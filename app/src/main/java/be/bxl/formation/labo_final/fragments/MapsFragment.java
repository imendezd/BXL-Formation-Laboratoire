package be.bxl.formation.labo_final.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import be.bxl.formation.labo_final.R;

public class MapsFragment extends Fragment {

    public MapsFragment() {
        // Required empty public constructor
    }

    public static MapsFragment newInstance() { return new MapsFragment(); }

    public void onCreate(Bundle savedInstanceState) { MapsFragment.super.onCreate(savedInstanceState); }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }

    private OnMapReadyCallback callback = googleMap -> {
        //TODO add with loop every location
        /*
        for (){
        * LatLng place = new LatLng(latitude, longitude);
        * googleMap.addMarker(new MarkerOptions().position(place).title(placeName));
        * googleMap.moveCamera(CameraUpdateFactory.newLatLng(palce));
        * }
        */
        LatLng teide = new LatLng(28.271, -16.644);
        googleMap.addMarker(new MarkerOptions().position(teide).title("Teide National Park"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(teide));

        LatLng grandPlace = new LatLng(50.847, 4.352);
        googleMap.addMarker(new MarkerOptions().position(grandPlace).title("Grand Place"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(grandPlace));

        LatLng stocletHouse = new LatLng(50.835, 4.416);
        googleMap.addMarker(new MarkerOptions().position(stocletHouse).title("Stoclet House"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(stocletHouse));

        LatLng horta = new LatLng(50.828, 4.362);
        googleMap.addMarker(new MarkerOptions().position(horta).title("Major Town Houses of the Architect Victor Horta (Brussels)"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(horta));

        LatLng brugge = new LatLng(51.209, 3.225);
        googleMap.addMarker(new MarkerOptions().position(brugge).title("Historic Centre of Brugge"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(brugge));

        LatLng platinMoretus = new LatLng(51.218, 4.398);
        googleMap.addMarker(new MarkerOptions().position(platinMoretus).title("Plantin-Moretus House-Workshops-Museum Complex"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(platinMoretus));

        LatLng flemishBeguinages = new LatLng(51.031, 4.474);
        googleMap.addMarker(new MarkerOptions().position(flemishBeguinages).title("Flemish Béguinages"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(flemishBeguinages));

        LatLng notreDameTournai = new LatLng(50.606, 3.389);
        googleMap.addMarker(new MarkerOptions().position(notreDameTournai).title("Notre-Dame Cathedral in Tournai"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(notreDameTournai));

    };
}