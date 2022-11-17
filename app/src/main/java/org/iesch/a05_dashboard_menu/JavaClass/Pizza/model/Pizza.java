package org.iesch.a05_dashboard_menu.JavaClass.Pizza.model;

import com.google.gson.annotations.SerializedName;

public class Pizza {
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("image")
    private String urlPizza;
    @SerializedName("id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pizza(String name, String description, String urlPizza, int id) {
        this.name = name;
        this.description = description;
        this.urlPizza = urlPizza;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", urlPizza='" + urlPizza + '\'' +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String descripcion) {
        this.description = descripcion;
    }

    public String getUrlPizza() {
        return urlPizza;
    }

    public void setUrlPizza(String urlPizza) {
        this.urlPizza = urlPizza;
    }
}
