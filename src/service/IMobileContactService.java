package service;

import dto.MobileContactDTO;
import model.MobileContact;
import service.exceptions.MobileContactNotFoundException;
import service.exceptions.PhoneNumberAlreadyExistsException;
import service.exceptions.UserAlreadyExistsException;

import java.util.List;

/**
 * Interface for MobileContact services, outlining necessary methods for managing mobile contacts.
 * These methods include insert, update, delete, get and getAll for mobile contacts,
 * and checks for existence of phone number and user Id.
 *
 * @author Ntirintis John
 */
public interface IMobileContactService {
    MobileContact insertMobileContact(MobileContactDTO contactDTO)
            throws PhoneNumberAlreadyExistsException, UserAlreadyExistsException;

    MobileContact updateMobileContact(long id, MobileContactDTO contactDTO)
            throws MobileContactNotFoundException, PhoneNumberAlreadyExistsException, UserAlreadyExistsException;

    void deleteMobileContact(String phoneNumber) throws MobileContactNotFoundException;

    void deleteMobileContact(long id) throws MobileContactNotFoundException;

    MobileContact getMobileContact(String phoneNumber) throws MobileContactNotFoundException;

    MobileContact getMobileContact(long id) throws MobileContactNotFoundException;

    List<MobileContact> getAllMobileContacts();

}
