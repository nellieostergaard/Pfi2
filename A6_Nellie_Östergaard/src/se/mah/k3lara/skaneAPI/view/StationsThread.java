package se.mah.k3lara.skaneAPI.view;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;
import se.mah.k3lara.skaneAPI.model.Station;
import java.util.ArrayList;


public class StationsThread extends Thread{

	
	Parser parser;
	   private GUI gui;

	
	public StationsThread (Parser p, GUI g){
		this.parser = p;
		this.gui = g;
	
}
	
	public void run (){
		
		gui.textArea.setText(null);
		
		gui.textArea.setText("Loading..");
		
		ArrayList<Station>searchstation1 = new ArrayList<Station>();
		
	
		searchstation1.addAll(Parser.getStationsFromURL(gui.textField_2.getText()));
		
		gui.textArea.setText(null);
		
		for (Station s: searchstation1){
			gui.textArea.append(s.getStationName() + " number:" +s.getStationNbr() + "\n");
		}
		
	}
	}
	

