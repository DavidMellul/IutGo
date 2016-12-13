package Ui.Markers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.border.StrokeBorder;

import Controllers.Controller;
import Member.Member;
import fr.unice.iut.info.methodo.maps.Coordinate;
import fr.unice.iut.info.methodo.maps.MapMarkerCircle;

public class MemberPinMarker extends PinMarker {
	
	private Member m_memberRef;
	private MapMarkerCircle m_radius;
	
	public MemberPinMarker(String name, Coordinate coord) {
		super(name, coord);
		this.m_memberRef = Controller.getInstance().getCurrentMember();
		this.m_radius = new MapMarkerCircle(m_memberRef.getLastPosition().getMyCoordinate().toOSMCoordinate(), 0.0);
		this.m_icon = GREEN;
	}
	
	public Member getMember(){
		return m_memberRef;
	}
	
	@Override
	public void paint(Graphics g, Point position, int radius) {
		if(m_icon != null){
	        int sizeH = m_icon.getIconHeight();
	        int sizeW = m_icon.getIconWidth();

	        if (g instanceof Graphics2D) {
	        	m_imageRect.setLocation(position.x - sizeW/2, position.y - sizeH);
	        	m_imageRect.setSize(m_icon.getIconWidth(), m_icon.getIconHeight());
	        	g.drawImage(m_icon.getImage(),m_imageRect.x ,m_imageRect.y, null);
	        	g.drawOval((int)(position.x-m_radius.getRadius()/2), (int)(position.y-m_radius.getRadius()/2), (int)m_radius.getRadius(),(int) m_radius.getRadius());
	        }
		}

        if (getLayer() == null || getLayer().isVisibleTexts()){
        	paintText(g, position);
        }
	}
	
	public void setRadius(int r) { this.m_radius = new MapMarkerCircle(m_memberRef.getLastPosition().getMyCoordinate().toOSMCoordinate(), r); }
	
}
