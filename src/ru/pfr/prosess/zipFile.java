package ru.pfr.prosess;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


public class zipFile implements TypeFile{

    public zipFile(){
        this.pathD = new File("").getAbsolutePath();
    }

    public void getTypeFile(){

        System.out.println("тип файла zip");
    }
    @Override
    public void write(String dirName){


        String filename;
        System.out.printf(this.pathD);
        File dir = new File(String.join("",this.pathD,"\\in\\dir\\",dirName));
        File[] files = dir.listFiles();
        filename = String.join("",this.pathD,"\\in\\dir\\",dirName);
        try(ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(String.join("",this.pathD,"/out/",dirName,".zip")));

            )
        {
            for (File file: files
                 ) {
                FileInputStream fis= new FileInputStream(String.join("",this.pathD,"\\in\\dir\\",dirName,"\\",file.getName()));
                ZipEntry entry1=new ZipEntry(file.getName().toString());
                System.out.printf(file.getName().toString());
                zout.putNextEntry(entry1);
                // считываем содержимое файла в массив byte
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                // добавляем содержимое к архиву
                zout.write(buffer);
            }

            zout.closeEntry();
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }

        finally {
            // закрываем текущую запись для новой записи

        }
    }
    @Override
    public void read(String fileName){
        try(ZipInputStream zin = new ZipInputStream(new FileInputStream(String.join("",this.pathD,"\\in\\zip\\",fileName))))
        {
            ZipEntry entry;
            String name;
            long size;

            final File dir1 = new File(String.join("",this.pathD,"\\in\\dir\\",fileName.substring(0,fileName.length()-4)));
            if(!dir1.exists()) {
                if(dir1.mkdir()) {
                    System.out.println("Kaтaлoг " + dir1.getAbsolutePath()+ " ycпeшнo coздaн.");
                }
                else {
                    System.out.println("Kaтaлoг " + dir1.getAbsolutePath()+ " coздвть нe yдaлocь.");
                }
            } else { System.out.println("Kaтaлoг " + dir1.getAbsolutePath()+ " yжe cyщecтвyeт.");
            }
            while((entry=zin.getNextEntry())!=null){

                name = entry.getName(); // получим название файла
                size=entry.getSize();  // получим его размер в байтах
                System.out.printf("File name: %s \t File size: %d \n", name, size);

                // распаковка




                FileOutputStream fout = new FileOutputStream(String.join("",this.pathD,"\\in\\dir\\",fileName.substring(0,fileName.length()-4),"\\",name));
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

    public void readWriteZip(){
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
            this.read(fileZip.getName());

            this.write(fileZip.getName().substring(0,fileZip.getName().length()-4));
            System.out.println(fileZip.getAbsolutePath());
        }
       System.out.printf("");
    }
    private String pathD;
}

