package com.Seancheey.mapAnalyser;

import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;
import com.Seancheey.EntityAttributes.Entity;

public interface MapData {
	public Image getBackground();
	public ArrayList<Entity> getEntities();
	public Dimension getSize();
	public String getName();
}
