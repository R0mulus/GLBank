package glbank;

/**
 * Created by Joseph on 21.3.2017.
 */
public class Employee {
    private int idemp;
    private String firstname;
    private String lastname;
    private String email;
    private char position;

    public Employee(int idemp, String firstname, String lastname, String email, char position) {
        this.idemp = idemp;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.position = position;
    }

    public int getIdemp() {
        return idemp;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public char getPosition() {
        return position;
    }
}
