/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.DichVu;
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
public class DichVuDAOTest {
    
    public DichVuDAOTest() {
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
     * Test of getDichVuById method, of class DichVuDAO.
     */
//    @Test
//    public void testGetDichVuById() {
//        System.out.println("getDichVuById");
//        int id = 0;
//        DichVuDAO instance = new DichVuDAO();
//        DichVu expResult = null;
//        DichVu result = instance.getDichVuById(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//    }

    /**
     * Test of getDVByTen method, of class DichVuDAO.
     */
    //TH tên có trong cơ sở dữ liệu
    @Test
    public void testGetDVByTen() {
        System.out.println("getDVByTen");
        String name = "Duran";
        DichVuDAO instance = new DichVuDAO();
        List<DichVu> expResult = new ArrayList<>();
        expResult.add(new DichVu(4, "Durango", null));
        List<DichVu> result = instance.getDVByTen(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    //TH tên không có trong cơ sở dữ liệu
    @Test
    public void testGetDVByTen2(){
        String name="ssddsa";
        List<DichVu> result =new DichVuDAO().getDVByTen(name);
        assertEquals(result, new ArrayList<Object>());
    }
}
