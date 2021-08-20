package be.bxl.formation.labo_final.fragments;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import be.bxl.formation.labo_final.R;
import be.bxl.formation.labo_final.enums.SearchByEnum;
import be.bxl.formation.labo_final.models.Site;
import be.bxl.formation.labo_final.request.SiteRequestTask;

public class SearchFragment extends Fragment implements SiteRequestTask.OnResultRequestListener {

    private EditText etSearchId;
    private Spinner spSearchBy;
    private ListView lvSearch;

    public SearchFragment() {
        // Required empty public constructor
    }

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_search, container, false);
        spSearchBy = v.findViewById(R.id.sp_frag_search_by);
        etSearchId = v.findViewById(R.id.et_frag_search_id);
        lvSearch = v.findViewById(R.id.lv_search_list);

        // Spinner SearchBy
        List<String> categories = new ArrayList<>();
        for(SearchByEnum category :SearchByEnum.values()) {
            categories.add(category.getName(v.getContext()));
        }

        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(v.getContext(),
                android.R.layout.simple_spinner_item,
                categories
        );

        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spSearchBy.setAdapter(categoryAdapter);

        etSearchId.setOnEditorActionListener((v1, actionId, event) -> {
            if(actionId == EditorInfo.IME_ACTION_SEARCH) {
                searchSite();
                return true;
            }
            return false;
        });

        return v;
    }

    public void searchSite() {
        int searchId = Integer.parseInt(etSearchId.getText().toString());

        SiteRequestTask task = new SiteRequestTask();
        task.setListener(this);
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, searchId);
    }

    @Override
    public void onSiteResult(Site site) {
        switch (spSearchBy.getSelectedItem().toString()){
            case "Country":
                Toast.makeText(getContext(), site.getCountry(), Toast.LENGTH_LONG).show();
                break;
            case "Name":
                Toast.makeText(getContext(), site.getName(), Toast.LENGTH_LONG).show();
                break;
            default: throw new RuntimeException("Event click not supported");
        }
    }
}