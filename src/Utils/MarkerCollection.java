package Utils;

import java.util.ArrayList;
import java.util.Observable;

import fr.unice.iut.info.methodo.maps.interfaces.MapMarker;

public class MarkerCollection extends Observable {

	private MapMarker m_currentMember;
	private ArrayList<MapMarker> m_listRelations;
	private ArrayList<MapMarker> m_listInterest;

	public MarkerCollection() {
		m_listRelations = new ArrayList<>();
		m_listInterest = new ArrayList<>();
	}

	public void addRelation(MapMarker m) {
		this.m_listRelations.add(m);
		setChanged();
		notifyObservers();
	}
	
	public void setMemberMarker(MapMarker m){
		m_currentMember = m;
		setChanged();
		notifyObservers();
	}

	public void addInteret(MapMarker m) {
		this.m_listInterest.add(m);
		setChanged();
		notifyObservers();
	}
	
	public void addAllRelations(ArrayList<MapMarker> list){
		m_listRelations.addAll(list);
		setChanged();
		notifyObservers();
	}
	
	public void addAllInterest(ArrayList<MapMarker> list){
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
	
	public ArrayList<MapMarker> getAllRelations(){
		return this.m_listRelations;
	}
	
	public ArrayList<MapMarker> getAllInterest(){
		return this.m_listInterest;
	}
	
	public MapMarker getCurrentMember(){
		return this.m_currentMember;
	}

}
