package ru.pfr.prosess;

import java.io.File;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class ReadingXMLData {

    /** dom4j object model representation of a xml document. Note: We use the interface(!) not its implementation */
    private Document doc;

    /**
     * Loads a document from a file.
     *
     * @throw a org.dom4j.DocumentException occurs whenever the buildprocess fails.
     */
    public void parseWithSAX(File aFile) throws DocumentException {
        SAXReader xmlReader = new SAXReader();
        this.doc = xmlReader.read(aFile);
    }
}