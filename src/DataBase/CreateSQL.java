package DataBase;

import Adaptation.*;
import java.util.ArrayList;

/**
 * Created by programming on 23.2.16.
 */
public class CreateSQL {

    public CreateSQL() {

    }

    public String createSQLQuery(String row){
        Parse t = new Parse(row);
        ArrayList<String> tmp = t.Parse();
        String temp = "";
        ValidStringFromSQL validString = new ValidStringFromSQL(tmp.get(3));
        temp = validString.OutStringInsert();

        tmp.remove(3);
        tmp.add(temp);
        String SQL = "INSERT INTO temp SET location ='"+tmp.get(0)+"',param = '"+tmp.get(1)+"' ,date = '"+tmp.get(2)+"' ,message = '"+tmp.get(3)+"', id=''";
        return SQL;
    }



}

