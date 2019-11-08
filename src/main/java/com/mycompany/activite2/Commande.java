/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.activite2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.json.JSONObject;

public class Commande {

    private static Connection con;
    private static PreparedStatement stm = null;

    private static ResultSet rs = null;

    static JSONObject mainObject = new JSONObject();
    static Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());

    public static JSONObject insertRecord() {

        try {

            createConnection();
            String sql = "insert into  Commande "
                    + "values (?,?,?)";
            stm = con.prepareStatement(sql);
            stm.setInt(1, 330);
            stm.setInt(2, 20);
            stm.setString(3, ("19-11-08"));

            int nombre = stm.executeUpdate();
            System.out.println(nombre);

            if (nombre == 1) {
                mainObject = Status.getOkStatus("Record Inserted");
            } else {
                mainObject = Status.getErrorStatus("Error Message");

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
        mainObject.clear();
        try {

            createConnection();
            String sql = "delete from commande where nocommande=?";
            stm = con.prepareStatement(sql);
            stm.setInt(1, nocommande);
            int nombre = stm.executeUpdate();
            System.out.println(nombre);

            if (nombre == 1) {
                mainObject = Status.getOkStatus("Record Inserted");
            } else {
                mainObject = Status.getErrorStatus("Error Message");

            }

        } catch (SQLException ex) {
            Logger.getLogger(Commande.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            closeConnection();
            mainObject.clear();
        }
        return mainObject;
    }

    public static JSONObject updateRecord(int nocommande, int noclient) {

        try {

            createConnection();
            String sql = "update  Commande set noclient=? where nocommande=?";
            stm = con.prepareStatement(sql);

            stm.setInt(2, 10);
            stm.setInt(1, 20);

            int nombre = stm.executeUpdate();
            System.out.println(nombre);

            if (nombre == 1) {
                mainObject = Status.getOkStatus("Record Inserted");
            } else {
                mainObject = Status.getErrorStatus("Error Message");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Commande.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            closeConnection();
            mainObject.clear();
        }
        return mainObject;
    }

    public static JSONObject selectSimple(int nocommande) {
        mainObject.clear();
        try {

            createConnection();
            String sql = "select * from commande where nocommande=?";
            stm = con.prepareStatement(sql);
            stm.setInt(1, nocommande);
            rs = stm.executeQuery();
            rs.next();

            if (rs != null) {
                mainObject = Status.getOkStatusSelect();
                mainObject.accumulate("nocommande", rs.getInt("nocommande"));
                mainObject.accumulate("noclient", rs.getInt("noclient"));
                mainObject.accumulate("datecommande", String.valueOf(rs.getDate("datecommande")));

            } else {
                mainObject = Status.getErrorStatus("Error Message");

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
            con = DriverManager.getConnection("jdbc:oracle:thin:@144.217.163.57:1521:XE", "vente", "anypw");
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
