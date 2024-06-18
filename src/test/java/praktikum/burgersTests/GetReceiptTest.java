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

public class GetReceiptTest {
    private final Burger burger = new Burger();
    Database database = Mockito.mock(Database.class);

    @Test
    public void getReceiptTest() {
        burger.setBuns(getBun());
        burger.addIngredient(getIngredient().get(0));
        burger.addIngredient(getIngredient().get(1));
        String actual = burger.getReceipt();
        assertEquals(getExpected(), actual);
    }

    private String getExpected() {
        return "(==== black bun ====)\r\n" +
                "= sauce hot sauce =\r\n" +
                "= filling cutlet =\r\n" +
                "(==== black bun ====)\r\n" +
                "\r\n" +
                "Price: 400,000000\r\n";
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
