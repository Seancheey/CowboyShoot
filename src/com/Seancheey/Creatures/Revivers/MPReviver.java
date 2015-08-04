package com.Seancheey.Creatures.Revivers;

import com.Seancheey.EntityAttributes.TypeGetter;
import com.Seancheey.EntityAttributes.CreatureType;
import com.Seancheey.GUI.Game.Bar.StatusBar;

public class MPReviver extends Reviver{

	public MPReviver() {
		setType("MPReviver");
		setImage("resource/Reviver/avoiderReviver2.png");
		reset();
	}
	
	public void collisionOperation(int id) {
		super.collisionOperation(id);
		if(TypeGetter.getType(id)==CreatureType.PLAYER){
			TypeGetter.getPlayer(id).MP+=30;
			if(TypeGetter.getPlayer(id).MP>TypeGetter.getPlayer(id).maxMP)
				TypeGetter.getPlayer(id).MP=TypeGetter.getPlayer(id).maxMP;
			StatusBar.setMagic(TypeGetter.getPlayer(id).MP);
		}
	}
}
