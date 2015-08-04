package com.seancheey.gui.Shop;

import com.seancheey.gui.MainFrame;
import com.seancheey.gui.StdPanel;

public class ShopPanel extends StdPanel {
	private static final long serialVersionUID = 1L;

	private static ShoppingFrame shoppingFrame;
	private static ShopMenu shopMenu;

	public ShopPanel(MainFrame mainFrame) {
		super(mainFrame);
	}

	@Override
	protected void init() {
		shoppingFrame = new ShoppingFrame();
		shopMenu = new ShopMenu(mainFrame);

		setSize(MainFrame.frameSize);
		add(shoppingFrame);
		add(shopMenu);
	}
}