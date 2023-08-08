/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.TourDAO;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AD
 */
public class LichTrinh {
    private int id;
    private Tour tour;

    public LichTrinh() {
    }

    public LichTrinh(int id, int tourId) throws SQLException, ClassNotFoundException {
        this.id = id;
        this.tour=new TourDAO().getTourbyId(tourId);
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    @Override
    public int hashCode() {
        try {
            return Objects.hash(new LichTrinh(id, tour.getId()));
        } catch (SQLException ex) {
            Logger.getLogger(LichTrinh.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LichTrinh.class.getName()).log(Level.SEVERE, null, ex);
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
        final LichTrinh other = (LichTrinh) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.tour, other.tour)) {
            return false;
        }
        return true;
    }
    
    
    
}
