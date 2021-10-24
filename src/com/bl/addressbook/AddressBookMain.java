package com.bl.addressbook;

import java.io.IOException;
import java.lang.annotation.AnnotationTypeMismatchException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;



public class AddressBookMain {
	// Variables
	private static AddressBook addressBook = new AddressBook();
	private static final Scanner scan = new Scanner(System.in);
    public static HashMap<String, AddressBook> addressBookSystem = new HashMap<>();
    private static String state;
    private static String city;
	/**
	 * Create Method for Implementing the Address Book
	 */
	public static void addressBook() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException{
		boolean choose = false;
		while (true) {
			System.out.println("1.Create\n 2.Edit\n 3.Delete\n 4.Write Data To File\n 5.Read Data from Console\n 6.Read data from Csvfile 7.Write from Jsonfile\n 8.Read from Jsonfile\n 9.Exit the loop");
			System.out.println("Enter the choice What you want do");
			int choice = scan.nextInt();
			switch (choice) {
			case 1 :
				List<ContactPerson> person = new ArrayList<ContactPerson>();
				AddressBook addContact = new AddressBook(person);
				Scanner consoleInputReader = new Scanner(System.in);
				addContact.addContactDetails(consoleInputReader);
				choose = true;
				break;
			case 2 :
				AddressBook editContact = new AddressBook();
				editContact.editContactDetailsByFirstName();
				choose = true;
				break;
			case 3 :
				AddressBook deleteContact = new AddressBook();
				deleteContact.deleteContactByFirstName(); // Calling Delete Contact Method
				choose = true;
				break;
			case 4 :
				AddressBook addressBook = new AddressBook();
				addressBook.writeAddressBook(AddressBook.IOService.FILE_IO);
				break;
			case 5 :
				AddressBook addressBook1= new AddressBook();
				addressBook1.readAddressBook(AddressBook.IOService.CONSOLE_IO);
				break;
			case 6 :
				AddressBook readCSV = new AddressBook();
                readCSV.readAddressBookContactsFromCSV();
                break;
			case 7 :
				AddressBook writeContactsJSON = new AddressBook();
                writeContactsJSON.writeContactsToJsonFile();
                break;
			case 8 :
				 AddressBook readContactsJSON = new AddressBook();
                 readContactsJSON.readContactsFromJsonFile();
                 break;
			case 9 : System.exit(0);
			default :
				System.out.println("Choice is incorrect");
			}
			
			System.out.println("Do you wish to continue, Say Yes or No");
            scan.nextLine();
            String option1= scan.nextLine();
            if(option1.equals("yes"))
                choose = false;
            else
                break;
		}
	}
	
