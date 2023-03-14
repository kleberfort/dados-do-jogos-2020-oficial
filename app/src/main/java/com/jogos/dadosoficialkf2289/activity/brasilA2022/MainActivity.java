package com.jogos.dadosoficialkf2289.activity.brasilA2022;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.jogos.dadosoficialkf2289.databinding.ActivityMainBinding;
import com.jogos.dadosoficialkf2289.fragments.alemanhaA2022a23.ListaAlemaoA2022a23Fragment;
import com.jogos.dadosoficialkf2289.fragments.espanhaA2022a23.ListaEspanholA2022a23Fragment;
import com.jogos.dadosoficialkf2289.fragments.francaA2022a23.ListaFrancesA2022a23Fragment;
import com.jogos.dadosoficialkf2289.fragments.inglesA2022a23.ListaInglesA2022a23Fragment;
import com.jogos.dadosoficialkf2289.fragments.brasileiroA2022.ListaBrA2022Fragment;
import com.jogos.dadosoficialkf2289.fragments.italiaA2022a23.ListaItalianoA2022a23Fragment;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        getSupportActionBar().hide();

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {

            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        binding.adViewBsA22Principal.loadAd(adRequest);

    //Configurar adapter para abas
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(this)
                        .add("Inglês A 2022-23", ListaInglesA2022a23Fragment.class)
                        .add("Espanhol A 2022-23", ListaEspanholA2022a23Fragment.class)
                        .add("Alemão A 2022-23", ListaAlemaoA2022a23Fragment.class)
                        .add("Italiano A 2022-23", ListaItalianoA2022a23Fragment.class)
                        .add("Françês A 2022-23", ListaFrancesA2022a23Fragment.class)
                        .add("Brasileiro A 2022", ListaBrA2022Fragment.class)
                        .create()
        );
    //Inicio o meu adapter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);



    }
}