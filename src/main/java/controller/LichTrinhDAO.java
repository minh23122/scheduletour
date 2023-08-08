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
import model.LichTrinh;

/**
 *
 * @author AD
 */
public class LichTrinhDAO {

    DAO dao = new DAO();
    Connection connection = null;

    public List<LichTrinh> getAllLTTours() {
        List<LichTrinh> l = new ArrayList<>();
        try {
            connection = dao.getConnection();
            String sql = "select * from tour left join lichtrinh on tour.id=lichtrinh.tour_id";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                l.add(new LichTrinh(rs.getInt(6), rs.getInt(1)));
            }
            rs.close();
            ps.close();
            connection.close();
            return l;
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return l;
    }
    
    public LichTrinh getLichTrinhById(int id) throws ClassNotFoundException {
        LichTrinh lt = null;
        try {
            String sql = "SELECT * FROM lichtrinh where id=?";
            Connection con = dao.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                lt = new LichTrinh(rs.getInt(1), rs.getInt(2));
            }
            rs.close();
            ps.close();
            con.close();
            return lt;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return lt;
    }

    public List<LichTrinh> getAllLichTrinhs() {
        List<LichTrinh> list = new ArrayList<>();
        try {
            connection = dao.getConnection();
            String sqlString = "select * from lichtrinh";
            PreparedStatement ps = connection.prepareStatement(sqlString);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new LichTrinh(rs.getInt(1), rs.getInt(2)));
            }
            rs.close();
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return list;
    }

    public void themLT() {
        try {
            connection = dao.getConnection();
            String sql = "insert into lichtrinh(id) values (?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            List<LichTrinh> list = getAllLichTrinhs();
            ps.setInt(1, list.size() + 1);
            ps.executeUpdate();
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    public void rollBackThemLT(){
        try {
            connection = dao.getConnection();
            String sql = "delete from lichtrinh where id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            List<LichTrinh> list = getAllLichTrinhs();
            ps.setInt(1, list.size());
            ps.executeUpdate();
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    public void save(int ltId, int tourId) {
        try {
            connection = dao.getConnection();
            String sql = "update lichtrinh set tour_id=? where id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, tourId);
            ps.setInt(2, ltId);
            ps.executeUpdate();
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
