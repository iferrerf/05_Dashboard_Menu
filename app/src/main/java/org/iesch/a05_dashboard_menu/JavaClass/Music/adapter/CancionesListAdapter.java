package org.iesch.a05_dashboard_menu.JavaClass.Music.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.iesch.a05_dashboard_menu.JavaClass.Music.model.Cancion;
import org.iesch.a05_dashboard_menu.R;

import java.util.ArrayList;

public class CancionesListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Cancion> cancionList;
    private int layoutId;

    public CancionesListAdapter(Context context, ArrayList<Cancion> cancionList, int layoutId) {
        this.context = context;
        this.cancionList = cancionList;
        this.layoutId = layoutId;
    }

    @Override
    public int getCount() {
        return cancionList.size();
    }

    @Override
    public Object getItem(int i) {
        return cancionList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final Cancion cancion = (Cancion) getItem(i);

        view = LayoutInflater.from(context).inflate(R.layout.cancion_list_item, null);
        TextView cancionIdTextView = view.findViewById(R.id.cancion_list_item_id_textView);
        TextView cancionNameTextView = view.findViewById(R.id.cancion_list_item_name_textView);
        TextView cancionAutorTextView = view.findViewById(R.id.cancion_list_item_autor_textView);
        TextView cancionDateTextView = view.findViewById(R.id.cancion_list_item_date_textView);
        ImageView cancionTypeImageView = view.findViewById(R.id.cancion_list_item_type_image);

        try {
            cancionIdTextView.setText(String.valueOf(cancion.getId()));
            cancionNameTextView.setText(cancion.getName());
            cancionAutorTextView.setText(cancion.getAutor());
            cancionDateTextView.setText(cancion.getDate());
        }catch (Exception e){

        }



        final Cancion.Type type = cancion.getType();

        switch (type){
            case POP:
                cancionTypeImageView.setImageResource(R.drawable.pop);
                break;
            case ELECTRONIC:
                cancionTypeImageView.setImageResource(R.drawable.electronic);
                break;
            case JAZZ:
                cancionTypeImageView.setImageResource(R.drawable.jazz);
                break;
            case ROCK:
                cancionTypeImageView.setImageResource(R.drawable.rock);
                break;
            case FLAMENCO:
                cancionTypeImageView.setImageResource(R.drawable.flamenco);
                break;
        }

        return view;
    }
}
