import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class AddConstanteX {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setCoalescing(false);
		dbf.setIgnoringElementContentWhitespace(true);
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse(new File("expbis.xml"));
		Element constantes = (Element) document.getDocumentElement().getFirstChild();
		Element constd = document.createElement("const") ; 
		constd.setAttribute("nom", "X"); 
		constd.setAttribute("valeur","50");
		constantes.appendChild(constd);
		XMLTOOLS1.ecrireXML(document, "expbis.xml", "expMath.dtd");  
	}
}
