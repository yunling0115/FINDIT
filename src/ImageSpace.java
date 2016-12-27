import java.awt.*;

import javax.swing.*;
import java.util.*;
public class ImageSpace extends JComponent implements ImageSpaceInterface{
	// Instance Variables
	private Vector imagenames;
	private static final Image leftimage[]={
			ImageAuxiliaries.readImage("photo1A.jpg"),
			ImageAuxiliaries.readImage("photo2A.jpg"),
			ImageAuxiliaries.readImage("photo3A.jpg"),
			ImageAuxiliaries.readImage("photo4A.jpg"),
			ImageAuxiliaries.readImage("photo5A.jpg"),
			ImageAuxiliaries.readImage("photo6A.jpg"),
			ImageAuxiliaries.readImage("photo7A.jpg"),
			ImageAuxiliaries.readImage("photo8A.jpg"),
			ImageAuxiliaries.readImage("photo9A.jpg"),
			ImageAuxiliaries.readImage("photo10A.jpg"),
			ImageAuxiliaries.readImage("photo11A.jpg"),
			ImageAuxiliaries.readImage("photo12A.jpg"),
			ImageAuxiliaries.readImage("photo13A.jpg"),
			ImageAuxiliaries.readImage("photo14A.jpg"),
			ImageAuxiliaries.readImage("photo15A.jpg"),
			ImageAuxiliaries.readImage("photo16A.jpg"),
			ImageAuxiliaries.readImage("photo17A.jpg"),
			ImageAuxiliaries.readImage("photo18A.jpg"),
			};
	private static final Image rightimage[]={
			ImageAuxiliaries.readImage("photo1B.jpg"),
			ImageAuxiliaries.readImage("photo2B.jpg"),
			ImageAuxiliaries.readImage("photo3B.jpg"),
			ImageAuxiliaries.readImage("photo4B.jpg"),
			ImageAuxiliaries.readImage("photo5B.jpg"),
			ImageAuxiliaries.readImage("photo6B.jpg"),
			ImageAuxiliaries.readImage("photo7B.jpg"),
			ImageAuxiliaries.readImage("photo8B.jpg"),
			ImageAuxiliaries.readImage("photo9B.jpg"),
			ImageAuxiliaries.readImage("photo10B.jpg"),
			ImageAuxiliaries.readImage("photo11B.jpg"),
			ImageAuxiliaries.readImage("photo12B.jpg"),
			ImageAuxiliaries.readImage("photo13B.jpg"),
			ImageAuxiliaries.readImage("photo14B.jpg"),
			ImageAuxiliaries.readImage("photo15B.jpg"),
			ImageAuxiliaries.readImage("photo16B.jpg"),
			ImageAuxiliaries.readImage("photo17B.jpg"),
			ImageAuxiliaries.readImage("photo18B.jpg"),
			};
	private static final Image welcomeimage=ImageAuxiliaries.readImage("welcomeimage.jpg");
	private static final Image winimage=ImageAuxiliaries.readImage("winimage.jpg");
	private static final Image loseimage=ImageAuxiliaries.readImage("loseimage.jpg");
	private static final Image winallimage=ImageAuxiliaries.readImage("winallimage.jpg");
	private static final Image gameoverimage=ImageAuxiliaries.readImage("gameoverimage.jpg");
	private int imageWidth, imageHeight; // Adjusted width and height for loading two images...
	private int level=0, foundfault=0, maxfault=5;
	private boolean timeup=false, gamewon=false, gamelose=false, gameover=false, gamewinall=false;
	private double timeleft=100;
	private static final double faultXXpos[][]={
		// Positions (proportion w.r.t. image, not the ImageSpace)
		{0.367,0.540,0.867,0.503,0.220},
		{0.3533,0.446,0.477,0.138,0.793},
		{0.342,0.825,0.1836,0.496,0.471},
		{0.105,0.724,0.895,0.324,0.615},
		{0.255,0.298,0.258,0.5537,0.720},
		{0.920,0.227,0.628,0.489,0.289},
		{0.310,0.795,0.420,0.6826,0.4224},
		{0.702,0.880,0.194,0.083,0.450},
		{0.320,0.535,0.915,0.547,0.213},
		{0.258,0.021,0.236,0.560,0.735},
		{0.540,0.8366,0.122,0.266,0.132},
		{0.222,0.427,0.984,0.789,0.760},
		{0.175,0.689,0.947,0.550,0.646},
		{0.421,0.443,0.440,0.064,0.778},
		{0.770,0.182,0.643,0.732,0.357},
		{0.454,0.4,0.937,0.811,0.230},
		{0.758,0.701,0.480,0.701,0.797},
		{0.582,0.676,0.123,0.380,0.585},
		};
	private static final double faultYYpos[][]={
		{0.296,0.171,0.512,0.899,0.557},
		{0.251,0.380,0.563,0.587,0.527},
		{0.2515,0.4850,0.6078,0.61078,0.883},
		{0.2515,0.326,0.392,0.832,0.674},
		{0.2335,0.635,0.772,0.180,0.2335},
		{0.311,0.850,0.653,0.533,0.641},
		{0.287,0.413,0.4246,0.692,0.850},
		{0.254,0.584,0.760,0.288,0.5},
		{0.186,0.138,0.781,0.689,0.596},
		{0.450,0.796,0.728,0.482,0.527},
		{0.784,0.377,0.383,0.668,0.820},
		{0.100,0.2395,0.2485,0.2335,0.518},
		{0.338,0.593,0.557,0.629,0.922},
		{0.230,0.464,0.653,0.587,0.230},
		{0.9689,0.162,0.069,0.051,0.626},
		{0.344,0.024,0.835,0.970,0.674},
		{0.0456,0.647,0.915,0.650,0.444},
		{0.036,0.871,0.548,0.272,0.240},
		};
	private double faultXpos[]={0.0,0.0,0.0,0.0,0.0}, faultYpos[]={0.0,0.0,0.0,0.0,0.0};
	private double Xpos=0,Ypos=0, Zpos=0; // current mouse position w.r.t. the image (not ImageSpace!), Zpos=0 if left image, Zpos=1 if right image
	private int x_initial=0,y_initial=0; // When loading two images, the coordinates of the upper left corner of the left image
	private double range=0.1;
	private boolean founds[]={false,false,false,false,false};

