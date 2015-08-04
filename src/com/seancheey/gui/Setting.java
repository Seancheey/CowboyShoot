package com.seancheey.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Setting extends StdPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	private static JButton exitButton = new JButton("Back");

	public Setting(MainFrame mainFrame) {
		super(mainFrame);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exitButton)
			switchTo(new Menu(mainFrame));
	}

	@Override
	protected void init() {
		GuiTool.initializePanel(this);

		exitButton.setFont(new Font("Bradley Hand ITC", Font.BOLD, 50));
		exitButton.setSize(exitButton.getPreferredSize());
		exitButton.setLocation(GuiTool.fitWidth(890 - exitButton.getWidth()),
				GuiTool.fitHeight(580 - exitButton.getHeight()));
		exitButton.setBorderPainted(false);
		exitButton.setBackground(Color.WHITE);
		exitButton.addActionListener(this);
		exitButton.setFocusable(false);
		add(exitButton);
	}
}
