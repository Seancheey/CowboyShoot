package com.seancheey.gui.Game.Bar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JPanel;

import com.seancheey.gui.GuiTool;

public class ScoreBoard extends JPanel {
	private static final long serialVersionUID = 1L;
	public static int score = 0;
	private static Image background = Toolkit.getDefaultToolkit()
			.getImage("resource/Background/avoiderBarBackgorund1.png");

	public static int getScore() {
		return score;
	}

	public ScoreBoard() {
		setLayout(null);
		setSize(GuiTool.fitSize(100, 50));
		setLocation(GuiTool.convertPoint(new Point(450, 0)));
		setBackground(Color.WHITE);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, GuiTool.fitWidth(100), GuiTool.fitHeight(50), this);
		g.setColor(Color.BLACK);
		g.setFont(new Font("serif", Font.BOLD, 30));
		g.drawString(score + "", 10, 40);
		repaint();
	}

	public void resetScore() {
		score = 0;
	}

	public void scoreAdd(int added) {
		score += added;
	}
}