package com.seancheey.mapAnalyser;

import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;

import com.seancheey.entityAttributes.Entity;

public class Analyser implements MapData {
	private static ArrayList<Entity> entities = new ArrayList<Entity>();
	private static int width, height;
	private static Image background;
	private static String mapName;

	public static Entity getEntity(int id) {
		return entities.get(id);
	}

	Analyser(MapData data) {
		entities = data.getEntities();
		width = data.getSize().width;
		height = data.getSize().height;
		background = data.getBackground();
		mapName = data.getName();
	}

	@Override
	public Image getBackground() {
		return background;
	}

	@Override
	public ArrayList<Entity> getEntities() {
		return entities;
	}

	@Override
	public String getName() {
		return mapName;
	}

	@Override
	public Dimension getSize() {
		return new Dimension(width, height);
	}
}
