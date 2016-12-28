import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

// http://java.sun.com/j2se/1.4.2/docs/api/org/xml/sax/helpers/DefaultHandler.html
class SaxParser extends DefaultHandler {

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        System.out.println("Тег: "+qName);
        if(qName.equals("book"))
            System.out.println("id книги "+attributes.getValue("id"));

    }

    @Override
    public void characters(char[] c, int start, int length)
            throws SAXException {
        char[] val=new char[length];
        System.arraycopy(c, start, val, 0, length);
        String a = new String(val);
        System.out.println(a);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("Тег разобран: "+qName);
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Начало разбора документа!");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Разбор документа окончен!");

    }

}

