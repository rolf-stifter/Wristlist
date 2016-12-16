package be.pxl.elision.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Id;
import java.util.Date;

/**
 * Created by 11308157 on 8/12/2016.
 */
@Document(collection = "locations")
@Transactional
public class Location {

    //CONSTRUCTORS
    public Location(){}

    public Location(double x_coordinate, double y_coordinate, double z_coordinate, Date measured, String userId){
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
        this.z_coordinate = z_coordinate;
        this.measured = measured;
        this.userId = userId;

    }

    //PROPERTIES
    @Id
    private String id;
    private double x_coordinate;
    private double y_coordinate;
    private double z_coordinate;
    private Date measured;
    private String userId;

    //GETTERS AND SETTERS
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getX_coordinate() {
        return x_coordinate;
    }

    public void setX_coordinate(double x_coordinate) {
        this.x_coordinate = x_coordinate;
    }

    public double getY_coordinate() {
        return y_coordinate;
    }

    public void setY_coordinate(double y_coordinate) {
        this.y_coordinate = y_coordinate;
    }

    public double getZ_coordinate() {
        return z_coordinate;
    }

    public void setZ_coordinate(double z_coordinate) {
        this.z_coordinate = z_coordinate;
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
