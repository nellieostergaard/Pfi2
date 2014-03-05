package se.mah.k3lara.skaneAPI.view;

import java.util.ArrayList;
import java.util.Iterator;

import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmalparser.Parser;
import se.mah.k3lara.skaneAPI.xmalparser.XMLParser;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("// Results when searching for Sölvesborg resecentrum - Malmö Gustav Adolfs torg");
//		String searchURL = Constants.getURL("10001","80100",20); //Malmö C = 80000,  Malmö GAtorg 80100, Häsleholm C 93070
//		Journeys journeys = Parser.getJourneys(searchURL);
//		for (Journey journey : journeys.getJourneys()) {
//			System.out.print(journey.getStartStation()+" - ");
//			System.out.print(journey.getEndStation());
//			System.out.println(" Departs in "+journey.getTimeToDeparture()+ " minutes");
//		} 
//		
//	   System.out.println("// Stations when searching for stations containing \"Malm\"");
//		ArrayList<Station> searchStations = new ArrayList<Station>(); 
//		searchStations.addAll(Parser.getStationsFromURL("Malm"));
//		for (Station s: searchStations){
//			System.out.println(s.getStationName());
//		}

		//Thingspeaktest
		XMLParser parser = new XMLParser();
		String result = parser.getXmlFromUrl( "http://api.thingspeak.com/update?key=EDN7O90L314XP5NT&field1=723&field2=34&field3=25");
		System.out.println(result);
	}

}
