package be.bxl.formation.labo_final.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import be.bxl.formation.labo_final.R;

public class SiteItemFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public SiteItemFragment() {
        // Required empty public constructor
    }

    /**
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SiteItemFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SiteItemFragment newInstance(String param1, String param2) {
        SiteItemFragment fragment = new SiteItemFragment();
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_site_item, container, false);
    }
}