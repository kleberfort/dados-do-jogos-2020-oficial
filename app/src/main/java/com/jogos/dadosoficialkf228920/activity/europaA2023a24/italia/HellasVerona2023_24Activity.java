package com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayoutMediator;
import com.jogos.dadosoficialkf228920.databinding.ActivityHellasVerona202324Binding;
import com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.italia.atalanta.AtalantaCasaFragment;
import com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.italia.atalanta.AtalantaForaFragment;
import com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.italia.hellasverona.HellasVeronaCasaFragment;
import com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.italia.hellasverona.HellasVeronaForaFragment;
import com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.italia.resultado.estatistica.atalanta.AtalantaResultadoEstatisticaFragment;
import com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.italia.resultado.estatistica.hellasverona.HellasVeronaResultadoEstatisticaFragment;
import com.jogos.dadosoficialkf228920.model.ViewPagerAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.unity3d.services.banners.BannerErrorInfo;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;

public class HellasVerona2023_24Activity extends AppCompatActivity {

    private ActivityHellasVerona202324Binding binding;

    private BannerView bannerBottomUnity;
    private RelativeLayout relativeLayoutBannerUnity;
    private String bottomAdUnitId = "Banner_detalhes_Times";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHellasVerona202324Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);

        configTablayout();

        //configurar o adapter para abas
//        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
//                getSupportFragmentManager(),
//                FragmentPagerItems.with(getApplicationContext())
//                        .add("Casa 2023-24", HellasVeronaCasaFragment.class)
//                        .add("Fora 2023-24", HellasVeronaForaFragment.class)
//                        .create()
//        );
//
//        //Inicio o meu adpter para carregar na tela
//        binding.viewPager.setAdapter(adapter);
//        binding.viewPagerTab.setViewPager(binding.viewPager);

        relativeLayoutBannerUnity = binding.adViewContainerActivityArsenalUnity;
        exibirBannerUnity();


    }

    private void configTablayout(){
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        binding.viewPager.setAdapter(adapter);

        adapter.addFragment(new HellasVeronaCasaFragment(), "Jogos casa");
        adapter.addFragment(new HellasVeronaForaFragment(), "Jogos fora");
        adapter.addFragment(new HellasVeronaResultadoEstatisticaFragment(), "Estatística");
        binding.viewPager.setOffscreenPageLimit(adapter.getItemCount());

        TabLayoutMediator mediator = new TabLayoutMediator(binding.tabs, binding.viewPager, (tab, position) -> {
            tab.setText(adapter.getTitle(position));
        });

        mediator.attach();


        //Inicio o meu adpter para carregar na tela
        // binding.viewPager.setAdapter(adapter);
        // binding.viewPagerTab.setViewPager(binding.viewPager);

    }


    public void exibirBannerUnity() {

        bannerBottomUnity = new BannerView(this, bottomAdUnitId, new UnityBannerSize(320, 50));
        bannerBottomUnity.setListener(listenerBanner());
        bannerBottomUnity.load();
        relativeLayoutBannerUnity.addView(bannerBottomUnity);
        //conecta seu celular
    }


    public BannerView.Listener listenerBanner(){

        BannerView.Listener bannerListener = new BannerView.Listener() {
            @Override
            public void onBannerLoaded(BannerView bannerAdView) {
                super.onBannerLoaded(bannerAdView);
            }

            @Override
            public void onBannerShown(BannerView bannerAdView) {
                super.onBannerShown(bannerAdView);
            }

            @Override
            public void onBannerFailedToLoad(BannerView bannerAdView, BannerErrorInfo errorInfo) {
                super.onBannerFailedToLoad(bannerAdView, errorInfo);
            }

            @Override
            public void onBannerClick(BannerView bannerAdView) {
                super.onBannerClick(bannerAdView);
            }

            @Override
            public void onBannerLeftApplication(BannerView bannerAdView) {
                super.onBannerLeftApplication(bannerAdView);
            }
        };

        return  bannerListener;

    }// fim do método Banne
}