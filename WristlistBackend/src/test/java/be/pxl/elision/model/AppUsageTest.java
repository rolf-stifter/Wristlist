package be.pxl.elision.model;

import be.pxl.elision.models.AppUsage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by 11308157 on 9/12/2016.
 */
public class AppUsageTest {

    private AppUsage appUsage;

    private Calendar cal;

    private Date now;

    @Before
    public void init(){
        cal = Calendar.getInstance();
        now = cal.getTime();

        appUsage = new AppUsage(new Timestamp(12345), now);

    }

    @Test
    public void getMeasured(){
        Assert.assertTrue(appUsage.getMeasured().getTime() - now.getTime() == 0);
    }

    @Test
    public void setMeasured(){
        Assert.assertTrue(appUsage.getMeasured().getTime() - now.getTime() == 0);
        cal.add(Calendar.MINUTE, 10);
        now = cal.getTime();
        appUsage.setMeasured(now);
        Assert.assertTrue(appUsage.getMeasured().getTime() - now.getTime() == 0);

    }

    @Test
    public void getTimeUsed(){
        Assert.assertTrue(appUsage.getTime_used().getTime() - new Timestamp(12345).getTime() == 0);
    }

    @Test
    public void setTimeUsed(){
        Assert.assertTrue(appUsage.getTime_used().getTime() - new Timestamp(12345).getTime() == 0);
        appUsage.setTime_used(new Timestamp(12346));
        Assert.assertTrue(appUsage.getTime_used().getTime() - new Timestamp(12346).getTime() == 0);
    }

}
