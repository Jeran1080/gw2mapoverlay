package AXi;

public class Handler {

	public void start(){
		//Load in preferences
		//Initialize setting
		//Update JSON
		//Launch GUI
		launch();
		//Initiate recurring JSON call
		//Wait for close
		//Save preferences
		//Close successfully
		
	}
	
	/*
	 * This is the method that will call and handle
	 * the loading of saved preferences
	 */
	public void load(){
		
	}
	
	/*
	 * This is the method that will call and handle
	 * the updating of JSON on initial load as well
	 * as be called from the recurring call
	 */
	public void update(){
		
	}
	
	/*
	 * This is the method that will call and handle
	 * the displaying of the GUI
	 */
	public void launch(){
		MainGUI gui = new MainGUI();
		gui.display();
	}
	
	/*
	 * This is the method that will call and handle
	 * the recalling of update()
	 */
	public void reUpdate(){
		
	}
	
	/*
	 * This is the method that will call and handle
	 * the saving of custom preferences
	 */
	public void save(){
		
	}
	
}
