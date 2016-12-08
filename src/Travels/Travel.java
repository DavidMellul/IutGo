package Travels;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import Member.Member;
import fr.unice.iut.info.methodo.maps.Coordinate;

public class Travel implements Serializable{
	
	private static final long serialVersionUID = -2171317894391516495L;
	
	private Calendar m_date;
    private Member m_driver;
    private ArrayList<Member> m_passengersList;
    private Coordinate m_coordinateStart;
    private Coordinate m_coordinateEnd;
    private int m_seats;


    public Travel(Calendar date, Member driver,int seats, Coordinate cStart, Coordinate cEnd){
        this.m_driver = driver;
        this.m_seats = seats;
        this.m_passengersList = new ArrayList<Member>();
        this.m_coordinateStart = cStart;
        this.m_coordinateEnd = cEnd;
        this.m_driver.addTravel(this);
    }

    public Calendar getDate(){
        return this.m_date;
    }

    public Member getDriver(){
        return this.m_driver;
    }
 
    public ArrayList<Member> getPassengersList(){
        return this.m_passengersList;
    }

    public int getSeats(){
        return this.m_seats;
    }


    public Coordinate getCoordinateStart(){
        return this.m_coordinateStart;
    }

 
    public Coordinate getCoordinateEnd(){
        return this.m_coordinateEnd;
    }

    public boolean addPasenger(Member passenger){
        if(this.m_seats > 0 && !isAlreadyHere(passenger)) {
            if(passenger.addTravel(this)) {
                this.m_passengersList.add(passenger);
                this.m_seats -= 1;
                return true;
            }
        }
        return false;
    }

    private boolean isAlreadyHere(Member m){
        if(m.getId() == this.m_driver.getId())
            return  true;
        return this.m_passengersList.contains(m);
    }

    @Override
    public String toString() {
        return "Travel{" +
                "date=" + m_date +
                ", driver=" + m_driver +
                ", passengersList=" + m_passengersList +
                ", coordinateStart=" + m_coordinateStart +
                ", coordinateEnd=" + m_coordinateEnd +
                ", seats=" + m_seats +
                '}';
    }
}
