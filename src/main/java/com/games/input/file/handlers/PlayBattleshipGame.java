package com.games.input.file.handlers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.games.battleship.domain.Player;
import com.games.battleship.game.GamePlay;

public class PlayBattleshipGame {

	public static void main(String[] args) throws FileNotFoundException {

		if ((args == null) || (args.length == 0)) {
			System.out.println("You need to specify a path to input file!");
			return;
		}

		StringBuilder consolidatedInputWithToken = new StringBuilder();

		try {
			FileInputStream fis = new FileInputStream(args[0]);
			Scanner sc = new Scanner(fis);
			while (sc.hasNextLine()) {
				consolidatedInputWithToken.append(sc.nextLine() + "\n");
			}
			sc.close(); // closes the scanner
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

			GamePlay newGame = new GamePlay(p1, p2);
			newGame.play();
		} catch (Exception e) {
			System.out.println("File Parsing/System Error");
		}

	}
}
