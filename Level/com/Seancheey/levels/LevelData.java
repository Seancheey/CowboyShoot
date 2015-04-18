package com.Seancheey.levels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

import com.Seancheey.Creatures.Creature;
import com.Seancheey.Creatures.Balls.*;
import com.Seancheey.EntityAttributes.CreatureType;
import com.Seancheey.EntityAttributes.Entity;
import com.Seancheey.GUI.GuiTool;
import com.Seancheey.GUI.Game.GamePanel;
import com.Seancheey.mapAnalyser.MapData;

public abstract class LevelData implements MapData, CreatureCreator {
	protected ArrayList<Entity> entities=new ArrayList<Entity>(10);
	protected ArrayList<Creature> creatures=new ArrayList<Creature>(200);
	protected Image backgroundImage;
	protected String mapName;
	protected Dimension mapSize;
	protected Random r = new Random();
	private int id = -1;
	private Thread tester;

	public LevelData() {
		tester = new Thread() {
			@SuppressWarnings("deprecation")
			public void run() {
				for (;;) {
					try {
						sleep(200);
						if (testWin()) {
							winOperation();
							tester.suspend();
						} else if (testFail()) {
							failOperation();
							tester.suspend();
						}
					} catch (Exception e) {
					}
				}
			}
		};
		tester.start();
	}

	public int getID() {
		return id;
	}

	public void setID(int newID) {
		if (id == -1)
			id = newID;
		else
			System.out
					.println("com.Seancheey.levels.LevelData---setID---Map ID cannot be changed twice");
	}

	public void startRefreshAll() {
		for (int ba = 0; ba < creatures.size(); ba++) {
			creatures.get(ba).startRefresh();
		}
	}

	@SuppressWarnings("deprecation")
	protected void kill() {
		entities = null;
		creatures = null;
		backgroundImage = null;
		mapName = null;
		mapSize = null;
		try {
			tester.suspend();
		} catch (Exception e) {
		}
		tester = null;
	}

	public Dimension getSize() {
		return mapSize;
	}

	public String getName() {
		return mapName;
	}

	public Image getBackground() {
		return backgroundImage;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void clearCreatures() {
		for (int i = 0; i < creatures.size(); i++) {
			creatures.get(i).kill();
		}
		creatures.clear();
		creatures = new ArrayList<Creature>(300);
	}

	public ArrayList<Creature> getCreatureList() {
		return creatures;
	}

	protected abstract void failOperation();

	protected abstract void winOperation();

	protected abstract boolean testWin();

	protected abstract boolean testFail();

	@Override
	public void reset(int id, CreatureType type) {
		if (id >= 0) {
			// delete the creature from the RAM
			creatures.get(id).kill();
			// if the type of the creature is BALL:
			if (type == CreatureType.BALL) {
				// stop the previous ball
				creatures.get(id).kill();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// create random type of the ball
				String specificType;
				double seed = r.nextDouble();
				if (seed < 0.8)
					specificType = "normalBall";
				else if (seed < 0.83)
					specificType = "fastBall";
				else if (seed < 0.99)
					specificType = "charger";
				else
					specificType = "boss";
				// instantiate the new ball
				switch (specificType) {
				case ("boss"):
					creatures.set(id, new Boss());
					break;
				case ("fastBall"):
					creatures.set(id, new FastBall());
					break;
				case ("normalBall"):
					creatures.set(id, new NormalBall());
					break;
				case ("charger"):
					creatures.set(id, new Charger());
					break;
				default:
					System.out
							.println("com.Seancheey.levels.LevelData---reset---Unidentified BALL");
				}
			}
			// give ID and Start refreshing
			creatures.get(id).setID(id);
			creatures.get(id).startRefresh();
		}
	}

	@Override
	public void addNew(Creature newCreature) {
		creatures.add(newCreature);
		newCreature.setID(creatures.indexOf(newCreature));
	}

	public void paintMap(Graphics g) {
		g.drawImage(backgroundImage, 0, 0, GuiTool.fitWidth(900),
				GuiTool.fitHeight(600), GamePanel.game);

		for (int ba = 0; ba < entities.size(); ba++) {
			entities.get(ba).paint(g);
		}
		for (int ba = 0; ba < creatures.size(); ba++) {
			creatures.get(ba).paint(g);
		}
	}
}
