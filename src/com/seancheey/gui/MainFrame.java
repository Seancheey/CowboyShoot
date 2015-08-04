package com.seancheey.gui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.seancheey.data.KeyHandling.KeyHandler;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private static Image icon;
	public final static double screenRatio = (double) 900 / (double) 600;
	public static Dimension frameSize = GuiTool.getFittedSize(screenRatio);

	public KeyHandler keyhandler;

	public MainFrame() {
		super("Western Guardian");
		setVisible(true);
		setSize(frameSize.width, frameSize.height + 35);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		icon = Toolkit.getDefaultToolkit().getImage("resource/Avoider/avoiderAvoider1.png");
		setIconImage(icon);
		keyhandler = new KeyHandler();
		addKeyListener(keyhandler);
		repaint();
	}

	public void switchPanel(JPanel oldPanel, JPanel newPanel) {
		newPanel.setEnabled(true);
		getContentPane().add(newPanel);
		getContentPane().remove(oldPanel);
		oldPanel.setEnabled(false);
		keyhandler.switchPanel(newPanel);
		getContentPane().repaint();
	}
}