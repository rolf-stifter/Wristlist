package be.pxl.elision.integration;

import be.pxl.elision.models.Notification;
import be.pxl.elision.models.UsedApi;
import be.pxl.elision.repositories.NotificationRepository;
import be.pxl.elision.repositories.UsedApiRepository;
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
public class UsedApiRepositoryIntegrationTest {
    @Autowired
    private UsedApiRepository repository;

    private Calendar cal;

    private UsedApi usedApi;

    @Before
    public void setUp() throws Exception {
        cal = Calendar.getInstance();
        usedApi = new UsedApi("TEST", cal.getTime(), "12345");
        repository.save(usedApi);
    }

    @Test
    public void canAddLocation() throws Exception{
        UsedApi usedApi = new UsedApi("TEST", cal.getTime(), "12345");
        repository.save(usedApi);
        List<UsedApi> usedApiList = repository.findAll();

        Assert.assertFalse(usedApiList.get(1).getId().equals(usedApiList.get(0).getId()));
    }

    @Test
    public void lastAdded() throws Exception{
        cal.add(Calendar.MINUTE, 1);
        UsedApi usedApi2 = new UsedApi("TEST", cal.getTime(), "12345");
        repository.save(usedApi2);
        List<UsedApi> notificationList = repository.findAll();
        String id = notificationList.get(1).getId();
        UsedApi usedApi = repository.findTop1ByOrderByMeasuredDesc();
        Assert.assertEquals(id, usedApi.getId());
    }

    @After
    public void finalize(){
        repository.deleteAll();
    }
}
