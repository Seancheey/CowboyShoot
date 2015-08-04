package com.seancheey.creatures.Balls;

import java.util.Random;

import com.seancheey.creatures.Creature;
import com.seancheey.entityAttributes.TypeGetter;
import com.seancheey.entityAttributes.CreatureType;
import com.seancheey.gui.Game.Game;
import com.seancheey.gui.Game.GameBar;

public abstract class Ball extends Creature {
	protected static Random r = new Random();

	public Ball() {

	}

	public void resetSize() {
		int previousSize = getSize();
		setSize(HP * 10);
		px += (previousSize - getSize()) / 2;
		py += (previousSize - getSize()) / 2;
	}

	public void refreshAction() {
		makeMove();
	}

	public int getSize() {
		return getWidth();
	}

	public void collisionOperation(int id) {
		if (TypeGetter.getType(id) == CreatureType.BULLET) {
			HP -= 1;
			hurt(Game.map.getCreatureList().get(id), 1);
			Game.map.getCreatureList().get(id).hurt(this, 1);
			GameBar.scoreBoard.scoreAdd(1);
			resetSize();
		}
	}

	public void deathOperation() {

		kill();
	}
}
