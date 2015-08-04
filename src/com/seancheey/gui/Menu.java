package com.seancheey.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.seancheey.data.Mainclass;
import com.seancheey.gui.Game.GamePanel;

public class Menu extends StdPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	private static final int buttonNum = 5;
	private static JButton[] button = new JButton[buttonNum];
	private static ImageIcon[] buttonIcon = new ImageIcon[buttonNum];
	private static Image titleIcon = Toolkit.getDefaultToolkit().getImage("resource/Label/Title.png");
	private static JLabel versionLabel = new JLabel(Mainclass.version);
	private static boolean firstTime = true;

	public Menu(MainFrame mainFrame) {
		super(mainFrame);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button[0]) {
			switchTo(new GamePanel(mainFrame));
			firstTime = true;
		} else if (e.getSource() == button[1]) {
			if (!firstTime) {
				switchTo(new GamePanel(mainFrame));
			}
		} else if (e.getSource() == button[2]) {
			switchTo(new Setting(mainFrame));
		} else if (e.getSource() == button[3]) {
			switchTo(new Credit(mainFrame));
		} else if (e.getSource() == button[4]) {
			switchTo(new Rank(mainFrame));
		}
	}

	@Override
	protected void init() {
		setBackground(Color.ORANGE);
		// button
		for (int ba = 0; ba < buttonNum; ba++) {
			int i = ba + 1;
			buttonIcon[ba] = new ImageIcon("resource/Button/avoiderButton" + i + ".png");
			button[ba] = new JButton();
			button[ba].setIcon(buttonIcon[ba]);
			button[ba].setLocation(660, ba * 100 + 100);
			GuiTool.setBounds(button[ba], 660, ba * 100 + 60, 200, 80);
			button[ba].setSize(200, 80);
			button[ba].addActionListener(this);
			button[ba].setBackground(Color.WHITE);
			button[ba].setFocusable(false);
			add(button[ba]);
		}
		// version label
		versionLabel.setSize(versionLabel.getPreferredSize());
		add(versionLabel);

		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(titleIcon, 10, 10, GuiTool.fitWidth(600), GuiTool.fitHeight(230), this);
	}

}
