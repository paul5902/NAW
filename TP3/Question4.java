import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Question4 {

	public static double evaluate(Element e) {
		if (e.getTagName().equals("op")) {
			NodeList operandes = e.getChildNodes();
			double v1 = evaluate((Element) operandes.item(0));
			double v2 = evaluate((Element) operandes.item(1));
			if (e.getAttribute("symbole").equals("plus")) {
				return v1 + v2;
			}
			if (e.getAttribute("symbole").equals("moins")) {
				return v1 - v2;
			}
			if (e.getAttribute("symbole").equals("mult")) {
				return v1 * v2;
			}
			if (e.getAttribute("symbole").equals("div")) {
				return v1 / v2;
			}

		}
		return 0;
	}

}
