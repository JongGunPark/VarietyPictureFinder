package game;

import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;

public class frame extends JFrame {
	private static final long serialVersionUID = 1L;
	JPanel panel_main;
	

	public frame() {
		setTitle("�پ��� �׸� ã��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon img = new ImageIcon("���.jpg","���");
		panel_main = new panel_main(this);
		add(panel_main);
		
		
		setSize(img.getIconWidth(),img.getIconHeight());
		setVisible(true);
		setResizable(false); // â ũ�� ����
	
		
				
	}
	
	public static void main(String[] args) {
		new frame();
	}
}
