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
import model.DiaDiem;

/**
 *
 * @author AD
 */
public class LichTrinhDiaDiemDAO {

    DAO dao = new DAO();

    public void themLTDD(int ltId, int ddId) {
        try {
            Connection con = dao.getConnection();
            String sql = "insert into lichtrinhdiadiem values(?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ltId);
            ps.setInt(2, ddId);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    void rollBackThemLTDD(int ltId, int ddId) {
        try {
            Connection con = dao.getConnection();
            String sql = "delete from lichtrinhdiadiem where lt_id=? and dd_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ltId);
            ps.setInt(2, ddId);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public List<DiaDiem> getDDByLT(int ltId) {
        List<DiaDiem> list = new ArrayList<>();

        try {
            Connection con = dao.getConnection();
            String sql = "select * from lichtrinhdiadiem where lt_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ltId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new DiaDiemDAO().getDiaDiemById(rs.getInt(2)));
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }

}
