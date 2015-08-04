package com.seancheey.magic;

import java.awt.event.KeyEvent;
import com.seancheey.entityAttributes.TypeGetter;

public class HallowRing extends Magic {

	public HallowRing() {
		super("resource/Magic/avoiderMagic2.png", KeyEvent.VK_X, 40, 5000);
	}

	public void execution() {
		double angle = 0;
		for (int ba = 0; ba < 50; ba++) {
			angle += 2 * Math.PI / 50;
			TypeGetter.getPlayer(0).shootPress(angle);
		}
	}
}
