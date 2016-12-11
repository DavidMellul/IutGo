package Utils;

import java.io.Serializable;
import java.util.ArrayList;

import Member.Member;
import Utils.MyCoordinate;

public class Address implements Serializable{
	private static final long serialVersionUID = -7530102637176081952L;

	private MyCoordinate m_coordinateGps;
    private Member m_member;
    private Formation m_formation;
    private ArrayList<Member> listAddress= new ArrayList<Member>();
    private String m_name;

    public Address(Member member, MyCoordinate coordinateGps) {
        this.m_member = member;
        this.m_coordinateGps = coordinateGps;
        this.m_formation = new Formation();
        this.m_name = "undefined";
    }

    public Address() {
        this.m_member=null;
        this.m_coordinateGps=null;
        this.m_name = "undefined";
    }
    
    public Address(String name) { this.m_name = name; }

    public  double distanceWith ( Address adress2) {
        MyCoordinate c1 = this.m_coordinateGps;
        MyCoordinate c2 = adress2.getMyCoordinateGps();
        double theta = c1.getLon() - c2.getLon();

        double dist = Math.sin(deg2rad(c1.getLat())) * Math.sin(deg2rad(c2.getLat())) + Math.cos(deg2rad(c1.getLat())) * Math.cos(deg2rad(c2.getLat())) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344; 

        return (dist);
    }

    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }


    public MyCoordinate getMyCoordinateGps() {
        return m_coordinateGps;
    }

    public void setMyCoordinateGps(MyCoordinate coordinateGps) {
        this.m_coordinateGps = coordinateGps;
    }

    public Member getMember() {
        return this.m_member;
    }


    public void setMember(Member member) {
        this.m_member = member;
    }

    public ArrayList<Member> getListAddress() {
        return this.listAddress;
    }


    public void setListAddress(ArrayList<Member> listAddress) {
        this.listAddress = listAddress;
    }
  
    public void addMember(Member member){
        this.listAddress.add(member);
    }


    public Formation getFormation() {
        return this.m_formation;
    }
 
    public void setFormation(Formation formation) {
        this.m_formation = formation;
    }
    
    @Override 
    public String toString() { return this.m_name; }
}