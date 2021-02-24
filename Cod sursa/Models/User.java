package Models;

public class User {

    private String id;
    private String lastName;
    private String firstName;
    private String userName;
    private String password;
    private String seasonTicket;

    /**Constructor*/
    public User(String id, String lastName, String firstName, String userName, String password, String seasonTicket) {
        this.id = id;
        this.firstName = lastName;
        this.lastName = firstName;
        this.userName = userName;
        this.password = password;
        this.seasonTicket = seasonTicket;
    }

    /**Methods*/
    public String getId() {return this.id;}

    public String getLastName() { return this.lastName; }

    public String getFirstName() { return this.firstName; }

    public String getUsername() { return this.userName; }

    public String getPassword() { return this.firstName; }

    public String getSeasonTicket() { return this.seasonTicket; }

    @Override
    public String toString() {
        return "User: { id = " + this.id + ", lastName = " + this.lastName + ", firstName = " + this.firstName +
                ", userName = " + this.userName + ", password = " + this.password + ", seasonTicket = " +
                this.seasonTicket + " }";
    }
}
