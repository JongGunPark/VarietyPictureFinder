package game;

import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;

public class frame extends JFrame {
	private static final long serialVersionUID = 1L;
	JPanel panel_main;
	

	public frame() {
		setTitle("다양한 그림 찾기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon img = new ImageIcon("배경.jpg","배경");
		panel_main = new panel_main(this);
		add(panel_main);
		
		
		setSize(img.getIconWidth(),img.getIconHeight());
		setVisible(true);
		setResizable(false); // 창 크기 고정
	
		
				
	}
	
	public static void main(String[] args) {
		new frame();
	}
}
