package AddressBookController;

import AddressBookIOOperations.ReadWriteOperations;
import AddressBookModel.PersonInfo;
import AddressBookService.AddressBook;
import Util.UserInputOutput;

import java.util.*;


public class AddressBookSystem {

    private static final int ADD = 1;
    private static final int EDIT = 2;
    private static final int DELETE = 3;
    private static final int DISPLAY = 4;
    private static final int SEARCH_CITY = 5;
    private static final int SORT_DATA = 6;
    private static final int QUIT = 7;
    static AddressBook add_Book = new AddressBook();
    static Scanner input = new Scanner(System.in);

    public static void main(String args[]){
        Hashtable<String, ArrayList<PersonInfo>> personInfoDict = new Hashtable<>();
        ReadWriteOperations readWriteObj = new ReadWriteOperations();

        boolean flag = true;
        int option;
        while(flag) {
            option = UserInputOutput.menu();
            switch (option) {
                case ADD:
                    System.out.println("\n" + "Add a new Address Book");
                    personInfoDict = add_Book.insertContactDetails();
                    readWriteObj.writeInAddressBook(personInfoDict);
                    //System.out.println(personInfoDict + "\n");
                    break;
                case EDIT:
                    System.out.print("\n" + "Enter the name of the Address Book that you want to replace: ");
                    String companyName = input.next();

                    add_Book.updateContact(companyName, personInfoDict);
                    break;
                case DELETE:
                    System.out.print("\n" + "Enter the name of the Address Book that you want to delete: ");
                    String deletedName = input.next();
                    add_Book.deleteContact(deletedName, personInfoDict);
                    break;
                case DISPLAY:
                    System.out.println("\n" + "Display all contacts in the Address Book");
                    //add_Book.displayCompanyContacts(personInfoDict);
                    readWriteObj.readFromAddressBook();
                    break;
                case SEARCH_CITY:
                    System.out.println("\n" + "Search Address Book based on City or State");
                    add_Book.searchPerson();
                    flag = true;
                    break;
                case SORT_DATA:
                    System.out.println("\n" + "Sort Address Book");
                    add_Book.sortPerson();
                    flag = true;
                    break;
                case QUIT:
                    flag = false;
                    System.out.println("\n" + "Thank you for referring the address book.");
                    break;
            }
        }
    }

}
