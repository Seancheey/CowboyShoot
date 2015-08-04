package com.seancheey.data.KeyHandling;

import javax.swing.*;

import java.awt.event.*;

import com.seancheey.gui.MainPanel;

public class KeyHandler implements KeyListener {
	private JPanel panel;
	private KeyListener gameKL;

	public KeyHandler() {
		gameKL = new GameKeyHandler();
	}

	public void switchPanel(JPanel keyhandlingPanel) {
		panel = keyhandlingPanel;
	}

	public void keyPressed(KeyEvent e) {
		if (panel == MainPanel.gamePanel)
			gameKL.keyPressed(e);
	}

	public void keyReleased(KeyEvent e) {
		if (panel == MainPanel.gamePanel) {
			gameKL.keyReleased(e);
		}
	}

	public void keyTyped(KeyEvent arg0) {

	}
}
