package Models;

public class Conductor {

    private String id;
    private String lastName;
    private String firstName;
    private String info;

    /**Constructor*/
    public Conductor(String id, String lastName, String firstName, String info) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.info = info;
    }

    /**Methods*/
    public String getId() { return this.id; }

    public String getLastName() { return this.lastName; }

    public String getFirstName() { return this.firstName; }

    public String getInfo() { return this.info; }

    @Override
    public String toString() {
        return "Counductor: { id = " + this.id + ", lastName = " + this.lastName + ", firstName = " + this.firstName +
                ", info = " + this.info + " }";
    }
}
