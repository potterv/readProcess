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
        String file = "zip";
        String pathD = String.join("",new File("").getAbsolutePath());
        Factory factory = new Factory();
        TypeFile typeFile = factory.getCurentTypeFile(file);
        typeFile.getTypeFile();
        WorkFile workFile = new WorkFile();
        try {
            final String PATHDIRIN = String.join("",pathD,"\\in");
            final String PATHDIROUT = String.join("",pathD,"\\out");
            final String PATHZIP =String.join("",PATHDIRIN,"\\zip");
            final String PATHDIR = String.join("",PATHDIRIN,"\\dir");
            File dirZip = new File(PATHZIP);
            File[] filesZip = dirZip.listFiles();
            File dirDir = new File(PATHZIP);
            File[] filesDir = dirDir.listFiles();

            for (File fileZip: filesZip
            ) {
                file = "zip";
                typeFile = factory.getCurentTypeFile(file);
                typeFile.read(fileZip.getName());

                file="xml";
                typeFile = factory.getCurentTypeFile(file);
                typeFile.read(fileZip.getName().substring(0,fileZip.getName().length()-4));



                file="zip";
                typeFile = factory.getCurentTypeFile(file);
                typeFile.write(fileZip.getName().substring(0,fileZip.getName().length()-4));
                System.out.println(fileZip.getAbsolutePath());
            }

//            typeFile.read("_НВП_10_ДНЕЙ_КТЛ_3_0_0_2019.09.13");
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