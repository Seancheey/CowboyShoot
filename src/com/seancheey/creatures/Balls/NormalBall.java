package com.seancheey.creatures.Balls;

public class NormalBall extends Ball {

	public NormalBall() {
		setType("normalBall");
		setImage("resource/Ball/avoiderBall" + 6 + ".png");
		reset();
	}

	public void reset() {
		setVx((2 * r.nextDouble() - 1) * 100);
		setVy((2 * r.nextDouble() - 1) * 100);
		HP = 1 + r.nextInt(10);
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
}
