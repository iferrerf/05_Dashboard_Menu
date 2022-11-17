package org.iesch.a05_dashboard_menu.JavaClass.Pizza;

import org.iesch.a05_dashboard_menu.JavaClass.Pizza.model.Pizza;

import java.util.ArrayList;

public class PizzaRespuesta {

    // 5 - Tenemos que poner los atributos de aquella informacion que nos interesa del JSON
    // en nuestro caso nos interesan los results
    private ArrayList<Pizza> results;

    public ArrayList<Pizza> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pizza> results) {
        this.results = results;
    }
}