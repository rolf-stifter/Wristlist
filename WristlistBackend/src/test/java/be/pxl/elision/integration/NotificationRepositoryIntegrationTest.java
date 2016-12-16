package be.pxl.elision.integration;

import be.pxl.elision.models.Location;
import be.pxl.elision.models.Notification;
import be.pxl.elision.repositories.LocationRepository;
import be.pxl.elision.repositories.NotificationRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.List;

/**
 * Created by 11308157 on 9/12/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class NotificationRepositoryIntegrationTest {
    @Autowired
    private NotificationRepository repository;

    private Calendar cal;

    private Notification notification;

    @Before
    public void setUp() throws Exception {
        cal = Calendar.getInstance();
        notification = new Notification("TEST", cal.getTime(), "12345");
        repository.save(notification);
    }

    @Test
    public void canAddLocation() throws Exception{
        Notification notification2 = new Notification("TEST", cal.getTime(), "12345");
        repository.save(notification2);
        List<Notification> notificationList = repository.findAll();

        Assert.assertFalse(notificationList.get(1).getId().equals(notificationList.get(0).getId()));
    }

    @Test
    public void lastAdded() throws Exception{
        cal.add(Calendar.MINUTE, 1);
        Notification notification2 = new Notification("TEST", cal.getTime(), "12345");
        repository.save(notification2);
        List<Notification> notificationList = repository.findAll();
        String id = notificationList.get(1).getId();
        Notification notification = repository.findTop1ByOrderByMeasuredDesc();
        Assert.assertEquals(id, notification.getId());
    }

    @After
    public void finalize(){
        repository.deleteAll();
    }
}
