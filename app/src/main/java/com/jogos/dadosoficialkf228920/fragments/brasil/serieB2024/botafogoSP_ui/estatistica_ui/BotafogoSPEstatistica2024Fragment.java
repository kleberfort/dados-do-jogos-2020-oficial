package com.jogos.dadosoficialkf228920.fragments.brasil.serieB2024.botafogoSP_ui.estatistica_ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.databinding.FragmentBotafogoSPEstatistica2024Binding;
import com.jogos.dadosoficialkf228920.databinding.FragmentCearaEstatistica2024Binding;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieB2024.ceara_ui.estatistica_ui.CearaEstatisticaCasa2024Fragment;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieB2024.ceara_ui.estatistica_ui.CearaEstatisticaFora2024Fragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BotafogoSPEstatistica2024Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BotafogoSPEstatistica2024Fragment extends Fragment {

    private FragmentBotafogoSPEstatistica2024Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBotafogoSPEstatistica2024Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        //configurar o adapter para abas do time
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getChildFragmentManager(),
                FragmentPagerItems.with(requireContext())
                        .add("Casa", BotafogoSPEstatisticaCasa2024Fragment.class)
                        .add("Fora", BotafogoSPEstatisticaFora2024Fragment.class)
                        .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);


        return view;
    }


}