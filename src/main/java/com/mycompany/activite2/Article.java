/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.activite2;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.json.JSONObject;

/**
 *
 * @author 1995092
 */
public class Article {
    
    private static Connection con = null;
    private static PreparedStatement stm = null;
    private static Statement stm1 = null;
    private static ResultSet rs = null;
    static Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());
    static JSONObject mainObject = new JSONObject();

    public static JSONObject insertArticle(){
       mainObject.clear();
       try {
            createConnection();
            String sql = "insert into  article "
                    + "values (?,?,?,?)";
            stm = con.prepareStatement(sql);
            stm.setInt(1, 100);
            stm.setString(2, "articleTest");
            stm.setDouble(3, 10.1);
            stm.setInt(4, 20);
            int nombre = stm.executeUpdate();
              if (nombre == 1) {
                mainObject = Status.getOkStatus(" article inserted");
            } else {
                mainObject = Status.getErrorStatus("IN INSERT ARTICLE ");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Article.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            closeConnection();

        }

        return mainObject;
    }
    public static JSONObject updateArticle(int noartilce, double prixUnitaire) {
       mainObject = new JSONObject();
        try {

            createConnection();
            String sql = "update  article set prixunitaire=? where noartilce=?";
            stm = con.prepareStatement(sql);
            stm.setDouble(1, prixUnitaire);
            stm.setInt(2, noartilce);
            int nombre = stm.executeUpdate();
            if (nombre == 1) {
                mainObject = Status.getOkStatus(" article updated");
            } else {
                mainObject = Status.getErrorStatus("IN UPDATE ARTICLE ");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Article.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            closeConnection();

        }
        return mainObject;

    }

    public static JSONObject deleteArticle(int noarticle) {
        mainObject.clear();
        try {

            createConnection();
            String sql = "delete from article where noarticle=?";
            stm = con.prepareStatement(sql);
            stm.setInt(1, noarticle);
            int nombre = stm.executeUpdate();
            if (nombre == 1) {
                mainObject = Status.getOkStatus(" article deleted");
            } else {
                mainObject = Status.getErrorStatus("IN DELETE ARTICLE ");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Article.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
        return mainObject;

    }

    public static JSONObject selectSimpleArticle(int noartilce) {
        mainObject.clear();
        try {

            createConnection();
            String sql = "select * from article  where noartilce=?";
            stm = con.prepareStatement(sql);
            stm.setInt(1, noartilce);

            rs.next();
            if (rs != null) {
                Status.getOkStatusSelect();
                mainObject.accumulate("noartilce", rs.getInt("noartilce"));
                mainObject.accumulate("description", rs.getString("description"));
                mainObject.accumulate("prix unitaire", rs.getString("prixunitaire"));
                mainObject.accumulate("quantite en stock", rs.getString("quantiteenstock"));
            } else {
                mainObject = Status.getErrorStatus("IN SELECT ARTICLE ");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Article.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            closeConnection();

        }
        return mainObject;

    }

    private static void createConnection() {
        try {

            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@144.217.163.57:1521:XE", "e19a10team2", "anypw");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Article.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Article.class.getName()).log(Level.SEVERE, null, ex);
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

//    private static JSONObject getErrorStatus(String msg) {
//        mainObject.accumulate("Statut", "Error");
//        mainObject.accumulate("Timestamp", timestamp.getTime());
//        mainObject.accumulate("ERROR", "" + msg);
//        return mainObject;
//    }
//    private static JSONObject getOkStatus(String msg) {
//        mainObject.accumulate("Statut", "OK");
//        mainObject.accumulate("Timestamp", timestamp.getTime());
//        mainObject.accumulate("message", "" + msg);
//        return mainObject;
//
//    }
}
