package game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class panel_pause extends JPanel implements ActionListener {

	public JButton btn1;
	public JButton btn2;
	frame fr;
	
	public panel_pause(frame fr) {
		
		this.fr = fr;
		
		setBackground(new Color(252,241,192));

		ImageIcon img2 = new ImageIcon("gogo.png","계속하기");
		ImageIcon img3 = new ImageIcon("gogo2.png");
		ImageIcon img4 = new ImageIcon("stop.png","그만하기");
		ImageIcon img5 = new ImageIcon("stop2.png");
		
		setBounds(0, 0, 1000, 600);
		btn1 = new JButton("계속하기", img2);
		btn1.addActionListener(this);
		btn1.setBorderPainted(false);
		btn1.setContentAreaFilled(false);
		btn1.setRolloverIcon(img3);
		
		btn2 = new JButton("그만하기", img4);
		btn2.addActionListener(this);
		btn2.setBorderPainted(false);
		btn2.setContentAreaFilled(false);
		btn2.setRolloverIcon(img5);


		setLayout(null);		
		btn1.setBounds(315,160,370, 130);
		add(btn1);
		btn2.setBounds(315,310,370, 130);
		add(btn2);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "계속하기") 
			fr.change2("panel_stage1");		
		
		else if (e.getActionCommand() == "그만하기")
			fr.change2("panel_main");
	}	
	
	
	
}
