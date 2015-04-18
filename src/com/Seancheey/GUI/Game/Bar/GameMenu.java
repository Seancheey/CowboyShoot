package com.Seancheey.GUI.Game.Bar;

import javax.swing.*;
import com.Seancheey.GUI.GuiTool;
import com.Seancheey.GUI.MainPanel;
import com.Seancheey.GUI.Game.Game;

import java.awt.*;
import java.awt.event.*;

public class GameMenu extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private static final int buttonNum=2;
	private JButton[] button=new JButton[buttonNum];
	private Image[] buttonIcon=new Image[buttonNum];
	public GameMenu() {
		setLayout(null);
		setLocation(GuiTool.convertPoint(new Point(550,0)));
		setSize(GuiTool.fitSize(350, 50));
		setBackground(Color.GREEN);
		//buttons
		for(int ba=0;ba<buttonNum;ba++){
			button[ba]=new JButton();
			buttonIcon[ba]=Toolkit.getDefaultToolkit().getImage("resource/Button/avoiderButton"+(ba+6)+".png");
			button[ba].setSize(GuiTool.fitSize(180, 50));
			button[ba].setLocation(GuiTool.fitWidth(ba*180), 0);
			button[ba].setBorderPainted(false);
			button[ba].setFocusable(false);
			button[ba].addActionListener(this);
			button[ba].setBackground(new Color(0,0,0,0));
			add(button[ba]);
			repaint();
		}
	}

	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		for(int ba=0;ba<buttonNum;ba++)
			g.drawImage(buttonIcon[ba], GuiTool.fitWidth(ba*180), 0, GuiTool.fitWidth(180), GuiTool.fitWidth(50),this);
		repaint();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button[0]){
			Game.map.pauseAll();
			GuiTool.switchPanel(MainPanel.gamePanel, MainPanel.shopPanel);
		}else if(e.getSource()==button[1]){
			Game.map.pauseAll();
			GuiTool.switchPanel(MainPanel.gamePanel,MainPanel.menu);
		}
	}
}
