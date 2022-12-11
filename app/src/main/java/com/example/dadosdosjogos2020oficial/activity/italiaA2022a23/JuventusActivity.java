package com.example.dadosdosjogos2020oficial.activity.italiaA2022a23;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityJuventusBinding;
import com.example.dadosdosjogos2020oficial.databinding.ActivityNantesBinding;
import com.example.dadosdosjogos2020oficial.fragments.inglesA2022a23.wolverhampton.WolverhamptonCasa2022a23Fragment;
import com.example.dadosdosjogos2020oficial.fragments.inglesA2022a23.wolverhampton.WolverhamptonFora2022a23Fragment;
import com.example.dadosdosjogos2020oficial.fragments.italiaA2022a23.juventus.JuventusCasa2022a23Fragment;
import com.example.dadosdosjogos2020oficial.fragments.italiaA2022a23.juventus.JuventusFora2022a23Fragment;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class JuventusActivity extends AppCompatActivity {

    private ActivityJuventusBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityJuventusBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {

            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        binding.avJuventus.loadAd(adRequest);

        //configurar o adapter para abas do time
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(getApplicationContext())
                        .add("Casa 2022-23", JuventusCasa2022a23Fragment.class)
                        .add("Fora 2022-23", JuventusFora2022a23Fragment.class)
                        .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);
    }
}