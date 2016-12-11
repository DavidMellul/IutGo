package Controller;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.Locale;

import Member.Member;
import Ui.PinMarker;
import fr.unice.iut.info.methodo.maps.Coordinate;
import fr.unice.iut.info.methodo.maps.JMapController;
import fr.unice.iut.info.methodo.maps.JMapViewer;
import fr.unice.iut.info.methodo.maps.Layer;
import fr.unice.iut.info.methodo.maps.interfaces.MapMarker;
import fr.unice.iut.info.methodo.maps.interfaces.MapObject;

public class MapController extends JMapController implements MouseListener, MouseMotionListener, MouseWheelListener {

	private static MapController m_instance;

	private static final int MOUSE_BUTTONS_MASK = MouseEvent.BUTTON3_DOWN_MASK | MouseEvent.BUTTON1_DOWN_MASK
			| MouseEvent.BUTTON2_DOWN_MASK;

	private static final int MAC_MOUSE_BUTTON1_MASK = MouseEvent.BUTTON1_DOWN_MASK;
	private int movementMouseButton = MouseEvent.BUTTON1;
	private int movementMouseButtonMask = MouseEvent.BUTTON1_DOWN_MASK;

	private Point lastDragPoint;

	private boolean isMoving;
	private boolean movementEnabled = true;

	private boolean wheelZoomEnabled = true;

	private ArrayList<MapMarker> m_drawnMarkers;

	private Layer m_layerRelations;
	private Layer m_layerUser;

	public MapController(JMapViewer map) {
		super(map);
		m_layerRelations = new Layer("Relations");
		m_layerUser = new Layer("User");
		m_drawnMarkers = new ArrayList<>();
	}

	public static MapController getInstance() {
		return m_instance;
	}

	/*
	 * A appeller AVANT getInstance, pour initialiser le controller
	 */
	public static void init(JMapViewer p_map) {
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
		// Do nothing
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == movementMouseButton || (isPlatformOsx() && e.getModifiersEx() == MAC_MOUSE_BUTTON1_MASK)) {
			lastDragPoint = null;
			isMoving = true;
		}

		PinMarker p = isOnMarker(e.getPoint());
		if (p != null) {
			System.out.println(p.getName());
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
			if (map.getZoom() - rotation >= 2) {
				map.setZoom(map.getZoom() - rotation, e.getPoint());
			}
		}
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
		Coordinate currLocation = Controller.getInstance().getCurrentMember().getLastPosition().getMyCoordinate()
				.toOSMCoordinate();
		MapMarker markerCurrLocation = new PinMarker(m_layerUser, "You", currLocation, PinMarker.GREEN);
		m_layerUser.add(markerCurrLocation);
		m_drawnMarkers.add(markerCurrLocation);
		
		map.setDisplayPosition(new Coordinate(currLocation.getLat(), currLocation.getLon()), 18);
	}

	private void fillLayerRelations(String kindOfRelation) {
		this.m_layerRelations = new Layer(kindOfRelation);
		ArrayList<Member> myRelations = Controller.getInstance().getCurrentMember().getRelations(kindOfRelation);
		for (Member m : myRelations) {
			Coordinate OSMC = m.getLastPosition().getMyCoordinate().toOSMCoordinate();
			MapMarker relationMarker = new PinMarker(m_layerRelations, m.getFirstname(), OSMC, PinMarker.BLUE);
			m_layerRelations.add(relationMarker);
			m_drawnMarkers.add(relationMarker);
		}
	}

	public void showRelationMembers(String kindOfRelation, boolean visible) {
		if (visible) {
			fillLayerRelations(kindOfRelation);
			if (m_layerRelations.getElements() != null)
				for (MapObject m : m_layerRelations.getElements()) {
					MapMarker mm = (PinMarker) m;
					this.map.addMapMarker(mm);
				}
		} else {
			this.m_layerRelations.setVisible(false);
		}
	}

	public PinMarker isOnMarker(Point position) {
		for (MapMarker m : m_drawnMarkers) {
			if (m instanceof PinMarker) {
				if (((PinMarker) m).contains(position))
					return (PinMarker) m;
			}
		}
		return null;
	}
}