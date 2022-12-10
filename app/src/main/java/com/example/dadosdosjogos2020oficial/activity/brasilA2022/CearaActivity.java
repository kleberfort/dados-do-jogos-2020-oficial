package com.example.dadosdosjogos2020oficial.activity.brasilA2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityCearaBinding;
import com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.ceara.CearaCasa2022Fragment;
import com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.ceara.CearaFora2022Fragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class CearaActivity extends AppCompatActivity {
    private ActivityCearaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCearaBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


       // getSupportActionBar().setElevation(10);

        //configurar o adapter para abas do time do Ceará
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(getApplicationContext())
                .add("Casa 2022", CearaCasa2022Fragment.class)
                        .add("Fora 2022", CearaFora2022Fragment.class)
                .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);


    }
}