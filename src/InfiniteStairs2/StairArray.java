package InfiniteStairs2;

import java.util.ArrayList;
import java.util.Random;


public class StairArray extends ArrayList<Stair>{
	Stair s;
	Random r = new Random(); //0:왼쪽, 1:오른쪽
	
	public StairArray() {
		Frame2.number=0;
	}
	
	public void makeStair(ImagePanel jp) {
		s = new Stair("rock.png");
		if(Frame2.number==0) {
			s.setX(100);
			s.setY(470);
		}
		else {
			int t = r.nextInt(2);
			
			while(true) {
				
				if(t==0) {
					s.setX(this.get(Frame2.number-1).getX()-50); //왼쪽 계단 생성
					if(s.getX()<50) {
						t=1;
						continue;
					}
					else break;
				}
				else {
					s.setX(this.get(Frame2.number-1).getX()+50);
					if(s.getX()>350) {
						t=0;
						continue;
					}
					else break;
				}
			}
			
			s.setY(this.get(Frame2.number-1).getY()-30);
		}
		
		s.setLocation(s.getX(),s.getY());
		
		add(s);
		
		jp.add(this.get(Frame2.number));
		jp.repaint();
		
		System.out.println("cnt: "+Frame2.number);
		System.out.println(s.getX()+","+s.getY());
		Frame2.number++;
		
	}
	
	public void movingStair() {
		for(int i=0;i<Frame2.number;i++) { //생성된 계단 전까지의 계단들 이동
			this.get(i).setX(this.get(i).getX()+Frame2.direc*50);
			this.get(i).setY(this.get(i).getY()+30);
		}
		
	}
	
	

}
