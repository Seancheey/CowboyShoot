package com.seancheey.creatures.Revivers;

import com.seancheey.entityAttributes.TypeGetter;
import com.seancheey.entityAttributes.CreatureType;
import com.seancheey.gui.Game.Bar.StatusBar;

public class HPReviver extends Reviver {

	public HPReviver() {
		setType("HPReviver");
		setImage("resource/Reviver/avoiderReviver1.png");
		reset();
	}

	public void collisionOperation(int id) {
		super.collisionOperation(id);
		if (TypeGetter.getType(id) == CreatureType.PLAYER) {
			TypeGetter.getPlayer(id).addHP(5);
			if (TypeGetter.getPlayer(id).HP > TypeGetter.getPlayer(id).getMaxHealth())
				TypeGetter.getPlayer(id).HP = TypeGetter.getPlayer(id).getMaxHealth();
			StatusBar.setHealth(TypeGetter.getPlayer(id).HP);
		}
	}
}
