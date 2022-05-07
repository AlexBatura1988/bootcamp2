package exAlice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Runner {

	public static void main(String[] args) {
		alice();

	}

	public static void alice() {

		int wordCount = 0;
		int lineCount = 1;
		String word = "";
		String sentence = "";

		try (FileReader reader = new FileReader("myFiles/alice.txt")) {
			int text;
			do {
				text = reader.read();
				char ch = (char) text;
				if (ch == '\n') {
					lineCount++;
					wordCount++;
				} else if (ch == ' ') {
					wordCount++;
				}
				if (lineCount == 18) {
					sentence += ch;
				}
				if (wordCount == 578) {
					word += ch;
				}

			} while (text != -1);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		System.out.println("line count is: " + lineCount);
		System.out.println("world count is: " + wordCount);
		System.out.println("sentence 18 is: " + sentence);
		System.out.println("word 578 is: " + word);

		try (FileWriter writer = new FileWriter("myFiles/output.txt")) {
			writer.write("word 578 is: " + word +"\n");
			writer.write("line count is: " + lineCount + "\n");
			writer.write("world count is: " + wordCount + "\n");
			writer.write("sentence 18 is: " + sentence);
			

		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
