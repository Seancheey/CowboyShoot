package com.seancheey.gui;

import javax.swing.*;

import java.awt.*;

import com.seancheey.data.Mainclass;
import com.seancheey.data.KeyHandling.KeyHandler;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private static Image icon;
	public final static double screenRatio = (double) 900 / (double) 600;
	public static Dimension frameSize = GuiTool.getFittedSize(screenRatio);
	public static MainPanel mainPanel;
	public static KeyHandler keyhandler;

	public MainFrame() {
		super("Western Guardian");
		setVisible(true);
		setSize(frameSize.width, frameSize.height + 35);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		icon = Toolkit.getDefaultToolkit().getImage("resource/Avoider/avoiderAvoider1.png");
		setIconImage(icon);
		mainPanel = new MainPanel();
		add(mainPanel);
		keyhandler = new KeyHandler();
		addKeyListener(keyhandler);
		// addKeyListener(new GameKeyHandler());
		repaint();
	}

	public static JFrame getFrame() {
		return Mainclass.frame;
	}
}