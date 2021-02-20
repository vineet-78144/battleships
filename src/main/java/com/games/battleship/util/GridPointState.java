package com.games.battleship.util;

import com.games.battleship.domain.GridPoint;

public interface GridPointState {
	void next(GridPoint gridPoint);
	String toString();
}
