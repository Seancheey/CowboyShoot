package com.seancheey.gui.Game.Bar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.seancheey.gui.GuiTool;
import com.seancheey.gui.MainFrame;
import com.seancheey.gui.Menu;
import com.seancheey.gui.StdPanel;
import com.seancheey.gui.Game.Game;
import com.seancheey.gui.Game.GamePanel;
import com.seancheey.gui.Shop.ShopPanel;

public class GameMenu extends StdPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	private static final int buttonNum = 2;
	private JButton[] button;
	private Image[] buttonIcon;

	public GameMenu(MainFrame mainFrame) {
		super(mainFrame);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button[0]) {
			Game.map.pauseAll();
			mainFrame.switchPanel(new GamePanel(mainFrame), new ShopPanel(mainFrame));
		} else if (e.getSource() == button[1]) {
			Game.map.pauseAll();
			mainFrame.switchPanel(new GamePanel(mainFrame), new Menu(mainFrame));
		}
	}

	@Override
	protected void init() {
		setLocation(GuiTool.convertPoint(new Point(550, 0)));
		setSize(GuiTool.fitSize(350, 50));
		setBackground(Color.GREEN);
		// buttons
		button = new JButton[buttonNum];
		buttonIcon = new Image[buttonNum];
		for (int ba = 0; ba < buttonNum; ba++) {
			button[ba] = new JButton();
			buttonIcon[ba] = Toolkit.getDefaultToolkit().getImage("resource/Button/avoiderButton" + (ba + 6) + ".png");
			button[ba].setSize(GuiTool.fitSize(180, 50));
			button[ba].setLocation(GuiTool.fitWidth(ba * 180), 0);
			button[ba].setBorderPainted(false);
			button[ba].setFocusable(false);
			button[ba].addActionListener(this);
			button[ba].setBackground(new Color(0, 0, 0, 0));
			add(button[ba]);
			repaint();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int ba = 0; ba < buttonNum; ba++)
			g.drawImage(buttonIcon[ba], GuiTool.fitWidth(ba * 180), 0, GuiTool.fitWidth(180), GuiTool.fitWidth(50),
					this);
		repaint();
	}
}
