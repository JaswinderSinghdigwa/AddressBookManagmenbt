package com.bl.contact;

import java.util.ArrayList;
import java.util.List;

import com.bl.Utility.InputUtility;

public class SearchingPerson {

	public static void searchByCity(List<Person> person) {
		String search;
		List<Person> matches = new ArrayList<>();
		System.out.println("Enter First Name to search : ");
		search = InputUtility.getStringValue();
		int flag = 0;
		for (Person p : person) {
			if (p.getCity().equalsIgnoreCase(search)) {
				flag = 1;
				matches.add(p);
			}
		}
		if (flag == 1) {
			System.out.println("...Match Found...");
			for (Person p : matches) {
				System.out.println(p);
			}
		} else {
			System.out.println("Match Not Found!!!");
		}
	}

	public static void searchByState(List<Person> person) {
		String search;
		int flag = 0;
		List<Person> matches = new ArrayList<>();
		System.out.println("Enter First Name to search : ");
		search = InputUtility.getStringValue();
		for (Person p : person) {
			if (p.getState().equalsIgnoreCase(search)) {
				flag = 1;
				matches.add(p);
			}
		}
		if (flag == 1) {
			System.out.println("...Match Found...");
			for (Person p : matches) {
				System.out.println(p);
			}
		} else {
			System.out.println("Match Not Found!!!");
		}
	}

	public static void sortByName(List<Person> person) {
		person.sort(Person.firstNameSorting);
		person.forEach(System.out::println);
	}

	public static void sortByCity(List<Person> person) {
		person.sort(Person.citySorting);
		person.forEach(System.out::println);
	}

	public static void sortByState(List<Person> person) {
		person.sort(Person.stateSorting);
		person.forEach(System.out::println);
	}

	public static void sortByZip(List<Person> person) {
		person.sort(Person.zipSorting);
		person.forEach(System.out::println);
	}
}
