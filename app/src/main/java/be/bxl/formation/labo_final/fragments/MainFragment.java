package be.bxl.formation.labo_final.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import be.bxl.formation.labo_final.R;

public class MainFragment extends Fragment implements View.OnClickListener {

    Button btnSearch, btnFavorite, btnMap;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        btnFavorite = v.findViewById(R.id.btn_main_favorite);
        btnMap = v.findViewById(R.id.btn_main_map);
        btnSearch = v.findViewById(R.id.btn_main_search);

        btnFavorite.setOnClickListener(this);
        btnMap.setOnClickListener(this);
        btnSearch.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_main_search) {
            sendNavEvent(SelectedView.SEARCH);
        }
        else if (v.getId() == R.id.btn_main_favorite) {
            sendNavEvent(SelectedView.FAV);
        }
        else if (v.getId() == R.id.btn_main_map) {
            sendNavEvent(SelectedView.MAP);
        }
        else {
            throw  new RuntimeException("Event click not supported");
        }
    }

    private void sendNavEvent(SelectedView selected) {
        if(navListener != null) {
            navListener.onSelect(selected);
        }
    }

    //region Enum/Inferface
    public enum SelectedView {
        SEARCH,
        FAV,
        MAP
    }

    @FunctionalInterface
    public interface OnNavListener {
        void onSelect(SelectedView selected);
    }

    private OnNavListener navListener;

    public void setNavListener(OnNavListener navListener) {
        this.navListener = navListener;
    }
    //endregion
}