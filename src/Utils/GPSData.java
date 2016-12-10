package Utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Utils.Coordinate;

public class GPSData implements Comparable<Object>, Serializable {
	private static final long serialVersionUID = 1710036580140276926L;
	private Coordinate m_coordinate;
    private Date m_date;
    private String m_location = null;

    public GPSData(Coordinate p_coordinate, Date p_date)
    {
        m_coordinate = p_coordinate;
        m_date = p_date;
    }

    public Date getDate()
    {
        return this.m_date;
    }

    public Coordinate getCoordinate()
    {
        return this.m_coordinate;
    }

    public int compareTo(Object o)
    {
        GPSData gData = (GPSData)(o);
        return m_date.compareTo( gData.getDate() );
    }

    public String toLocation(int zoom){
        if(m_location != null) return m_location;

        String name = null;
        try {
            URL web = new URL("http://nominatim.openstreetmap.org/reverse?format=json&lat=" + m_coordinate.getLat() + "&lon=" + m_coordinate.getLon() + "&zoom=" + zoom +"&addressdetails=0");

            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(web.openStream()));
                String inputLine = in.readLine();
                if(inputLine != null){
                    if(!inputLine.contains("error")){
                        JSONObject jsonObject = (JSONObject)new JSONParser().parse(inputLine);
                        name = (String)jsonObject.get("display_name");
                    }
                }
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return (m_location = (name == null)?"Unknown location ["+ m_coordinate.getLat() + ";"+ m_coordinate.getLon() +"]":name);
    }

    public String toString()
    {
        return this.getCoordinate()+" le "+new SimpleDateFormat("dd/MM/YYYY").format(this.getDate());
    }
}
