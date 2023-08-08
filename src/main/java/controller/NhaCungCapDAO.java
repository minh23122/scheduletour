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
import model.DiaDiem;
import model.NhaCungCap;

/**
 *
 * @author AD
 */
public class NhaCungCapDAO {

    DAO dao = new DAO();

    public NhaCungCap getNCCById(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM nhacungcap where id=?";
        Connection con = dao.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        NhaCungCap ncc = null;
        if (rs.next()) {
            String ten = rs.getString(2);
            String email = rs.getString(3);
            String dienthoai = rs.getString(4);
            String mota = rs.getString(5);

            ncc=new NhaCungCap(id, ten, email, dienthoai, mota);
        }
        rs.close();
        ps.close();
        con.close();
        return ncc;
    }
}
