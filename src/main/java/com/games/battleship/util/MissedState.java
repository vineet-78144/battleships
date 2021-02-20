package com.games.battleship.util;

import com.games.battleship.domain.GridPoint;

public class MissedState implements GridPointState {
	public void next(GridPoint gridPoint) {
		gridPoint.setState(new MissedState());
	}
	public String toString() {
		return "O";
	}
}
