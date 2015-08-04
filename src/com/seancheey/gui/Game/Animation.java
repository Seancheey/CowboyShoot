package com.seancheey.gui.Game;

import java.awt.*;

import com.seancheey.entityAttributes.TypeGetter;
import com.seancheey.gui.GuiTool;

public class Animation {
	private static Image image;
	private static int time = 0;
	private static boolean started = false;

	public void paint(Graphics g) {
		if (started) {
			if (time >= 50) {
				time = 0;
				started = false;
			}
			g.drawImage(image, GuiTool.fitWidth(TypeGetter.getPlayer(0).getCenterPosition().x - time * 3),
					GuiTool.fitHeight(TypeGetter.getPlayer(0).getCenterPosition().y - time * 3),
					GuiTool.fitWidth(time * 6), GuiTool.fitWidth(time * 6), GamePanel.game);
			time++;
		}
	}

	public void newImage(String imagePath) {
		image = Toolkit.getDefaultToolkit().getImage(imagePath);
		time = 0;
		started = true;
	}

	public void newImage(Image newImage) {
		image = newImage;
		time = 0;
		started = true;
	}

}
