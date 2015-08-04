package com.Seancheey.EntityAttributes;

import com.Seancheey.Creatures.Players.Player;
import com.Seancheey.Creatures.Revivers.*;
import com.Seancheey.Creatures.Balls.*;
import com.Seancheey.Creatures.Bullets.Bullet;
import com.Seancheey.GUI.Game.Game;

public final class TypeGetter {

	public static CreatureType getType(int id) {
		String ST = getSpecificType(id);
		switch (ST) {
		case ("player"):
			return CreatureType.PLAYER;
		case ("normalBall"):
		case ("boss"):
		case ("fastBall"):
		case ("charger"):
			return CreatureType.BALL;
		case ("bullet"):
			return CreatureType.BULLET;
		case ("magicReviver"):
		case ("healthReviver"):
			return CreatureType.REVIVER;
		case ("ballSpawner"):
			return CreatureType.SPAWNER;
		case ("wall"):
			return CreatureType.WALL;
		default:
			System.out.println(
					"com.Seancheey.EntityAttributes.EntityList---getType---" + ST + " is an unidentified object");
			return CreatureType.NIL;
		}
	}

	public static String getSpecificType(int id) {
		return Game.map.getCreatureList().get(id).getType();
	}

	public static Player getPlayer(int id) {
		return (Player) Game.map.getCreatureList().get(id);
	}

	public static Ball getBall(int id) {
		return (Ball) Game.map.getCreatureList().get(id);
	}

	public static Bullet getBullet(int id) {
		return (Bullet) Game.map.getCreatureList().get(id);
	}

	public static Reviver getReviver(int id) {
		return (Reviver) Game.map.getCreatureList().get(id);
	}
}