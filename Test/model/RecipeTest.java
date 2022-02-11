package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RecipeTest {

	Recipe recipe;
	
	public void setupStage1() {
		recipe = new Recipe("", 0);
	}
	
	public void setupStage2() {
		recipe = new Recipe("", 0);
		recipe.addIngredient("Cebolla", 315);
		recipe.addIngredient("Ajo", 58);
		recipe.addIngredient("Arroz", 520);
	}
	
	@Test
	public void testAddIngredient() {
		setupStage1();
		recipe.addIngredient("Sal", 12);
		assertEquals(1, recipe.getIngredients().size());
		assertEquals("Sal", recipe.getIngredients().get(0).getName());
		assertEquals(12, recipe.getIngredients().get(0).getWeight());
		
		setupStage2();
		recipe.addIngredient("Pimienta", 6);
		assertEquals(4, recipe.getIngredients().size());
		assertEquals("Pimienta", recipe.getIngredients().get(3).getName());
		assertEquals(6, recipe.getIngredients().get(3).getWeight());
		
		setupStage2();
		recipe.addIngredient("Ajo", 21);
		assertEquals(3, recipe.getIngredients().size());
		assertEquals("Ajo", recipe.getIngredients().get(1).getName());
		assertEquals(79, recipe.getIngredients().get(1).getWeight());
	}
	
	@Test
	public void testRemoveIngredient() {
		setupStage2();
		recipe.removeIngredient("Ajo");
		assertEquals(2, recipe.getIngredients().size());
		assertEquals("Cebolla", recipe.getIngredients().get(0).getName());
		assertEquals("Arroz", recipe.getIngredients().get(1).getName());
	}
}
