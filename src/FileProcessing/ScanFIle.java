package FileProcessing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by programming on 23.2.16.
 */
public class ScanFIle {
    private String Filename;
    private final String Directory = "/home/programming/trends/data/";
    private int n;
    private int m;

    public ScanFIle(String FileName) {
        this.Filename = FileName;
        this.n = 2;
        this.m = 1;

    }
    public ScanFIle(String Filename, int n, int m) {
        this.m = m;
        this.Filename = Filename;
        this.n = n;
    }

    public ArrayList<String> GetAllString(){
        ArrayList <String> temp = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(Directory+Filename)))
        {
            String s;
            while((s=br.readLine())!=null){
                temp.add(s);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return temp;
    }


}
