package InfiniteStairs2;

import java.util.ArrayList;

import javax.swing.JProgressBar;

public class Timer extends Thread{
	int limit;
	static boolean timeout;
	JProgressBar pgb;
	ImagePanel jp;
	Character character;
	public Timer(ImagePanel jp,JProgressBar pgb, Character character) {
		limit = 5000;
		timeout = false;
		this.jp = jp;
		this.pgb = pgb;
		this.character = character;
		pgb.setMaximum(limit);
		pgb.setValue(limit);
	}
	
	public void run() {
		a: while(true) {
			long start = System.currentTimeMillis();
			while(true) {
				long now = System.currentTimeMillis();
				pgb.setValue(limit-(int)(now-start));
				if(limit-(int)(now-start)<0) { //�ð��� �� �Ǿ��� ��
					Frame2.isRunning=false;
					timeout = true;
					Character.isFalling = true;
					break a;
				}
				if(Character.isFalling) { //��� ��� ���� ��
					Frame2.isRunning=false;
					break a;
				}
				if(Frame2.isKeyBordPressed==true) { //Ű���� ������ Ÿ�̸� �ʱ�ȭ(���ݽð�-10)
					Frame2.isKeyBordPressed=false;
					break;
				}
			}
			limit -= 10;
			this.pgb = pgb;
			pgb.setMaximum(limit);
			pgb.setValue(limit);
		}
	
		
		
	
	}

}
