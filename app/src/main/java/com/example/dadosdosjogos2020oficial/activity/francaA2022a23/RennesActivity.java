package com.example.dadosdosjogos2020oficial.activity.francaA2022a23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dadosdosjogos2020oficial.databinding.ActivityRennesBinding;
import com.example.dadosdosjogos2020oficial.databinding.ActivityVillarrealBinding;
import com.example.dadosdosjogos2020oficial.fragments.espanhaA2022a23.villarreal.VillarrealCasa2022a23Fragment;
import com.example.dadosdosjogos2020oficial.fragments.espanhaA2022a23.villarreal.VillarrealFora2022a23Fragment;
import com.example.dadosdosjogos2020oficial.fragments.francaA2022a23.rennes.RennesCasa2022a23Fragment;
import com.example.dadosdosjogos2020oficial.fragments.francaA2022a23.rennes.RennesFora2022a23Fragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class RennesActivity extends AppCompatActivity {

    private ActivityRennesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRennesBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);

        //configurar o adapter para abas do time
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(getApplicationContext())
                        .add("Casa 2022", RennesCasa2022a23Fragment.class)
                        .add("Fora 2022", RennesFora2022a23Fragment.class)
                        .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);
    }
}