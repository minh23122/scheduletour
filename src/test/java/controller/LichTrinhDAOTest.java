/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.List;
import model.LichTrinh;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author AD
 */
public class LichTrinhDAOTest {
    
    public LichTrinhDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllLTTours method, of class LichTrinhDAO.
     */
    @Test
    public void testGetAllLTTours() throws Exception {
        System.out.println("getAllLTTours");
        LichTrinhDAO instance = new LichTrinhDAO();
        List<LichTrinh> result = instance.getAllLTTours();
        assertEquals(result.size(), 20);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testThemLT() {
        System.out.println("themLT");
        LichTrinhDAO instance = new LichTrinhDAO();
        int x=instance.getAllLichTrinhs().size();
        instance.themLT();
        int y=instance.getAllLichTrinhs().size();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(x+1, y);
        instance.rollBackThemLT();
    }

    /**
     * Test of rollBackThemLT method, of class LichTrinhDAO.
//     */
//    @Test
//    public void testRollBackThemLT() {
//        System.out.println("rollBackThemLT");
//        LichTrinhDAO instance = new LichTrinhDAO();
//        instance.rollBackThemLT();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of save method, of class LichTrinhDAO.
     */
    @Test
    public void testSave() throws SQLException, ClassNotFoundException {
        System.out.println("save");
        int ltId = 1;
        int tourId = 14;
        LichTrinhDAO instance = new LichTrinhDAO();
        instance.save(ltId, tourId);
        List<LichTrinh> list=instance.getAllLTTours();
        boolean check=false;
        for(LichTrinh lt:list){
            if(lt.getId()==ltId){
                check=(lt.getTour().getId()==tourId);
            }
        }
        assertTrue(check);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
