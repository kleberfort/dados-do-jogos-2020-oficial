package com.example.dadosdosjogos2020oficial.activity.brasilA2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.dadosdosjogos2020oficial.databinding.ActivityBragantinoBinding;
import com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.bragantino.BragantinoCasa2022Fragment;
import com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.bragantino.BragantinoFora2022Fragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class BragantinoActivity extends AppCompatActivity {
    private ActivityBragantinoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBragantinoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //configurar o adapter para abas
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(getApplicationContext())
                        .add("Casa 2022", BragantinoCasa2022Fragment.class)
                        .add("Fora 2022", BragantinoFora2022Fragment.class)
                        .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);
    }
}