package com.Seancheey.levels;

public class CurrentLevel extends LevelData {
	// loaded level
	private static LevelData LVL;

	public CurrentLevel() {
		switchMap(new Village());
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

	public void resetAll() {
		for (int ba = 0; ba < creatures.size(); ba++) {
			creatures.get(ba).reset();
		}
	}

	public void pauseAll() {
		for (int ba = 0; ba < creatures.size(); ba++) {
			creatures.get(ba).timer.stop();
		}
	}

	public void resumeAll() {
		for (int ba = 0; ba < creatures.size(); ba++) {
			creatures.get(ba).timer.restart();
		}
	}

	@Override
	protected void failOperation() {
		LVL.failOperation();
	}

	@Override
	protected void winOperation() {
		LVL.winOperation();
	}

	@Override
	protected boolean testWin() {
		return LVL.testWin();
	}

	@Override
	protected boolean testFail() {
		return LVL.testFail();
	}

}
