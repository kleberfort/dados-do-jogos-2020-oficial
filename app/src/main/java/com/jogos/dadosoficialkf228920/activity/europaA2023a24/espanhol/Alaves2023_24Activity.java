package com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.jogos.dadosoficialkf228920.databinding.ActivityAlaves202324Binding;
import com.jogos.dadosoficialkf228920.databinding.ActivityAugsburgBinding;
import com.jogos.dadosoficialkf228920.fragments.alemanhaA2022a23.augsburg.AugsburgCasa2022a23Fragment;
import com.jogos.dadosoficialkf228920.fragments.alemanhaA2022a23.augsburg.AugsburgFora2022a23Fragment;
import com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.espanhol.alaves.AlavesCasaFragment;
import com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.espanhol.alaves.AlavesForaFragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class Alaves2023_24Activity extends AppCompatActivity {

    private ActivityAlaves202324Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAlaves202324Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);



        //configurar o adapter para abas do time
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(getApplicationContext())
                        .add("Casa 2023-24", AlavesCasaFragment.class)
                        .add("Fora 2023-24", AlavesForaFragment.class)
                        .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);

    }
}