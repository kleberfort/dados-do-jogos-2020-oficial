package com.example.dadosdosjogos2020oficial.activity.brasilA2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.dadosdosjogos2020oficial.databinding.ActivityAtleticoMgBinding;
import com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.atleticoMG.AtleticoMgCasa2022Fragment;
import com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.atleticoMG.AtleticoMgFora2022Fragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class AtleticoMgActivity extends AppCompatActivity {
    private ActivityAtleticoMgBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAtleticoMgBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //configurar o adapter para abas do time do Ceará
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(getApplicationContext())
                        .add("Casa 2022", AtleticoMgCasa2022Fragment.class)
                        .add("Fora 2022", AtleticoMgFora2022Fragment.class)
                        .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);

    }
}