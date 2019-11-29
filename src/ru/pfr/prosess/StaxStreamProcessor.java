package ru.pfr.prosess;


import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class StaxStreamProcessor  {
    public void saxLoader() throws IOException, XMLStreamException {

        String urlString;

        urlString = "http://www.w3c.org";
        System.out.println("Using " + urlString);

        URL url = null;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        InputStream in = url.openStream();
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader parser = factory.createXMLStreamReader(in);
        while (parser.hasNext()){
             int event = parser.next ();
             if (event == XMLStreamConstants.START_ELEMENT) {
                if (parser.getLocalName().equals("a")) {
                    String href = parser.getAttributeValue(null, "href");
                    if (href != null)
                        System.out.println(href);
                }
             }
           }
    }
//        File file = new File("D:\\IdeaProject\\readProcess\\in\\НВП_10_ДНЕЙ_КТЛ_3_0_0_2019.09.13\\processDefinition.xml");
//        if (!file.exists()){
//
//                System.out.println("По данному пути  файл не существует");
//            }
//
//        }else {
//
//        }
////        String urlString;
////        if(a)

}