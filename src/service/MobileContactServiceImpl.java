package service;

import dao.IMobileContactDAO;
import dto.MobileContactDTO;
import dto.UserDetailsDTO;
import model.MobileContact;
import model.UserDetails;
import service.exceptions.MobileContactNotFoundException;
import service.exceptions.PhoneNumberAlreadyExistsException;
import service.exceptions.UserAlreadyExistsException;

import java.util.List;

/**
 * Service implementation for MobileContact. It communicates with DAO layer
 * and handles the business logic related to mobile contacts.
 * It implements methods for inserting, updating, deleting and retrieving mobile contacts,
 * and checks for existence of phone number and user Id.
 *
 * @author Ntirintis John
 */
public class MobileContactServiceImpl implements IMobileContactService{

    private final IMobileContactDAO dao;

    public MobileContactServiceImpl(IMobileContactDAO dao) {
        this.dao = dao;
    }

    @Override
    public MobileContact insertMobileContact(MobileContactDTO mobileContactDTO)
            throws PhoneNumberAlreadyExistsException, UserAlreadyExistsException {

        MobileContact mobileContact = null;

        try {
            mobileContact = new MobileContact();

            if (dao.phoneNumberExists(mobileContactDTO.getPhoneNumber())) {
                throw new PhoneNumberAlreadyExistsException(mobileContact);
            }

            if (dao.userIdExists(mobileContactDTO.getId())) {
                throw new UserAlreadyExistsException(mobileContact);
            }

            mapMobileContact(mobileContact, mobileContactDTO);

            mobileContact = dao.insert(mobileContact);

        } catch (PhoneNumberAlreadyExistsException | UserAlreadyExistsException exception) {
            exception.printStackTrace();
            throw exception;
        }

        return mobileContact;
    }

    @Override
    public MobileContact updateMobileContact(long id, MobileContactDTO mobileContactDTO)
            throws MobileContactNotFoundException, PhoneNumberAlreadyExistsException {

        MobileContact mobileContact = null;

        try {
            mobileContact = new MobileContact();
            mapMobileContact(mobileContact, mobileContactDTO);

            if (id != mobileContactDTO.getId() || !dao.userIdExists(id)) {
                throw new MobileContactNotFoundException(id);
            }

            if (dao.phoneNumberExists(mobileContactDTO.getPhoneNumber())) {
                if(!dao.get(mobileContactDTO.getId()).equals((dao.get(mobileContactDTO.getPhoneNumber())))) {
                    throw new PhoneNumberAlreadyExistsException(mobileContact);
                }
            }

            mobileContact = dao.update(id, mobileContact);

        } catch (PhoneNumberAlreadyExistsException e) {
            e.printStackTrace();
            throw e;
        }

        return mobileContact;
    }

    @Override
    public void deleteMobileContact(String phoneNumber) throws MobileContactNotFoundException {

        MobileContact mobileContact;
        try {
            mobileContact = new MobileContact();

            if(!dao.phoneNumberExists(phoneNumber)){
                throw new MobileContactNotFoundException(mobileContact);
            }

            dao.delete(phoneNumber);

        } catch (MobileContactNotFoundException e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteMobileContact(long id) throws MobileContactNotFoundException {

        MobileContact mobileContact;
        try {
            mobileContact = new MobileContact();

            if(!dao.userIdExists(id)){
                throw new MobileContactNotFoundException(mobileContact);
            }

            dao.delete(id);

        } catch (MobileContactNotFoundException e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public MobileContact getMobileContact(String phoneNumber) throws MobileContactNotFoundException {
        MobileContact mobileContact;

        try {
            mobileContact = dao.get(phoneNumber);
            if(mobileContact == null) {
                throw new MobileContactNotFoundException(phoneNumber);
            }

            return mobileContact;
        } catch (MobileContactNotFoundException e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public MobileContact getMobileContact(long id) throws MobileContactNotFoundException {
        MobileContact mobileContact;
        try {
            mobileContact = dao.get(id);
            if(mobileContact == null){
                throw new MobileContactNotFoundException(id);
            }

            return mobileContact;
        } catch (MobileContactNotFoundException e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<MobileContact> getAllMobileContacts() {
        return dao.getAll();
    }

    private void mapMobileContact(MobileContact mobileContact, MobileContactDTO mobileContactDTO) {
        mobileContact.setId(mobileContactDTO.getId());
        mobileContact.setPhoneNumber((mobileContactDTO.getPhoneNumber()));

        UserDetails userDetails = new UserDetails();
        mapUserDetails(userDetails, mobileContactDTO.getUserDetails());
        mobileContact.setUserDetails(userDetails);
    }

    private void mapUserDetails(UserDetails userDetails, UserDetailsDTO userDetailsDTO){
        userDetails.setId(userDetailsDTO.getId());
        userDetails.setFirstName(userDetailsDTO.getFirstName());
        userDetails.setLastName(userDetailsDTO.getLastName());
    }
}
