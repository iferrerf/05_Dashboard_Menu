package org.iesch.a05_dashboard_menu.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.iesch.a05_dashboard_menu.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailMusicFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailMusicFragment extends Fragment {

    // Declaraciones
    private ImageView detailImageView;
    private static boolean musicAciva = false;
    private MediaPlayer mediaPlayer;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DetailMusicFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailMusicFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailMusicFragment newInstance(String param1, String param2) {
        DetailMusicFragment fragment = new DetailMusicFragment();
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

    public void setCancionImage(int cancionImageId) {
        detailImageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), cancionImageId));
    }

    public void playCancionSound(int cancionSoundId) {

        try {
            mediaPlayer.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }

        mediaPlayer = MediaPlayer.create(getActivity(), cancionSoundId);
        mediaPlayer.start();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail_music, container, false);
        detailImageView = view.findViewById(R.id.cancion_detail_imageView);
        return view;
    }
}