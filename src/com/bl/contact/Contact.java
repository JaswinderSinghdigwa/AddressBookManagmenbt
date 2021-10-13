package com.bl.contact;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.bl.Utility.InputUtility;

public class Contact {


	// GLOBAL LIST TO STORE PERSON RECORD
	List<Person> PERSON = new ArrayList<Person>();

	/**
	 * Create Method to Add the Contact List.
	 */

	public void addRecord() {
		int i = 0;
		String firstname = null;
		final String lastname, address, city, state, phone, zip;
		while (i == 0) {
			System.out.print("Enter First Name : ");
			firstname = InputUtility.getStringValue();
			if (checkExists(firstname)) {
				System.out.println("Person Name Already Exists!!\nPlease enter different name...");
			} else {
				i = 1;
			}
		}
		System.out.print("Enter Last Name : ");
		lastname = InputUtility.getStringValue();
		System.out.print("Enter Phone Number : ");
		phone = InputUtility.getStringValue();
		System.out.print("Enter Address : ");
		address = InputUtility.getStringValue();
		System.out.print("Enter city : ");
		city = InputUtility.getStringValue();
		System.out.print("Enter zip : ");
		zip = InputUtility.getStringValue();
		System.out.print("Enter state : ");
		state = InputUtility.getStringValue();

		PERSON.add(new Person(firstname, lastname, address, city, state, phone, zip));
	} // END of addRecord()

	// DISPLAY METHOD
	public void displayRecord() {
		if (PERSON.isEmpty()) {
			System.out.println("No Records!!!");
		} else {
			for (Person person : PERSON) {
				System.out.println(person);
			}
		}

	} // END OF displayRecord

	/**
	 * Create Method to Edit the Contact using First Name.
	 */
	public void editRecord() {
		int id, choice = 0, i = 0;
		String firstname, lastnamename, address, city, state, phone, zip;
		for (Person person : PERSON) {
			System.out.println("ID: #" + PERSON.indexOf(person) + " : " + person);
		}
		System.out.print("\nEnter #ID to Edit Contact : ");
		id = InputUtility.getIntValue();
		System.out.println(PERSON.get(id));
		while (i == 0) {
			System.out.println("What You Want to edit...\n" + "\t1: Address\n" + "\t2: city\n" + "\t3: State\n"
					+ "\t4: Phone\n" + "\t5: Zip Code\n" + "\t6. Save And Exit\n");
			choice = InputUtility.getIntValue();
			switch (choice) {
			case 1:
				System.out.print("Enter new Address : ");
				address = InputUtility.getStringValue();
				PERSON.get(id).setAddress(address);
				break;
			case 2:
				System.out.print("Enter new City : ");
				city = InputUtility.getStringValue();
				PERSON.get(id).setCity(city);
				break;
			case 3:
				System.out.print("Enter new State : ");
				state = InputUtility.getStringValue();
				PERSON.get(id).setState(state);
				break;
			case 4:
				System.out.print("Enter new Phone : ");
				phone = InputUtility.getStringValue();
				PERSON.get(id).setPhone(phone);
				break;
			case 5:
				System.out.print("Enter new Zip Code : ");
				zip = InputUtility.getStringValue();
				PERSON.get(id).setZip(zip);
				break;
			case 6:
				i = 1;
				break;
			default:
				System.out.println("Please Enter Valid Option");
			}
			System.out.println(PERSON.get(id));
		}
	} // end of edit() method

	/**
	 * Create Method to Delete the Contact. Will work as there is no contacts with
	 * first name.
	 */

	public void deleteRecord() {
		int id;
		for (Person person : PERSON) {
			System.out.println("ID: #" + PERSON.indexOf(person) + " : " + person);
		}
		System.out.print("\nEnter #ID to delete Contact : ");
		id = InputUtility.getIntValue();
		PERSON.remove(id);
	}
	
	 /**
     * Create Method to Sorting the Contact By detail
     */
	
	public void sortRecords(){
        System.out.println("Sort By...\n"
                + "1: First Name\n"
                + "2: City\n"
                + "3: State\n"
                + "4: Zip Code\n"
                + "5: Back");
        int choice = InputUtility.getIntValue();
        switch (choice)
        {
            case 1 : 
                Sorting.sortByName(PERSON);
                break;
            case 2 :
                Sorting.sortByZip(PERSON);
                break;
            case 3 :
                Sorting.sortByState(PERSON);
                break;
            case 4 :
                Sorting.sortByZip(PERSON);
                break;
            case 5 :
                return;
            default:
                System.out.println("Please Enter Valid Option...");
        }
    }


	/**
	 * Create Method to checking the String. Will work as there is contacts with
	 * first name.
	 */

	public boolean checkExists(String firstname) {
		int flag = 0;
		for (Person person : PERSON) {
			if (person.getFirstname().equals(firstname)) {
				flag = 1;
				break;
			}
		}
		if (flag == 1) {
			return true;
		}
		return false;
	}
}