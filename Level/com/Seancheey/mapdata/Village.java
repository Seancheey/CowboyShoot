package com.Seancheey.mapdata;

import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;

import com.Seancheey.EntityAttributes.Entity;
import com.Seancheey.mapAnalyser.MapData;

public class Village implements MapData{

	@Override
	public Image getBackground() {
		return null;
	}

	@Override
	public ArrayList<Entity> getEntities() {
		return null;
	}

	@Override
	public Dimension getSize() {
		return new Dimension(900,600);
	}

	@Override
	public String getName() {
		return null;
	}
}
