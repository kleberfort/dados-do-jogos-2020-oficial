package com.example.dadosdosjogos2020oficial.activity.BrasilA2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.dadosdosjogos2020oficial.databinding.ActivityGoiasBinding;
import com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.AtleticoGO.AtleticoGOCasa2022Fragment;
import com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.AtleticoGO.AtleticoGOFora2022Fragment;
import com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.goias.GoiasCasa2022Fragment;
import com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.goias.GoiasFora2022Fragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class GoiasActivity extends AppCompatActivity {
    private ActivityGoiasBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGoiasBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //configurar o adapter para abas do time do Ceará
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(getApplicationContext())
                        .add("Casa 2022", GoiasCasa2022Fragment.class)
                        .add("Fora 2022", GoiasFora2022Fragment.class)
                        .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);
    }
}