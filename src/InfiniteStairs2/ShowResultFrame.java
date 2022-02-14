package InfiniteStairs2;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ShowResultFrame implements ActionListener{
	JButton jb1,jb2,jb3;
	JLabel gameover,jl_score, score, jl_best, best;
	ImagePanel jp;
	Frame2 f2;
	public ShowResultFrame(ImagePanel jp,Frame2 f2){
		this.jp = jp;
		this.f2 = f2;
		result();
	}
	
	public void result() {
		ImageIcon ii = new ImageIcon("gameover.png");
		Image img = ii.getImage().getScaledInstance(300, 50, Image.SCALE_SMOOTH);
		ii.setImage(img);
		gameover = new JLabel(ii);
		gameover.setSize(300,300);
		gameover.setLocation(50,-50);
		
		
		ii = new ImageIcon("score.png");
		img = ii.getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH);
		ii.setImage(img);
		jl_score = new JLabel(ii);
		jl_score.setSize(150, 50);
		jl_score.setLocation(125,175);
		
		score = new JLabel(Integer.toString(Frame2.score));
		score.setHorizontalAlignment(JLabel.CENTER);
		score.setForeground(new Color(176,56,9));
		score.setFont(new Font("具愁磊 具眉",Font.BOLD,50));
		score.setBorder(BorderFactory.createLineBorder(new Color(88,23,2)));
		score.setSize(100, 50);
		score.setLocation(150,250);
		
		
		ii = new ImageIcon("best.png");
		img = ii.getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH);
		ii.setImage(img);
		jl_best = new JLabel(ii);
		jl_best.setSize(150, 50);
		jl_best.setLocation(125,325);
		
		best = new JLabel("0");
		best.setHorizontalAlignment(JLabel.CENTER);
		best.setForeground(new Color(176,56,9));
		best.setFont(new Font("具愁磊 具眉",Font.BOLD,25));
		best.setBorder(BorderFactory.createLineBorder(new Color(88,23,2)));
		best.setSize(100, 25);
		best.setLocation(150,400);
		
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
		
		
		
		jp.add(gameover);
		jp.add(jl_score);
		jp.add(score);
		jp.add(jl_best);
		jp.add(best);
		jp.add(jb1);
		jp.add(jb2);
		jp.add(jb3);
		
		jp.updateUI();
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
			jp.repaint();

			Frame2.isRunning = true;
			Frame2.isKeyBordPressed= false;
			Frame2.direc = 1;
			Frame2.TimerStart = true;
			Frame2.score =0;
			Frame2.number = 0;
			Frame2.isEnd = false;
			Character.isFalling = false;
			
			f2.sa.removeAll(f2.sa);
			f2.initGame();

		}
	}
	
	public void restart() {
		
	}

}
