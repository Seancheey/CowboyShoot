package com.seancheey.creatures.Players;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import com.seancheey.creatures.Creature;
import com.seancheey.creatures.Bullets.Bullet;
import com.seancheey.data.RankModifier;
import com.seancheey.data.KeyHandling.GameKeyHandler;
import com.seancheey.data.KeyHandling.PlayerKeyHandler;
import com.seancheey.entityAttributes.CreatureType;
import com.seancheey.entityAttributes.TypeGetter;
import com.seancheey.gui.GuiTool;
import com.seancheey.gui.Game.Game;
import com.seancheey.gui.Game.GamePanel;
import com.seancheey.gui.Game.Bar.ScoreBoard;
import com.seancheey.gui.Game.Bar.StatusBar;
import com.seancheey.magic.Magic;

public class Player extends Creature {
	private static final int maxSpeed = 10;
	// image of the gun
	private static Image gunImage = Toolkit.getDefaultToolkit().getImage("resource/Player/gun1.png");
	// Magic point and maximum Magic point of player
	public int MP = 100, maxMP = 100;
	// The time left that the player shows the gun in his hand
	private int showGunTime = 1000;
	// Rotation of the gun
	private double gunRotation = 0;
	// If the player is shooting, for the shootThread
	private boolean isShooting = false;
	// the direction of the bullet that will appear on the screen
	private double shootDirection = 0;
	// control if the player will shoot and the frequency of the shooting
	private Thread shootThread = new Thread() {
		@Override
		public void run() {
			for (;;) {
				try {
					sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (isShooting)
					shoot(shootDirection);
			}
		}
	};
	private PlayerKeyHandler playerKeyHandler = new PlayerKeyHandler();

	public Player(GameKeyHandler keyHandler) {
		setType("player");
		setImage("resource/Player/Cowboy2.png");
		setSize(50);
		reset();
		shootThread.start();
		keyHandler.addListener(playerKeyHandler);
	}

	@Override
	public void collisionOperation(int id) {
		if (TypeGetter.getType(id) == CreatureType.BALL) {
			HP -= 1;
			Game.map.getCreatureList().get(id).addHP(-1);
			TypeGetter.getBall(id).resetSize();
		} else if (TypeGetter.getType(id) == CreatureType.REVIVER) {
			Game.map.getCreatureList().get(id).collisionOperation(getID());
		}
		StatusBar.setHealth(HP);
	}

	public void conjure(Magic Magic) {
		Magic.conjure();
	}

	@Override
	public void deathOperation() {
		new RankModifier().addNewRank("Sean", ScoreBoard.getScore());
		// TODO exit the game panel
	}

	@Override
	public void makeMove() {
		super.makeMove();
		vx = maxSpeed * playerKeyHandler.getMovingDirection().x;
		vy = maxSpeed * playerKeyHandler.getMovingDirection().y;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (showGunTime > 0) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.rotate(gunRotation, GuiTool.fitWidth(getCenterPosition().x), GuiTool.fitHeight(getCenterPosition().y));
			g.drawImage(gunImage, GuiTool.fitWidth(getCenterPosition().x), GuiTool.fitHeight(getCenterPosition().y),
					GuiTool.fitWidth(30), GuiTool.fitHeight(15), GamePanel.game);
			g2d.rotate(-gunRotation, GuiTool.fitWidth(getCenterPosition().x), GuiTool.fitHeight(getCenterPosition().y));
		}
	}

	public void reset() {
		px = 430;
		py = 280;
		setVx(0);
		setVy(0);
		maxHP = 50;
		HP = 50;
		maxMP = 100;
		MP = 100;
	}

	public void shoot(double direction) {
		double bulletvx = (vx + Math.cos(direction) * 20);
		double bulletvy = (vy + Math.sin(direction) * 20);
		Bullet b = new Bullet(getCenterPosition(), bulletvx, bulletvy);
		Game.map.addNew(b);
	}
}
