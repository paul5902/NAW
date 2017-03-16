import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CustomHandler extends DefaultHandler {
	int nbBalises = 0;
	String tagCourant = null;
	Point pointCourant = null;
	double distanceTot = 0;
	int altMax = 0;
	int altMin = 9999;
	int compteur = 2;

	public void startElement(String nameSpace, String localName, String qName, Attributes attr) throws SAXException {
		tagCourant = qName;
		System.out.println("Début du noeud " + qName);

		if(compteur>0) {
			compteur --;
		}
		

		if (tagCourant.equals("trkpt")) {
			if(pointCourant!=null) {
				distanceTot+=distance(pointCourant.getLat(),pointCourant.getLong(),Double.parseDouble(attr.getValue(0)),Double.parseDouble(attr.getValue(1)));
			}
			nbBalises++;
			pointCourant = new Point(Double.parseDouble(attr.getValue(0)), Double.parseDouble(attr.getValue(1)));
			
		}
	}

	public void startDocument() {

		System.out.println("Start parsing");

	}

	public void endDocument() {

		System.out.println("End parsing");
		System.out.println("Nombre de points de l'itinéraire:  " + nbBalises);
		System.out.println("Distance totale:"+distanceTot);
		System.out.println("Alt mini :"+altMin+", Alt max : "+altMax);

	}

	public void endElement(String uri, String localName, String qName) {
		System.out.println("Fin de l'élément " + qName);

	}

	public void characters(char[] data, int start, int end) {
		String str = new String(data, start, end);
		if(tagCourant.equals("ele")) {
			if(Integer.parseInt(str)>altMax) {
				altMax = Integer.parseInt(str);
			}
			if(Integer.parseInt(str)<altMin) {
				altMin = Integer.parseInt(str);
			}

		}
		

	}

	public static double distance(double latA, double longA, double latB, double longB) {
		double a = Math.PI / 180;
		double lat1 = latA * a;
		double long1 = longA * a;
		double lat2 = latB * a;
		double long2 = longB * a;
		double t1 = Math.sin(lat1) * Math.sin(lat2);
		double t2 = Math.cos(lat1) * Math.cos(lat2);
		double t3 = Math.cos(long1 - long2);
		double t4 = t2 * t3;
		double t5 = t1 + t4;
		double radDist = Math.atan(-t5 / Math.sqrt(-t5 * t5 + 1)) + 2 * Math.atan(1);
		return (radDist * 3437.74677 * 1.1508) * 1.6093470878864446;
	}

}
