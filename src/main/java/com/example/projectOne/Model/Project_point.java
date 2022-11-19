package com.example.projectOne.Model;

public class Project_point {
   private Integer id_layer;
   private Double x;
   private Double y;
   private Integer geom_format;

    public Project_point(Integer id_layer, Double x, Double y, Integer geom_format) {
        this.id_layer = id_layer;
        this.x = x;
        this.y = y;
        this.geom_format = geom_format;
    }

    public Project_point() {
    }

    public Integer getId_layer() {
        return id_layer;
    }

    public void setId_layer(Integer id_layer) {
        this.id_layer = id_layer;
    }

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

    public Integer getGeom_format() {
        return geom_format;
    }

    public void setGeom_format(Integer geom_format) {
        this.geom_format = geom_format;
    }

    @Override
    public String toString() {
        return "Project_point{" +
                "id_layer=" + id_layer +
                ", x=" + x +
                ", y=" + y +
                ", geom_format=" + geom_format +
                '}';
    }
}
