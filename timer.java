package game;

import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
import javax.swing.event.*; 

class timer extends JPanel { 
        JProgressBar p; 

        public timer() { 
                setLayout(null); 
                p = new JProgressBar();
                p.setBackground(Color.white);
                p.setForeground(Color.yellow);
                p.setMinimum(0); 
                p.setMaximum(30); 
                p.setSize(1000, 20);
                p.setValue(0); 

                add(p); 
        } 

        public void go() { 
                try        { 
                        for(int i=30;i>=0;i--) { 	// 30���� 1�ʾ� Ÿ�̸� �۵�
                                p.setValue(i); 
                                Thread.sleep(1000); 	// 1�ʾ� ������
                        } 
                } 
                catch (InterruptedException e) {} 
        } 

//        public Dimension getPreferredSize() { 
//                return new Dimension(300, 80); 
//        } 
//        

        
        public static void main(String[] args) { 
                JFrame f = new  JFrame("Timer"); 
                timer panel = new timer(); 
                f.getContentPane().add(panel); 
                f.setSize(1000,600);  
                f.setVisible(true); 
                panel.go(); 
       
        } 
}