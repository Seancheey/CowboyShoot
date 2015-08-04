package com.seancheey.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.seancheey.data.RankModifier;

public class Rank extends StdPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	private static JButton exitButton;
	private static JLabel[] rankList = new JLabel[10];

	public Rank(MainFrame mainFrame) {
		super(mainFrame);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exitButton)
			switchTo(new Menu(mainFrame));
	}

	@Override
	protected void init() {
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
}
