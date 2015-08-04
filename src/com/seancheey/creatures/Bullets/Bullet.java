package com.seancheey.creatures.Bullets;

import java.awt.*;

import com.seancheey.creatures.Creature;
import com.seancheey.entityAttributes.CreatureType;
import com.seancheey.entityAttributes.TypeGetter;
import com.seancheey.gui.*;
import com.seancheey.gui.Game.Game;

public class Bullet extends Creature {

	public Bullet() {
		setType("bullet");
		setImage("resource/Bullet/avoiderBullet1.png");
		setWidth(11);
		setHeight(6);
		reset();
	}

	public void shooted(double direction, Creature source, int velocity) {
		setVx(Math.cos(direction) * velocity + source.getVx());
		setVy(Math.sin(direction) * velocity + source.getVy());
		px = source.getCenterPosition().x;
		py = source.getCenterPosition().y;
		HP = 1;
		refreshRotation();
	}

	public void reset(Point position, double vx, double vy) {
		HP = 1;
		this.px = position.x;
		this.py = position.y;
		this.setVx(vx);
		this.setVy(vy);
		refreshRotation();
	}

	public void makeMove() {
		if (px < MainFrame.frameSize.width - getWidth() - 15 && px > 0)
			px += getVx() / 1000 * timer.getDelay();
		else
			remove();
		if (py < MainFrame.frameSize.height - getHeight() - 50 && py > 0)
			py += getVy() / 1000 * timer.getDelay();
		else
			remove();
	}

	public void deathOperation() {
		kill();
	}

	public void collisionOperation(int id) {
		if (TypeGetter.getType(id) == CreatureType.BALL) {
			Game.map.getCreatureList().get(id).collisionOperation(getID());
		}
	}

	public void reset() {
		remove();
	}

	public void refreshAction() {
		makeMove();
	}
}
