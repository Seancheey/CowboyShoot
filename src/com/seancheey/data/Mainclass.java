package com.seancheey.data;

import com.seancheey.gui.MainFrame;
import com.seancheey.gui.Menu;

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

	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.add(new Menu(frame));
		frame.repaint();
	}
}