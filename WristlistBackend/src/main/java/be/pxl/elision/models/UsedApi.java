package be.pxl.elision.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Id;
import java.util.Date;

/**
 * Created by 11308157 on 8/12/2016.
 */
@Document(collection = "used_apis")
@Transactional
public class UsedApi {

    //CONSTRUCTORS
    public UsedApi(){}

    public UsedApi(String api_name, Date measured){
        this.api_name = api_name;
        this.measured = measured;
    }

    //PROPERTIES
    @Id
    private String id;
    private String api_name;
    private Date measured;

    //GETTERS AND SETTERS

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApi_name() {
        return api_name;
    }

    public void setApi_name(String api_name) {
        this.api_name = api_name;
    }

    public Date getMeasured() {
        return measured;
    }

    public void setMeasured(Date measured) {
        this.measured = measured;
    }
}
