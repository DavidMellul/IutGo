package Ui.Markers;

import Member.Member;
import fr.unice.iut.info.methodo.maps.Coordinate;

public class FormationPinMarker extends MemberPinMarker {
	public FormationPinMarker(String name, Coordinate coord, Member memberRef) {
		super(name, coord, PinMarker.FORMATION, memberRef);
	}
}
