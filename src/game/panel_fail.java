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
   public JButton btnRego;
   frame fr;
   public panel_fail(frame fr) {
      this.fr=fr;
      setBackground(Color.BLACK);
      ImageIcon img = new ImageIcon("fail.gif","Crying Picka");
      ImageIcon lose = new ImageIcon("lose.jpg","You Lose");
       ImageIcon rego = new ImageIcon("rego3.png","regame");
       ImageIcon rego2 = new ImageIcon("rego4.png");
      JLabel bg = new JLabel(img);
      JLabel tt = new JLabel(lose);
      setBounds(0, 0,1000, 600);
      setLayout(null);
      tt.setBounds(300,0,400, 130);
      bg.setBounds(0,0,1000, 600);
       btnRego = new JButton(rego);
       btnRego.addActionListener(this);
       btnRego.setBorderPainted(false);
       btnRego.setContentAreaFilled(false);
       btnRego.setRolloverIcon(rego2);
       btnRego.setBounds(400,445,200,100);
      add(tt);
      add(bg);
      add(btnRego);
      setVisible(true);
      
   }   

   
   @Override
   public void actionPerformed(ActionEvent e) {
            fr.change2("panel_main");      
   }

}
