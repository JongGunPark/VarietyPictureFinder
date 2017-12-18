package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class panel_final extends JPanel implements ActionListener {
   public JButton btnRego;
   frame fr;
   long endTime;
   int score;
   Font f1;
   public panel_final(frame fr) {
      this.fr = fr;
      f1 = new Font("�����ձ۾� ��", Font.BOLD, 50);
      endTime = System.currentTimeMillis();
      ImageIcon img = new ImageIcon("final.jpg","���Ϲ��");
      ImageIcon img2= new ImageIcon("f.gif","��ī��");
      ImageIcon im= new ImageIcon("START.png","���ӽ���");
      ImageIcon im2= new ImageIcon("START2.png");
      ImageIcon rego = new ImageIcon("rego3.png","regame");
      ImageIcon rego2 = new ImageIcon("rego4.png");
      score=(int) ((endTime-fr.startTime)/10);
      setBounds(0, 0, 1000, 600);
      JLabel sc = new JLabel("���� ���� : " + score + "��");
	  sc.setForeground(Color.BLACK);
	  sc.setFont(f1);
	  sc.setHorizontalAlignment(SwingConstants.CENTER);      
	  sc.setBounds(220, 420, 600, 50);
      JLabel bg = new JLabel(img);
      JLabel pk = new JLabel(img2);
      btnRego = new JButton(rego);
      btnRego.addActionListener(this);
      btnRego.setBorderPainted(false);
      btnRego.setContentAreaFilled(false);
      btnRego.setRolloverIcon(rego2);
      System.out.println((endTime-fr.startTime)/1000);
      
      setBounds(0, 0, 1000, 600);
      setLayout(null);
      
      
      btnRego.setBounds(430,480,197, 80);
      pk.setBounds(250,120,500, 280);
      add(pk);
      add(sc);
      add(btnRego);
      bg.setBounds(0,0,1000, 600);
      add(bg);
      setVisible(true);
      
   }   


   
   public void actionPerformed(ActionEvent e) {
         fr.change3("panel_main");
   }
}