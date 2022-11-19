package com.example.projectOne.Model;

public class Obj_pkd_pkf_route {

        private Double pkd;
        private Double pkf;
        private String route;

    public Obj_pkd_pkf_route(Double pkd, Double pkf, String route) {
        this.pkd = pkd;
        this.pkf = pkf;
        this.route = route;
    }

    public Obj_pkd_pkf_route() {
    }

    public Double getPkd() {
        return pkd;
    }

    public void setPkd(Double pkd) {
        this.pkd = pkd;
    }

    public Double getPkf() {
        return pkf;
    }

    public void setPkf(Double pkf) {
        this.pkf = pkf;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "Obj_pkd_pkf_route{" +
                "pkd=" + pkd +
                ", pkf=" + pkf +
                ", route='" + route + '\'' +
                '}';
    }
}

