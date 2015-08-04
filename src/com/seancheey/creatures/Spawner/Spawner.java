package com.seancheey.creatures.Spawner;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import com.seancheey.creatures.Creature;
import com.seancheey.entityAttributes.CreatureType;
import com.seancheey.entityAttributes.TypeGetter;
import com.seancheey.gui.Game.Game;

public abstract class Spawner extends Creature {
	protected final Random r = new Random();
	protected boolean visible = false;
	protected boolean invulnerable = true;
	protected boolean respawnable = false;
	protected int spawnRadius = 30, spawnInterval = 10000;
	protected String[] spawnList;
	// the left time of spawning the next creature
	private int leftTime = 10000;

	public Spawner() {
		setType("spawner");
		setSize(50, 50);
	}

	public Spawner(int px, int py, int spawnInterval, String[] spawnList) {
		this.px = px;
		this.py = py;
		this.spawnInterval = spawnInterval;
		this.spawnList = spawnList;
	}

	@Override
	public void collisionOperation(int id) {
		if (!invulnerable) {
			if (TypeGetter.getType(id) == CreatureType.BULLET) {
				HP -= 1;
				Game.map.getCreatureList().get(id).HP -= 1;
			}
		}
	}

	private Point createRandomSpawnPoint() {
		double angle = r.nextDouble() * 2 * Math.PI;
		double radius = r.nextDouble() * spawnRadius;
		return new Point(getCenterPosition().x + (int) (radius * Math.cos(angle)),
				getCenterPosition().y + (int) (radius * Math.sin(angle)));
	}

	@Override
	public void makeMove() {
		if (leftTime <= 0) {
			resetLeftTime();
			spawn(createRandomSpawnPoint());
		}
	}

	@Override
	public void paint(Graphics g) {
		if (visible) {
			super.paint(g);
		}
	}

	private void resetLeftTime() {
		leftTime = spawnInterval + (int) (0.15 * spawnInterval * (r.nextDouble() * 2 - 1));
	}

	public void setType(String[] type) {
		spawnList = type;
	}

	protected abstract void spawn(Point position);
}
