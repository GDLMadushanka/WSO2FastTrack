import org.w3c.dom.Text;

import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by lahiru on 4/19/17.
 */
public class DocumentGenerator {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBulder = docFactory.newDocumentBuilder();
        org.w3c.dom.Document doc = docBulder.newDocument();

        org.w3c.dom.Element rootele = doc.createElement("Students");
        org.w3c.dom.Element studentele = doc.createElement("Student");
        org.w3c.dom.Element nameele = doc.createElement("Name");
        org.w3c.dom.Element emailele = doc.createElement("email");
        org.w3c.dom.Element mobileele = doc.createElement("mobile");

        Text t1 = doc.createTextNode("Lahiru");
        Text t2 = doc.createTextNode("lahiru@gmail");
        Text t3 = doc.createTextNode("789567");

        nameele.appendChild(t1);
        emailele.appendChild(t2);
        mobileele.appendChild(t3);

        studentele.appendChild(nameele);
        studentele.appendChild(emailele);
        studentele.appendChild(mobileele);

        rootele.appendChild(studentele);
        doc.appendChild(rootele);
        Transformer trans = TransformerFactory.newInstance().newTransformer();
        trans.transform(new DOMSource(doc),new StreamResult(new FileOutputStream("out.xml")));
        System.out.println("XML generated");

    }


}
