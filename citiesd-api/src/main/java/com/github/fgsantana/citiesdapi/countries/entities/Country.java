package com.github.fgsantana.citiesdapi.countries.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
        name = "pais"
)
public class Country {
    @Id
    @Column(
            name = "id"
    )
    private Long id;
    @Column(
            name = "nome"
    )
    private String name;
    @Column(
            name = "nome_pt"
    )
    private String ptName;
    @Column(
            name = "sigla"
    )
    private String initials;
    private String bacen;

    public Country() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPtName() {
        return this.ptName;
    }

    public void setPtName(String ptName) {
        this.ptName = ptName;
    }

    public String getInitials() {
        return this.initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getBacen() {
        return this.bacen;
    }

    public void setBacen(String bacen) {
        this.bacen = bacen;
    }
}
