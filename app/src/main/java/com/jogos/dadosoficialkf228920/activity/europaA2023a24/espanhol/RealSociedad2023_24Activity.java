package com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.jogos.dadosoficialkf228920.databinding.ActivityRealSociedad202324Binding;
import com.jogos.dadosoficialkf228920.databinding.ActivityWerderBremenBinding;
import com.jogos.dadosoficialkf228920.fragments.alemanhaA2022a23.werderbremen.WerderBremenCasa2022a23Fragment;
import com.jogos.dadosoficialkf228920.fragments.alemanhaA2022a23.werderbremen.WerderBremenFora2022a23Fragment;
import com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.espanhol.realsociedad.RealSociedadCasaFragment;
import com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.espanhol.realsociedad.RealSociedadForaFragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class RealSociedad2023_24Activity extends AppCompatActivity {

    private ActivityRealSociedad202324Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRealSociedad202324Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);



        //configurar o adapter para abas
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(getApplicationContext())
                        .add("Casa 2023-24", RealSociedadCasaFragment.class)
                        .add("Fora 2023-24", RealSociedadForaFragment.class)
                        .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);
    }
}