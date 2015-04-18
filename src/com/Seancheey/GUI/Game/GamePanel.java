package com.Seancheey.GUI.Game;

import javax.swing.*;
import com.Seancheey.GUI.GuiTool;
import com.Seancheey.GUI.Game.Bar.StatusBar;

public class GamePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public static Game game;
	public static GameBar bar;
	public static Animation animation;
	public GamePanel() {
		GuiTool.initializePanel(this);
		game=new Game();
		bar=new GameBar();
		animation=new Animation();
		add(game);
		add(bar);
		repaint();
	}
	
	public void reset(){
		StatusBar.resetBar();
		GameBar.scoreBoard.resetScore();
	}
}
