package Member;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import Data.GPSManager;
import Data.LinkManager;
import Data.TravelManager;
import Interests.InterestPoint;
import Links.CustomLink;
import Links.Link;
import Travels.Travel;
import Utils.Address;
import Utils.Formation;
import Utils.GPSData;
import Utils.Mood;
import fr.unice.iut.info.methodo.maps.Coordinate;

public class Member implements Serializable{

	// --------------------------------------- SERIAL VERSION ID -----------------------------------
	private static final long serialVersionUID = -741883278053815891L;

	
	private static int ID_MEMBER = 1; 
	
	// ---------------------------------------------- BASE -----------------------------------------
	private int m_id;
	private String m_firstname;
	private String m_lastname;
	
	private String m_login;
	private String m_password;
	
	// -------------------------------------------- GPS --------------------------------------------
	private ArrayList<GPSData> m_gpsDatas;
	private GPSManager m_gps;
	
	// -------------------------------------------- LINKS ------------------------------------------
	private ArrayList<Link> m_links;
	
	// -------------------------------------------- TRAVELS ----------------------------------------
	private ArrayList<Travel> m_travels;
	
	// ------------------------------------------- INTEREST ----------------------------------------
    private HashMap<String, Date> m_interestPoints;

	// ------------------------------------------- FACEBOOK ----------------------------------------
    private String m_nickname;
    private Mood m_mood;
    private Address m_address;
    private Formation m_formation;
	
	// -------------------------------------------- CONSTRUCTEURS ----------------------------------
	public Member() {
		this.m_id = ID_MEMBER++;
		this.m_firstname = "undefined";
		this.m_lastname = "undefined";
		this.m_nickname = "undefined";
		this.m_login = new String();
		this.m_password = new String();
		
		this.m_gpsDatas = new ArrayList<GPSData>();
		this.m_links = new ArrayList<Link>();
		this.m_travels = new ArrayList<Travel>();
		this.m_interestPoints = new HashMap<String, Date>();
		
		this.m_formation = new Formation();
		this.m_mood = Mood.NO_SPECIAL_MOOD;
		this.m_address = new Address();
		
		this.m_gps = new GPSManager();
	}
	
	public Member(int id) {
		this.m_id = id;
		this.m_firstname = "undefined";
		this.m_lastname = "undefined";
		this.m_nickname = "undefined";
		this.m_login = new String();
		this.m_password = new String();

		
		this.m_gpsDatas = new ArrayList<GPSData>();
		this.m_links = new ArrayList<Link>();
		this.m_travels = new ArrayList<Travel>();
		this.m_interestPoints = new HashMap<String, Date>();
		
		this.m_formation = new Formation();
		this.m_mood = Mood.NO_SPECIAL_MOOD;
		this.m_address = new Address();
		
		this.m_gps = new GPSManager();
	}
	
	public Member(String firstname, String lastname) {
		this.m_id = ID_MEMBER++;
		this.m_firstname = firstname;
		this.m_lastname = lastname;
		this.m_nickname = "undefined";
		this.m_login = new String();
		this.m_password = new String();
		
		this.m_gpsDatas = new ArrayList<GPSData>();
		this.m_links = new ArrayList<Link>();
		this.m_travels = new ArrayList<Travel>();
		this.m_interestPoints = new HashMap<String, Date>();
		
		this.m_formation = new Formation();
		this.m_mood = Mood.NO_SPECIAL_MOOD;
		this.m_address = new Address();
		
		this.m_gps = new GPSManager();
	}
	
	public Member(int id, String firstname, String lastname) {
		this.m_id = id;
		this.m_firstname = firstname;
		this.m_lastname = lastname;
		this.m_login = new String();
		this.m_password = new String();
		
		this.m_gpsDatas = new ArrayList<GPSData>();
		this.m_links = new ArrayList<Link>();
		this.m_travels = new ArrayList<Travel>();
		this.m_interestPoints = new HashMap<String, Date>();
		
		this.m_formation = new Formation();
		this.m_mood = Mood.NO_SPECIAL_MOOD;
		this.m_address = new Address();
		
		this.m_gps = new GPSManager();
	}
	
	
	// ---------------------------------------------- ACCESSEURS -------------------------------------
	public int getId() { return this.m_id; }
	
