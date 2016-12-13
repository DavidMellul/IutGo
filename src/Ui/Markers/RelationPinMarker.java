package Ui.Markers;

import Member.Member;
import fr.unice.iut.info.methodo.maps.Coordinate;

public class RelationPinMarker extends PinMarker{
		private Member m_memberRef;
		
		public RelationPinMarker(String name, Coordinate coord, Member memberRef) {
			super(name, coord);
			this.m_memberRef = memberRef;
			this.m_icon = BLUE;
		}
		
		public Member getMember(){
			return m_memberRef;
		}
	
}
