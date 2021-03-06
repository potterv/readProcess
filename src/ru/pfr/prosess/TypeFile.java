package ru.pfr.prosess;

import org.dom4j.DocumentException;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public interface TypeFile {
    void getTypeFile();

    public void write(String filename) throws XMLStreamException;

    void read(String fileName) throws DocumentException, IOException, XMLStreamException;
}
