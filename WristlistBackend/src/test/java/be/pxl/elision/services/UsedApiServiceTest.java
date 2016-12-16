package be.pxl.elision.services;

import be.pxl.elision.models.Notification;
import be.pxl.elision.models.UsedApi;
import be.pxl.elision.repositories.NotificationRepository;
import be.pxl.elision.repositories.UsedApiRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Created by 11308157 on 9/12/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class UsedApiServiceTest {

    private Date firstDate;
    private Date secondDate;
    private Date thirdDate;
    private Calendar cal;

    @Mock
    UsedApiRepository repositoryMock;

    @InjectMocks
    UsedApiService serviceMock;

    @Before
    public void init(){
        cal = Calendar.getInstance();

        firstDate = cal.getTime();
    }


    @Test
    public void testFindAll(){
        List<UsedApi> usedApis = new ArrayList<>();
        usedApis.add(new UsedApi("TEST", firstDate, "12345"));
        when(repositoryMock.findAll()).thenReturn(usedApis);

        Assert.assertSame(serviceMock.getAll(), usedApis);
    }


    @Test
    public void testFindAllBetweenDates(){
        List<UsedApi> usedApis = new ArrayList<>();
        usedApis.add(new UsedApi("TEST", firstDate, "12345"));
        cal.add(Calendar.MINUTE, -5);
        secondDate = cal.getTime();
        cal.add(Calendar.MINUTE, 10);
        thirdDate = cal.getTime();
        when(repositoryMock.findByMeasuredBetween(secondDate, thirdDate)).thenReturn(usedApis);

        Assert.assertSame(serviceMock.getBetweenDates(secondDate, thirdDate), usedApis);
    }

    @Test
    public void AddNew(){
        UsedApi usedApi = new UsedApi("TEST", firstDate, "12345");
        serviceMock.addNew(usedApi);
        Mockito.verify(repositoryMock).save(usedApi);
    }

    @Test
    public void deleteAll(){
        UsedApi usedApi = new UsedApi("TEST", firstDate, "12345");
        serviceMock.addNew(usedApi);
        serviceMock.deleteAll();
        Mockito.verify(repositoryMock).deleteAll();
    }

    @After
    public void finalize(){
        repositoryMock.deleteAll();
    }




}
