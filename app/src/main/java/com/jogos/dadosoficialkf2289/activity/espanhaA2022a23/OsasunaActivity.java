package com.jogos.dadosoficialkf2289.activity.espanhaA2022a23;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.jogos.dadosoficialkf2289.databinding.ActivityMainz05Binding;
import com.jogos.dadosoficialkf2289.databinding.ActivityOsasunaBinding;
import com.jogos.dadosoficialkf2289.fragments.espanhaA2022a23.osasuna.OsasunaCasa2022a23Fragment;
import com.jogos.dadosoficialkf2289.fragments.espanhaA2022a23.osasuna.OsasunaFora2022a23Fragment;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class OsasunaActivity extends AppCompatActivity {

    private ActivityOsasunaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOsasunaBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {

            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        binding.avOsasuna.loadAd(adRequest);

        //configurar o adapter para abas do time
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(getApplicationContext())
                        .add("Casa 2022-23", OsasunaCasa2022a23Fragment.class)
                        .add("Fora 2022-23", OsasunaFora2022a23Fragment.class)
                        .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);
    }
}