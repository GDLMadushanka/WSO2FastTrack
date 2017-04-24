import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.ByteArrayOutputStream;

/**
 * Created by lahiru on 4/19/17.
 */
public class STAXstreamWriter {
    String[][] turorials ={{"factory","abs factory","singleton"},
            {"jms","p2p","publish/subscribe"}};

    public static void main(String[] args) throws XMLStreamException {
        STAXstreamWriter staXstreamWriter = new STAXstreamWriter();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        jdk.internal.util.xml.XMLStreamWriter xmlStreamWriter = (jdk.internal.util.xml.XMLStreamWriter) (XMLOutputFactory.newInstance()).createXMLStreamWriter(byteArrayOutputStream);
        staXstreamWriter.writeXML((XMLStreamWriter) xmlStreamWriter);
    }

    public void writeXML(XMLStreamWriter xmlStreamWriter) throws XMLStreamException {
        xmlStreamWriter.writeStartDocument("1.0");
        xmlStreamWriter.writeStartElement("channel");
        xmlStreamWriter.writeAttribute("name","Lahiru Academy");
        populateTopic(xmlStreamWriter,"Design patterns",turorials[0]);
        populateTopic(xmlStreamWriter,"Java messaging",turorials[1]);
        xmlStreamWriter.writeEndElement();
        xmlStreamWriter.writeEndDocument();
    }

    public void populateTopic(XMLStreamWriter xmlStreamWriter,String topic,String[] tutorials) throws XMLStreamException {
        xmlStreamWriter.writeStartElement(topic);
        xmlStreamWriter.writeAttribute("name",topic);
        int i=0;
        while (i<tutorials.length){
            xmlStreamWriter.writeStartElement("tutorial");
            xmlStreamWriter.writeCharacters(tutorials[i++]);
            xmlStreamWriter.writeEndElement();
        }
        xmlStreamWriter.writeEndElement();
    }
}
