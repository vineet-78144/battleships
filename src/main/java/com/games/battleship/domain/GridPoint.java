package com.games.battleship.domain;

import com.games.battleship.util.AliveState;
import com.games.battleship.util.GridPointState;
import com.games.battleship.util.ShipAbsent;

public class GridPoint {

	private GridPointState state = new ShipAbsent();

	public void shoot() {
		state.next(this);
	}

	public void setState(GridPointState state) {
		this.state = state;
	}

	public GridPoint place() {
		this.setState(new AliveState());
		return this;
	}

	public String toString() {
		return this.state.toString();
	}

}
