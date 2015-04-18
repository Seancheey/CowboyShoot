package com.Seancheey.GUI.Game;

import javax.swing.*;

import java.awt.*;
import com.Seancheey.GUI.GuiTool;
import com.Seancheey.GUI.MainFrame;
import com.Seancheey.levels.CurrentLevel;

public class Game extends JPanel{
	private static final long serialVersionUID = 1L;
	private static Image background=Toolkit.getDefaultToolkit().getImage("resource/Background/meadow.jpg");
	public static CurrentLevel map=new CurrentLevel();
	public Game(){
		setSize(GuiTool.fitSize(900, 550));
		setBackground(Color.WHITE);
		setLayout(null);
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		//paint background
			g.drawImage(background, 0, 0, MainFrame.frameSize.width, MainFrame.frameSize.height, this);
		//paint all of the mobs
		map.paintMap(g);
		GamePanel.animation.paint(g);
		repaint();
	}
}
