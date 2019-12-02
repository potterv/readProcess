package ru.pfr.prosess;

import org.dom4j.DocumentException;

public interface TypeFile {
    void getTypeFile();


    void write(String filename);

    void read(String filename) throws DocumentException;
}
