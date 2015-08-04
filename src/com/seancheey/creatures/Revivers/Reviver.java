package com.Seancheey.Creatures.Revivers;

import java.util.Random;
import com.Seancheey.Creatures.Creature;
import com.Seancheey.EntityAttributes.CreatureType;
import com.Seancheey.EntityAttributes.TypeGetter;

public abstract class Reviver extends Creature {
	private Random r = new Random();
	protected int disappearTime = 10000;
	private int timeLeft = disappearTime;

	public Reviver() {
		setSize(40);
		reset();
	}

	public void refreshAction() {
		timeLeft -= timer.getDelay();
		if (timeLeft <= 0)
			kill();
	}

	public void deathOperation() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		reset();
	}

	public void makeMove() {
	}

	public void reset() {
		px = r.nextDouble() * (660);
		py = r.nextDouble() * (510);
		HP = 1;
	}

	public void collisionOperation(int id) {
		if (TypeGetter.getType(id) == CreatureType.PLAYER) {
			kill();
		}
	}
}
