package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientParamTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientParamTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "тип: {0}, наименование: {1}, цена: {2}")
    public static Object[][] data() {
        return new Object[][]{
                {SAUCE, "cheese", 10},
                {FILLING, "", 10},
                {SAUCE, "большущееееееееееееееколиииииииииииичествоБуквисимволос%^*@", -29454},
                {FILLING, "", 846548384.98f}
        };
    }

    @Test
    public void IngredientCreateTests() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(ingredient.getName(), name);
        assertEquals(ingredient.getPrice(), price, 0);
        assertEquals(ingredient.getType(), type);
    }
}
