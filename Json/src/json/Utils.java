package json;

import java.util.ArrayList;
import java.util.List;

import json.Pastry.Label;

public  class Utils {
	
	public static List<Pastry> pastryList(){
		List<Ingredient>ingredientList  = new ArrayList<>();
		List<Ingredient>ingredientList1  = new ArrayList<>();
		List<Pastry>pastryList = new ArrayList<>();
		Ingredient in1 = new Ingredient("Sugar",150);
		Ingredient in2 = new Ingredient("Salt",200);
		Ingredient in3 = new Ingredient("meat",300);
		Ingredient in4 = new Ingredient("water",50);
		
		ingredientList.add(in1);
		ingredientList.add(in2);
		ingredientList1.add(in3);
		ingredientList1.add(in4);
		
		Pastry pastry1 = new Pastry("baget",150,ingredientList,Label.PAREVE);
		Pastry pastry2 = new Pastry("Steak",200,ingredientList1,Label.PAREVE);
		
		pastryList.add(pastry1);
		pastryList.add(pastry2);
		
		return pastryList;
		
		
		
		
		
	}
	

}
