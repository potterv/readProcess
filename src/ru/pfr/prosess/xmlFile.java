package ru.pfr.prosess;

import java.io.File;

public class xmlFile implements TypeFile {
    public void getTypeFile(){
        System.out.println("тип файла xml");
    }

    @Override
    public void write(String filename) {

    }

    @Override
    public void read(String filename) {
        ReadingXMLData readingXMLData= new ReadingXMLData();

        readingXMLData.parseWithSAX(fileName);
    }
}
