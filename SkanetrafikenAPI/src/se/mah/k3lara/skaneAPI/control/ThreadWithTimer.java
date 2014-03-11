package se.mah.k3lara.skaneAPI.control;

import java.util.TimerTask;

import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.view.TestGUI;
import se.mah.k3lara.skaneAPI.xmalparser.Parser;


public class ThreadWithTimer extends TimerTask{
    //times member represent calling times.
    TestGUI testGUI;
    public ThreadWithTimer(TestGUI testGUI) {
		this.testGUI = testGUI; 
	}
    public void run() {
            	 System.out.println("Results when searching for Sölvesborg resecentrum - Malmö Gustav Adolfs torg");
            		String searchURL = Constants.getURL("80100","81216",1); //Malmö C = 80000,  Malmö Gatorg 80100, Häsleholm C 93070 Kolla skånetrafiken för fler koder
            		Journeys journeys = Parser.getJourneys(searchURL);
            		if (journeys.getJourneys().get(0) != null ){
            			testGUI.updateGUI(journeys.getJourneys().get(0).getTimeToDeparture());
            		}
    }
}
