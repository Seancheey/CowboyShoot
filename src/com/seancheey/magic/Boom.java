package com.seancheey.magic;

import java.awt.event.KeyEvent;

import com.seancheey.entityAttributes.CreatureType;
import com.seancheey.entityAttributes.TypeGetter;
import com.seancheey.gui.Game.Game;
import com.seancheey.gui.Game.GameBar;

public class Boom extends Magic {

	public Boom() {
		super("resource/Magic/avoiderMagic1.png", KeyEvent.VK_Z, 35, 3000);
	}

	@Override
	public void execution() {
		for (int ba = 0; ba < Game.map.getCreatureList().size(); ba++) {
			if (TypeGetter.getType(ba) == CreatureType.BALL) {
				if (Game.map.getCreatureList().get(ba).HP >= 2) {
					Game.map.getCreatureList().get(ba).HP -= 2;
					GameBar.scoreBoard.scoreAdd(2);
				} else if (Game.map.getCreatureList().get(ba).HP == 1) {
					Game.map.getCreatureList().get(ba).HP -= 1;
					GameBar.scoreBoard.scoreAdd(1);
				}
			}
		}
	}
}
