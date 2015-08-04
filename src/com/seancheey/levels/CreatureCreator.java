package com.Seancheey.levels;

import java.util.ArrayList;
import com.Seancheey.Creatures.Creature;
import com.Seancheey.EntityAttributes.CreatureType;

public interface CreatureCreator {
	public void reset(int id, CreatureType type);

	public ArrayList<Creature> getCreatureList();

	public void addNew(Creature newCreature);
}
