package com.jogos.dadosoficialkf228920.activity.brasil.serieB2024;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RelativeLayout;

import com.google.android.material.tabs.TabLayoutMediator;
import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.databinding.ActivityCeara2024Binding;
import com.jogos.dadosoficialkf228920.databinding.ActivityPaysandu2024Binding;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieB2024.ceara_ui.estatistica_ui.CearaEstatistica2024Fragment;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieB2024.ceara_ui.estatistica_ui.partidas_ui.CearaCasaPartidas2024Fragment;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieB2024.ceara_ui.estatistica_ui.partidas_ui.CearaForaPartidas2024Fragment;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieB2024.paysandu_ui.estatistica_ui.PaysanduEstatistica2024Fragment;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieB2024.paysandu_ui.estatistica_ui.partidas_ui.PaysanduCasaPartidas2024Fragment;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieB2024.paysandu_ui.estatistica_ui.partidas_ui.PaysanduForaPartidas2024Fragment;
import com.jogos.dadosoficialkf228920.model.ViewPagerAdapter;
import com.unity3d.services.banners.BannerErrorInfo;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;

public class Paysandu2024Activity extends AppCompatActivity {

    private ActivityPaysandu2024Binding binding;

    private BannerView bannerBottomUnity;
    private RelativeLayout relativeLayoutBannerUnity;
    private String bottomAdUnitId = "Banner_detalhes_Times";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPaysandu2024Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        configTablayout();

        relativeLayoutBannerUnity = binding.adViewContainerActivityArsenalUnity;
        exibirBannerUnity();

    }



    private void configTablayout(){
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        binding.viewPager.setAdapter(adapter);

        adapter.addFragment(new PaysanduCasaPartidas2024Fragment(), "Jogos casa");
        adapter.addFragment(new PaysanduForaPartidas2024Fragment(), "Jogos fora");
        adapter.addFragment(new PaysanduEstatistica2024Fragment(), "Estatística");
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