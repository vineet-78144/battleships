package com.games.battleship.util;

import com.games.battleship.domain.GridPoint;

public class DeadState implements GridPointState {
	public void next(GridPoint gridPoint) {
		gridPoint.setState(new DeadState());
	}
	public String toString() {
		return "X";
	}
}
