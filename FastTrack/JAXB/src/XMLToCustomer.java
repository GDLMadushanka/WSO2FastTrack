import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by lahiru on 4/18/17.
 */
public class XMLToCustomer {
    public static void main(String[] args) {
        try {

            File file = new File("output.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Customer customer = (Customer) jaxbUnmarshaller.unmarshal(file);
            System.out.println(customer.getName() + customer.getAge());

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
