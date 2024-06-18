package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParamTest {
    private final String name;
    private final float price;

    public BunParamTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "название: {0}, цена: {1}")
    public static Object[][] data() {
        return new Object[][]{
                {"name", 100},
                {"", 100},
                {"ИмяНаимеованиеМногоМногоБукависимволов(!%?#", 100},
                {"name", 0},
                {"name", -1},
                {"name", 846548384.98f}
        };
    }

    @Test
    public void createBunTest() {
        Bun bun = new Bun(name, price);
        assertEquals(bun.getName(), name);
        assertEquals(bun.getPrice(), price, 0);
    }
}
