package ru.pfr.prosess;

import ru.pfr.prosess.Factory;
public class FactorTest {
    public static void main(String[] args){
        String file = "xml";
        Factory factory = new Factory();
        TypeFile typeFile = factory.getCurentTypeFile(file);
        typeFile.getTypeFile();
    }

}
