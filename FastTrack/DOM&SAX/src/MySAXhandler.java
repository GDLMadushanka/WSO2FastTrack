import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by lahiru on 4/19/17.
 */
public class MySAXhandler extends DefaultHandler {
    public void startDocument(){
        System.out.println("document begins here");
    }
    public void startElement(String uri,String localName, String qName,Attributes attrs){
        System.out.println("<"+qName+"> ");
    }

    public void characters(char ch[],int start,int len){
        System.out.println("character "+new String(ch,start,len));
    }

    public void endElement(String uri,String localName, String qName){
        System.out.println("</"+qName+">");
    }

    public void endDocument(){
        System.out.println("Document end here");
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParser saxp = SAXParserFactory.newInstance().newSAXParser();
        saxp.parse(new FileInputStream("Staff.XML"),new MySAXhandler());
    }
}
