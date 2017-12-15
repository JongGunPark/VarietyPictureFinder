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
import javax.swing.Timer;


public class panel_stage1 extends JPanel implements ActionListener  {
	
   JProgressBar p;
   Timer timer;
 
   static int[] imageX = {269, 7, 470, 136};
   static int[] imageY = {102, 191, 106, 53};
   // Ʋ���κ��� ���� �⺻ ������
   static final int range = 15;
   
   static boolean f1 = false;
   static boolean f2 = false;
   static boolean f3 = false;
   static boolean f4 = false;
   
   ImageIcon img = new ImageIcon("image1.jpg","Stage1_image1");
   JLabel bg = new JLabel(img);
   
   ImageIcon img2 = new ImageIcon("image2.jpg","Stage1_image2");
   JLabel bg2 = new JLabel(img2);
   
   ImageIcon circle = new ImageIcon("circle.png");
   Image cir = circle.getImage();
   
//	int lifeNum=3;
//	ImageIcon lifeIcon;
//	ImageIcon life3 = new ImageIcon("Life3.jpg","3Life");
//	ImageIcon life2 = new ImageIcon("Life2.jpg","2life");
//	ImageIcon life1 = new ImageIcon("Life1.jpg","1life");
	
   public panel_stage1(frame fr) {
	   setBackground(new Color(252,241,192));
      CustomMouseAdapter cma = new CustomMouseAdapter (); 
      //image1 �̹����� ����� JPanel a ��ü�� ������ ����
      bg.addMouseListener(cma);
      //image1 �̹����� ����� JPanel b ��ü�� ������ ����
      bg2.addMouseListener(cma);
      
      setBounds(0, 0, 1000, 600);
      setLayout(null);
      JProgressBar progressBar = new JProgressBar();
       JButton button = new JButton("Pause");
      progressBar.setBackground(Color.white);
       progressBar.setForeground(Color.YELLOW);
       //progressBar.setBorder(BorderFactory.createLineBorder(Color.green));
       progressBar.setBorderPainted(false);
       progressBar.setBounds(0, 470, 1000, 20);
       button.setBounds(870, 500, 100, 30);
//	    LifeControl();
//	    lifeDraw.setBounds(100, 500, 100, 50);
//	    add(lifeDraw);
       add(progressBar);
       add(button);
       progressBar.setValue(100);

       ActionListener updateProBar = new ActionListener() {
         public void actionPerformed(ActionEvent actionEvent) {
           int val = progressBar.getValue();
           progressBar.setValue(--val);
           System.out.println(progressBar.getValue());
         }
       };

       timer = new Timer(300, updateProBar);
       timer.start();
       timer.isRunning();

       

       button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
           if (timer.isRunning()) {
             timer.stop();
             button.setText("Start");
           } else if (button.getText() != "Pause") {
             timer.start();
             button.setText("Pause");
           }
         }
       });
      //timer();
      bg.setBounds(10,55,img.getIconWidth(), img.getIconHeight());
      add(bg);
      bg2.setBounds(502,55,img2.getIconWidth(), img2.getIconHeight());
      add(bg2);
      
      setVisible(true);
      
   }

   
   public boolean isRangeof(int index, Point p){
      //����Ʈ X��ǥ�� �Է¹޾� pointX�� ����
            int pointX = p.x;
      //����Ʈ Y��ǥ�� �Է¹޾� pointX�� ����
            int pointY = p.y;
      //�迭������ �ش���ǥ�� �Է��� ��ȯ
            return (pointX >= imageX[index]-range) && (pointX <= imageX[index]+range) 
                  && (pointY >= imageY[index]-range) && (pointY <= imageY[index]+range);
     }
     
   
   class CustomMouseAdapter extends MouseAdapter{
      public void mouseReleased(MouseEvent e) {
       // ���콺Ŭ���� ���� x,y��ǥ���� ���� Point ��ü�� ����
       Point p = e.getPoint();
       if (isRangeof(0,p)) {
          f1 = true; 
          bg.repaint();
          bg2.repaint(); //���ʸ�� ���׶�� ǥ�ø� ���� repaint

       } else if (isRangeof(1,p)) {
          f2 = true;
          bg.repaint();
          bg2.repaint();

       } else if (isRangeof(2,p)) {
          f3 = true;
          bg.repaint();
          bg2.repaint();

       } else if (isRangeof(3,p)) {
          f4 = true;
          bg.repaint();
          bg2.repaint();

       } 
//       
//       // Ʋ���κ��� �� ã���� �޼��� ���
//       if (f1 == true && f2 == true && f3 == true && f4 == true) {
//        JOptionPane.showMessageDialog(null, "�����մϴ�.");
//        //�� �Ϸ��ϸ� �ٽ� ������ ���� ���׶�� ����
//        f1 = false;
//        f2 = false;
//        f3 = false;
//        f4 = false;
//        
//        bg.repaint();
//        bg2.repaint();
//       }// if end
      	}// mouseReleased()
      }//CustomMouseAdapter{}


   public void timerStop() {
		timer.stop();		
	}
//	public void LifeControl() {
//
//		if (lifeNum==3) {
//			lifeIcon = life3;
//			System.out.println("����˴ϴ�.");
//			}
//		else if (lifeNum==2) {
//			lifeIcon = life2;
//			}
//		else {
//			lifeIcon = life1;
//			}
//		}
   @Override
      public void update(Graphics g) {
         // TODO Auto-generated method stub
         super.update(g);
      }
   

   public void paint(Graphics g) {

      super.paint(g);
      // ���׶�� ���� �������� ǥ��
      g.setColor(Color.RED);
      // Ʋ���׸��κп� ���׶�� �׸���
      if (f1 == true) {
         g.drawImage(cir, 252, 130, 60, 60, this);      //�Ķ���
         g.drawImage(cir, 742, 130, 60, 60, this);
      } 
      if (f2 == true) {
         g.drawImage(cir, 7, 225, 60, 60, this);      //����
         g.drawImage(cir, 499, 225, 60, 60, this);
      }
      if (f3 == true) {
          g.drawImage(cir, 442, 145, 60, 60, this);      //����
          g.drawImage(cir, 932, 145, 60, 60, this);
      }
      if (f4 == true) {
          g.drawImage(cir, 123, 83, 60, 60, this);      //�ź��� ��
          g.drawImage(cir, 610, 83, 60, 60, this);
      }
   }
    
    
    
   @Override
   public void actionPerformed(ActionEvent arg0) {
      // TODO Auto-generated method stub
      
   }
}