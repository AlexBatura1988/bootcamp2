package junit;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_METHOD)
class ColorTest {

	private final static int SIZE = 3;
	Color[] colorArr;
	Color[] expectedColorArr;

	public ColorTest() {
		colorArr = new Color[SIZE];
		colorArr[0] = new Color(20, 20, 20);
		colorArr[1] = new Color(0, 0, 0);
		colorArr[2] = new Color(30, 30, 30);
		expectedColorArr = new Color[SIZE];
	}

	void expectedColors() {
		expectedColorArr[0] = new Color(20, 20, 20);
		expectedColorArr[1] = new Color(0, 0, 0);
		expectedColorArr[2] = new Color(30, 30, 30);
	}

	@Test
	void testColorNull() {
		for (Color color : colorArr) {
			assertNotNull(color);
		}
	}

	@Test
	void equalityColorFields() {
		expectedColors();

		for (int i = 0; i < colorArr.length; i++) {
			assertEquals(expectedColorArr[i].getBlue(), colorArr[i].getBlue());
			assertEquals(expectedColorArr[i].getRed(), colorArr[i].getRed());
			assertEquals(expectedColorArr[i].getGreen(), colorArr[i].getGreen());
		}
	}

}
