package com.seancheey.levels;

import com.seancheey.data.KeyHandling.GameKeyHandler;

public class CurrentLevel extends LevelData {
	// loaded level
	private static LevelData LVL;

	public CurrentLevel(GameKeyHandler gameKeyHandler) {
		super(gameKeyHandler);
		switchMap(new Village(gameKeyHandler));
	}

	@Override
	protected void failOperation() {
		LVL.failOperation();
	}

	public void pauseAll() {
		// TODO pause
	}

	public void resumeAll() {
		// TODO resume
	}

	public void switchMap(LevelData newLevel) {
		kill();
		entities = newLevel.entities;
		creatures = newLevel.creatures;
		backgroundImage = newLevel.backgroundImage;
		mapName = newLevel.mapName;
		mapSize = newLevel.mapSize;
		setID(newLevel.getID());
		LVL = newLevel;
	}

	@Override
	protected boolean testFail() {
		return LVL.testFail();
	}

	@Override
	protected boolean testWin() {
		return LVL.testWin();
	}

	@Override
	protected void winOperation() {
		LVL.winOperation();
	}

}
