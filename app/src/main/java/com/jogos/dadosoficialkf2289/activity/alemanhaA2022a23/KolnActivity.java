package com.jogos.dadosoficialkf2289.activity.alemanhaA2022a23;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.jogos.dadosoficialkf2289.databinding.ActivityBayerLeverkusenBinding;
import com.jogos.dadosoficialkf2289.databinding.ActivityKolnBinding;
import com.jogos.dadosoficialkf2289.fragments.alemanhaA2022a23.koln.KolnCasa2022a23Fragment;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.jogos.dadosoficialkf2289.fragments.alemanhaA2022a23.koln.KolnFora2022a23Fragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class KolnActivity extends AppCompatActivity {

    private ActivityKolnBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityKolnBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {

            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        binding.avKoln.loadAd(adRequest);

        //configurar o adapter para abas
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(getApplicationContext())
                        .add("Casa 2022-23", KolnCasa2022a23Fragment.class)
                        .add("Fora 2022-23", KolnFora2022a23Fragment.class)
                        .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);
    }
}