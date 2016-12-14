package be.pxl.elision.integration;

import be.pxl.elision.models.AppUsage;
import be.pxl.elision.repositories.AppUsageRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

/**
 * Created by 11308157 on 9/12/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AppUsageRepositoryIntegrationTest {

    @Autowired
    private AppUsageRepository repository;

    private Calendar cal;

    private AppUsage appUsage;

    @Before
    public void setUp() throws Exception {
        cal = Calendar.getInstance();
        appUsage = new AppUsage(new Timestamp(12345), cal.getTime());
        repository.save(appUsage);
    }

    @Test
    public void canAddAppUsage() throws Exception{
        AppUsage appUsage2 = new AppUsage(new Timestamp(12345), cal.getTime());
        repository.save(appUsage2);
        List<AppUsage> appUsageList = repository.findAll();
        Assert.assertFalse(appUsageList.get(1).getId().equals(appUsageList.get(0).getId()));
    }

    @Test
    public void lastAdded() throws Exception{
        cal.add(Calendar.MINUTE, 1);
        AppUsage appUsage2 = new AppUsage(new Timestamp(12345), cal.getTime());
        repository.save(appUsage2);
        List<AppUsage> appUsageList = repository.findAll();
        String id = appUsageList.get(1).getId();
        AppUsage appUsage = repository.findTop1ByOrderByMeasuredDesc();
        Assert.assertEquals(id, appUsage.getId());
    }

    @After
    public void finalize(){
        repository.deleteAll();
    }

}
