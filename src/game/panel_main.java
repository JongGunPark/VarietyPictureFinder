package game;

import java.awt.Insets;
import java.awt.event.ActionEvent;
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
   Insets m = new Insets(0, 14, 0, 0); // Inset이 여백값 설정
   
   public panel_main(frame fr) {
      this.fr=fr;
      ImageIcon img = new ImageIcon("배경.jpg","배경");
      ImageIcon img2 = new ImageIcon("start.png","시작");
      ImageIcon img22 = new ImageIcon("start2.png");
      
      ImageIcon img3= new ImageIcon("howto.png","방법");
      ImageIcon img33= new ImageIcon("howto2.png");
      
      setBounds(0, 0, 1000, 600);
      JLabel bg = new JLabel(img);
      btn1 = new JButton("시작");
      btn1.setIcon(img2);
      btn1.addActionListener(this);
      btn1.setBorderPainted(false);
      btn1.setContentAreaFilled(false);
      btn1.setFocusPainted(false);
      btn1.setRolloverIcon(img22);
      
      
      btn2 = new JButton("방법");
      btn2.setIcon(img3);
      btn2.addActionListener(this);
      btn2.setBorderPainted(false);
      btn2.setContentAreaFilled(false);
      btn2.setFocusPainted(false);
      btn2.setRolloverIcon(img33);
      
      setLayout(null);      
      btn1.setBounds(630,350,192, 80);
      btn1.setMargin(m);
      add(btn1);
      btn2.setBounds(630,450,192, 80);
      btn2.setMargin(m);
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