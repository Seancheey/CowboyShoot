package com.seancheey.data;

import com.seancheey.gui.*;
import com.seancheey.timing.TimeCounter;

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
	public static TimeCounter timeCounter;

	public static void main(String[] args) {
		timeCounter = new TimeCounter();
		frame = new MainFrame();
		frame.repaint();
	}
}