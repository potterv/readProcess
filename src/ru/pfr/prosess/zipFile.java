package ru.pfr.prosess;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


public class zipFile implements TypeFile{
    public void getTypeFile(){
        System.out.println("тип файла zip");
    }
    @Override
    public void write(String filename){
        filename = "/home/potterdev/Загрузки/new/processDefinition.xml";
        try(ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("/home/potterdev/Загрузки/output.zip"));
            FileInputStream fis= new FileInputStream(filename);)
        {
            ZipEntry entry1=new ZipEntry("processDefinition.xml");
            zout.putNextEntry(entry1);
            // считываем содержимое файла в массив byte
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            // добавляем содержимое к архиву
            zout.write(buffer);
            // закрываем текущую запись для новой записи
            zout.closeEntry();
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }
    @Override
    public void read(String fileName){
        try(ZipInputStream zin = new ZipInputStream(new FileInputStream("/home/potterdev/Загрузки/Process_vv_znp001_Заявление о НП ЛК_2018.10.31_типа 9.6.0.zip")))
        {
            ZipEntry entry;
            String name;
            long size;
            while((entry=zin.getNextEntry())!=null){

                name = entry.getName(); // получим название файла
                size=entry.getSize();  // получим его размер в байтах
                System.out.printf("File name: %s \t File size: %d \n", name, size);

                // распаковка
                FileOutputStream fout = new FileOutputStream("/home/potterdev/Загрузки/new/" + name);
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }
                fout.flush();
                zin.closeEntry();
                fout.close();
            }
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }
}

