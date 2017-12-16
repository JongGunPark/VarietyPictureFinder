package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class panel_main extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private frame fr;
	public JLabel bg;
	public JButton btn1;
	public JButton btn2;
	
	public panel_main(frame fr) {
		this.fr=fr;
		
		ImageIcon img = new ImageIcon("배경.jpg","배경");
		ImageIcon img2 = new ImageIcon("start.jpg","시작");
		ImageIcon img3= new ImageIcon("howto.jpg","방법");
		setBounds(0, 0, 1000, 600);
		JLabel bg = new JLabel(img);
		btn1 = new JButton("시작");
		btn1.setIcon(img2);
		btn2 = new JButton("방법");
		btn2.setIcon(img3);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		setLayout(null);		
		btn1.setBounds(650,350,200, 80);
		add(btn1);
		btn2.setBounds(650,450,200, 80);
		add(btn2);
		add(bg);
		bg.setBounds(0,0,img.getIconWidth(), img.getIconHeight()); // 1000x600
		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "시작") 
			fr.change("panel_stagep1");
	
		else if (e.getActionCommand() == "방법") {
			fr.change("panel_howto");
			
			
		}
			
		
	}
	


	
}

