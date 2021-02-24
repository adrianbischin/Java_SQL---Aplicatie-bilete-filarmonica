package Models;

public class Administrator {

    private String id;
    private String lastName;
    private String firstName;
    private String userName;
    private String password;

    /**Constructor*/
    public Administrator(String id, String lastName, String firstName, String userName, String password) {
        this.id = id;
        this.firstName = lastName;
        this.lastName = firstName;
        this.userName = userName;
        this.password = password;
    }

    /**Methods*/
    public String getId() {return this.id;}

    public String getLastName() { return this.lastName; }

    public String getFirstName() { return this.firstName; }

    public String getUsername() { return this.userName; }

    public String getPassword() { return this.firstName; }

    @Override
    public String toString() {
        return "Administrator: { id = " + this.id + ", lastName = " + this.lastName + ", firstName = " + this.firstName +
                ", userName = " + this.userName + ", password = " + this.password + " }";
    }
}
