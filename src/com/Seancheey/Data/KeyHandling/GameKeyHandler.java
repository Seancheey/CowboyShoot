package com.Seancheey.Data.KeyHandling;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import com.Seancheey.EntityAttributes.TypeGetter;
import com.Seancheey.Magic.*;

public class GameKeyHandler implements KeyListener {
	private ArrayList<ReactableKey> keys;
	private static ReactableKey keyW = new ReactableKey(KeyEvent.VK_W) {

		@Override
		public void press() {
			TypeGetter.getPlayer(0).movePress(getKeyCode());
		}

		@Override
		public void release() {
			TypeGetter.getPlayer(0).moveRelease(getKeyCode());
		}
	}, keyA = new ReactableKey(KeyEvent.VK_A) {

		@Override
		public void press() {
			TypeGetter.getPlayer(0).movePress(getKeyCode());
		}

		@Override
		public void release() {
			TypeGetter.getPlayer(0).moveRelease(getKeyCode());
		}
	}, keyS = new ReactableKey(KeyEvent.VK_S) {

		@Override
		public void press() {
			TypeGetter.getPlayer(0).movePress(getKeyCode());
		}

		@Override
		public void release() {
			TypeGetter.getPlayer(0).moveRelease(getKeyCode());
		}
	}, keyD = new ReactableKey(KeyEvent.VK_D) {

		@Override
		public void press() {
			TypeGetter.getPlayer(0).movePress(getKeyCode());
		}

		@Override
		public void release() {
			TypeGetter.getPlayer(0).moveRelease(getKeyCode());
		}
	}, keyLEFT = new ReactableKey(KeyEvent.VK_LEFT) {

		@Override
		public void press() {
			TypeGetter.getPlayer(0).shootPress(Math.PI);
		}

		@Override
		public void release() {
			TypeGetter.getPlayer(0).shootRelease(Math.PI);
		}
	}, keyRIGHT = new ReactableKey(KeyEvent.VK_RIGHT) {

		@Override
		public void press() {
			TypeGetter.getPlayer(0).shootPress(0);
		}

		@Override
		public void release() {
			TypeGetter.getPlayer(0).shootRelease(0);
		}
	}, keyUP = new ReactableKey(KeyEvent.VK_UP) {

		@Override
		public void press() {
			TypeGetter.getPlayer(0).shootPress(Math.PI*1.5);
		}

		@Override
		public void release() {
			TypeGetter.getPlayer(0).shootRelease(Math.PI*1.5);
		}
	}, keyDOWN = new ReactableKey(KeyEvent.VK_DOWN) {

		@Override
		public void press() {
			TypeGetter.getPlayer(0).shootPress(Math.PI/2);
		}

		@Override
		public void release() {
			TypeGetter.getPlayer(0).shootRelease(Math.PI/2);
		}
	}, keyZ = new ReactableKey(KeyEvent.VK_Z) {

		@Override
		public void press() {
			TypeGetter.getPlayer(0).conjure(Magic.boom);
		}

		@Override
		public void release() {

		}
	}, keyX = new ReactableKey(KeyEvent.VK_X) {

		@Override
		public void press() {
			TypeGetter.getPlayer(0).conjure(Magic.hallowRing);
		}

		@Override
		public void release() {

		}
	}, keyC = new ReactableKey(KeyEvent.VK_C) {

		@Override
		public void press() {
			TypeGetter.getPlayer(0).conjure(Magic.heal);
		}

		@Override
		public void release() {

		}
	};

	GameKeyHandler() {
		keys = new ArrayList<ReactableKey>(11);
		keys.add(keyA);
		keys.add(keyW);
		keys.add(keyD);
		keys.add(keyS);
		keys.add(keyLEFT);
		keys.add(keyUP);
		keys.add(keyRIGHT);
		keys.add(keyDOWN);
		keys.add(keyZ);
		keys.add(keyX);
		keys.add(keyC);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		for (int ba = 0; ba < keys.size(); ba++)
			if (keys.get(ba).matchKey(e.getKeyCode()))
				keys.get(ba).press();

	}

	@Override
	public void keyReleased(KeyEvent e) {
		for (int ba = 0; ba < keys.size(); ba++)
			if (keys.get(ba).matchKey(e.getKeyCode()))
				keys.get(ba).release();

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}
}
