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

    public AppUsage(Date timeUsed, Date measured, String userId){
        this.timeUsed = timeUsed;
        this.measured = measured;
        this.userId = userId;
    }

    //PROPERTIES
    @Id
    private String id;
    private Date timeUsed;
    private Date measured;
    private String userId;

    //GETTERS AND SETTERS
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTime_used() {
        return timeUsed;
    }

    public void setTime_used(Date time_used) {
        this.timeUsed = time_used;
    }

    public Date getMeasured() {
        return measured;
    }

    public void setMeasured(Date measured) {
        this.measured = measured;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
