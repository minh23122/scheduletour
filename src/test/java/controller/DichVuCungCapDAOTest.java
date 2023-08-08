/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.DichVuCungCap;
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
public class DichVuCungCapDAOTest {

    public DichVuCungCapDAOTest() {
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
     * Test of getDVCCbyDV method, of class DichVuCungCapDAO.
     */
    // TH có dịch vụ cung cấp cung cấp dịch vụ đó
    @Test
    public void testGetDVCCbyDV() throws ClassNotFoundException, SQLException {
        System.out.println("getDVCCbyDV");
        int dvId = 1;
        DichVuCungCapDAO instance = new DichVuCungCapDAO();
        List<DichVuCungCap> expResult = new ArrayList<>();
        expResult.add(new DichVuCungCap(13, 1, 1, 0, 381.5));
        expResult.add(new DichVuCungCap(28, 1, 20, 0, 216.2));
        List<DichVuCungCap> result = instance.getDVCCbyDV(dvId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getDVCCbyLT method, of class DichVuCungCapDAO.
     */
    @Test
    public void testgetDVCCbyDV2() {
        int dvId = 21;
        DichVuCungCapDAO instance = new DichVuCungCapDAO();
        List<DichVuCungCap> expResult = new ArrayList<>();
        List<DichVuCungCap> result = instance.getDVCCbyDV(dvId);
        assertEquals(expResult, result);
    }
    //th1: lt đã có dịch vụ cung cấp
    @Test
    public void testGetDVCCbyLT() throws SQLException, ClassNotFoundException {
        System.out.println("getDVCCbyLT");
        int ltId = 11;
        DichVuCungCapDAO instance = new DichVuCungCapDAO();
        List<DichVuCungCap> expResult = new ArrayList<>();
        expResult.add(new DichVuCungCap(9,14, 20, 11, 368.9));
        List<DichVuCungCap> result = instance.getDVCCbyLT(ltId);
        assertEquals(expResult.get(0).getId(), result.get(0).getId());
        assertEquals(expResult.get(0).getDv(), result.get(0).getDv());
        assertEquals(expResult.get(0).getNcc(), result.get(0).getNcc());
        assertEquals(expResult.get(0).getDongia(), result.get(0).getDongia(),1);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    //th2: lt chưa có dịch vụ cung cấp nào.
    public void testgetDVCCbyLT(){
        int ltId = 1;
        DichVuCungCapDAO instance = new DichVuCungCapDAO();
        List<DichVuCungCap> expResult = new ArrayList<>();
        List<DichVuCungCap> result = instance.getDVCCbyLT(ltId);
        assertEquals(expResult, result);
    }
    /**
     * Test of themLTtoDVCC method, of class DichVuCungCapDAO.
     */
    @Test
    public void testThemLTtoDVCC() {
        System.out.println("themLTtoDVCC");
        int ltId = 1;
        int dvccId = 1;
        DichVuCungCapDAO instance = new DichVuCungCapDAO();
        instance.themLTtoDVCC(ltId, dvccId);
        List<DichVuCungCap> resultDvcc=instance.getDVCCbyLT(1);
        assertEquals(dvccId, resultDvcc.get(0).getId());
        assertEquals(ltId, resultDvcc.get(0).getLt().getId());
        instance.roolBackThemLTtoDVCC(dvccId);
        // TODO review the generated test code and remove the default call to fail.
    }

}
