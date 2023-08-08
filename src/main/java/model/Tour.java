/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.DiaDiemDAO;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AD
 */
public class Tour {

    private int id;
    private String name;
    private DiaDiem noiden, noixuatphat;
    private String mota;
    public Tour() {
    }
    DiaDiemDAO dddao = new DiaDiemDAO();

    public Tour(int id, String name, int idNoiDen, int idNoixuatphat, String mota) throws SQLException, SQLException, ClassNotFoundException {
        this.id = id;
        this.name = name;
        this.noiden = dddao.getDiaDiemById(idNoiDen);
        this.noixuatphat = dddao.getDiaDiemById(idNoixuatphat);
        this.mota=mota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DiaDiem getNoiden() {
        return noiden;
    }

    public void setNoiden(DiaDiem noiden) {
        this.noiden = noiden;
    }

    public DiaDiem getNoixuatphat() {
        return noixuatphat;
    }

    public void setNoixuatphat(DiaDiem noixuatphat) {
        this.noixuatphat = noixuatphat;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    @Override
    public int hashCode() {
        try {
            return Objects.hash(new Tour(id, name, noiden.getId(), noixuatphat.getId(), mota));
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
        final Tour other = (Tour) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.mota, other.mota)) {
            return false;
        }
        if (!Objects.equals(this.noiden, other.noiden)) {
            return false;
        }
        if (!Objects.equals(this.noixuatphat, other.noixuatphat)) {
            return false;
        }
        if (!Objects.equals(this.dddao, other.dddao)) {
            return false;
        }
        return true;
    }
    
}
