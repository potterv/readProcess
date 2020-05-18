package ru.pfr.prosess;

import org.junit.Test;


import static org.junit.Assert.*;

public class zipFileTest {

    @Test
    public void getTypeFile() {
    }

    @Test
    public void write() {
        zipFile zf = new zipFile();
        zf.write("");

    }

    @Test
    public void read() {
       zipFile zf = new zipFile();
        zf.read("Process_vv_znp001_Заявление о НП ЛК_9.6.0_00_2019.11.07.zip");
    }
}