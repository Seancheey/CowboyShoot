package com.seancheey.creatures.Walls;

import com.seancheey.creatures.Creature;
import com.seancheey.gui.Game.Game;

public class Wall extends Creature {

	public Wall(int px, int py, int width, int height) {
		this(px, py, width, height, "resource/Wall/wall1.png");
	}

	public Wall(int px, int py, int width, int height, String imagePath) {
		this.px = px;
		this.py = py;
		this.setSize(width, height);
		this.setImage(imagePath);
		setType("wall");
	}

	@Override
	public void refreshAction() {
	}

	@Override
	public void reset() {
	}

	@Override
	public void deathOperation() {
	}

	@Override
	public void makeMove() {
	}

	@Override
	public void collisionOperation(int id) {
		// if collide horizontally, vx*=-1
		if (Math.abs(Game.map.getCreatureList().get(id).getCenterPosition().x
				- getCenterPosition().x) <= (double) (Game.map.getCreatureList().get(id).getWidth() + getWidth()) / 2) {

			Game.map.getCreatureList().get(id).setVx(Game.map.getCreatureList().get(id).getVx() * -1);
		} else
			// if collide vertically, vy*=-1
			if (Math.abs(Game.map.getCreatureList().get(id).getCenterPosition().y
					- getCenterPosition().y) <= (double) (Game.map.getCreatureList().get(id).getHeight() + getHeight())
							/ 2) {

			Game.map.getCreatureList().get(id).setVy(Game.map.getCreatureList().get(id).getVy() * -1);
		}
	}
}
