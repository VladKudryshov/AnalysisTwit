package Adaptation;

import java.util.ArrayList;

/**
 * Created by programming on 23.2.16.
 */
public class Parse {
    private String str;

    public Parse(String str) {
        this.str = str;
    }

    public ArrayList<String> Parse() {
        ArrayList<String> temp = new ArrayList<>();
        for (String a : str.split("\t")) {
            temp.add(a);
        }
        return  temp;
    }
}
