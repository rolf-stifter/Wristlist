package be.pxl.elision.wristlist.Model.Orders;

/**
 * Created by 11400081 on 9/12/2016.
 */

public class DummyProduct {
    private String name;
    private String price;
    private String datum;
    private int stock;
    private String description;


    public DummyProduct() {
    }

    public String getName() {
        return name;
    }

    public void setName(String naam) {
        this.name = naam;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return datum;
    }

    public void setDate(String datum) {
        this.datum = datum;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getdescription() {
        return description;
    }

    public void setDescription(String omschrijving) {
        this.description = omschrijving;
    }
}