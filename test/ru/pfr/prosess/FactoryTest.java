package ru.pfr.prosess;

import org.dom4j.DocumentException;
import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class FactoryTest {

    @Test
    public void getCurentTypeFile() {
        String file = "xml";
        String pathD = String.join("",new File("").getAbsolutePath(),"\\readProcess\\in");
        Factory factory = new Factory();
        TypeFile typeFile = factory.getCurentTypeFile(file);
        typeFile.getTypeFile();
        try {
            typeFile.read(String.join("",pathD,"\\in\\НВП_10_ДНЕЙ_КТЛ_3_0_0_2019.09.13\\processDefinition.xml"));
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        try {
            typeFile.write("sdsf");
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}