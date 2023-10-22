package com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.jogos.dadosoficialkf228920.databinding.ActivitySevilla202324Binding;
import com.jogos.dadosoficialkf228920.databinding.ActivityWolfsburgBinding;
import com.jogos.dadosoficialkf228920.fragments.alemanhaA2022a23.wolfsburg.WolfsburgCasa2022a23Fragment;
import com.jogos.dadosoficialkf228920.fragments.alemanhaA2022a23.wolfsburg.WolfsburgFora2022a23Fragment;
import com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.espanhol.sevilla.SevillaCasaFragment;
import com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.espanhol.sevilla.SevillaForaFragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class Sevilla2023_24Activity extends AppCompatActivity {

    private ActivitySevilla202324Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySevilla202324Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);



        //configurar o adapter para abas
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(getApplicationContext())
                        .add("Casa 2023-24", SevillaCasaFragment.class)
                        .add("Fora 2023-24", SevillaForaFragment.class)
                        .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);
    }
}