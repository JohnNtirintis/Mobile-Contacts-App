package dao;

import model.MobileContact;

import java.util.List;

/**
 * This interface provides the structure for a DAO class to manage MobileContact objects.
 * @author Ntirintis John
 */
public interface IMobileContactDAO {
    /**
     * Inserts a MobileContact into the datastore.
     * @param mobileContact The contact to be inserted.
     * @return The inserted MobileContact.
     */
    MobileContact insert(MobileContact mobileContact);
    /**
     * Updates the MobileContact with the specified ID in the datastore.
     * @param id The ID of the MobileContact to be updated.
     * @param mobileContact The MobileContact with updated details.
     * @return The updated MobileContact.
     */
    MobileContact update(long id, MobileContact mobileContact);
    /**
     * Deletes the MobileContact with the specified ID from the datastore.
     * @param id The ID of the MobileContact to be deleted.
     */
    void delete(long id);
    /**
     * Retrieves the MobileContact with the specified ID from the datastore.
     * @param id The ID of the MobileContact to be retrieved.
     * @return The retrieved MobileContact.
     */
    MobileContact get(long id);
    /**
     * Retrieves all MobileContacts from the datastore.
     * @return A list of all MobileContacts.
     */
    List<MobileContact> getAll();
    /**
     * Retrieves the MobileContact with the specified phone number from the datastore.
     * @param phoneNumber The phone number of the MobileContact to be retrieved.
     * @return The retrieved MobileContact.
     */
    MobileContact get(String phoneNumber);
    /**
     * Deletes the MobileContact with the specified phone number from the datastore.
     * @param phoneNumber The phone number of the MobileContact to be deleted.
     */
    void delete(String phoneNumber);
    /**
     * Checks if a MobileContact with the specified phone number exists in the datastore.
     * @param phoneNumber The phone number to check.
     * @return True if a MobileContact with the specified phone number exists, false otherwise.
     */
    boolean phoneNumberExists(String phoneNumber);
    /**
     * Checks if a MobileContact with the specified user ID exists in the datastore.
     * @param id The user ID to check.
     * @return True if a MobileContact with the specified user ID exists, false otherwise.
     */
    boolean userIdExists(long id);


}
