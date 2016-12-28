import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;

// SAX
import org.xml.sax.SAXException;

public class Main {

    public static void main(String[] args)
    {
        System.out.println("1-чтение xml средствами SAX");
        System.out.println("2-запись xml средствами DOM");
        System.out.println("0-выход");
        Scanner in = new Scanner(System.in);
        int res=in.nextInt();
        switch (res){
            case 1: SAXParserFactory factory = SAXParserFactory.newInstance();
                SAXParser parser;

                InputStream xmlData = null;
                try
                {
                    xmlData = new FileInputStream("src/books.xml");

                    parser = factory.newSAXParser();
                    parser.parse(xmlData, new SaxParser());


                } catch (ParserConfigurationException | SAXException | IOException e)
                {
                    e.printStackTrace();
                    // обработки ошибки, файл не найден
                } break;
            case 2: DomParser dom = new DomParser(); break;
            case 0:break;
                default:break;
        }


    }
}
