import java.awt.event.*;
import java.awt.*;
public class ImageSpaceListener extends MouseAdapter{
	FinditApplication fa;
	public ImageSpaceListener(FinditApplication a){
		fa=a;
	}
	public void mousePressed (MouseEvent e){		
		int x = e.getX();
		int y = e.getY();
		double range = fa.getImageSpace().getRange();
		Dimension d = fa.getImageSpace().getSize();
		double faultXpos[]=fa.getImageSpace().getFaultXpos();
		double faultYpos[]=fa.getImageSpace().getFaultYpos();
		int x_initial = fa.getImageSpace().getX_initial();
		int y_initial = fa.getImageSpace().getY_initial();
		int imageHeight = fa.getImageSpace().getImageHeight();
		int imageWidth = fa.getImageSpace().getImageWidth();
		double xpos = x/d.width;
		double ypos = y/d.height;
		double Zpos = 0.0;
		double Xpos = (double)(x-x_initial)/imageWidth;
		if (Xpos>1){Zpos=1; Xpos=(double)(x-d.width/2-x_initial)/imageWidth;}
		double Ypos = (double)(y-y_initial)/imageHeight;
		// Note: the only invariant is the position w.r.t image, so need to revise xpos and ypos then convey it to setXpos and setYpos		
		fa.getFindit().setXpos(Xpos);
		fa.getFindit().setYpos(Ypos);
		fa.getFindit().setZpos(Zpos);
		for (int i=0;i<fa.getImageSpace().getMaxfault();i++){
			if((Math.abs(Xpos-faultXpos[i])<range/2)&&(Math.abs(Ypos-faultYpos[i])<range/2)){
				fa.getFindit().setFounds(i,true);
			}
		}
		fa.getFindit().reset();
		
	}
}
