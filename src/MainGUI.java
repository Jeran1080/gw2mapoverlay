import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainGUI extends JPanel {
	static final JFrame frame = new JFrame("GuildWars2 Map Overlay");
	
	public ArrayList<Tabs> tabList = new ArrayList<Tabs>();
	final JTabbedPane tabbedPane = new JTabbedPane();
	
	int leftRight = 350;
	int upDown    = 400;

	String[] text = {"1.1","1.2","1.3","2.1","2.2","2.3","3.1","3.2","3.3","4.1","4.2","4.3","5.1","5.2","5.3","6.1","6.2","6.3",
					 "1.1","1.2","1.3","2.1","2.2","2.3","3.1","3.2","3.3","4.1","4.2","4.3","5.1","5.2","5.3","6.1","6.2","6.3",
					 "1.1","1.2","1.3","2.1","2.2","2.3","3.1","3.2","3.3","4.1","4.2","4.3","5.1","5.2","5.3","6.1","6.2","6.3",
					 "1.1","1.2","1.3","2.1","2.2","2.3","3.1","3.2","3.3","4.1","4.2","4.3","5.1","5.2","5.3","6.1","6.2","6.3",
					 "1.1","1.2","1.3","2.1","2.2","2.3","3.1","3.2","3.3","4.1","4.2","4.3","5.1","5.2","5.3","6.1","6.2","6.3",
					 "1.1","1.2","1.3","2.1","2.2","2.3","3.1","3.2","3.3","4.1","4.2","4.3","5.1","5.2","5.3","6.1","6.2","6.3",
					 "1.1","1.2","1.3","2.1","2.2","2.3","3.1","3.2","3.3","4.1","4.2","4.3","5.1","5.2","5.3","6.1","6.2","6.3",
					 "1.1","1.2","1.3","2.1","2.2","2.3","3.1","3.2","3.3","4.1","4.2","4.3","5.1","5.2","5.3","6.1","6.2","6.3",
					 "1.1","1.2","1.3","2.1","2.2","2.3","3.1","3.2","3.3","4.1","4.2","4.3","5.1","5.2","5.3","6.1","6.2","6.3",
					 "1.1","1.2","1.3","2.1","2.2","2.3","3.1","3.2","3.3","4.1","4.2","4.3","5.1","5.2","5.3","6.1","6.2","6.3",
					 "1.1","1.2","1.3","2.1","2.2","2.3","3.1","3.2","3.3","4.1","4.2","4.3","5.1","5.2","5.3","6.1","6.2","6.3"};
	String[] text2 = {"Much WOW", "very seperated", "Such Tab"};
	String[] emptyText = {"", "", ""};
	
	ImageIcon icon = createImageIcon("");
	
	public MainGUI() {
		Tabs p1 = new Tabs("Tab 1", icon, text, "");
		p1.makeTextPanel();
		p1.scrollFrame.setPreferredSize(new Dimension(leftRight, upDown));
		tabList.add(p1);

		Tabs p2 = new Tabs("Tab 2", icon, text, "");
		p2.makeTextPanel();
		p2.scrollFrame.setPreferredSize(new Dimension(leftRight, upDown));
		tabList.add(p2);
		
		Tabs p3 = new Tabs("Tab 3", icon, text, "");
		p3.makeTextPanel();
		p3.scrollFrame.setPreferredSize(new Dimension(leftRight, upDown));
		tabList.add(p3);
		
		Tabs p4 = new Tabs("Tab 4", icon, text2, "");
		p4.makeTextPanel();
		p4.scrollFrame.setPreferredSize(new Dimension(leftRight, upDown));
		tabList.add(p4);
		
		Tabs p5 = new Tabs("+", icon, emptyText, "");
		p5.makeTextPanel();
		p5.scrollFrame.setPreferredSize(new Dimension(leftRight, upDown));
		tabList.add(p5);
		
		for(int i=0; i<tabList.size(); i++){
			tabbedPane.addTab(tabList.get(i).title, tabList.get(i).image, tabList.get(i).scrollFrame, tabList.get(i).toolTip);
		}
		
		//Alt switch tabs
		//tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		ChangeListener changeListener = new ChangeListener() {
			public void stateChanged(ChangeEvent changeEvent) {
				JTabbedPane sp = (JTabbedPane) changeEvent.getSource();
				//tabbedPane.setEnabled(tabbedPane.getSelectedIndex());
			    if (tabbedPane.getSelectedIndex() == (tabbedPane.getComponentCount() - 1)){			
			    	/*************************************
			    	 * change old new tab to say next tab
			    	 *************************************/			    	
			    	Tabs newTab = new Tabs("+", icon, emptyText, "");
					newTab.makeTextPanel();
					newTab.scrollFrame.setPreferredSize(new Dimension(leftRight, upDown));
					tabList.add(newTab);
					tabbedPane.addTab(newTab.title, newTab.image, newTab.scrollFrame, newTab.toolTip);
					System.out.println(tabList.size());
			    }
			    //System.out.println("d");
			    //refresh();
			}
		};
		tabbedPane.addChangeListener(changeListener);

		add(tabbedPane);
		//tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	}
	
	private void refresh() {
		tabbedPane.removeAll();
		frame.validate();
		frame.repaint();
		frame.pack();
		for(int i=0; i<tabList.size(); i++){
			tabbedPane.addTab(tabList.get(i).title, tabList.get(i).image, tabList.get(i).scrollFrame, tabList.get(i).toolTip);
		}
		System.out.println(tabList.size());
	}

	/*
	 * Creates and displays the main application frame.
	 */
	public void display() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Add content to the window.
		frame.add(this, BorderLayout.CENTER);

		//set ALL to clear //DONT Do
		//frame.setUndecorated(true);
		
		//set to clear
		frame.setBackground(new Color(0, 0, 0, 0));
		
		// Set's the window to be "always on top"
        frame.setAlwaysOnTop(true);
		
		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	/*
	 *  Returns an ImageIcon, or null if the path was invalid. 
	 */
	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = MainGUI.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
}
