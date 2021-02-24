package Models;

public class Ticket {

    private String id;
    private String user;
    private String concert;

    /**Constructor*/
    public Ticket(String id, String user, String concert) {
        this.id = id;
        this.user = user;
        this.concert = concert;
    }

    /**Methods*/
    public String getId() { return this.id; }

    public String getUser() { return this.user; }

    public String getConcert() { return this.concert; }

    @Override
    public String toString() {
        return "Ticket: { id = " + this.id + ", user = " + this.user + ", concert = " + this.concert + " }";
    }
}
