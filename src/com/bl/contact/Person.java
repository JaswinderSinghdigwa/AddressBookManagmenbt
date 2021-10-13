package com.bl.contact;

import java.util.Comparator;

public class Person
{
    private String firstname, lastname, address, city, state, phone,zip;

    public Person(String firstname, String lastname, String address, String city, String state, String phone, String zip)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.city = city;
        this.state = state;
        this.phone = phone;
        this.zip = zip;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String fname)
    {
        this.firstname = fname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lname)
    {
        this.lastname = lname;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getZip()
    {
        return zip;
    }

    public void setZip(String zip)
    {
        this.zip = zip;
    }
    
    // Sort By First Name
    public static Comparator<Person> firstNameSorting = new Comparator<Person>() {
        @Override
        public int compare(Person person1, Person person2)
        {
            String firstname1 = person1.getFirstname();
            String firstname2 = person2.getFirstname();
            // ascending order
            return firstname1.compareTo(firstname2);
        }
    };

 // Sort By City
    public static Comparator<Person> citySorting = new Comparator<Person>() {
        @Override
        public int compare(Person person1, Person person2)
        {
            String city1 = person1.getCity();
            String city2 = person2.getCity();
            // ascending order
            return city1.compareToIgnoreCase(city2);
        }
    };
    
    // Sort By State
    public static Comparator<Person> stateSorting = new Comparator<Person>() {
        @Override
        public int compare(Person person1, Person person2)
        {
            String state1 = person1.getState();
            String state2 = person2.getState();
            // ascending order
            return state1.compareToIgnoreCase(state2);
        }
    };
    
    // Sort By Zip
    public static Comparator<Person> zipSorting = new Comparator<Person>() {
        @Override
        public int compare(Person person1, Person person2)
        {
            String zip1 = person1.getZip();
            String zip2 = person2.getZip();
            // ascending order
            return zip1.compareToIgnoreCase(zip2);
        }
    };
    
    @Override
    public String toString() {
        return "Person{" +
                "fname='" + firstname + '\'' +
                ", lname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", phone='" + phone + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
