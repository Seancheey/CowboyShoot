package com.seancheey.magic;

import java.awt.event.KeyEvent;

import com.seancheey.entityAttributes.TypeGetter;
import com.seancheey.gui.Game.Bar.StatusBar;

public class Heal extends Magic {

	public Heal() {
		super("resource/Magic/avoiderMagic3.png", KeyEvent.VK_C, 60, 10000);
	}

	@Override
	public void execution() {
		TypeGetter.getPlayer(0).HP += 20;
		if (TypeGetter.getPlayer(0).HP > TypeGetter.getPlayer(0).getMaxHealth())
			TypeGetter.getPlayer(0).HP = TypeGetter.getPlayer(0).getMaxHealth();
		StatusBar.resetBar();
	}
}
