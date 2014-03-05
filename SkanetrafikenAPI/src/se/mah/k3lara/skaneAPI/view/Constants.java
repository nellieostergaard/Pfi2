package se.mah.k3lara.skaneAPI.view;


public class Constants {
	public static final String testURL = "http://www.labs.skanetrafiken.se/v2.2/resultspage.asp?cmdaction=next&selPointFr=%7C81116%7C0&selPointTo=%7C65008%7C0&LastStart=2012-10-14%2008:00";
	public static final String baseURL = "http://www.labs.skanetrafiken.se/v2.2/";
	public static final String queryURL = "resultspage.asp?cmdaction=next&selPointFr=";
	public static final String getStationURL = "querystation.asp?inpPointfr=";
	public static final String pipe = "%7C";
	public static final String space = "%20";
	public static final String midPartURL = "0&selPointTo=";
	public static final String lastPartURL = "0&LastStart=";
	public static final String noOfResults = "&NoOf=";
	public static double latSjobo = 55.63428;
	public static double longSjobo = 13.70526;
	public static int runLimit = 10;
	public static int getStartedLimit = 15;
	public static int stayCoolLimit = 60;
	public static int nbrResultsToGet = 15;
	public static int nbrStationsToStore = 10;
	public static final String dummyStationName = "Lägg till ny station";
	public static final String dummyStationNumber = "999";
	public static final String PREFS_NAME = "MyPrefsFile";
	public static final String FROMPOS_PREFS_NAME = "toPos";
	public static final String TOPOS_PREFS_NAME = "fromPos";

	/**
	 * Build the Querystringz
	 * @param startStationNumber from skånetrafiken
	 * @param endStationNumber from skånetrafiken
	 * @param date for first start from in form yyyy-mm-dd
	 * @param time in format hh:mm 24 H
	 * @param nbrResults max 20
	 * */
	public static String getURL(String startStationNumber, String endStationNumber  , String date, String time, int nbrResults){
		String nbrRes = String.valueOf(nbrResults);
		String url = baseURL + queryURL + pipe+startStationNumber + pipe + midPartURL +pipe + endStationNumber + pipe + lastPartURL + date + space + time+noOfResults+nbrRes;
		return url;
	}
	
	/**
	 * Build the Querystringz
	 * @param startStationNumber from skånetrafiken
	 * @param endStationNumber from skånetrafiken
	 * @param nbrResults max 20 from now
	 * */
	public static String getURL(String startStationNumber, String endStationNumber, int nbrResults){
		String nbrRes = String.valueOf(nbrResults);
		String url = baseURL + queryURL + pipe+startStationNumber + pipe + midPartURL +pipe + endStationNumber + pipe + "0"+ noOfResults+nbrRes;
		return url;
	}
	
	public static final String testURLIP = "http://www.labs.skanetrafiken.se/v2.2/resultspage.asp?cmdaction=next&selPointFr=%7C81116%7C0&selPointTo=%7C65008%7C0&LastStart=2012-10-11%2019:38";
	public static final String KEY_Journey = "Journey"; // parent node
	public static final String KEY_DepDateTimeFull = "DepDateTimeFull"; //With date and all
	public static final String KEY_DepDateTime = "DepDateTime";
	public static final String KEY_ArrDateTime = "ArrDateTime";
	public static final String KEY_From = "From";
	public static final String KEY_To = "To";
	public static final String KEY_Line = "Line";
	public static final String KEY_Name = "Name";
	public static final String KEY_LineTypeName = "LineTypeName";
	public static final String KEY_TravelTime = "TravelTime";
	public static final String KEY_TimeToDeparture = "TimeToDeparture";
	public static final String TAG = "k3larra";
	public static final String KEY_NoOfChanges = "NoOfChanges";
	public static final String KEY_NoOfZones = "NoOfZones";
	public static final String KEY_DepTimeDeviation = "DepTimeDeviation";
	public static final String KEY_ArrTimeDeviation = "ArrTimeDeviation";
	public static final String KEY_StartPoints = "StartPoints";
	public static final String KEY_Point = "Point";
	public static final String KEY_Point_Name = "Name";
	public static final String KEY_Point_Id = "Id";
	public static final String KEY_Point_X = "X";
	public static final String KEY_Point_Y = "Y";
	public static final String KEY_Point_ToStation = "ToStation";
	public static final String KEY_Point_FromStation = "FromStation";
}
