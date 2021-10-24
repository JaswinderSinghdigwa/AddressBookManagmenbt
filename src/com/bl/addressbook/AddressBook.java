package com.bl.addressbook;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * Create Class for Defining the Address Book
 */
public class AddressBook {
	// Created Enum for the File_Io
	public enum IOService {
		CONSOLE_IO, FILE_IO
	}

	// variables
	private static final String SAMPLE_CSV_FILE_PATH = "../AddressBookManagmenbt/addressBook_file.txt";
	private static final Scanner sc = new Scanner(System.in);
	public static List<ContactPerson> person = new ArrayList<ContactPerson>();
	public static HashMap<String, List<ContactPerson>> addressBookSystem = new HashMap<>();
	public static Map<String,List<ContactPerson>> personByCity;
    public static Map<String,List<ContactPerson>> personByState;

	/**
	 * Create Constructor for Initializing the variables with parameters
	 */
	public AddressBook(List<ContactPerson> person) {
		this.person = person;
	    this.personByCity = new HashMap<>();
	    this.personByState= new HashMap<>();
	}

	// Empty Constructor
	public AddressBook() {
	}

	/**
	 * Create Method to Add the Contact List.
	 */
	public void addContactDetails(Scanner consoleInputReader) {
		System.out.println("How Many Contacts Do You Want to Enter In Address Book");
		int numberOfContacts = consoleInputReader.nextInt();
		for (int i = 1; i <= numberOfContacts; i++) {
			System.out.println("enter the First Name");
			consoleInputReader.nextLine();
			String firstName = consoleInputReader.nextLine();
			System.out.println("enter the Last Name");
			String lastName = consoleInputReader.nextLine();
			System.out.println("enter the Address");
			String address = consoleInputReader.nextLine();
			System.out.println("enter the City");
			String city = consoleInputReader.nextLine();
			System.out.println("enter the State");
			String state = consoleInputReader.nextLine();
			System.out.println("enter the Zip Code");
			int zipCode = consoleInputReader.nextInt();
			consoleInputReader.nextLine();
			System.out.println("enter the Email address");
			String email = consoleInputReader.nextLine();
			System.out.println("enter the Phone Number");
			String phoneNumber = consoleInputReader.nextLine();

			String pName = firstName + lastName;
			for (Iterator<ContactPerson> iterator = person.iterator(); iterator.hasNext();) {
				ContactPerson temp = iterator.next();
				String contactName = temp.getFirstName() + temp.getLastName();
				if (contactName.equals(pName)) {
					System.out.println("Sorry this contact already exists.");
					return; // the name exists, so we exit the method.
				}
			}
			// Otherwise... you've checked all the elements, and have not found a duplicate
			person.add(new ContactPerson(firstName, lastName, address, city, state, zipCode, email, phoneNumber)); // Storing
																													// the
																													// Contacts
			System.out.println(person); // Printing the Contacts
		}
	}

	/**
	 * Create Method for Reading the AddressBook from Console
	 */
	public List<ContactPerson> readAddressBook(IOService ioService) {
		if (ioService.equals(AddressBook.IOService.CONSOLE_IO))
			this.person = new AddressBookIOService().readData();
		return person;
	}

	/**
	 * Create Main Method for Writing the addressBook to a File
	 */
	public void writeAddressBook(AddressBook.IOService ioService) throws IOException {
		if (ioService.equals(IOService.CONSOLE_IO))
			System.out.println("\n Writing Address Book Roaster to Console\n " + person);
		else if (ioService.equals(IOService.FILE_IO))
			new AddressBookIOService().writeData(person);
	}

	/**
	 * Create Method to Edit the Contact using First Name.
	 */
	public void editContactDetailsByFirstName() {
		System.out.println("Enter First Name to verify and edit the Contact list");
		Scanner sc = new Scanner(System.in);
		String firstName = sc.nextLine();
		for (Iterator<ContactPerson> iterator = person.iterator(); iterator.hasNext();) {
			ContactPerson temp = iterator.next();
			if (temp.getFirstName().equalsIgnoreCase(firstName)) {
				System.out.println(
						"1.First Name\n,2.Second Name\n,3.Address\n,4.City\n,5.State\n,6.Zip Code\n,7.Email Address\n,8.Phone Number\n");
				System.out.println("Enter the choice What you want to Edit");
				int choice = sc.nextInt();
				switch (choice) { // choosing which option as to edit
				case 1 :
					System.out.println("Enter the New First Name");
					Scanner scanner1 = new Scanner(System.in);
					firstName = scanner1.nextLine();
					temp.setFirstName(firstName);
					break;
				case 2 :
					System.out.println("Enter the New Last Name");
					Scanner scanner2 = new Scanner(System.in);
					String lastName = scanner2.nextLine();
					temp.setLastName(lastName);
					break;
				case 3 :
					System.out.println("Enter the Address");
					Scanner scanner3 = new Scanner(System.in);
					String address = scanner3.nextLine();
					temp.setAddress(address);
					break;
				case 4 :
					System.out.println("Enter the New City");
					Scanner scanner4 = new Scanner(System.in);
					String city = scanner4.nextLine();
					temp.setCity(city);
					break;
				case 5 :
					System.out.println("Enter the New State");
					Scanner scanner5 = new Scanner(System.in);
					String state = scanner5.nextLine();
					temp.setState(state);
					break;
				case 6 :
					System.out.println("Enter the New Zip Code");
					Scanner scanner6 = new Scanner(System.in);
					int zipCode = scanner6.nextInt();
					temp.setZipCode(zipCode);
					break;
				case 7 :
					System.out.println("Enter the New Email Address");
					Scanner scanner7 = new Scanner(System.in);
					String eMail = scanner7.nextLine();
					temp.setMail(eMail);
					break;
				case 8 :
					System.out.println("Enter the New Phone Number");
					Scanner scanner8 = new Scanner(System.in);
					String phoneNumber = scanner8.nextLine();
					temp.setPhoneNumber(phoneNumber);
				}
				System.out.println("Contacts are Updated");
				System.out.println(person);
				return;
			}
		}
		System.out.println("No Contact Found To Edit");
	}

