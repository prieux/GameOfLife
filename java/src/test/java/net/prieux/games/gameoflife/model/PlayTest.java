package net.prieux.games.gameoflife.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlayTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public final void testUpdateDeadToLive() {
		Play play = new Play();
		Board board = play.getBoard();
		Cell cell1 = board.cellAt(1, 0);
		cell1.setAlive();
		Cell cell2 = board.cellAt(-1, 0);
		cell2.setAlive();
		Cell cell3 = board.cellAt(-1, 1);
		cell3.setAlive();
		Cell cell = board.cellAt(0, 0);
		assertFalse(cell.isAlive());
		play.applyGameRules();
		cell = play.getBoard().cellAt(0, 0);
		assertTrue(cell.isAlive());
	}
	
	@Test
	public final void testUpdateWithoutChangeAliveCell() {
		Play play = new Play();
		Board board = play.getBoard();
		Cell cell1 = board.cellAt(1, 0);
		cell1.setAlive();
		Cell cell2 = board.cellAt(-1, 0);
		cell2.setAlive();
		Cell cell = board.cellAt(0, 0);
		cell.setAlive();
		assertTrue(cell.isAlive());
		play.applyGameRules();
		cell = play.getBoard().cellAt(0, 0);
		assertTrue(cell.isAlive());
	}
	
	@Test
	public final void testUpdateWithoutChangeDeadCell() {
		Play play = new Play();
		Board board = play.getBoard();
		Cell cell1 = board.cellAt(1, 0);
		cell1.setAlive();
		Cell cell2 = board.cellAt(-1, 0);
		cell2.setAlive();
		Cell cell = board.cellAt(0, 0);
		assertFalse(cell.isAlive());
		play.applyGameRules();
		cell = play.getBoard().cellAt(0, 0);
		assertFalse(cell.isAlive());
	}
	
	@Test
	public final void testUpdateCellIsKilledWithTooFewLiveNeighbors() {
		Play play = new Play();
		Board board = play.getBoard();
		Cell cell1 = board.cellAt(-1, 0);
		cell1.setAlive();
		Cell cell = board.cellAt(0, 0);
		cell.setAlive();
		assertTrue(cell.isAlive());
		play.applyGameRules();
		cell = play.getBoard().cellAt(0, 0);
		assertFalse(cell.isAlive());
	}
	
	@Test
	public final void testUpdateCellIsKilledWithTooManyLiveNeighbors() {
		Play play = new Play();
		Board board = play.getBoard();
		Cell cell1 = board.cellAt(-1, 0);
		cell1.setAlive();
		Cell cell2 = board.cellAt(-1, 1);
		cell2.setAlive();
		Cell cell3 = board.cellAt(0, 1);
		cell3.setAlive();
		Cell cell4 = board.cellAt(1, 1);
		cell4.setAlive();
		Cell cell = board.cellAt(0, 0);
		cell.setAlive();
		assertTrue(cell.isAlive());
		play.applyGameRules();
		cell = play.getBoard().cellAt(0, 0);
		assertFalse(cell.isAlive());
	}
}
