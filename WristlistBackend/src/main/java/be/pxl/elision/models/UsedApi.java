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

    public UsedApi(String apiName, Date measured, String userId){
        this.apiName = apiName;
        this.measured = measured;
        this.userId = userId;

    }

    //PROPERTIES
    @Id
    private String id;
    private String apiName;
    private Date measured;
    private String userId;

    //GETTERS AND SETTERS

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApi_name() {
        return apiName;
    }

    public void setApi_name(String apiName) {
        this.apiName = apiName;
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
