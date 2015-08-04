package com.seancheey.gui;

import javax.swing.JPanel;

public class StdPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	protected MainFrame mainFrame;

	public StdPanel(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		setSize(MainFrame.frameSize);
		setLayout(null);
		setBackground(null);
		init();
	}

	protected void init() {

	}

	public void switchTo(StdPanel newPanel) {
		mainFrame.switchPanel(this, newPanel);
	}
}
