package dto;

/**
 * The UserDetailsDTO class is a data transfer object (DTO) that represents the user details.
 * It holds the ID, first name, and last name of the user.
 * @author Ntirintis John
 */
public class UserDetailsDTO {
    private long id;
    private String firstName;
    private String lastName;

    public UserDetailsDTO() {}

    public UserDetailsDTO(long id, String firstname, String lastname) {
        this.id = id;
        this.firstName = firstname;
        this.lastName = lastname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
