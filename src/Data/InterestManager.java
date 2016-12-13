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
            double dLat = Math.toRadians(p_center.getLat()- i.getLat());
            double dLon = Math.toRadians(p_center.getLon()- i.getLon());
            double lat1 = Math.toRadians(p_center.getLat());
            double lat2 = Math.toRadians(i.getLat());
            
            double a = Math.sin(dLat/2)*Math.sin(dLat/2) + Math.sin(dLon/2) * Math.sin(dLon/2) * Math.cos(lat1)*Math.cos(lat2);
            double c = 2*Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
            double d = 6371 * c;
            
            if (Math.abs(d) <= p_radius && i.getName().toLowerCase().contains(nameFilter.toLowerCase()) && i.getNoteMoyenne() >= minNote) {
                list.add(i);
            }
        }
        return list;
    }
}
