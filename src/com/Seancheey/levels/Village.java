package com.Seancheey.levels;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.Seancheey.Creatures.Players.Player;
import com.Seancheey.Creatures.Spawner.BallSpawner;
import com.Seancheey.Creatures.Walls.Wall;

public class Village extends LevelData {

	public Village() {
		mapSize = new Dimension(1000, 1000);
		backgroundImage=Toolkit.getDefaultToolkit().getImage("resource/Background/meadow.jpg");
		clearCreatures();
		//add creatures
		creatures.add(new Player());
		creatures.add(new BallSpawner(100,100,3000));
		creatures.add(new BallSpawner(800,500,2800));
		BallSpawner b=new BallSpawner(450,-1000,15000);
		b.setType(new String[]{"boss"});
		creatures.add(b);
		creatures.add(new Wall(300,0,100,100));
		startRefreshAll();
	}
	@Override
	protected void failOperation() {
		
	}

	@Override
	protected void winOperation() {
		
	}

	@Override
	protected boolean testWin() {
		return false;
	}

	@Override
	protected boolean testFail() {
		return false;
	}
}
