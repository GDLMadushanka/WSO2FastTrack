import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.lang.instrument.Instrumentation;

/**
 * Created by lahiru on 4/19/17.
 */

public class ReadFromXML {
    private static final long MEGABYTE = 1024L * 1024L;
    public static long bytesToMegabytes(long bytes) {
        return bytes / MEGABYTE;
    }

    public static void main(String[] args) throws Exception {
        File xmlfile = new File("Staff.XML");
        DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBulder = dbfactory.newDocumentBuilder();
        Document doc = docBulder.parse(xmlfile);
        Runtime runtime = Runtime.getRuntime();
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory is bytes: " + memory);
        System.out.println("Used memory is megabytes: " + bytesToMegabytes(memory));

        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
        NodeList nlist = doc.getElementsByTagName("staff");
        System.out.println("---------------");
        for (int i = 0; i < nlist.getLength(); i++) {
            Node nNode = nlist.item(i);
            System.out.println(nNode.getNodeName());
            if(nNode.getNodeType()==Node.ELEMENT_NODE){
                Element ele = (Element)nNode;
                System.out.println("id "+ele.getAttribute("id"));
                System.out.println("firstname "+ele.getElementsByTagName("firstname").item(0).getTextContent());
                System.out.println("lastname "+ele.getElementsByTagName("lastname").item(0).getTextContent());
                System.out.println("salary "+ele.getElementsByTagName("salary").item(0).getTextContent());

            }
        }
    }
}
