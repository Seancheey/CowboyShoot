package com.seancheey.creatures.Balls;

import com.seancheey.entityAttributes.CreatureType;
import com.seancheey.entityAttributes.TypeGetter;
import com.seancheey.gui.Game.Game;
import com.seancheey.gui.Game.GameBar;

public class Boss extends Ball {
	public int v = 150;

	public Boss() {
		setType("boss");
		setImage("resource/Ball/avoiderBall" + 5 + ".png");
		reset();
	}

	@Override
	public void collisionOperation(int id) {
		if (TypeGetter.getType(id) == CreatureType.BULLET) {
			HP -= 1;
			Game.map.getCreatureList().get(id).addHP(-1);
			GameBar.scoreBoard.scoreAdd(1);
		}
	}

	@Override
	public void makeMove() {
		double angle = Math.atan2(TypeGetter.getPlayer(0).getCenterPosition().y - getCenterPosition().y,
				TypeGetter.getPlayer(0).getCenterPosition().x - getCenterPosition().x);
		setVx(v * Math.cos(angle));
		setVy(v * Math.sin(angle));
		refreshRotation();
	}

	public void reset() {
		HP = 50 + r.nextInt(20);
		refreshRotation();
		setSize(HP * 5);
		if (r.nextInt(2) == 1) {
			if (r.nextInt(2) == 1)
				py = -250;
			else
				py = 600;
			px = (2 * r.nextDouble() - 1) * 600;
		} else {
			if (r.nextInt(2) == 1)
				px = -250;
			else
				px = 900;
			py = (2 * r.nextDouble() - 1) * 600;
		}
	}

	@Override
	public void resetSize() {
	}
}
