package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.Timer;


public class panel_fail extends JPanel implements ActionListener  {
	frame fr;
	public panel_fail(frame fr) {
		this.fr=fr;
		ImageIcon img = new ImageIcon("fail.gif","How_to");
		JLabel bg = new JLabel(img);
		setBounds(0, 0, 600, 600);
		setLayout(null);

		bg.setBounds(0,0,1000, 600);
		add(bg);
		setVisible(true);
		
	}	

		
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