	/**
	 * Create Method to Delete the Contact. Will work as there is no contacts with
	 * first name.
	 */
	public static void deleteContactByFirstName() {
		System.out.println("Enter the First Name to verify and delete the contact");
		Scanner scanner = new Scanner(System.in);
		String firstName = scanner.nextLine();
		int flag = 0;
		for (Iterator<ContactPerson> iterator = person.iterator(); iterator.hasNext();) {
			ContactPerson temp = iterator.next();
			if (temp.getFirstName().equalsIgnoreCase(firstName)) {
				iterator.remove();
				System.out.println("The Contact with First Name " + firstName + " Deleted Successfully");
				return;
			}
		}
		System.out.println("No contact With First Name " + firstName + " will found");
	}
	
	 /**
     * Create Method for Writing the addressBook contacts from Json File
	 * @param <Json>
     */
    public void writeContactsToJsonFile() throws IOException {
        
    	 File file=new File("../AddressBookManagmenbt/addressBook_file.txt");
         BufferedWriter buffer = null;
         try{
             buffer=new BufferedWriter(new FileWriter(file));

             for (Entry<String, List<ContactPerson>> book : addressBookSystem.entrySet()){
                 buffer.write(book.getKey() + ":" +book.getValue());
                 buffer.newLine();
             }
             buffer.flush();
         }
         catch(IOException e){
             e.printStackTrace();
         }
    }
    
    /**
     * Create Method for Reading the addressBook contacts from Json File
     */
    public void readContactsFromJsonFile() throws IOException {
        List<ContactPerson> contactPersonList = null;
        try (Reader reader = Files.newBufferedReader(Path.of(SAMPLE_CSV_FILE_PATH));) {
        	gson json = new gson();
            contactPersonList = new ArrayList<ContactPerson>(Arrays.asList(json.fromJson(reader, ContactPerson[].class)));
            for (ContactPerson contactList : contactPersonList) {
                System.out.println("First Name : " + contactList.getFirstName());
                System.out.println("Last Name : " + contactList.getLastName());
                System.out.println("Address : " + contactList.getAddress());
                System.out.println("City : " + contactList.getCity());
                System.out.println("State : " + contactList.getState());
                System.out.println("ZipCode : " + contactList.getZipCode());
                System.out.println("Email : " + contactList.getMail());
                System.out.println("Phone number : " + contactList.getPhoneNumber());
            }
        }
    }
	
	/**
     * Create Method to Search the Contact By Using City Name
     */
    public void searchPersonByCity(String city) {
        List<ContactPerson> search = person.stream().filter(first -> first.getCity().equals(city)).collect(Collectors.toList());
        for (ContactPerson contacts : search ) {
            System.out.println("City: " + contacts.getCity() + " LastName: " + contacts.getCity());
        }
    }
    
    /**
     * Create Method for Reading the addressBook contacts from a csv
     */
    public void readAddressBookContactsFromCSV() throws IOException {
        try (Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
             CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();) {
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                System.out.println("First Name - " + nextRecord[0]);
                System.out.println("Last Name - " + nextRecord[1]);
                System.out.println("Address - " + nextRecord[1]);
                System.out.println("City - " + nextRecord[1]);
                System.out.println("State - " + nextRecord[1]);
                System.out.println("Email - " + nextRecord[1]);
                System.out.println("Phone - " + nextRecord[1]);
                System.out.println("Zip - " + nextRecord[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Create Method to Search the Contact By Using State Name
     */
    public void searchPersonByState(String state) {
        List<ContactPerson> search = person.stream().filter(first -> first.getState().equals(state)).collect(Collectors.toList());
        for (ContactPerson contacts : search ) {
            System.out.println("State: " + contacts.getState() + " LastName: " + contacts.getState());
        }
    }
}