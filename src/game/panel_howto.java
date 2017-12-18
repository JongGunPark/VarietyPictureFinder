package game;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class panel_howto extends JPanel implements ActionListener {
   
   frame fr;
   public JButton butt;
   Insets m = new Insets(0, 14, 0, 0);
   
   public panel_howto(frame fr) {
      this.fr = fr;
      
      ImageIcon img = new ImageIcon("설명2.jpg","설명");
      
      ImageIcon im= new ImageIcon("START.png","게임시작");
      ImageIcon im2= new ImageIcon("START2.png");
      
      setBounds(0, 0, 1000, 600);
      JLabel bg = new JLabel(img);
      
      butt = new JButton("게임시작");
      butt.setIcon(im);
      butt.addActionListener(this);
      butt.setBorderPainted(false);
      butt.setContentAreaFilled(false);
      butt.setFocusPainted(false);
      butt.setRolloverIcon(im2);
      butt.setMargin(m);
      
      
      setBounds(0, 0, 1000, 600);
      setLayout(null);
      
      butt.setBounds(430,450,197, 80);
      add(butt);
      bg.setBounds(0,0,1000, 600);
      add(bg);
      setVisible(true);
      
   }   


   
   public void actionPerformed(ActionEvent e) {
      if (e.getActionCommand() == "게임시작") 
         fr.change2("panel_stagep1");
   }
}