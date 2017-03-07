
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ExprEvaluateur {
	public static double evaluate(Node n, Map<String, Double> map) {

		double a, b;

		if (n.getNodeName().equals("op")) {

			if (n.getAttributes().getNamedItem("symbole").getNodeValue().equals("mult")) {
				a = evaluate(n.getFirstChild(), map);
				b = evaluate(n.getFirstChild().getNextSibling(), map);
				return a * b;
			} else if (n.getAttributes().getNamedItem("symbole").getNodeValue().equals("plus")) {
				a = evaluate(n.getFirstChild(), map);
				b = evaluate(n.getFirstChild().getNextSibling(), map);
				return a + b;
			} else if (n.getAttributes().getNamedItem("symbole").getNodeValue().equals("moins")) {
				a = evaluate(n.getFirstChild(), map);
				b = evaluate(n.getFirstChild().getNextSibling(), map);
				return a - b;
			} else if (n.getAttributes().getNamedItem("symbole").getNodeValue().equals("div")) {
				a = evaluate(n.getFirstChild(), map);
				b = evaluate(n.getFirstChild().getNextSibling(), map);
				return a / b;
			}
		} else if (n.getNodeName().equals("var")) {
			String var1 = n.getAttributes().getNamedItem("nom").getNodeValue();
			if (map.containsKey(var1)) {
				return map.get(var1);
			}
		}
		return 0;

	}

	public static Map<String, Double> getConstantes(Document d) {
		Map<String, Double> constantes = new HashMap<String, Double>();
		Element cst = (Element) d.getDocumentElement().getFirstChild();
		NodeList n = cst.getChildNodes();

		for (int i = 0; i < n.getLength(); i++) {
			NamedNodeMap nnm = n.item(i).getAttributes();
			String value = nnm.getNamedItem("valeur").getNodeValue();
			Double val = Double.parseDouble(value);
			constantes.put(nnm.getNamedItem("nom").getNodeValue(), val);

		}
		return constantes;

	}

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setCoalescing(false);
		dbf.setIgnoringElementContentWhitespace(true);
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse(new File("expMath.xml"));
		Element exp = (Element) document.getDocumentElement().getFirstChild().getNextSibling().getFirstChild()
				.getFirstChild();
		Double e = evaluate(exp, getConstantes(document));
		System.out.println(e);
	}

}
