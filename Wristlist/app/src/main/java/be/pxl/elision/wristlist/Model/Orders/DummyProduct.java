package be.pxl.elision.wristlist.Model.Orders;

/**
 * Created by 11400081 on 9/12/2016.
 */

public class DummyProduct {
    private String naam;
    private String prijs;
    private String datum;
    private int stock;
    private String omschrijving;


    public DummyProduct() {
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getPrijs() {
        return prijs;
    }

    public void setPrijs(String prijs) {
        this.prijs = prijs;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }
}