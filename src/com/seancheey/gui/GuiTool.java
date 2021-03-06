package com.seancheey.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class GuiTool {
	public static void switchPanel(JPanel oldPanel, JPanel newPanel) {
		newPanel.setEnabled(true);
		MainFrame.mainPanel.add(newPanel);
		MainFrame.mainPanel.remove(oldPanel);
		oldPanel.setEnabled(false);
		MainFrame.keyhandler.switchPanel(newPanel);
		MainFrame.mainPanel.repaint();
	}

	public static void initializePanel(JPanel panel) {
		initializePanel(panel, MainFrame.frameSize);
	}

	public static void initializePanel(JPanel panel, int width, int heigth) {
		initializePanel(panel, new Dimension(width, heigth));
	}

	public static void initializePanel(JPanel panel, Dimension size) {
		panel.setLayout(null);
		panel.setSize(size);
		panel.setBackground(Color.white);
	}

	public static int fitWidth(int originalWidth) {
		return (int) (originalWidth * MainFrame.frameSize.width / 900);
	}

	public static int fitHeight(int originalHeight) {
		return (int) (originalHeight * MainFrame.frameSize.height / 600);
	}

	public static Dimension fitSize(Dimension originalSize) {
		return new Dimension((int) (originalSize.width * MainFrame.frameSize.width / 900),
				(int) (originalSize.height * MainFrame.frameSize.height / 600));
	}

	public static Dimension fitSize(int width, int height) {
		return fitSize(new Dimension(width, height));
	}

	public static Dimension getFittedSize(double ratio) {
		Dimension windowSize = new Dimension((int) (Toolkit.getDefaultToolkit().getScreenSize().width * 0.85),
				(int) (Toolkit.getDefaultToolkit().getScreenSize().height * 0.85));
		if (windowSize.width == windowSize.height * ratio)
			return windowSize;
		else if (windowSize.width > windowSize.height * ratio)
			return new Dimension((int) (windowSize.height * ratio), windowSize.height);
		else if (windowSize.width < windowSize.height * ratio)
			return new Dimension(windowSize.width, (int) (windowSize.width / ratio));
		else
			System.out.println("Unable to read the size of the screen");
		return null;
	}

	public static void setBounds(JComponent component, int px, int py, int width, int height) {
		component.setLocation(new Point(fitWidth(px), fitHeight(py)));
		component.setSize(fitSize(width, height));
	}

	public static Point convertPoint(Point originalPoint) {
		return new Point((int) (originalPoint.x * MainFrame.frameSize.width / 900),
				(int) (originalPoint.y * MainFrame.frameSize.height / 600));
	}

	public static Point convertPoint(int x, int y) {
		return convertPoint(new Point(x, y));
	}
}
