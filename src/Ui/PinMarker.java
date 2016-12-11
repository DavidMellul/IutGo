package Ui;

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.ImageIcon;

import fr.unice.iut.info.methodo.maps.Coordinate;
import fr.unice.iut.info.methodo.maps.Layer;
import fr.unice.iut.info.methodo.maps.MapMarkerDot;

public class PinMarker extends MapMarkerDot {

	private ImageIcon m_icon;
	
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
	        	g.drawImage(m_icon.getImage(), position.x - sizeW/2, position.y - sizeH, null);
	        }
		}

        if (getLayer() == null || getLayer().isVisibleTexts()){
        	paintText(g, position);
        }
	}
	
	
}
