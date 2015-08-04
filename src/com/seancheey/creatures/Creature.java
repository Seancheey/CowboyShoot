package com.seancheey.creatures;

import com.seancheey.entityAttributes.Entity;
import com.seancheey.gui.Game.Game;
import com.seancheey.timing.*;

public abstract class Creature extends Entity {
	private Timer normalTimer;

	public Creature() {
		normalTimer = new Timer(35, new NormalAction());
	}

	private class NormalAction implements RefreshAction {
		public void refreshAction() {
			if (HP > 0)
				detectCollision();
			else
				deathOperation();
		}
	}

	public void startRefresh() {
		timer.start();
		normalTimer.start();
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
						// if (Math.pow(EntityList.creatures.get(i)
						// .getCenterPosition().x - getCenterPosition().x,
						// 2)
						// + Math.pow(EntityList.creatures.get(i)
						// .getCenterPosition().y
						// - getCenterPosition().y, 2) <= (Math
						// .pow(EntityList.creatures.get(i).getWidth()
						// + getWidth(), 2) + Math.pow(
						// EntityList.creatures.get(i).getHeight()
						// + getHeight(), 2)) / 2)
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
		normalTimer.kill();
	}

	public void hurt(Creature aim, int damage) {
		aim.hurted(this, damage);
	}

	protected void hurted(Creature source, int damage) {
		HP -= damage;
	}

	public abstract void reset();

	protected abstract void deathOperation();

	protected abstract void makeMove();
}
