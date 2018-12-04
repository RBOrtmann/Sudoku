package sudokuPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoardTest {


	@Test
	void testGetCell() {
		String boardtest = "000000000\n"
				+ "050000000\n"
				+ "000000000\n"
				+ "000000000\n"
				+ "000000000\n"
				+ "000000000\n"
				+ "000000000\n"
				+ "000000000\n"
				+ "000000000\n";
		Board b = new Board(boardtest);
		assertEquals(5,b.getCell(1, 1));
	}


	@Test
	void testChangeCell() {
		String boardtest = "000000000\n"
				+ "050000000\n"
				+ "000000000\n"
				+ "000000000\n"
				+ "000000000\n"
				+ "000000000\n"
				+ "000000000\n"
				+ "000000000\n"
				+ "000000000\n";
		Board b = new Board(boardtest);
		b.changeCell(0, 0, 3);
		assertEquals(3,b.getCell(0, 0));
	}

}
