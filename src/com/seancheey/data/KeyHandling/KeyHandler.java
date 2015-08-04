package com.seancheey.data.KeyHandling;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import com.seancheey.gui.Game.GamePanel;

public class KeyHandler implements KeyListener {
	private JPanel panel;
	public GameKeyHandler gameKL;

	public KeyHandler() {
		gameKL = new GameKeyHandler();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (panel instanceof GamePanel)
			gameKL.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (panel instanceof GamePanel) {
			gameKL.keyReleased(e);
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

	public void switchPanel(JPanel keyhandlingPanel) {
		panel = keyhandlingPanel;
	}
}
