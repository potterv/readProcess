package ru.pfr.prosess;

import ru.pfr.prosess.Factory;
public class FactorTest {
    public static void main(String[] args){
        String file = "zip";
        Factory factory = new Factory();
        TypeFile typeFile = factory.getCurentTypeFile(file);
        typeFile.getTypeFile();
//        typeFile.read();
        typeFile.write("sdsf");
    }

}
