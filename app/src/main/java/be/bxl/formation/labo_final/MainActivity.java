package be.bxl.formation.labo_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnFavorite, btnMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFavorite = findViewById(R.id.btn_main_favorite);
        btnMap = findViewById(R.id.btn_main_map);

        btnFavorite.setOnClickListener(this);
        btnMap.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_main_favorite:
                openFavoriteActivity();
                break;
            case R.id.btn_main_map:
                throw new RuntimeException("In development :( ");
        }
    }

    private void openFavoriteActivity() {
        Intent intentList = new Intent(getApplicationContext(), FavoriteActivity.class);
        startActivity(intentList);
    }
}