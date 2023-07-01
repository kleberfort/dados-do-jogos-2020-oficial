package com.jogos.dadosoficialkf228920.activity.brasilB2023;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.jogos.dadosoficialkf228920.databinding.ActivityAvaiBinding;
import com.jogos.dadosoficialkf228920.databinding.ActivityGuaraniB2023Binding;
import com.jogos.dadosoficialkf228920.fragments.brasileiroB2023.guarani.GuaraniCasa2023Fragment;
import com.jogos.dadosoficialkf228920.fragments.brasileiroB2023.guarani.GuaraniFora2023Fragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class GuaraniActivity extends AppCompatActivity {


    private ActivityGuaraniB2023Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGuaraniB2023Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete( InitializationStatus initializationStatus) {

            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        binding.avGuarani.loadAd(adRequest);


        //configurar o adapter para abas
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(getApplicationContext())
                        .add("Casa 2023", GuaraniCasa2023Fragment.class)
                        .add("Fora 2023", GuaraniFora2023Fragment.class)
                        .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);
    }
}