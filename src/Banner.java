import java.awt.*;
import javax.swing.*;

import java.util.*;
public class Banner extends JComponent{
	// Instance variable
	private FinditApplication fa;
	private Image filledcheck=ImageAuxiliaries.readImage("filledcheck.jpg");
	private Image unfilledcheck=ImageAuxiliaries.readImage("unfilledcheck.jpg");
	// constructor
	public void Banner(FinditApplication a){
		fa = a;
	}
	// paint (Banner.paint)
	public void paint(Graphics g){
		Dimension d = getSize();
		int maxfault = 5;
		int foundfault = fa.getFindit().getFoundfault();
		boolean founds[] = fa.getFindit().getFounds();
		for(int i=0;i<foundfault;i++){
			g.drawImage(filledcheck,i*d.height,0,d.height,d.height,this);
		}
		for(int i=foundfault;i<maxfault;i++){
			g.drawImage(unfilledcheck,i*d.height,0,d.height,d.height,this);
		}
		g.setFont(new Font("Helvetica",Font.BOLD,(int)Math.round(d.height*2/3)));
		g.drawString(maxfault-foundfault+" remaining differences", (int)Math.round((maxfault+0.5)*d.height),(int)Math.round(d.height*2/3));
	}
	// setters and getters
	public void setFinditApplication(FinditApplication a){
		fa = a;
	}
}
