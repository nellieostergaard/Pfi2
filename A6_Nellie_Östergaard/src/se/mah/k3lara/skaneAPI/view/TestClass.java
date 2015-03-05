package se.mah.k3lara.skaneAPI.view;

import java.util.ArrayList;
import java.util.Calendar;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

public class TestClass {

	public static void main(String[] args) {
		String searchURL = Constants.getURL("80000","81216",20); //Malmö C = 80000,  Lund C, 81216 Malmö Gatorg 80100, Hässleholm C 93070
		// URL skriver ut nummer "80000" om användaren anger Malmö C som destination. "81216" står för Lund C. 20 står för antal resultat.
		System.out.println(searchURL);
		System.out.println("// Results when searching:");
		
		Journeys journeys = Parser.getJourneys(searchURL); // Hämtar detaljer om resan, så som avgång och restid.
		for (Journey journey : journeys.getJourneys()) {
			System.out.print(journey.getStartStation()+" - ");
			System.out.print(journey.getEndStation());
			String time = journey.getDepDateTime().get(Calendar.HOUR_OF_DAY)+":"+journey.getDepDateTime().get(Calendar.MINUTE);
			System.out.println(" Departs " + time +" that is in "+journey.getTimeToDeparture()+ " minutes. And it is "+journey.getDepTimeDeviation()+" min late");
		} 
		
	   System.out.println("// Stations when searching for stations containing \"Malm\"");
		ArrayList<Station> searchStations = new ArrayList<Station>(); // Lista med alla stationer
		searchStations.addAll(Parser.getStationsFromURL("Malm")); // Fyller möjlig resterande text om användaren skriver bokstäver.
		for (Station s: searchStations){
			System.out.println(s.getStationName() +" number:" +s.getStationNbr());
		}
	}
}

