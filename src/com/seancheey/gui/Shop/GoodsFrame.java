package com.seancheey.gui.Shop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.seancheey.gui.GuiTool;

public class GoodsFrame extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private Image goodImage;
	private String goodName = "null", discreption = "null";

	public GoodsFrame() {
		setSize(GuiTool.fitSize(290, 180));
		setBackground(Color.CYAN);

		// button
		JButton b = new JButton(goodName);
		b.setSize(b.getPreferredSize());
		b.setLocation(0, 0);
		b.setToolTipText(discreption);
		add(b, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

	public void addImage(Image addedImage) {
		goodImage = addedImage;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

	}

	public void setDiscreption(String discreption) {
		this.discreption = discreption;
	}

	public void setGoodName(String name) {
		goodName = name;
	}
}
