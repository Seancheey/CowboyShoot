package com.seancheey.data.KeyHandling;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GameKeyHandler implements KeyListener {
	ArrayList<KeyListener> listeners = new ArrayList<KeyListener>();

	public void addListener(KeyListener l) {
		listeners.add(l);
	}

	public void flushListeners() {
		listeners = new ArrayList<KeyListener>();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		for (KeyListener l : listeners) {
			l.keyPressed(e);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		for (KeyListener l : listeners) {
			l.keyReleased(e);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		for (KeyListener l : listeners) {
			l.keyTyped(e);
		}
	}

	public void removeListener(KeyListener l) {
		listeners.remove(l);
	}
}
