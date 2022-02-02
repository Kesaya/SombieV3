package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.io.FilenameUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javafx.scene.image.Image;

public class CocktailParser {
	
	
	
	private String cocktailsDirectory = "cocktails";
	
	private ArrayList<Cocktail> cocktailList;
	
	public CocktailParser() {
		this.cocktailList = new ArrayList<>();
	}
	
	
	public void parse() {
		Set<File> cocktailFiles = this.getCocktailFiles(this.cocktailsDirectory);
		for (File cocktailFile : cocktailFiles) {
			//check only .json files
			if(FilenameUtils.getExtension(cocktailFile.getAbsolutePath()).equals("json")) {
				JSONParser cocktailFileParser = new JSONParser();
				try {
					BufferedReader cocktailFileReader = new BufferedReader(new FileReader(cocktailFile));
					
					Object cocktailObject = cocktailFileParser.parse(cocktailFileReader);
					
					JSONObject cocktailJSONObject = (JSONObject) cocktailObject;
					
					Cocktail cocktail = new Cocktail();
					
					cocktail.setName(cocktailJSONObject.get("name").toString());
					//TODO: implement Cocktail Object 
					//System.out.println("Reading Image: "+ cocktailFile.getParentFile().getAbsolutePath()+"\\pictures\\"+ cocktailJSONObject.get("picture").toString());
					//cocktail.setPicture(new Image(cocktailFile.getParentFile().getAbsolutePath()+"\\pictures\\"+ cocktailJSONObject.get("picture").toString()));
					
					JSONArray ingredients = (JSONArray) cocktailJSONObject.get("ingredients");
					Iterator<Object> ingredientIterator = ingredients.iterator();
					
					while(ingredientIterator.hasNext()) {
						JSONObject ingredient = (JSONObject) ingredientIterator.next();
						
					}
					
					
				} catch (FileNotFoundException e) {
					System.err.println("ERROR - File not Found Exception on Cocktail File: "+ cocktailFile.getAbsolutePath());
					e.printStackTrace();
				} catch (IOException e) {
					System.err.println("ERROR - IO Exception on Cocktail File: "+ cocktailFile.getAbsolutePath());
					e.printStackTrace();
				} catch (ParseException e) {
					System.err.println("ERROR - Parse Exception on Cocktail File: "+ cocktailFile.getAbsolutePath());
					e.printStackTrace();
				} finally {
					System.out.println("INFO - Successfully parsed Cocktail File: " + cocktailFile.getAbsolutePath());
				}
			}
		}
	}
	
	
	public void saveCocktail(Cocktail cocktail) {
		File saveCocktailFile = new File(this.getCocktailsDirectory() + cocktail.getName().strip().replace(" ", "_")+".json");

		try {
			FileWriter cocktailFileWriter = new FileWriter(saveCocktailFile);
			cocktailFileWriter.write(cocktail.getJSON());
			//Writing Image File from Cocktail not yet implemented
			writeCocktailImageFile(cocktail);
			cocktailFileWriter.close();
			
		} catch (IOException e) {
			System.out.println("Error saving File...");
			e.printStackTrace();
		} finally {
			
		}
		
	}
	
	private void writeCocktailImageFile(Cocktail cocktail) {
		//File saveCocktailPictureFile = new File(this.getCocktailsDirectory() + "\\pictures\\"+ cocktail.getName().strip().replace(" ", "_")+".png");
	}
	
	
	
	
	//get java.io.File Objects from the this.cocktailDirectory
	public Set<File> getCocktailFiles(String dir) {
	    return Stream.of(new File(dir).listFiles())
	      .filter(file -> !file.isDirectory())
	      .collect(Collectors.toSet());
	}

	public String getCocktailsDirectory() {
		return cocktailsDirectory;
	}

	public void setCocktailsDirectory(String cocktailsDirectory) {
		this.cocktailsDirectory = cocktailsDirectory;
	}

}
