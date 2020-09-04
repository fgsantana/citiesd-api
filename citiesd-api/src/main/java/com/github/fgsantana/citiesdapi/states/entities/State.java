

package com.github.fgsantana.citiesdapi.states.entities;

import com.github.fgsantana.citiesdapi.countries.entities.Country;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

@Entity
@Table(
        name = "estado"
)
@TypeDefs({@TypeDef(
        name = "jsonb",
        typeClass = JsonBinaryType.class
)})
public class State {
    @Id
    private Long id;
    @Column(
            name = "nome"
    )
    private String name;
    private String uf;
    private int ibge;
    @ManyToOne
    @JoinColumn(
            name = "pais",
            referencedColumnName = "id"
    )
    private Country country;
    @Type(
            type = "jsonb"
    )
    @Basic(
            fetch = FetchType.LAZY
    )
    @Column(
            name = "ddd",
            columnDefinition = "jsonb"
    )
    private List<Integer> ddd;

    public State() {
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

    public String getUf() {
        return this.uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public int getIbge() {
        return this.ibge;
    }

    public void setIbge(int ibge) {
        this.ibge = ibge;
    }

    public Country getCountry() {
        return this.country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Integer> getDdd() {
        return this.ddd;
    }

    public void setDdd(List<Integer> ddd) {
        this.ddd = ddd;
    }
}
