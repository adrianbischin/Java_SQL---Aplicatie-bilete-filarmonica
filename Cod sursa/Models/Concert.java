package Models;

public class Concert {

    private String id;
    private String dateTime;
    private String location;
    private String details;
    private String price;
    private String availableSits;

    /**Constructor*/
    public Concert(String id, String dateTime, String location, String details, String price, String availableSits) {
        this.id = id;
        this.dateTime = dateTime;
        this.location = location;
        this.details = details;
        this.price = price;
        this.availableSits = availableSits;
    }

    /**Methods*/
    public String getId() { return this.id; }

    public String getDateTime() { return this.dateTime; }

    public String getLocation() { return this.location; }

    public String getDetails() { return this.details; }

    public String getPrice() { return this.price; }

    public String getAvailableSits() { return this.availableSits; }

    @Override
    public String toString() {
        return "Concert: { id = " + this.id + ", dateTime = " + this.dateTime + ", location = " + this.location +
                ", details = " + this.details + ", " + this.details + ", price = " + this.price + ", availableSits = " +
                this.availableSits + " }";
    }


}
