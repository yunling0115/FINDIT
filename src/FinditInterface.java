import java.util.*;
public interface FinditInterface {
	// method: reset() (update the model)
	public abstract void reset();
	// getters
	public abstract int getLevel();
	public abstract int getFoundfault();
	public abstract boolean getTimeup();
	public abstract boolean getGamewon();
	public abstract boolean getGamelose();
	public abstract boolean getGameover();
	public abstract boolean getGamewinall();
	public abstract double getTimeleft();
	public abstract double getXpos();
	public abstract double getYpos();
	public abstract double getZpos();
	public abstract boolean getFounds(int i);
	public abstract boolean[] getFounds();
	public abstract int getMaxfault();
	// setters
	public void setLevel(int l);
	public void setFoundfault(int ff);
	public void setTimeup(boolean tu);
	public void setTimeleft(double tl);
	public void setGamewon(boolean gw);
	public void setGamelose(boolean gl);
	public void setGameover(boolean go);
	public void setGamewinall(boolean gwa);
	public void setXpos(double xp);
	public void setYpos(double yp);
	public void setZpos(double zp);
	public void setFounds(int i, boolean b);
	public void setFounds(boolean b[]);
	public void setMaxfault(int mf);
}
