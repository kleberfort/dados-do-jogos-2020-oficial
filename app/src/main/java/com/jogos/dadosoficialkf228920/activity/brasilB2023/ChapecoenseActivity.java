package com.jogos.dadosoficialkf228920.activity.brasilB2023;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.jogos.dadosoficialkf228920.databinding.ActivityChapecoenseB2023Binding;
import com.jogos.dadosoficialkf228920.databinding.ActivityCoritibaBinding;
import com.jogos.dadosoficialkf228920.fragments.brasileiroB2023.chapecoense.ChapecoenseCasa2023Fragment;
import com.jogos.dadosoficialkf228920.fragments.brasileiroB2023.chapecoense.ChapecoenseFora2023Fragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class ChapecoenseActivity extends AppCompatActivity {


    private ActivityChapecoenseB2023Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChapecoenseB2023Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete( InitializationStatus initializationStatus) {

            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        binding.avChapecoense.loadAd(adRequest);

        //configurar o adapter para abas
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(getApplicationContext())
                        .add("Casa 2023", ChapecoenseCasa2023Fragment.class)
                        .add("Fora 2023", ChapecoenseFora2023Fragment.class)
                        .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);
    }
}