package sudokuPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoardTest {
/*
 * 	@Test
	public void testGetCell() {
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
	public void testGetCells() {
		fail("Not yet implemented");
	}

	@Test
	public void testChangeCell() {
		String boardtest = "000000000/n"
				+ "050000000/n"
				+ "000000000/n"
				+ "000000000/n"
				+ "000000000/n"
				+ "000000000/n"
				+ "000000000/n"
				+ "000000000/n"
				+ "000000000/n";
		Board b = new Board(boardtest);
		b.changeCell(0, 0, 3);
		assertEquals(3,b.getCell(1, 1));
		//assertEquals(3,b.changeCell(0, 0, 3));
		//Assert.fail();
	}
 */

	@Test
	void testPopulateInitialCells() {
		fail("Not yet implemented");
	}

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
	void testGetCells() {
		fail("Not yet implemented");
	}

	@Test
	void testChangeCell() {
		fail("Not yet implemented");
	}

	@Test
	void testPrintBoard() {
		fail("Not yet implemented");
	}

	@Test
	void testEqualsObject() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

}
