package Models;

public class ChoirPlayer {

    private String id;
    private String lastName;
    private String firstName;
    private String section;
    private String sectionPrincipal;

    /**Constructor*/
    public ChoirPlayer(String id, String lastName, String firstName, String section, String sectionPrincipal) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.section = section;
        this.sectionPrincipal = sectionPrincipal;
    }

    /**Methods*/
    public String getId() { return this.id; }

    public String getLastName() { return this.lastName; }

    public String getFirstName() { return this.firstName; }

    public String getSection() { return this.section; }

    public String getSectionPrincipal() { return this.sectionPrincipal; }

    @Override
    public String toString() {
        return "Choir player: { id = " + this.id + ", lastName = " + this.lastName + ", firstName = " + this.firstName +
                ", section = " + this.section + ", sectionPrincipal = " + this.sectionPrincipal + " }";
    }
}
