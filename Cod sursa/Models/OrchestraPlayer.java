package Models;

public class OrchestraPlayer {

    private String id;
    private String lastName;
    private String firstName;
    private String section;
    private String sectionPrincipal;
    private String concertmaster;

    /**Constructor*/
    public OrchestraPlayer(String id, String lastName, String firstName, String section, String sectionPrincipal, String concertmaster) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.section = section;
        this.sectionPrincipal = sectionPrincipal;
        this.concertmaster = concertmaster;
    }

    /**Methods*/
    public String getId() { return this.id; }

    public String getLastName() { return this.lastName; }

    public String getFirstName() { return this.firstName; }

    public String getSection() { return this.section; }

    public String getSectionPrincipal() { return this.sectionPrincipal; }

    public String getConcertmaster() { return this.concertmaster; }

    @Override
    public String toString() {
        return "Orchersta player: { id = " + this.id + ", lastName = " + this.lastName + ", firstName = " +
                this.firstName + ", section = " + this.section + ", sectionPrincipal = " + this.sectionPrincipal +
                ", concertmaster = " + this.concertmaster + " }";
    }
}
