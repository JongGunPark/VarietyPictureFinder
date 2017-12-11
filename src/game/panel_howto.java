package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class panel_howto extends JPanel implements ActionListener {
	
	public panel_howto(frame fr) {
		ImageIcon img = new ImageIcon("배경.jpg","하는방법");
		JLabel bg = new JLabel(img);
		setBounds(0, 0, 1000, 600);
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
