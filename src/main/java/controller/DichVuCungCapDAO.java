/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DichVuCungCap;

/**
 *
 * @author AD
 */
public class DichVuCungCapDAO {

    DAO dao = new DAO();

    public List<DichVuCungCap> getDVCCbyDV(int dvId) {
            List<DichVuCungCap> list = new ArrayList<>();
        try {
            Connection con = dao.getConnection();
            String sql = "select * from dichvucungcap where dv_id=? and lt_id is null";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dvId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new DichVuCungCap(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDouble(5)));
            }
            rs.close();
            ps.close();
            con.close();
            return list;
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return list;
    }

    public List<DichVuCungCap> getDVCCbyLT(int ltId) {
        List<DichVuCungCap> list = new ArrayList<>();
        try {
            Connection con = dao.getConnection();
            String sql = "select * from dichvucungcap where lt_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ltId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new DichVuCungCap(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDouble(5)));
            }
            rs.close();
            ps.close();
            con.close();
            return list;
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return list;
    }

    public void themLTtoDVCC(int ltId, int dvccId) {
        try {
            Connection con = dao.getConnection();
            String sql = "update dichvucungcap set lt_id=? where id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ltId);
            ps.setObject(2, dvccId);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    public void roolBackThemLTtoDVCC(int dvccId){
        try {
            Connection con = dao.getConnection();
            String sql = "update dichvucungcap set lt_id=NULL where id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, dvccId);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
