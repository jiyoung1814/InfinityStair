package InfiniteStairs2;

import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Character extends JLabel implements Runnable{
	int x, y;
	static int foot = 1; //-1: 왼발, 1: 오른발
	static boolean isMoving;
	static boolean isFalling;
	Frame2 f2;
	
	ImagePanel jp;
	ArrayList<Stair> sa;
	
	public Character(String path, ImagePanel jp,ArrayList<Stair> sa, Frame2 f2) {
		this.jp = jp;
		this.sa = sa;
		this.f2 = f2;
		
		foot = 1;
		isMoving = false;
		isFalling = false;
		
		ImageIcon ii = new ImageIcon(path);
		setIcon(ii);
		setSize(70, 150);
	}
	
	public void setX(int x) {
		this.x =x;
	}
	
	public int getX() {
		return x;
	}
	
	public void setY(int y) {
		this.y =y;
	}
	
	public int getY() {
		return y;
	}
	
	public void setXY(int x, int y) {
		this.x =x;
		this.y =y;
	}
	
	public void changeImage(String path,int w, int h) {
		setVisible(false);
		ImageIcon ii = new ImageIcon(path);
		setIcon(ii);
		setSize(w, h);
		setLocation(x,y);
		setVisible(true);
	}
	
	public void moveCharacter() throws InterruptedException{
		foot *=-1;
		
		if(Frame2.direc==1) {//왼쪽 방향
			if(foot==-1) {//왼발
				changeImage("boxer2.png", 82, 150);
				setXY(90, 500-this.getHeight());
			}
			else {//오른발
				changeImage("boxer3.png", 111, 150);
				setXY(200-this.getWidth(), 500-this.getHeight());
			}
			
			Thread.sleep(250);
			
			changeImage("boxer1.png", 82, 150);
			setXY(100-15, 500-this.getHeight()-30);
		}
		else if(Frame2.direc== -1) {//오른쪽 방향
			
			if(Frame2.number==17) { //처음 오른쪽 방향 키보드
				changeImage("boxer2_r.png", 82, 150);
				setXY(100+50,500-this.getHeight());
				
				Thread.sleep(250);
				
				changeImage("boxer1_r.png", 82, 150);
				setXY(x+50, y-30);
				isFalling = true;
			}
			else {
				if(foot==-1) {//오른발
					changeImage("boxer2_r.png", 82, 150);
					setXY(150-this.getWidth(), 500-this.getHeight());
						
				}
				else {//왼발
					changeImage("boxer3_r.png", 111, 150);
					setXY(60, 500-this.getHeight());
				}
				
				Thread.sleep(250);
				
				changeImage("boxer1_r.png", 82, 150);
				setXY(150+20-this.getWidth(), y-30);
			}
			
		}
	}
	
	public void fallingCharacter(){
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {e1.printStackTrace();}
		
			
		if(this.getX()==85) //왼쪽방향
			this.changeImage("boxer4.png", 88, 150);
			
		else 
			this.changeImage("boxer4_r.png", 88, 150);	
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {e.printStackTrace();}	
		
		while(true) {
			this.setY(this.getY()+10);
			this.setLocation(this.getX(), this.getY());
			jp.updateUI();
			
			if(this.getY()>650) {
				jp.remove(this);
				jp.updateUI();
				break;
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {e.printStackTrace();}	
		}
	}
	
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			System.out.print("");
			if(isMoving) {
				try {
					moveCharacter();
					jp.updateUI();
				} catch (InterruptedException e) {e.printStackTrace();}
				isMoving = false;
			}
			
			if(isFalling){
				fallingCharacter();
				jp.removeAll();
				try {
					new ShowResultFrame(jp, f2);
				} catch (SQLException e) {e.printStackTrace();}
				break;
			}
			
		}
	}

}
