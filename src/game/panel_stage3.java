package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//import java.applet.*;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.Timer;


public class panel_stage3 extends JPanel implements ActionListener  {

   frame fr;
   JProgressBar p;
   Timer timer;
   Timer endtimer;
   Timer hinttimer;
   int lifeNum=3;
   int questionNum=4;
   int val;
   int pointxx;
   int pointyy;
   Insets m = new Insets(0, 7, 0, 0);

   File Clap =new File("right.wav");
   File Clap2 =new File("wrong.wav");
   File Clap3 =new File("hints.wav");
   
   static int[] imageX = {472, 382, 265, 849};
   static int[] imageY = {79, 136, 243, 10};
   // 틀린부분의 범위 기본 설정값
   static final int range = 20;
   static final int range2 = 10;
   
   boolean f1 = false;
   boolean f2 = false;
   boolean f3 = false;
   boolean f4 = false;
   boolean fx = false;
   boolean h1 = false;
   boolean h2 = false;
   boolean h3 = false;
   
   ImageIcon stage2 = new ImageIcon("stage3.png","Stage2");
   JLabel stage11 = new JLabel(stage2);
   
   
   ImageIcon img = new ImageIcon("image5.jpg","Stage1_image1");
   JLabel bg = new JLabel(img);
   
   
   ImageIcon xig = new ImageIcon("x.png");
   Image x = xig.getImage();
   
   ImageIcon circle = new ImageIcon("circle.png");
   Image cir = circle.getImage();
   
   ImageIcon circle2 = new ImageIcon("hint0.png");
   Image cir2 = circle2.getImage();
   
   ImageIcon dotboki = new ImageIcon("hint.png");
//   ImageIcon dotboki2 = new ImageIcon("hint2.jpg");
   ImageIcon clear2 = new ImageIcon("clear.png");
   Image cle = clear2.getImage();
   
   ImageIcon life1 = new ImageIcon("life1.png","1life");
   ImageIcon life2 = new ImageIcon("life2.png","2life");
   ImageIcon life3 = new ImageIcon("life3.png","3Life");
   JLabel life = new JLabel();   // 목숨에 대한 라벨 : 클릭 수에 따라 변화

   ImageIcon que0 = new ImageIcon("zero.png");
   ImageIcon que1 = new ImageIcon("one.png");
   ImageIcon que2 = new ImageIcon("two.png");
   ImageIcon que3 = new ImageIcon("three.png");
   ImageIcon que4 = new ImageIcon("four.png");
   JLabel question = new JLabel();   // 남은 문제의 갯수 라벨 : 정답 체크 수에 따라 변화
   
