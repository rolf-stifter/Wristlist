package be.pxl.elision.wristlist.Model.Profile;

public class Address {
    private String id;
    private String title;
    private String titleCode;
    private String firstName;
    private String lastName;
    private String companyName;
    private String line1;
    private String line2;
    private String town;
    private Region region;
    private String postalCode;
    private String phone;
    private String email;
    private Country country;
    private Boolean shippingAddress;
    private Boolean visibleInAddressBook;
    private String formattedAddress;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleCode() {
        return titleCode;
    }

    public void setTitleCode(String titleCode) {
        this.titleCode = titleCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Boolean getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Boolean shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Boolean getVisibleInAddressBook() {
        return visibleInAddressBook;
    }

    public void setVisibleInAddressBook(Boolean visibleInAddressBook) {
        this.visibleInAddressBook = visibleInAddressBook;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }
}
