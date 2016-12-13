package Data;

import java.io.Serializable;
import java.util.ArrayList;

import Travels.Travel;
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

	public boolean addTravel(Travel t) {
		if (m_travels.add(t))
			return true;
		return false;
	}

}
