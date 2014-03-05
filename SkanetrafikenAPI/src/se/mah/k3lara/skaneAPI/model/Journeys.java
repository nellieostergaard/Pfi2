package se.mah.k3lara.skaneAPI.model;

import java.util.ArrayList;

public class Journeys {
	private ArrayList<Journey> journeys;
	
	public Journeys() {
		// TODO Auto-generated constructor stub
		journeys = new ArrayList<Journey>();
	}
	
	public void addJourney(Journey journey) {
		this.journeys.add(journey);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Journey> getJourneys() {
		return journeys;
	}
	
	public void clearJourneys() {
		this.journeys.clear();
	}
}
