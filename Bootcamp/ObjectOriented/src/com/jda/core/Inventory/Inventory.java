package com.jda.core.Inventory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.jda.utility.Utility;

public class Inventory {
	private static String path = "/home/bridgelabz/java-programs/Functional-Programs/AddressBook/InventoryFiles";
	static ObjectMapper mapper = new ObjectMapper();
	static List<Product> allProducts = new ArrayList<>();

	public static String convertToJson(List<Product> allProducts)
			throws JsonGenerationException, JsonMappingException, IOException {
		String json = mapper.writeValueAsString(allProducts);
		return json;
	}

	public static void writeDataToFile(String json) throws IOException {
		FileWriter file = new FileWriter(path + "/Inventory.json");
		file.write(json);
		file.close();
	}

	public static List<Product> getInput(List<Product> allProducts) {
		for (int i = 0; i < 3; i++) {
			Product product = new Product();
			System.out.println("Enter the name:");
			product.setName(Utility.getString());
			System.out.println("Enter the weight:");
			product.setWeight(Utility.getFloat());
			System.out.println("Enter the price:");
			product.setPrice(Utility.getFloat());
			Utility.getString();
			allProducts.add(product);
		}
		return allProducts;
	}

	public static void calculateValue(List<Product> allProducts) {
		System.out.println("\nThe values are :");
		for (Product x : allProducts) {
			float value = x.getPrice() * x.getWeight();
			System.out.println(x.getName() + " : " + value);
		}
	}

	//public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
//		allProducts = getInput(allProducts);
//		writeDataToFile(convertToJson(allProducts));
//		calculateValue(allProducts);
//	}
}
