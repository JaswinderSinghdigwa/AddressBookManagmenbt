package com.bl.addressbook;

import com.bl.Utility.InputUtility;
import com.bl.contact.Contact;

/**
 * Create Class for Defining the Address Book
 */	
public class AddressBook {
	
	public String name;
	
	
    public AddressBook(String name) {
		super();
		this.name = name;
	}

	public static void main(String[] args) {
    	AddressBook[] address = new AddressBook[0];
    	
    	while(true){
           int  howManyBooks = InputUtility.getIntValue();
            if (howManyBooks>0){
                address = new AddressBook[howManyBooks];                   //This code decides how many books are in the array of books/the library
                break;
            }
            else System.out.print("You must create at least 1 book.");
            }
    	for (int i=0;i<address.length;i++){

    		System.out.println("Enter the BookName");
    		String bookname = InputUtility.getStringValue();
    		address[i] = new AddressBook(bookname);
    	}
    
        int choice,i=0;
         Contact contact = new Contact();
        while(i==0)
        {
            System.out.println("--- Address Book Management ---\n");
            System.out.println("\t--MENU--");
            System.out.println("1: Add New Person      ");
            System.out.println("2: Display Records     ");
            System.out.println("3: Edit Person     ");
            System.out.println("4: Delete Person     ");
            System.out.println("5: Exit		       \n");
//			System.out.println(" -----------------------");
            System.out.println("--- Enter Your Choice ---");
            choice = InputUtility.getIntValue();
            switch(choice)
            {
            /* Create Method to Add the Contact List.
            */
                case 1 :
                	contact.addRecord();
                    break;
                case 2 :
                	contact.displayRecord();
                    break;
                case 3 :
                	contact.editRecord();
                    break;
                case 4 :
                	contact.deleteRecord();
                    break;
                case 5 :
                    i=1;
                    break;
                default :
                    System.out.println("Please Enter Valid Option!!!");
            }
        }
    }
}