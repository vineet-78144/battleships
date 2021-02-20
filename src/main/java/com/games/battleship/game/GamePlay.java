package com.games.battleship.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import com.games.battleship.domain.Player;

public class GamePlay {

	private Player p1;
	private Player p2;

	public GamePlay(Player p1, Player p2) {
		super();
		this.p1 = p1;
		this.p2 = p2;
	}

	public void play() throws FileNotFoundException {
		p1.placeBattleShips();
		p2.placeBattleShips();
		p1.shootBattleships();
		p2.shootBattleships();
		PrintStream o = new PrintStream(new File("output.txt"));
		System.setOut(o);
		System.out.println("Player 1");
		p1.printGrid();
		System.out.println("Player 2");
		p2.printGrid();
		System.out.println("P1: " + p1.getTotalHits() + "\n");
		System.out.println("P2: " + p2.getTotalHits() + "\n");
		System.out.println(result());
	}

	public String result() {
		if (p1.getTotalHits() == p2.getTotalHits()) {
			return "It's a draw";
		} else if (p1.getTotalHits() < p2.getTotalHits()) {
			return "Player 2 wins";
		} else {
			return "Player 1 wins";
		}
	}
	
	public int getTotalHitsPlayer1() {
		return p1.getTotalHits();
	}
	
	public int getTotalHitsPlayer2() {
		return p2.getTotalHits();
	}

}
