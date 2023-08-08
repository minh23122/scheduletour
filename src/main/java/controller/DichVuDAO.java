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
import model.DichVu;

/**
 *
 * @author AD
 */
public class DichVuDAO {

    DAO dao = new DAO();

    public DichVu getDichVuById(int id) {
        DichVu dv = null;
        try {
            Connection con = dao.getConnection();
            String sql = "select * from dichvu where id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dv = new DichVu(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return dv;

    }

    public List<DichVu> getDVByTen(String name) {
        List<DichVu> list = new ArrayList<>();
        try {
            Connection con = dao.getConnection();
            String sql = "select * from dichvu where ten like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new DichVu(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
            rs.close();
            ps.close();
            con.close();
            return list;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }

}
