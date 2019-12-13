package ru.pfr.prosess;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StaxStreamWriter {
    public void write() throws XMLStreamException, IOException {
//        final String XHTML_NS = "http://www.w3.org/1999/xhtml";
        String XHTML_NS="START";
        XMLOutputFactory f = XMLOutputFactory.newInstance();
//        XMLStreamWriter w = f.createXMLStreamWriter(System.out);
        FileWriter fileWriter = new FileWriter("myoutput.xml");
        XMLStreamWriter w = w = f.createXMLStreamWriter(fileWriter);
        try {

            w.writeStartDocument("<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"no\\\"?>");
            w.writeCharacters("\n");
            w.writeDTD("<!DOCTYPE html >");
            w.writeCharacters("\n");
            w.writeStartElement("html");
//            w.writeStartElement(XHTML_NS, "html");
            w.writeDefaultNamespace(XHTML_NS);
            w.writeAttribute("lang", "en");
            w.writeCharacters("\n");
            w.writeStartElement(XHTML_NS, "head");
            w.writeStartElement(XHTML_NS, "title");
            w.writeCharacters("Test");
            w.writeEndElement();
            w.writeEndElement();
            w.writeCharacters("\n");
            w.writeStartElement(XHTML_NS, "body");
            w.writeCharacters("This is a test.");
            w.writeEndElement();
            w.writeEndElement();
            w.writeEndDocument();
        } catch (XMLStreamException  e) {
            e.printStackTrace();
        } finally {
            w.close();
        }
    }
}
