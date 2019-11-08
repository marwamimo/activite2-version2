/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.activite2;

import net.sf.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 1995092
 */
public class ArticleTest {
    
    public ArticleTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insertArticle method, of class Article.
     */
    @Test
    public void testInsertArticle() {
        System.out.println("insertArticle");
        JSONObject expResult = null;
        JSONObject result = Article.insertArticle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateArticle method, of class Article.
     */
    @Test
    public void testUpdateArticle() {
        System.out.println("updateArticle");
        int noartilce = 0;
        double prixUnitaire = 0.0;
        JSONObject expResult = null;
        JSONObject result = Article.updateArticle(noartilce, prixUnitaire);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteArticle method, of class Article.
     */
    @Test
    public void testDeleteArticle() {
        System.out.println("deleteArticle");
        int noarticle = 0;
        JSONObject expResult = null;
        JSONObject result = Article.deleteArticle(noarticle);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectSimpleArticle method, of class Article.
     */
    @Test
    public void testSelectSimpleArticle() {
        System.out.println("selectSimpleArticle");
        int noartilce = 0;
        JSONObject expResult = null;
        JSONObject result = Article.selectSimpleArticle(noartilce);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
