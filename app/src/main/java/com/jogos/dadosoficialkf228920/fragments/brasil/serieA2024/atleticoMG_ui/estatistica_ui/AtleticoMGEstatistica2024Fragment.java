package com.jogos.dadosoficialkf228920.fragments.brasil.serieA2024.atleticoMG_ui.estatistica_ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.databinding.FragmentAtleticoMGEstatistica2024Binding;
import com.jogos.dadosoficialkf228920.databinding.FragmentAtleticoPREstatitisca2024Binding;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AtleticoMGEstatistica2024Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AtleticoMGEstatistica2024Fragment extends Fragment {

    private FragmentAtleticoMGEstatistica2024Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAtleticoMGEstatistica2024Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        //configurar o adapter para abas do time
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getChildFragmentManager(),
                FragmentPagerItems.with(requireContext())
                        .add("Casa", AtleticoMGEstatisticaCasa2024Fragment.class)
                        .add("Fora", AtleticoMGEstatisticaFora2024Fragment.class)
                        .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);


        return view;
    }
}