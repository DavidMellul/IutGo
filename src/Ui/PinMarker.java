package Ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import fr.unice.iut.info.methodo.maps.Coordinate;
import fr.unice.iut.info.methodo.maps.Layer;
import fr.unice.iut.info.methodo.maps.MapMarkerDot;

public class PinMarker extends MapMarkerDot {

	private ImageIcon m_icon;
	private Rectangle m_imageRect;
	
	public PinMarker(String name, Coordinate coord, ImageIcon icon) {
		super(name, coord);
		m_icon = icon;
	}

	public PinMarker(Layer layer, String name, Coordinate coord, ImageIcon icon) {
		super(layer, name, coord);
		m_icon = icon;
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
	        }
		}

        if (getLayer() == null || getLayer().isVisibleTexts()){
        	paintText(g, position);
        }
	}
	
	public boolean contains(Point position){
		return m_imageRect.contains(position);
	}
}
