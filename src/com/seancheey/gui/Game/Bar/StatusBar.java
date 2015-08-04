package com.seancheey.gui.Game.Bar;

import javax.swing.*;

import com.seancheey.entityAttributes.TypeGetter;
import com.seancheey.gui.GuiTool;

import java.awt.*;

public class StatusBar extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final int barNum = 3;
	private static Image[] icon = new Image[barNum], bar = new Image[barNum];
	private static int maxHealth = 50, currentHealth = 50, maxMagic = 100, currentMagic = 100;
	private static int HPLength = (int) (currentHealth / maxHealth * (350)),
			MPLength = (int) (currentHealth / maxHealth * (350));
	private static Image background = Toolkit.getDefaultToolkit()
			.getImage("resource/Background/avoiderBarBackgorund1.png");

	public StatusBar() {
		setSize(GuiTool.fitSize(300, 50));
		setLocation(0, 0);
		setBackground(new Color(255, 255, 255, 10));
		setLayout(null);
		// initialize icons and bars
		icon[0] = Toolkit.getDefaultToolkit().getImage("resource/Icon/avoiderHeart.png");
		icon[1] = Toolkit.getDefaultToolkit().getImage("resource/Icon/avoiderMagic.png");
		icon[2] = Toolkit.getDefaultToolkit().getImage("resource/Icon/avoiderEXP.png");

		bar[0] = Toolkit.getDefaultToolkit().getImage("resource/Bar/avoiderHealthBar.png");
		bar[1] = Toolkit.getDefaultToolkit().getImage("resource/Bar/avoiderMagicBar.png");
		bar[2] = Toolkit.getDefaultToolkit().getImage("resource/Bar/avoiderEXPBar.png");

	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, GuiTool.fitWidth(300), GuiTool.fitHeight(50), this);
		g.drawImage(icon[0], 0, 0, GuiTool.fitWidth(25), GuiTool.fitHeight(25), this);
		g.drawImage(icon[1], 0, GuiTool.fitHeight(25), GuiTool.fitWidth(25), GuiTool.fitHeight(25), this);
		g.drawImage(bar[0], GuiTool.fitWidth(25), 0, GuiTool.fitWidth(HPLength), GuiTool.fitWidth(25), this);
		g.drawImage(bar[1], GuiTool.fitWidth(25), GuiTool.fitHeight(25), GuiTool.fitWidth(MPLength),
				GuiTool.fitHeight(25), this);
		repaint();
	}

	public static void setHealth(int health) {
		currentHealth = health;
		HPLength = (int) ((double) currentHealth / (double) maxHealth * 275);
	}

	public static void setMagic(int Magic) {
		currentMagic = Magic;
		MPLength = (int) ((double) currentMagic / (double) maxMagic * 275);
	}

	public static void resetBar() {
		setMagic(TypeGetter.getPlayer(0).MP);
		setHealth(TypeGetter.getPlayer(0).HP);
	}
}
