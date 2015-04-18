package com.Seancheey.GUI;

import javax.swing.*;
import com.Seancheey.Data.Mainclass;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private static final int buttonNum=5;
	private static JButton[] button=new JButton[buttonNum];
	private static ImageIcon[] buttonIcon=new ImageIcon[buttonNum];
	private static Image titleIcon=Toolkit.getDefaultToolkit().getImage("resource/Label/Title.png");
	private static JLabel versionLabel=new JLabel(Mainclass.version);
	private static boolean firstTime=true;
	public Menu() {
		GuiTool.initializePanel(this);
		setBackground(Color.ORANGE);
		//button
		for(int ba=0;ba<buttonNum;ba++){
			int i=ba+1;
			buttonIcon[ba]=new ImageIcon("resource/Button/avoiderButton"+i+".png");
			button[ba]=new JButton();
			button[ba].setIcon(buttonIcon[ba]);
			button[ba].setLocation(660,ba*100+100);
			GuiTool.setBounds(button[ba], 660, ba*100+60, 200, 80);
			button[ba].setSize(200, 80);
			button[ba].addActionListener(this);
			button[ba].setBackground(Color.WHITE);
			button[ba].setFocusable(false);
			add(button[ba]);
		}
		//version label
		versionLabel.setSize(versionLabel.getPreferredSize());
		add(versionLabel);
		
		repaint();
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(titleIcon, 10, 10, GuiTool.fitWidth(600), GuiTool.fitHeight(230), this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button[0]){
			GuiTool.switchPanel(this, MainPanel.gamePanel);
			firstTime=true;
		}
		else if(e.getSource()==button[1]){
			if(!firstTime){
				GuiTool.switchPanel(this, MainPanel.gamePanel);
			}
		}else if(e.getSource()==button[2]){
			GuiTool.switchPanel(this, MainPanel.setting);
		}
		else if(e.getSource()==button[3]){
			MainPanel.credit=new Credit();
			GuiTool.switchPanel(this, MainPanel.credit);
		}else if(e.getSource()==button[4]){
			GuiTool.switchPanel(this, MainPanel.rank);
		}
	}

}
