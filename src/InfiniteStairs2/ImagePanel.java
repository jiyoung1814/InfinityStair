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
		backY = -(2640-650);
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
	
	
	

}
