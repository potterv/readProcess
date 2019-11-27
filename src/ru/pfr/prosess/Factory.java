package ru.pfr.prosess;

public class Factory {
    public TypeFile getCurentTypeFile(String input){
        TypeFile typeFile =null;
        if(input.equals("zip")){
         typeFile = new zipFile();
        }else if (input.equals("xml")){
            typeFile = new xmlFile();
        }
        return typeFile;
    }
}
