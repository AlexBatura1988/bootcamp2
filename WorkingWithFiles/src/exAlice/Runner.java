package exAlice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Runner {

	public static void main(String[] args) {
		alice();
		

	}
	public static void alice() {
		
		int wordCount = 0;
		int lineCount = 0;
		String word = "";
		String sentence = "";
		
		try(FileReader reader = new FileReader("myFiles/alice.txt")){
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
