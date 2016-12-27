import java.awt.*;
// NOTE: using layout manager, must explicitly call each component to repaint!
import java.awt.LayoutManager;
public class FinditApplicationLayout implements LayoutManager{
	private Component imagespace;
	private Component timebar;
	private Component finditpanel;
	private Component banner;
	public void addLayoutComponent(String name, Component o){
		if (name.equals("ImageSpace")){imagespace = o;}
		else if (name.equals("Timebar")){timebar = o;}
		else if (name.equals("FinditPanel")){finditpanel = o;}
		else if (name.equals("Banner")){banner = o;}
		else {System.err.println(name+"argument unrecognized");}		
	}
	public void removeLayoutComponent(Component o){
		if(imagespace==o){imagespace=null;}
		else if(timebar==o){timebar=null;}
		else if(finditpanel==o){finditpanel=null;}
		else if(banner==o){banner=null;}
	}
	public void layoutContainer(Container parent){
		Dimension d = parent.getSize();
		int height = d.height;
		int width = d.width;
		if(imagespace!=null){
			imagespace.setBounds(0,0,width,(int)Math.round(height*8/13));
		}
		if(timebar!=null){
			timebar.setBounds(0,(int)Math.round(height*17/26),width,(int)Math.round(height/13));
		}
		if(banner!=null){
			banner.setBounds(0,(int)Math.round(height*10/13),width,(int)Math.round(height/13));
		}
		if(finditpanel!=null){
			finditpanel.setBounds(0,(int)Math.round(height*23/26),width,(int)Math.round(height*3/26));
			if(finditpanel instanceof FinditPanel){
				((FinditPanel) finditpanel).getButtonPlay().setFont(new Font("Times New Roman",Font.BOLD,(int)Math.round(height/16)));
				((FinditPanel) finditpanel).getButtonPlay().setBackground(Color.green);
				((FinditPanel) finditpanel).getButtonPlay().setForeground(Color.white);
				((FinditPanel) finditpanel).getButtonNext().setFont(new Font("Times New Roman",Font.BOLD,(int)Math.round(height/16)));
				((FinditPanel) finditpanel).getButtonNext().setBackground(Color.red);
				((FinditPanel) finditpanel).getButtonNext().setForeground(Color.white);
				((FinditPanel) finditpanel).getButtonExit().setFont(new Font("Times New Roman",Font.BOLD,(int)Math.round(height/16)));
				((FinditPanel) finditpanel).getButtonExit().setBackground(Color.blue);
				((FinditPanel) finditpanel).getButtonExit().setForeground(Color.white);
			}
		}
	}
	public Dimension minimumLayoutSize(Container parent){
		return new Dimension(50,50);
	}
	public Dimension preferredLayoutSize(Container parent){
		return new Dimension(50,50);
	}
}
