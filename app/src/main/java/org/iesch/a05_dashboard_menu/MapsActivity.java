package org.iesch.a05_dashboard_menu;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.iesch.a05_dashboard_menu.JavaClass.Maps.model.IES;
import org.iesch.a05_dashboard_menu.databinding.ActivityMapsBinding;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity<onMapReady> extends FragmentActivity implements OnMapReadyCallback{

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    // Creo una lista de institutos
    private List<IES> listaInstitutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.mapas_title);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addInstituto();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    // Añado un metodo para crear institutos aleatorios
    private void addInstituto(){
        listaInstitutos = new ArrayList<>();

        listaInstitutos.add(new IES("IES Segundo de Chomón", 40.32800138274268, -1.09780059533068));
        listaInstitutos.add(new IES("IES Santa Emerenciana", 40.334362437738754, -1.1062259882530376));
        listaInstitutos.add(new IES("IES Vega del Turia", 40.342513592820964, -1.1088184164648198));
        listaInstitutos.add(new IES("IES Francés de Aranda", 40.35199435451252, -1.1101224293644023));
        listaInstitutos.add(new IES("CIFP San Blas", 40.353611272895954, -1.1668733307851775));
        listaInstitutos.add(new IES("CIFP Escuela de Hostelería y Turismo Teruel", 40.34345882207552, -1.1075273619856685));
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Creamos un objeto de tipo LatLng
        LatLng teruel = new LatLng(40.34215462530947, -1.1071156044052786);

        BitmapDescriptor taco = BitmapDescriptorFactory.fromResource(R.drawable.school);

        // 4 - Creamos un marcador para cada restaurante
        for (IES r: listaInstitutos){
            LatLng posicion = new LatLng(r.getLatitud(),r.getLongitud());
            String nombre = r.getNombre().toString();

            mMap.addMarker(new MarkerOptions()
                    .position(posicion)

                    .title(nombre));

            int iconId = 0;
            switch (nombre) {
                case "IES Segundo de Chomón":
                case "IES Santa Emerenciana":
                case "IES Francés de Aranda":
                case "IES Vega del Turia":
                    iconId = R.drawable.school;
                    break;
                case "CIFP San Blas":
                    iconId = R.drawable.tractor;
                    break;
                case "CIFP Escuela de Hostelería y Turismo Teruel":
                    iconId = R.drawable.cocina;
                    break;

            }

            mMap.addMarker(new MarkerOptions().position(posicion).icon(bitmapDescriptorFromVector(this, iconId)).title(nombre));

        }

        // Le dice al mapa que mueva la camara
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(teruel,14.0f));
    }

    @NonNull
    private BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }


}