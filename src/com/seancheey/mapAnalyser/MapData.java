package com.seancheey.mapAnalyser;

import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;

import com.seancheey.entityAttributes.Entity;

public interface MapData {
	public Image getBackground();

	public ArrayList<Entity> getEntities();

	public String getName();

	public Dimension getSize();
}
