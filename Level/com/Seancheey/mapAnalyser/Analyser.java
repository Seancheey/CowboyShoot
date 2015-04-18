package com.Seancheey.mapAnalyser;

import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;

import com.Seancheey.EntityAttributes.Entity;

public class Analyser implements MapData{
	private static ArrayList<Entity> entities=new ArrayList<Entity>();
	private static int width,height;
	private static Image background;
	private static String mapName;
	Analyser(MapData data){
		entities=data.getEntities();
		width=data.getSize().width;
		height=data.getSize().height;
		background=data.getBackground();
		mapName=data.getName();
	}
	
	public static Entity getEntity(int id){
		return entities.get(id);
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
	public Dimension getSize() {
		return new Dimension(width,height);
	}

	@Override
	public String getName() {
		return mapName;
	}
}