	/**
	 * Create Main Method for Implementing the Address Book Main System
	 */
	public static void main(String[] args) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
		  AddressBookMain addressBookMain = new AddressBookMain();
	        boolean option = false;
	        while (true) {
	            System.out.println(" 1.Creating AddressBook\n 2.Search by City\n 3.Search by State\n 4.View Person By City\n 5.View Person By State\n 6.Count By city\n " +
	                    "7.Count By State\n 8.Sort Contact By Name\n 9.Sort Contact By City\n 10.Sort Contact By State\n 11.Sort Contact By ZipCode\n 12.Exit the Loop");
	            System.out.println("Enter The Choice");
	            int choice = scan.nextInt();
	            switch (choice) {
	                case 1 :
	                    System.out.println("Enter the Name of the Address Book");
	                    scan.nextLine();
	                    String addressBookName = scan.nextLine();
	                    if (addressBookSystem.containsKey(addressBookName)) {
	                        System.out.println("This Address Book Already Exists,Please Try With Different Name");
	                    } else {
	                        addressBookSystem.put(addressBookName,addressBook);
	                    }
	                    break;
	                case 2 :
	                    city();
	                    addressBookMain.searchByCity(city);
	                    break;
	                case 3 :
	                    state();
	                    addressBookMain.searchByState(state);
	                    break;
	                case 4 :
	                    city();
	                    addressBookMain.viewPersonByCity(city);
	                    break;
	                case 5 :
	                   state();
	                    addressBookMain.viewPersonByState(state);
	                    break;
	                case 6 :
	                    city();
	                    addressBookMain.countPersonByCity(city);
	                    break;
	                case 7 :
	                    state();
	                    addressBookMain.countPersonByState(state);
	                    break;
	                case 8 :
	                    sortByPersonsName();
	                    break;
	                case 9 :
	                    sortContactsByCity();
	                    break;
	                case 10 :
	                    sortContactsByState();
	                    break;
	                case 11 :
	                    sortContactsByZipCode();
	                    break;
	                case 12 : System.exit(0);
	            }
	        }
	}
	
	  /**
     * Create Method for state to follow DRY principal
     */
    public static void state() {
        System.out.println("Enter the Name of StateName");
        scan.nextLine();
        state = scan.nextLine();
    }
    /**
     * Create Method for city to follow DRY principal
     */
    public static void city() {
        System.out.println("Enter the Name of CityName");
        scan.nextLine();
        city = scan.nextLine();
    }

    /**
     * Create Method for Search person By state
     */
    private void searchByState(String state) {
        for (Map.Entry<String, AddressBook> book : addressBookSystem.entrySet()) {
            AddressBook value = book.getValue();
            System.out.println("The AddressBookName: " + book.getKey());
            value.searchPersonByState(state);
        }
    }
    /**
     * Create Method for Search Person By City
     */
    private static void searchByCity(String city) {
        for (Map.Entry<String, AddressBook> book : addressBookSystem.entrySet()) {
            AddressBook value = book.getValue();
            System.out.println("The AddressBookName: " + book.getKey());
            value.searchPersonByCity(city);
        }
    }
    /**
     * Create Method for View Person By City
     */
    private void viewPersonByCity(String city) {
        for (Map.Entry<String,AddressBook> book : addressBookSystem.entrySet()) {
            AddressBook value = book.getValue();
            List<ContactPerson> contactPeople = value.personByCity.entrySet().stream().filter(find -> find.getKey().equals(city)).map(Map.Entry::getValue).findFirst().orElse(null);
            for(ContactPerson contact: contactPeople){
                System.out.println("The First Name: " +contact.getFirstName() + " The Last Name: "+ contact.getLastName());
            }
        }
    }
    /**
     * Create Method for View Person By State
     */
    private void viewPersonByState(String State) {
        for (Map.Entry<String, AddressBook> book : addressBookSystem.entrySet()) {
            AddressBook value = book.getValue();
            List<ContactPerson> contactPeople = value.personByState.entrySet().stream().filter(find -> find.getKey().equals(State)).map(Map.Entry::getValue).findFirst().orElse(null);
            for(ContactPerson contact: contactPeople){
                System.out.println("From AddressBook: " +book.getKey()+ " \nFirst Name: " + contact.getFirstName() + " Last Name: " + contact.getLastName());
            }
        }
    }
    /**
     * Create Method for count person By State
     */
    public void countPersonByState(String state) {
        int countPersonByState = 0;
        for(Map.Entry<String, AddressBook> entry: addressBookSystem.entrySet()){
            for(int i=0;i<(entry.getValue()).person.size();i++) {
                ContactPerson contact= entry.getValue().person.get(i);
                if(state.equals(contact.getState())) {
                    countPersonByState++;
                }
            }
        }
        System.out.println("Count Of Persons in state "+state+": "+countPersonByState);
    }
    /**
     * Create Method for count Person By city
     */
    public void countPersonByCity(String city) {
        int countPersonByCity = 0;
        for(Map.Entry<String, AddressBook> entry: addressBookSystem.entrySet()){
            for(int i=0;i<(entry.getValue()).person.size();i++) {
                ContactPerson contact= entry.getValue().person.get(i);
                if(city.equals(contact.getCity())) {
                    countPersonByCity++;
                }
            }
        }
        System.out.println("Count Of Persons in City "+city+": "+countPersonByCity);
    }
    /**
     * Create Method for List by sorting with Persons Name;
     */
    public static void sortByPersonsName () {
        for (Map.Entry<String,AddressBook>entry:addressBookSystem.entrySet()){
            AddressBook value = entry.getValue();
            List<ContactPerson> sortedList = value.person.stream().sorted(Comparator.comparing(ContactPerson::getFirstName)).collect(Collectors.toList());
            for(ContactPerson contact:sortedList){
                System.out.println("The First Name: "+contact.getFirstName()+ " The Last Name: "+contact.getLastName());
            }
        }
    }
    /**
     * Create Method for List by sorting with city;
     */
    public static void sortContactsByCity () {
        for (Map.Entry<String,AddressBook>entry:addressBookSystem.entrySet()){
            AddressBook value = entry.getValue();
            List<ContactPerson> sortedList = value.person.stream().sorted(Comparator.comparing(ContactPerson::getCity)).collect(Collectors.toList());
            for(ContactPerson contact:sortedList){
                System.out.println("The City: "+contact.getCity()+ " The Last city: "+contact.getCity());
            }
        }
    }
    /**
     * Create Method for List by sorting with state;
     */
    private static void sortContactsByState() {
        for (Map.Entry<String,AddressBook>entry:addressBookSystem.entrySet()){
            AddressBook value = entry.getValue();
            List<ContactPerson> sortedList = value.person.stream().sorted(Comparator.comparing(ContactPerson::getState)).collect(Collectors.toList());
            for(ContactPerson contact:sortedList){
                System.out.println("The State: "+contact.getState()+ " The Last Name: "+contact.getState());
            }
        }
    }
    /**
     * Create Method for List by sorting with zipCode;
     */
    private static void sortContactsByZipCode() {
        for (Map.Entry<String,AddressBook>entry:addressBookSystem.entrySet()){
            AddressBook value = entry.getValue();
            List<ContactPerson> sortedList = value.person.stream().sorted(Comparator.comparing(ContactPerson::getZipCode)).collect(Collectors.toList());
            for(ContactPerson contact:sortedList){
                System.out.println("The Zipcoode: "+contact.getZipCode()+ " The zipcode: "+contact.getZipCode());
            }
        }
    }
}
