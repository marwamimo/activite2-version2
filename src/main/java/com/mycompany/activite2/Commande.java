/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.activite2;

import static com.mycompany.activite2.Article.mainObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.json.JSONObject;

public class Commande {
    

    private static Connection con ;
    private static PreparedStatement stm= null;

    private static ResultSet rs=null ;

    static JSONObject mainObject = new JSONObject();
    static Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());

    public static JSONObject insertRecord() {

        try {

            createConnection();
            String sql = "insert into  Commande "
                    + "values (?,?,?)";
            stm = con.prepareStatement(sql);
            stm.setInt(1, 10);
            stm.setInt(2, 20);
            stm.setDate(3, java.sql.Date.valueOf("2019-11-08"));

            int nombre = stm.executeUpdate();
            System.out.println(nombre);

            if (nombre == 1) {
                mainObject=Status.getOkStatus("Record Inserted");
            } else  {
                mainObject=Status.getErrorStatus("Error Message");

            }

        } catch (SQLException ex) {
            Logger.getLogger(Commande.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            closeConnection();
            mainObject.clear();

        }
        return mainObject;
    }

    public static JSONObject deleteRecord(int nocommande) {

        try {

            createConnection();
            String sql = "delete from commande where nocommande=?";
            stm = con.prepareStatement(sql);
            stm.setInt(1, 10);
            int nombre = stm.executeUpdate();
            System.out.println(nombre);

            if (nombre == 1) {
                mainObject=Status.getOkStatus("Record Inserted");
            } else  {
                mainObject=Status.getErrorStatus("Error Message");

            }

        } catch (SQLException ex) {
            Logger.getLogger(Commande.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            closeConnection();
            mainObject.clear();
        }
        return mainObject;
    }

    public static JSONObject updateRecord(int nocommande, Date datecommande) {

        try {

            createConnection();
            String sql = "update  Commande set datecommande=? where nocommande=?";
            stm = con.prepareStatement(sql);
            
            stm.setInt(2, 10);
            stm.setDate(1,  java.sql.Date.valueOf("2019-11-08"));
            
            int nombre = stm.executeUpdate();
            System.out.println(nombre);

            if (nombre == 1) {
                mainObject=Status.getOkStatus("Record Inserted");
            } else  {
                mainObject=Status.getErrorStatus("Error Message");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Commande.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            closeConnection();
            mainObject.clear();
        }
        return mainObject;
    }

    public static JSONObject selectSimple() {

        try {

            createConnection();
            String sql = "select * from Commande "
                    + " where nocommande=? ";
            stm = con.prepareStatement(sql);
            
            stm.setInt(1, 4);
            rs.next();
            if (rs != null) {
                mainObject=Status.getOkStatusSelect();
                mainObject.accumulate("nocommande", "4");
                mainObject.accumulate("noclient", "10");
                mainObject.accumulate("datecommande", "19-07-05");

            } else  {
                mainObject=Status.getErrorStatus("Error Message");

            }
        } catch (SQLException ex) {
            Logger.getLogger(Commande.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            closeConnection();
            mainObject.clear();
        }
        return mainObject;
    }

    private static void createConnection() {
        try {

            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@144.217.163.57:1521:XE", "e19a10team2", "anypw");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void closeConnection() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {

            }

        }
        if (stm != null) {
            try {
                stm.close();
            } catch (SQLException e) {

            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {

            }
        }
    }
}
