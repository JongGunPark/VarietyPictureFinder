package game;

import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;

public class frame extends JFrame {
   private static final long serialVersionUID = 1L;
   JPanel panel_main;
   JPanel panel_stage1;
   JPanel panel_howto;
   JPanel panel_pause;
   
   public frame() {
      setTitle("다양한 그림 찾기");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ImageIcon img = new ImageIcon("배경.jpg","배경");
      panel_main = new panel_main(this);

      setSize(img.getIconWidth(),img.getIconHeight());
      setLayout(null);
   
      add(panel_main);
      panel_main.setVisible(true);
         
      panel_stage1 = new panel_stage1(this);
      add(panel_stage1);
      panel_stage1.setVisible(false);
      ((game.panel_stage1) panel_stage1).timerStop();
      
      panel_howto = new panel_howto(this);
      add(panel_howto);
      panel_howto.setVisible(false);
      
      panel_pause = new panel_pause(this);
      add(panel_pause);
      panel_pause.setVisible(false);
      
      
      setVisible(true);
      setResizable(false); // 창 크기 고정                  
   }
//   public void stage1() {
//      panel_main.setVisible(false);
//      panel_stage1.setVisible(true);
//   }
//   public void howto() {
//      panel_main.setVisible(false);
//      add(panel_howto);
//      panel_howto.setVisible(true);
//   }
//   
   
   public void change(String panel_name) {
      if(panel_name.equals("panel_howto")) {
         panel_main.setVisible(false);
      
         remove(panel_howto);
         
         panel_howto = new panel_howto(this);
         add(panel_howto);
         panel_howto.setVisible(true);
         
      }
      else if(panel_name.equals("panel_stage1")) {
         panel_main.setVisible(false);
         panel_howto.setVisible(false);
         
         remove(panel_stage1);
         
         panel_stage1 = new panel_stage1(this);
         add(panel_stage1);
         panel_stage1.setVisible(true);
         
      }
      else if(panel_name.equals("panel_pause")){
    	  panel_stage1.setVisible(false);
    	  
    	  panel_pause = new panel_pause(this);
    	  add(panel_pause);
    	  panel_pause.setVisible(true);
      }
      
   }
   
   public void change2(String Panel_name) {
	   if(Panel_name.equals("panel_stage1")){
		   panel_pause.setVisible(false);

	       panel_stage1.setVisible(true);
	       ((game.panel_stage1) panel_stage1).timerStart();

	   }
	   
	   else if(Panel_name.equals("panel_main")){
		   panel_pause.setVisible(false);
		   remove(panel_pause);
		   remove(panel_stage1);
		   
		   panel_main = new panel_main(this);
		   add(panel_main);
		   panel_main.setVisible(true);
	   }
   }
   
   public static void main(String[] args) {
      new frame();
   }
}