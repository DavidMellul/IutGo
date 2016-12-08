package Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

import Member.Member;
import Utils.GPSData;
import fr.unice.iut.info.methodo.maps.Coordinate;

public class GPSManager implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3892867060303029823L;

	public GPSManager() {
	}

	public GPSData getLastPosition(Member p_member) {
		@SuppressWarnings("deprecation")
		Date lastDate = new Date(0, 0, 0, 0, 0, 0);
		GPSData dataKept = new GPSData(new Coordinate(0, 0), lastDate);

		for (GPSData gdata : p_member.getGPSData()) {
			if (gdata.getDate().getTime() > lastDate.getTime()) {
				lastDate = gdata.getDate();
				dataKept = gdata;
			}
		}
		return dataKept;
	}

	public GPSData getPosition(Member p_member, Date p_date) {
		long differenceDate = 0;
		long maxDateDifference = 0;
		@SuppressWarnings("deprecation")
		GPSData dataKept = new GPSData(new Coordinate(0, 0), new Date(0, 0, 0, 0, 0, 0));

		for (GPSData gdata : p_member.getGPSData()) {
			differenceDate = p_date.getTime() - gdata.getDate().getTime();

			if (differenceDate >= 0) {
				if (maxDateDifference >= differenceDate) {
					maxDateDifference = differenceDate;
					dataKept = gdata;
				}
			}
		}
		return dataKept;
	}

	public ArrayList<GPSData> getPath(Member p_member, Date p_date1, Date p_date2) {
		ArrayList<GPSData> memberPath = new ArrayList<GPSData>();

		for (GPSData gdata : p_member.getGPSData()) {
			if (gdata.getDate().getTime() >= p_date1.getTime() && gdata.getDate().getTime() <= p_date2.getTime()) {
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

	public Object[] getFrequentPosition(Member p_member, int p_day) {
		HashMap<String, ArrayList<GPSData>> hashmap = new HashMap<String, ArrayList<GPSData>>();

		Calendar calendar = Calendar.getInstance();
		try {
			for (GPSData data : p_member.getGPSData()) {
				calendar.setTime(data.getDate());
				if (calendar.get(Calendar.DAY_OF_WEEK) == p_day) {
					String s = data.toLocation(18);
					if (s != null) {
						if (!hashmap.containsKey(s)) {
							hashmap.put(s, new ArrayList<GPSData>());
						}
						hashmap.get(s).add(data);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (hashmap.size() == 0) {
			return new Object[] { "No positions found this day of week", 100f };
		}

		int max = 0;
		int sum = 0;
		ArrayList<GPSData> list = null;
		for (ArrayList<GPSData> d : hashmap.values()) {
			int l = d.size();
			if (max < l) {
				list = d;
			}
			sum += l;
		}
		return new Object[] { list.get(0).toLocation(18), (float) list.size() / (float) sum * 100 };
	}

	public ArrayList<Member> getSurroundingMembers(Member p_member, double p_radius) {
		ArrayList<Member> list = SerialManager.getAllMembers();
		list.remove(p_member);

		Coordinate p_coordinate = p_member.getLastPosition().getCoordinate();

		double x1 = 6371 * Math.cos(p_coordinate.getLat()) * Math.cos(p_coordinate.getLon());
		double y1 = 6371 * Math.cos(p_coordinate.getLat()) * Math.sin(p_coordinate.getLon());

		Iterator<Member> it = list.iterator();
		while (it.hasNext()) {
			Member m = it.next();
			double x2 = 6371 * Math.cos(m.getLastPosition().getCoordinate().getLat())
					* Math.cos(m.getLastPosition().getCoordinate().getLon());
			double y2 = 6371 * Math.cos(m.getLastPosition().getCoordinate().getLat())
					* Math.sin(m.getLastPosition().getCoordinate().getLon());
			double d = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));

			if (Math.abs(d) > p_radius)
				it.remove();
		}
		return list;
	}

	public GPSData getCurrentPosition() {
		double lat = randomInRange(-90, 90);
		double lon = randomInRange(-180, 180);
		Date d = new Date(getRandomTimeBetweenTwoDates());
		return new GPSData(new Coordinate(lat, lon), d);
	}

	public double randomInRange(double min, double max) {
		Random r = new Random();
		double range = max - min;
		double scaled = r.nextDouble() * range;
		double shifted = scaled + min;
		return shifted;
	}

	public long getRandomTimeBetweenTwoDates() {
		long beginTime = Timestamp.valueOf("2016-01-01 00:00:00").getTime();
		long endTime = Timestamp.valueOf("2018-01-01 00:59:59").getTime();
		long diff = endTime - beginTime + 1;
		return beginTime + (long) (Math.random() * diff);
	}
}
