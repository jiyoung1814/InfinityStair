package InfiniteStairs2;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class Frame2 implements KeyListener{
	ImagePanel jp;
	JButton up, change;
	JLabel jl_score;
	JProgressBar pgb;
	static int round;
	static int number;
	static int score;
	static int direc = 1; //-1:���� , 1: ������
	static boolean TimerStart = true;
	static boolean isRunning = false; //���� �ʱ�ȭ ����
	static boolean isKeyBordPressed;
	static boolean isStart; //��ư ������ �� ����
	static boolean isEnd; //ĳ���� �������� ��� â
	StairArray sa;
	Character character;
	Timer t;
	Stair s;
	
	public Frame2(ImagePanel jp) {
		this.jp = jp;
		sa = new StairArray();
		character = new Character("boxer1.png", jp,sa, this);
		initGame();
		
		jp.addKeyListener(this);
	}
	
	public void initGame() {
		
		System.out.println(sa.size());
		
		character.changeImage("boxer1.png", 70, 150);
		character.setX(150);
		character.setY(350);
		character.setLocation(character.getX(), character.getY());
		new Thread((Runnable)character).start();
		
		
		ImageIcon ii_bt = new ImageIcon("up.png");
		Image img = ii_bt.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ii_bt.setImage(img);
		up = new JButton(ii_bt);
		up.setBorderPainted(false);
		up.setContentAreaFilled(false);
		up.setLocation(300, 570);
		up.setSize(50,50);
//		up.addActionListener(this);
		
		ii_bt = new ImageIcon("change.png");
		img = ii_bt.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ii_bt.setImage(img);
		change = new JButton(ii_bt);
		change.setBorderPainted(false);
		change.setContentAreaFilled(false);
		change.setLocation(50, 570);
		change.setSize(50,50);
//		change.addActionListener(this);
		
		pgb = new JProgressBar(JProgressBar.HORIZONTAL,0,5000);
		pgb.setValue(5000);
		pgb.setSize(300, 30);
		pgb.setLocation(50, 520);
		pgb.setBackground(new Color(90,70,57));
		pgb.setForeground(new Color(200,71,32));
		pgb.setBorderPainted(false);
		
		jl_score = new JLabel(Integer.toString(score));
		jl_score.setHorizontalAlignment(JLabel.CENTER);
		jl_score.setFont(new Font("�߳��� ��ü",Font.BOLD,50));
//		jl_score.setForeground(new Color(200,71,32));
		jl_score.setLocation(150, 570);
		jl_score.setSize(100, 50);
		
		jp.add(character);
		jp.add(up);
		jp.add(change);
		jp.add(pgb);
		jp.add(jl_score);

		
		for(int i=0;i<17;i++) { //ó�� 17���� ��� ����
			sa.makeStair(jp);
		}
		
		isRunning = true; //Ű���� ���� OK
		
		jp.requestFocus();
		
	}
	
	public void judge() {
		System.out.println(number-18);
		if(sa.get(number-18).getX()==100 &&!Character.isFalling) {//��� ���� + ó�� �� Ŭ����
			score++;
			jl_score.setText(Integer.toString(score));
			jp.MoveBackground();//��� �����̱�
			jp.updateUI();
		}
		else {//��� ����
			character.isFalling = true;
		}
	}
	
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

		if(isRunning) {
			
			if(e.getKeyCode()==KeyEvent.VK_RIGHT||e.getKeyCode()==KeyEvent.VK_LEFT) {
				if(TimerStart) {
					t = new Timer(jp,pgb,character);
					t.start();
					TimerStart = false;
				}
				else {
					isKeyBordPressed = true; //Ű���尡 ������ �ð� �ʱ�ȭ
					
					if (e.getKeyCode()==KeyEvent.VK_LEFT) direc *= -1; //������ Ű���� ������ �� ���� ��ȯ}
					
					if(number>17) { //��� ������
						sa.movingStair();
					}
					character.isMoving = true;	
					sa.makeStair(jp);
					judge();
				}
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}
