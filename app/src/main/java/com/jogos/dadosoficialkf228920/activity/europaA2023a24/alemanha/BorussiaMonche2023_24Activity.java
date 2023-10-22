package com.jogos.dadosoficialkf228920.activity.europaA2023a24.alemanha;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.jogos.dadosoficialkf228920.databinding.ActivityBorussiaMonche202324Binding;
import com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.alemanha.borussiamonche.BorussiaMoncheCasaFragment;
import com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.alemanha.borussiamonche.BorussiaMoncheForaFragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class BorussiaMonche2023_24Activity extends AppCompatActivity {

    private ActivityBorussiaMonche202324Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBorussiaMonche202324Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //configurar o adapter para abas do time
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(getApplicationContext())
                        .add("Casa 2023-24", BorussiaMoncheCasaFragment.class)
                        .add("Fora 2023-24", BorussiaMoncheForaFragment.class)
                        .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);

    }
}