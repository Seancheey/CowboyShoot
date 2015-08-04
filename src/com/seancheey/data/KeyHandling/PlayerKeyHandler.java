package com.seancheey.data.KeyHandling;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerKeyHandler implements KeyListener {
	private int down = KeyEvent.VK_DOWN, up = KeyEvent.VK_UP, left = KeyEvent.VK_LEFT, right = KeyEvent.VK_RIGHT;
	private int A = KeyEvent.VK_A, W = KeyEvent.VK_W, S = KeyEvent.VK_S, D = KeyEvent.VK_D;
	private int lastHori, lastVert, lastBull;

	public PlayerKeyHandler() {
	}

	public PlayerKeyHandler(int up, int down, int left, int right, int shootUp, int shootDown, int shootLeft,
			int shootRight) {
		W = up;
		S = down;
		A = right;
		D = left;
		this.up = shootUp;
		this.down = shootDown;
		this.left = shootLeft;
		this.right = shootRight;
	}

	private void deleteLastPressKey(int key) {
		if (key == W || key == S)
			if (lastVert == key)
				lastVert = 0;
		if (key == A || key == D)
			if (lastHori == key)
				lastHori = 0;
		if (isDirectionalKey(key))
			if (lastBull == key)
				lastBull = 0;
	}

	public Point getMovingDirection() {
		Point p = new Point();
		if (lastHori == A)
			p.x = -1;
		if (lastHori == D)
			p.x = 1;
		if (lastVert == W)
			p.y = -1;
		if (lastVert == S)
			p.y = 1;
		return p;
	}

	public Point getShootingDirection() {
		Point p = new Point();
		if (lastBull == up) {
			p.y = -1;
		} else if (lastBull == down) {
			p.y = 1;
		} else if (lastBull == left) {
			p.x = -1;
		} else if (lastBull == right) {
			p.x = 1;
		}
		return p;
	}

	private boolean isDirectionalKey(int key) {
		if (key == right || key == left || key == up || key == down)
			return true;
		else
			return false;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		setLastPressKey(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		deleteLastPressKey(e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	private void setLastPressKey(int key) {
		if (key == W || key == S)
			lastVert = key;
		if (key == A || key == D)
			lastHori = key;
		if (isDirectionalKey(key))
			lastBull = key;
	}

}
