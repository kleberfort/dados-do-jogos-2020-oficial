package com.example.dadosdosjogos2020oficial.activity.BrasilA2022;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dadosdosjogos2020oficial.databinding.ActivityMainBinding;
import com.example.dadosdosjogos2020oficial.fragments.ListaInglesA2022a23Fragment;
import com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.ListaBrA2022Fragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

    //Configurar adapter para abas
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(this)
                    .add("Brasileiro A 2022", ListaBrA2022Fragment.class)
                        .add("Inglês A 2022-23", ListaInglesA2022a23Fragment.class)
                        .create()
        );
    //Inicio o meu adapter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);


    }
}