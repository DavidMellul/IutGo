package Ui.Markers;

import javax.swing.ImageIcon;

import Controllers.Controller;
import Member.Member;
import fr.unice.iut.info.methodo.maps.Coordinate;

public class MemberPinMarker extends PinMarker {

	private Member m_memberRef;

	public MemberPinMarker(String name, Coordinate coord) {
		super(name, coord, PinMarker.SELF);
		this.m_memberRef = Controller.getInstance().getCurrentMember();
	}

	protected MemberPinMarker(String name, Coordinate coord, ImageIcon color, Member memberRef) {
		super(name, coord, color);
		m_memberRef = memberRef;
	}
	
	public Member getMember() {
		return m_memberRef;
	}
}
