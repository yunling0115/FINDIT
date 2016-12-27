import java.awt.*;
import javax.swing.*;
import java.lang.*;
import java.util.*;
import java.awt.event.*; 
public class Timebar extends JComponent{
	// Instance Variables
	private FinditApplication fa;
	private int level=0;
	private boolean ready=false, timeup=false, gamewon=false, gamelose=false, gameover=false, gamewinall=false;
	private double timeleft=100.0;
	private TimebarThread thread;
	private int rightpos=getSize().width, initialrightpos=getSize().width, leftpos=0;
	double delta=0.03;
	// Constructor
	public Timebar(){
		thread = new TimebarThread(this);
		thread.start();
	}
	// decremenetPosition
	public void decrementPosition(){
		if(level==0){repaint();}
		else if(gamewon){repaint();}
		else if(gamelose){repaint();}
		else if(gamewinall){repaint();}
		else if(gameover){repaint();}
		
		else {
			timeleft = Math.max(0, timeleft-level*delta);
			initialrightpos=getSize().width;			
			rightpos = (int)((double)timeleft/(double)100*initialrightpos);
			fa.getFindit().setTimeleft(timeleft);
			repaint();
		}
	}
	// paint (Timebar.paint)
	public void paint(Graphics g){
		Rectangle rc = getParent().getBounds(); 
		g.setColor(Color.white);
		g.fillRect(rightpos, rc.y, initialrightpos, rc.height);
		g.setColor(Color.gray);
		g.fillRect(rc.x, rc.y, rightpos, rc.height);	
	}
	public Dimension getMinimumSize() {return new Dimension(300,50);}
	public Dimension getPreferredSize() {return new Dimension(300,50);}
	// setFindApplication
	public void setFinditApplication(FinditApplication a){
		fa=a;
	}
	// class TimebarThread
	class TimebarThread extends Thread {
		private Timebar timebar;
		public TimebarThread(Timebar tb) {
			timebar = tb;
		}
		public void run(){
			while(true){
				if(timeup){
					fa.getFindit().setTimeup(true); 
					return;
					}
				ChangeHandler changeHandler = new ChangeHandler(timebar);
				SwingUtilities.invokeLater(changeHandler);
				try{sleep(200);}
				catch(InterruptedException e){}
			}
		}
	}
	// class ChangeHandler
	class ChangeHandler implements Runnable{
		private Timebar timebar;
		public ChangeHandler(Timebar tb){
			timebar = tb;
		}
		public void run(){
			timebar.decrementPosition();
			fa.getFindit().reset();
			fa.getImageSpace().repaint();
			fa.getBanner().repaint();
		}
	}
	
	// getters
	protected int getLevel(){return level;}
	protected boolean getTimeup(){return timeup;}
	protected boolean getGamewon(){return gamewon;}
	protected boolean getGamelose(){return gamelose;}
	protected boolean getGameover(){return gameover;}
	protected boolean getGamewinall(){return gamewinall;}
	protected double getTimeleft(){return timeleft;}
	protected TimebarThread getThread(){return thread;}
	// setters
	protected void setLevel(int l){level=l;}
	protected void setTimeup(boolean tu){timeup=tu;}
	protected void setGamewon(boolean gw){gamewon=gw;}
	protected void setGamelose(boolean gl){gamelose=gl;}
	protected void setGameover(boolean go){gameover=go;}
	protected void setGamewinall(boolean gwa){gamewinall=gwa;}
	protected void setTimeleft(double tl){timeleft=tl;}
	protected void setThread(TimebarThread tt){thread=tt;}
	protected void newThread(){this.thread=new TimebarThread(this); thread.start();}
}
