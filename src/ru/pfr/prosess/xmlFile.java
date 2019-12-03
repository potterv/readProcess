package ru.pfr.prosess;

import org.dom4j.DocumentException;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.IOException;

public class xmlFile implements TypeFile {
    public void getTypeFile(){
        System.out.println("тип файла xml");
    }

    @Override
    public void write(String filename) throws XMLStreamException {
        StaxStreamWriter staxStreamWriter=new StaxStreamWriter();
        staxStreamWriter.write();
    }

    @Override
    public void read(String fileName) throws DocumentException, IOException, XMLStreamException {

        StaxStreamProcessor staxStreamProcessor =new StaxStreamProcessor();
        staxStreamProcessor.staxLoader();
//        ReadingXMLData readingXMLData= new ReadingXMLData();
//
//        readingXMLData.parseWithSAX(new File(fileName));
//        System.out.println(readingXMLData.toString());
    }
}
