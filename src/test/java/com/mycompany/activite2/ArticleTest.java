/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.activite2;

import static com.mycompany.activite2.Article.mainObject;
import static com.mycompany.activite2.Status.mainObject;
import static com.mycompany.activite2.Status.timestamp;
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
     * Test of updateArticle method, of class Article.
     */
    @Test
    public void testUpdateArticle() {
        System.out.println("updateArticle");
        int noartilce = 80;
        String desc = "test11";
        //JSONObject expResult = new JSONObject();
        //expResult.accumulate("Statut", "OK");
        JSONObject result = Article.updateArticle(noartilce, desc);
        //System.out.println(result.getString("Status"));
        assertEquals(result.getString("Statut"), "OK");

    }
    /**
     * Test of deleteArticle method, of class Article.
     */
    @Test
    public void testDeleteArticle() {
        System.out.println("deleteArticle");
        int noarticle = 100;
        JSONObject expResult = new JSONObject();
        expResult.accumulate("Statut", "OK");
        JSONObject result = Article.deleteArticle(noarticle);
        assertEquals(expResult.getString("Statut"), result.getString("Statut"));
        // TODO review the generated test code and remove the default call to fail.

    }


    /**
     * Test of selectSimpleArticle method, of class Article.
     */
    @Test
    public void testSelectSimpleArticle() {
        System.out.println("selectSimpleArticle");
        int noartilce = 100;
        JSONObject result = Article.selectSimpleArticle(noartilce);
        assertEquals(100, result.getInt("noartilce"));

    }

    /**
     * Test of insertArticle method, of class Article.
     */
    @Test
    public void testInsertArticle() {
        System.out.println("insertArticle");
        JSONObject expResult = new JSONObject();
        expResult.accumulate("Statut", "OK");
        JSONObject result = Article.insertArticle();
        assertEquals(expResult.getString("Statut"), result.getString("Statut"));
    }

}
