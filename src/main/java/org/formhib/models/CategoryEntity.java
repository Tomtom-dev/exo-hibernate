package org.formhib.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="categorie", schema = "materiel_location")
public class CategoryEntity {
    // code libelle
    private int code;
    private String libelle;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

}
