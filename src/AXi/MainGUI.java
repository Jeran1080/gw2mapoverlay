package AXi;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class MainGUI extends JPanel {
	public static final JFrame frame = new JFrame("GuildWars2 Map Overlay");
	
	public ArrayList<Tabs> tabList = new ArrayList<Tabs>();
	final JTabbedPane tabbedPane = new JTabbedPane();
	static Point mouseDownCompCoords;
	int leftRight = 350;
	int upDown    = 400;
	
	private int tabCount = 1;
	
	private int map1index = 0;
	private int map2index = 1;
	private int map3index = 2;
	
	
	private String    setTitle = new String("Settings");
	private ImageIcon setImage;
	private String    setToolTip = new String("This is the Settings");
	private JPanel    setPanel;
	private static int trans = 70;
	private JLabel   transparency = new JLabel ("Set Transparency");
	private JScrollPane setScrollFrame;
	private static final int TRAN_MIN = 20;
	private static final int TRAN_MAX = 100;
	private static final int TRAN_INIT = 70;    //initial frames per second
	
	
	private ImageIcon greenKeep = createImageIcon("./Icons/Green/Keep.png");
	private ImageIcon greenSupply = createImageIcon("./Icons/Green/Camp.png");
	private ImageIcon redGarrison = createImageIcon("./Icons/Red/Castle.png");
	private ImageIcon redKeep = createImageIcon("./Icons/Red/Keep.png");
	private ImageIcon redSupply = createImageIcon("./Icons/Red/Camp.png");
	
	
	Node node1 = new Node(greenSupply, "TitanPaw Supply Camp", "Green");
	Node node2 = new Node(greenSupply, "FaithLeap Supply Camp", "Green");
	Node node3 = new Node(greenKeep, "Sunnyhill Keep", "Green");
	Node node4 = new Node(redGarrison, "Garison Garrison", "Red");
	Node node5 = new Node(greenKeep, "Cragtop Keep", "Green");
	Node node6 = new Node(greenSupply, "Foghaven Supply Camp", "Green");
	Node node7 = new Node(redGarrison, "Dreadfall Garison", "Red");
	Node node8 = new Node(redGarrison, "Shadaran Hills Garison", "Red");
	Node node9 = new Node(redSupply, "Bluevale Refuge Supply Camp", "Red");
	Node node10 = new Node(greenKeep, "Bluebriar Keep", "Green");
	Node node11 = new Node(redKeep, "Redlake Keep", "Red");
	Node node12 = new Node(redSupply, "Redwater Lowlands Supply Camp", "Red");
	Node node13 = new Node(redSupply, "Hero's Lodge Supply Camp", "Red");
	
	Node[] nodes = {node1, node2, node3, node4, node5, node6, node7, node8, node9, node10, node11, node12, node13};
	String[] emptyText = {"", "", ""};
	
	ImageIcon icon = createImageIcon("");
	
	public MainGUI() {
		//Tabs p1 = new Tabs("Tab 1", icon, text, "");
		Tabs p1 = new Tabs("Tarnished Coast", icon, nodes, "Tarnished Coast Map");
		p1.makeNodePanel();
		p1.scrollFrame.setPreferredSize(new Dimension(leftRight, upDown));
		tabList.add(p1);

		Tabs p2 = new Tabs("Blackgate", icon, nodes, "Blackgate Map");
		p2.makeNodePanel();
		p2.scrollFrame.setPreferredSize(new Dimension(leftRight, upDown));
		tabList.add(p2);
		
		Tabs p3 = new Tabs("Jade Quarry", icon, nodes, "Jade Quarry Map");
		p3.makeNodePanel();
		p3.scrollFrame.setPreferredSize(new Dimension(leftRight, upDown));
		tabList.add(p3);
		
		/*************************************************************************************
		 *************************************************************************************/
		JLabel whiteSpace = new JLabel("");
		
		JSlider framesPerSecond = new JSlider(JSlider.HORIZONTAL, TRAN_MIN, TRAN_MAX, TRAN_INIT);
		
		framesPerSecond.setMajorTickSpacing(20);
		framesPerSecond.setMinorTickSpacing(1);
		framesPerSecond.setPaintTicks(true);
		framesPerSecond.setPaintLabels(true);
		framesPerSecond.addChangeListener(new SliderListener());
		
		JPanel tranPan = new JPanel();
		tranPan.setLayout(new BorderLayout());
		tranPan.add(transparency, BorderLayout.WEST);
		tranPan.add(framesPerSecond, BorderLayout.EAST);
		
		final JCheckBox map1 = new JCheckBox(tabList.get(0).title, true);
		map1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	boolean done = false;
            	int count = 1;
            	if(map1.isSelected() == true){
            		tabbedPane.addTab(tabList.get(0).title, tabList.get(0).image, tabList.get(0).scrollFrame, tabList.get(0).toolTip);
            	}
            	else{
            		while (done == false){
	            		if (tabbedPane.getTitleAt(count) == tabList.get(0).title){
		            		tabbedPane.removeTabAt(count);
		            		frame.revalidate();
		            		frame.repaint();
		            		done = true;
	            		}
	            		else
	            			count++;
            		}
            	}
            }
        });
		final JCheckBox map2 = new JCheckBox(tabList.get(1).title, true);
		map2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	boolean done = false;
            	int count = 1;
            	if(map2.isSelected() == true){
            		tabbedPane.addTab(tabList.get(1).title, tabList.get(1).image, tabList.get(1).scrollFrame, tabList.get(1).toolTip);
            	}
            	else{
            		while (done == false){
	            		if (tabbedPane.getTitleAt(count) == tabList.get(1).title){
		            		tabbedPane.removeTabAt(count);
		            		frame.revalidate();
		            		frame.repaint();
		            		done = true;
	            		}
	            		else
	            			count++;
            		}
            	}
            }
        });
		final JCheckBox map3 = new JCheckBox(tabList.get(2).title, true);
		map3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	boolean done = false;
            	int count = 1;
            	if(map3.isSelected() == true){
            		tabbedPane.addTab(tabList.get(2).title, tabList.get(2).image, tabList.get(2).scrollFrame, tabList.get(2).toolTip);
            	}
            	else{
            		while (done == false){
	            		if (tabbedPane.getTitleAt(count) == tabList.get(2).title){
		            		tabbedPane.removeTabAt(count);
		            		frame.revalidate();
		            		frame.repaint();
		            		done = true;
	            		}
	            		else
	            			count++;
            		}
            	}
            }
        });
		JPanel checkPan = new JPanel();
		checkPan.setLayout(new BorderLayout());
		checkPan.add(map1, BorderLayout.NORTH);
		checkPan.add(map2, BorderLayout.CENTER);
		checkPan.add(map3, BorderLayout.SOUTH);
		
		JButton close = new JButton("Close");
		close.addActionListener(new ActionListener() { 
		    public void actionPerformed(ActionEvent e) { 
		        frame.dispose();
		    } 
		});
		JPanel closePan = new JPanel();
		closePan.setLayout(new BorderLayout());
		closePan.add(checkPan, BorderLayout.WEST);
		closePan.add(close, BorderLayout.EAST);
		
		
		setPanel = new JPanel(false);
		setPanel.setLayout(new GridLayout(6, 2));
		setPanel.add(tranPan);
		setPanel.add(closePan);
		setScrollFrame = new JScrollPane(setPanel);
		setPanel.setAutoscrolls(true);
		
		tabbedPane.addTab(setTitle, setImage, setScrollFrame, setToolTip);
		/*************************************************************************************
		 *************************************************************************************/
		for(int i=0; i<tabList.size(); i++){
			JButton but = new JButton("wow");
			tabbedPane.addTab(tabList.get(i).title, tabList.get(i).image, tabList.get(i).scrollFrame, tabList.get(i).toolTip);
		}
		
		Tabs pPlus = new Tabs("+", icon, emptyText, "");
		pPlus.makeTextPanel();
		pPlus.scrollFrame.setPreferredSize(new Dimension(leftRight, upDown));
		//tabbedPane.addTab(pPlus.title, pPlus.image, pPlus.scrollFrame, pPlus.toolTip);
		
		//Alt switch tabs
		//tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		/*ChangeListener changeListener = new ChangeListener() {
			public void stateChanged(ChangeEvent changeEvent) {
				JTabbedPane sp = (JTabbedPane) changeEvent.getSource();
				//tabbedPane.setEnabled(tabbedPane.getSelectedIndex());
				System.out.println(tabbedPane.getSelectedIndex() + ":" +(tabbedPane.getComponentCount()));
			    if (tabbedPane.getSelectedIndex() == (tabbedPane.getComponentCount() - tabCount)){
			    	System.out.println(tabbedPane.getSelectedIndex() + ":" +(tabbedPane.getComponentCount()));
			    	
			    	JLabel newTitle = new JLabel("New Tab");
			    	tabbedPane.setTabComponentAt(tabbedPane.getSelectedIndex(), newTitle);
			    	
			    	System.out.println(tabbedPane.getSelectedIndex() + ":" +(tabbedPane.getComponentCount()));
			    	
			    	Tabs newTab = new Tabs("+", icon, emptyText, "");
					newTab.makeTextPanel();
					newTab.scrollFrame.setPreferredSize(new Dimension(leftRight, upDown));
					tabList.add(newTab);
					tabbedPane.addTab(newTab.title, newTab.image, newTab.scrollFrame, newTab.toolTip);
					
					
					System.out.println(tabbedPane.getSelectedIndex() + ":" +(tabbedPane.getComponentCount()));
			    }
			}
		};
		tabbedPane.addChangeListener(changeListener);
