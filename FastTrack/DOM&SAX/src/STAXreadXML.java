import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

import static javax.xml.transform.OutputKeys.*;

/**
 * Created by lahiru on 4/19/17.
 */
public class STAXreadXML {

    //Using Event reader
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException, TransformerException {
        STAXreadXML stax = new STAXreadXML();
        String temp = stax.processXMLFile("Staff.XML").toString();
        System.out.println(stax.transformXML(4,temp));
    }

    public static String transformXML(int indentation, String rawXml) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        transformerFactory.setAttribute("indent-number",indentation);
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT,"yes");
        StreamResult streamResult = new StreamResult(new StringWriter());
        transformer.transform(new StreamSource(new StringReader(rawXml)),streamResult);
        return streamResult.getWriter().toString();
    }

    public StringBuffer processXMLFile(String XMLfile) throws FileNotFoundException, XMLStreamException {
        XMLEvent xmlEvent = null;
        StringBuffer rawXML = new StringBuffer();
        Characters characters =null;
        XMLEventReader xmlEventReader = XMLInputFactory.newInstance().createXMLEventReader(new FileInputStream(XMLfile));
        while (xmlEventReader.hasNext()){
            xmlEvent = xmlEventReader.nextEvent();
            switch (xmlEvent.getEventType()){
                case XMLStreamConstants.START_ELEMENT:
                    rawXML.append("<"+(((StartElement)xmlEvent).getName()).getLocalPart()+">");break;
                case XMLStreamConstants.CHARACTERS:
                    characters = (Characters)xmlEvent;
                    if(!(characters.isWhiteSpace()||characters.isIgnorableWhiteSpace())){rawXML.append(characters.getData());}break;
                case XMLStreamConstants.END_ELEMENT:
                    rawXML.append("</"+(((EndElement)xmlEvent).getName()).getLocalPart()+">");break;
            }
        }
        return rawXML;
    }
}
