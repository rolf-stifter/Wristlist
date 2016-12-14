package be.pxl.elision.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by 11308157 on 8/12/2016.
 */
@Document(collection = "app_usages")
@Transactional
public class AppUsage {

    //CONSTRUCTORS
    public AppUsage(){}

    public AppUsage(Date time_used, Date measured){
        this.time_used = time_used;
        this.measured = measured;
    }

    //PROPERTIES
    @Id
    private String id;
    private Date time_used;
    private Date measured;

    //GETTERS AND SETTERS
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTime_used() {
        return time_used;
    }

    public void setTime_used(Date time_used) {
        this.time_used = time_used;
    }

    public Date getMeasured() {
        return measured;
    }

    public void setMeasured(Date measured) {
        this.measured = measured;
    }
}
