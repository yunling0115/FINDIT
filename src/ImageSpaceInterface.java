import java.awt.Graphics;
import java.awt.Image;


public interface ImageSpaceInterface {
	
	// SetImage
	public void setImageFile(String s, Image i);
	// paint (ImageSpace.paint)
	public void paint(Graphics g);
	
	// getters
	public int getLevel();
	public int getFoundfault();
	public boolean getTimeup();
	public boolean getGamewon();
	public boolean getGamelose();
	public boolean getGameover();
	public boolean getGamewinall();
	public double getXpos();
	public double getYpos();
	public int getMaxfault();
	public double getRange();
	public int getX_initial();
	public int getY_initial();
	public int getImageHeight();
	public int getImageWidth();
	public double[] getFaultXpos();
	public double[] getFaultYpos();
	public boolean[] getFounds();

	// setters
	public void setLevel(int l);
	public void setFoundfault(int ff);
	public void setTimeup(boolean tu);
	public void setGamewon(boolean gw);
	public void setGamelose(boolean gl);
	public void setGameover(boolean go);
	public void setGamewinall(boolean gwa);
	public void setXpos(double xp);
	public void setYpos(double yp);
	public void setZpos(double zp);
	public void setX_initial(int x);
	public void setY_intiial(int y);
	public void setFounds(boolean fs[]);

}
