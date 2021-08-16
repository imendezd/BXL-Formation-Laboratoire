package be.bxl.formation.labo_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import be.bxl.formation.labo_final.fragments.SearchFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnFavorite, btnMap, btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFavorite = findViewById(R.id.btn_main_favorite);
        btnMap = findViewById(R.id.btn_main_map);
        btnSearch = findViewById(R.id.btn_main_search);

        btnFavorite.setOnClickListener(this);
        btnMap.setOnClickListener(this);
        btnSearch.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_main_favorite:
                openFavoriteActivity();
                break;
            case R.id.btn_main_map:
                openMapFragment();
                break;
            case R.id.btn_main_search:
                openSearchFragment();
                break;
        }
    }

    private void openFavoriteActivity() {
        Intent intentList = new Intent(getApplicationContext(), FavoriteActivity.class);
        startActivity(intentList);
    }

    private void openSearchFragment(){
        Toast.makeText(this, R.string.workInProgress, Toast.LENGTH_LONG).show();
        /*Intent intentSearch = new Intent(getApplicationContext(), SearchFragment.class);
        startActivity(intentSearch);*/
    }

    private void openMapFragment(){
        Toast.makeText(this, R.string.workInProgress, Toast.LENGTH_LONG).show();
    }
}