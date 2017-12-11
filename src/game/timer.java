package game;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class timer {
  public static void main(String[] args) {
    JProgressBar progressBar = new JProgressBar();
    JButton button = new JButton("Pause");
    
	progressBar.setBackground(Color.white);
    progressBar.setForeground(Color.yellow);
   
    
    JFrame f = new JFrame();
    f.setLayout(null);
    f.setSize(1000,600);
    progressBar.setBounds(0, 0, 1000, 20);
    button.setBounds(870, 30, 100, 30);
    f.add(progressBar);
    f.add(button);
    
    progressBar.setValue(100);
    ActionListener updateProBar = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        int val = progressBar.getValue();
        progressBar.setValue(--val);
        System.out.println(progressBar.getValue());
      }
    };
    

    Timer   timer = new Timer(50, updateProBar);
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

    
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
  }
}