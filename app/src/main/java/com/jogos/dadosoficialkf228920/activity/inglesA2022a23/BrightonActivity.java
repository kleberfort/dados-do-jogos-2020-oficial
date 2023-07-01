package com.jogos.dadosoficialkf228920.activity.inglesA2022a23;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.jogos.dadosoficialkf228920.databinding.ActivityBrightonBinding;
import com.jogos.dadosoficialkf228920.fragments.inglesA2022a23.brighton.BrightonCasa2022a23Fragment;
import com.jogos.dadosoficialkf228920.fragments.inglesA2022a23.brighton.BrightonFora2022a23Fragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class BrightonActivity extends AppCompatActivity {

    private ActivityBrightonBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityBrightonBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);



        //configurar o adapter para abas do time
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(getApplicationContext())
                        .add("Casa 2022-23", BrightonCasa2022a23Fragment.class)
                        .add("Fora 2022-23", BrightonFora2022a23Fragment.class)
                        .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);


    }
}