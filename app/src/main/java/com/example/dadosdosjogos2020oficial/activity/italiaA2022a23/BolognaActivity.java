package com.example.dadosdosjogos2020oficial.activity.italiaA2022a23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityBolognaBinding;
import com.example.dadosdosjogos2020oficial.databinding.ActivityNantesBinding;
import com.example.dadosdosjogos2020oficial.fragments.inglesA2022a23.wolverhampton.WolverhamptonCasa2022a23Fragment;
import com.example.dadosdosjogos2020oficial.fragments.inglesA2022a23.wolverhampton.WolverhamptonFora2022a23Fragment;
import com.example.dadosdosjogos2020oficial.fragments.italiaA2022a23.bologna.BolognaCasa2022a23Fragment;
import com.example.dadosdosjogos2020oficial.fragments.italiaA2022a23.bologna.BolognaFora2022a23Fragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class BolognaActivity extends AppCompatActivity {

    private ActivityBolognaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBolognaBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);

        //configurar o adapter para abas do time
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(getApplicationContext())
                        .add("Casa 2022", BolognaCasa2022a23Fragment.class)
                        .add("Fora 2022", BolognaFora2022a23Fragment.class)
                        .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);
    }
}