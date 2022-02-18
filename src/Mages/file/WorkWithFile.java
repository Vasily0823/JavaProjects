package Mages.file;

import java.io.*;
import java.util.Arrays;


public class WorkWithFile {

    //создание каталога для записи
    public static void createPackage(String fileName) {
        File f = new File("E:\\JavaProjects\\magesSaves", fileName);
        if (!f.exists()) {
            System.out.println("папки нет, создаем");

            System.out.println(f.mkdirs());
        }
    }

    //записали в фаил
    public static void writeInFile(String text, String namefile){
        try(FileOutputStream fos=new FileOutputStream(namefile))
        {
            // перевод строки в байты
            byte[] buffer = text.getBytes();
            fos.write(buffer, 0, buffer.length);
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    //

    public static void readFromFile(String namefile){
        try(FileReader reader = new FileReader(namefile))
        {
            char[] buf = new char[256];
            int c;
            while((c = reader.read(buf))>0){

                if(c < 256){
                    buf = Arrays.copyOf(buf, c);
                }
                System.out.print(buf);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }



}

