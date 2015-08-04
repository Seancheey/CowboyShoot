package com.seancheey.gui.Shop;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.seancheey.gui.GuiTool;
import com.seancheey.gui.MainFrame;
import com.seancheey.gui.StdPanel;
import com.seancheey.gui.Game.Game;
import com.seancheey.gui.Game.GamePanel;

public class ShopMenu extends StdPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	private static JButton exitButton = new JButton("Back");

	public ShopMenu(MainFrame mainFrame) {
		super(mainFrame);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exitButton) {
			mainFrame.switchPanel(new ShopPanel(mainFrame), new GamePanel(mainFrame));
			Game.map.resumeAll();
		}
	}

	@Override
	protected void init() {
		setSize(GuiTool.fitSize(900, 60));
		setLocation(GuiTool.convertPoint(0, 540));
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

}
