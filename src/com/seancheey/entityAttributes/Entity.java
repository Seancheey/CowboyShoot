package com.seancheey.entityAttributes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import com.seancheey.gui.GuiTool;
import com.seancheey.gui.Game.GamePanel;

public abstract class Entity{
	public int HP = 10, maxHP;

	protected double px, py, vx, vy;

	private double rotation = 0;
	private Image image;
	private int id, width, height;
	private String type;

	protected Entity() {
		image = null;
		id = -1;
		type = "nil";
	}

	public abstract void collisionOperation(int id);

	public Point getCenterPosition() {
		return new Point((int) px + width / 2, (int) py + height / 2);
	}

	public int getHeight() {
		return height;
	}

	public int getID() {
		return id;
	}

	public String getType() {
		return type;
	}

	public double getVelocity() {
		return Math.sqrt(Math.pow(getVx(), 2) + Math.pow(getVy(), 2));
	}

	public double getVx() {
		return vx;
	}

	public double getVy() {
		return vy;
	}

	public int getWidth() {
		return width;
	}

	public void kill() {
		id = -1;
		width = 0;
		height = 0;
		remove();
	}

	public void paint(Graphics g) {
		if (HP > 0) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.rotate(rotation, GuiTool.fitWidth(getCenterPosition().x), GuiTool.fitHeight(getCenterPosition().y));
			g.drawImage(image, GuiTool.fitWidth((int) px), GuiTool.fitHeight((int) py), GuiTool.fitWidth(width),
					GuiTool.fitHeight(height), GamePanel.game);
			g2d.rotate(-rotation, GuiTool.fitWidth(getCenterPosition().x), GuiTool.fitHeight(getCenterPosition().y));
		}
	}

	public void refreshRotation() {
		rotation = Math.atan2(getVy(), getVx());
	}

	public void remove() {
		HP = 0;
		px = -10000;
		py = -10000;
		setVx(0);
		setVy(0);
	}

	protected void setHeight(int height) {
		this.height = height;
	}

	public void setID(int newID) {
		if (id == -1)
			id = newID;
	}

	protected void setImage(Image addedImage) {
		image = addedImage;
	}

	protected void setImage(String imagePath) {
		image = Toolkit.getDefaultToolkit().getImage(imagePath);
		if (image.toString() == null)
			System.out.println("com.seancheey.MOB---setImage---image is not found");
	}

	public void setPosition(int px, int py) {
		this.px = px;
		this.py = py;
	}

	public void setPosition(Point point) {
		this.px = point.x;
		this.py = point.y;
	}

	public void setSize(int size) {
		setWidth(size);
		setHeight(size);
	}

	public void setSize(int width, int height) {
		setWidth(width);
		setHeight(height);
	}

	protected void setType(String type) {
		this.type = type;
	}

	public void setVx(double vx) {
		this.vx = vx;
	}

	public void setVy(double vy) {
		this.vy = vy;
	}

	protected void setWidth(int width) {
		this.width = width;
	}
}
