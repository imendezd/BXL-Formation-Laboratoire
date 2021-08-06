package be.bxl.formation.labo_final;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class FavoriteActivity extends AppCompatActivity {

    ListView lvFavPlaces;
    Button btnBack;

    //region
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        // Récuperation de la listeView
        lvFavPlaces = findViewById(R.id.lv_fav_list);

        ArrayList<Site> sites = new ArrayList<>();
        //TODO add every fav site

        ArrayList<HashMap<String, String>> dataSource = new ArrayList<>();
        for(Site p : sites) {
            HashMap<String, String> decomposition = new HashMap<>();
            decomposition.put("name", p.getName());
            decomposition.put("contry", p.getCountry());
            dataSource.add(decomposition);
        }

        SimpleAdapter adapter = new SimpleAdapter(
                getApplicationContext(),
                dataSource,
                android.R.layout.simple_list_item_2,
                new String[] { "name", "country" },
                new int[] { android.R.id.text1, android.R.id.text2 }
        );
        lvFavPlaces.setAdapter(adapter);

        btnBack = findViewById(R.id.btn_list_back);
        btnBack.setOnClickListener(v -> {
            //TODO Back to main screen
        });
    }
    //endregion
}