package com.seancheey.gui.Shop;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import com.seancheey.gui.GuiTool;
import com.seancheey.gui.MainPanel;
import com.seancheey.gui.Game.Game;

public class ShopMenu extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static JButton exitButton = new JButton("Back");

	public ShopMenu() {
		setSize(GuiTool.fitSize(900, 60));
		setLocation(GuiTool.convertPoint(0, 540));
		setBackground(Color.WHITE);

		// exit button
		exitButton.setFont(new Font("Bradley Hand ITC", Font.BOLD, 50));
		exitButton.setSize(exitButton.getPreferredSize());
		exitButton.setLocation(GuiTool.fitWidth(900 - exitButton.getWidth()), GuiTool.fitHeight(10));
		exitButton.setBorderPainted(false);
		exitButton.setBackground(Color.WHITE);
		exitButton.addActionListener(this);
		exitButton.setFocusable(false);
		add(exitButton);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exitButton) {
			GuiTool.switchPanel(MainPanel.shopPanel, MainPanel.gamePanel);
			Game.map.resumeAll();
		}
	}

}
