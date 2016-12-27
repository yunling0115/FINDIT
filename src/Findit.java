import java.util.*;
public class Findit extends Observable implements FinditInterface{
	// instance variables
	private int level=0, foundfault=0, maxfault=5;
	private boolean timeup=false, gamewon=false, gamelose=false, gameover=false, gamewinall=false;
	private double timeleft=100;
	private double faultXpos[]={0.0,0.0,0.0,0.0,0.0}, faultYpos[]={0.0,0.0,0.0,0.0,0.0};
	private double Xpos,Ypos,Zpos;
	private boolean founds[]={false,false,false,false,false};
	
	// method: reset() (update the model)
	public void reset(){
		foundfault=0;
		for(int i=0;i<maxfault;i++){
			if(founds[i]==true) foundfault=foundfault+1;
			}
		if(timeleft==0){timeup=true;}
		if(timeup && foundfault<5){gamelose=true;}
		if(!timeup && foundfault==5){gamewon=true;}
		if(gamewon==true && level==18){gamewinall=true;}
		if(timeleft==100){Xpos=0;Ypos=0;}
		setChanged(); notifyObservers();		
	}
	
	// getters
	public int getLevel(){return level;}
	public int getFoundfault(){return foundfault;}
	public boolean getTimeup(){return timeup;}
	public boolean getGamewon(){return gamewon;}
	public boolean getGamelose(){return gamelose;}
	public boolean getGameover(){return gameover;}
	public boolean getGamewinall(){return gamewinall;}
	public double getTimeleft(){return timeleft;}
	public double getXpos(){return Xpos;}
	public double getYpos(){return Ypos;}
	public double getZpos(){return Zpos;}
	public boolean getFounds(int i){return founds[i];}
	public boolean[] getFounds(){return founds;}
	public int getMaxfault(){return maxfault;}
	
	// setters
	public void setLevel(int l){
		level=l;
		setChanged(); notifyObservers();
		}
	public void setFoundfault(int ff){
		foundfault=ff;
		setChanged(); notifyObservers();
		}
	public void setTimeup(boolean tu){
		timeup=tu;
		setChanged(); notifyObservers();
		}
	public void setTimeleft(double tl){
		timeleft=tl;
		setChanged(); notifyObservers();
	}
	public void setGamewon(boolean gw){
		gamewon=gw;
		setChanged(); notifyObservers();
		}
	public void setGamelose(boolean gl){
		gamelose=gl;
		setChanged(); notifyObservers();
		}
	public void setGameover(boolean go){
		gameover=go;
		setChanged(); notifyObservers();
		}
	public void setGamewinall(boolean gwa){
		gamewinall=gwa;
		setChanged(); notifyObservers();
		}
	public void setXpos(double xp){
		Xpos=xp;
		setChanged(); notifyObservers();
	}
	public void setYpos(double yp){
		Ypos=yp;
		setChanged(); notifyObservers();
	}
	public void setZpos(double zp){
		Zpos=zp;
		setChanged(); notifyObservers();
	}
	public void setFounds(int i, boolean b){
		founds[i]=b;
		setChanged();notifyObservers();
	}
	public void setFounds(boolean b[]){
		founds=b;
		setChanged();notifyObservers();
	}
	public void setMaxfault(int mf){
		maxfault=mf;
		setChanged();notifyObservers();
	}
}
