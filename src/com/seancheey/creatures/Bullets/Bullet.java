package com.seancheey.creatures.Bullets;

import java.awt.Point;

import com.seancheey.creatures.Creature;
import com.seancheey.entityAttributes.CreatureType;
import com.seancheey.entityAttributes.TypeGetter;
import com.seancheey.gui.Game.Game;

public class Bullet extends Creature {

	public Bullet() {
		this(new Point(0, 0), 0, 0, 1);
	}

	public Bullet(Point position, double vx, double vy) {
		this(position, vx, vy, 1);
	}

	public Bullet(Point position, double vx, double vy, int HP) {
		setType("bullet");
		setImage("resource/Bullet/avoiderBullet1.png");
		setWidth(11);
		setHeight(6);
		this.HP = HP;
		this.px = position.x;
		this.py = position.y;
		this.setVx(vx);
		this.setVy(vy);
		refreshRotation();
	}

	@Override
	public void collisionOperation(int id) {
		if (TypeGetter.getType(id) == CreatureType.BALL) {
			Game.map.getCreatureList().get(id).collisionOperation(getID());
		}
	}

	@Override
	public void deathOperation() {
		kill();
	}
}
