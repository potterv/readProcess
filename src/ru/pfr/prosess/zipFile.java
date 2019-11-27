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
//    public void write(String filename){
//        filename = "C:\\SomeDir\\notes.txt";
//        try(ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("C:\\SomeDir\\output.zip"));
//            FileInputStream fis= new FileInputStream(filename);)
//        {
//            ZipEntry entry1=new ZipEntry("notes.txt");
//            zout.putNextEntry(entry1);
//            // считываем содержимое файла в массив byte
//            byte[] buffer = new byte[fis.available()];
//            fis.read(buffer);
//            // добавляем содержимое к архиву
//            zout.write(buffer);
//            // закрываем текущую запись для новой записи
//            zout.closeEntry();
//        }
//        catch(Exception ex){
//
//            System.out.println(ex.getMessage());
//        }
//    }
//
//    public void read(){
//        try(ZipInputStream zin = new ZipInputStream(new FileInputStream("C:\\SomeDir\\output.zip")))
//        {
//            ZipEntry entry;
//            String name;
//            long size;
//            while((entry=zin.getNextEntry())!=null){
//
//                name = entry.getName(); // получим название файла
//                size=entry.getSize();  // получим его размер в байтах
//                System.out.printf("File name: %s \t File size: %d \n", name, size);
//
//                // распаковка
//                FileOutputStream fout = new FileOutputStream("C:\\somedir\\new" + name);
//                for (int c = zin.read(); c != -1; c = zin.read()) {
//                    fout.write(c);
//                }
//                fout.flush();
//                zin.closeEntry();
//                fout.close();
//            }
//        }
//        catch(Exception ex){
//
//            System.out.println(ex.getMessage());
//        }
//    }
}

