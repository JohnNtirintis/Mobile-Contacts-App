import dao.IMobileContactDAO;
import dao.MobileContactDAOImpl;
import dto.MobileContactDTO;
import dto.UserDetailsDTO;
import model.MobileContact;
import service.IMobileContactService;
import service.MobileContactServiceImpl;
import service.exceptions.MobileContactNotFoundException;
import service.exceptions.PhoneNumberAlreadyExistsException;
import service.exceptions.UserAlreadyExistsException;

import java.util.List;

/**
 * This is the main application class for managing mobile contacts.
 * The application interacts with the underlying DAO and Service layers
 * to insert, update, delete and retrieve mobile contacts.
 * It uses Data Transfer Objects (DTOs) to handle data exchange.
 * Any exceptions thrown by the service layer methods are caught and handled here.
 *
 * @author Ntirintis John
 */
public class MobileContactsApp {

    // Define the DAO and Service as static final variables to be used across the class
    private final static IMobileContactDAO dao = new MobileContactDAOImpl();
    private final static IMobileContactService service = new MobileContactServiceImpl(dao);

    public static void main(String[] args) {
        try{
            // Create new UserDetailDTO and MobileContactDTO objects
            UserDetailsDTO userDetailsDTO = new UserDetailsDTO(1L, "John", "Nt.");
            MobileContactDTO mobileContactDTO = new MobileContactDTO(1L, userDetailsDTO, "123456789");

            UserDetailsDTO updatedUserDetailsDTO = new UserDetailsDTO(1L, "Fernando", "Alonso");
            MobileContactDTO updateMobileContactDTO = new MobileContactDTO(1L, updatedUserDetailsDTO, "123456789");


            // Insert and update mobile contact using the service layer methods
            service.insertMobileContact(mobileContactDTO);
            service.updateMobileContact(1L, updateMobileContactDTO);


            // Get all contacts and print them to the console
            List<MobileContact> contacts = service.getAllMobileContacts();
            for(MobileContact contact : contacts){
                System.out.println(contact);
            }

            // Catch and handle exceptions thrown by the service layer methods
        } catch (PhoneNumberAlreadyExistsException | UserAlreadyExistsException | MobileContactNotFoundException e){
            System.out.println(e.getMessage());
        }

    }
}
