import java.util.*;
public class FinditObserver implements Observer {
	private FinditApplication fa;
	public FinditObserver(FinditApplication a){
		fa=a;
	}
	public void update(Observable observable, Object object){
		int level = fa.getFindit().getLevel();
		int maxfault = fa.getFindit().getMaxfault();
		int foundfault = fa.getFindit().getFoundfault();
		double timeleft = fa.getFindit().getTimeleft();
		boolean timeup = fa.getFindit().getTimeup();
		boolean gamewon = fa.getFindit().getGamewon();
		boolean gamelose = fa.getFindit().getGamelose();
		boolean gameover = fa.getFindit().getGameover();
		boolean gamewinall = fa.getFindit().getGamewinall();
		double Xpos = fa.getFindit().getXpos();
		double Ypos = fa.getFindit().getYpos();
		double Zpos = fa.getFindit().getZpos();
		boolean founds[] = fa.getFindit().getFounds();
		fa.getImageSpace().setFounds(founds);
		fa.getImageSpace().setXpos(Xpos);
		fa.getImageSpace().setYpos(Ypos);
		fa.getImageSpace().setZpos(Zpos);
		fa.getTimebar().setTimeleft(timeleft);
		fa.getImageSpace().setLevel(level);
		fa.getTimebar().setLevel(level);
		fa.getFinditPanel().setLevel(level);
		fa.getImageSpace().setFoundfault(foundfault);
		fa.getImageSpace().setTimeup(timeup);
		fa.getTimebar().setTimeup(timeup);
		fa.getFinditPanel().setTimeup(timeup);
		fa.getImageSpace().setGamewon(gamewon);
		fa.getTimebar().setGamewon(gamewon);
		fa.getFinditPanel().setGamewon(gamewon);
		fa.getImageSpace().setGamelose(gamelose);
		fa.getTimebar().setGamelose(gamelose);
		fa.getFinditPanel().setGamelose(gamelose);
		fa.getImageSpace().setGameover(gameover);
		fa.getTimebar().setGameover(gameover);
		fa.getFinditPanel().setGameover(gameover);
		fa.getImageSpace().setGamewinall(gamewinall);
		fa.getTimebar().setGamewinall(gamewinall);
		fa.getFinditPanel().setGamewinall(gamewinall);		
	}
}
