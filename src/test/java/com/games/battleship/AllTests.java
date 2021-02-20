package com.games.battleship;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.junit.*;

import com.games.battleship.domain.Player;
import com.games.battleship.game.GamePlay;

public class AllTests {

	GamePlay newGame;

	@Before
	public void setUp() throws Exception {
		StringBuilder consolidatedInputWithToken = new StringBuilder();
		try {
			FileInputStream fis = new FileInputStream("src/main/resources/playgame.txt");
			Scanner sc = new Scanner(fis);
			while (sc.hasNextLine()) {
				consolidatedInputWithToken.append(sc.nextLine() + "\n");
			}
			sc.close(); // closes the scanner
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] inputData = consolidatedInputWithToken.toString().split("\n");
		int gridSize = Integer.parseInt(inputData[0].trim());
		int totalShips = Integer.parseInt(inputData[1].trim());
		String p1ShipPositions = inputData[2];
		String p2ShipPositions = inputData[3];
		int totalMissiles = Integer.parseInt(inputData[4].trim());
		String p1HitMoves = inputData[5];
		String p2HitMoves = inputData[6];
		Player p1 = new Player.Builder(gridSize).positionShips(p1ShipPositions).totalMissiles(totalMissiles)
				.hitPositions(p2HitMoves).build();

		Player p2 = new Player.Builder(gridSize).positionShips(p2ShipPositions).totalMissiles(totalMissiles)
				.hitPositions(p1HitMoves).build();

		newGame = new GamePlay(p1, p2);
		newGame.play();
	}

	@After
	public void tearDown() throws Exception {
		newGame = null;
	}

	@Test
	public void testPlayer1TotalHits() {
		assertEquals("The total hits of player 1 are ", 2, newGame.getTotalHitsPlayer1());
	}

	@Test
	public void testPlayer2TotalHits() {
		assertEquals("The total hits of player 2 are ", 1, newGame.getTotalHitsPlayer2());
	}

	@Test
	public void testWhoWins() {
		assertEquals("Player 1 wins", newGame.result());
	}

}
