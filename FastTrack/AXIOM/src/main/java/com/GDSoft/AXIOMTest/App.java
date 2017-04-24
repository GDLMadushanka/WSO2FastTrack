package com.GDSoft.AXIOMTest;

import org.apache.axiom.om.*;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args )
    {


        File file = new File("sample.xml");
        App app = new App();
        try {
            app.processFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void processFile(File file) throws  OMException, IOException {
        // Create a builder for the file and get the root element
        InputStream in = new FileInputStream(file);
        OMElement root = OMXMLBuilderFactory.createOMBuilder(in).getDocumentElement();

        // Process the content of the file
        OMElement urlElement = root.getFirstChildWithName(
                new QName("http://www.axiom.org/article/oxygentank", "Employee"));

        urlElement = urlElement.getFirstChildWithName(
                new QName("http://www.axiom.org/article/oxygentank", "Name"));

        Iterator it =  urlElement.getChildElements();
        while(it.hasNext()){
            System.out.println("r");
        }

        if (urlElement == null) {
            System.out.println("No <url> element found");
        } else {
            System.out.println("url = " + urlElement.getText());
        }

        // Because Axiom uses deferred parsing, the stream must be closed AFTER
        // processing the document (unless OMElement#build() is called)
        in.close();
    }
}
