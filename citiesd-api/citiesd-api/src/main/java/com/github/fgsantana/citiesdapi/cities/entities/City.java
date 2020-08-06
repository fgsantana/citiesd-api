//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.github.fgsantana.citiesdapi.cities.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.github.fgsantana.citiesdapi.cities.types.PointType;
import com.github.fgsantana.citiesdapi.states.entities.State;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.geo.Point;

@Entity
@Table(
        name = "cidade"
)
@TypeDefs({@TypeDef(
        name = "point",
        typeClass = PointType.class
)})
public class City {
    @Id
    private Long id;
    @Column(
            name = "nome"
    )
    private String name;
    private int ibge;
    @ManyToOne
    @JoinColumn(
            name = "uf",
            referencedColumnName = "id"
    )
    private State state;
    @Type(
            type = "point"
    )
    @Column(
            name = "lat_lon",
            updatable = false,
            insertable = false
    )
    private Point location;

    public City() {
    }

    public State getState() {
        return this.state;
    }

    public void setState(State state) {
        this.state = state;
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

    public int getIbge() {
        return this.ibge;
    }

    public void setIbge(int ibge) {
        this.ibge = ibge;
    }

    public Point getLocation() {
        return this.location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }
}
