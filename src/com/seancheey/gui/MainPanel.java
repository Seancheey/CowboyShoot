package com.seancheey.gui;

public class MainPanel extends StdPanel {
	private static final long serialVersionUID = 1L;

	public MainPanel(MainFrame mainFrame) {
		super(mainFrame);
	}

	@Override
	protected void init() {
		add(new Menu(mainFrame));
	}
}
