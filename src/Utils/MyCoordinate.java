package Utils;

import java.awt.geom.Point2D;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import fr.unice.iut.info.methodo.maps.Coordinate;

//Classe utilisée pouvant être sérialisée au lieu de la classe Coordinate d'OSM non sérialisable.

public class MyCoordinate implements Serializable {

	private static final long serialVersionUID = 5870501795967031875L;
	private transient Point2D.Double data;

    public MyCoordinate(double lat, double lon) {
        data = new Point2D.Double(lon, lat);
    }

    public double getLat() {
        return data.y;
    }

    public void setLat(double lat) {
        data.y = lat;
    }

    public double getLon() {
        return data.x;
    }

    public void setLon(double lon) {
        data.x = lon;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(data.x);
        out.writeObject(data.y);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        data = new Point2D.Double();
        data.x = (Double) in.readObject();
        data.y = (Double) in.readObject();
    }
    
    public Coordinate toOSMCoordinate() { return new Coordinate(getLat(),getLon()); }

    public String toString() {
        return "Coordinate[" + data.y + ", " + data.x + "]";
    }
}
