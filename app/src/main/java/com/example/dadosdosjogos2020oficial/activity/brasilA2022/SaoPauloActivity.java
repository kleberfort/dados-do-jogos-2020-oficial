package com.example.dadosdosjogos2020oficial.activity.brasilA2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.dadosdosjogos2020oficial.databinding.ActivitySaoPauloBinding;
import com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.saopaulo.SaopauloCasa2022Fragment;
import com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.saopaulo.SaopauloFora2022Fragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class SaoPauloActivity extends AppCompatActivity {
    private ActivitySaoPauloBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySaoPauloBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //configurar o adapter para abas do time do Ceará
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(getApplicationContext())
                        .add("Casa 2022", SaopauloCasa2022Fragment.class)
                        .add("Fora 2022", SaopauloFora2022Fragment.class)
                        .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);
    }
}