	// SetImage
	public void setImageFile(String s, Image i){
		if(s==null){i=null;}
		else{i=ImageAuxiliaries.readImage(s);}
		repaint();
	}
	// paint (ImageSpace.paint)
	public void paint(Graphics g){
		Dimension d = getSize();
		if (level==0){			
			int x,y,width, height;
			double imageRatio = (double)welcomeimage.getHeight(this)/(double)welcomeimage.getWidth(this);
			double windowRatio = (double)d.height/(double)d.width;
			if(imageRatio>windowRatio){
				height = d.height;
				width = welcomeimage.getWidth(this)*(d.height)/welcomeimage.getHeight(this);
			}
			else {
				width = d.width;
				height = welcomeimage.getHeight(this)*(d.width)/welcomeimage.getWidth(this);
			}
			x = (d.width-width)/2;
			y = (d.height-height)/2;
			g.drawImage(welcomeimage,x,y,width,height,this);			
		}
		// if win all games
		else if (gamewinall==true){
			int x,y,width, height;
			// Adjust size
			double imageRatio = (double)winallimage.getHeight(this)/(double)winallimage.getWidth(this);
			double windowRatio = (double)d.height/(double)d.width;
			if(imageRatio>windowRatio){
				height = d.height;
				width = winallimage.getWidth(this)*(d.height)/winallimage.getHeight(this);
			}
			else {
				width = d.width;
				height = winallimage.getHeight(this)*(d.width)/winallimage.getWidth(this);
			}
			x = (d.width-width)/2;
			y = (d.height-height)/2;
			// Adjust ends
			g.drawImage(winallimage,x,y,width,height,this);
		}
		// if lose all games (same as if lose one shot game)
		else if (gameover==true){
			int x,y,width, height;
			// Adjust size
			double imageRatio = (double)gameoverimage.getHeight(this)/(double)gameoverimage.getWidth(this);
			double windowRatio = (double)d.height/(double)d.width;
			if(imageRatio>windowRatio){
				height = d.height;
				width = gameoverimage.getWidth(this)*(d.height)/gameoverimage.getHeight(this);
			}
			else {
				width = d.width;
				height = gameoverimage.getHeight(this)*(d.width)/gameoverimage.getWidth(this);
			}
			x = (d.width-width)/2;
			y = (d.height-height)/2;
			// Adjust ends
			g.drawImage(gameoverimage,x,y,width,height,this);
		}
		// if lose one shot game
		else if (gamelose==true){
			int x,y,width, height;
			// Adjust size
			double imageRatio = (double)loseimage.getHeight(this)/(double)loseimage.getWidth(this);
			double windowRatio = (double)d.height/(double)d.width;
			if(imageRatio>windowRatio){
				height = d.height;
				width = loseimage.getWidth(this)*(d.height)/loseimage.getHeight(this);
			}
			else {
				width = d.width;
				height = loseimage.getHeight(this)*(d.width)/loseimage.getWidth(this);
			}
			x = (d.width-width)/2;
			y = (d.height-height)/2;
			// Adjust ends
			g.drawImage(loseimage,x,y,width,height,this);
		}
		// if win one shot game
		else if (gamewon==true){
			int x,y,width, height;
			// Adjust begins
			double imageRatio = (double)winimage.getHeight(this)/(double)winimage.getWidth(this);
			double windowRatio = (double)d.height/(double)d.width;
			if(imageRatio>windowRatio){
				height = d.height;
				width = winimage.getWidth(this)*(d.height)/winimage.getHeight(this);
			}
			else {
				width = d.width;
				height = winimage.getHeight(this)*(d.width)/winimage.getWidth(this);
			}
			x = (d.width-width)/2;
			y = (d.height-height)/2;
			// Adjust ends
			g.drawImage(winimage,x,y,width,height,this);
		}
		// during the play of one shot game
		else {
			faultXpos=faultXXpos[level-1];
			faultYpos=faultYYpos[level-1];
			int x,y,width, height;
			// Adjust size: leftimage and rightimage should have the same size
			if(leftimage[level-1]!=null && rightimage[level-1]!=null){
				double twoimageRatio = (double)leftimage[level-1].getHeight(this)/(double)(leftimage[level-1].getWidth(this)*2);
				double windowRatio = (double)d.height/(double)d.width;
				if(twoimageRatio>windowRatio){
					height = d.height;
					width = leftimage[level-1].getWidth(this)*(height)/leftimage[level-1].getHeight(this);
				}
				else {
					width = (d.width)/2;
					height = leftimage[level-1].getHeight(this)*(width)/leftimage[level-1].getWidth(this);
				}
				imageHeight = height;
				imageWidth = width;
				x = (d.width-2*width)/4;
				y = (d.height-height)/2;
				x_initial = x;
				y_initial = y;
				// Adjust ends
			    g.drawImage(leftimage[level-1],x,y,width,height,this);
				g.drawImage(rightimage[level-1],x+d.width/2,y,width,height,this);
				//int xpos = (int)Math.round(Xpos*d.width), ypos = (int)Math.round(Ypos*d.height);
				if(Xpos!=0&&Ypos!=0){
					int xpos = (int)Math.round(Xpos*imageWidth+x_initial+Zpos*0.5*d.width);
					int ypos = (int)Math.round(Ypos*imageHeight+y_initial);
					// Transform to position w.r.t. Image
					//double XposI = (Xpos*d.width-x_initial)/width;
					//double YposI = (Ypos*d.height-y_initial)/height;
					g.setColor(Color.red);
					g.drawRect(xpos-(int)(range/2*width),ypos-(int)(range/2*height),(int)(range*width),(int)(range*height));
				}
				g.setColor(Color.red);
				for (int i=0;i<maxfault;i++){
					if(founds[i]==true){
						double faultXposIS = (faultXpos[i]*imageWidth+x_initial)/d.width;
						double faultYposIS = (faultYpos[i]*imageHeight+y_initial)/d.height;
						g.setXORMode(Color.white);
						g.setColor(Color.yellow);
						g.fillRect((int)Math.round(faultXposIS*d.width)-(int)(range*1.5/2*imageWidth),(int)Math.round(faultYposIS*d.height)-(int)(range*1.5/2*height),(int)(range*1.5*width),(int)(range*1.5*height));
						g.fillRect((int)Math.round(faultXposIS*d.width)-(int)(range*1.5/2*imageWidth)+d.width/2,(int)Math.round(faultYposIS*d.height)-(int)(range*1.5/2*height),(int)(range*1.5*width),(int)(range*1.5*height));
					    g.setPaintMode();
						g.setColor(Color.orange);
						g.drawRect((int)Math.round(faultXposIS*d.width)-(int)(range*1.5/2*imageWidth),(int)Math.round(faultYposIS*d.height)-(int)(range*1.5/2*height),(int)(range*1.5*width),(int)(range*1.5*height));
						g.drawRect((int)Math.round(faultXposIS*d.width)-(int)(range*1.5/2*imageWidth)+d.width/2,(int)Math.round(faultYposIS*d.height)-(int)(range*1.5/2*height),(int)(range*1.5*width),(int)(range*1.5*height));
					}
				}
				
			}
		}
	}
	
