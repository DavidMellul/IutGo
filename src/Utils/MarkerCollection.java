package Utils;

import java.util.ArrayList;
import java.util.Observable;

import Ui.Markers.FormationPinMarker;
import Ui.Markers.InterestPinMarker;
import Ui.Markers.MemberPinMarker;
import Ui.Markers.PinMarker;
import Ui.Markers.RelationPinMarker;
import Ui.Markers.TravelPinMarker;

public class MarkerCollection extends Observable {

	private MemberPinMarker m_currentMember;
	private ArrayList<RelationPinMarker> m_listRelations;
	private ArrayList<InterestPinMarker> m_listInterest;
	private ArrayList<FormationPinMarker> m_listFormation;
	private ArrayList<TravelPinMarker> m_listCarpool;

	public MarkerCollection() {
		m_listRelations = new ArrayList<>();
		m_listInterest = new ArrayList<>();
		m_listFormation = new ArrayList<>();
		m_listCarpool = new ArrayList<>();
	}

	public void setMemberMarker(MemberPinMarker m) {
		m_currentMember = m;
		setChanged();
		notifyObservers();
	}

	public void addRelation(RelationPinMarker m) {
		this.m_listRelations.add(m);
		setChanged();
		notifyObservers();
	}

	public void addInteret(InterestPinMarker m) {
		this.m_listInterest.add(m);
		setChanged();
		notifyObservers();
	}

	public void addFormation(FormationPinMarker m) {
		this.m_listFormation.add(m);
		setChanged();
		notifyObservers();
	}

	public void addCarpool(TravelPinMarker m) {
		this.m_listCarpool.add(m);
		setChanged();
		notifyObservers();
	}

	public void addAllRelations(ArrayList<RelationPinMarker> list) {
		m_listRelations.addAll(list);
		setChanged();
		notifyObservers();
	}

	public void addAllInterest(ArrayList<InterestPinMarker> list) {
		m_listInterest.addAll(list);
		setChanged();
		notifyObservers();
	}

	public void addAllFormation(ArrayList<FormationPinMarker> list) {
		m_listFormation.addAll(list);
		setChanged();
		notifyObservers();
	}

	public void addAllCarpool(ArrayList<TravelPinMarker> list) {
		m_listCarpool.addAll(list);
		setChanged();
		notifyObservers();
	}

	public void removeAllRelations() {
		m_listRelations.clear();
		setChanged();
		notifyObservers();
	}

	public void removeAllInterest() {
		m_listInterest.clear();
		setChanged();
		notifyObservers();
	}

	public void removeAllFormation() {
		m_listFormation.clear();
		setChanged();
		notifyObservers();
	}

	public void removeAllCarpool() {
		m_listCarpool.clear();
		setChanged();
		notifyObservers();
	}

	public ArrayList<RelationPinMarker> getAllRelations() {
		return this.m_listRelations;
	}

	public ArrayList<InterestPinMarker> getAllInterest() {
		return this.m_listInterest;
	}

	public ArrayList<FormationPinMarker> getAllFormations() {
		return this.m_listFormation;
	}

	public ArrayList<TravelPinMarker> getAllCarpools() {
		return this.m_listCarpool;
	}

	public MemberPinMarker getCurrentMember() {
		return this.m_currentMember;
	}

}
