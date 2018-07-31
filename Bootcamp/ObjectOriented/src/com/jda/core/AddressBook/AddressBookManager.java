package com.jda.core.AddressBook;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.jda.utility.Utility;

public class AddressBookManager {

	private static String path = "/home/bridgelabz/java-programs/Functional-Programs/ObjectOriented/src/com/jda/core/AddressBook/Json-Files";
	private static List<String> allAddressBooks = Utility.allFilesInFolder(path);
	private static List<AddressBook> allOpenAddressBooks = new ArrayList<>();

	public static void createAddressBook() throws IOException {
		System.out.println("Enter the name of the address book:");
		String name = Utility.getString();
		while (allAddressBooks.contains(name + ".json")) {
			System.out.print("Filename already exists! Enter name again :");
			name = Utility.getString();

		}
		String fileName = path + "/" + name + ".json";
		File file = new File(fileName);
		file.createNewFile();
		allAddressBooks.add(name + ".json");
	}

	public static void openAddressBook() throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println(allAddressBooks);
		ObjectMapper mapper = new ObjectMapper();
		List<Person> person = new ArrayList<>();
		System.out.println("Enter the name of the address book:");
		String name = Utility.getString();
		try {
			person = mapper.readValue(new File(path + "/" + name + ".json"), new TypeReference<ArrayList<Person>>() {
			});
		} catch (IOException e) {
			person = new ArrayList<Person>();
		}
		AddressBook addressBook = new AddressBook(name);
		while (true) {
			System.out.println("1. Create new entry");
			System.out.println("2. Edit information");
			System.out.println("3. Delete an entry");
			System.out.println("4. Sort by last name");
			System.out.println("5. Sort by zip");
			System.out.println("6. Go back to main menu");
			System.out.print("Enter choice :");
			int ans = Utility.getInt();
			Utility.getString();
			if (ans != 6) {
				switch (ans) {
				case 1: {
					person = addressBook.addEntry(person);
				}
					break;
				case 2: {
					person = addressBook.editInfo(person);
				}
					break;
				case 3: {
					person = addressBook.deleteEntry(person);
				}
					break;
				case 4: {
					person = addressBook.sortByLastName(person);
				}
					break;
				case 5: {
					person = addressBook.sortByZip(person);
				}
					break;
				}
			} else {
				break;
			}
		}
		addressBook.setAllPersons(person);
		allOpenAddressBooks.add(addressBook);
	}

	public static void closeAddressBook() throws JsonGenerationException, JsonMappingException, IOException {
		if (allOpenAddressBooks.size() == 1) {
			System.out.println("Do you want to save the file?(y/n)");
			String choice = Utility.getString();
			if (choice.equals("y")) {
				saveAddressBook();
			}
			allOpenAddressBooks.remove(0);
		} else {
			System.out.println("Address Books open:");
			for (AddressBook x : allOpenAddressBooks) {
				System.out.println(x.getAddressBookName());
			}
			System.out.println("Enter the Address Book name to be closed:");
			String name = Utility.getString();
			System.out.println("Do you want to save the file?(y/n)");
			String choice = Utility.getString();
			if (choice.equals("y")) {
				saveAddressBook();
			}
			allOpenAddressBooks.remove(name);
		}
	}

	public static void saveAddressBook() throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		if (allOpenAddressBooks.size() == 1) {
			String totalData = mapper.writerWithDefaultPrettyPrinter()
					.writeValueAsString(allOpenAddressBooks.get(0).getAllPersons());
			FileWriter file = new FileWriter(path + "/" + allOpenAddressBooks.get(0).getAddressBookName() + ".json");
			System.out.println(totalData);
			file.write(totalData);
			file.close();
		} else {
			System.out.println("Enter the name of the file to be saved:");
			String name = Utility.getString();
			for (AddressBook x : allOpenAddressBooks) {
				if (x.getAddressBookName().equals(name)) {
					String totalData = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(x.getAllPersons());
					FileWriter file = new FileWriter(path + "/" + x.getAddressBookName() + ".json");
					System.out.println(totalData);
					file.write(totalData);
					file.close();
					break;
				}
			}
		}
	}

	public static void saveAsAddressBook() throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("Save as name :");
		String name = Utility.getString();
		if (allOpenAddressBooks.size() == 1) {
			String totalData = mapper.writerWithDefaultPrettyPrinter()
					.writeValueAsString(allOpenAddressBooks.get(0).getAllPersons());
			FileWriter file = new FileWriter(path + "/" + name + ".json");
			System.out.println(totalData);
			file.write(totalData);
			file.close();
		} else {
			System.out.println("Enter the name of the file to be saved:");
			String name1 = Utility.getString();
			for (AddressBook x : allOpenAddressBooks) {
				if (x.getAddressBookName().equals(name1)) {
					String totalData = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(x.getAllPersons());
					FileWriter file = new FileWriter(path + "/" + name + ".json");
					System.out.println(totalData);
					file.write(totalData);
					file.close();
					break;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		while (true) {
			System.out.println("1. Create address book");
			System.out.println("2. Open address book");
			System.out.println("3. Close address book");
			System.out.println("4. Save address book");
			System.out.println("5. Save as address book");
			System.out.println("6. Quit");
			System.out.print("Enter choice :");
			int ans = Utility.getInt();
			Utility.getString();
			if (ans != 6) {
				switch (ans) {
				case 1: {
					createAddressBook();
				}
					break;
				case 2: {
					openAddressBook();
				}
					break;
				case 3: {
					closeAddressBook();
				}
					break;
				case 4: {
					saveAddressBook();
				}
					break;
				case 5: {
					saveAsAddressBook();
				}
				}
			} else {
				break;
			}
		}
	}
}