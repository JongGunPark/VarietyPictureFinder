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


public class panel_stagep2 extends JPanel implements ActionListener  {
   frame fr;
   Timer timerp2;

   public panel_stagep2(frame fr) {
      this.fr=fr;
      ImageIcon img = new ImageIcon("pre1.jpg","Previous_stage2");
      JLabel bg = new JLabel(img);
      ImageIcon readygo = new ImageIcon("readygo6.gif"); 
      JLabel rego = new JLabel(readygo);
      setBounds(0, 0, 1000, 600);
      setLayout(null);
      rego.setBounds(345, 135, 290, 260);
      bg.setBounds(0,0,995, 574);
      add(rego);
      add(bg);
      setVisible(true);
      
      timerp2 = new Timer(2700, this);
      timerp2.start();
      timerp2.isRunning();
      
   }   
   
   @Override   
   public void actionPerformed(ActionEvent arg0) {
      fr.change("panel_stage2");
      timerp2.stop();
      
   }
    public void update(Graphics g) {
        // TODO Auto-generated method stub
        super.update(g);
     }
    public void timerStop() {
      timerp2.stop();      
   }
  

}