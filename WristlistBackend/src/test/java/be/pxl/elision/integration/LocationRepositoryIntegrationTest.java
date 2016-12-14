package be.pxl.elision.integration;

import be.pxl.elision.models.Location;
import be.pxl.elision.repositories.LocationRepository;
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
public class LocationRepositoryIntegrationTest {

    @Autowired
    private LocationRepository repository;

    private Calendar cal;

    private Location location;

    @Before
    public void setUp() throws Exception {
        cal = Calendar.getInstance();
        location = new Location(2.2, 2.2, 2.2, cal.getTime());
        repository.save(location);
    }

    @Test
    public void canAddLocation() throws Exception{
        Location location2 = new Location(2.2, 2.2, 2.2, cal.getTime());
        repository.save(location2);
        List<Location> locationList = repository.findAll();

        Assert.assertFalse(locationList.get(1).getId().equals(locationList.get(0).getId()));
    }

    @Test
    public void lastAdded() throws Exception{
        cal.add(Calendar.MINUTE, 1);
        Location location2 = new Location(2.2, 2.2, 2.2, cal.getTime());
        repository.save(location2);
        List<Location> locationList = repository.findAll();
        String id = locationList.get(1).getId();
        Location location = repository.findTop1ByOrderByMeasuredDesc();
        Assert.assertEquals(id, location.getId());
    }

    @After
    public void finalize(){
        repository.deleteAll();
    }

}
