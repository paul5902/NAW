import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class ParserDom {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); 
		  dbf.setCoalescing(false);
		  dbf.setIgnoringElementContentWhitespace(true); 
		  dbf.setValidating(true);
		  DocumentBuilder db = dbf.newDocumentBuilder(); 
		  Document document = db.parse(new File("expbis.xml"));
	}

}
