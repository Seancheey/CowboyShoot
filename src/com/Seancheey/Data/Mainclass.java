package com.Seancheey.Data;

import com.Seancheey.GUI.*;
import com.Seancheey.Timing.TimeCounter;

/*Cowboy Alpha0.1
 * 修改标题
 * 攻击时显示抢
 * 改善键盘控制
 * 完善地图
 * 关卡制
 * 增加墙
 */

/**
 * @author 单奇逸
 *
 */

public class Mainclass {
	public static String version="Alpha0.1";
	public static MainFrame frame;
	public static RankModifier rankModifier;
	public static TimeCounter timeCounter;
	public static void main(String[] args){
		rankModifier=new RankModifier();
		timeCounter=new TimeCounter();
		frame=new MainFrame();
		frame.repaint();
	}
}