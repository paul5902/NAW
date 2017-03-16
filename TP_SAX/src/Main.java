import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Main {
	
	public static void main(String[] args) {
		
		try {
	         SAXParserFactory factory = SAXParserFactory.newInstance();
	         SAXParser parser = factory.newSAXParser();
	         
	         parser.parse("houlgate.gpx", new CustomHandler());

	      } catch (DOMException e) {
	         e.printStackTrace();
	      } catch (ParserConfigurationException e) {
	         e.printStackTrace();
	      } catch (TransformerFactoryConfigurationError e) {
	         e.printStackTrace();
	      } catch (SAXException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	}

}
