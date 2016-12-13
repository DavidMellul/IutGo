package Ui.Markers;

import javax.swing.ImageIcon;

import Travels.Travel;
import fr.unice.iut.info.methodo.maps.Coordinate;

public class TravelPinMarker extends PinMarker {

	private Travel m_travelRef;
	
	public TravelPinMarker(String name, Coordinate coord, Travel travelRef) {
		super(name, coord, PinMarker.TRAVEL);
		m_travelRef = travelRef;
	}

	public Travel getTravel() {
		return m_travelRef;
	}
}
