package net.prieux.games.gameoflife.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private List<Cell> cells;
	
	public Board() {
		cells = new ArrayList<Cell>();
	}
	
	private Cell createCell(int x, int y) {
		Cell newCell = new Cell(x, y);
		cells.add(newCell);
		return newCell;
	}
	
	public List<Cell> getNeighbors(Cell cell) {
		List<Cell> neighbors = new ArrayList<Cell>();
		neighbors.add(cellAt(cell.getX() - 1, cell.getY() - 1));
		neighbors.add(cellAt(cell.getX() - 1, cell.getY()));
		neighbors.add(cellAt(cell.getX() - 1, cell.getY() + 1));
		neighbors.add(cellAt(cell.getX(), cell.getY() + 1));
		neighbors.add(cellAt(cell.getX() + 1, cell.getY() + 1));
		neighbors.add(cellAt(cell.getX() + 1, cell.getY()));
		neighbors.add(cellAt(cell.getX() + 1, cell.getY() - 1));
		neighbors.add(cellAt(cell.getX(), cell.getY() - 1));
		return neighbors;
	}
	
	public Cell cellAt(int x, int y) {
		for (Cell cell : cells) {
			if ((cell.getX() == x) && (cell.getY() == y)) {
				return cell;
			}
		}
		return createCell(x, y);
	}
	
	public List<Cell> getLiveCells() {
		List<Cell> liveCells = new ArrayList<Cell>();
		for (Cell cell : cells) {
			if (cell.isAlive()) {
				liveCells.add(cell);
			}
		}
		return liveCells;
	}
	
	public List<Cell> getCellsToConsider() {
		List<Cell> cellsToConsider = new ArrayList<Cell>();
		for (Cell cell : getLiveCells()) {
			if (!cellsToConsider.contains(cell)) {
				cellsToConsider.add(cell);
			}
			List<Cell> neighbors = getNeighbors(cell);
			for (Cell neighbor : neighbors) {
				if (!cellsToConsider.contains(neighbor)) {
					cellsToConsider.add(neighbor);
				}
			}
		}
		return cellsToConsider;
	}
	
	public List<Cell> getLiveNeighbors(Cell cell) {
		List<Cell> neighbors = getNeighbors(cell);
		List<Cell> liveNeighbors = new ArrayList<Cell>();
		for (Cell neighbor : neighbors) {
			if (neighbor.isAlive()) {
				liveNeighbors.add(neighbor);
			}
		}
		return liveNeighbors;
	}
}
