package Adaptation;

/**
 * Created by programming on 23.2.16.
 */
public class ValidStringFromSQL {
    private String temp;

    public ValidStringFromSQL(String temp) {
        this.temp = temp;
    }

    public String OutStringInsert(){

        temp = temp.replace("\\","\\\\'");
        return temp.replace("'","\\\'");
    }



}
