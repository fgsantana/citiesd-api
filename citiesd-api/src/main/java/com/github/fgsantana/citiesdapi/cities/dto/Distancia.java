package com.github.fgsantana.citiesdapi.cities.dto;

public class Distancia {
    private String message;
    private Double distancia;
    private String unidade;



    public Distancia(String cityX, String cityY, Double distancia, String unidade) {
        this.message = "Distância entre " + cityX + " e " + cityY;
        this.distancia = distancia;
        this.unidade = unidade;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Double getDistancia() {
        return distancia;
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
