package Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Member.Member;
import Travels.Travel;
import Utils.GPSData;
import Utils.Mood;
import Utils.MyCoordinate;
import Utils.Util;

public class TravelManager implements Serializable {
	
	private static final long serialVersionUID = -3370481895716548296L;

	private ArrayList<Travel> m_travels = new ArrayList<Travel>();

	public TravelManager() {
	};
	

	public ArrayList<Travel> getTravelList() {
		return m_travels;
	}
	
	public ArrayList<Travel> searchTravelAround(MyCoordinate p_center, double p_radius, String start, String dest, Mood mood){
		ArrayList<Travel> travelS = new ArrayList<Travel>();
		for (Travel t : this.m_travels){
            double d = Util.distanceCoordinates(p_center.toOSMCoordinate(), t.getCoord().toOSMCoordinate());
            if(d <= p_radius){
            	if(t.getSeats() <= 0) continue;
            	if(!t.getStart().toLowerCase().contains(start.toLowerCase())) continue;
            	if(!t.getEnd().toLowerCase().contains(dest.toLowerCase())) continue;
            	if(!mood.equals(Mood.NO_SPECIAL_MOOD) && !mood.equals(null) && mood != t.getDriver().getMood()) continue;
            	
            	travelS.add(t);
            }
		}
		
		return travelS;
	}
	
//
//	public ArrayList<Travel> findTravellingMembers(Member m, String destination) {
//        ArrayList<Travel> listTravels = new ArrayList<Travel>();
//
//        String myPosition = m.getLastPosition().toLocation(6);
//        myPosition = myPosition.substring(0,myPosition.indexOf(','));
//
//        for(Travel t : m_travels) {
//            MyCoordinate cStart = t.getMyCoordinateStart();
//            MyCoordinate cEnd = t.getMyCoordinateEnd();
//
//            GPSData gStart = new GPSData(cStart,dTravel.getTime());
//            GPSData gEnd = new GPSData(cEnd,new Date());
//
//            String locationStart = gStart.toLocation(6); locationStart = gStart.toLocation(6).substring(0,locationStart.indexOf(','));
//            String locationEnd = gEnd.toLocation(6);  locationEnd = gEnd.toLocation(6).substring(0,locationEnd.indexOf(','));
//
//            if(locationEnd.equalsIgnoreCase(destination) && locationStart.equalsIgnoreCase(myPosition)) {
//                    listTravels.add(t);
//            }
//        }
//        return listTravels;
//    }
	
	public boolean addTravel(Travel t) {
		if (m_travels.add(t))
			return true;
		return false;
	}

}