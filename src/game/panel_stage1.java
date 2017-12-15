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
   long startTime; 
   boolean gameEnd=false;
   boolean pause=false;
   boolean pauseStart=false;
   
   
   static int[] imageX = {269, 7, 470, 136};
   static int[] imageY = {102, 191, 106, 53};
   // 틀린부분의 범위 기본 설정값
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
   
   public panel_stage1(frame fr) {
      
      CustomMouseAdapter cma = new CustomMouseAdapter (); 
      //image1 이미지가 저장된 JPanel a 객체에 감지기 설정
      bg.addMouseListener(cma);
      //image1 이미지가 저장된 JPanel b 객체에 감지기 설정
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

       Timer timer = new Timer(300, updateProBar);
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
	   //포인트 X좌표를 입력받아 pointX로 저장
	   		int pointX = p.x;
	   //포인트 Y좌표를 입력받아 pointX로 저장
	   		int pointY = p.y;
	   //배열순번과 해당좌표를 입력해 반환
	   		return (pointX >= imageX[index]-range) && (pointX <= imageX[index]+range) 
	   				&& (pointY >= imageY[index]-range) && (pointY <= imageY[index]+range);
	  }
	  
   
   class CustomMouseAdapter extends MouseAdapter{
	   public void mouseReleased(MouseEvent e) {
	    // 마우스클릭한 곳의 x,y좌표값을 얻어와 Point 객체를 생성
	    Point p = e.getPoint();
	    if (isRangeof(0,p)) {
	    	f1 = true; 
	    	bg.repaint();
	    	bg2.repaint(); //양쪽모두 동그라미 표시를 위한 repaint

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
//	    // 틀린부분을 다 찾으면 메세지 출력
//	    if (f1 == true && f2 == true && f3 == true && f4 == true) {
//	     JOptionPane.showMessageDialog(null, "축하합니다.");
//	     //다 완료하면 다시 시작을 위해 동그라미 갱신
//	     f1 = false;
//	     f2 = false;
//	     f3 = false;
//	     f4 = false;
//	     
//	     bg.repaint();
//	     bg2.repaint();
//	    }// if end
	   }// mouseReleased()
	  }//CustomMouseAdapter{}


   
   @Override
      public void update(Graphics g) {
         // TODO Auto-generated method stub
         super.update(g);
      }
   

   public void paint(Graphics g) {

	   super.paint(g);
	   // 동그라미 색깔 빨강으로 표시
	   g.setColor(Color.RED);
	   // 틀린그림부분에 동그라미 그리기
	   if (f1 == true) {
		   g.drawImage(cir, 252, 130, 60, 60, this);		//파란애
		   g.drawImage(cir, 742, 130, 60, 60, this);
	   } 
	   if (f2 == true) {
		   g.drawImage(cir, 7, 225, 60, 60, this);		//가방
		   g.drawImage(cir, 499, 225, 60, 60, this);
	   }
	   if (f3 == true) {
	    	g.drawImage(cir, 442, 145, 60, 60, this);		//구름
	    	g.drawImage(cir, 932, 145, 60, 60, this);
	   }
	   if (f4 == true) {
	    	g.drawImage(cir, 123, 83, 60, 60, this);		//거북이 등
	    	g.drawImage(cir, 610, 83, 60, 60, this);
	   }
   }
    
    
    
   @Override
   public void actionPerformed(ActionEvent arg0) {
      // TODO Auto-generated method stub
      
   }
}