	// getters
	public int getLevel(){return level;}
	public int getFoundfault(){return foundfault;}
	public boolean getTimeup(){return timeup;}
	public boolean getGamewon(){return gamewon;}
	public boolean getGamelose(){return gamelose;}
	public boolean getGameover(){return gameover;}
	public boolean getGamewinall(){return gamewinall;}
	public double getXpos(){return Xpos;}
	public double getYpos(){return Ypos;}
	public int getMaxfault(){return maxfault;}
	public double getRange(){return range;}
	public int getX_initial(){return x_initial;}
	public int getY_initial(){return y_initial;}
	public int getImageHeight(){return imageHeight;}
	public int getImageWidth(){return imageWidth;}
	public double[] getFaultXpos(){return faultXpos;}
	public double[] getFaultYpos(){return faultYpos;}
	public boolean[] getFounds(){return founds;}

	// setters
	public void setLevel(int l){level=l;}
	public void setFoundfault(int ff){foundfault=ff;}
	public void setTimeup(boolean tu){timeup=tu;}
	public void setGamewon(boolean gw){gamewon=gw;}
	public void setGamelose(boolean gl){gamelose=gl;}
	public void setGameover(boolean go){gameover=go;}
	public void setGamewinall(boolean gwa){gamewinall=gwa;}
	public void setXpos(double xp){Xpos=xp;}
	public void setYpos(double yp){Ypos=yp;}
	public void setZpos(double zp){Zpos=zp;}
	public void setX_initial(int x){x_initial=x;}
	public void setY_intiial(int y){y_initial=y;}
	public void setFounds(boolean fs[]){founds=fs;}

}
	

