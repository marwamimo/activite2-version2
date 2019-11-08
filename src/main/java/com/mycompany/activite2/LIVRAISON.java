/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.activite2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.json.JSONObject;

/**
 *
 * @author 1995164
 */
public class LIVRAISON {

    private static Connection con = null;
    private static PreparedStatement stm = null;
    private static Statement stm1 = null;
    private static ResultSet rs = null;
    static Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());
    static JSONObject mainObjetct = new JSONObject();

    public static JSONObject insertLivraison(int NOLIVRAISON, Date DATELIVRAISON) {

        try {

            createConnection();
            String sql = "insert into  Livraison "
                    + "values (?,?)";
            stm = con.prepareStatement(sql);
            stm.setInt(1, NOLIVRAISON);
            stm.setDate(2, DATELIVRAISON);

            int nombre = stm.executeUpdate();

            if (nombre == 1) {

                // mainObjetct = Status.getOkStatus("OK");
//         
            } else {
                //  mainObjetct = Status.getErrorStatus("ERREUR");

            }

        } catch (SQLException ex) {
            Logger.getLogger(LIVRAISON.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            closeConnection();

        }
        return mainObjetct;

    }

    public static JSONObject deleteLIVRAISON(int NOLIVRAISON) {
        mainObjetct.clear();
        try {
            createConnection();
            String sql = "delete from livraision where NOLIVRAISON=?";
            stm = con.prepareStatement(sql);
            stm.setInt(1, NOLIVRAISON);
            int nombre = stm.executeUpdate();
            if (nombre == 1) {

                // mainObjetct = Status.getOkStatus("OK");
//         
            } else {
                //  mainObjetct = Status.getErrorStatus("ERREUR");

            }

        } catch (SQLException ex) {
            Logger.getLogger(LIVRAISON.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            closeConnection();

        }
        return mainObjetct;

    }

    public static JSONObject updateLivraison(int NOLIVRAISON, Date DATELIVRAISON) {

        mainObjetct.clear();
        try {

            createConnection();
            String sql = "update  Livraison set DATELIVRAISON=? where NOLIVRAISON=?";
            stm = con.prepareStatement(sql);
            stm.setDate(1, DATELIVRAISON);
            stm.setInt(2, NOLIVRAISON);
            int nombre = stm.executeUpdate();
            // System.out.println(nombre);
            if (nombre == 1) {

                // mainObjetct = Status.getOkStatus("OK");
//         
            } else {
                // mainObjetct = Status.getErrorStatus("ERREUR");

            }

        } catch (SQLException ex) {
            Logger.getLogger(LIVRAISON.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            closeConnection();

        }
        return mainObjetct;

    }

    public static JSONObject listLivraison() {
        mainObjetct.clear();
        try {

            LIVRAISON.createConnection();

            String sql = "SELECT * FROM LIVRAISON";
            stm1 = con.createStatement();
            rs = stm1.executeQuery(sql);
            int NOLIVRAISON;
            Date DATELIVRAISON;

            while (rs.next()) {
                NOLIVRAISON = rs.getInt("NOLIVRAISON");
                DATELIVRAISON = rs.getDate("DATELIVRAISON");

            }

        } catch (SQLException ex) {
            Logger.getLogger(LIVRAISON.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            closeConnection();

        }
        return mainObjetct;

    }

    private static void createConnection() {
        try {

            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@144.217.163.57:1521:XE", "VENTE", "anypw");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LIVRAISON.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LIVRAISON.class.getName()).log(Level.SEVERE, null, ex);
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

    private static JSONObject messageOkSingle(String msg) {

        mainObjetct.accumulate("Status", "OK");
        mainObjetct.accumulate("timestamp", timestamp.getTime());
        mainObjetct.accumulate("message", msg);

        return mainObjetct;

    }

}
