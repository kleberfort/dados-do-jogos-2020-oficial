package com.jogos.dadosoficialkf228920.activity.francaA2022a23;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.jogos.dadosoficialkf228920.databinding.ActivityMarseilleBinding;
import com.jogos.dadosoficialkf228920.fragments.francaA2022a23.marseille.MarseilleCasa2022a23Fragment;
import com.jogos.dadosoficialkf228920.fragments.francaA2022a23.marseille.MarseilleFora2022a23Fragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class MarseilleActivity extends AppCompatActivity {

    private ActivityMarseilleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMarseilleBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);



        //configurar o adapter para abas do time
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(getApplicationContext())
                        .add("Casa 2022-23", MarseilleCasa2022a23Fragment.class)
                        .add("Fora 2022-23", MarseilleFora2022a23Fragment.class)
                        .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);
    }
}