	public void setFirstname(String firstname) { this.m_firstname = firstname; }
	public String getFirstname() { return this.m_firstname; }
	
	public void setNickname(String nickname) { this.m_nickname = nickname; }
	public String getNickname() { return this.m_nickname; }
	
	public void setLastname(String lastname) { this.m_lastname = lastname; }
	public String getLastname()  { return this.m_lastname; }
	
	public void setLogin(String login) { this.m_login = login; }
	public String getLogin() { return this.m_login; }
	
	public void setPassword(String password) { this.m_password = password; }
	public String getPassword() { return this.m_password; }
	
	public void setMood(Mood m) { this.m_mood = m; }
	public Mood getMood() { return this.m_mood; }
	
	public void setFormation(Formation f) { this.m_formation = f; f.addMember(this);}
	public Formation getFormation() { return this.m_formation; }
	
	public void setAddress(Address a) { this.m_address = a; a.addMember(this);}
	public Address getAddress() { return this.m_address; }
	
	public void setLinks(ArrayList<Link> links) { this.m_links = links; }
	public ArrayList<Link> getLinks() { return this.m_links; }
	
	public void setTravels(ArrayList<Travel> travels) { this.m_travels = travels; }
	public ArrayList<Travel> getTravels() { return this.m_travels; }
	
	public void setGPSDatas(ArrayList<GPSData> gpsDatas) { this.m_gpsDatas = gpsDatas; }
	public ArrayList<GPSData> getGPSData() { return this.m_gpsDatas; }
	
	public void setInterestPoints(HashMap<String, Date> h) { this.m_interestPoints = h; }
	public HashMap<String, Date> getInterestPoints() { return this.m_interestPoints; }
	
