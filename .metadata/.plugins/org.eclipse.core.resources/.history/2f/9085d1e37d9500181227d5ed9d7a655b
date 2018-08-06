package com.jda.core.StockReport;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class StockPortfolio {

	public static List<Stock> readFromFile() throws JsonParseException, JsonMappingException, IOException {
		String data;
		try {
			data = new String(Files.readAllBytes(Paths.get(
					"/home/bridgelabz/java-programs/Functional-Programs/ObjectOriented/src/com/jda/core/StockReport/stocks.json")));
		} catch (Exception e) {
			System.out.println("File does not exist!");
			return null;
		}
		ObjectMapper mapper = new ObjectMapper();
		List<Stock> stock = mapper.readValue(data, new TypeReference<ArrayList<Stock>>() {
		});
		return stock;
	}

	public static void calculateValues() throws JsonParseException, JsonMappingException, IOException {
		List<Stock> stock = readFromFile();
		for (Stock x : stock)
		{
			System.out.print("Name : " + x.getName() + " \t| " + "Value : " + x.getPrice()*x.getQuantity() + "\n");
		}
	}

//	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
//		calculateValues();
//	}
}