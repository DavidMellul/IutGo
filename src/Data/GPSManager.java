package Data;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;

import Member.Member;
import Utils.GPSData;
import Utils.MyCoordinate;

public class GPSManager implements Serializable {
	private static final long serialVersionUID = -3892867060303029823L;

	public GPSManager() { }
	
	 public GPSData getLastPosition(Member p_member)
	    {
	        @SuppressWarnings("deprecation")
			Date lastDate = new Date(0,0,0,0,0,0);
	        GPSData dataKept = new GPSData(new MyCoordinate(0,0), lastDate);

	        for(GPSData gdata : p_member.getGPSData())
	        {
	            if (gdata.getDate().getTime() > lastDate.getTime())
	            {
	                lastDate = gdata.getDate();
	                dataKept = gdata;
	            }
	        }
	        return dataKept;
	    }

	    public GPSData getPosition(Member p_member, Date p_date)
	    {
	        long differenceDate = 0;
	        long maxDateDifference = 0;
	        @SuppressWarnings("deprecation")
			GPSData dataKept = new GPSData(new MyCoordinate(0,0), new Date(0,0,0,0,0,0));

	        for(GPSData gdata : p_member.getGPSData())
	        {
	            differenceDate = p_date.getTime() - gdata.getDate().getTime();

	            if (differenceDate >= 0)
	            {
	                if (maxDateDifference >= differenceDate)
	                {
	                    maxDateDifference = differenceDate;
	                    dataKept = gdata;
	                }
	            }
	        }
	        return dataKept;
	    }

	    public ArrayList<GPSData> getPath(Member p_member, Date p_date1, Date p_date2)
	    {
	        ArrayList<GPSData> memberPath = new ArrayList<GPSData>();

	        for(GPSData gdata : p_member.getGPSData())
	        {
	            if(gdata.getDate().getTime() >= p_date1.getTime() && gdata.getDate().getTime() <= p_date2.getTime())
	            {
	                memberPath.add(gdata);
	            }
	        }

	        Collections.sort(memberPath, new Comparator<GPSData>() {
	            public int compare(GPSData o1, GPSData o2) {
	                return o1.compareTo(o2);
	            }
	        });
	        return memberPath;
	    }

	    public Object[] getFrequentPosition(Member p_member, int p_day)
	    {
	        HashMap<String, ArrayList<GPSData>> hashmap = new HashMap<String, ArrayList<GPSData>>();

	        Calendar calendar = Calendar.getInstance();
	        try {
	            for(GPSData data : p_member.getGPSData()){
	                calendar.setTime(data.getDate());
	                if(calendar.get(Calendar.DAY_OF_WEEK) == p_day)
	                {
	                    String s = data.toLocation(18);
	                    if(s != null){
	                        if(!hashmap.containsKey(s)){
	                            hashmap.put(s, new ArrayList<GPSData>());
	                        }
	                        hashmap.get(s).add(data);
	                    }
	                }
	            }
	        }
	        catch (Exception e){
	            e.printStackTrace();
	        }

	        if(hashmap.size() == 0){
	            return new Object[]{"No positions found this day of week", 100f};
	        }

	        int max = 0;
	        int sum =  0;
	        ArrayList<GPSData> list = null;
	        for(ArrayList<GPSData> d : hashmap.values()){
	            int l = d.size();
	            if(max < l){
	                list = d;
	            }
	            sum+=l;
	        }
	        return new Object[]{list.get(0).toLocation(18), (float)list.size()/(float)sum*100};
	    }

	    public ArrayList<Member> getSurroundingMembers(Member p_member, double p_radius)
	    {
	        ArrayList<Member> list = SerialManager.getAllMembers();
	        list.remove(p_member);

	        MyCoordinate p_coordinate = p_member.getLastPosition().getMyCoordinate();

	        double x1 = 6371 * Math.cos(p_coordinate.getLat()) * Math.cos(p_coordinate.getLon());
	        double y1 = 6371 * Math.cos(p_coordinate.getLat()) * Math.sin(p_coordinate.getLon());

	        Iterator<Member> it = list.iterator();
	        while(it.hasNext())
	        {
	            Member m = it.next();
	            double x2 = 6371 * Math.cos(m.getLastPosition().getMyCoordinate().getLat()) * Math.cos(m.getLastPosition().getMyCoordinate().getLon());
	            double y2 = 6371 * Math.cos(m.getLastPosition().getMyCoordinate().getLat()) * Math.sin(m.getLastPosition().getMyCoordinate().getLon());
	            double d = Math.sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1));

	            if(Math.abs(d) > p_radius)
	                it.remove();
	        }
	        return list;
	    }

	    public GPSData getCurrentPosition()
	    {	
	    	LookupService ls = null;
	    	URL whatismyip = null;
	    	BufferedReader in = null;
	    	String ip = null;
	    	Location location = null;
	    	
			try {
				whatismyip = new URL("http://checkip.amazonaws.com");
				in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
				ip = in.readLine();
				ls = new LookupService(getClass().getResource("../Resources/datagps.dat").getPath(),LookupService.GEOIP_MEMORY_CACHE | LookupService.GEOIP_CHECK_CACHE);
				location = ls.getLocation(ip);
			} catch (Exception e1) {
				e1.printStackTrace();
			}

	        double lat = location.latitude;
	        double lon = location.longitude;
	        Date d = new Date();
	        return new GPSData(new MyCoordinate(lat, lon), d);
	    }
}
