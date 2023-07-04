package service.exceptions;

import model.MobileContact;

/**
 * @author Ntirintis John
 */
public class MobileContactNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public MobileContactNotFoundException(MobileContact mobileContact){
        super("The mobile contact with the number " + mobileContact.getPhoneNumber() + " was not found.");
    }

    public MobileContactNotFoundException(String phoneNumber){
        super("The mobile contact with the number " + phoneNumber + " was not found.");
    }

    public MobileContactNotFoundException(long id){
        super("The mobile contact with the id " + id + " was not found.");
    }
}
