package com.seancheey.creatures;

import com.seancheey.entityAttributes.Entity;
import com.seancheey.gui.Game.Game;

public abstract class Creature extends Entity {

	public Creature() {

	}

	private void detectCollision() {
		for (int i = 0; i < Game.map.getCreatureList().size(); i++) {
			if (Math.abs(Game.map.getCreatureList().get(i).getCenterPosition().x
					- getCenterPosition().x) <= (double) (Game.map.getCreatureList().get(i).getWidth() + getWidth())
							/ 2)
				if (Math.abs(Game.map.getCreatureList().get(i).getCenterPosition().y
						- getCenterPosition().y) <= (double) (Game.map.getCreatureList().get(i).getHeight()
								+ getHeight()) / 2)
					if (i != getID())
						if (Game.map.getCreatureList().get(i).HP > 0)
							collisionOperation(i);
		}
	}

	public int getMaxHealth() {
		return maxHP;
	}

	public void addHP(int addValue) {
		HP += addValue;
	}

	public void kill() {
		super.kill();
	}

	public void hurt(Creature aim, int damage) {
		aim.hurted(this, damage);
	}

	protected void hurted(Creature source, int damage) {
		HP -= damage;
	}

	protected void deathOperation() {
	}

	public void makeMove() {
		px += vx;
		py += vy;
		if (HP > 0)
			detectCollision();
		else
			deathOperation();
	}
}
