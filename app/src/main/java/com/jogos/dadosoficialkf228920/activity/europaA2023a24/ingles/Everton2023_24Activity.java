package com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.jogos.dadosoficialkf228920.databinding.ActivityEverton202324Binding;
import com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.ingles.everton.EvertonCasaFragment;
import com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.ingles.everton.EvertonForaFragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class Everton2023_24Activity extends AppCompatActivity {

    private ActivityEverton202324Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEverton202324Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);



        //configurar o adapter para abas
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(getApplicationContext())
                        .add("Casa 2023-24", EvertonCasaFragment.class)
                        .add("Fora 2023-24", EvertonForaFragment.class)
                        .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);
    }
}