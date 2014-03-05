package se.mah.k3lara.skaneAPI.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Stations {
	private ArrayList<Station> stations;
	private Stations() {
		
	}
	private static Stations instance;
	
//	//Singleton pattern
//	public static Stations getInstance() {
//		if (instance == null){
//			instance = new Stations();
//			instance.stations = new ArrayList<Station>();
//		}
//		return instance;
//	}
	
	public Station getClosestStation(){
		return stations.get(0);
	}
	
	public List<Station> getStations() {
		return stations;
	}
	
	
	public boolean removeStation(Station s) {
		return stations.remove(s);
	}
	
	public void addStations(List<Station> newStations) {
        //This should check if they exists and in that case remove etc....
		stations.clear();
		for (Station station : newStations) {
			addStation(station);	
		}
		Collections.sort(stations);
	}
	
	public boolean addStation (Station newStation) {
		boolean b = stations.contains(newStation);
		if(!b){
		   stations.add(newStation);
		}
		Collections.sort(stations);
		return !b; //returns true if b sucessfully added (b not in stations) 
	}

	public int getNbrSavedStations() {
		return stations.size();
	}
}
