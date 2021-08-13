package be.bxl.formation.labo_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
                openMapActivity();
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
        //TODO Implement SearchFragment
    }

    private void openMapActivity(){
        //TODO implement map
    }
}