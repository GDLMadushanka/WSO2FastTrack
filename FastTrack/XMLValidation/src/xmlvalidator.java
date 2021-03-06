import jdk.internal.org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

/**
 * Created by lahiru on 4/19/17.
 */
public class xmlvalidator {
    public static void main(String[] args)   {


       // System.out.println("EmployeeRequest.xml validates against Employee.xsd? "+validateXMLSchema("Employee.xsd", "employeeRequest.xml"));
      //  System.out.println("EmployeeResponse.xml validates against Employee.xsd? "+validateXMLSchema("Employee.xsd", "employeeResponse.xml"));
        System.out.println("employee.xml validates against Employee.xsd? "+validateXMLSchema("Employee.xsd", "employee.xml"));

    }

    public static boolean validateXMLSchema(String xsdPath, String xmlPath) {

        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
        } catch (IOException | org.xml.sax.SAXException e) {
            System.out.println("Exception: "+e.getMessage());
            return false;
        }
        return true;
    }
}
