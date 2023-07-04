package dto;

import model.MobileContact;

/**
 * The MobileContactDTO class is a data transfer object (DTO) that represents a mobile contact.
 * It holds the ID, user details (another DTO object), and the phone number of the contact.
 * @author Ntirintis John
 */
public class MobileContactDTO {
    private long id;
    private UserDetailsDTO userDetails;
    private String phoneNumber;

    public MobileContactDTO() {}

    public MobileContactDTO(long id, UserDetailsDTO userDetails, String phoneNumber) {
        this.id = id;
        this.userDetails = userDetails;
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserDetailsDTO getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetailsDTO userDetails) {
        this.userDetails = userDetails;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
