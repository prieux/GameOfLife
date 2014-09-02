package net.prieux.games.gameoflife.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGetCellOnBoard() {
		Board board = new Board();
		assertTrue(board.cellAt(-2, 10) != null);
	}
	
	@Test
	public final void testNeighborCellsContainAllNeighbors() {
		Board board = new Board();
		Cell cell = board.cellAt(3, 10);
		List<Cell> neighbors = board.getNeighbors(cell);
		Cell neighbor1 = new Cell(2, 11);
		assertTrue(neighbors.contains(neighbor1));
		Cell neighbor2 = new Cell(3, 11);
		assertTrue(neighbors.contains(neighbor2));
		Cell neighbor3 = new Cell(4, 11);
		assertTrue(neighbors.contains(neighbor3));
		Cell neighbor4 = new Cell(4, 10);
		assertTrue(neighbors.contains(neighbor4));
		Cell neighbor5 = new Cell(4, 9);
		assertTrue(neighbors.contains(neighbor5));
		Cell neighbor6 = new Cell(3, 9);
		assertTrue(neighbors.contains(neighbor6));
		Cell neighbor7 = new Cell(2, 9);
		assertTrue(neighbors.contains(neighbor7));
		Cell neighbor8 = new Cell(2, 10);
		assertTrue(neighbors.contains(neighbor8));
	}
	
	@Test
	public final void testGetLiveCellsCount() {
		Board board = new Board();
		Cell cell1 = board.cellAt(0, 0);
		cell1.setAlive();
		Cell cell2 = board.cellAt(10, 0);
		cell2.setAlive();
		Cell cell3 = board.cellAt(-6, 6);
		cell3.setAlive();
		Cell cell4 = board.cellAt(20, 7);
		cell4.setAlive();
		Cell cell5 = board.cellAt(13, -45);
		cell5.setAlive();
		assertEquals(5, board.getLiveCells().size());
	}
	
	@Test
	public final void testGetCellsToConsider() {
		Board board = new Board();
		Cell cell1 = board.cellAt(0, 0);
		cell1.setAlive();
		Cell cell2 = board.cellAt(-1, 0);
		cell2.setAlive();
		Cell cell3 = board.cellAt(-1, -1);
		cell3.setAlive();
		Cell cell4 = board.cellAt(-1, -2);
		cell4.setAlive();
		Cell cell5 = board.cellAt(1, 0);
		cell5.setAlive();
		Cell cell6 = board.cellAt(1, -1);
		cell6.setAlive();
		Cell cell7 = board.cellAt(1, -2);
		cell7.setAlive();
		assertEquals(25, board.getCellsToConsider().size());
	}
	
	@Test
	public final void testGetLiveNeighbors() {
		Board board = new Board();
		Cell cell1 = board.cellAt(0, 0);
		cell1.setAlive();
		Cell cell2 = board.cellAt(-1, 0);
		cell2.setAlive();
		Cell cell3 = board.cellAt(-1, -1);
		cell3.setAlive();
		Cell cell = board.cellAt(0, -1);
		assertTrue(board.getLiveNeighbors(cell).size() == 3);
	}
}
