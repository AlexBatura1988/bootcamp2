package exam3;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class Tests {

	@Test
    public void testFoodIsDesert() throws NonCapatilizedException {
        Food food1 = new Food("Apple", Taste.SWEET, MacronutrientsCategory.CARBOHYDRATE);
        Food food2 = new Food("Salmon", Taste.SALTY, MacronutrientsCategory.PROTEIN);
        assertEquals(true, food1.isDesert());
        assertEquals(false, food2.isDesert());
    }
	
	@Test
    public void testFoodSetName() {
        assertThrows(NonCapatilizedException.class, () -> {
             new Food("apple", Taste.SWEET, MacronutrientsCategory.CARBOHYDRATE);
        });
        assertDoesNotThrow(() -> {
             new Food("Apple", Taste.SWEET, MacronutrientsCategory.CARBOHYDRATE);
        });
    }
	
	 @Test
	    public void testDragonBirthDate() {
	        assertThrows(TooYoungException.class, () -> {
	            new Dragon("dragon1", LocalDate.of(888, 8,9), 5);
	        });
	        assertDoesNotThrow(() -> {
	             new Dragon("dragon2", LocalDate.of(888, 8,8), 5);
	        });
	    }

}
