package be.pxl.elision.model;
import be.pxl.elision.models.UsedApi;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;

/**
 * Created by 11308157 on 9/12/2016.
 */
public class UsedApiTest {

    private UsedApi usedApi;

    @Before
    public void init(){
        usedApi = new UsedApi("TEST", new Timestamp(12345), "12345");
    }

    @Test
    public void getCategory(){
        Assert.assertEquals(usedApi.getApi_name(), "TEST");
    }

    @Test
    public void setCategory(){
        Assert.assertEquals(usedApi.getApi_name(), "TEST");
        usedApi.setApi_name("TSET");
        Assert.assertEquals(usedApi.getApi_name(), "TSET");

    }
}
