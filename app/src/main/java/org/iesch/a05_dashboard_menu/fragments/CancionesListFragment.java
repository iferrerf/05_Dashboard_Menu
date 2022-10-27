package org.iesch.a05_dashboard_menu.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import org.iesch.a05_dashboard_menu.Interface.iComunicaMusicFragments;
import org.iesch.a05_dashboard_menu.JavaClass.Music.adapter.CancionesListAdapter;
import org.iesch.a05_dashboard_menu.JavaClass.Music.model.Cancion;
import org.iesch.a05_dashboard_menu.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CancionesListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CancionesListFragment extends Fragment {

    // Declaraciones necesarias
    private ListView lvCancion;
    private CancionesListAdapter adaptador;
    private ArrayList<Cancion> cancionList = new ArrayList<>();
    public View view;
    // declaro la interfaz que voy a utilizar
    iComunicaMusicFragments interfaz;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CancionesListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        interfaz = (iComunicaMusicFragments) context;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CancionesListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CancionesListFragment newInstance(String param1, String param2) {
        CancionesListFragment fragment = new CancionesListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_canciones_list, container,  false);
        lvCancion = view.findViewById(R.id.listaCanciones);
        cancionList.add(new Cancion(1, "All Day And Night", "Boostereo", "2022", Cancion.Type.ELECTRONIC, R.raw.all_day_and_nigth, R.drawable.all_day_and_night_img));
        cancionList.add(new Cancion(2, "Camiseta De Rokanrol", "Estopa y Fito", "2019", Cancion.Type.POP, R.raw.camiseta_de_rokanrol, R.drawable.camiseta_de_rokanrol_img));
        cancionList.add(new Cancion(3, "Carretera Y Manta", "Pablo Alborán", "2022", Cancion.Type.POP, R.raw.carretera_y_manta, R.drawable.carretera_y_manta_img));
        cancionList.add(new Cancion(4, "Despecha", "Rosalía", "2022", Cancion.Type.FLAMENCO, R.raw.despecha, R.drawable.despecha_img));
        cancionList.add(new Cancion(5, "Jindama", "Marea", "2001", Cancion.Type.ROCK, R.raw.jindama, R.drawable.jindama_img));
        cancionList.add(new Cancion(6, "La Musiquita", "Naviles de Novelda", "2022", Cancion.Type.FLAMENCO, R.raw.la_musiquita, R.drawable.la_musiquita_img));
        cancionList.add(new Cancion(7, "Light", "Eqric", "2022", Cancion.Type.ELECTRONIC, R.raw.light, R.drawable.light_img));
        cancionList.add(new Cancion(8, "Long Tall Sally", "Little Richard", "2022", Cancion.Type.JAZZ, R.raw.long_tall_sally, R.drawable.long_tall_saly_img));
        cancionList.add(new Cancion(9, "Me Encanta", "Naviles de Novelda", "2021", Cancion.Type.FLAMENCO, R.raw.me_encanta, R.drawable.me_encanta_img));
        cancionList.add(new Cancion(10, "Your Love", "Eqric", "2022", Cancion.Type.ELECTRONIC, R.raw.your_love, R.drawable.your_love_img));

        adaptador = new CancionesListAdapter(getActivity(), cancionList, R.id.cancion_list_fragment);
        lvCancion.setAdapter(adaptador);

        lvCancion.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> {
            Cancion selectedCancion = (Cancion) adaptador.getItem(position);
            if (selectedCancion != null){
                //Toast.makeText(getActivity(), selectedCancion.getName(), Toast.LENGTH_SHORT).show();
                interfaz.enviarCancion(selectedCancion);
            }
        });

        return view;

    }
}