package org.iesch.a05_dashboard_menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import org.iesch.a05_dashboard_menu.JavaClass.Pizza.API.PizzaApiService;
import org.iesch.a05_dashboard_menu.JavaClass.Pizza.adapter.ListaPizzaAdapter;
import org.iesch.a05_dashboard_menu.JavaClass.Pizza.model.Pizza;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PizzasActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private RecyclerView recyclerView;
    private ListaPizzaAdapter listaPizzaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzas);
        setTitle(R.string.pizza_title);

        recyclerView = findViewById(R.id.recyclerView);
        listaPizzaAdapter = new ListaPizzaAdapter(this);
        recyclerView.setAdapter(listaPizzaAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://private-anon-2da0e872d7-codingpizza.apiary-mock.com/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        obtenerDatos();

    }

    private void obtenerDatos(){
        PizzaApiService service = retrofit.create(PizzaApiService.class);

        Call<List<Pizza>> pizzaRespuestaCall = service.obtenerListaPizzas();

        pizzaRespuestaCall.enqueue(new Callback<List<Pizza>>() {
            @Override
            public void onResponse(Call<List<Pizza>> call, Response<List<Pizza>> response) {

                if (response.isSuccessful()){

                    Log.i("PIZZA", "onResponse: "+response.body().toString());

                    // Cuando recibimos los datos ya no los mostramos por consola
                    // se los mandamos al adaptador por medio de un metodo
                    listaPizzaAdapter.adicionarPizza(response.body());

                }else{
                    Log.i("PIZZA", "onResponse: "+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<Pizza>> call, Throwable t) {
                Log.i("PIZZA", "onFailure: "+t.getMessage());
            }
        });
    }
}