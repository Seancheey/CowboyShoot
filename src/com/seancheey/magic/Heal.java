package com.Seancheey.Magic;

import java.awt.event.KeyEvent;

import com.Seancheey.EntityAttributes.TypeGetter;
import com.Seancheey.GUI.Game.Bar.StatusBar;

public class Heal extends Magic {

	public Heal() {
		super("resource/Magic/avoiderMagic3.png", KeyEvent.VK_C, 60, 10000);
	}

	public void execution() {
		TypeGetter.getPlayer(0).HP += 20;
		if (TypeGetter.getPlayer(0).HP > TypeGetter.getPlayer(0).getMaxHealth())
			TypeGetter.getPlayer(0).HP = TypeGetter.getPlayer(0).getMaxHealth();
		StatusBar.resetBar();
	}
}
