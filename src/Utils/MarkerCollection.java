package Utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

import fr.unice.iut.info.methodo.maps.interfaces.MapMarker;

public class MarkerCollection extends Observable {

	private ArrayList<MapMarker> m_listMarkers;

	public MarkerCollection() {
		this.m_listMarkers = new ArrayList<MapMarker>();
	}

	public void add(MapMarker m) {
		this.m_listMarkers.add(m);
		setChanged();
		notifyObservers();
	}

	public void addAll(ArrayList<MapMarker> list) {
		this.m_listMarkers.addAll(list);
		setChanged();
		notifyObservers();
	}

	public void remove(int index) {
		this.m_listMarkers.remove(index);
		setChanged();
		notifyObservers();
	}

	public void remove(MapMarker m) {
		Iterator<MapMarker> it = m_listMarkers.iterator();
		while(it.hasNext()){
			MapMarker mark = it.next();
			if(mark.getCoordinate().equals(m.getCoordinate())){
				it.remove();
				break;
			}
		}
		setChanged();
		notifyObservers();
	}

	public void removeAll(ArrayList<MapMarker> list) {
		for(MapMarker m : list){
			remove(m);
		}
		setChanged();
		notifyObservers();
	}

	public ArrayList<MapMarker> getMarkers() {
		return this.m_listMarkers;
	}

}
