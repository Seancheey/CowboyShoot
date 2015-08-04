package com.Seancheey.GUI.Game.Bar;

import javax.swing.*;

import com.Seancheey.EntityAttributes.TypeGetter;
import com.Seancheey.GUI.GuiTool;
import com.Seancheey.Magic.Magic;

import java.awt.event.*;
import java.awt.*;

public class MagicUsingBar extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	private static Image[] magicImage = new Image[3];
	private static JButton[] button = new JButton[3];
	public static boolean[] canUse = new boolean[3];
	public static char[] hotKey = new char[3];
	private static Image background = Toolkit.getDefaultToolkit()
			.getImage("resource/Background/avoiderBarBackgorund1.png");

	public MagicUsingBar() {
		setSize(GuiTool.fitSize(150, 50));
		setLocation(GuiTool.convertPoint(300, 0));
		setBackground(Color.WHITE);
		hotKey[0] = 'z';
		hotKey[1] = 'x';
		hotKey[2] = 'c';
		// initialize magicImage
		for (int ba = 0; ba < 3; ba++) {
			button[ba] = new JButton();
			button[ba].setSize(GuiTool.fitSize(50, 50));
			button[ba].setLocation(GuiTool.convertPoint(ba * 50, 0));
			button[ba].setBackground(new Color(0, 0, 0, 0));
			button[ba].setFocusable(false);
			button[ba].addActionListener(this);
			button[ba].setBorderPainted(false);
			add(button[ba]);
			magicImage[ba] = Toolkit.getDefaultToolkit().getImage("resource/Magic/avoiderMagic" + (ba + 1) + ".png");
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		readCanUse();
		g.drawImage(background, 0, 0, GuiTool.fitWidth(150), GuiTool.fitHeight(50), this);
		for (int ba = 0; ba < 3; ba++) {
			g.drawImage(magicImage[ba], GuiTool.fitWidth(ba * 50), 0, GuiTool.fitWidth(50), GuiTool.fitHeight(50),
					this);
			if (!canUse[ba]) {
				g.setColor(new Color(0, 0, 0, 100));
				g.fillRect(GuiTool.fitWidth(ba * 50), 0, GuiTool.fitWidth(50), GuiTool.fitHeight(50));
			}
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString(String.valueOf(hotKey[ba]), GuiTool.fitWidth(ba * 50), GuiTool.fitHeight(45));
		}
		repaint();
	}

	private void readCanUse() {
		if (Magic.boom.canUse && TypeGetter.getPlayer(0).MP >= Magic.boom.MPUse)
			canUse[0] = true;
		else
			canUse[0] = false;
		if (Magic.hallowRing.canUse && TypeGetter.getPlayer(0).MP >= Magic.hallowRing.MPUse)
			canUse[1] = true;
		else
			canUse[1] = false;
		if (Magic.heal.canUse && TypeGetter.getPlayer(0).MP >= Magic.heal.MPUse)
			canUse[2] = true;
		else
			canUse[2] = false;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button[0])
			Magic.boom.conjure();
		else if (e.getSource() == button[1])
			Magic.hallowRing.conjure();
		else if (e.getSource() == button[2])
			Magic.heal.conjure();
	}
}
