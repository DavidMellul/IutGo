package Data;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import Interests.InterestPoint;
import Interests.Lodging;
import Utils.MyCoordinate;


public class InterestManager implements Serializable {
	
	private static final long serialVersionUID = -7398633576499773357L;
	ArrayList<InterestPoint> m_piList;

    public InterestManager(){
        m_piList = new ArrayList<InterestPoint>();
    }

    public void createInterestPoint(String nom, String desc, double lat, double lon){
        InterestPoint pI = new InterestPoint(nom, desc, lat, lon);
        m_piList.add(pI);
    }

    public void addNote(String nom, int note){
        InterestPoint pI = getInterestPoint(nom);
        if(pI != null){
            pI.addNote(note);
        }
    }

    private InterestPoint getInterestPoint(String nom){
        for(InterestPoint pI : m_piList){
            if(pI.getName().equals(nom)){
                return pI;
            }
        }
        return null;
    }

    public void addHebergement(String nomPI, float cout, String nomH){
        InterestPoint pI = getInterestPoint(nomPI);
        if(pI != null){
            pI.addLodgings(new Lodging(cout, nomH));
        }
    }

    public int size(){ return m_piList.size(); }

    public ArrayList<InterestPoint> getNearestPointOfInterest(MyCoordinate p_center, double p_radius, String nameFilter, float minNote) throws IllegalArgumentException {
        if(p_radius <= 0) throw new IllegalArgumentException("Radius is 0 or less");

        ArrayList<InterestPoint> list = new ArrayList<InterestPoint>();

        double x1 = 6371 * Math.cos(p_center.getLat()) * Math.cos(p_center.getLon());
        double y1 = 6371 * Math.cos(p_center.getLat()) * Math.sin(p_center.getLon());

        Iterator<InterestPoint> it = m_piList.iterator();
        while(it.hasNext())
        {
            InterestPoint i = it.next();
            double x2 = 6371 * Math.cos(i.getMyCoordinate().getLat()) * Math.cos(i.getMyCoordinate().getLon());
            double y2 = 6371 * Math.cos(i.getMyCoordinate().getLat()) * Math.sin(i.getMyCoordinate().getLon());
            double d = Math.sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1));

            float price = i.getCoutNuitee();
            if (Math.abs(d) <= p_radius && i.getName().contains(nameFilter) && i.getNoteMoyenne() >= minNote) {
                list.add(i);
            }
        }
        return list;
    }
}
