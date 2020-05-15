/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Objects;

/**
 *
 * @author ASUS
 */
public class Magasin {
     private int id;
   private String name_M;
   private String adresse;
   private int tel;
   private Region R;

    public Magasin(int id, String name_M, String adresse, int tel, Region R) {
        this.id = id;
        this.name_M = name_M;
        this.adresse = adresse;
        this.tel = tel;
        this.R = R;
    }

    public Magasin(String name_M, String adresse, int tel, Region R) {
        this.name_M = name_M;
        this.adresse = adresse;
        this.tel = tel;
        this.R = R;
    }

    public Magasin() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_M() {
        return name_M;
    }

    public void setName_M(String name_M) {
        this.name_M = name_M;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public Region getR() {
        return R;
    }

    public void setR(Region R) {
        this.R = R;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.id;
        hash = 83 * hash + Objects.hashCode(this.name_M);
        hash = 83 * hash + Objects.hashCode(this.adresse);
        hash = 83 * hash + this.tel;
        hash = 83 * hash + Objects.hashCode(this.R);
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
        final Magasin other = (Magasin) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.tel != other.tel) {
            return false;
        }
        if (!Objects.equals(this.name_M, other.name_M)) {
            return false;
        }
        if (!Objects.equals(this.adresse, other.adresse)) {
            return false;
        }
        if (!Objects.equals(this.R, other.R)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Magasin{" + "id=" + id + ", name_M=" + name_M + ", adresse=" + adresse + ", tel=" + tel + ", R=" + R + '}';
    }
   
   
}
