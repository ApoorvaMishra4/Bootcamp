package com.jda.core.Inventory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class InventoryFactory {
	
	public static List<Product> jsonToObject(String path) throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper mapper = new ObjectMapper();
		List<Product> data = mapper.readValue(new File(path), new TypeReference<ArrayList<Product>>(){});
		return data;
	}
}
