package praktikum.burgersTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class GetPriceTest {
    private final float bunPrice;
    private final float ingredient1Price;
    private final float ingredient2Price;
    private final float ingredient3Price;
    private final float expected;
    private final Burger burger = new Burger();

    public GetPriceTest(float bunPrice, float ingredient1Price, float ingredient2Price, float ingredient3Price,
                        float expected) {
        this.bunPrice = bunPrice;
        this.ingredient1Price = ingredient1Price;
        this.ingredient2Price = ingredient2Price;
        this.ingredient3Price = ingredient3Price;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "cost of ingredients: bun - {0}, tomato sauce - {1}, beef cutlet - {2}, cheese - {3}; burger cost: {4}")
    public static Object[][] data() {
        return new Object[][]{
                {100f, 100f, 0, 0, 300f},
                {100f, 100f, 100f, 0, 400f},
                {100f, 100f, 100f, 100f, 500f},
                {5f, 1.2f, 6.4f, 9.1f, 26.7f},
                {16.9f, 3f, -72.3f, 0.9f, -34.6f},
                {16.9f, 0, 0, 0, 33.8f}
        };
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(new Bun("bun with sesame seeds", bunPrice));
        burger.addIngredient(new Ingredient(SAUCE, "tomato sauce", ingredient1Price));
        burger.addIngredient(new Ingredient(FILLING, "beef cutlet", ingredient2Price));
        burger.addIngredient(new Ingredient(FILLING, "cheese", ingredient3Price));
        float actual = burger.getPrice();
        assertEquals(expected, actual, 0.00001);
    }
}
