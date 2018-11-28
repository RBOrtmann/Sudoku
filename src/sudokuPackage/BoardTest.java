package sudokuPackage;



import org.junit.*;

public class BoardTest {

	@Test
	public void testBoard() {
		Assert.fail("Not yet implemented");
	}

	@Test
	public void testPopulateInitialCells() {
		Assert.fail("Not yet implemented");
	}

	@Test
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
		Assert.assertEquals(5,b.getCell(1, 1));
	}

	@Test
	public void testGetCells() {
		Assert.fail("Not yet implemented");
	}

	@Test
	public void testChangeCell() {
//		String boardtest = "000000000/n"
//				+ "050000000/n"
//				+ "000000000/n"
//				+ "000000000/n"
//				+ "000000000/n"
//				+ "000000000/n"
//				+ "000000000/n"
//				+ "000000000/n"
//				+ "000000000/n";
//		Board b = new Board(boardtest);
		//b.changeCell(0, 0, 3);
		//assertEquals(3,b.changeCell(0, 0, 3));
		Assert.fail();
	}

	@Test
	public void testPrintBoard() {
		Assert.fail("Not yet implemented");
	}

	@Test
	public void testEqualsObject() {
		Assert.fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		Assert.fail("Not yet implemented");
	}

	@Test
	public void testObject() {
		Assert.fail("Not yet implemented");
	}

	@Test
	public void testGetClass() {
		Assert.fail("Not yet implemented");
	}

	@Test
	public void testHashCode() {
		Assert.fail("Not yet implemented");
	}

	@Test
	public void testEqualsObject1() {
		Assert.fail("Not yet implemented");
	}

	@Test
	public void testClone() {
		Assert.fail("Not yet implemented");
	}

	@Test
	public void testToString1() {
		Assert.fail("Not yet implemented");
	}

	@Test
	public void testNotify() {
		Assert.fail("Not yet implemented");
	}

	@Test
	public void testNotifyAll() {
		Assert.fail("Not yet implemented");
	}

	@Test
	public void testWaitLong() {
		Assert.fail("Not yet implemented");
	}

	@Test
	public void testWaitLongInt() {
		Assert.fail("Not yet implemented");
	}

	@Test
	public void testWait() {
		Assert.fail("Not yet implemented");
	}

	@Test
	public void testFinalize() {
		Assert.fail("Not yet implemented");
	}

}
