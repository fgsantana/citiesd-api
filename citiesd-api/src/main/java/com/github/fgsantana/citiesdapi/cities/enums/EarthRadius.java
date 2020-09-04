package com.github.fgsantana.citiesdapi.cities.enums;

public enum EarthRadius {
    METERS("m", 6378168.0F),
    KILOMETERS("km", 6378.168F),
    MILES("mi", 3958.7478F);

    private final String unit;
    private final float value;

    private EarthRadius(final String unit, final float value) {
        this.unit = unit;
        this.value = value;
    }

    public float getValue() {
        return this.value;
    }

    public String getUnit() {
        return this.unit;
    }
}
