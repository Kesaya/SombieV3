package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FilenameUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class IngredientParser {
	
	String ingredientsDirectory = "ingredients";
	
	ArrayList<Ingredient> ingredientList;

	public IngredientParser() {
		this.ingredientList = new ArrayList<>();
	}
	
	
	public void parse() {
		Set<File> ingredientFiles = this.getIngredientFiles(this.ingredientsDirectory);
		for (File ingredientFile : ingredientFiles) {
			//check only .json files
			
			if(FilenameUtils.getExtension(ingredientFile.getAbsolutePath()).equals("json")) {
				JSONParser ingredientFileParser = new JSONParser();
				try {
					BufferedReader ingredientFileReader = new BufferedReader(new FileReader(ingredientFile));
					
					Object ingredientObject = ingredientFileParser.parse(ingredientFileReader);
					
					JSONObject ingredientJSONObject = (JSONObject) ingredientObject;
					
					Ingredient ingredient = new Ingredient();
					
					ingredient.setName(ingredientJSONObject.get("name").toString());
					//TODO: implement Ingredient Object 
					
					ingredientList.add(ingredient);
					
				} catch (FileNotFoundException e) {
					System.err.println("ERROR - File not Found Exception on Ingredient File: "+ ingredientFile.getAbsolutePath());
					e.printStackTrace();
				} catch (IOException e) {
					System.err.println("ERROR - IO Exception on Ingredient File: "+ ingredientFile.getAbsolutePath());
					e.printStackTrace();
				} catch (ParseException e) {
					System.err.println("ERROR - Parse Exception on Ingredient File: "+ ingredientFile.getAbsolutePath());
					e.printStackTrace();
				} finally {
					System.out.println("INFO - Successfully parsed Ingredient File: " + ingredientFile.getAbsoluteFile());
				}
			}
		}
	}
	
	
	//get java.io.File Objects from the this.ingredientsDirectory
	public Set<File> getIngredientFiles(String dir) {
		System.out.println("Analyzing ingredient files in directory: " + dir);
	    return Stream.of(new File(dir).listFiles())
	      .filter(file -> !file.isDirectory())
	      .collect(Collectors.toSet());
	}
	public String getIngredientsDirectory() {
		return ingredientsDirectory;
	}

	public void setIngredientsDirectory(String ingredientsDirectory) {
		this.ingredientsDirectory = ingredientsDirectory;
	}	

	public ArrayList<Ingredient> getIngredientList(){
		return this.ingredientList;
	}
	
	public Ingredient findIngredientByName(String ingredientName) {
		Ingredient ingredient = this.getIngredientList()
				.stream()
				.filter(i -> i
						.getName()
						.equals(ingredientName))
				.collect(Collectors.toList())
				.get(0);
		if (ingredient != null) {
			return ingredient;
		} else {
			Ingredient newIngredient = new Ingredient();
			newIngredient.setName(ingredientName);
			return newIngredient;
		}
	}
		//Quick hack for now to return the first item of the list ==> result should always only have 1 or 0 if no item is found
}
