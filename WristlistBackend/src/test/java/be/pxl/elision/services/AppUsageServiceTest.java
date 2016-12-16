package be.pxl.elision.services;

import be.pxl.elision.models.AppUsage;
import be.pxl.elision.repositories.AppUsageRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;


/**
 * Created by 11308157 on 8/12/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class AppUsageServiceTest {

    private Date firstDate;
    private Date secondDate;
    private Date thirdDate;
    private Calendar cal;

    @Mock
    private AppUsageRepository repositoryMock;

    @InjectMocks
    private AppUsageService serviceMock;

    @Before
    public void init(){
        cal = Calendar.getInstance();

        firstDate = cal.getTime();
    }

    @Test
    public void testFindAll(){
        List<AppUsage> appUsages = new ArrayList<>();
        appUsages.add(new AppUsage(new Timestamp(12345), firstDate, "12345"));
        when(repositoryMock.findAll()).thenReturn(appUsages);

        Assert.assertSame(serviceMock.getAll(), appUsages);
    }

    @Test
    public void testFindAllBetweenDates(){
        List<AppUsage> appUsages = new ArrayList<>();
        appUsages.add(new AppUsage(new Timestamp(12345), firstDate, "12345"));
        cal.add(Calendar.MINUTE, -5);
        secondDate = cal.getTime();
        cal.add(Calendar.MINUTE, 10);
        thirdDate = cal.getTime();
        when(repositoryMock.findByMeasuredBetween(secondDate, thirdDate)).thenReturn(appUsages);

        Assert.assertSame(serviceMock.getBetweenDates(secondDate, thirdDate), appUsages);
    }

    @Test
    public void AddNew(){
        AppUsage appUsage = new AppUsage(new Timestamp(12345), firstDate, "12345");
        serviceMock.addNew(appUsage);
        Mockito.verify(repositoryMock).save(appUsage);
    }

    @Test
    public void deleteAll(){
        AppUsage appUsage = new AppUsage(new Timestamp(12345), firstDate, "12345");
        serviceMock.addNew(appUsage);
        serviceMock.deleteAll();
        Mockito.verify(repositoryMock).deleteAll();
    }

    @After
    public void finalize(){
        repositoryMock.deleteAll();
    }


}
