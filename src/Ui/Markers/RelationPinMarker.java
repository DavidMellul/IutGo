package Ui.Markers;

import Member.Member;
import fr.unice.iut.info.methodo.maps.Coordinate;

public class RelationPinMarker extends MemberPinMarker {
	public RelationPinMarker(String name, Coordinate coord, Member memberRef) {
		super(name, coord, PinMarker.RELATION, memberRef);
	}
}
