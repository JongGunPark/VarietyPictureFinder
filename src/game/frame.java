package game;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;
//import java.awt.Cursor;

public class frame extends JFrame {
   private static final long serialVersionUID = 1L;
   JPanel panel_main;
   JPanel panel_fail;
   JPanel panel_stagep1;
   JPanel panel_stage1;
   JPanel panel_stage2;
   JPanel panel_stage3;
   JPanel panel_howto;
   JPanel panel_pause;
   JPanel panel_pause2;
   JPanel panel_pause3;
   JPanel panel_stagep2;
   JPanel panel_stagep3;
   JPanel panel_final;
   
   long startTime;

   
   public frame() {
      startTime = System.currentTimeMillis();
      CustomCursor();
//      Cursor myCursor = tk.createCustomCursor(img,new Point(10,10), "Pen");
      setTitle("다양한 그림 찾기");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ImageIcon img = new ImageIcon("배경.jpg","배경");
      panel_main = new panel_main(this);

      setSize(img.getIconWidth(),img.getIconHeight());
      setLayout(null);
   
      add(panel_main);
      panel_main.setVisible(true);      
      
      panel_stagep1 = new panel_stagep1(this);
      add(panel_stagep1);      
      panel_stagep1.setVisible(false);
      ((game.panel_stagep1) panel_stagep1).timerStop();
      
      panel_stage1 = new panel_stage1(this);
      add(panel_stage1);      
      panel_stage1.setVisible(false);
      ((game.panel_stage1) panel_stage1).timerStop();

      panel_fail = new panel_fail(this);
      add(panel_fail);
      panel_fail.setVisible(false);
      
      panel_stagep2 = new panel_stagep2(this);
      add(panel_stagep2);      
      panel_stagep2.setVisible(false);
      ((game.panel_stagep2) panel_stagep2).timerStop();
      
      panel_stagep3 = new panel_stagep3(this);
      add(panel_stagep3);      
      panel_stagep3.setVisible(false);
      ((game.panel_stagep3) panel_stagep3).timerStop();
      
      panel_stage2 = new panel_stage2(this);
      add(panel_stage2);
      panel_stage2.setVisible(false);
      ((game.panel_stage2) panel_stage2).timerStop();
      
      panel_stage3 = new panel_stage3(this);
      add(panel_stage3);
      panel_stage3.setVisible(false);
      ((game.panel_stage3) panel_stage3).timerStop();
      
      panel_howto = new panel_howto(this);
      add(panel_howto);
      panel_howto.setVisible(false);
      
      panel_pause = new panel_pause(this);
       add(panel_pause);
       panel_pause.setVisible(false);
       
       panel_pause2 = new panel_pause2(this);
       add(panel_pause2);
       panel_pause2.setVisible(false);
       
       panel_pause3 = new panel_pause3(this);
       add(panel_pause3);
       panel_pause3.setVisible(false);
       
       panel_final = new panel_final(this);
       add(panel_final);
       panel_final.setVisible(false);
      
      setVisible(true);
      setResizable(false); // 창 크기 고정                  
   }

   
   public void change(String panel_name) {
      if(panel_name.equals("panel_howto")) {
         panel_main.setVisible(false);
      
         remove(panel_howto);
         panel_howto = new panel_howto(this);
         add(panel_howto);
         panel_howto.setVisible(true);
         
      }
      else if(panel_name.equals("panel_stagep1")) {
         panel_pause.setVisible(false);
         panel_main.setVisible(false);
         
         remove(panel_stagep1);
         panel_stagep1 = new panel_stagep1(this);
         add(panel_stagep1);
         panel_stagep1.setVisible(true);         
         }
      
      else if(panel_name.equals("panel_stagep2")) {
          panel_pause.setVisible(false);
          panel_stage1.setVisible(false);
          
          remove(panel_stagep2);
          panel_stagep2 = new panel_stagep2(this);
          add(panel_stagep2);
          panel_stagep2.setVisible(true);         
          }
      
      else if(panel_name.equals("panel_stagep3")) {
          panel_pause2.setVisible(false);
          panel_stage2.setVisible(false);
          
          remove(panel_stagep3);
          panel_stagep3 = new panel_stagep3(this);
          add(panel_stagep3);
          panel_stagep3.setVisible(true);         
          }
      
      else if(panel_name.equals("panel_final")) {
          panel_pause3.setVisible(false);
          panel_stage3.setVisible(false);
          
          remove(panel_stage3);
          panel_final = new panel_final(this);
          add(panel_final);
          panel_final.setVisible(true);         
          }
      
      else if(panel_name.equals("panel_pause")){
            panel_stage1.setVisible(false);
            
            panel_pause = new panel_pause(this);
            add(panel_pause);
            panel_pause.setVisible(true);
         }
      else if(panel_name.equals("panel_pause2")){
          panel_stage2.setVisible(false);
          
          panel_pause2 = new panel_pause2(this);
          add(panel_pause2);
          panel_pause2.setVisible(true);
       }
      else if(panel_name.equals("panel_pause3")){
          panel_stage3.setVisible(false);
          
          panel_pause3 = new panel_pause3(this);
          add(panel_pause3);
          panel_pause3.setVisible(true);
       }
      
      
      
      else if(panel_name.equals("panel_fail")) {
         remove(panel_stage1);
         panel_stage1.setVisible(false);

         panel_fail.setVisible(true);         
      }
      else if(panel_name.equals("panel_stage1")) {
         panel_stagep1.setVisible(false);
         
         remove(panel_stage1);
         panel_stage1 = new panel_stage1(this);
         add(panel_stage1);
         panel_stage1.setVisible(true);
         
      }
      
      
//      else if(panel_name.equals("panel_stage1")) {
//         panel_main.setVisible(false);
//         
//         remove(panel_stage1);
//         panel_stage1 = new panel_stage1(this);
//         add(panel_stage1);
//         panel_stage1.setVisible(true);
//         
//      }
      else if(panel_name.equals("panel_stage2")) {
         panel_stagep2.setVisible(false);
         remove(panel_stage2);
         panel_stage2 = new panel_stage2(this);
         add(panel_stage2);
         panel_stage2.setVisible(true);         
      }
      
      else if(panel_name.equals("panel_stage3")) {
          panel_stagep3.setVisible(false);
          remove(panel_stage3);
          panel_stage3 = new panel_stage3(this);
          add(panel_stage3);
          panel_stage3.setVisible(true);         
       }
      
   }
   
   
   
