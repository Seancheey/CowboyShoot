package com.Seancheey.GUI.Game;

import java.awt.*;

import javax.swing.JPanel;
import com.Seancheey.GUI.GuiTool;
import com.Seancheey.GUI.Game.Bar.*;

public class GameBar extends JPanel {
	private static final long serialVersionUID = 1L;

	public static StatusBar statusBar;
	public static ScoreBoard scoreBoard;
	public static GameMenu gameMenu;
	public static MagicUsingBar magicUsingBar;

	public GameBar() {
		statusBar = new StatusBar();
		scoreBoard = new ScoreBoard();
		gameMenu = new GameMenu();
		magicUsingBar = new MagicUsingBar();
		setSize(GuiTool.fitSize(900, 50));
		setLocation(0, GuiTool.fitHeight(550));
		setBackground(Color.WHITE);
		add(statusBar);
		add(scoreBoard);
		add(gameMenu);
		add(magicUsingBar);
	}

}
