package com.jda.core.Inventory;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

public class InventoryManager {
	private static String path = "/home/bridgelabz/java-programs/Functional-Programs/AddressBook/InventoryFiles/Inventory.json";
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		List<Product>  allProducts= InventoryFactory.jsonToObject(path);
		Inventory.calculateValue(allProducts);
	}
}