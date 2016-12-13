package Ui.Markers;

import javax.swing.ImageIcon;

import Interests.InterestPoint;
import fr.unice.iut.info.methodo.maps.Coordinate;

public class InterestPinMarker extends PinMarker {

	private InterestPoint m_pointOfInterest;
	
	public InterestPinMarker(String name, Coordinate coord, InterestPoint interest) {
		super(name, coord);
		this.m_pointOfInterest = interest;
		this.m_icon = RED;
	}
	
	public InterestPoint getInterestPoint(){
		return m_pointOfInterest;
	}
}
