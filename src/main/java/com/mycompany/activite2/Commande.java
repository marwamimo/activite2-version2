/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.activite2;

import com.sun.security.ntlm.Client;
import java.io.File;
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

public class Commande implements java.io.Serializable {

    private static Connection con = null;
    private static PreparedStatement stm = null;
    private static Statement stm1 = null;
    private static ResultSet rs = null;

    private int nocommande;
    private int noclient;
    private Date datecommande;

    static JSONObject mainObject = new JSONObject();
    static Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());

    public Commande() {
    }

    public Commande(int nocommande, int noclient, Date datecommande) {
        this.nocommande = nocommande;
        this.noclient = noclient;
        this.datecommande = datecommande;
    }

    public int getNocommande() {
        return this.nocommande;
    }

    public void setNocommande(int nocommande) {
        this.nocommande = nocommande;
    }

    public int getClient() {
        return this.noclient;
    }

    public void setClient(int noclient) {
        this.noclient = noclient;
    }

    public Date getDatecommande() {
        return this.datecommande;
    }

    public void setDatecommande(Date datecommande) {
        this.datecommande = datecommande;
    }

    public void insertRecord() {

        try {

            createConnection();
            String sql = "insert into  Commande "
                    + "values (?,?,?)";
            stm = con.prepareStatement(sql);
            stm.setInt(1, nocommande);
            stm.setInt(2, noclient);
            stm.setDate(3, (java.sql.Date) datecommande);

            int nombre = stm.executeUpdate();
            System.out.println(nombre);

            if (nombre == 1) {
                //mainObject=Statut.getOkStatus("Record Inserted");
            } else if (nombre == 0) {
                //mainObject=Statut.getErrorStatus("Error Message");

            }
            File f = new File("json/insertRecord.json", mainObject.toString());

        } catch (SQLException ex) {
            Logger.getLogger(Commande.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            closeConnection();
            mainObject.clear();

        }

    }

    public void deleteRecord(int nocommande) {

        try {

            createConnection();
            String sql = "delete from commande where nocommande=?";
            stm = con.prepareStatement(sql);
            stm.setInt(1, nocommande);
            int nombre = stm.executeUpdate();
            System.out.println(nombre);

            if (nombre == 1) {
                //mainObject=Statut.getOkStatus("Record Inserted");
            } else if (nombre == 0) {
                //mainObject=Statut.getErrorStatus("Error Message");

            }
            File f = new File("json/deleteRecord.json", mainObject.toString());

        } catch (SQLException ex) {
            Logger.getLogger(Commande.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            closeConnection();
            mainObject.clear();
        }

    }

    public static void updateRecord(int nocommande, Date datecommande) {

        try {

            createConnection();
            String sql = "update  Commande set datecommande=? where nocommande=?";
            stm = con.prepareStatement(sql);
            stm.setDate(1, (java.sql.Date) datecommande);
            stm.setInt(2, nocommande);
            int nombre = stm.executeUpdate();
            System.out.println(nombre);

            if (nombre == 1) {
                //mainObject=Statut.getOkStatus("Record Inserted");
            } else if (nombre == 0) {
                //mainObject=Statut.getErrorStatus("Error Message");
            }
            File f = new File("json/deleteRecord.json", mainObject.toString());

        } catch (SQLException ex) {
            Logger.getLogger(Commande.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            closeConnection();
            mainObject.clear();
        }

    }

    public void selectSimple() {

        try {

            createConnection();
            String sql = "select * from Commande "
                    + " where nocommande=? ";
            stm = con.prepareStatement(sql);
            stm.setInt(1, nocommande);
            rs.next();
            if (rs != null) {
                //mainObject=Statut.getOkStatusSelect("Record Inserted");
                mainObject.accumulate("nocommande", "4");
                mainObject.accumulate("noclient", "10");
                mainObject.accumulate("datecommande", "19-07-05");

            } else if (rs == null) {
                //mainObject=Statut.getErrorStatus("Error Message");

            }
        } catch (SQLException ex) {
            Logger.getLogger(Commande.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            closeConnection();

        }

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
