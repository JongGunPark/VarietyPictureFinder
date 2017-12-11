package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class panel_stage1 extends JPanel implements ActionListener {
//	public JPanel timer = new timer();
	 JProgressBar p; 
	long startTime; 
	boolean gameEnd=false;
	boolean pause=false;
	boolean pauseStart=false;
	
	public panel_stage1(frame fr) {
		startTime = System.currentTimeMillis(); 
		System.out.print(startTime);
		ImageIcon img = new ImageIcon("게임예시.jpg","게임예시");
		JLabel bg = new JLabel(img);
		setBounds(0, 0, 1000, 600);
		setLayout(null);
		
//		timer();
		bg.setBounds(0,0,img.getIconWidth(), img.getIconHeight());
		add(bg);
		setVisible(true);
		
	}

//	
//	public void timer() { 
//        setLayout(null); 
//        p = new JProgressBar();
//        p.setBackground(Color.white);
//        p.setForeground(Color.yellow);
//        p.setMinimum(0); 
//        p.setMaximum(30000); 
//        p.setBounds(0, 300, 1000, 20);
//        p.setValue(0);
//        add(p); 
//        
//	}
//	
//	
//	
//	
//	@Override
//		protected void paintComponent(Graphics g) {
//			super.paintComponent(g);
//			
//			long time_l = System.currentTimeMillis() - startTime;
//	        p.setValue((int)time_l);
//	        int time = (int)time_l/1000;
//	        long pStartTime = 0;
//	        
//	        
//	        
//	        
//	        if(pause==true) {
//	        	if(pauseStart == true) {
//		        	pStartTime = System.currentTimeMillis();
//	        		pauseStart = false;
//	        	}
//	        	long pEndTime = System.currentTimeMillis();
//	        	
//	        	long pauseTime = pEndTime - pStartTime;
//	        	// start에다가 pause 시간을 더해주고 , end 
//	        }0  12  16
//	        
//	        
//	        
////	        if(time>30) {
////	        	gameEnd = true;
////	        }
////	        
////	        if(gameEnd == true) {
////	        	
////	        	
////	        }
//			repaint();
//			
//		}
	@Override
		public void update(Graphics g) {
			// TODO Auto-generated method stub
			super.update(g);
		}
	

	 
	 
	 
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
