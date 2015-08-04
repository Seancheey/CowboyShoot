package com.seancheey.creatures.Spawner;

import java.awt.Point;

import com.seancheey.creatures.Balls.Ball;
import com.seancheey.creatures.Balls.Boss;
import com.seancheey.creatures.Balls.Charger;
import com.seancheey.creatures.Balls.FastBall;
import com.seancheey.creatures.Balls.NormalBall;
import com.seancheey.gui.Game.Game;

public class BallSpawner extends Spawner {

	public BallSpawner() {
		this(0, 0);
	}

	public BallSpawner(int px, int py) {
		this(px, py, 10000);
	}

	public BallSpawner(int px, int py, int spawnInterval) {
		this(px, py, spawnInterval, new String[] { "normalBall", "fastBall", "charger" });
	}

	public BallSpawner(int px, int py, int spawnInterval, String[] spawnList) {
		super(px, py, spawnInterval, spawnList);
		setImage("resource/Reviver/avoiderReviver1.png");
		setType("ballSpawner");
		visible = true;
	}

	@Override
	protected void spawn(Point position) {
		// create a new ball
		Ball newBall;
		int seed = r.nextInt(spawnList.length);
		String specificType = spawnList[seed];
		switch (specificType) {
		case ("normalBall"):
			newBall = new NormalBall();
			break;
		case ("boss"):
			newBall = new Boss();
			break;
		case ("fastBall"):
			newBall = new FastBall();
			break;
		case ("charger"):
			newBall = new Charger();
			break;
		default:
			newBall = new NormalBall();
		}
		newBall.setPosition(position.x - newBall.getWidth() / 2, position.y - newBall.getHeight() / 2);
		Game.map.addNew(newBall);
	}
}