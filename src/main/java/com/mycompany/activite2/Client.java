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
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.json.JSONObject;

/**
 *
 * @author 1995127
 */
public class Client {

    private static JSONObject mainObject;
    static Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());
    private static Connection con = null;
    private static PreparedStatement stm = null;
    private static Statement stm1 = null;
    private static ResultSet rs = null;

    public static JSONObject deleteClient(int id) {
        mainObject.clear();
        try {

            createConnection();
            String sql = "delete from client where noclient=?";
            stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            int nombre = stm.executeUpdate();
            if (nombre == 1) {
                // getOkStatus("MSG");
            } else {

                // getErrorStatus() 
            }

        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            closeConnection();
            return mainObject;
        }

    }

    public static void updateClientNom(int id, String nom) {
        mainObject.clear();
        try {

            createConnection();
            String sql = "update  Client set nomclient=? where noclient=?";
            stm = con.prepareStatement(sql);
            stm.setString(1, nom);
            stm.setInt(2, id);
            int nombre = stm.executeUpdate();
            if (nombre == 1) {
                // getOkStatus("MSG");
            } else {

                // getErrorStatus() 
            }

        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            closeConnection();

        }

    }

    public static JSONObject selectSimple(int noClient) {
        mainObject.clear();
        try {

            Client.createConnection();

            String sql = "SELECT * FROM client where noclient=?";
            stm = con.prepareStatement(sql);
            stm.setInt(1, noClient);

            rs.next();
            if (rs != null) {
                // getOkStatus();
                mainObject.accumulate("noClient", rs.getInt("noclient"));
                mainObject.accumulate("nomClient", rs.getString("nomclient"));
                mainObject.accumulate("notelephone", rs.getString("notelephone"));
            } else {

            }

        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            closeConnection();
            return mainObject;

        }

    }

    private static void createConnection() {
        try {

            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@144.217.163.57:1521:XE", "e19a10team2", "anypw");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
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

    private static void getOkStatus() {
        mainObject.accumulate("Statut", "OK");
        mainObject.accumulate("Timestamp", timestamp.getTime());

    }

}