   //JLabel clear = new JLabel();
   public panel_stage3(frame fr) {
      
     this.fr = fr;
     setBackground(new Color(252,241,192));
      CustomMouseAdapter cma = new CustomMouseAdapter (); 
      //image1 이미지가 저장된 JPanel a 객체에 감지기 설정
      bg.addMouseListener(cma);
      //image1 이미지가 저장된 JPanel b 객체에 감지기 설정
      
      setBounds(0, 0, 1000, 600);
      setLayout(null);
//      JLabel title = new JLabel("STAGE1 틀린그림찾기");
//      title.setForeground(Color.BLACK);
//      title.setHorizontalAlignment(SwingConstants.LEFT);      
//      title.setBounds(0, 30, 1000, 30);
      JProgressBar progressBar = new JProgressBar();
      ImageIcon pau = new ImageIcon("pause.png","Pause");
      JButton button = new JButton("Pause", pau);
      button.setBorderPainted(false);
      button.setContentAreaFilled(false);
      button.setBounds(910, 505, 57, 50);
      button.setMargin(m);
      JButton Hbutton = new JButton("h",dotboki);
      Hbutton.addActionListener(this);
      Hbutton.setBorderPainted(false);
      Hbutton.setContentAreaFilled(false);
      Hbutton.setBounds(850, 505, 57, 50);
      Hbutton.setMargin(m);
      progressBar.setBackground(Color.white);
      progressBar.setForeground(new Color(184,119,84));
      //progressBar.setBorder(BorderFactory.createLineBorder(Color.green));
      progressBar.setBorderPainted(false);
      progressBar.setBounds(0, 464, 1000, 20);
      
      stage11.setBounds(10, 10, 300, 55);
      life.setBounds(30, 445, 250, 170);
      life.setIcon(new ImageIcon("life3.png","3life"));  
      question.setBounds(390, 428, 250, 200);
      question.setIcon(new ImageIcon("four.png","4que"));
//      dot.setBounds(400, 480, 100, 100);
//      dot.setIcon(new ImageIcon("hint.jpg","dotbogi"));
      //clear.setBounds(150,150,600,300);
      //clear.setIcon(new ImageIcon("clear.jpg"));
//     add(title);
      add(stage11);
      add(progressBar);
      add(life);
      add(question);
//      add(dot);
      add(Hbutton);
      
      add(button);
       progressBar.setValue(100);

       ActionListener updateProBar = new ActionListener() {
         public void actionPerformed(ActionEvent actionEvent) {
           val = progressBar.getValue();
           progressBar.setValue(--val);
           if (val==0 || lifeNum == 0) {
              fr.change2("panel_fail");
              timer.stop();
           }
           System.out.println(progressBar.getValue());
         }
       };

       timer = new Timer(300, updateProBar); //300
       timer.start();
       timer.isRunning();
       
       
       button.addActionListener(new ActionListener() {         //일시정지버튼
         public void actionPerformed(ActionEvent e) {
                   if (timer.isRunning()) {
                     timer.stop();         
                     fr.change("panel_pause3");
                   } 
         }
       });
       Hbutton.addActionListener(new ActionListener() {         //힌트버튼
           public void actionPerformed(ActionEvent e) {
//              if (timer.isRunning()) {
//                   timer.stop();   
//              }
              
              h1=true;
                 bg.repaint();

                  System.out.println("h1의 상태는" + h1);
                  System.out.println("h2의 상태는" + h2);
               if(h3==false) {
                  PlaySound(Clap3);
               }
                  h3=true;
           }
       });
      
      //add(clear);
      //clear.setVisible(false);
      bg.setBounds(0,65,img.getIconWidth(), img.getIconHeight());
      add(bg);
      
      
      setVisible(true);
      
   }

   
   public boolean isRangeof(int index, Point p){         // 좌표값
      //포인트 X좌표를 입력받아 pointX로 저장
            int pointX = p.x;
      //포인트 Y좌표를 입력받아 pointX로 저장
            int pointY = p.y;
      //배열순번과 해당좌표를 입력해 반환
            return (pointX >= imageX[index]-range) && (pointX <= imageX[index]+range) 
                  && (pointY >= imageY[index]-range) && (pointY <= imageY[index]+range);
     }
//   public boolean isRangeof2(int index, Point p){
//         //포인트 X좌표를 입력받아 pointX로 저장
//               int pointX2 = p.x;
//               pointxx = pointX2;
//         //포인트 Y좌표를 입력받아 pointX로 저장
//               int pointY2 = p.y;
//               pointyy = pointY2;
//         //배열순번과 해당좌표를 입력해 반환
//               return (pointX2 >= imageX[index]-range2) && (pointX2 <= imageX[index]+range2) 
//                     && (pointY2 >= imageY[index]-range2) && (pointY2 <= imageY[index]+range2);
//        }
     
   
   class CustomMouseAdapter extends MouseAdapter{
      public void mouseReleased(MouseEvent e) {
       // 마우스클릭한 곳의 x,y좌표값을 얻어와 Point 객체를 생성
       Point p = e.getPoint();

       if (isRangeof(0,p)) {
         if (f1 == false) {
         questionNum--;
         }
          f1 = true; 
          bg.repaint();
   
          PlaySound(Clap);
          
       } else if (isRangeof(1,p)) {
          if (f2 == false) {
             questionNum--;
             }
          f2 = true;
          bg.repaint();
         
          PlaySound(Clap);
          
       } else if (isRangeof(2,p)) {
          if (f3 == false) {
             questionNum--;
             }
          f3 = true;
          bg.repaint();
        
          PlaySound(Clap);
          
       } else if (isRangeof(3,p)) {
          if (f4 == false) {
             questionNum--;
           }
          f4 = true;
          bg.repaint();
       
          PlaySound(Clap);
          
       } else {             // 엑스표시
             lifeNum--;
          System.out.println(lifeNum + "만큼 목숨이 남았다.");
          
          fx = false;
            bg.repaint();
           
           PlaySound(Clap2);
           
          if (lifeNum==2) {
             life.setIcon(life2);
          }
          else if(lifeNum==1) {
             life.setIcon(life1);
          }
//          else if(lifeNum<=0) {
//             fr.change2("panel_fail");
//          }
                       
          
       }
      if (questionNum==4) {
         question.setIcon(que4);
      }
      else if(questionNum==3) {
         question.setIcon(que3);
      }else if(questionNum==2) {
         question.setIcon(que2);
      }else if(questionNum==1) {
         question.setIcon(que1);   
      }else if(questionNum==0) {
         question.setIcon(que0);   
      }
       //       
//       // 틀린부분을 다 찾으면 메세지 출력
   
       if (f1 == true && f2 == true && f3 == true && f4 == true) {
       lifeNum=1000; // 클리어 메시지에 틀린 곳을 클릭해도 이미 성공한 페이지므로 생명에 영향을 미치지 않게한다.
        System.out.println("축하합니다. 다 맞추셨습니다.");
        //여기다가 clear글자를 띄웁니다.
        
        //clear.setVisible(true);
        timerStop();
        ActionListener andthenClear = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
               fr.change("panel_final");          
              //여기다가 다음화면으로 넘어가는 코드를 넣습니다.
              endtimer.stop();     
            }
          };
          
