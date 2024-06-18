package praktikum;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BunTest {

    Database database = Mockito.mock(Database.class);

    @Test
    public void getNameTest() {
        Bun bun = getBun();
        String actual = bun.getName();
        assertEquals("black bun", actual);
    }

    @Test
    public void getPriceTest() {
        Bun bun = getBun();
        float actual = bun.getPrice();
        assertEquals(100, actual, 0);
    }

    private Bun getBun() {
        Mockito.when(database.availableBuns()).thenReturn(List.of(new Bun("black bun", 100)));
        return database.availableBuns().get(0);
    }
}
