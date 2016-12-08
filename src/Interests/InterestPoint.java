package Interests;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.unice.iut.info.methodo.maps.Coordinate;

public class InterestPoint implements Serializable{
	private static final long serialVersionUID = 5837365909344441417L;

	private static ArrayList<InterestPoint> instances = new ArrayList<InterestPoint>();

	private String m_name = null;
	private String m_description = null;
	private Coordinate m_coordinate;
	private List<Lodging> lodgings = new ArrayList<Lodging>();
	private List<Integer> m_note = new ArrayList<Integer>();

	public InterestPoint(String n) {
		setNom(n);
		instances.add(this);
	}

	public InterestPoint(String n, String d) {
		this(n);
		setDescription(d);
	}

	public InterestPoint(String n, String d, double lat, double lon) {
		m_name = n;
		m_description = d;
		m_coordinate = new Coordinate(lat, lon);
		instances.add(this);
	}

	public InterestPoint(String n, double lat, double lon) {
		m_name = n;
		m_coordinate = new Coordinate(lat, lon);
		instances.add(this);
	}

	public static List<InterestPoint> getInstances() {
		return instances;
	}

	public String getName() {
		return this.m_name;
	}

	public String getDescription() {
		return this.m_description;
	}

	public Coordinate getCoordinate() {
		return this.m_coordinate;
	}

	public double getLat() {
		return this.m_coordinate.getLat();
	}

	public double getLon() {
		return this.m_coordinate.getLon();
	}

	public float getCoutNuitee() {
		if (lodgings.size() == 0)
			return 0;

		float prixMin = Integer.MAX_VALUE;
		for (Lodging h : lodgings) {
			if (h.getNightCost() < prixMin)
				prixMin = h.getNightCost();
		}

		return prixMin;
	}

	public float getNoteMoyenne() {
		if (this.m_note.size() == 0)
			return Integer.MAX_VALUE;

		float moy = 0;
		int j = 0;
		for (float i : this.m_note) {
			j++;
			moy += i;
		}

		return (float) (Math.round(moy / j * 2) / 2.0);
	}

	public void setNom(String n) {
		this.m_name = n;
	}

	public void setDescription(String d) {
		this.m_description = d;
	}

	public void setCoordinate(double lat, double lon) {
		this.m_coordinate.setLat(lat);
		this.m_coordinate.setLon(lon);
	}

	public void addNote(int n) {
		if (n >= 0 && n <= 5)
			this.m_note.add(n);
	}

	public void addLodgings(Lodging h) {
		if (h != null) {
			lodgings.add(h);
		}
	}

	@Override
	public String toString() {
		return "InterestPoint{" + "\n\tm_note=" + m_note + "\n\tm_name='" + m_name + '\'' + "\n\tm_description='"
				+ m_description + '\'' + "\n\tlodgings=" + lodgings + "\n\tCoordonnées m_coordinate = ("
				+ m_coordinate.getLat() + ", " + +m_coordinate.getLon() + ")" + "\n}";
	}
}
