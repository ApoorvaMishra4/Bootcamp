package com.jda.core.AddressBook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.jda.utility.Utility;

public class AddressBook {
	private List<Person> allPersons = new ArrayList<>();
	private String AddressBookName;

	public List<Person> getAllPersons() {
		return allPersons;
	}

	public void setAllPersons(List<Person> allPersons) {
		this.allPersons = allPersons;
	}

	public String getAddressBookName() {
		return AddressBookName;
	}

	public void setAddressBookName(String addressBookName) {
		AddressBookName = addressBookName;
	}

	public AddressBook(String name) {
		this.AddressBookName = name;
	}

	public List<Person> addEntry(List<Person> person) {
		Person entry = new Person();
		System.out.print("Enter the name:");
		entry.setName(Utility.getString());
		System.out.print("Enter the address:");
		entry.setAddress(Utility.getString());
		System.out.print("Enter the city:");
		entry.setCity(Utility.getString());
		System.out.print("Enter the state:");
		entry.setState(Utility.getString());
		System.out.print("Enter the zip:");
		entry.setZip(Utility.getInt());
		System.out.print("Enter the phone number:");
		entry.setPhoneNumber(Utility.getLong());
		person.add(entry);
		return person;
	}

	public List<Person> editInfo(List<Person> allPersons) {
		System.out.println("Enter the name of the user:");
		String name = Utility.getString();
		for (Person person : allPersons) {
			if (person.getName().equals(name)) {
				System.out.println("Enter 1 to change address, 2 to change phone number:");
				int key = Utility.getInt();
				Utility.getString();
				switch (key) {
				case 1: {
					String change;
					System.out.println("Enter the new address:(0 if no change)");
					change = Utility.getString();
					if (!change.equals("0")) {
						person.setAddress(change);
					}
					System.out.println("Enter the new city:(0 if no change)");
					change = Utility.getString();
					if (!change.equals("0")) {
						person.setCity(change);
					}
					System.out.println("Enter the new state:(0 if no change)");
					change = Utility.getString();
					if (!change.equals("0")) {
						person.setState(change);
					}
					System.out.println("Enter the new zip number:(0 if no change)");
					int zip = Utility.getInt();
					if (!change.equals("0")) {
						person.setZip(zip);
					}
				}
					break;
				case 2: {
					int number;
					System.out.println("Enter the new phone number:(0 if no change)");
					number = Utility.getInt();
					if (number != 0) {
						person.setPhoneNumber(number);
					}
				}
				}
			}
		}
		return allPersons;
	}

	public List<Person> deleteEntry(List<Person> allPersons) {
		System.out.println("Enter the name of the user:");
		String name = Utility.getString();
		for (Person x : allPersons) {
			if (x.getName().equals(name)) {
				allPersons.remove(x);
				break;
			}
		}
		return allPersons;
	}

	class NameComparator implements Comparator<Person> {

		@Override
		public int compare(Person arg0, Person arg1) {
			String lastName1 = arg0.getName().split(" ")[1];
			String lastName2 = arg1.getName().split(" ")[1];
			if (lastName1.compareTo(lastName2) < 0) {
				return -1;
			} else if (lastName1.compareTo(lastName2) > 0) {
				return 1;
			} else if (lastName1.equals(lastName2)) {
				String firstName1 = arg0.getName().split(" ")[0];
				String firstName2 = arg1.getName().split(" ")[0];
				if (firstName1.compareTo(firstName2) < 0) {
					return -1;
				} else {
					return 1;
				}
			}
			return 0;
		}
	}

	class ZipComparator implements Comparator<Person> {

		@Override
		public int compare(Person o1, Person o2) {
			if (o1.getZip() < o2.getZip()) {
				return -1;
			} else if (o1.getZip() < o2.getZip()) {
				return 1;
			} else {
				String lastName1 = o1.getName().split(" ")[1];
				String lastName2 = o2.getName().split(" ")[1];
				if (lastName1.compareTo(lastName2) < 0) {
					return -1;
				} else if (lastName1.compareTo(lastName2) > 0) {
					return 1;
				} else if (lastName1.equals(lastName2)) {
					String firstName1 = o1.getName().split(" ")[0];
					String firstName2 = o2.getName().split(" ")[0];
					if (firstName1.compareTo(firstName2) < 0) {
						return -1;
					} else {
						return 1;
					}
				}
				return 0;
			}
		}
	}

	public List<Person> sortByLastName(List<Person> allPersons) {
		Collections.sort(allPersons, new NameComparator());
		return allPersons;
	}

	public List<Person> sortByZip(List<Person> allPersons) {
		Collections.sort(allPersons, new ZipComparator());
		return allPersons;
	}

	public void print() {
		for (Person x : allPersons) {
			System.out.println("Name : " + x.getName());
			System.out.println("Address : " + x.getAddress());
			System.out.println("City : " + x.getCity());
			System.out.println("State : " + x.getState());
			System.out.println("Zip Code : " + x.getZip());
			System.out.println("Phone Number : " + x.getPhoneNumber());
			System.out.print("\n");
		}
	}
}
