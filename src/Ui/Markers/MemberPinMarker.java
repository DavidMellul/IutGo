package Ui.Markers;

import javax.swing.ImageIcon;

import Member.Member;
import fr.unice.iut.info.methodo.maps.Coordinate;

public class MemberPinMarker extends PinMarker {
	
	private Member m_memberRef;
	
	public MemberPinMarker(String name, Coordinate coord, ImageIcon icon, Member memberRef) {
		super(name, coord, icon);
		m_memberRef = memberRef;
	}
	
	public Member getMember(){
		return m_memberRef;
	}
	
}
