package com.example.dadosdosjogos2020oficial.activity.inglesA2022a23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityBrightonBinding;
import com.example.dadosdosjogos2020oficial.fragments.francaA2022a23.troyes.TroyesCasa2022a23Fragment;
import com.example.dadosdosjogos2020oficial.fragments.francaA2022a23.troyes.TroyesFora2022a23Fragment;
import com.example.dadosdosjogos2020oficial.fragments.inglesA2022a23.brighton.BrightonCasa2022a23Fragment;
import com.example.dadosdosjogos2020oficial.fragments.inglesA2022a23.brighton.BrightonFora2022a23Fragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class BrightonActivity extends AppCompatActivity {

    private ActivityBrightonBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityBrightonBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //configurar o adapter para abas do time
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(getApplicationContext())
                        .add("Casa 2022", BrightonCasa2022a23Fragment.class)
                        .add("Fora 2022", BrightonFora2022a23Fragment.class)
                        .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);


    }
}