    public void change2(String Panel_name) {
         if(Panel_name.equals("panel_stage1")){
            panel_pause.setVisible(false);

             panel_stage1.setVisible(true);
             ((game.panel_stage1) panel_stage1).timerStart();

         }
         
         else if(Panel_name.equals("panel_main")){
           remove(panel_stage1);
           panel_fail.setVisible(false);
            panel_pause.setVisible(false);
            
            remove(panel_stage2);
             panel_pause2.setVisible(false);
             
             remove(panel_stage3);
             panel_pause3.setVisible(false);
             
             remove(panel_final);
             panel_final.setVisible(false);
            
            panel_main.setVisible(true);
         }
         else if(Panel_name.equals("panel_stagep1")){
               panel_howto.setVisible(false);         
               remove(panel_stagep1);
               panel_stagep1 = new panel_stagep1(this);
               add(panel_stagep1);
               panel_stagep1.setVisible(true);         
               }
         else if(Panel_name.equals("panel_stage2")){
             panel_pause2.setVisible(false);

              panel_stage2.setVisible(true);
              ((game.panel_stage2) panel_stage2).timerStart();

          }
         else if(Panel_name.equals("panel_stage3")){
             panel_pause3.setVisible(false);

              panel_stage3.setVisible(true);
              ((game.panel_stage3) panel_stage3).timerStart();

          }
         
         else if(Panel_name.equals("panel_fail")) {
             remove(panel_stage2);
             panel_stage2.setVisible(false);
             
             remove(panel_stage3);

             panel_fail.setVisible(true);         
          }
         
         
    }
    
    
    public void CustomCursor() {
       Toolkit toolkit = Toolkit.getDefaultToolkit();
       Image img = toolkit.getImage("pen1.png");
       Point point = new Point(10,10);
       Cursor cursor = toolkit.createCustomCursor(img, point, "cursor");
       setCursor(cursor);
    }
      
   
   public static void main(String[] args) {
      new frame();
   }
}