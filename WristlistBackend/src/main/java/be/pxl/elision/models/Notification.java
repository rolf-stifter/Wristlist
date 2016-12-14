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

    public Notification(String category_name, Date measured){
        this.category_name = category_name;
        this. measured = measured;
    }

    //PROPERTIES
    @Id
    private String id;
    private String category_name;
    private Date measured;

    //GETTERS AND SETTERS
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public Date getMeasured() {
        return measured;
    }

    public void setMeasured(Date measured) {
        this.measured = measured;
    }
}
