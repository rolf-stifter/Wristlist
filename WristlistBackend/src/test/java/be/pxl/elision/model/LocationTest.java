package be.pxl.elision.model;

import be.pxl.elision.models.Location;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;

/**
 * Created by 11308157 on 9/12/2016.
 */
public class LocationTest {
    private Location location;

    @Before
    public void init(){
        location = new Location(2.2,2.2,2.2,new Timestamp(12345));
    }

    @Test
    public void getCoordinate(){
        Assert.assertTrue(location.getX_coordinate() == 2.2);
        Assert.assertTrue(location.getY_coordinate() == 2.2);
        Assert.assertTrue(location.getZ_coordinate() == 2.2);
    }

    @Test
    public void setCoordinate(){
        Assert.assertTrue(location.getX_coordinate() == 2.2);
        location.setX_coordinate(2.3);
        Assert.assertTrue(location.getX_coordinate() == 2.3);
    }
}
