package sudokuPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameTest {


	@Test
	void testHasWonTrue() {
		String Easy2ans_first = "852716943"
				+ "197843652\n"
				+ "463925187\n"
				+ "278634591\n"
				+ "645179328\n"
				+ "931582476\n"
				+ "786491235\n"
				+ "314258769\n"
				+ "529367814\n";
		Board first = new Board(Easy2ans_first);
		
		String Easy2ans_second = "852716943"
				+ "197843652\n"
				+ "463925187\n"
				+ "278634591\n"
				+ "645179328\n"
				+ "931582476\n"
				+ "786491235\n"
				+ "314258769\n"
				+ "529367814\n";
		Board second = new Board(Easy2ans_second);
		assertTrue(first.equals(second));
	}

	@Test
	void testHasWonFalse() {
		String Easy2ans_first = "852716943"
				+ "097843652\n"
				+ "463925087\n"
				+ "278634591\n"
				+ "645179328\n"
				+ "931582476\n"
				+ "786491235\n"
				+ "314258769\n"
				+ "029367810\n";
		Board first = new Board(Easy2ans_first);
		
		String Easy2ans_second = "852716943"
				+ "197843652\n"
				+ "463925187\n"
				+ "278634591\n"
				+ "645179328\n"
				+ "931582476\n"
				+ "786491235\n"
				+ "314258769\n"
				+ "529367814\n";
		Board second = new Board(Easy2ans_second);
		assertTrue(first.equals(second));
	}

}
