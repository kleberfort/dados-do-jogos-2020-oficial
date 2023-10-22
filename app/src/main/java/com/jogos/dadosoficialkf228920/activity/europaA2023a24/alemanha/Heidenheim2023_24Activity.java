package com.jogos.dadosoficialkf228920.activity.europaA2023a24.alemanha;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.jogos.dadosoficialkf228920.databinding.ActivityHeidenheim202324Binding;
import com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.alemanha.heidenheim.HeidenheimCasaFragment;
import com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.alemanha.heidenheim.HeidenheimForaFragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class Heidenheim2023_24Activity extends AppCompatActivity {

    private ActivityHeidenheim202324Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHeidenheim202324Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //configurar o adapter para abas do time
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(getApplicationContext())
                        .add("Casa 2023-24", HeidenheimCasaFragment.class)
                        .add("Fora 2023-24", HeidenheimForaFragment.class)
                        .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);

    }
}