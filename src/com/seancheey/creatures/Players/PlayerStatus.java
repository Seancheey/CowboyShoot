package com.seancheey.creatures.Players;

public class PlayerStatus {
	@SuppressWarnings("unused")
	private int HP, maxHP, MP, maxMP, EXP;

	public PlayerStatus(Player player) {
		HP = player.HP;
		maxHP = player.maxHP;
		MP = player.MP;
		maxMP = player.maxMP;
	}
}
