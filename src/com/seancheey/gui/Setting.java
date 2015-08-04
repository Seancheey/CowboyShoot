package com.Seancheey.GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Setting extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static JButton exitButton = new JButton("Back");

	public Setting() {
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

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exitButton)
			GuiTool.switchPanel(this, MainPanel.menu);
	}
}
