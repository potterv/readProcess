package ru.pfr.prosess;

import org.dom4j.DocumentException;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public interface TypeFile {
    void getTypeFile();


    void write(String filename) throws XMLStreamException;

    void read(String filename) throws DocumentException, IOException, XMLStreamException;
}
