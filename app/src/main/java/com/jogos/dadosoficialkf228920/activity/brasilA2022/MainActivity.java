package com.jogos.dadosoficialkf228920.activity.brasilA2022;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.*;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.databinding.ActivityMainBinding;
import com.jogos.dadosoficialkf228920.fragments.brasileiroA2023.ListaBrA2023Fragment;
import com.jogos.dadosoficialkf228920.fragments.brasileiroB2023.ListaBrB2023Fragment;
import com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.alemanha.ListaAlemaoA2023a24Fragment;
import com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.espanhol.ListaEspanholA2023a24Fragment;
import com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.franca.ListaFrancaA2023a24Fragment;
import com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.ingles.ListaInglesA2023a24Fragment;
import com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.italia.ListaItaliaA2023a24Fragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private FirebaseAnalytics mFirebaseAnalytics;
    private AdView adView;


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



        //AdSettings.addTestDevice("1914974858865720_2046072719089266");
        adView = new AdView(this, "IMG_16_9_APP_INSTALL#1914974858865720_2046072719089266", AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);
        adContainer.addView(adView);
        adView.loadAd();





//       MobileAds.initialize(this, new OnInitializationCompleteListener() {
//          @Override
//           public void onInitializationComplete(InitializationStatus initializationStatus) {
//          }
//       });
//        AdRequest adRequest = new AdRequest.Builder().build();
//       binding.adViewBsA22Principal.loadAd(adRequest);

    //Configurar adapter para abas
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(this)
                        .add("Brasileiro A 2023", ListaBrA2023Fragment.class)
                        .add("Brasileiro B 2023", ListaBrB2023Fragment.class)
                        .add("Inglês A 2023-24", ListaInglesA2023a24Fragment.class)
                        .add("Espanhol A 2023-24", ListaEspanholA2023a24Fragment.class)
                        .add("Alemão A 2023-24", ListaAlemaoA2023a24Fragment.class)
                        .add("Italiano A 2023-24", ListaItaliaA2023a24Fragment.class)
                        .add("Françês A 2023-24", ListaFrancaA2023a24Fragment.class)

                        .create()
        );
    //Inicio o meu adapter para carregar na tela
       binding.viewPager.setAdapter(adapter);
       binding.viewPagerTab.setViewPager(binding.viewPager);



    }

    @Override
    protected void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }

}