package com.games.battleship.domain;

public final class Player {

	private GridPoint[][] grid;
	private int totalHits;
	private int gridSize;
	private String shipPositions;
	private int totalMissiles;
	private String hitMoves;

	private Player() {
	}

	public static class Builder {
		private int gridSize = 0;
		private String shipPositions;
		private int totalMissiles;
		private String hitMoves;

		public Builder(int gridSize) {
			this.gridSize = gridSize;

		}

		public Builder positionShips(String shipPositions) {
			this.shipPositions = shipPositions;

			return this;
		}

		public Builder totalMissiles(int totalMissiles) {
			this.totalMissiles = totalMissiles;

			return this;
		}

		public Builder hitPositions(String hitMoves) {
			this.hitMoves = hitMoves;

			return this;
		}

		public Player build() {
			Player player = new Player();
			player.gridSize = this.gridSize;
			player.shipPositions = this.shipPositions;
			player.totalMissiles = this.totalMissiles;
			player.hitMoves = this.hitMoves;
			player.grid = new GridPoint[gridSize][gridSize];
			for (int row = 0; row < player.grid.length; row++) {
				for (int col = 0; col < player.grid[row].length; col++) {
					player.grid[row][col] = new GridPoint();
				}
			}

			return player;
		}
	}

	public void placeBattleShips() {
		String[] shipsTokens = shipPositions.split(":");
		for (String firstLevelTokens : shipsTokens) {
			String[] secondLevelTokens = firstLevelTokens.split(",");
			int xpos = Integer.parseInt(secondLevelTokens[0].trim());
			int ypos = Integer.parseInt(secondLevelTokens[1].trim());
			this.grid[xpos][ypos].place();
		}

	}

	public void shootBattleships() {
		String[] hitsTokens = hitMoves.split(":");
		for (String firstLevelTokens : hitsTokens) {
			String[] secondLevelTokens = firstLevelTokens.split(",");
			int xpos = Integer.parseInt(secondLevelTokens[0].trim());
			int ypos = Integer.parseInt(secondLevelTokens[1].trim());
			this.grid[xpos][ypos].shoot();
		}
	}

	public void printGrid() {
		for (GridPoint[] row : grid) {
			printRow(row);
		}
		System.out.println("\n");
	}

	private void printRow(GridPoint[] row) {
		for (GridPoint gridPoint : row) {
			if ("X".equals(gridPoint.toString())) {
				++this.totalHits;
			}
			System.out.print(gridPoint);
			System.out.print("\t");
		}
		System.out.println();
	}

	public int getTotalHits() {
		return this.totalHits;
	}

}
