import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
public interface LayoutManager {
	public void addLayoutComponent(String name, Component component);
	public void removeLayoutComponent(Component component);
	public void layoutContainer(Container parent);
	public Dimension minimumLayoutSize(Container parent);
	public Dimension preferredLayoutSize(Container parent);

}
