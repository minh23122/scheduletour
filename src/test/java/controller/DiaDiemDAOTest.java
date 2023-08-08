/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.transaction.Transactional;
import model.DiaDiem;
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
public class DiaDiemDAOTest {
    
    public DiaDiemDAOTest() {
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
    /**
     * Test of getDDByTen method, of class DiaDiemDAO.
     */
    //TH tên có trong csdl các địa điểm.
    @Test
    public void testGetDDByTen() {
        System.out.println("getDDByTen");
        String name="Zuogaimanma";
        List<DiaDiem> expResult =new ArrayList<>();
        expResult.add(new DiaDiem(1, "Zuogaimanma", null));
        DiaDiemDAO instance = new DiaDiemDAO();
        List<DiaDiem> result = instance.getDDByTen(name);
        assertEquals(expResult, result);
    }
    //TH tên không có trong csdl.
    @Test
    public void testGetDDByTen2(){
        String name="ạksawf";
        DiaDiemDAO instance = new DiaDiemDAO();
        List<DiaDiem> result = instance.getDDByTen(name);
        assertEquals(result.size(), 0);
    }
    
}
