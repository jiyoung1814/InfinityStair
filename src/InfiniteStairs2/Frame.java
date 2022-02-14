package InfiniteStairs2;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame implements ActionListener{
	Container c;
	ImagePanel jp;
	JLabel character;
	JLabel title,background;
	JButton jb1,jb2,jb3;
	Frame2 f2;

	public Frame() {
		c = getContentPane();
		c.setLayout(null);
		
		ImageIcon ii_jp = new ImageIcon("background.png");
		Image img = ii_jp.getImage().getScaledInstance(450, 650, Image.SCALE_SMOOTH);
		jp = new ImagePanel(new ImageIcon("background.png").getImage().getScaledInstance(400, 2640, Image.SCALE_SMOOTH));
			
		ImageIcon ii_title = new ImageIcon("title.png");
		title = new JLabel(ii_title);
		title.setLocation(50, 50);
		title.setSize(300, 150);
		
		ImageIcon ii = new ImageIcon("boxer1.png");
		img = ii.getImage().getScaledInstance(70, 150, Image.SCALE_SMOOTH);
		ii.setImage(img);
		character = new JLabel(ii);
		character.setSize(70, 150);
		character.setLocation(150, 300);
		
		ImageIcon ii_bt = new ImageIcon("button1.png");
		img = ii_bt.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
		ii_bt.setImage(img);
		jb1 = new JButton(ii_bt);
		jb1.setBorderPainted(false);
		jb1.setContentAreaFilled(false);
		jb1.setLocation(50, 550);
		jb1.setSize(75,75);
		jb1.setBackground(new Color(255,210,123));
		jb1.setBorderPainted(false);
		jb1.addActionListener(this);
		
		ii_bt = new ImageIcon("button2.png");
		img = ii_bt.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
		ii_bt.setImage(img);
		jb2 = new JButton(ii_bt);
		jb2.setBorderPainted(false);
		jb2.setContentAreaFilled(false);
		jb2.setLocation(150, 550);
		jb2.setSize(75,75);
		jb2.addActionListener(this);
		
		ii_bt = new ImageIcon("button3.png");
		img = ii_bt.getImage().getScaledInstance(100, 75, Image.SCALE_SMOOTH);
		ii_bt.setImage(img);
		jb3 = new JButton(ii_bt);
		jb3.setBorderPainted(false);
		jb3.setContentAreaFilled(false);
		jb3.setLocation(250, 550);
		jb3.setSize(100,75);
		jb3.addActionListener(this);
		
		jp.add(character);
		jp.add(title);
		jp.add(character);
		jp.add(jb1);
		jp.add(jb2);
		jp.add(jb3);
		c.add(jp);
		
		setTitle("무한의 계단");
		setSize(416,689);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1) {
			
		}
		else if(e.getSource()==jb2) {
			
		}
		else if(e.getSource()==jb3) {

			jp.removeAll();
			f2 = new Frame2(jp);

			
		}
		
	}
	


}
