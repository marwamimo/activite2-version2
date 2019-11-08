/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.activite2;

import net.sf.json.JSONObject;
import net.sf.json.test.JSONAssert;
import org.junit.After;
import static org.junit.Assert.assertEquals;
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
    //  public void testInsertRecord() {
//        System.out.println("insertRecord");
//        JSONObject expResult = null;
//        JSONObject result = Commande.insertRecord();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    //   }
    /**
     * Test of deleteRecord method, of class Commande.
     */
//    @Test
    // public void testDeleteRecord() {
//        System.out.println("deleteRecord");
//        int nocommande = 0;
//        JSONObject expResult = null;
//        JSONObject result = Commande.deleteRecord(nocommande);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    //  }
    /**
     * Test of updateRecord method, of class Commande.
     */
//    @Test
//    public void testUpdateRecord() {
//         System.out.println("UpdateRecord");
//        int nocommande =4;
//        int noclient=30;
//        JSONObject expResult = new JSONObject();
//        JSONObject result = new JSONObject();
//               result= Commande.updateRecord(nocommande, noclient);
//        expResult.accumulate("Statut", "OK");
//
//        assertEquals(4, result.getInt("nocommande"));
//       assertEquals(expResult, result.getString("OK"));
//    }
    /**
     * Test of selectSimple method, of class Commande.
     */
    @Test
    public void testSelectSimple() {       
        int nocommande = 4;
        JSONObject result = new JSONObject();
        result = Commande.selectSimple(nocommande);
        assertEquals(result.getInt("nocommande"), 4);

    }

}
