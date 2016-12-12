package Controller;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;

import Interests.InterestPoint;
import Member.Member;
import Ui.InterestDialog;
import Ui.InterestPinMarker;
import Ui.MemberPinMarker;
import Ui.PinMarker;
import Ui.InfoCards.InterestCard;
import Ui.InfoCards.UserCard;
import Utils.MarkerCollection;
import Utils.MyCoordinate;
import fr.unice.iut.info.methodo.maps.Coordinate;
import fr.unice.iut.info.methodo.maps.JMapController;
import fr.unice.iut.info.methodo.maps.JMapViewer;
import fr.unice.iut.info.methodo.maps.interfaces.MapMarker;

public class MapController extends JMapController implements MouseListener, MouseMotionListener, MouseWheelListener, Observer {


	private static final int MOUSE_BUTTONS_MASK = MouseEvent.BUTTON3_DOWN_MASK | MouseEvent.BUTTON1_DOWN_MASK
			| MouseEvent.BUTTON2_DOWN_MASK;

	private static final int MAC_MOUSE_BUTTON1_MASK = MouseEvent.BUTTON1_DOWN_MASK;
	private int movementMouseButton = MouseEvent.BUTTON1;
	private int movementMouseButtonMask = MouseEvent.BUTTON1_DOWN_MASK;
	private int interestMouseButton = MouseEvent.BUTTON3;

	private Point lastDragPoint;

	private boolean isMoving;
	private boolean movementEnabled = true;

	private boolean wheelZoomEnabled = true;

	private MarkerCollection m_listMarkers;
	private UserCard m_userCard;
	private InterestCard m_interestCard;
//	private boolean m_isACardShown;
	
	// ----------------------------------------------------------------- SINGLETON -------------------------------------------------
	private static MapController m_instance;
	private MapController(JMapViewer map) {
		super(map);
		m_listMarkers = new MarkerCollection(); m_listMarkers.addObserver(this);
		m_userCard = new UserCard();
		m_userCard.getBtnMinus().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				m_userCard.setVisible(false);
				map.remove(m_userCard);
			}
		});
		m_userCard.setVisible(false);
		
		m_interestCard = new InterestCard();
		m_interestCard.getBtnMinus().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				m_interestCard.setVisible(false);
				map.remove(m_interestCard);
			}
		});
		m_interestCard.setVisible(false);
	}

	public static MapController getInstance() {
		return m_instance;
	}
	
	public static void init(JMapViewer p_map) {
		m_instance = new MapController(p_map);
	}
	
	// ----------------------------------------------------------------- LISTENERS -------------------------------------------------
	@Override
	public void mouseDragged(MouseEvent e) {
		if (!movementEnabled || !isMoving || !canMoveMap())
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
		if(e.getButton() == movementMouseButton){
			PinMarker p = isOnMarker(e.getPoint());
			if (p != null) {
				if(p instanceof MemberPinMarker){
					Point position = map.getMapPosition(p.getCoordinate()); 
					position.setLocation(position.getX() - m_userCard.getWidth()/2, position.getY() - m_userCard.getHeight()/2);
					m_userCard.showMember(((MemberPinMarker) p).getMember(), position);
					m_userCard.setVisible(true);
					map.add(m_userCard);
				}else if(p instanceof InterestPinMarker){
					Point position = map.getMapPosition(p.getCoordinate()); 
					position.setLocation(position.getX() - m_interestCard.getWidth()/2, position.getY() - m_interestCard.getHeight()/2);
					m_interestCard.showInterestPoint(((InterestPinMarker) p).getInterestPoint(), position);
					m_interestCard.setVisible(true);
					map.add(m_interestCard);
				}
				
				map.updateUI();
			}
		}
		else if(e.getButton() == interestMouseButton){
			Coordinate c = (Coordinate) map.getPosition(e.getPoint());
			InterestDialog d = new InterestDialog();
			d.setLocation(e.getLocationOnScreen());
			d.setVisible(true);
			d.getAddBtn().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(!d.getTxtDesc().getText().isEmpty() && !d.getTxtName().getText().isEmpty()){
						Controller.getInstance().addPointOfInterest(d.getTxtName().getText(), d.getTxtDesc().getText(), c);
						d.dispose();
					}
				}
			});
		}
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

	// ----------------------------------------------------------------- METHODES ESSENTIELLES -------------------------------------------------

	public void showAndFitOnCurrentPosition() {
		Coordinate currLocation = Controller.getInstance().getCurrentMember().getLastPosition().getMyCoordinate()
				.toOSMCoordinate();
		PinMarker markerCurrLocation = new MemberPinMarker("You", currLocation, PinMarker.GREEN, Controller.getInstance().getCurrentMember());
//		markerCurrLocation.setCard(new UserCard(Controller.getInstance().getCurrentMember()));
		m_listMarkers.add(markerCurrLocation);
		
		map.setDisplayPosition(new Coordinate(currLocation.getLat(), currLocation.getLon()), 18);
	}



	public void showRelationMembers(String kindOfRelation, boolean visible) {
		ArrayList<MapMarker> toChange = new ArrayList<MapMarker>();
		for(Member m : Controller.getInstance().getCurrentMember().getRelations(kindOfRelation)) {
			MyCoordinate mcMember = m.getLastPosition().getMyCoordinate();
			Coordinate osmcMember = new Coordinate(mcMember.getLat(), mcMember.getLon());
			PinMarker relation = new MemberPinMarker(m.toString(), osmcMember, PinMarker.BLUE, m);
//			relation.setCard(new UserCard(m));
			toChange.add(relation);
		}
		
		if (visible) {
			this.m_listMarkers.addAll(toChange);
		} else {
			this.m_listMarkers.removeAll(toChange);
		}
	}
	
	public void showPointOfInterest(double p_radius, String nameFilter, float minNote, boolean visible){
		ArrayList<InterestPoint> pIs = Controller.getInstance().getInterestManager().getNearestPointOfInterest(Controller.getInstance().getCurrentMember().getLastPosition().getMyCoordinate(), p_radius, nameFilter, minNote);
		ArrayList<MapMarker> toChange = new ArrayList<MapMarker>();
		for(InterestPoint p : pIs) {
			PinMarker relation = new InterestPinMarker(p.getName(), p.getMyCoordinate().toOSMCoordinate(), PinMarker.RED, p);
			toChange.add(relation);
		}
		
		if (visible) {
			this.m_listMarkers.addAll(toChange);
		} else {
			this.m_listMarkers.removeAll(toChange);
		}
	}
	
	public boolean canMoveMap(){
		if(m_userCard.isVisible()) return false;
		
		return true;
	}

	public PinMarker isOnMarker(Point position) {
		for (MapMarker m : m_listMarkers.getMarkers()) {
			if (m instanceof PinMarker) {
				if (((PinMarker) m).contains(position))
					return (PinMarker) m;
			}
		}
		return null;
	}

	// ------------------------------------------------------------------ PATTERN OBSERVER-OBSERVABLE -----------------------------------------------
	@Override
	public void update(Observable o, Object arg) {
		map.removeAllMapMarkers();
		MarkerCollection mc = (MarkerCollection)o;
		for(MapMarker m : mc.getMarkers())
			map.addMapMarker(m);
		map.updateUI();
	}
}
