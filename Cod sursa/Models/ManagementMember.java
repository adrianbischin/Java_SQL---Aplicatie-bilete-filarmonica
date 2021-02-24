package Models;

public class ManagementMember {

    private String id;
    private String lastName;
    private String firstName;
    private String position;

    /**Constructor*/
    public ManagementMember(String id, String lastName, String firstName, String position) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.position = position;
    }

    /**Methods*/
    public String getId() { return this.id; }

    public String getLastName() { return this.lastName; }

    public String getFirstName() { return this.firstName; }

    public String getPosition() { return this.position; }

    @Override
    public String toString() {
        return "Management Member: { id = " + this.id + ", lastName = " + this.lastName + ", firstName = " +
                this.firstName + ", position = " + this.position + " }";
    }
}
