package model;

/**
 * MobileContact is a class that extends AbstractEntity and represents a mobile contact in the system.
 * It includes user details and a phone number.
 * @author Ntirintis John
 */
public class MobileContact extends AbstractEntity{
    private UserDetails userDetails;
    private String phoneNumber;

    public MobileContact() {}

    public MobileContact(long id, UserDetails userDetails, String phoneNumber) {
        setId(id);
        this.userDetails = userDetails;
        this.phoneNumber = phoneNumber;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MobileContact that = (MobileContact) o;

        if (!getUserDetails().equals(that.getUserDetails())) return false;
        return getPhoneNumber().equals(that.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        int result = getUserDetails().hashCode();
        result = 31 * result + getPhoneNumber().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "MobileContact{" +
                "userDetails=" + userDetails +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
