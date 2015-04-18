package com.Seancheey.GUI.Shop;

import javax.swing.*;

import com.Seancheey.GUI.GuiTool;

import java.awt.*;
import java.awt.event.*;

public class GoodsFrame extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private Image goodImage;
	private String goodName="null",discreption="null";
	
	public GoodsFrame(){
		setSize(GuiTool.fitSize(290, 180));
		setBackground(Color.CYAN);
		
		//button
		JButton b=new JButton(goodName);
		b.setSize(b.getPreferredSize());
		b.setLocation(0, 0);
		b.setToolTipText(discreption);
		add(b,BorderLayout.SOUTH);
	}
	public void setGoodName(String name){
		goodName=name;
	}
	public void setDiscreption(String discreption){
		this.discreption=discreption;
	}
	
	public void addImage(Image addedImage){
		goodImage=addedImage;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	}
	public void actionPerformed(ActionEvent arg0) {
		
	}
}
