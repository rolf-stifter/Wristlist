package be.pxl.elision.services;

import be.pxl.elision.models.Location;
import be.pxl.elision.models.Notification;
import be.pxl.elision.repositories.LocationRepository;
import be.pxl.elision.repositories.NotificationRepository;
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
public class NotificationServiceTest {

    private Date firstDate;
    private Date secondDate;
    private Date thirdDate;
    private Calendar cal;

    @Mock
    NotificationRepository repositoryMock;

    @InjectMocks
    NotificationService serviceMock;

    @Before
    public void init(){
        cal = Calendar.getInstance();

        firstDate = cal.getTime();
    }


    @Test
    public void testFindAll(){
        List<Notification> notifications = new ArrayList<>();
        notifications.add(new Notification("TEST", firstDate));
        when(repositoryMock.findAll()).thenReturn(notifications);

        Assert.assertSame(serviceMock.getAll(), notifications);
    }


    @Test
    public void testFindAllBetweenDates(){
        List<Notification> notifications = new ArrayList<>();
        notifications.add(new Notification("TEST", firstDate));
        cal.add(Calendar.MINUTE, -5);
        secondDate = cal.getTime();
        cal.add(Calendar.MINUTE, 10);
        thirdDate = cal.getTime();
        when(repositoryMock.findByMeasuredBetween(secondDate, thirdDate)).thenReturn(notifications);

        Assert.assertSame(serviceMock.getBetweenDates(secondDate, thirdDate), notifications);
    }

    @Test
    public void AddNew(){
        Notification notification = new Notification("TEST", firstDate);
        serviceMock.addNew(notification);
        Mockito.verify(repositoryMock).save(notification);
    }

    @Test
    public void deleteAll(){
        Notification notification = new Notification("TEST", firstDate);
        serviceMock.addNew(notification);
        serviceMock.deleteAll();
        Mockito.verify(repositoryMock).deleteAll();
    }

    @After
    public void finalize(){
        repositoryMock.deleteAll();
    }



}
