package org.iesch.a05_dashboard_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import org.iesch.a05_dashboard_menu.JavaClass.Pizza.API.PizzaApiService;
import org.iesch.a05_dashboard_menu.JavaClass.Pizza.PizzaRespuesta;
import org.iesch.a05_dashboard_menu.JavaClass.Pizza.adapter.ListaPizzaAdapter;
import org.iesch.a05_dashboard_menu.JavaClass.Pizza.model.Pizza;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestaurantesActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private RecyclerView recyclerView;
    private ListaPizzaAdapter listaPizzaAdapter;

    private int offset;

    private boolean aptoParaCargar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurantes);
        setTitle(R.string.restaurantes_title);

        recyclerView = findViewById(R.id.recyclerView);
        listaPizzaAdapter = new ListaPizzaAdapter(this);
        recyclerView.setAdapter(listaPizzaAdapter);

        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);

        // El RecyclerView detecta el movimiento con este Scroll
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                // Hacemos una serie de preguntas para preguntar si el scroll es hacia abajo y llegó al ultimo item
                int visibleItemCount = layoutManager.getChildCount();
                int totalItemCount = layoutManager.getItemCount();
                int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();
                //Creo aptoparaCargar para controlar las llamadas a la API
                if (aptoParaCargar){
                    if ((visibleItemCount + pastVisibleItems) >= totalItemCount){
                        Log.i("PIZZA","Llegamos al Final");
                        aptoParaCargar = false;
                        offset += 20;
                        obtenerDatos(offset);
                    }
                }

            }
        });

        retrofit = new Retrofit.Builder()
                .baseUrl("http://private-3cc5a4-codingpizza.apiary-mock.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        aptoParaCargar=true;
        offset=0;
        obtenerDatos(offset);

    }

    private void obtenerDatos(int offset){
        PizzaApiService service = retrofit.create(PizzaApiService.class);

        Call<PizzaRespuesta> pizzaRespuestaCall = service.obtenerListaPizzas(4, offset);

        pizzaRespuestaCall.enqueue(new Callback<PizzaRespuesta>() {
            @Override
            public void onResponse(Call<PizzaRespuesta> call, Response<PizzaRespuesta> response) {

                aptoParaCargar = true;
                if (response.isSuccessful()){
                    PizzaRespuesta pizzaRespuesta = response.body();

                    ArrayList<Pizza> listaPizza = pizzaRespuesta.getResults();

                    // Cuando recibimos los datos ya no los mostramos por consola
                    // se los mandamos al adaptador por medio de un metodo
                    listaPizzaAdapter.adicionarPizza(listaPizza);

                }else{
                    Log.i("PIZZA", "onResponse: "+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<PizzaRespuesta> call, Throwable t) {
                aptoParaCargar = true;
                Log.i("PIZZA", "onFailure: "+t.getMessage());
            }
        });
    }
}