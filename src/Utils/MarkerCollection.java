package Utils;

import java.util.ArrayList;
import java.util.Observable;

import fr.unice.iut.info.methodo.maps.interfaces.MapMarker;

public class MarkerCollection extends Observable{
	
	private ArrayList<MapMarker> m_listMarkers;
	
	public MarkerCollection() {
		this.m_listMarkers = new ArrayList<MapMarker>();
	}
	
	public void add(MapMarker m) { this.m_listMarkers.add(m); setChanged(); notifyObservers(); }
	public void addAll(ArrayList<MapMarker> list) { this.m_listMarkers.addAll(list); setChanged(); notifyObservers(); }
	public void remove(int index) { this.m_listMarkers.remove(index); setChanged(); notifyObservers(); }
	public void remove(MapMarker m) { this.m_listMarkers.remove(m); setChanged(); notifyObservers(); }
	public void removeAll(ArrayList<MapMarker> list) { this.m_listMarkers.removeAll(list); setChanged(); notifyObservers(); }
	public ArrayList<MapMarker> getMarkers() { return this.m_listMarkers; }

}
