import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class DomParser {

    private DocumentBuilder builder;

    public DomParser() {
        ParamLangXML();  //Инициализация XML
        System.out.println("Введите имя файла");
        Scanner in = new Scanner(System.in);
        String name = in.next();
        try {
            WriteParamXML(name); // запись
        } catch (TransformerException | IOException e) {
            e.printStackTrace();
        }
    }

    public void ParamLangXML() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try { builder = factory.newDocumentBuilder(); }
        catch (ParserConfigurationException e) { e.printStackTrace(); }
    }


    /**
     * Запись настроек в XML файл
     */
    public void WriteParamXML(String name) throws TransformerException, IOException {

        Document doc=builder.newDocument();
        Element RootElement=doc.createElement("DataBase");

        Element DBDriver=doc.createElement("DataBaseDriver");
        DBDriver.appendChild(doc.createTextNode("com.mysql.jdbc.Driver"));
        RootElement.appendChild(DBDriver);

        Element DataUrl=doc.createElement("DataURL");
        DataUrl.appendChild(doc.createTextNode("jdbc:mysql://localhost:3306/onlinestore"));
        RootElement.appendChild(DataUrl);

        Element Login=doc.createElement("login");
        Login.appendChild(doc.createTextNode("root"));
        RootElement.appendChild(Login);

        Element Password=doc.createElement("password");
        Password.appendChild(doc.createTextNode("root"));
        RootElement.appendChild(Password);

        doc.appendChild(RootElement);

        Transformer t= TransformerFactory.newInstance().newTransformer();
        t.transform(new DOMSource(doc), new StreamResult(new FileOutputStream("src/"+name+".xml")));

    }
}
