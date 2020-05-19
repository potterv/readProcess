package ru.pfr.prosess;


import javax.xml.stream.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class StaxStreamProcessor {

    public StaxStreamProcessor(){
        this.pathD= new File("").getAbsolutePath();
    }
    public void staxLoader() throws IOException, XMLStreamException {
//        Создание классов для  записи Xml
        String XHTML_NS="START";
        XMLOutputFactory f = XMLOutputFactory.newInstance();
//        XMLStreamWriter w = f.createXMLStreamWriter(System.out);
        final File dir1 = new File(String.join("",this.pathD,"\\in\\temp\\",this.dir));
        if(!dir1.exists()) {
            if(dir1.mkdir()) {
                System.out.println("Kaтaлoг " + dir1.getAbsolutePath()+ " ycпeшнo coздaн.");
            }
            else {
                System.out.println("Kaтaлoг " + dir1.getAbsolutePath()+ " coздвть нe yдaлocь.");
            }
        } else { System.out.println("Kaтaлoг " + dir1.getAbsolutePath()+ " yжe cyщecтвyeт.");
        }

        FileWriter fileWriter = new FileWriter(String.join("", this.pathD,"\\in\\temp\\",this.dir,"\\processDefinition.xml"));
        XMLStreamWriter w = w = f.createXMLStreamWriter(fileWriter);


//        инициализация классов для загрузки xml файла
        String urlString;
        boolean bossTOPfr=false;
        boolean isTransition=false;
        boolean isDep=false;


        urlString = String.join("","file:///",this.pathD,"/in/dir/", this.dir,"/processDefinition.xml");



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
        parser.standaloneSet();

        w.writeStartDocument("UTF-8","1.0");


        while (parser.hasNext()) {
            int event = parser.next();
            if (event == XMLStreamConstants.START_ELEMENT) {
                w.writeCharacters("\n");
                String tagName=parser.getLocalName();

                w.writeStartElement(tagName);

                if (parser.getAttributeCount()!=0){
                   for (int indexAttribute=0;indexAttribute<parser.getAttributeCount();indexAttribute++){
                       w.writeAttribute(parser.getAttributeLocalName(indexAttribute),parser.getAttributeValue(indexAttribute));
                   }

                }
                try {
                    if (tagName.equals("dep")) {
                        String deptype = parser.getAttributeValue(null, "type");
                        if (!deptype.equals(null) && deptype.equals("RAION")) {
                            String text = parser.getElementText().toString();
                            w.writeCharacters(text);
                            w.writeEndElement();
                        }
                        if (!deptype.equals(null) && deptype.equals("STAGE")) {
                            String text = parser.getElementText().toString();
                            w.writeCharacters(text);
                            w.writeEndElement();
                        }
                    }
                } catch (XMLStreamException  e){

                    e.printStackTrace();
                }
                finally {
                    w.writeCharacters("\n");
                }






//                if (parser.getLocalName().equals("state") || parser.getLocalName().equals("transition") || parser.getLocalName().equals("dep")) {
//
//
//                    String name = parser.getAttributeValue(null, "name");
//                    String to = parser.getAttributeValue(null, "to");
//                    String deptype = parser.getAttributeValue(null, "type");
//
//                    if (name != null) {
//// поиск тэгов с текстом "Руководитель ТО ПФР"
//                        if (name.equals("Руководитель ТО ПФР") || name.equals("Выплата") || name.equals("Руководитель ОВ (Распределитель работ)") || name.equals("Руководитель ОВ")) {
//                            System.out.println("namne " + name);
//
//                            bossTOPfr=true;
////                            log.info("Найден тэг с патраметром name = Руководитель ТО ПФР");
//                        }
//                        if (bossTOPfr){
//                            if (to!=null){
//                                System.out.println("to " + to);
//                                isTransition=true;
//                            }
//
//                        }
//
//                     }
////                    System.out.println(deptype);
//                    if (deptype!=null && deptype.equals("RAION")){
//
//                        if (isTransition){
//                            System.out.println(deptype);
//                            String textDep=parser.getElementText().toString();
//                            System.out.println(textDep);
//                            w.writeCharacters(textDep);
//
//
//                        }
//
//                    }
//
//                    if (deptype!=null && deptype.equals("STAGE")){
//                        String textDep=parser.getElementText().toString();
//                        System.out.println(textDep);
//                        w.writeCharacters(textDep);
//                        w.writeEndElement();
//
//                    }
//
//                }
//                w.writeEndElement();
            }
            if (event == XMLStreamConstants.END_ELEMENT){
                    w.writeEndElement();
                }
//

      }

        w.writeEndDocument();
        w.close();
        System.out.println("процесс анализа XML завершен");
//        log.info("процесс анализа XML завершен");
    }

private String pathD;

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    private String dir;
//    private static final Logger log = Logger.getLogger(StaxStreamProcessor.class);
}