package org.iesch.a05_dashboard_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Toast;

import org.iesch.a05_dashboard_menu.Interface.iComunicaMusicFragments;
import org.iesch.a05_dashboard_menu.JavaClass.Music.model.Cancion;
import org.iesch.a05_dashboard_menu.fragments.DetailMusicFragment;

public class MusicListActivity extends AppCompatActivity implements iComunicaMusicFragments {

    DetailMusicFragment detalleFragmentCancion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_list);
        setTitle(R.string.music_title);

    }

    @Override
    public void enviarCancion(Cancion cancion) {
        Toast.makeText(this, cancion.getName(), Toast.LENGTH_SHORT).show();

        detalleFragmentCancion = (DetailMusicFragment) getSupportFragmentManager().findFragmentById(R.id.cancion_detail_fragment);

        detalleFragmentCancion.setCancionImage(cancion.getImageId());
        detalleFragmentCancion.playCancionSound(cancion.getSoundId());
    }


}