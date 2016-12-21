package be.pxl.elision.wristlist.Model.Orders;

import java.util.List;

import be.pxl.elision.wristlist.Model.Profile.Address;

/**
 * Created by 11400081 on 9/12/2016.
 */

public class DummyOrder {
    private String name;
    private String status;
    private String date;
    private Double price;
    private List<DummyProduct> orders;
    private Address address;


    public DummyOrder() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<DummyProduct> getOrders() {
        return orders;
    }

    public void setOrders(List<DummyProduct> orders) {
        this.orders = orders;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
