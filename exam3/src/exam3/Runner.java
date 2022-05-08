package exam3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.time.LocalDate;

public class Runner {

	static File file;
	static OutputStream os;
	static ObjectOutputStream oos;

	public static void main(String[] args) throws IOException, ClassNotFoundException, NonCapatilizedException, FlameNotInRangeException {
		Food food = new Food("Meat", Taste.SALTY, MacronutrientsCategory.FAT);
		Food food1 = new Food("Potato", Taste.BITTER, MacronutrientsCategory.CARBOHYDRATE);

		Dragon dragon = new Dragon("dragon1", LocalDate.of(887, 1, 12), 2);
		Dragon dragon1 = new Dragon("dragon2", LocalDate.of(888, 2, 11), 9);

		Object[] objects = new Object[] { food, food1, dragon, dragon1 };

		file = new File("myFiles/file.txt");
		os = new FileOutputStream(file);
		oos = new ObjectOutputStream(os);
		
		randomSelect(objects);
        randomSelect(objects);
        oos.close();
        printFromFile();

	}

	public static void randomSelect(Object[] objects) throws IOException {

		oos.writeObject(objects[(int) (Math.random() * 4)]);
	}

	public static void printFromFile() throws IOException, ClassNotFoundException {
		InputStream is = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(is);
		System.out.println(ois.readObject());
		System.out.println(ois.readObject());
		ois.close();

	}

}
