/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.DichVuDAO;
import controller.LichTrinhDAO;
import controller.NhaCungCapDAO;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.KeyCode;

/**
 *
 * @author AD
 */
public class DichVuCungCap {

    private int id;
    private DichVu dv;
    private NhaCungCap ncc;
    private LichTrinh lt;
    private double dongia;

    public DichVuCungCap() {
    }

    public DichVuCungCap(int id, int dvId, int nccId, int ltId, double dongia) throws SQLException, ClassNotFoundException {
        this.id = id;
        this.dv = new DichVuDAO().getDichVuById(dvId);
        this.ncc = new NhaCungCapDAO().getNCCById(nccId);
        this.lt = new LichTrinhDAO().getLichTrinhById(ltId);
        this.dongia = dongia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DichVu getDv() {
        return dv;
    }

    public void setDv(DichVu dv) {
        this.dv = dv;
    }

    public NhaCungCap getNcc() {
        return ncc;
    }

    public void setNcc(NhaCungCap ncc) {
        this.ncc = ncc;
    }

    public LichTrinh getLt() {
        return lt;
    }

    public void setLt(LichTrinh lt) {
        this.lt = lt;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    @Override
    public int hashCode() {

        try {
            return Objects.hash(new DichVuCungCap(id, dv.getId(), ncc.getId(), lt.getId(), dongia));
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DichVuCungCap other = (DichVuCungCap) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.dongia) != Double.doubleToLongBits(other.dongia)) {
            return false;
        }
        if (!Objects.equals(this.dv, other.dv)) {
            return false;
        }
        if (!Objects.equals(this.ncc, other.ncc)) {
            return false;
        }
        if (!Objects.equals(this.lt, other.lt)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DichVuCungCap{" + "id=" + id + ", dv=" + dv + ", ncc=" + ncc + ", lt=" + lt + ", dongia=" + dongia + '}';
    }
    
}
