package net.prieux.games.gameoflife.model;

import java.util.List;


public class Play {
	private Board board;
	
	public Play() {
		board = new Board();
	}
	
	public Board getBoard() {
		return board;
	}
	
	public void applyGameRules() {
		Board updatedBoard = new Board();
		List<Cell> cellsToConsider = board.getCellsToConsider();
		for (Cell cell : cellsToConsider) {
			Cell cellCopy = updatedBoard.cellAt(cell.getX(), cell.getY());
			if (board.getLiveNeighbors(cell).size() == 3) {
				cellCopy.setAlive();
			}
			else if (board.getLiveNeighbors(cell).size() == 2) {
				if (cell.isAlive()) {
					cellCopy.setAlive();
				}
			}
			else if (board.getLiveNeighbors(cell).size() < 2) {
				cellCopy.kill();
			}
			else if (board.getLiveNeighbors(cell).size() > 3) {
				cellCopy.kill();
			}
		}
		board = updatedBoard;
	}
	
	public void printCurrentBoard() {
		int minX = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int minY = Integer.MAX_VALUE;
		int maxY = Integer.MIN_VALUE;
		List<Cell> cellsToConsider = board.getCellsToConsider();
		for (Cell cell : cellsToConsider) {
			if (cell.getX() < minX) {
				minX = cell.getX();
			}
			if (cell.getX() > maxX) {
				maxX = cell.getX();
			}
			if (cell.getY() < minY) {
				minY = cell.getY();
			}
			if (cell.getY() > maxY) {
				maxY = cell.getY();
			}
		}
		System.out.println(minX + ", " + maxX + ", " + minY + ", " + maxY);
		for (int row = maxY ; row >= minY ; row--) {
			for (int column = minX ; column <= maxX ; column ++) {
				Cell cell = board.cellAt(column,  row);
				System.out.print(cell.isAlive() ? 'O' : ' ');
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Play play = new Play();
		// draw an heptomino PI of alive cells
		Cell cell1 = play.getBoard().cellAt(-1, 0);
		cell1.setAlive();
		Cell cell2 = play.getBoard().cellAt(-1, 1);
		cell2.setAlive();
		Cell cell3 = play.getBoard().cellAt(-1, 2);
		cell3.setAlive();
		Cell cell4 = play.getBoard().cellAt(0, 2);
		cell4.setAlive();
		Cell cell5 = play.getBoard().cellAt(1, 2);
		cell5.setAlive();
		Cell cell6 = play.getBoard().cellAt(1, 1);
		cell6.setAlive();
		Cell cell7 = play.getBoard().cellAt(1, 0);
		cell7.setAlive();
		play.printCurrentBoard();
		for (int i = 0 ; i < 110 ; i++) {
			play.applyGameRules();
		}
		// should display a clown's face!
		play.printCurrentBoard();
	}
}
