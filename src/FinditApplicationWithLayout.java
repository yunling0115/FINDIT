import javax.swing.*;

import java.awt.LayoutManager;
import java.awt.event.*;
import java.util.*;
public class FinditApplicationWithLayout extends FinditApplication{
	public FinditApplicationWithLayout(){
		super();
		getContentPane().setLayout(new FinditApplicationLayout());
		getContentPane().add("ImageSpace",getImageSpace());
		getContentPane().add("Timebar",getTimebar());
		getContentPane().add("FinditPanel",getFinditPanel());
		getContentPane().add("Banner",getBanner());
	}	
}
