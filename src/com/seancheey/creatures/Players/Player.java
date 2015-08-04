package com.Seancheey.Creatures.Players;

import java.awt.*;
import java.awt.event.KeyEvent;

import com.Seancheey.Creatures.Creature;
import com.Seancheey.Creatures.Bullets.Bullet;
import com.Seancheey.Data.Mainclass;
import com.Seancheey.EntityAttributes.CreatureType;
import com.Seancheey.EntityAttributes.TypeGetter;
import com.Seancheey.GUI.GuiTool;
import com.Seancheey.GUI.MainPanel;
import com.Seancheey.GUI.Game.Game;
import com.Seancheey.GUI.Game.GamePanel;
import com.Seancheey.GUI.Game.Bar.ScoreBoard;
import com.Seancheey.GUI.Game.Bar.StatusBar;
import com.Seancheey.Magic.Magic;

public class Player extends Creature {
	private static final int maxSpeed = 300;
	// magic point and maximum magic point of player
	public int MP = 100, maxMP = 100;
	// image of the gun
	private static Image gunImage = Toolkit.getDefaultToolkit().getImage("resource/Player/gun1.png");
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

	public Player() {
		setType("player");
		setImage("resource/Player/Cowboy2.png");
		setSize(50);
		reset();
		shootThread.start();
	}

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

	public void deathOperation() {
		timer.kill();

		Mainclass.rankModifier.addNewRank("Sean", ScoreBoard.getScore());
		GuiTool.switchPanel(MainPanel.gamePanel, MainPanel.menu);
	}

	public void movePress(int key) {
		if (key == KeyEvent.VK_W && getVy() > 0 - maxSpeed) {
			setVy(getVy() - 301);
		} else if (key == KeyEvent.VK_S && getVy() < maxSpeed) {
			setVy(getVy() + 301);
		} else if (key == KeyEvent.VK_A && getVx() > 0 - maxSpeed) {
			setVx(getVx() - 301);
		} else if (key == KeyEvent.VK_D && getVx() < maxSpeed) {
			setVx(getVx() + 301);
		}
	}

	public void moveRelease(int key) {
		if (key == KeyEvent.VK_A || key == KeyEvent.VK_D) {
			setVx(0);
		} else if (key == KeyEvent.VK_S || key == KeyEvent.VK_W) {
			setVy(0);
		}
	}

	public void conjure(Magic magic) {
		magic.conjure();
	}

	public void makeMove() {
		if (px < 900 - getWidth() - 15 && px > 0)
			px += getVx() / 1000 * timer.getDelay();
		else {
			px += (px <= 0 ? 1 : -1);
			setVx(getVx() * -1);
		}
		if (py < 600 - getHeight() - 50 && py > 0)
			py += getVy() / 1000 * timer.getDelay();
		else {
			py += (py <= 0 ? 1 : -1);
			setVy(getVy() * -1);
		}
	}

	public void refreshAction() {
		makeMove();
		if (showGunTime > 0)
			showGunTime -= timer.getDelay();
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

	private void shoot(double direction) {
		Bullet b = new Bullet();
		b.shooted(direction, this, 400);
		b.startRefresh();
		Game.map.addNew(b);
	}

	public void shootPress(double direction) {
		shootDirection = direction;
		isShooting = true;
		gunRotation = shootDirection;
		showGunTime = 1000;
	}

	@SuppressWarnings("deprecation")
	public void kill() {
		super.kill();
		shootThread.suspend();
		shootThread = null;
	}

	public void shootRelease(double direction) {
		isShooting = false;
	}

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
}
