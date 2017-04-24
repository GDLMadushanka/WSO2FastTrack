import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

/**
 * Created by lahiru on 4/18/17.
 */
public class CustomerToXml {
    public static void main(String[] args) {
        Customer cus = new Customer();
        cus.setAge(43);
        cus.setName("Lahiru");
        cus.setId(23);
        try{
           File file = new File("output.xml");
            JAXBContext jaxbcontext = JAXBContext.newInstance(Customer.class);
            Marshaller jaxbmarshellr = jaxbcontext.createMarshaller();
            jaxbmarshellr.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            jaxbmarshellr.marshal(cus,file);
            jaxbmarshellr.marshal(cus,System.out);

        }catch (JAXBException ex){
            ex.printStackTrace();
        }
    }
}
