package com.example.dadosdosjogos2020oficial.activity.alemanhaA2022a23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityBayerLeverkusenBinding;
import com.example.dadosdosjogos2020oficial.databinding.ActivityMainz05Binding;
import com.example.dadosdosjogos2020oficial.fragments.alemanhaA2022a23.mainz05.Mainz05Casa2022a23Fragment;
import com.example.dadosdosjogos2020oficial.fragments.alemanhaA2022a23.mainz05.Mainz05Fora2022a23Fragment;
import com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.americaMG.AmericaMgCasa2022Fragment;
import com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.americaMG.AmericaMgFora2022Fragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class Mainz05Activity extends AppCompatActivity {

    private ActivityMainz05Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainz05Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);

        //configurar o adapter para abas do time do Ceará
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(getApplicationContext())
                        .add("Casa 2022", Mainz05Casa2022a23Fragment.class)
                        .add("Fora 2022", Mainz05Fora2022a23Fragment.class)
                        .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);
    }
}