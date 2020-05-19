package ru.pfr.prosess;

import org.junit.Before;
import org.junit.Test;
import org.omg.CosNaming.BindingIterator;


import static org.junit.Assert.*;

public class zipFileTest {

    @Before
    public void init(){
        this.zf = new zipFile();
    }

    @Test
    public void getTypeFile() {
    }

    @Test
    public void write() {

        zf.write("Process_vv_znp001_Заявление о НП ЛК_9.6.0_00_2019.11.07");

    }

    @Test
    public void read() {

        zf.read("Process_vv_znp001_Заявление о НП ЛК_9.6.0_00_2019.11.07.zip");
    }

    @Test
    public void readWriteZip() {

        zf.readWriteZip();
    }
    private  zipFile zf;
}