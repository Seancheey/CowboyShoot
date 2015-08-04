package com.seancheey.creatures.Balls;

import com.seancheey.entityAttributes.TypeGetter;

public class Charger extends Ball {
	private double v = 0, chargeTime = 2000, notifiedTime = 1000;

	public Charger() {
		setType("charger");
		setImage("resource/Ball/Zombie.png");
		chargeTime = 1800 + r.nextInt(400);
		notifiedTime = 1000;
		if (r.nextDouble() < 0.98)
			HP = 6 + r.nextInt(4);
		else {
			HP = 20 + r.nextInt(10);
			setImage("resource/Ball/Zombie1.png");
		}
		refreshRotation();
		resetSize();
		if (r.nextInt(2) == 1) {
			if (r.nextInt(2) == 1)
				py = 2;
			else
				py = 540 - getSize();
			px = (2 * r.nextDouble() - 1) * (585 - getSize());
		} else {
			if (r.nextInt(2) == 1)
				px = 2;
			else
				px = 880 - getSize();
			py = (2 * r.nextDouble() - 1) * (550 - getSize());
		}
	}

	@Override
	public void makeMove() {
		if (chargeTime <= 0) {
			v = 500;
			if (notifiedTime == 1000) {
				double angle = Math.atan2(TypeGetter.getPlayer(0).getCenterPosition().y - getCenterPosition().y,
						TypeGetter.getPlayer(0).getCenterPosition().x - getCenterPosition().x);
				setVx(v * Math.cos(angle));
				setVy(v * Math.sin(angle));
				refreshRotation();
			} else {
				// TODO ??
			}
		} else {
			v = 0.01;
			double angle = Math.atan2(TypeGetter.getPlayer(0).getCenterPosition().y - getCenterPosition().y,
					TypeGetter.getPlayer(0).getCenterPosition().x - getCenterPosition().x);
			setVx(v * Math.cos(angle));
			setVy(v * Math.sin(angle));
			refreshRotation();
		}
		// TODO fill the make move method
	}

}
