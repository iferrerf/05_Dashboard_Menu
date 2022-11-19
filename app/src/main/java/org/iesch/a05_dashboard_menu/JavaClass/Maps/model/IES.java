package org.iesch.a05_dashboard_menu.JavaClass.Maps.model;

public class IES {

    private String nombre;
    private Double latitud;
    private Double longitud;

    public IES(String nombre, Double latitud, Double longitud) {
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getLatitud() {
        return latitud;
    }

    public Double getLongitud() {
        return longitud;
    }


}
