/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.activite2;

import java.sql.Date;
import java.util.Calendar;
import net.sf.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Manar
 */
public class LIVRAISONTest {
    
    public LIVRAISONTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insertLivraison method, of class Livraison.
     */
    @Test
    public void testInsertLivraison() {
        JSONObject result = new JSONObject();
        result = LIVRAISON.insertLivraison();
        assertEquals(result.getString("Statut"), "OK");
    }

    /**
     * Test of deleteLIVRAISON method, of class Livraison.
     */
    @Test
    public void testDeleteLIVRAISON() {
        int nolivraison = 100;
        JSONObject result = new JSONObject();
        result = LIVRAISON.deleteLIVRAISON(nolivraison);
        assertEquals(result.getString("Statut"), "OK");
    }

    /**
     * Test of updateLivrason method, of class Livraison.
     */
    @Test
    public void testUpdateLivrason() {
        System.out.println("updateLivrason");
        int nolivraison = 100;
        JSONObject result = new JSONObject();
        result = LIVRAISON.updateLivrason(nolivraison, new java.sql.Date(Calendar.getInstance().getTime().getTime()));
       
        assertEquals(result.getString("Statut"), "OK");

    }

    /**
     * Test of selectSimpleLivraison method, of class Livraison.
     */
    @Test
    public void testSelectSimpleLivraison() {
        System.out.println("selectSimpleLivraison");
           int nolivraison = 100;

        JSONObject result = new JSONObject();
        result = LIVRAISON.selectSimpleLivraison(nolivraison);

        assertEquals(result.getInt("nolivraison"), 100);
        assertEquals(result.getString("Statut"), "OK");
    }
    
}
