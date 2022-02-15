package InfiniteStairs2;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import InfiniteStairs2.Character;
import InfiniteStairs2.Timer;

public class ImagePanel extends JPanel {
//	private Image img;
	int imageNumber; 
	String[] imgPath = {"background1.png", "background2.png"};
	static boolean moveBackground;
	static int backY = -(2640-650);

	JButton up, change;
	JLabel jl_score;
	JProgressBar pgb;
	ImageIcon ii;
	Image img;

	 
	public ImagePanel() {
		imageNumber = 0;
		setBackgroundImage();
		
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
	
	
	public void setBackgroundImage() {
		img = new ImageIcon(imgPath[imageNumber]).getImage().getScaledInstance(400, 2640, Image.SCALE_SMOOTH);
		if(imageNumber==1) {
			backY = -(2640-650);
			imageNumber= -1;
		}
		imageNumber++;
	}
	

}
