/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.activite2;

import static com.mycompany.activite2.Article.mainObject;
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

    public static JSONObject insertLivraison() {

        try {

            createConnection();
            String sql = "insert into  Livraison "
                    + "values (?,?)";
            stm = con.prepareStatement(sql);
            stm.setInt(1, 300);
            stm.setDate(2, (Date) new java.util.Date());

            int nombre = stm.executeUpdate();

            if (nombre == 1) {

                mainObjetct = Status.getOkStatus("OK");
//         
            } else {
                mainObjetct = Status.getErrorStatus("ERREUR");

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

                mainObjetct = Status.getOkStatus("OK");
//         
            } else {
                mainObjetct = Status.getErrorStatus("ERREUR");

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

            if (nombre == 1) {

                mainObjetct = Status.getOkStatus("OK");
//         
            } else {
                mainObjetct = Status.getErrorStatus("ERREUR");

            }

        } catch (SQLException ex) {
            Logger.getLogger(LIVRAISON.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            closeConnection();

        }
        return mainObjetct;

    }

    public static JSONObject selectSimpleLivraison(int NOLIVRAISON) {
        mainObjetct.clear();
        try {

            LIVRAISON.createConnection();

            String sql = "SELECT * FROM LIVRAISON where NOLIVRAISON=?";
            stm1 = con.prepareStatement(sql);
            stm.setInt(1, NOLIVRAISON);
            rs.next();
            if (rs != null) {
                Status.getOkStatusSelect();
                mainObject.accumulate("NOLIVRAISON", rs.getInt("NOLIVRAISON"));
                mainObject.accumulate("DATELIVRAISON", rs.getString("DATELIVRAISON"));

            } else {
                mainObject = Status.getErrorStatus("IN DELETE LIVRAISON ");
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
}
