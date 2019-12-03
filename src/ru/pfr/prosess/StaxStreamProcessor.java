package ru.pfr.prosess;


import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class StaxStreamProcessor {
    public void staxLoader() throws IOException, XMLStreamException {

        String urlString;
        boolean bossTOPfr=false;
        boolean isTransition=false;
        boolean isDep=false;

        urlString = "file:///D:/IdeaProject/readProcess/in/%D0%9D%D0%92%D0%9F_10_%D0%94%D0%9D%D0%95%D0%99_%D0%9A%D0%A2%D0%9B_3_0_0_2019.09.13/processDefinition.xml";
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
        while (parser.hasNext()) {
            int event = parser.next();
            if (event == XMLStreamConstants.START_ELEMENT) {
                if (parser.getLocalName().equals("state") || parser.getLocalName().equals("transition") || parser.getLocalName().equals("dep")) {
                    String name = parser.getAttributeValue(null, "name");
                    String to = parser.getAttributeValue(null, "to");
                    String deptype = parser.getAttributeValue(null, "type");

                    if (name != null) {

                        if (name.equals("Руководитель ТО ПФР")) {
                            System.out.println("namne " + name);

                            bossTOPfr=true;

                        }
                        if (bossTOPfr){
                            if (to!=null){
                                System.out.println("to " + to);
                                isTransition=true;
                            }

                        }

                     }
                    if (deptype!=null){
                        if (isTransition){
                            System.out.println(deptype);
                        }

                    }

                }
            }
            if (event == XMLStreamConstants.END_ELEMENT){
                if (parser.getLocalName().equals("state")) {
                    bossTOPfr=false;
                }
            }
            if (event == XMLStreamConstants.END_ELEMENT) {
                if (parser.getLocalName().equals("transition")) {
                    isTransition = false;
                }
            }

            if (event == XMLStreamConstants.END_ELEMENT) {
                if (parser.getLocalName().equals("dep")) {
                    isDep = false;
                }
            }

        }
        System.out.println("процесс анализа XML завершен");
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