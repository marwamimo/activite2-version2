/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.activite2;

import java.sql.Date;
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
    @Test
    public void testInsertLivraison() {
        System.out.println("insertLivraison");
        JSONObject expResult = null;
        JSONObject result = LIVRAISON.insertLivraison();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteLIVRAISON method, of class LIVRAISON.
     */
    @Test
    public void testDeleteLIVRAISON() {
        System.out.println("deleteLIVRAISON");
        int NOLIVRAISON = 0;
        JSONObject expResult = null;
        JSONObject result = LIVRAISON.deleteLIVRAISON(NOLIVRAISON);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateLivraison method, of class LIVRAISON.
     */
    @Test
    public void testUpdateLivraison() {
        System.out.println("updateLivraison");
        int NOLIVRAISON = 0;
        Date DATELIVRAISON = null;
        JSONObject expResult = null;
        JSONObject result = LIVRAISON.updateLivraison(NOLIVRAISON, DATELIVRAISON);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectSimpleLivraison method, of class LIVRAISON.
     */
    @Test
    public void testSelectSimpleLivraison() {
        System.out.println("selectSimpleLivraison");
        int NOLIVRAISON = 0;
        JSONObject expResult = null;
        JSONObject result = LIVRAISON.selectSimpleLivraison(NOLIVRAISON);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
