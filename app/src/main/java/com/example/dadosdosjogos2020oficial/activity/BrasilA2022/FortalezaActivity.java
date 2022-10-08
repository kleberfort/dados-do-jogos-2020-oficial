package com.example.dadosdosjogos2020oficial.activity.BrasilA2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.dadosdosjogos2020oficial.databinding.ActivityFortalezaBinding;
import com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.ceara.CearaCasa2022Fragment;
import com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.ceara.CearaFora2022Fragment;
import com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.fortaleza.FortalezaCasa2022Fragment;
import com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.fortaleza.FortalezaFora2022Fragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class FortalezaActivity extends AppCompatActivity {
    private ActivityFortalezaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFortalezaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //configurar o adapter para abas do time do Ceará
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(getApplicationContext())
                        .add("Casa 2022", FortalezaCasa2022Fragment.class)
                        .add("Fora 2022", FortalezaFora2022Fragment.class)
                        .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);
    }
}