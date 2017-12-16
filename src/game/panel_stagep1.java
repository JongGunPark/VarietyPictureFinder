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


public class panel_stagep1 extends JPanel implements ActionListener  {
	frame fr;
	Timer timerp1;

	public panel_stagep1(frame fr) {
		this.fr=fr;
		ImageIcon img = new ImageIcon("pre.jpg","Previous_stage1");
		JLabel bg = new JLabel(img);
		ImageIcon readygo = new ImageIcon("readygo.gif");
		JLabel rego = new JLabel(readygo);
		setBounds(0, 0, 1000, 600);
		setLayout(null);
		rego.setBounds(345, 135, 290, 260);
		bg.setBounds(0,0,1000, 600);
		add(rego);
		add(bg);
		setVisible(true);
		
		timerp1 = new Timer(2700, this);
		timerp1.start();
		timerp1.isRunning();
		
	}	
	
	@Override	
	public void actionPerformed(ActionEvent arg0) {
		fr.change("panel_stage1");
		timerp1.stop();
		
	}
    public void update(Graphics g) {
        // TODO Auto-generated method stub
        super.update(g);
     }
    public void timerStop() {
		timerp1.stop();		
	}
  

}