package model;

import java.util.ArrayList;
import java.util.List;

import exception.NegativeNumberException;

public class Recipe {
	private List<Ingredient> ingredients;
	
	public Recipe(String n, double w) {
		ingredients = new ArrayList<Ingredient>();
	}
	
	public Ingredient searchIngredient(String n) {
		Ingredient searched = null;
		for (int i = 0; i < ingredients.size() && searched==null; i++) {
			Ingredient current = ingredients.get(i);
			if(current.getName().equals(n)) {
				searched = current;
			}
		}
		return searched;
	}
	
	public void addIngredient(String n, double w) {
		Ingredient searched = searchIngredient(n);
		if(searched!=null) {
			try {
				searched.addWeight(w);
			} catch (NegativeNumberException e) {
				e.getMessage();
			}
		}else {
			Ingredient newIngredient = new Ingredient(n, w);
			ingredients.add(newIngredient);
		}		
	}
	
	public String removeIngredient(String n) {
		Ingredient searched = searchIngredient(n);
		if(searched!=null) {
			ingredients.remove(searched);
			return "El ingrediente se removió exitosamente";
		}else {
			return "El ingrediente no existe en la receta";
		}
	}
	
	public List<Ingredient> getIngredients(){
		return ingredients;
	}
}
