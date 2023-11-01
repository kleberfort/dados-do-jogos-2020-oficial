package com.jogos.dadosoficialkf228920.activity.brasilA2023;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.jogos.dadosoficialkf228920.databinding.ActivityCuiabaA2023Binding;
import com.jogos.dadosoficialkf228920.fragments.brasileiroA2023.cuiaba.CuiabaCasa2023Fragment;
import com.jogos.dadosoficialkf228920.fragments.brasileiroA2023.cuiaba.CuiabaFora2023Fragment;
import com.jogos.dadosoficialkf228920.fragments.brasileiroA2023.cuiaba.resultado.Cuiaba2023ResultadoFragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class CuiabaActivity extends AppCompatActivity {


    private ActivityCuiabaA2023Binding binding;
    //private ActivityCuiabaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCuiabaA2023Binding.inflate(getLayoutInflater());
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
                        .add("Casa 2023", CuiabaCasa2023Fragment.class)
                        .add("Fora 2023", CuiabaFora2023Fragment.class)
                        .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);
    }
}