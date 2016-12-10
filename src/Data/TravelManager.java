package Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import Member.Member;
import Travels.Travel;
import Utils.Mood;
import Utils.Coordinate;

public class TravelManager implements Serializable {
	
	private static final long serialVersionUID = -3370481895716548296L;

	private ArrayList<Travel> m_travels = new ArrayList<Travel>();

	private static final TravelManager tm = new TravelManager();

	private TravelManager() {
	};

	public static final TravelManager getInstance() {
		return tm;
	}

	public ArrayList<Travel> getTravelList() {
		return m_travels;
	}

	public ArrayList<Travel> searchByStart(Coordinate c) {
		ArrayList<Travel> travelS = new ArrayList<Travel>();
		for (Travel t : this.m_travels)
			if (c.equals(t.getCoordinateStart()))
				travelS.add(t);
		return travelS;
	}

	public ArrayList<Travel> searchByDestination(Coordinate c) {
		ArrayList<Travel> travelD = new ArrayList<Travel>();
		for (Travel t : this.m_travels)
			if (c.equals(t.getCoordinateEnd()))
				travelD.add(t);
		return travelD;
	}

	public ArrayList<Travel> searchByDate(Calendar date, int offset) {
		ArrayList<Travel> travelT = new ArrayList<Travel>();

		Calendar datePosOffset = (GregorianCalendar) date.clone();
		datePosOffset.add(Calendar.HOUR_OF_DAY, offset);
		Calendar dateNegOffset = (GregorianCalendar) date.clone();
		dateNegOffset.add(Calendar.HOUR_OF_DAY, -offset);

		for (Travel travel : m_travels) {
			if (travel.getDate().compareTo(datePosOffset) <= 0 && travel.getDate().compareTo(dateNegOffset) >= 0)
				travelT.add(travel);
		}
		return travelT;
	}

	public ArrayList<Travel> searchByMood(ArrayList<Travel> travel, Mood mood) {
		ArrayList<Travel> resultat = new ArrayList<Travel>();
		for (Travel t : travel) {
			if (t.getDriver().getMood().equals(mood))
				resultat.add(t);
			else
				for (Member mp : t.getPassengersList())
					if (mp.getMood().equals(mood)) {
						resultat.add(t);
						break;
					}
		}
		return resultat;
	}

	public boolean addTravel(Travel t) {
		if (m_travels.add(t))
			return true;
		return false;
	}

}
