package com.github.fgsantana.citiesdapi.cities.dto;

public class Distancia {
    private Double distancia;
    private String unidade;

    public Distancia(Double distancia, String unidade) {
        this.distancia = distancia;
        this.unidade = unidade;
    }

    public Double getDistancia() {
        return this.distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
}
