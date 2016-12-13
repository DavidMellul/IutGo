package Ui.Markers;

import Interests.InterestPoint;
import fr.unice.iut.info.methodo.maps.Coordinate;

public class InterestPinMarker extends PinMarker {

	private InterestPoint m_pointOfInterest;
	
	public InterestPinMarker(String name, Coordinate coord, InterestPoint interest) {
		super(name, coord, PinMarker.RED);
		this.m_pointOfInterest = interest;
	}
	
	public InterestPoint getInterestPoint(){
		return m_pointOfInterest;
	}
}
