package com.example.dadosdosjogos2020oficial.activity.brasilA2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityAtleticoGoBinding;
import com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.AtleticoGO.AtleticoGOCasa2022Fragment;
import com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.AtleticoGO.AtleticoGOFora2022Fragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class AtleticoGoActivity extends AppCompatActivity {

    private ActivityAtleticoGoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAtleticoGoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //configurar o adapter para abas do time do Ceará
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(getApplicationContext())
                        .add("Casa 2022", AtleticoGOCasa2022Fragment.class)
                        .add("Fora 2022", AtleticoGOFora2022Fragment.class)
                        .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);

    }
}