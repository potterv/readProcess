package ru.pfr.prosess;

import org.dom4j.DocumentException;

import java.io.File;

public class xmlFile implements TypeFile {
    public void getTypeFile(){
        System.out.println("тип файла xml");
    }

    @Override
    public void write(String filename) {

    }

    @Override
    public void read(String fileName) throws DocumentException {
        ReadingXMLData readingXMLData= new ReadingXMLData();

        readingXMLData.parseWithSAX(new File(fileName));
    }
}
