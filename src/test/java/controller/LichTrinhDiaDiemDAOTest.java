/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
public class LichTrinhDiaDiemDAOTest {

    public LichTrinhDiaDiemDAOTest() {
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
     * Test of themLTDD method, of class LichTrinhDiaDiemDAO.
     */
    @Test
    public void testThemLTDD() {
        System.out.println("themLTDD");
        int ltId = 10;
        int ddId = 2;
        LichTrinhDiaDiemDAO instance = new LichTrinhDiaDiemDAO();
        DiaDiemDAO dddao = new DiaDiemDAO();
        instance.themLTDD(ltId, ddId);
        List<DiaDiem> expect = instance.getDDByLT(ltId);
        List<DiaDiem> result = new ArrayList<>();
        result.add(new DiaDiem(2, "Sekolan", null));
        result.add(dddao.getDiaDiemById(19));
        result.add(dddao.getDiaDiemById(20));
        assertEquals(expect, result);
        instance.rollBackThemLTDD(ltId, ddId);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of rollBackThemLTDD method, of class LichTrinhDiaDiemDAO.
     */
    //TH1: Lịnh trình có địa điểm
    @Test
    public void testGetDDByLT() throws Exception {
        System.out.println("getDDByLT");
        int ltId = 2;
        DiaDiemDAO dddao = new DiaDiemDAO();
        LichTrinhDiaDiemDAO instance = new LichTrinhDiaDiemDAO();
        List<DiaDiem> expResult = new ArrayList<>();
        expResult.add(dddao.getDiaDiemById(4));
        expResult.add(dddao.getDiaDiemById(16));
        List<DiaDiem> result = instance.getDDByLT(ltId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
//    TH2: Lịch trình không có địa điểm điểm nào
    @Test
    public void testGetDDByLT2() throws Exception {
        System.out.println("getDDByLT");
        int ltId = 11;
        DiaDiemDAO dddao = new DiaDiemDAO();
        LichTrinhDiaDiemDAO instance = new LichTrinhDiaDiemDAO();
        List<DiaDiem> expResult = new ArrayList<>();
        List<DiaDiem> result = instance.getDDByLT(ltId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
}
