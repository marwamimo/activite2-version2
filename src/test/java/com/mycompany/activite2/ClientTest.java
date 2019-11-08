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
     * Test of updateClientNom method, of class Client.
     */
    @Test
    public void testUpdateClientNom() {
        int noClient = 10;
        String nom = "MarouaBh";
        
        JSONObject result =new JSONObject();
         result = Client.updateClientNom(noClient, nom);
        
        assertEquals(result.getString("Statut"), "OK");
      
    }
    /**
     * Test of deleteClient method, of class Client.
     */
    
    
  @Test
    public void testDeleteClient() {
        int noclient=514;
        JSONObject result = new JSONObject();
        result = Client.deleteClient(noclient);

        assertEquals(result.getString("Statut"), "OK");
      
    }

    /**
     * Test of selectSimple method, of class Client.
     */
    @Test
    public void testSelectSimple() {

        int noClient = 10;

        JSONObject result = new JSONObject();
        result = Client.selectSimple(noClient);

        assertEquals(result.getInt("noClient"), 10);
        assertEquals(result.getString("Statut"), "OK");

    }
    
      /**
     * Test of insertClient method, of class Client.
     */
    @Test
    public void testInsertClient() {
        
      JSONObject result = new JSONObject();
        result = Client.insertClient();
        assertEquals(result.getString("Statut"), "OK");
    }

}
