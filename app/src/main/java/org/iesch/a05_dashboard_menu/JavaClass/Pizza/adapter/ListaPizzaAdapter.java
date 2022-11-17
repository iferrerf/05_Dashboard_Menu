package org.iesch.a05_dashboard_menu.JavaClass.Pizza.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.iesch.a05_dashboard_menu.JavaClass.Pizza.model.Pizza;
import org.iesch.a05_dashboard_menu.R;

import java.util.ArrayList;
import java.util.List;

public class ListaPizzaAdapter extends RecyclerView.Adapter<ListaPizzaAdapter.ViewHolder> {


    // Creamos la lista de pizzas y el contexto
    private List<Pizza> listaPizzas;
    private Context context;

    public ListaPizzaAdapter(Context context) {
        // Creamos constructor donde le pasamos el contexto e instanciamos la lista de pizzas
        this.context = context;
        this.listaPizzas = new ArrayList<>();
    }

    @NonNull
    @Override
    public ListaPizzaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Creamos una vista inflando item_restaurantes desde el parent
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_restaurante, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaPizzaAdapter.ViewHolder holder, int position) {
        // Cargamos el nombre y la descripcion de cada pizza
        Pizza pizza = listaPizzas.get(position);

        Log.i("PIZZA", "onResponse: "+ pizza.toString());

        holder.nombreTextView.setText(pizza.getName());
        holder.descripcionTextView.setText(pizza.getDescription());

        // FALTA LA IMAGEN
        Glide.with(context)
                .load(pizza.getUrlPizza())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.fotoImageView);
    }

    @Override
    public int getItemCount() {
        // Devolvemos la longitud de la lista de pizzas
        return listaPizzas.size();
    }

    // Permitimos que el Arraylist que llega lo junte con el arraylist del adaptador
    public void adicionarPizza(List<Pizza> listaPizzas) {
        this.listaPizzas.addAll(listaPizzas);
        // Con este metodo actualizaremos el recyclerView en la pantalla
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        // Creamos los elementos donde mostraremos contenido
        private ImageView fotoImageView;
        private TextView nombreTextView;
        private TextView descripcionTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Asignamos los elementos creados con los que tenemos en el item_restaurantes.xml
            fotoImageView = itemView.findViewById(R.id.fotoPizzaImageView);
            nombreTextView = itemView.findViewById(R.id.nombrePizzaTextView);
            descripcionTextView = itemView.findViewById(R.id.descipcionPizzaTextView);
        }
    }
}

