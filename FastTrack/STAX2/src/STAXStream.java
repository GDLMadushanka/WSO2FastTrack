import javax.xml.stream.*;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by lahiru on 4/19/17.
 */
public class STAXStream {

    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        STAXStream stax = new STAXStream();
        System.out.println(stax.processXMLFile("Staff.XML"));
    }

    public StringBuffer processXMLFile(String XMLfile) throws FileNotFoundException, XMLStreamException {
        XMLStreamReader xmlStreamReader = XMLInputFactory.newInstance().createXMLStreamReader(new FileInputStream(XMLfile));
        StringBuffer rawXML = new StringBuffer();
        while (xmlStreamReader.hasNext()){
            switch (xmlStreamReader.next()){
                case XMLStreamConstants.START_ELEMENT:
                    rawXML.append("<"+xmlStreamReader.getLocalName()+">");break;
                case XMLStreamConstants.CHARACTERS:
                    if(!xmlStreamReader.isWhiteSpace()){rawXML.append(xmlStreamReader.getText());}break;
                case XMLStreamConstants.END_ELEMENT:
                    rawXML.append("</"+xmlStreamReader.getLocalName()+">");break;
            }
        }
        return rawXML;
    }
}