*/
		add(tabbedPane);
		//tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	}
	

	/*
	 * Creates and displays the main application frame.
	 */
	public void display() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Add content to the window.
		frame.add(this, BorderLayout.CENTER);

		//set ALL to clear
		frame.setUndecorated(true);
		
		frame.addMouseListener(new MouseListener(){
            public void mouseReleased(MouseEvent e) {
                mouseDownCompCoords = null;
            }
            public void mousePressed(MouseEvent e) {
                mouseDownCompCoords = e.getPoint();
            }
            public void mouseExited(MouseEvent e) {
            }
            public void mouseEntered(MouseEvent e) {
            }
            public void mouseClicked(MouseEvent e) {
            }
        });

		frame.addMouseMotionListener(new MouseMotionListener(){
            public void mouseMoved(MouseEvent e) {
            }

            public void mouseDragged(MouseEvent e) {
                Point currCoords = e.getLocationOnScreen();
                frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
            }
        });
		
		//set to clear
		frame.setOpacity(trans * 0.01f);
		
		// Set's the window to be "always on top"
        frame.setAlwaysOnTop(true);
		
		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}
	

	class SliderListener implements ChangeListener {
	    public void stateChanged(ChangeEvent e) {
	        JSlider source = (JSlider)e.getSource();
	        if (!source.getValueIsAdjusting()) {
	            trans = (int)source.getValue();
	            frame.setOpacity(trans * 0.01f);
	        }    

	    }
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
