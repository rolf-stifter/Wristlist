package be.pxl.elision.wristlist.Model.Profile;

public class Country {
    private String isocode;
    private Integer name;

    public String getIsocode() {
        return isocode;
    }

    public void setIsocode(String isocode) {
        this.isocode = isocode;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }
}