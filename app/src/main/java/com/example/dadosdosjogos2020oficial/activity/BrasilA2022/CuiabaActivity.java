package com.example.dadosdosjogos2020oficial.activity.BrasilA2022;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dadosdosjogos2020oficial.databinding.ActivityCuiabaBinding;
import com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.cuiaba.CuiabaCasa2022Fragment;
import com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.cuiaba.CuiabaFora2022Fragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class CuiabaActivity extends AppCompatActivity {
    private ActivityCuiabaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCuiabaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //configurar o adapter para abas do time do Ceará
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(getApplicationContext())
                        .add("Casa 2022", CuiabaCasa2022Fragment.class)
                        .add("Fora 2022", CuiabaFora2022Fragment.class)
                        .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);
    }
}