package Controller;


import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.ImageIcon;

import Member.Member;
import Ui.PinMarker;
import Utils.MyCoordinate;
import fr.unice.iut.info.methodo.maps.Coordinate;
import fr.unice.iut.info.methodo.maps.JMapController;
import fr.unice.iut.info.methodo.maps.JMapViewer;
import fr.unice.iut.info.methodo.maps.Layer;
import fr.unice.iut.info.methodo.maps.MapMarkerDot;
import fr.unice.iut.info.methodo.maps.interfaces.MapMarker;
import fr.unice.iut.info.methodo.maps.interfaces.MapObject;

public class MapController extends JMapController implements MouseListener, MouseMotionListener, MouseWheelListener {

	private static MapController m_instance;
	
	private static final int MOUSE_BUTTONS_MASK = MouseEvent.BUTTON3_DOWN_MASK | MouseEvent.BUTTON1_DOWN_MASK
			| MouseEvent.BUTTON2_DOWN_MASK;

	private static final int MAC_MOUSE_BUTTON1_MASK = MouseEvent.BUTTON1_DOWN_MASK;

	private Point lastDragPoint;

	private boolean isMoving;

	private boolean movementEnabled = true;

	private int movementMouseButton = MouseEvent.BUTTON1;
	private int movementMouseButtonMask = MouseEvent.BUTTON1_DOWN_MASK;

	private boolean wheelZoomEnabled = true;
	
	private Layer m_layerRelations;
	
	private static final ImageIcon m_relationStyle = new ImageIcon(MapController.class.getResource("/Resources/icone_marker_green.png"));

	public MapController(JMapViewer map) {
		super(map);
		m_layerRelations = new Layer("");
	}
	
	public static MapController getInstance(){
		return m_instance;
	}
	
	/*
	 * A appeller AVANT getInstance, pour initialiser le controller
	 */
	public static void init(JMapViewer p_map){
		m_instance = new MapController(p_map);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (!movementEnabled || !isMoving)
			return;
		// Is only the selected mouse button pressed?
		if ((e.getModifiersEx() & MOUSE_BUTTONS_MASK) == movementMouseButtonMask
				|| (isPlatformOsx() && e.getModifiersEx() == MAC_MOUSE_BUTTON1_MASK)) {
			Point p = e.getPoint();
			if (lastDragPoint != null) {
				int diffx = lastDragPoint.x - p.x;
				int diffy = lastDragPoint.y - p.y;
				map.moveMap(diffx, diffy);
			}
			lastDragPoint = p;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//Do nothing
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == movementMouseButton || (isPlatformOsx() && e.getModifiersEx() == MAC_MOUSE_BUTTON1_MASK)) {
			lastDragPoint = null;
			isMoving = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == movementMouseButton || (isPlatformOsx() && e.getButton() == MouseEvent.BUTTON1)) {
			lastDragPoint = null;
			isMoving = false;
		}
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if (wheelZoomEnabled) {
			int rotation = JMapViewer.zoomReverseWheel ? -e.getWheelRotation() : e.getWheelRotation();
			if(map.getZoom() - rotation >= 2){
				map.setZoom(map.getZoom() - rotation, e.getPoint());
			}
		}
	}
	
	public boolean isMovementEnabled() {
		return movementEnabled;
	}
	
	public void setMovementEnabled(boolean movementEnabled) {
		this.movementEnabled = movementEnabled;
	}

	public int getMovementMouseButton() {
		return movementMouseButton;
	}
	
	public void setMovementMouseButton(int movementMouseButton) {
		this.movementMouseButton = movementMouseButton;
		switch (movementMouseButton) {
		case MouseEvent.BUTTON1:
			movementMouseButtonMask = MouseEvent.BUTTON1_DOWN_MASK;
			break;
		case MouseEvent.BUTTON2:
			movementMouseButtonMask = MouseEvent.BUTTON2_DOWN_MASK;
			break;
		case MouseEvent.BUTTON3:
			movementMouseButtonMask = MouseEvent.BUTTON3_DOWN_MASK;
			break;
		default:
			throw new RuntimeException("Unsupported button");
		}
	}

	public boolean isWheelZoomEnabled() {
		return wheelZoomEnabled;
	}

	public void setWheelZoomEnabled(boolean wheelZoomEnabled) {
		this.wheelZoomEnabled = wheelZoomEnabled;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// do nothing
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// do nothing
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if (isPlatformOsx()) {
			if (!movementEnabled || !isMoving)
				return;
			if (e.getModifiersEx() == MouseEvent.CTRL_DOWN_MASK) {
				Point p = e.getPoint();
				if (lastDragPoint != null) {
					int diffx = lastDragPoint.x - p.x;
					int diffy = lastDragPoint.y - p.y;
					map.moveMap(diffx, diffy);
				}
				lastDragPoint = p;
			}
		}
	}
	
    public static boolean isPlatformOsx() {
        String os = System.getProperty("os.name");
        return os != null && os.toLowerCase(Locale.ENGLISH).startsWith("mac os x");
    }
    
    public void showAndFitOnCurrentPosition() {
    	MyCoordinate currLocation = Controller.getInstance().getCurrentMember().getLastPosition().getMyCoordinate();
		MapMarker markerCurrLocation = new MapMarkerDot(Color.BLUE, currLocation.getLat(), currLocation.getLon());
		this.map.addMapMarker(markerCurrLocation);
		this.map.setDisplayPosition(new Coordinate(currLocation.getLat(),currLocation.getLon()), 19);
    }
    
    private void fillLayerRelations(String kindOfRelation) {
    	this.m_layerRelations = new Layer(kindOfRelation);
    	ArrayList<Member> myRelations = Controller.getInstance().getCurrentMember().getRelations(kindOfRelation);	
    	for(Member m : myRelations) {
	    		MyCoordinate mC = m.getLastPosition().getMyCoordinate();
	    		Coordinate OSMC = new Coordinate(mC.getLat(),mC.getLon());
	    		MapMarker relationMarker = new PinMarker(m_layerRelations, m.getFirstname(), OSMC, m_relationStyle);
	    		m_layerRelations.add(relationMarker);
    		}    
    	}
    
    public void showRelationMembers(String kindOfRelation, boolean visible) { 
    	if(visible) {
	    	fillLayerRelations(kindOfRelation);
	    	for(MapObject m : m_layerRelations.getElements()) {
	    		MapMarker mm = (MapMarkerDot)m;
	    		this.map.addMapMarker(mm);
	    	}
    	}
    	else {
    		this.m_layerRelations.setVisible(false);
    	}
    }
}