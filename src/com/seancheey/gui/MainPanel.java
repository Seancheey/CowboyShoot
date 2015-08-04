package com.seancheey.gui;

import javax.swing.JPanel;
import com.seancheey.gui.Game.GamePanel;
import com.seancheey.gui.Shop.ShopPanel;

public class MainPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	public static Menu menu;
	public static Credit credit;
	public static GamePanel gamePanel;
	public static ShopPanel shopPanel = new ShopPanel();
	public static Setting setting = new Setting();
	public static Rank rank = new Rank();

	public MainPanel() {
		menu = new Menu();
		credit = new Credit();
		gamePanel = new GamePanel();
		GuiTool.initializePanel(this);
		add(menu);
	}
}
