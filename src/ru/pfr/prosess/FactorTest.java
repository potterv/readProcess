package ru.pfr.prosess;

import org.dom4j.DocumentException;
import ru.pfr.prosess.Factory;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public class FactorTest {
    public static void main(String[] args) throws DocumentException, IOException, XMLStreamException {
        String file = "xml";
        Factory factory = new Factory();
        TypeFile typeFile = factory.getCurentTypeFile(file);
        typeFile.getTypeFile();
        typeFile.read("D:\\IdeaProject\\readProcess\\in\\НВП_10_ДНЕЙ_КТЛ_3_0_0_2019.09.13\\processDefinition.xml");
        typeFile.write("sdsf");
    }

}
