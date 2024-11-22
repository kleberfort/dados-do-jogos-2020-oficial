package com.jogos.dadosoficialkf228920.activity.europa_A_2024_2025.premierLeague;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RelativeLayout;

import com.google.android.material.tabs.TabLayoutMediator;
import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.databinding.ActivityArgentinoJunioresBinding;
import com.jogos.dadosoficialkf228920.databinding.ActivityArsenal202425Binding;
import com.jogos.dadosoficialkf228920.fragments.americadosul.argentina.ligaprofissinal2024.argentino_juniors.estatistica_ui.ArgentinoJuniorsEstatisticaCasa2024Fragment;
import com.jogos.dadosoficialkf228920.fragments.americadosul.argentina.ligaprofissinal2024.argentino_juniors.estatistica_ui.ArgentinoJuniorsEstatisticaFora2024Fragment;
import com.jogos.dadosoficialkf228920.fragments.americadosul.argentina.ligaprofissinal2024.argentino_juniors.partidas_ui.ArgentinoJuniorsCasaPartidas2024Fragment;
import com.jogos.dadosoficialkf228920.fragments.americadosul.argentina.ligaprofissinal2024.argentino_juniors.partidas_ui.ArgentinoJuniorsForaPartidas2024Fragment;
import com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.premierLeague.arsenal.estatistica_ui.ArsenalEstatisticaCasa2025Fragment;
import com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.premierLeague.arsenal.estatistica_ui.ArsenalEstatisticaFora2025Fragment;
import com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.premierLeague.arsenal.partidas_ui.ArsenalCasaPartidas2025Fragment;
import com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.premierLeague.arsenal.partidas_ui.ArsenalForaPartidas2025Fragment;
import com.jogos.dadosoficialkf228920.model.ViewPagerAdapter;
import com.unity3d.services.banners.BannerErrorInfo;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;

public class Arsenal2024_25Activity extends AppCompatActivity {

    private ActivityArsenal202425Binding binding;

    private BannerView bannerBottomUnity;
    private RelativeLayout relativeLayoutBannerUnity;
    private String bottomAdUnitId = "Banner_detalhes_Times";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityArsenal202425Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        configTablayout();


        relativeLayoutBannerUnity = binding.adViewContainerActivityArsenalUnity;
        exibirBannerUnity();

    }



    private void configTablayout(){
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        binding.viewPager.setAdapter(adapter);

        adapter.addFragment(new ArsenalCasaPartidas2025Fragment(), "Jogos casa");
        adapter.addFragment(new ArsenalForaPartidas2025Fragment(), "Jogos fora");
        adapter.addFragment(new ArsenalEstatisticaCasa2025Fragment(), "Estatística Casa");
        adapter.addFragment(new ArsenalEstatisticaFora2025Fragment(), "Estatística Fora");
        binding.viewPager.setOffscreenPageLimit(adapter.getItemCount());

        TabLayoutMediator mediator = new TabLayoutMediator(binding.tabs, binding.viewPager, (tab, position) -> {
            tab.setText(adapter.getTitle(position));
        });

        mediator.attach();

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

    }// fim do método Banner
}