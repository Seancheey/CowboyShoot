package com.Seancheey.GUI;

import javax.swing.*;

import com.Seancheey.Data.RankModifier;

import java.awt.*;
import java.awt.event.*;

public class Rank extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static JButton exitButton;
	private static JLabel[] rankList = new JLabel[10];

	public Rank() {
		GuiTool.initializePanel(this);
		// exitButton
		exitButton = new JButton("Back");
		exitButton.setFont(new Font("Bradley Hand ITC", Font.BOLD, 50));
		exitButton.setSize(exitButton.getPreferredSize());
		exitButton.setLocation(GuiTool.fitWidth(890 - exitButton.getWidth()),
				GuiTool.fitHeight(580 - exitButton.getHeight()));
		exitButton.setBorderPainted(false);
		exitButton.setBackground(Color.WHITE);
		exitButton.addActionListener(this);
		exitButton.setFocusable(false);
		add(exitButton);
		// rank list
		for (int ba = 0; ba < 10; ba++) {
			rankList[ba] = new JLabel(RankModifier.nameList[ba] + ": \t" + RankModifier.scoreList[ba]);
			rankList[ba].setFont(new Font("serif", Font.BOLD, 30));
			rankList[ba].setSize(rankList[ba].getPreferredSize());
			rankList[ba].setLocation(
					GuiTool.convertPoint(450 - rankList[ba].getWidth() / 2, (rankList[ba].getHeight() + 10) * ba + 20));
			add(rankList[ba]);
		}
	}

	public void refreshRank() {
		for (int ba = 0; ba < 10; ba++) {
			rankList[ba].setText(RankModifier.nameList[ba] + ": \t" + RankModifier.scoreList[ba]);
			rankList[ba].setSize(rankList[ba].getPreferredSize());
			rankList[ba].setLocation(
					GuiTool.convertPoint(450 - rankList[ba].getWidth() / 2, (rankList[ba].getHeight() + 10) * ba + 20));
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exitButton)
			GuiTool.switchPanel(this, MainPanel.menu);
	}
}
