package com.example.dadosdosjogos2020oficial.activity.brasilA2022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.dadosdosjogos2020oficial.databinding.ActivityFortalezaBinding;
import com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.fortaleza.FortalezaCasa2022Fragment;
import com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.fortaleza.FortalezaFora2022Fragment;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class FortalezaActivity extends AppCompatActivity {
    private ActivityFortalezaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFortalezaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {

            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        binding.avFortaleza.loadAd(adRequest);


        //configurar o adapter para abas
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(getApplicationContext())
                        .add("Casa 2022", FortalezaCasa2022Fragment.class)
                        .add("Fora 2022", FortalezaFora2022Fragment.class)
                        .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);
    }
}