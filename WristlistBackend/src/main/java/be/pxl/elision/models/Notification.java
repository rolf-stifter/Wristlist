package be.pxl.elision.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Id;
import java.util.Date;

/**
 * Created by 11308157 on 8/12/2016.
 */
@Document(collection = "notifications")
@Transactional
public class Notification {

    //CONSTRUCTORS
    public Notification(){}

    public Notification(String categoryName, Date measured, String userId){
        this.categoryName = categoryName;
        this. measured = measured;
        this.userId = userId;

    }

    //PROPERTIES
    @Id
    private String id;
    private String categoryName;
    private Date measured;
    private String userId;

    //GETTERS AND SETTERS
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory_name() {
        return categoryName;
    }

    public void setCategory_name(String categoryName) {
        this.categoryName = categoryName;
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
