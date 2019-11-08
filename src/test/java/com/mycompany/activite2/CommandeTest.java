/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.activite2;

import java.util.Date;
import net.sf.json.JSONObject;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author 1995150
 */
public class CommandeTest {

    public CommandeTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of insertRecord method, of class Commande.
     */
    //  @Test
     public void testInsertRecord() {

    JSONObject result = new JSONObject();
    result  = Commande.insertRecord();

    assertEquals(result.getString("Statut"), "OK");
    //   }
    /**
     * Test of deleteRecord method, of class Commande.
     */
//    @Test
//    public void testDeleteRecord() {
//        int nocommande = 10;
//        JSONObject result = new JSONObject();
//        result = Commande.deleteRecord(nocommande);
//        assertEquals(result.getString("Statut"), "OK");
        //  }
        /**
         * Test of updateRecord method, of class Commande.
         */
//    @Test
//    public void testUpdateRecord() {
//        
//        int nocommande =4;
//        int noclient=30;
// 
//        JSONObject result = new JSONObject();
//               result= Commande.updateRecord(nocommande, noclient);

//
//        assertEquals( result.getInt("Statut", "OK"), 4);

//    }
        /**
         * Test of selectSimple method, of class Commande.
         */
//    @Test
//    public void testSelectSimple() {       
//        int nocommande = 4;
//        JSONObject result = new JSONObject();
//        result = Commande.selectSimple(nocommande);
//        assertEquals(result.getInt("nocommande"), 4);
//
//    }

    }
}
