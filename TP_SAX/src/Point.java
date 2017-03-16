
public class Point {

	private double latA;
	private double longA;
	private int altitude;

	public Point() {
	}

	public double getLat() {
		return this.latA;
	}

	public double getLong() {
		return this.longA;
	}

	public void setAltitude(int alt) {
		this.altitude = alt;
	}

	public int getAltitude() {
		return this.altitude;
	}

	public void setLat(Double lat) {
		this.latA=lat;
	}

	public void setLong(Double lon) {
		this.longA = lon;
	}


}
