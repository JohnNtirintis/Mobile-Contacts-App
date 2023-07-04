package dao;

import model.MobileContact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class is an implementation of the IMobileContactDAO interface.
 * It uses an ArrayList to manage MobileContact objects.
 * @author Ntirintis John
 */
public class MobileContactDAOImpl implements  IMobileContactDAO{
    private static final List<MobileContact> contacts = new ArrayList<>();

    // Insert a new contact into the list
    @Override
    public MobileContact insert(MobileContact mobileContact) {
        if(mobileContact == null) return null;

        contacts.add(mobileContact);
        return mobileContact;
    }

    @Override
    public MobileContact update(long id, MobileContact mobileContact) {
        if(id != mobileContact.getId()) return null;

        // Must have completed equals()
        int positionToUpdate = getIndexById(id);
        return contacts.set(positionToUpdate, mobileContact);
    }

    @Override
    public void delete(long id) {
        // removeIf returns boolean
        contacts.removeIf((contact) -> contact.getId() == id);
    }

    @Override
    public MobileContact get(long id) {
        int pos = getIndexById(id);
        if(pos == -1) return null;

        return contacts.get(pos);
    }

    @Override
    public List<MobileContact> getAll() {
//        return new ArrayList<>(contacts);
        return Collections.unmodifiableList(contacts);
    }


    @Override
    public MobileContact get(String phoneNumber) {
        int position = getIndexByPhoneNumber(phoneNumber);
        if(position == -1) return null;

        return contacts.get(position);
    }

    @Override
    public void delete(String phoneNumber) {
        contacts.removeIf(contact -> contact.getPhoneNumber().equals(phoneNumber));
    }

    @Override
    public boolean phoneNumberExists(String phoneNumber) {
        return getIndexByPhoneNumber(phoneNumber) != -1;
    }

    @Override
    public boolean userIdExists(long id) {
        return getIndexById(id) != -1;
    }

    // Get index of contact by user id
    private int getIndexById(long id){
        int position = -1;

        for(int i = 0; i < contacts.size(); i++){
            if( contacts.get(i).getId() == id) {
                position = i;
                break;
            }
        }
        return position;
    }

    // Get index of contact by phone number
    private int getIndexByPhoneNumber(String phoneNumber){
        int position = -1;

        for(int i = 0; i < contacts.size(); i++){
            if( contacts.get(i).getPhoneNumber().equals(phoneNumber)) {
                position = i;
                break;
            }
        }
        return position;
    }
}
