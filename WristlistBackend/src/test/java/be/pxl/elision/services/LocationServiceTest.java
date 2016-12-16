package be.pxl.elision.services;

import be.pxl.elision.models.AppUsage;
import be.pxl.elision.models.Location;
import be.pxl.elision.repositories.LocationRepository;
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
public class LocationServiceTest {

    private Date firstDate;
    private Date secondDate;
    private Date thirdDate;
    private Calendar cal;

    @Mock
    LocationRepository repositoryMock;

    @InjectMocks
    LocationService serviceMock;

    @Before
    public void init(){
        cal = Calendar.getInstance();

        firstDate = cal.getTime();
    }

    @Test
    public void testFindAll(){
        List<Location> locations = new ArrayList<>();
        locations.add(new Location(2.2, 2.2, 2.2, firstDate, "12345"));
        when(repositoryMock.findAll()).thenReturn(locations);

        Assert.assertSame(serviceMock.getAll(), locations);
    }

    @Test
    public void testFindAllBetweenDates(){
        List<Location> locations = new ArrayList<>();
        locations.add(new Location(2.2, 2.2, 2.2, firstDate, "12345"));
        cal.add(Calendar.MINUTE, -5);
        secondDate = cal.getTime();
        cal.add(Calendar.MINUTE, 10);
        thirdDate = cal.getTime();
        when(repositoryMock.findByMeasuredBetween(secondDate, thirdDate)).thenReturn(locations);

        Assert.assertSame(serviceMock.getBetweenDates(secondDate, thirdDate), locations);
    }

    @Test
    public void AddNew(){
        Location location = new Location(2.2, 2.2, 2.2, firstDate, "12345");
        serviceMock.addNew(location);
        Mockito.verify(repositoryMock).save(location);
    }

    @Test
    public void deleteAll(){
        Location location = new Location(2.2, 2.2, 2.2, firstDate, "12345");
        serviceMock.addNew(location);
        serviceMock.deleteAll();
        Mockito.verify(repositoryMock).deleteAll();
    }


    @After
    public void finalize(){
        repositoryMock.deleteAll();
    }




}
