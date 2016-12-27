import java.awt.*;
import java.util.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
public class FinditPanel extends JPanel implements FinditPanelInterface{
	// Instance Variables
	private FinditApplication fa;
	private JButton buttonPlay, buttonNext, buttonExit;
	private int level=0;
	private boolean ready=false, timeup=false, gamewon=false, gamelose=false, gameover=false, gamewinall=false;
	private double timeleft=100.0;
	// Constructor
	FinditPanel(){
		setLayout(new GridLayout(1,3,3,3));
		buttonPlay = new JButton("Play");
		buttonNext = new JButton("Next");
		buttonExit = new JButton("Exit");
		add(buttonPlay);
		add(buttonNext);
		add(buttonExit);
		LocalActionListener listener = new LocalActionListener();
		buttonPlay.addActionListener(listener);
		buttonNext.addActionListener(listener);
		buttonExit.addActionListener(listener);
	}
	// Define LocalActionListener
	public class LocalActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if (e.getSource()==buttonPlay){	
				if(fa.getFindit().getLevel()==0){
					fa.getFindit().setTimeleft(100.0);
					fa.getFindit().setLevel(1);
					fa.getFindit().setFoundfault(0);
					boolean founds[] = {false,false,false,false,false};
					fa.getFindit().setFounds(founds);
					fa.getFindit().setGamelose(false);
					fa.getFindit().setGameover(false);
					fa.getFindit().setGamewinall(false);
					fa.getFindit().setGamewon(false);
					fa.getFindit().setTimeup(false);
					fa.getFindit().setXpos(0);
					fa.getFindit().setYpos(0);
					fa.getTimebar().newThread();
					}
				//If lose one shot game, you can play it again
				else if (fa.getFindit().getGamelose()==true){
					fa.getFindit().setTimeleft(100.0);
					fa.getFindit().setFoundfault(0);
					boolean founds[] = {false,false,false,false,false};
					fa.getFindit().setFounds(founds);
					fa.getFindit().setGamelose(false);
					fa.getFindit().setGameover(false);
					fa.getFindit().setGamewinall(false);
					fa.getFindit().setGamewon(false);
					fa.getFindit().setTimeup(false);
					fa.getFindit().setXpos(0);
					fa.getFindit().setYpos(0);
					fa.getFindit().reset();
					fa.getTimebar().newThread();
				}
				
			}
			else if (e.getSource()==buttonNext){
				if(fa.getFindit().getLevel()!=18 && gamewon==true){
					// If you win one shot of game
					fa.getFindit().setLevel(fa.getFindit().getLevel()+1);
					fa.getFindit().setFoundfault(0);
					boolean founds[] = {false,false,false,false,false};
					fa.getFindit().setFounds(founds);
					fa.getFindit().setGamelose(false);
					fa.getFindit().setGamewon(false);
					fa.getFindit().setGamewinall(false);
					fa.getFindit().setGameover(false);
					fa.getFindit().setTimeleft(100.0);
					fa.getFindit().setTimeup(false);
					fa.getFindit().setXpos(0);
					fa.getFindit().setYpos(0);
				}
				else if (fa.getFindit().getLevel()==18) fa.getFindit().setGameover(true);
			}
			else if (e.getSource()==buttonExit){
				System.exit(0);
			}
			
		}
			
	}
	// getters
	public int getLevel(){return level;}
	public boolean getTimeup(){return timeup;}
	public boolean getGamewon(){return gamewon;}
	public boolean getGamelose(){return gamelose;}
	public boolean getGameover(){return gameover;}
	public boolean getGamewinall(){return gamewinall;}
	public JButton getButtonPlay(){return buttonPlay;}
	public JButton getButtonNext(){return buttonNext;}
	public JButton getButtonExit(){return buttonExit;}
	// setters
	public void setFinditApplication(FinditApplication a){fa=a;}
	public void setLevel(int l){level=l;}
	public void setTimeup(boolean tu){timeup=tu;}
	public void setGamewon(boolean gw){gamewon=gw;}
	public void setGamelose(boolean gl){gamelose=gl;}
	public void setGameover(boolean go){gameover=go;}
	public void setGamewinall(boolean gwa){gamewinall=gwa;}	
	public Dimension getMinimumSize(){return new Dimension(300,75);}
	public Dimension getPreferredSize(){return new Dimension(300,75);}
}
