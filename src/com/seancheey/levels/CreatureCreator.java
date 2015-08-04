package com.seancheey.levels;

import java.util.ArrayList;

import com.seancheey.creatures.Creature;
import com.seancheey.entityAttributes.CreatureType;

public interface CreatureCreator {
	public void addNew(Creature newCreature);

	public ArrayList<Creature> getCreatureList();

	public void reset(int id, CreatureType type);
}
