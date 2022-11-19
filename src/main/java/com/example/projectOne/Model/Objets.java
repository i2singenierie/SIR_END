package com.example.projectOne.Model;

public class Objets {
    private Integer a;
    private Integer b;

    private Double x;
    private Double y;

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Objets(Integer a, Integer b, Double x, Double y) {
        this.a = a;
        this.b = b;
        this.x = x;
        this.y = y;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    public Objets() {
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Objets{" +
                "a=" + a +
                ", b=" + b +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
