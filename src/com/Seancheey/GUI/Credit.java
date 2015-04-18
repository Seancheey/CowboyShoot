package com.Seancheey.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.Seancheey.Data.Mainclass;

public class Credit extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	private static int labelNum = 12;
	private static JLabel[] label = new JLabel[labelNum];
	private static JLabel title = new JLabel("Credit");
	private static int py;
	private static JButton exitbutton = new JButton("exit");

	public Credit() {
		GuiTool.initializePanel(this);
		initialize();
		setBackground(Color.BLACK);
		// title
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Bradley Hand ITC", Font.BOLD, 50));
		title.setSize(title.getPreferredSize());
		title.setLocation(
				(int) ((MainFrame.frameSize.width - title.getWidth()) / 2), py);
		add(title);
		// label
		label[0] = new JLabel("Designer:");
		label[1] = new JLabel("Sean Shan");
		label[2] = new JLabel("Art:");
		label[3] = new JLabel("Sean Shan");
		label[4] = new JLabel("Will Wang");
		label[5] = new JLabel("Spectator:");
		label[6] = new JLabel("MaomiHz");
		label[7] = new JLabel("-------------------------");
		label[8] = new JLabel("email: adls371@163.com");
		label[9] = new JLabel("---West Guardian---");
		label[10] = new JLabel(Mainclass.version);
		label[11] = new JLabel("HFLS Developer Team :)");
		for (int ba = 0; ba < labelNum; ba++) {
			label[ba].setForeground(Color.WHITE);
			label[ba].setFont(new Font("serif", Font.BOLD, 21));
			label[ba].setSize(label[ba].getPreferredSize());
			label[ba]
					.setLocation((int) ((MainFrame.frameSize.width - label[ba]
							.getWidth()) / 2), py + title.getHeight() + 50 + ba
							* (label[0].getHeight() + 20));
			add(label[ba]);
		}
		// button
		exitbutton.setFont(new Font("Bradley Hand ITC", Font.BOLD, 50));
		exitbutton.setSize(exitbutton.getPreferredSize());
		exitbutton.setLocation(
				GuiTool.fitWidth(890 - exitbutton.getWidth()),
				GuiTool.fitHeight(580 - exitbutton.getHeight()));
		exitbutton.setBorderPainted(false);
		exitbutton.setBackground(Color.BLACK);
		exitbutton.setForeground(Color.WHITE);
		exitbutton.addActionListener(this);
		exitbutton.setFocusable(false);
		add(exitbutton);
	}

	public static void initialize() {
		py = GuiTool.fitHeight(550);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		title.setLocation(
				(int) ((MainFrame.frameSize.width - title.getWidth()) / 2), py);
		for (int ba = 0; ba < labelNum; ba++)
			label[ba]
					.setLocation((int) ((MainFrame.frameSize.width - label[ba]
							.getWidth()) / 2), py + title.getHeight() + 50 + ba
							* (label[0].getHeight() + 20));
		try {
			Thread.sleep(20);
			py -= 2;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		MainFrame.getFrame().repaint();
	}

	public void actionPerformed(ActionEvent e) {
		initialize();
		GuiTool.switchPanel(this, MainPanel.menu);
	}

}
