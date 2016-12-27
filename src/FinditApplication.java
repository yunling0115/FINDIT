import javax.swing.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
public class FinditApplication extends JApplet{
	// Declare instance variables	
	private Findit findit;
	private ImageSpace imagespace;
	private Timebar timebar;
	private FinditPanel finditpanel;
	private Banner banner;
	
	// Define constructor
	public FinditApplication(){
		getFindit();
		setSize(600,300); Dimension d = getSize();
		getContentPane().add("North", getImageSpace());
		getContentPane().add("Center", getTimebar());
		getContentPane().add("South", getFinditPanel());
	}
	
	// Define getters
	public Findit getFindit(){
		if(findit==null){setFindit(new Findit());}
		return findit;
	}
	public ImageSpace getImageSpace(){
		if(imagespace==null){setImageSpace(new ImageSpace());}
		return imagespace;
	}
	public Timebar getTimebar(){
		if(timebar==null){setTimebar(new Timebar());}
		return timebar;
	}
	public FinditPanel getFinditPanel(){
		if(finditpanel==null){setFinditPanel(new FinditPanel());}
		return finditpanel;
	}
	public Banner getBanner(){
		if(banner==null){setBanner(new Banner());}
		return banner;
	}
	
	// Define setters
	public void setFindit(Findit fi){
		if(findit==fi){return;}
		if(findit instanceof Findit){findit.deleteObservers();}
		if(fi instanceof Findit){
			findit=fi;
			findit.addObserver(new FinditObserver(this));
		}
	}
	public void setImageSpace(ImageSpace is){
		imagespace=is;
		imagespace.addMouseListener(new ImageSpaceListener(this));
	}
	public void setTimebar(Timebar tb){
		timebar=tb;
		timebar.setFinditApplication(this);
	}
	public void setFinditPanel(FinditPanel fip){
		finditpanel=fip;
		finditpanel.setFinditApplication(this);
	}
	public void setBanner(Banner bn){
		banner = bn;
		banner.setFinditApplication(this);
	}
	
}