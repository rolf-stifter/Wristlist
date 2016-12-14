package be.pxl.elision.wristlist.Model.Orders;

/**
 * Created by 11400081 on 9/12/2016.
 */

public class DummyProduct {
    private String name;
    private double price;
    private String date;
    private int stock;
    private String description;


    public DummyProduct() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) { this.stock = stock; }

    public String getdescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}