package com.jogos.dadosoficialkf228920.activity.brasilA2022;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.jogos.dadosoficialkf228920.databinding.ActivityMainBinding;
import com.jogos.dadosoficialkf228920.fragments.alemanhaA2022a23.ListaAlemaoA2022a23Fragment;
import com.jogos.dadosoficialkf228920.fragments.brasileiroA2023.ListaBrA2023Fragment;
import com.jogos.dadosoficialkf228920.fragments.brasileiroB2023.ListaBrB2023Fragment;
import com.jogos.dadosoficialkf228920.fragments.espanhaA2022a23.ListaEspanholA2022a23Fragment;
import com.jogos.dadosoficialkf228920.fragments.francaA2022a23.ListaFrancesA2022a23Fragment;
import com.jogos.dadosoficialkf228920.fragments.inglesA2022a23.ListaInglesA2022a23Fragment;
import com.jogos.dadosoficialkf228920.fragments.italiaA2022a23.ListaItalianoA2022a23Fragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private FirebaseAnalytics mFirebaseAnalytics;


    String id;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().hide();


        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, id);
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, name);
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);





        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });


        AdRequest adRequest = new AdRequest.Builder().build();
        binding.adViewBsA22Principal.loadAd(adRequest);

    //Configurar adapter para abas
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(this)
                        .add("Brasileiro A 2023", ListaBrA2023Fragment.class)
                        .add("Brasileiro B 2023", ListaBrB2023Fragment.class)
                        .add("Inglês A 2022-23", ListaInglesA2022a23Fragment.class)
                        .add("Espanhol A 2022-23", ListaEspanholA2022a23Fragment.class)
                        .add("Alemão A 2022-23", ListaAlemaoA2022a23Fragment.class)
                        .add("Italiano A 2022-23", ListaItalianoA2022a23Fragment.class)
                        .add("Françês A 2022-23", ListaFrancesA2022a23Fragment.class)

                        .create()
        );
    //Inicio o meu adapter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);



    }
}