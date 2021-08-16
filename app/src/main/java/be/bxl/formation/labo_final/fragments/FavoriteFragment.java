package be.bxl.formation.labo_final.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import be.bxl.formation.labo_final.R;
import be.bxl.formation.labo_final.models.Site;


public class FavoriteFragment extends Fragment {

    ListView lvFavPlaces;
    Button btnBack;

    public FavoriteFragment() {
        // Required empty public constructor
    }

    public static FavoriteFragment newInstance() { return new FavoriteFragment(); }

    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_favorite, container, false);

        lvFavPlaces = v.findViewById(R.id.lv_fav_list);

        ArrayList<Site> sites = new ArrayList<>();
        //TODO add every fav site

        ArrayList<HashMap<String, String>> dataSource = new ArrayList<>();
        for(Site s : sites) {
            HashMap<String, String> decomposition = new HashMap<>();
            decomposition.put("name", s.getName());
            decomposition.put("country", s.getCountry());
            dataSource.add(decomposition);
        }

        //TODO Change SimpleAdapter

        SimpleAdapter adapter = new SimpleAdapter(
                v.getContext(),
                dataSource,
                android.R.layout.simple_list_item_2,
                new String[] { "name", "country" },
                new int[] { android.R.id.text1, android.R.id.text2 }
        );
        lvFavPlaces.setAdapter(adapter);

        return v;
    }
}