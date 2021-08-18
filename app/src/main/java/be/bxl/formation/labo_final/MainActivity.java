package be.bxl.formation.labo_final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import be.bxl.formation.labo_final.fragments.FavoriteFragment;
import be.bxl.formation.labo_final.fragments.MainFragment;
import be.bxl.formation.labo_final.fragments.MapsFragment;
import be.bxl.formation.labo_final.fragments.SearchFragment;

public class MainActivity extends AppCompatActivity implements MainFragment.OnNavListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment home = MainFragment.newInstance();
        home.setNavListener(this);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frag_main_content, home);
        transaction.commit();
    }

    @Override
    public void onSelect(MainFragment.SelectedView selected) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        Fragment frag;
        switch (selected) {
            case SEARCH:
                frag = SearchFragment.newInstance();
                break;
            case FAV:
                frag = FavoriteFragment.newInstance();
                break;
            case MAP:
                frag = MapsFragment.newInstance();
                break;
            default:
                throw new RuntimeException("Not supported fragment");
        }

        transaction.replace(R.id.frag_main_content, frag);

        transaction.setCustomAnimations(
                android.R.anim.slide_in_left,
                android.R.anim.fade_out,
                android.R.anim.fade_in,
                android.R.anim.slide_out_right);

        transaction.addToBackStack(null);

        transaction.commit();
    }
}