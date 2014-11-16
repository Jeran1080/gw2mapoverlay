import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Tabs{

	public String    title;
	public ImageIcon image;
	public String[]  text;
	public String    toolTip;
	public JPanel    panel;
	
	public JScrollPane scrollFrame;

	
	Node[] node;
	
	public Tabs(String _title, ImageIcon _image, String[] _text, String _toolTip){
		title = _title;
		image = _image;
		text = _text;
		toolTip = _toolTip;
		
	}
	
	public Tabs(Node[] _node){
		node = _node;
	}
	
	public void makeTextPanel() {
		panel = new JPanel(false);
		panel.setBackground(new Color(0, 0, 0, 0));
		panel.setLayout(new GridLayout((text.length/3), 3));
		for(int i=0; i<text.length; i++){
			JLabel filler = new JLabel(text[i]);
			//filler.setHorizontalAlignment(JLabel.LEFT);
			panel.add(filler);
		}
		scrollFrame = new JScrollPane(panel);
		scrollFrame.setBackground(new Color(0, 0, 0, 0));
		panel.setAutoscrolls(true);
		//this.add(scrollFrame);
		//return scrollFrame;
	}

}
