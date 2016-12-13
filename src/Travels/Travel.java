package Travels;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import Member.Member;
import Utils.MyCoordinate;

public class Travel implements Serializable{
	
	private static final long serialVersionUID = -2171317894391516495L;
	
	private Calendar m_date;
    private Member m_driver;
    private ArrayList<Member> m_passengersList;
    private MyCoordinate m_coord;
    private String m_start;
    private String m_end;
    private int m_seats;


    public Travel(Calendar date, Member driver,int seats, MyCoordinate coord, String cStart, String cEnd){
        this.m_driver = driver;
        this.m_seats = seats;
        this.m_passengersList = new ArrayList<Member>();
        this.m_start = cStart;
        this.m_end = cEnd;
        this.m_coord = coord;
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
    
    public MyCoordinate getCoord(){
    	return m_coord;
    }


    public String getStart(){
        return this.m_start;
    }

 
    public String getEnd(){
        return this.m_end;
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
                ", coordinateStart=" + m_start +
                ", coordinateEnd=" + m_end +
                ", seats=" + m_seats +
                '}';
    }
}
