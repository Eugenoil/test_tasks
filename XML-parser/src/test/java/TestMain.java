public class TestMain {
    public static void main(String[] args) {
        XMLParser xmlParser = new XMLParser();
        System.out.println(xmlParser.parseXML("src/main/resources/software.xml"));
    }
}
