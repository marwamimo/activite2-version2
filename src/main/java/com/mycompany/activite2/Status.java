/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.activite2;

import static com.mycompany.activite2.Article.mainObject;
import java.sql.Timestamp;
import net.sf.json.JSONObject;

/**
 *
 * @author 1995092
 */
public class Status {

    static Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());

     public static JSONObject getOkStatusSelect() {
        mainObject.accumulate("Statut", "OK");
        mainObject.accumulate("Timestamp", timestamp.getTime());
        return mainObject;
    }
    public static JSONObject getOkStatus(String msg) {
        getOkStatusSelect();
        mainObject.accumulate("message", "" + msg);
        return mainObject;
    }
  
    public static JSONObject getErrorStatus(String msg) {
        mainObject.accumulate("Statut", "Error");
        mainObject.accumulate("Timestamp", timestamp.getTime());
        mainObject.accumulate("ERROR", "" + msg);
        return mainObject;
    }

}
