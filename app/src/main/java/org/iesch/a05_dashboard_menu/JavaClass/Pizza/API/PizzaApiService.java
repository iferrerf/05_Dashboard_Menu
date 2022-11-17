package org.iesch.a05_dashboard_menu.JavaClass.Pizza.API;

import org.iesch.a05_dashboard_menu.JavaClass.Pizza.PizzaRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PizzaApiService {

    @GET("/v2/pizzas")
    Call<PizzaRespuesta> obtenerListaPizzas(@Query("limit") int limit, @Query("offset") int offset);
}