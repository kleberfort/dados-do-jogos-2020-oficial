package com.example.dadosdosjogos2020oficial.activity.espanhaA2022a23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityAthleticBilbaoBinding;
import com.example.dadosdosjogos2020oficial.databinding.ActivityMainz05Binding;
import com.example.dadosdosjogos2020oficial.fragments.alemanhaA2022a23.augsburg.AugsburgCasa2022a23Fragment;
import com.example.dadosdosjogos2020oficial.fragments.alemanhaA2022a23.augsburg.AugsburgFora2022a23Fragment;
import com.example.dadosdosjogos2020oficial.fragments.espanhaA2022a23.athleticbilbao.AthleticBilbaoCasa2022a23Fragment;
import com.example.dadosdosjogos2020oficial.fragments.espanhaA2022a23.athleticbilbao.AthleticBilbaoFora2022a23Fragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class AthleticBilbaoActivity extends AppCompatActivity {

    private ActivityAthleticBilbaoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAthleticBilbaoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);

        //configurar o adapter para abas do time
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(getApplicationContext())
                        .add("Casa 2022", AthleticBilbaoCasa2022a23Fragment.class)
                        .add("Fora 2022", AthleticBilbaoFora2022a23Fragment.class)
                        .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);
    }
}