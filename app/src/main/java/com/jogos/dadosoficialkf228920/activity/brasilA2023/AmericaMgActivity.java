package com.jogos.dadosoficialkf228920.activity.brasilA2023;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.activity.brasilB2023.AbcActivity;
import com.jogos.dadosoficialkf228920.adapter.brasileiroA2023.americaMG.resultado.AmericaMgCsA2023RstdAdt;
import com.jogos.dadosoficialkf228920.databinding.ActivityAbcB2023Binding;
import com.jogos.dadosoficialkf228920.databinding.ActivityAmericaMgA2023Binding;
import com.jogos.dadosoficialkf228920.fragments.brasileiroA2023.americaMG.AmericaMgCasa2023Fragment;
import com.jogos.dadosoficialkf228920.fragments.brasileiroA2023.americaMG.AmericaMgFora2023Fragment;
import com.jogos.dadosoficialkf228920.fragments.brasileiroA2023.americaMG.resultado.AmericaMg2023RstdFragment;
import com.jogos.dadosoficialkf228920.fragments.brasileiroA2023.americaMG.resultado.AmericaMgCs2023RstdFragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class AmericaMgActivity extends AppCompatActivity {

    private ActivityAmericaMgA2023Binding binding;
    private ActivityAbcB2023Binding activityAbcB2023Binding;

    //private ActivityAmericaMgBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAmericaMgA2023Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

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
                        .add("Casa 2023", AmericaMgCasa2023Fragment.class)
                        .add("Fora 2023", AmericaMgFora2023Fragment.class)



                        .create()
        );



        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}