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
public class Produit {
    
     private int id;
    private String Ref_produit;
    private String Designation;
    private String Description;
    private Boolean Disponible;
    private double prix;
    private String image;
    private boolean Statut;
    private Magasin M;
    private double prix_heure;

    public Produit(int id, String Ref_produit, String Designation, String Description, Boolean Disponible, double prix, String image, boolean Statut, Magasin M, double prix_heure) {
        this.id = id;
        this.Ref_produit = Ref_produit;
        this.Designation = Designation;
        this.Description = Description;
        this.Disponible = Disponible;
        this.prix = prix;
        this.image = image;
        this.Statut = Statut;
        this.M = M;
        this.prix_heure = prix_heure;
    }

    public Produit(String Ref_produit, String Designation, String Description, Boolean Disponible, double prix, String image, boolean Statut, Magasin M, double prix_heure) {
        this.Ref_produit = Ref_produit;
        this.Designation = Designation;
        this.Description = Description;
        this.Disponible = Disponible;
        this.prix = prix;
        this.image = image;
        this.Statut = Statut;
        this.M = M;
        this.prix_heure = prix_heure;
    }

    public Produit() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRef_produit() {
        return Ref_produit;
    }

    public void setRef_produit(String Ref_produit) {
        this.Ref_produit = Ref_produit;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String Designation) {
        this.Designation = Designation;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Boolean getDisponible() {
        return Disponible;
    }

    public void setDisponible(Boolean Disponible) {
        this.Disponible = Disponible;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isStatut() {
        return Statut;
    }

    public void setStatut(boolean Statut) {
        this.Statut = Statut;
    }

    public Magasin getM() {
        return M;
    }

    public void setM(Magasin M) {
        this.M = M;
    }

    public double getPrix_heure() {
        return prix_heure;
    }

    public void setPrix_heure(double prix_heure) {
        this.prix_heure = prix_heure;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.Ref_produit);
        hash = 29 * hash + Objects.hashCode(this.Designation);
        hash = 29 * hash + Objects.hashCode(this.Description);
        hash = 29 * hash + Objects.hashCode(this.Disponible);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.prix) ^ (Double.doubleToLongBits(this.prix) >>> 32));
        hash = 29 * hash + Objects.hashCode(this.image);
        hash = 29 * hash + (this.Statut ? 1 : 0);
        hash = 29 * hash + Objects.hashCode(this.M);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.prix_heure) ^ (Double.doubleToLongBits(this.prix_heure) >>> 32));
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
        final Produit other = (Produit) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.prix) != Double.doubleToLongBits(other.prix)) {
            return false;
        }
        if (this.Statut != other.Statut) {
            return false;
        }
        if (Double.doubleToLongBits(this.prix_heure) != Double.doubleToLongBits(other.prix_heure)) {
            return false;
        }
        if (!Objects.equals(this.Ref_produit, other.Ref_produit)) {
            return false;
        }
        if (!Objects.equals(this.Designation, other.Designation)) {
            return false;
        }
        if (!Objects.equals(this.Description, other.Description)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        if (!Objects.equals(this.Disponible, other.Disponible)) {
            return false;
        }
        if (!Objects.equals(this.M, other.M)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", Ref_produit=" + Ref_produit + ", Designation=" + Designation + ", Description=" + Description + ", Disponible=" + Disponible + ", prix=" + prix + ", image=" + image + ", Statut=" + Statut + ", M=" + M + ", prix_heure=" + prix_heure + '}';
    }

   
   
    
}
