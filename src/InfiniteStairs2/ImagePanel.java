package InfiniteStairs2;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import InfiniteStairs2.Character;
import InfiniteStairs2.Timer;

public class ImagePanel extends JPanel {
	private Image img;
	static boolean moveBackground;
	static int backY = -(2640-650);

	JButton up, change;
	JLabel jl_score;
	JProgressBar pgb;

	 
	public ImagePanel(Image img) {
		 this.img = img;
	      setLayout(null);
	      setLocation(0, 0);
	      setSize(400, 650);  
	}
	
	public void MoveBackground() {
		backY+= 10;
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(img,0,backY,this);
	}
	
	
	
	
//	public void buttonCliked() {
//		ImageIcon ii_bt = new ImageIcon("up.png");
//		img = ii_bt.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
//		ii_bt.setImage(img);
//		up = new JButton(ii_bt);
//		up.setBorderPainted(false);
//		up.setContentAreaFilled(false);
//		up.setLocation(300, 570);
//		up.setSize(50,50);
//				
//		ii_bt = new ImageIcon("change.png");
//		img = ii_bt.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
//		ii_bt.setImage(img);
//		change = new JButton(ii_bt);
//		change.setBorderPainted(false);
//			change.setContentAreaFilled(false);
//		change.setLocation(50, 570);
//		change.setSize(50,50);
////		change.addActionListener(this);
//			
//		pgb = new JProgressBar(JProgressBar.HORIZONTAL,0,5000);
//		pgb.setValue(5000);
//		pgb.setSize(300, 30);
//		pgb.setLocation(50, 520);
//		pgb.setBackground(new Color(90,70,57));
//		pgb.setForeground(new Color(200,71,32));
//		pgb.setBorderPainted(false);
//		
//		jl_score = new JLabel("0");
//		jl_score.setHorizontalAlignment(JLabel.CENTER);
//		jl_score.setFont(new Font("¾ß³îÀÚ ¾ßÃ¼",Font.BOLD,50));
////		jl_score.setForeground(new Color(200,71,32));
//		jl_score.setLocation(150, 570);
//		jl_score.setSize(100, 50);
//		
////		add(character);
//		add(up);
//		add(change);
//		add(pgb);
//		add(jl_score);
//		this.updateUI();
//		
//		
//		
//	}

	

}
