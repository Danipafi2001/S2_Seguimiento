package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exception.NegativeNumberException;

class IngredientTest {

	Ingredient ingredient;
	
	public void setupStage1() {
		ingredient = new Ingredient("Tomate", 245);
	}
	
	@Test
	public void testAddWeight() {
		setupStage1();
		try {
			ingredient.addWeight(54);
		} catch (NegativeNumberException e) {
			e.getMessage();
		}
		assertEquals(299, ingredient.getWeight());
		
		setupStage1();
		try {
			ingredient.addWeight(-100);
		} catch (NegativeNumberException e) {
			e.getMessage();
		}
		assertEquals(245, ingredient.getWeight());
	}
	
	@Test
	public void testRemoveWeight() {
		setupStage1();
		try {
			ingredient.removeWeight(45);
		} catch (NegativeNumberException e) {
			e.getMessage();
		}
		assertEquals(200, ingredient.getWeight());
		
		setupStage1();
		try {
			ingredient.addWeight(-100);
		} catch (NegativeNumberException e) {
			e.getMessage();
		}
		assertEquals(245, ingredient.getWeight());
	}
}
