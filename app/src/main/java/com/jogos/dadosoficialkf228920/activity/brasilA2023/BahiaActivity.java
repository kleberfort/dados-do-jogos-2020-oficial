package com.jogos.dadosoficialkf228920.activity.brasilA2023;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.jogos.dadosoficialkf228920.databinding.ActivityBahiaA2023Binding;
import com.jogos.dadosoficialkf228920.fragments.brasileiroA2023.bahia.BahiaCasa2023Fragment;
import com.jogos.dadosoficialkf228920.fragments.brasileiroA2023.bahia.BahiaFora2023Fragment;
import com.jogos.dadosoficialkf228920.fragments.brasileiroA2023.bahia.resultado.Bahia2023ResultadoFragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class BahiaActivity extends AppCompatActivity {

    private ActivityBahiaA2023Binding binding;
    //private ActivityAtleticoPrBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBahiaA2023Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete( InitializationStatus initializationStatus) {

            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        binding.avAtleticoGO.loadAd(adRequest);


        //configurar o adapter para abas
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(getApplicationContext())
                        .add("Casa 2023", BahiaCasa2023Fragment.class)
                        .add("Fora 2023", BahiaFora2023Fragment.class)
                        .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);
    }
}