          endtimer = new Timer(2000, andthenClear);
          endtimer.start();
          endtimer.isRunning();
       }
      
//        //다 완료하면 다시 시작을 위해 동그라미 갱신
//        f1 = false;
//        f2 = false;
//        f3 = false;
//        f4 = false;
//        
//        bg.repaint();
//        bg2.repaint();
//       }// if end
         }// mouseReleased()
      public void mousePressed(MouseEvent e) {
         Point p = e.getPoint();
         if (isRangeof(0,p)) {            
         }else if(isRangeof(1,p)) {            
         }else if(isRangeof(2,p)) {           
         }else if(isRangeof(3,p)) {            
         }else {
          int xx=e.getX();
            pointxx = xx;
            int yy=e.getY();
            pointyy = yy;
            System.out.println("x의 좌표 : "+xx+"  y의 좌표 : "+yy);
            fx = true;
            bg.repaint();
            
         }
      }     
   }//CustomMouseAdapter{}


   public void timerStop() {
      timer.stop();      
   }
   public void timerStart() {
      timer.start();      
   }
   static void PlaySound(File Sound)         // 소리 재생
   {
      try{
         Clip clip = AudioSystem.getClip();
         clip.open(AudioSystem.getAudioInputStream(Sound));
         clip.start();
      }
      catch(Exception e)      {         
      }
   }


   @Override
      public void update(Graphics g) {
         // TODO Auto-generated method stub
         super.update(g);
      }
   

   public void paint(Graphics g) {

      super.paint(g);
      // 틀린그림부분에 동그라미 그리기
      if (h1 == true) {                        // 힌트 동그라미 그리기
         if (f1 == false) {
            g.drawImage(cir2, 442, 120, 60, 60, this);
            h2=true;
            System.out.println("f1 실행된다.");
         }
         else {
            
            if(f2 == false && h2 == false) {
                g.drawImage(cir2, 352, 182, 60, 60, this);
               h2=true;
               System.out.println("f2 실행된다.");
               }
            else {
               if(f3 == false && h2 == false) {
                  g.drawImage(cir2, 245, 285, 60, 60, this);
                  h2=true;
                  System.out.println("f3 실행된다.");
               }
            
               else {
                  if(f4 == false && h2 == false) {
                     g.drawImage(cir2, 830, 65, 60, 60, this);
                      h2=true;
                      System.out.println("f4 실행된다.");
                   }
               }
            }
                  
         }
      }
      if (f1 == true) {
         g.drawImage(cir, 442, 120, 60, 60, this);      // 1

      } 
      if (f2 == true) {
         g.drawImage(cir, 352, 182, 60, 60, this);      // 2

      }
      if (f3 == true) {
          g.drawImage(cir, 245, 285, 60, 60, this);      // 3

      }
      if (f4 == true) {
          g.drawImage(cir, 830, 65, 60, 60, this);      // 4
       
      }      
      if (f1==true && f2==true && f3==true && f4==true) {
         g.drawImage(cle, 100, 105, 800, 300, this);
      }
      if (fx==true) {
         g.drawImage(x, pointxx-range, pointyy-range+70, 60, 60, this);
        // g.drawImage(x, pointxx+493-range, pointyy-range+70, 60, 60, this);
      }
      
   }
       
   @Override
   public void actionPerformed(ActionEvent arg0) {
      // TODO Auto-generated method stub
      
   }
}