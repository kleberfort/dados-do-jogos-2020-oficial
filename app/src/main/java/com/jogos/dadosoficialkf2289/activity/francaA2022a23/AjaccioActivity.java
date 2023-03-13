package com.jogos.dadosoficialkf2289.activity.francaA2022a23;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.jogos.dadosoficialkf2289.R;
import com.jogos.dadosoficialkf2289.databinding.ActivityAjaccioBinding;
import com.jogos.dadosoficialkf2289.databinding.ActivityVillarrealBinding;
import com.jogos.dadosoficialkf2289.fragments.francaA2022a23.ajaccio.AjaccioCasa2022a23Fragment;
import com.jogos.dadosoficialkf2289.fragments.francaA2022a23.ajaccio.AjaccioFora2022a23Fragment;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class AjaccioActivity extends AppCompatActivity {

    private ActivityAjaccioBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAjaccioBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();


        setContentView(view);




        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {

            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        binding.avAjaccio.loadAd(adRequest);

        //configurar o adapter para abas do time
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(getApplicationContext())
                        .add("Casa 2022-23", AjaccioCasa2022a23Fragment.class)
                        .add("Fora 2022-23", AjaccioFora2022a23Fragment.class)
                        .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);


    }





}