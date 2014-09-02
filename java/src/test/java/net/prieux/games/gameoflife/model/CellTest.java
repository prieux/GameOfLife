package net.prieux.games.gameoflife.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CellTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testSetCellAlive() {
		Cell cell = new Cell(0, 0);
		cell.setAlive();
		assertTrue(cell.isAlive());
	}
	
	@Test
	public final void testKillCell() {
		Cell cell = new Cell(0, 0);
		cell.kill();
		assertFalse(cell.isAlive());
	}
	
	@Test
	public final void testCreateCellWithCoords() {
		Cell cell = new Cell(0, 0);
		assertEquals(cell.getX(), 0);
		assertEquals(cell.getY(), 0);
	}
	
	@Test
	public final void testCreateCellWithNegativeCoords() {
		Cell cell = new Cell(-10, -3);
		assertEquals(cell.getX(), -10);
		assertEquals(cell.getY(), -3);
	}
}
