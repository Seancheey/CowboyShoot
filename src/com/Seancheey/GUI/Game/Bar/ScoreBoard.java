package com.Seancheey.GUI.Game.Bar;

import java.awt.*;

import javax.swing.*;

import com.Seancheey.GUI.GuiTool;

public class ScoreBoard extends JPanel{
	private static final long serialVersionUID = 1L;
	public static int score=0;
	private static Image background=Toolkit.getDefaultToolkit().getImage("resource/Background/avoiderBarBackgorund1.png");
	public ScoreBoard() {
		setLayout(null);
		setSize(GuiTool.fitSize(100, 50));
		setLocation(GuiTool.convertPoint(new Point(450,0)));
		setBackground(Color.WHITE);
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(background, 0, 0, GuiTool.fitWidth(100), GuiTool.fitHeight(50), this);
		g.setColor(Color.BLACK);
		g.setFont(new Font("serif",Font.BOLD,30));
		g.drawString(score+"", 10, 40);
		repaint();
	}
	
	public void scoreAdd(int added){
		score+=added;
	}
	
	public void resetScore(){
		score=0;
	}
	
	public static int getScore(){
		return score;
	}
}