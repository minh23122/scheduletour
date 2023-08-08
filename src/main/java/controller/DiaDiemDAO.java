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
public class DiaDiemDAO {

    DAO dao = new DAO();

    public DiaDiem getDiaDiemById(int id) {
        DiaDiem d = null;
        try {
            String sql = "SELECT * FROM diadiem where id=?";
            Connection con = dao.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString(2);
                String mota = rs.getString(3);
                d = new DiaDiem(id, name, mota);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return d;
    }

    public List<DiaDiem> getDDByTen(String name) {
        List<DiaDiem> list = new ArrayList<>();
        try {
            Connection connection = dao.getConnection();
            String sqlString = "select * from diadiem where ten like ?";
            PreparedStatement ps = connection.prepareStatement(sqlString);
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new DiaDiem(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
            rs.close();
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }

}
