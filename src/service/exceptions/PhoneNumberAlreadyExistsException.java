package service.exceptions;

import model.MobileContact;

/**
 * @author Ntirintis John
 */
public class PhoneNumberAlreadyExistsException extends Exception {
    private final static long serialVersionUID = 1L;

    public PhoneNumberAlreadyExistsException(MobileContact mobileContact){
        super("Mobile contact with the number " + mobileContact.getPhoneNumber() + " already exists.");
    }
}
