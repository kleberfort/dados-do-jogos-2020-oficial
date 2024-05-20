package com.jogos.dadosoficialkf228920.fragments.brasil.serieA2024.vitoria_ui.estatistica_ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.databinding.FragmentVascoEstatistica2024Binding;
import com.jogos.dadosoficialkf228920.databinding.FragmentVitoriaEstatistica2024Binding;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieA2024.vasco_ui.estatistica_ui.VascoEstatisticaCasa2024Fragment;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieA2024.vasco_ui.estatistica_ui.VascoEstatisticaFora2024Fragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;


public class VitoriaEstatistica2024Fragment extends Fragment {


    private FragmentVitoriaEstatistica2024Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentVitoriaEstatistica2024Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        //configurar o adapter para abas do time
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getChildFragmentManager(),
                FragmentPagerItems.with(requireContext())
                        .add("Casa", VitoriaEstatisticaCasa2024Fragment.class)
                        .add("Fora", VitoriaEstatisticaFora2024Fragment.class)
                        .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);


        return view;
    }

}