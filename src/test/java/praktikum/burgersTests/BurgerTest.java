package praktikum.burgersTests;

import org.junit.Test;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class BurgerTest {

    private final Burger burger = new Burger();
    Database database = Mockito.mock(Database.class);

    @Test
    public void setBunsTest() {
        Bun bun = getBun();
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        Ingredient ingredient = getIngredient().get(0);
        burger.addIngredient(ingredient);
        assertEquals(List.of(ingredient), burger.ingredients);
    }

    @Test
    public void removeIngredientTest() {
        Ingredient ingredient1 = getIngredient().get(0);
        Ingredient ingredient2 = getIngredient().get(1);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(0);
        assertEquals(List.of(ingredient2), burger.ingredients);
    }

    @Test
    public void moveIngredientTest() {
        Ingredient ingredient1 = getIngredient().get(0);
        Ingredient ingredient2 = getIngredient().get(1);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals(List.of(ingredient2, ingredient1), burger.ingredients);
    }

    private Bun getBun() {
        Mockito.when(database.availableBuns()).thenReturn(List.of(new Bun("black bun", 100)));
        return database.availableBuns().get(0);
    }

    private List<Ingredient> getIngredient() {
        Mockito.when(database.availableIngredients()).thenReturn(List.of(
                new Ingredient(SAUCE, "hot sauce", 100),
                new Ingredient(FILLING, "cutlet", 100)));
        return database.availableIngredients();
    }
}
