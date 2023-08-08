/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.DiaDiemDAO;
import controller.LichTrinhDAO;
import java.sql.SQLException;

/**
 *
 * @author AD
 */
public class LichTrinhDiaDiem {
    private LichTrinh lt;
    private DiaDiem dd;

    public LichTrinhDiaDiem() {
    }

    public LichTrinhDiaDiem(int ltId, int ddId) throws SQLException, ClassNotFoundException {
        this.lt = new LichTrinhDAO().getLichTrinhById(ltId);
        this.dd = new DiaDiemDAO().getDiaDiemById(ddId);
    }

    public LichTrinh getLt() {
        return lt;
    }

    public void setLt(LichTrinh lt) {
        this.lt = lt;
    }

    public DiaDiem getDd() {
        return dd;
    }

    public void setDd(DiaDiem dd) {
        this.dd = dd;
    }
}
