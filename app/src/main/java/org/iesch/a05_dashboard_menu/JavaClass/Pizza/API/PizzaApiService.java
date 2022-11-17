package org.iesch.a05_dashboard_menu.JavaClass.Pizza.API;

import org.iesch.a05_dashboard_menu.JavaClass.Pizza.model.Pizza;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PizzaApiService {

    @GET("pizzas")
    Call<List<Pizza>> obtenerListaPizzas();
}