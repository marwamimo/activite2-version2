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
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.json.JSONObject;

/**
 *
 * @author 1995164
 */
public class LIVRAISON {

    private static JSONObject mainObjetct = new JSONObject();
    static Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());
    private static Connection con;
    private static PreparedStatement stm;
    private static Statement stm1;
    private static ResultSet rs;

//    public Livraison() {
//        Livraison livraison = new Livraison ();
//    }
    public static JSONObject insertLivraison() {
         mainObject.clear();
        try {
            createConnection();
            String sql = "insert into  livraison "
                    + "values (?,?)";
            stm = con.prepareStatement(sql);
            stm.setInt(1, 100);
           stm.setDate(2, new java.sql.Date(Calendar.getInstance().getTime().getTime()));
           
            int nombre = stm.executeUpdate();
            if (nombre == 1) {
                mainObject = Status.getOkStatus(" livraison inserted");
            } else {
                mainObject = Status.getErrorStatus("IN INSERT livraison ");
            }

        } catch (SQLException ex) {
            Logger.getLogger(LIVRAISON.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            closeConnection();

        }

        return mainObject;
    }


    public static JSONObject deleteLIVRAISON(int NOLIVRAISON) {
    mainObject.clear();
        try {

            createConnection();
            String sql = "delete from livraison where NOLIVRAISON=?";
            stm = con.prepareStatement(sql);
            stm.setInt(1, NOLIVRAISON);
            int nombre = stm.executeUpdate();
            if (nombre == 1) {
                mainObject = Status.getOkStatus(" LIVRAISON deleted");
            } else {
                mainObject = Status.getErrorStatus("IN DELETE LIVRAISON ");
            }

        } catch (SQLException ex) {
            Logger.getLogger(LIVRAISON.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
        return mainObject;

    }

    public static JSONObject updateLivrason(int NOLIVRAISON, Date DATELIVRAISON) {

        mainObject.clear();
        try {
            createConnection();
            String sql = "update  livraison set NOLIVRAISON=? where DATELIVRAISON=?";
            stm = con.prepareStatement(sql);
            stm.setInt(1,NOLIVRAISON);
            stm.setDate(2, DATELIVRAISON);
            int nombre = stm.executeUpdate();
            if (nombre == 1) {
                mainObject = Status.getOkStatus(" livraison updated");
            } else {
                mainObject = Status.getErrorStatus("IN UPDATE livraison ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LIVRAISON.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
        return mainObject;
    }
    public static JSONObject selectSimpleLivraison(int NOLIVRAISON) {
       mainObject.clear();
        try {

            createConnection();
            String sql = "select * from LIVRAISON  where NOLIVRAISON=?";
            stm = con.prepareStatement(sql);
            stm.setInt(1, NOLIVRAISON);
            rs=stm.executeQuery();
            rs.next();
            if (rs != null) {
                Status.getOkStatusSelect();
                mainObject.accumulate("NOLIVRAISON", rs.getInt("NOLIVRAISON"));
                mainObject.accumulate("datelivraison", rs.getDate("datelivraison"));
             
            } else {
                mainObject = Status.getErrorStatus("IN SELECT LIVRAISON ");
            }

        } catch (SQLException ex) {
            Logger.getLogger(LIVRAISON.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            closeConnection();

        }
        return mainObject;

    }

    private static void createConnection() {
        try {

            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@144.217.163.57:1521:XE", "vente", "anypw");
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
