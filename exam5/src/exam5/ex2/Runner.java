package exam5.ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class Runner {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(Path.of("myFiles", "file.json").toString());
		deserialize(file);

	}

	public static void deserialize(File file) throws FileNotFoundException {
		FileReader fileReader = new FileReader(file);
		JsonReader jsonReader = new JsonReader(fileReader);
		Gson gson = new Gson();

		Type apartment = new TypeToken<ArrayList<Apartment>>() {
		}.getType();
		List<Apartment> addList = gson.fromJson(jsonReader, apartment);
		addList.forEach(System.out::println);
	}

}
