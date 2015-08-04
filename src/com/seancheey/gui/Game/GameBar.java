package com.seancheey.gui.Game;

import com.seancheey.gui.GuiTool;
import com.seancheey.gui.MainFrame;
import com.seancheey.gui.StdPanel;
import com.seancheey.gui.Game.Bar.GameMenu;
import com.seancheey.gui.Game.Bar.MagicUsingBar;
import com.seancheey.gui.Game.Bar.ScoreBoard;
import com.seancheey.gui.Game.Bar.StatusBar;

public class GameBar extends StdPanel {
	private static final long serialVersionUID = 1L;

	public static StatusBar statusBar;

	public static ScoreBoard scoreBoard;
	public static GameMenu gameMenu;
	public static MagicUsingBar MagicUsingBar;

	public GameBar(MainFrame mainFrame) {
		super(mainFrame);
	}

	@Override
	protected void init() {
		statusBar = new StatusBar();
		scoreBoard = new ScoreBoard();
		gameMenu = new GameMenu(mainFrame);
		MagicUsingBar = new MagicUsingBar();
		setSize(GuiTool.fitSize(900, 50));
		setLocation(0, GuiTool.fitHeight(550));
		add(statusBar);
		add(scoreBoard);
		add(gameMenu);
		add(MagicUsingBar);
	}

}
