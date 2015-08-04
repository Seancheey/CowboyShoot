package com.Seancheey.Data;

import com.Seancheey.GUI.*;
import com.Seancheey.Timing.TimeCounter;

/*Cowboy Alpha0.1
 * �޸ı���
 * ����ʱ��ʾ��
 * ���Ƽ��̿���
 * ���Ƶ�ͼ
 * �ؿ���
 * ����ǽ
 */

/**
 * @author ������
 *
 */

public class Mainclass {
	public static String version = "Alpha0.1";
	public static MainFrame frame;
	public static RankModifier rankModifier;
	public static TimeCounter timeCounter;

	public static void main(String[] args) {
		rankModifier = new RankModifier();
		timeCounter = new TimeCounter();
		frame = new MainFrame();
		frame.repaint();
	}
}