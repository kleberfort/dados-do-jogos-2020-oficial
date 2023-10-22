package com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.jogos.dadosoficialkf228920.databinding.ActivityAthleticBilbao202324Binding;
import com.jogos.dadosoficialkf228920.databinding.ActivityBayernMuniqueBinding;
import com.jogos.dadosoficialkf228920.fragments.alemanhaA2022a23.bayernmunique.BayernMuniqueCasa2022a23Fragment;
import com.jogos.dadosoficialkf228920.fragments.alemanhaA2022a23.bayernmunique.BayernMuniqueFora2022a23Fragment;
import com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.espanhol.athleticbilbao.AthleticBilbaoCasaFragment;
import com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.espanhol.athleticbilbao.AthleticBilbaoForaFragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class AthleticBilbao2023_24Activity extends AppCompatActivity {

    private ActivityAthleticBilbao202324Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAthleticBilbao202324Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);



        //configurar o adapter para abas
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(getApplicationContext())
                        .add("Casa 2023-24", AthleticBilbaoCasaFragment.class)
                        .add("Fora 2023-24", AthleticBilbaoForaFragment.class)
                        .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);
    }
}