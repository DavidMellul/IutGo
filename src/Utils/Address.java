package Utils;

import java.io.Serializable;
import java.util.ArrayList;

import Member.Member;
import fr.unice.iut.info.methodo.maps.Coordinate;

public class Address implements Serializable{

    private Coordinate m_coordinateGps;
    private Member m_member;
    private Formation m_formation;
    private ArrayList<Member> listAddress= new ArrayList<Member>();

    public Address(Member member, Coordinate coordinateGps) {
        this.m_member = member;
        this.m_coordinateGps = coordinateGps;
        this.m_formation = new Formation();

    }

    public Address() {
        this.m_member=null;
        this.m_coordinateGps=null;
    }

    public  double distanceWith ( Address adress2) {
        Coordinate c1 = this.m_coordinateGps;
        Coordinate c2 = adress2.getCoordinateGps();
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


    public Coordinate getCoordinateGps() {
        return m_coordinateGps;
    }

    public void setCoordinateGps(Coordinate coordinateGps) {
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
}