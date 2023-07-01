package com.jogos.dadosoficialkf228920.activity.brasilB2023;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.jogos.dadosoficialkf228920.databinding.ActivityCearaBinding;
import com.jogos.dadosoficialkf228920.databinding.ActivityTombenseB2023Binding;
import com.jogos.dadosoficialkf228920.fragments.brasileiroB2023.tombense.TombenseCasa2023Fragment;
import com.jogos.dadosoficialkf228920.fragments.brasileiroB2023.tombense.TombenseFora2023Fragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class TombenseActivity extends AppCompatActivity {


    private ActivityTombenseB2023Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTombenseB2023Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete( InitializationStatus initializationStatus) {

            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        binding.avTombense.loadAd(adRequest);

       // getSupportActionBar().setElevation(10);

        //configurar o adapter para abas do time do Ceará
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(getApplicationContext())
                .add("Casa 2023", TombenseCasa2023Fragment.class)
                        .add("Fora 2023", TombenseFora2023Fragment.class)
                .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);


    }
}