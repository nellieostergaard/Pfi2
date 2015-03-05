package se.mah.k3lara.skaneAPI.view;

import java.util.Calendar;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;
import se.mah.k3lara.skaneAPI.model.Journeys;
	

public class JourneysThread extends Thread {
	
	Parser parser;
	   private GUI gui;

	
	public JourneysThread (Parser p, GUI g){
		this.parser = p;
		this.gui = g;
				
	}
@Override

	public void run(){
		
		gui.textArea_1.setText(null);
		
		gui.textArea_1.setText("Loading..");

		
		String searchURL1 = Constants.getURL(gui.textField.getText(), gui.textField_1.getText(), 1);
		
		Journeys journeys1 = Parser.getJourneys(searchURL1);
		
		gui.textArea_1.setText(null);
		
		for (Journey journey : journeys1.getJourneys()) {
			gui.textArea_1.append(journey.getStartStation()+" - "
			+ journey.getEndStation());
			String time1 = journey.getDepDateTime().get(Calendar.HOUR_OF_DAY)+":"+journey.getDepDateTime().get(Calendar.MINUTE);
			gui.textArea_1.append(" Departs " + time1 +" that is in "+journey.getTimeToDeparture()+ " minutes. And it is "+journey.getDepTimeDeviation()+" min late");
		} 
	}

}
