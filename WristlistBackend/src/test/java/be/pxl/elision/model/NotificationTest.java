package be.pxl.elision.model;

import be.pxl.elision.models.Notification;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;

/**
 * Created by 11308157 on 9/12/2016.
 */
public class NotificationTest {

    private Notification notification;

    @Before
    public void init(){
        notification = new Notification("TEST", new Timestamp(12345), "12345");
    }

    @Test
    public void getCategory(){
        Assert.assertEquals(notification.getCategory_name(), "TEST");
    }

    @Test
    public void setCategory(){
        Assert.assertEquals(notification.getCategory_name(), "TEST");
        notification.setCategory_name("TSET");
        Assert.assertEquals(notification.getCategory_name(), "TSET");

    }
}
