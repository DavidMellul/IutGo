package Utils;

import java.util.ArrayList;
import java.util.Observable;

import Ui.Markers.InterestPinMarker;
import Ui.Markers.MemberPinMarker;
import Ui.Markers.RelationPinMarker;
import fr.unice.iut.info.methodo.maps.interfaces.MapMarker;

public class MarkerCollection extends Observable {

	private MemberPinMarker m_currentMember;
	private ArrayList<RelationPinMarker> m_listRelations;
	private ArrayList<InterestPinMarker> m_listInterest;

	public MarkerCollection() {
		m_listRelations = new ArrayList<>();
		m_listInterest = new ArrayList<>();
	}

	public void addRelation(RelationPinMarker m) {
		this.m_listRelations.add(m);
		setChanged();
		notifyObservers();
	}
	
	public void setMemberMarker(MemberPinMarker m){
		m_currentMember = m;
		setChanged();
		notifyObservers();
	}

	public void addInteret(InterestPinMarker m) {
		this.m_listInterest.add(m);
		setChanged();
		notifyObservers();
	}
	
	public void addAllRelations(ArrayList<RelationPinMarker> list){
		m_listRelations.addAll(list);
		setChanged();
		notifyObservers();
	}
	
	public void addAllInterest(ArrayList<InterestPinMarker> list){
		m_listInterest.addAll(list);
		setChanged();
		notifyObservers();
	}
	
	public void removeAllRelations(){
		m_listRelations.clear();
		setChanged();
		notifyObservers();
	}
	
	public void removeAllInterest(){
		m_listInterest.clear();
		setChanged();
		notifyObservers();
	}
	
	public ArrayList<RelationPinMarker> getAllRelations(){
		return this.m_listRelations;
	}
	
	public ArrayList<InterestPinMarker> getAllInterest(){
		return this.m_listInterest;
	}
	
	public MemberPinMarker getCurrentMember(){
		return this.m_currentMember;
	}

}
