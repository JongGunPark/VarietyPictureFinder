package game;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class panel_main extends JPanel{

	public panel_main(frame fr) {
		ImageIcon img = new ImageIcon("배경.jpg","배경");
		ImageIcon img2 = new ImageIcon("start.jpg","시작");
		ImageIcon img3= new ImageIcon("howto.jpg","방법");
		
		JLabel bg = new JLabel(img);
		JButton st = new JButton(img2);
		JButton ht = new JButton(img3);

		setLayout(null);
		add(st);
		st.setBounds(650,350,img2.getIconWidth(), img2.getIconHeight());
		add(ht);
		ht.setBounds(650,450,img3.getIconWidth(), img3.getIconHeight());
		add(bg);
		bg.setBounds(0,0,img.getIconWidth(), img.getIconHeight()); // 1000x600

		
		setVisible(true);
	}
	
}
