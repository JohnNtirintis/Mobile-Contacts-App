package model;

/**
 * UserDetails is a class that extends AbstractEntity and represents user details in the system.
 * It includes the first name and last name of the user.
 * @author Ntirintis John
 */
public class UserDetails extends AbstractEntity{
    private String firstName;
    private String lastName;

    // Calls super implicitly
    public UserDetails() {}

    public UserDetails(long id, String firstName, String lastName) {
        setId(id);
        this.firstName = firstName;
        this.lastName = lastName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDetails that = (UserDetails) o;

        if (!getFirstName().equals(that.getFirstName())) return false;
        return getLastName().equals(that.getLastName());
    }

    @Override
    public int hashCode() {
        int result = getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
