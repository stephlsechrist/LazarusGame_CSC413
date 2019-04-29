package dev.utils;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utils {
    public static String loadFileAsString(String path){
        StringBuilder builder = new StringBuilder();

        try{
            String currentDir = System.getProperty("user.dir");
            //            System.out.println(currentDir);
            //            System.out.println(currentDir + path);
            BufferedReader br = new BufferedReader(new FileReader(currentDir + path));
            //            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while((line = br.readLine()) != null)
                builder.append(line + "\n");
            br.close();
        } catch(IOException e){
            e.printStackTrace();
        }

        return builder.toString();
    }

    public static int parseInt(String number){
        try{
            return Integer.parseInt(number);
        } catch(NumberFormatException e){
            e.printStackTrace();
            return 0;
        }
    }
}
