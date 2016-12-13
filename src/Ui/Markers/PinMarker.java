package Ui.Markers;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Controllers.MapController;
import fr.unice.iut.info.methodo.maps.Coordinate;
import fr.unice.iut.info.methodo.maps.MapMarkerDot;

public abstract class PinMarker extends MapMarkerDot {

	public static final ImageIcon GREEN = new ImageIcon(MapController.class.getResource("/Resources/icone_marker_green.png"));
	public static final ImageIcon RED = new ImageIcon(MapController.class.getResource("/Resources/icone_marker_red.png"));
	public static final ImageIcon YELLOW = new ImageIcon(MapController.class.getResource("/Resources/icone_marker_yellow.png"));
	public static final ImageIcon BLUE = new ImageIcon(MapController.class.getResource("/Resources/icone_marker_blue.png"));
	public static final ImageIcon CYAN = new ImageIcon(MapController.class.getResource("/Resources/icone_marker_cyan.png"));
	
	protected ImageIcon m_icon;
	protected Rectangle m_imageRect;
	
	
	public PinMarker(String name, Coordinate coord, ImageIcon icon) {
		super(name, coord);
		m_imageRect = new Rectangle(0, 0, 0, 0);
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
