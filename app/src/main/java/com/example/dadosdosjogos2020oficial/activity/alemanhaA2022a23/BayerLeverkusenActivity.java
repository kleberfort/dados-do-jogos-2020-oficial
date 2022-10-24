package com.example.dadosdosjogos2020oficial.activity.alemanhaA2022a23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityAugsburgBinding;
import com.example.dadosdosjogos2020oficial.databinding.ActivityBayerLeverkusenBinding;
import com.example.dadosdosjogos2020oficial.fragments.alemanhaA2022a23.bayerleverkusen.BayerLeverkusenCasa2022a23Fragment;
import com.example.dadosdosjogos2020oficial.fragments.alemanhaA2022a23.bayerleverkusen.BayerLeverkusenFora2022a23Fragment;
import com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.americaMG.AmericaMgCasa2022Fragment;
import com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.americaMG.AmericaMgFora2022Fragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class BayerLeverkusenActivity extends AppCompatActivity {

    private ActivityBayerLeverkusenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBayerLeverkusenBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //configurar o adapter para abas do time do Ceará
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(getApplicationContext())
                        .add("Casa 2022", BayerLeverkusenCasa2022a23Fragment.class)
                        .add("Fora 2022", BayerLeverkusenFora2022a23Fragment.class)
                        .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);

    }
}