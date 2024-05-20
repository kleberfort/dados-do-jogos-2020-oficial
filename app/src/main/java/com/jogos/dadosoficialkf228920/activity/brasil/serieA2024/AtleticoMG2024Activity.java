package com.jogos.dadosoficialkf228920.activity.brasil.serieA2024;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RelativeLayout;

import com.google.android.material.tabs.TabLayoutMediator;
import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.databinding.ActivityAtleticoMg2024Binding;
import com.jogos.dadosoficialkf228920.databinding.ActivityAtleticoMgactivityBinding;
import com.jogos.dadosoficialkf228920.databinding.ActivityAtleticoPr2024Binding;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieA2024.atleticoMG_ui.estatistica_ui.AtleticoMGEstatistica2024Fragment;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieA2024.atleticoMG_ui.estatistica_ui.AtleticoMGEstatisticaCasa2024Fragment;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieA2024.atleticoMG_ui.estatistica_ui.partidas_ui.AtleticoMGCasaPartidas2024Fragment;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieA2024.atleticoMG_ui.estatistica_ui.partidas_ui.AtleticoMGForaPartidas2024Fragment;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieA2024.atleticoPr_ui.estatistica_ui.AtleticoPREstatitisca2024Fragment;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieA2024.atleticoPr_ui.estatistica_ui.partidas_ui.AtleticoPRCasaPartidas2024Fragment;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieA2024.atleticoPr_ui.estatistica_ui.partidas_ui.AtleticoPRForaPartidas2024Fragment;
import com.jogos.dadosoficialkf228920.model.ViewPagerAdapter;
import com.unity3d.services.banners.BannerErrorInfo;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;

public class AtleticoMG2024Activity extends AppCompatActivity {

    private ActivityAtleticoMg2024Binding binding;

    private BannerView bannerBottomUnity;
    private RelativeLayout relativeLayoutBannerUnity;
    private String bottomAdUnitId = "Banner_detalhes_Times";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAtleticoMg2024Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        configTablayout();

        relativeLayoutBannerUnity = binding.adViewContainerActivityArsenalUnity;
        exibirBannerUnity();

    }



    private void configTablayout(){
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        binding.viewPager.setAdapter(adapter);

        adapter.addFragment(new AtleticoMGCasaPartidas2024Fragment(), "Jogos casa");
        adapter.addFragment(new AtleticoMGForaPartidas2024Fragment(), "Jogos fora");
        adapter.addFragment(new AtleticoMGEstatistica2024Fragment(), "Estatística");
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

    }// fim do método Banne

}