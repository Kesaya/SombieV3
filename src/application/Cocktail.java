package application;

import java.util.ArrayList;

import javafx.scene.image.Image;

public class Cocktail {

	enum Category{
		CLASSIC,
		FRUITY,
		TROPICAL,
		CAFFEINATED
	}
	
	private String name;
	private Image picture;
	private ArrayList<Ingredient> ingredients;
	private Cocktail.Category category;
	
	public Cocktail() {
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Image getPicture() {
		return picture;
	}


	public void setPicture(Image picture) {
		this.picture = picture;
	}


	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}
	
	public void addIngredient(Ingredient ingredient) {
		this.ingredients.add(ingredient);
	}


	public void setIngredients(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	
	
	
	public Cocktail.Category getCategory() {
		return category;
	}


	public void setCategory(Cocktail.Category category) {
		this.category = category;
	}


	public String getJSON() {
		String json = "";
		StringBuilder JSONStringBuilder = new StringBuilder();
		JSONStringBuilder.append("{");
		JSONStringBuilder.append("\"name\" : \"" + this.getName() + "\",");
		JSONStringBuilder.append("\"picture\" : \"" + "\\pictures\\" + this.getName().strip().replace(" ", "_") + ".png" + "\",");
		JSONStringBuilder.append("\"ingredients\" : ["); // open array for ingredients
		for(Ingredient ingredient : this.getIngredients()) {
			JSONStringBuilder.append("{\"name\" : \"" + ingredient.getName() + "\",");
		}
		JSONStringBuilder.deleteCharAt(JSONStringBuilder.length()-1); // delete last "," as this will break valid JSON
		JSONStringBuilder.append("],"); // close array for ingredients
		JSONStringBuilder.append("\"category\" : \"" + this.getCategory());
		JSONStringBuilder.append("}");
		
		json = JSONStringBuilder.toString();
		
		return json;
	}
}
