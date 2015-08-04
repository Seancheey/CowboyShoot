package com.seancheey.gui.Game;

import com.seancheey.gui.MainFrame;
import com.seancheey.gui.StdPanel;
import com.seancheey.gui.Game.Bar.StatusBar;

public class GamePanel extends StdPanel {
	private static final long serialVersionUID = 1L;
	public static Game game;
	public static GameBar bar;
	public static Animation animation;

	public GamePanel(MainFrame mainFrame) {
		super(mainFrame);
	}

	@Override
	protected void init() {
		game = new Game(mainFrame.keyhandler.gameKL);
		bar = new GameBar(mainFrame);
		animation = new Animation();
		add(game);
		add(bar);
		repaint();
	}

	public void reset() {
		StatusBar.resetBar();
		GameBar.scoreBoard.resetScore();
	}
}
