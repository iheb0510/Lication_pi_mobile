/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author ASUS
 */
public class Location {
     private int id_loc;
    private Date start_l;
   private  Date end_l;
    private double montant;
    private Produit p;
    private User c;

    public Location(int id_loc, Date start_l, Date end_l, double montant, Produit p, User c) {
        this.id_loc = id_loc;
        this.start_l = start_l;
        this.end_l = end_l;
        this.montant = montant;
        this.p = p;
        this.c = c;
    }

    public Location(Date start_l, Date end_l, double montant, Produit p, User c) {
        this.start_l = start_l;
        this.end_l = end_l;
        this.montant = montant;
        this.p = p;
        this.c = c;
    }

    public Location(Date start_l, Date end_l, Produit p, User c) {
        this.start_l = start_l;
        this.end_l = end_l;
        this.p = p;
        this.c = c;
    }

    public Location() {
    }

    public int getId_loc() {
        return id_loc;
    }

    public void setId_loc(int id_loc) {
        this.id_loc = id_loc;
    }

    public Date getStart_l() {
        return start_l;
    }

    public void setStart_l(Date start_l) {
        this.start_l = start_l;
    }

    public Date getEnd_l() {
        return end_l;
    }

    public void setEnd_l(Date end_l) {
        this.end_l = end_l;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Produit getP() {
        return p;
    }

    public void setP(Produit p) {
        this.p = p;
    }

    public User getC() {
        return c;
    }

    public void setC(User c) {
        this.c = c;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id_loc;
        hash = 79 * hash + Objects.hashCode(this.start_l);
        hash = 79 * hash + Objects.hashCode(this.end_l);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.montant) ^ (Double.doubleToLongBits(this.montant) >>> 32));
        hash = 79 * hash + Objects.hashCode(this.p);
        hash = 79 * hash + Objects.hashCode(this.c);
        return hash;
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
        final Location other = (Location) obj;
        if (this.id_loc != other.id_loc) {
            return false;
        }
        if (Double.doubleToLongBits(this.montant) != Double.doubleToLongBits(other.montant)) {
            return false;
        }
        if (!Objects.equals(this.start_l, other.start_l)) {
            return false;
        }
        if (!Objects.equals(this.end_l, other.end_l)) {
            return false;
        }
        if (!Objects.equals(this.p, other.p)) {
            return false;
        }
        if (!Objects.equals(this.c, other.c)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Location{" + "id_loc=" + id_loc + ", start_l=" + start_l + ", end_l=" + end_l + ", montant=" + montant + ", p=" + p + ", c=" + c + '}';
    }

    public Location(int id_loc) {
        this.id_loc = id_loc;
    }

   

   
    
    
    
    
    
}
