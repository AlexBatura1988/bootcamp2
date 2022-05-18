package json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;


import json.Pastry.Label;

public class Runner {

	public static void pastryToJson(Pastry pastry) {
		Gson gson = new Gson();
		String userJson = gson.toJson(pastry);
		File file = new File("myFiles/pastry.json");
		try (FileWriter writer = new FileWriter(file)) {
			writer.write(userJson);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void deSerializationPastryFromJson(File file) {
		try (FileReader fileReader = new FileReader(file)) {
			JsonReader jsonReader = new JsonReader(fileReader);
			Gson gson = new Gson();
			Pastry pastry = gson.fromJson(jsonReader, Pastry.class);
			System.out.println(pastry);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void pastryListToJson(List<Pastry> pastryList) {
		Gson gson = new Gson();
		String addListJson = gson.toJson(pastryList);
		File file = new File("myFiles/pastryList.json");

		try (FileWriter fileWriter = new FileWriter(file)) {
			fileWriter.write(addListJson);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void deSerializationPastryListFromJson(File file) throws FileNotFoundException {
		FileReader fileReader = new FileReader(file);
		JsonReader jsonReader = new JsonReader(fileReader);
		Gson gson = new Gson();
		Type pastryListType = new TypeToken<ArrayList<Pastry>>() {}.getType();
		List<Pastry> addList = gson.fromJson(jsonReader, pastryListType);
		addList.forEach(System.out::println);
				
	}
	
	private static Map<Label,List<Pastry>> convertToMap(List<Pastry> pastryList){
		
		Map map = pastryList.stream()
				.collect(Collectors.toMap(Pastry :: getLabel, list -> list));
		return map;
	}
	
	
		
	

	public static void main(String[] args) throws FileNotFoundException {
		List<Ingredient> pastryIngr = new ArrayList<>();
		pastryIngr.add(new Ingredient("flour", 100));
		pastryIngr.add(new Ingredient("Sault", 20));
		Pastry pastry = new Pastry("bread", 100, pastryIngr, Label.PAREVE);
		File file = new File(Path.of("myFiles", "pastry.json").toString());
		File FileList = new File(Path.of("myFiles","pastryList.json").toString());
		

		pastryToJson(pastry);
		deSerializationPastryFromJson(file);
		System.out.println("........deSerializationPastryListFromJson...........");

		
		pastryListToJson(Utils.pastryList());
		deSerializationPastryListFromJson(FileList);
		
		System.out.println("..........listToMap..........");
		System.out.println(convertToMap(Utils.pastryList()));

	}

}
