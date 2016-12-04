package Main;

import DataBase.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sun.rmi.runtime.Log;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by programming on 23.2.16.
 */
class Main {
    public static void main(String[] args) {


        //ConnectDB dataBase = new ConnectDB("localhost",  "root", "root", "users");
        //dataBase.Connect();
        JSONObject dataJsonObj = null;
        String secondName = "";

        String strJson = "{\"DE\": [[[-75.414089, 39.804456], [-75.507197, 39.683964], [-75.611259, 39.61824], [-75.589352, 39.459409], [-75.441474, 39.311532], [-75.403136, 39.065069], [-75.189535, 38.807653], [-75.09095, 38.796699], [-75.047134, 38.451652], [-75.693413, 38.462606], [-75.786521, 39.722302], [-75.616736, 39.831841], [-75.414089, 39.804456]]]}";


        int[] x = null;
        int[] y = null;

        try {
            dataJsonObj = new JSONObject(strJson);
            JSONArray friends = dataJsonObj.getJSONArray("DE");
            System.out.println(q(friends,new ArrayList<>()).size());
             x = new int [q(friends,new ArrayList<>()).size()/2];
             y = new int [q(friends,new ArrayList<>()).size()/2];

            ArrayList<Double> w = q(friends,new ArrayList<>());

            for(int i = 0; i<w.size(); i++){
                try{
                x[i] = w.get(0).intValue();
                y[i] = w.get(1).intValue();
                }catch (Exception gh){}
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        JFrame frame = new JFrame("Тест");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(800,600));
        Convacs convacs = new Convacs(x,y);
        frame.add(convacs);
        frame.setVisible(true);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }


    private static ArrayList q(JSONArray tmp,ArrayList<ArrayList> array ){
        ArrayList<Double> numb = new ArrayList<>();

        for (int i = 0; i < tmp.length(); i++) {
            try {
                numb.add( Double.parseDouble(tmp.get(0).toString()));
                numb.add( Double.parseDouble(tmp.get(1).toString()));
            }catch (Exception e){

                array.add(q(tmp.getJSONArray(i),array));
            }

        }
        array.add(numb);
        return array;
    }
}
