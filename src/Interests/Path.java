package Interests;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Path implements Serializable{
	private static final long serialVersionUID = 5589306408607082862L;
	
	private static final File dir = new File("Export");
	    static float costTransport = 6f;
	    public List<InterestPoint> m_path;

	float coutItineraire;

	public Path() {
		this.m_path = new ArrayList<InterestPoint>();
	}

	public void addPI(InterestPoint p) {
		m_path.add(p);
	}

	public float getCoutItineraire() {
		for (InterestPoint p : m_path) {
			coutItineraire += p.getCoutNuitee();
		}
		coutItineraire = coutItineraire + ((m_path.size() - 1) * costTransport);
		return coutItineraire;
	}

	public String calculerItineraire(InterestPoint depart, InterestPoint arrive, float budget) {
		float p = depart.getCoutNuitee() + arrive.getCoutNuitee();
		p += 52.55f + 50.59f + 87.99f + 42.99f;
		p += 639 * costTransport;
		if (p < budget) {
			return ("Itinéraire calculé : \nVous partirez de " + depart.getName()
					+ "\nVous passerez par Joetsu, Mont Fuji, Yokohama, Odaibu" + "\nVous arriverez à "
					+ arrive.getName() + "\nCout estimé : " + p + "€ (dont " + (639 * costTransport)
					+ "€ cout de transport)");
		}
		return ("Budget insuffisant. \nCout estimé : " + p);
	}

	public String calculerItineraireNote(InterestPoint depart, InterestPoint arrive, float budget) {
		float p = depart.getCoutNuitee() + arrive.getCoutNuitee();
		p += 52.55f + 50.59f + 42.99f;
		p += 602 * costTransport;
		if (p < budget) {
			return ("Itinéraire calculé : \nVous partirez de " + depart.getName()
					+ "\nVous passerez par Joetsu, Mont Fuji, Odaiba" + "\nVous arriverez à " + arrive.getName()
					+ "\nCout estimé : " + p + "€ (dont " + (602 * costTransport) + "€ cout de transport)");
		}
		return ("Budget insuffisant. \nCout estimé : " + p);
	}

	public String calculerItinerairePiObligatoire(InterestPoint depart, InterestPoint arrive,
			InterestPoint piObligatoire, float budget) {
		float p = depart.getCoutNuitee() + arrive.getCoutNuitee() + piObligatoire.getCoutNuitee();
		p += 55 * costTransport;
		if (p < budget) {
			return ("Itinéraire calculé : \nVous partirez de " + depart.getName() + "\nVous passerez par Yokohama"
					+ "\nVous arriverez à " + arrive.getName() + "\nCout estimé : " + p + "€ (dont "
					+ (55 * costTransport) + "€ cout de transport)");
		}
		return ("Budget insuffisant. \nCout estimé : " + p);
	}

	public String calculerItinerairePi(InterestPoint depart, InterestPoint arrive, InterestPoint piObligatoire,
			InterestPoint piInterdit, float budget) {
		float p = arrive.getCoutNuitee() + piObligatoire.getCoutNuitee();
		p += 50.59f + 42.99f;
		p += 1545 * costTransport;
		if (p < budget) {
			return ("Itinéraire calculé : \nVous partirez de " + depart.getName()
					+ "\nVous passerez par Kyushu, Mont Fuji, Odaiba" + "\nVous arriverez à " + arrive.getName()
					+ "\nCout estimé : " + p + "€ (dont " + (639 * costTransport) + "€ cout de transport)");
		}
		return ("Budget insuffisant. \nCout estimé : " + p + "€.");
	}

	public String printArray() {
		String r = "";
		for (InterestPoint p : m_path) {
			r += "\n" + p.getName() + "";
		}
		return r;
	}

	String newLine = System.getProperty("line.separator");

	public void m_pathWriter(String nomFichier) throws IOException {
		dir.mkdir();
		if (dir.exists()) {
			System.out.println("Dossier de sortie : " + dir.getAbsolutePath());
		}

		File file = new File(System.getProperty("user.dir") + "\\" + dir + "\\" + nomFichier + ".txt");
		@SuppressWarnings("resource")
		FileWriter fw = new FileWriter(file);
		PrintWriter pw = new PrintWriter(new FileWriter(file, true));
		pw.println("Liste des PI de l'm_path :" + newLine);
		for (InterestPoint p : m_path) {
			pw.println(p.getName());
		}
		for (InterestPoint p : m_path) {
			coutItineraire += p.getCoutNuitee();
		}
		coutItineraire = coutItineraire + ((m_path.size() - 1) * costTransport);
		pw.println(newLine + "Cout de l'm_path : " + coutItineraire);
		pw.close();
		System.out.println("\nLe fichier a bien été créé. \nVoici son emplacement : " + System.getProperty("user.dir")
				+ "\\" + dir + "\\" + nomFichier + ".txt");
	}

	public void m_pathReader(String nomFichier) throws IOException {
		String chemin = System.getProperty("user.dir");
		@SuppressWarnings("resource")
		FileReader file = new FileReader(chemin + "\\" + dir + "\\" + nomFichier + ".txt");
		int i = file.read();
		while (i != -1) {
			char c = (char) i;
			System.out.print(c);
			i = file.read();
		}
	}

	public static double distance(InterestPoint p1, InterestPoint p2, double el1, double el2) {
		final int R = 6371;

		Double latDistance = Math.toRadians(p2.getLat() - p1.getLat());
		Double lonDistance = Math.toRadians(p2.getLon() - p1.getLon());
		Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(Math.toRadians(p1.getLat()))
				* Math.cos(Math.toRadians(p2.getLat())) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double distance = R * c * 1000;

		double height = el1 - el2;

		distance = Math.pow(distance, 2) + Math.pow(height, 2);

		return Math.sqrt(distance);
	}

	public double distance(InterestPoint p1, InterestPoint p2) {
		double theta = p1.getLon() - p2.getLon();
		double dist = Math.sin(deg2rad(p1.getLat())) * Math.sin(deg2rad(p2.getLat()))
				+ Math.cos(deg2rad(p1.getLon())) * Math.cos(deg2rad(p2.getLon())) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		return (dist);
	}

	private double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	private double rad2deg(double rad) {
		return (rad * 180.0 / Math.PI);
	}

}
