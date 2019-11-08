/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.activite2;

import static com.mycompany.activite2.Status.timestamp;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 1995164
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
     * Test of insertLivraison method, of class LIVRAISON.
     */
//    @Test
//    public void testInsertLivraison() {
//        System.out.println("insertLivraison");
//        JSONObject expResult = null;
//        JSONObject result = LIVRAISON.insertLivraison();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteLIVRAISON method, of class LIVRAISON.
//     */
//    @Test
//    public void testDeleteLIVRAISON() {
//        System.out.println("deleteLIVRAISON");
//        int NOLIVRAISON = 0;
//        JSONObject expResult = null;
//        JSONObject result = LIVRAISON.deleteLIVRAISON(NOLIVRAISON);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of updateLivraison method, of class LIVRAISON.
     */
    @Test
    public void testUpdateLivraison() {

        LIVRAISON livraison = new LIVRAISON();
        SimpleDateFormat formatDate = new SimpleDateFormat("dd-mm-yyyy");
        int NOLIVRAISON = 100;
        java.util.Date dateLivraison = new java.util.Date();
        JSONObject expResult = new JSONObject();
        JSONObject result = LIVRAISON.updateLivraison(100, (Date) dateLivraison);
        assertEquals(expResult.getString("Statut"), result.getString("Statut"));

    }

    /**
     * Test of selectSimpleLivraison method, of class LIVRAISON.
     */
//    @Test
//    public void testSelectSimpleLivraison() {
//        System.out.println("selectSimpleLivraison");
//        int NOLIVRAISON = 0;
//        JSONObject expResult = null;
//        JSONObject result = LIVRAISON.selectSimpleLivraison(NOLIVRAISON);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
