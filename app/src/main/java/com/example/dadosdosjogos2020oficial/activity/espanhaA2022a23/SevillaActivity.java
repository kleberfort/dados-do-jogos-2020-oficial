package com.example.dadosdosjogos2020oficial.activity.espanhaA2022a23;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityMainz05Binding;
import com.example.dadosdosjogos2020oficial.databinding.ActivitySevillaBinding;
import com.example.dadosdosjogos2020oficial.fragments.alemanhaA2022a23.augsburg.AugsburgCasa2022a23Fragment;
import com.example.dadosdosjogos2020oficial.fragments.alemanhaA2022a23.augsburg.AugsburgFora2022a23Fragment;
import com.example.dadosdosjogos2020oficial.fragments.espanhaA2022a23.sevilla.SevillaCasa2022a23Fragment;
import com.example.dadosdosjogos2020oficial.fragments.espanhaA2022a23.sevilla.SevillaFora2022a23Fragment;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class SevillaActivity extends AppCompatActivity {

    private ActivitySevillaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySevillaBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {

            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        binding.avSevilla.loadAd(adRequest);

        //configurar o adapter para abas do time
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(getApplicationContext())
                        .add("Casa 2022-23", SevillaCasa2022a23Fragment.class)
                        .add("Fora 2022-23", SevillaFora2022a23Fragment.class)
                        .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);
    }
}