/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.activite2;

import static com.mycompany.activite2.Article.mainObject;
import static com.mycompany.activite2.Status.timestamp;
import net.sf.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 1995127
 */
public class ClientTest {

    public ClientTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of insertClient method, of class Client.
     */
    @Test
    public void testInsertClient() {
        System.out.println("insertClient");
        JSONObject expResult = null;
        JSONObject result = Client.insertClient();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteClient method, of class Client.
     */
    @Test
    public void testDeleteClient() {
        System.out.println("deleteClient");
        int id = 0;
        JSONObject expResult = null;
        JSONObject result = Client.deleteClient(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateClientNom method, of class Client.
     */
    @Test
    public void testUpdateClientNom() {
        int noClient = 10;
        String nom = "Testupd1";
        JSONObject expResult = new JSONObject();
        JSONObject result = Client.updateClientNom(noClient, nom);
        expResult.accumulate("Statut", "OK");
        expResult.accumulate("Timestamp", result.get("Timestamp"));
        expResult.accumulate("message", "" + "Client updated");

        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of selectSimple method, of class Client.
     */
    @Test
    public void testSelectSimple() {

        int noClient = 10;
        JSONObject expResult = new JSONObject();
        expResult.accumulate("Statut", "OK");
        expResult.accumulate("Timestamp", timestamp.getTime());
        
        JSONObject result = Client.selectSimple(noClient);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
