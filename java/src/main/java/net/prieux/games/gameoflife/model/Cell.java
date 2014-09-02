package net.prieux.games.gameoflife.model;

public class Cell {
	private boolean alive;
	private Integer x = null;
	private Integer y = null;
	
	public Cell(int x, int y) {
		this.x = Integer.valueOf(x);
		this.y = Integer.valueOf(y);
	}
	
	public int getX() {
		return x.intValue();
	}
	
	public int getY() {
		return y.intValue();
	}
	
	public void setAlive() {
		this.alive = true;
	}
	
	public boolean isAlive() {
		return(this.alive);
	}

	public void kill() {
		this.alive = false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Cell other = (Cell) obj;
		if (x == null) {
			if (other.x != null) {
				return false;
			}
		} else if (!x.equals(other.x)) {
			return false;
		}
		if (y == null) {
			if (other.y != null) {
				return false;
			}
		} else if (!y.equals(other.y)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Cell [alive=" + alive + ", x=" + x + ", y=" + y + "]";
	}
}
