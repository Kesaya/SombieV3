package application;

import javafx.scene.image.Image;

public class Ingredient {
	
	enum Catergory{
		FRUITY,
		CREAMY,
		ALCOHOLIC,
		CLEAR,
		CAFFEINATED
	}
	
	private boolean alcoholic;
	private Image picture;
	private float volAlcoholic;
	private String name;
	private Ingredient.Catergory catergory;
	private float amount; //needed for Cocktails but is not parsed from JSON object
	
	public Ingredient() {
		
	}

	public boolean isAlcoholic() {
		return alcoholic;
	}

	public void setAlcoholic(boolean alcoholic) {
		this.alcoholic = alcoholic;
	}

	public Image getPicture() {
		return picture;
	}

	public void setPicture(Image picture) {
		this.picture = picture;
	}

	public float getVolAlcoholic() {
		return volAlcoholic;
	}

	public void setVolAlcoholic(float volAlcoholic) {
		this.volAlcoholic = volAlcoholic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Ingredient.Catergory getCatergory() {
		return catergory;
	}

	public void setCatergory(Ingredient.Catergory catergory) {
		this.catergory = catergory;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
}
