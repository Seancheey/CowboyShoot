package com.seancheey.gui.Shop;

import javax.swing.*;
import com.seancheey.gui.MainFrame;

public class ShopPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private static ShoppingFrame shoppingFrame;
	private static ShopMenu shopMenu;

	public ShopPanel() {
		shoppingFrame = new ShoppingFrame();
		shopMenu = new ShopMenu();

		setSize(MainFrame.frameSize);
		add(shoppingFrame);
		add(shopMenu);
	}
}