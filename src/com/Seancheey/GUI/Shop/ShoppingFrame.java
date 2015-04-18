package com.Seancheey.GUI.Shop;

import java.awt.*;
import javax.swing.*;
import com.Seancheey.GUI.GuiTool;

public class ShoppingFrame extends JPanel{
	private static final long serialVersionUID = 1L;
	private static int horizontalNum=3,verticalNum=3;
	private static GoodsFrame[][] goodsFrame=new GoodsFrame[horizontalNum][verticalNum];
	public ShoppingFrame() {
		setSize(GuiTool.fitSize(900, 540));
		setBackground(Color.ORANGE);
		
		for(int y=0;y<verticalNum;y++){
			for(int x=0;x<horizontalNum;x++){
				goodsFrame[x][y]=new GoodsFrame();
				goodsFrame[x][y].setLocation(x*(goodsFrame[x][y].getWidth()+5), y*(goodsFrame[x][y].getHeight()+5));
				add(goodsFrame[x][y]);
			}
		}
		
	}
}
