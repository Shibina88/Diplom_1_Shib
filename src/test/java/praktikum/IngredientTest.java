package praktikum;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {
    Database database = Mockito.mock(Database.class);

    @Test
    public void getPriceTest() {
        Ingredient ingredient = getIngredient().get(0);
        assertEquals(ingredient.getPrice(), 100, 0);
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = getIngredient().get(1);
        assertEquals(ingredient.getName(), "cutlet");
    }


    @Test
    public void getTypeFillingTest() {
        Ingredient ingredient = getIngredient().get(1);
        assertEquals(ingredient.getType(), FILLING);
    }
    @Test
    public void getTypeSauceTest() {
        Ingredient ingredient = getIngredient().get(0);
        assertEquals(ingredient.getType(), SAUCE);
    }

    private List<Ingredient> getIngredient() {
        Mockito.when(database.availableIngredients()).thenReturn(List.of(
                new Ingredient(SAUCE, "hot sauce", 100),
                new Ingredient(FILLING, "cutlet", 100)));
        return database.availableIngredients();
    }
}
