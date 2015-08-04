package com.seancheey.magic;

import java.awt.Image;
import java.awt.Toolkit;

import com.seancheey.entityAttributes.CreatureType;
import com.seancheey.entityAttributes.TypeGetter;
import com.seancheey.gui.Game.Game;
import com.seancheey.gui.Game.GamePanel;
import com.seancheey.gui.Game.Bar.StatusBar;

public abstract class Magic {
	private class CDHandler extends Thread {
		@Override
		public void run() {
			canUse = false;
			try {
				sleep(CD);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			canUse = true;
		}
	}

	public static Boom boom = new Boom();
	public static HallowRing hallowRing = new HallowRing();
	public static Heal heal = new Heal();
	public int hotKeyCode, MPUse, CD = 3000;
	public boolean canUse = true;
	private Image image;

	private Thread cDHandler = new CDHandler();

	public Magic(String imagePath, int hotKey, int MPuse, int CT) {
		image = Toolkit.getDefaultToolkit().getImage(imagePath);
		hotKeyCode = hotKey;
		MPUse = MPuse;
	}

	public void conjure() {
		if (canUse == true) {
			if (TypeGetter.getPlayer(0).MP >= MPUse) {
				cDHandler = new CDHandler();
				cDHandler.start();
				TypeGetter.getPlayer(0).MP -= MPUse;
				GamePanel.animation.newImage(image);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				execution();
				for (int ba = 0; ba < Game.map.getCreatureList().size(); ba++) {
					if (TypeGetter.getType(ba) == CreatureType.BALL)
						TypeGetter.getBall(ba).resetSize();
				}
				StatusBar.resetBar();
			} else {
				// System.out.println("You don't have enought MP");
			}
		} else {
			// System.out.println("Cooldown Time hasn't fnished yet");
		}
	}

	public abstract void execution();
}
