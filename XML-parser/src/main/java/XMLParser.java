
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class XMLParser {


    public String parseXML(String fileName) {
        List<String> softList = new ArrayList<>();
    try {
            XMLStreamReader xmlr =
                    XMLInputFactory.newInstance().createXMLStreamReader
                            (fileName, new FileInputStream(fileName));

            while (xmlr.hasNext()) {
                xmlr.next();
                if (xmlr.isStartElement()) {
                    softList.add(xmlr.getLocalName());
                } else if (xmlr.isEndElement()) {
                    softList.add("/" + xmlr.getLocalName());
                } else if (xmlr.hasText() && xmlr.getText().trim().length() > 0) {
                    softList.add("   " + xmlr.getText());
                }
            }
        } catch (FileNotFoundException | XMLStreamException ex) {
            ex.printStackTrace();
        }
    return softList.toString();
    }

    @Override
    public String toString() {
        return "XMLParser{}";
    }
}