	// --------------------------------------------- REDEFINITIONS OBJECT -----------------------------
	@Override
	public String toString() {
		return this.m_firstname+" "+this.m_lastname;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Member) {
			Member m = (Member)o;
			return this.getId() == m.getId();
		}
		return false;
	}
	
	// ---------------------------------------------- PARTIE GPS --------------------------------------
	public void recordPosition() { this.m_gpsDatas.add(m_gps.getCurrentPosition()); }
	public GPSData getLastPosition() {return this.m_gps.getLastPosition(this);}
	public GPSData getPositionAtDate(Date date) { return this.m_gps.getPosition(this, date); }
	public Object[] getFrequentPosition(int day) { return this.m_gps.getFrequentPosition(this, day); }
	public ArrayList<Member> getSurroundingMembers(double radius) { return this.m_gps.getSurroundingMembers(this, radius); }
	public ArrayList<GPSData> getPath(Date d1, Date d2) { return this.m_gps.getPath(this, d1, d2); }
	
	
	// --------------------------------------------- PARTIE LINKED ------------------------------------
	public ArrayList<Member> getRelations(String type) {
        //LinkManager lm = LinkManager.getInstance();
        ArrayList<Member> relations = new ArrayList<Member>();
        for (Link link : this.m_links) {
            if (link.getType().equals(type))
                relations.add(link.getMember2());
        }
        return relations;
    }
	public ArrayList<Member> getAllRelations() {
        ArrayList<Member> relations = new ArrayList<Member>();
        for (Link link : this.m_links)
            relations.add(link.getMember2());
        return relations;
    }
	public void addCustomLink(String s) {
        LinkManager lm = LinkManager.getInstance();
        CustomLink ck = new CustomLink();

        if (!ck.existCustomLink(s))
            lm.addRelationnalCustomLink(s);
    }
	public boolean isLinkedTo(Member lma, Member lmb, String s) {
        for (Link link : lma.getLinks()) {
            if (link.getType().equals(s)) {
                for (Link link2 : lmb.getLinks()) {
                    if (link2.getType().equals(s)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
	public boolean hasCommonRelations(Member lma, Member lmb) {
        for (Link link1 : lma.getLinks()) {
            for (Link link2 : lmb.getLinks()) {
                if (link1.getMember2().equals(link2.getMember2())) {
                    return true;
                }
            }
        }
        return false;
    }
	
	// ----------------------------------------------- PARTIE TRAVELS ----------------------------------
	public boolean addTravel(Travel travel) { return this.m_travels.add(travel); }
	public ArrayList<Travel> getPastTravels() {
		Calendar date = new GregorianCalendar();
        ArrayList<Travel> travelDone = new ArrayList<Travel>();

        for (Travel travel : this.m_travels) {
            if ((travel.getDate()).before(date)) {
                travelDone.add(travel);
            }
        }
        return travelDone;
	}
	public ArrayList<Travel> getTravelsAsDriver() {
	  ArrayList<Travel> travelDone = this.getPastTravels();
	  ArrayList<Travel> travelDriver = new ArrayList<Travel>();
	  for (Travel t : travelDone) {
	      if (t.getDriver().getId() == this.m_id)
	        travelDriver.add(t);
	  }
	  return travelDriver;
	}
	public ArrayList<Travel> getTravelsAsPassenger() {
        ArrayList<Travel> travelDone = this.getPastTravels();
        ArrayList<Travel> travelPassenger = new ArrayList<Travel>();

        for (Travel t : travelDone) {
            if (t.getDriver().getId() != this.m_id)
                travelPassenger.add(t);
        }
        return travelPassenger;
    }
	public ArrayList<Travel> findTravellingMembers(String destination) {
        ArrayList<Travel> listTravels = new ArrayList<Travel>();
        
        TravelManager tm = TravelManager.getInstance();

        String myPosition = this.getLastPosition().toLocation(6);
        myPosition = myPosition.substring(0,myPosition.indexOf(','));

        for(Travel t : tm.getTravelList()) {
            Coordinate cStart = t.getCoordinateStart();
            Coordinate cEnd = t.getCoordinateEnd();

            Calendar dTravel = t.getDate();

            GPSData gStart = new GPSData(cStart,dTravel.getTime());
            GPSData gEnd = new GPSData(cEnd,new Date());

            String locationStart = gStart.toLocation(6); locationStart = gStart.toLocation(6).substring(0,locationStart.indexOf(','));
            String locationEnd = gEnd.toLocation(6);  locationEnd = gEnd.toLocation(6).substring(0,locationEnd.indexOf(','));

            System.out.println(locationStart+" "+locationEnd);
            if(locationEnd.equalsIgnoreCase(destination) && locationStart.equalsIgnoreCase(myPosition)) {
                Calendar tmp = Calendar.getInstance();
                if(			tmp.get(Calendar.YEAR) == dTravel.get(Calendar.YEAR) 
                		&& 	tmp.get(Calendar.MONTH) == dTravel.get(Calendar.MONTH) 
                		&& 	tmp.get(Calendar.DATE) == dTravel.get(Calendar.DATE) 
                		&& 	tmp.get(Calendar.HOUR_OF_DAY) <= dTravel.get(Calendar.HOUR_OF_DAY)) {
                    listTravels.add(t);
                }
            }
        }
        return listTravels;
    }
	
	// --------------------------------------------- PARTIE FACEBOOK ----------------------------------------
    public double getDistanceWith(Member m) {
        return this.m_address.distanceWith(m.getAddress());
    }
    public Member getNearestMemberByFormation() {
    	double distanceMin = Integer.MAX_VALUE;
        Member neighbour = null;
        for (Member m : this.m_formation.getListMembers()) {
            if (this.getDistanceWith(m) < distanceMin && !this.equals(m)) {
                neighbour = m;
                distanceMin = this.getDistanceWith(m);
            }
        }
        return neighbour;
    }
    public ArrayList<Member> getNearestMembersByFormation(double distance) {
        ArrayList<Member> neighbour = new ArrayList<Member>();
        for (Member m : this.m_formation.getListMembers()) {
            if (this.getDistanceWith(m) < distance) {
                neighbour.add(m);
            }
        }
        return neighbour;
    }
    	
	// --------------------------------------------- PARTIE INTEREST ----------------------------------------
	public void setInterestPoint(String name) {
        List<InterestPoint> instancesInterestPoint = InterestPoint.getInstances();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateInterestPoint = "00/00/0000";
        Date date = null;

        try {
            date = dateFormat.parse(dateInterestPoint);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (InterestPoint point : instancesInterestPoint) {
            if (point.getName().equals(name)){
                this.m_interestPoints.put(name, date);
            }
        }
    }
	public void setInterestPointByDate(String name, String interestPointDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = dateFormat.parse(interestPointDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.m_interestPoints.put(name, date);
	}
	
	
}
