package com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.jogos.dadosoficialkf228920.databinding.ActivityFrosinone202324Binding;
import com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.italia.frosinone.FrosinoneCasaFragment;
import com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.italia.frosinone.FrosinoneForaFragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class Frosinone2023_24Activity extends AppCompatActivity {

    private ActivityFrosinone202324Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFrosinone202324Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);



        //configurar o adapter para abas
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(getApplicationContext())
                        .add("Casa 2023-24", FrosinoneCasaFragment.class)
                        .add("Fora 2023-24", FrosinoneForaFragment.class)
                        .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);
    }
}