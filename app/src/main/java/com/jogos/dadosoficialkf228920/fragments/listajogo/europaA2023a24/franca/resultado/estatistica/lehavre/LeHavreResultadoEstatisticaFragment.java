package com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.franca.resultado.estatistica.lehavre;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.databinding.FragmentLeHavreResultadoEstatisticaBinding;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class LeHavreResultadoEstatisticaFragment extends Fragment {

    private FragmentLeHavreResultadoEstatisticaBinding binding;

    public LeHavreResultadoEstatisticaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLeHavreResultadoEstatisticaBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        // Configurar o adapter para abas do time
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getChildFragmentManager(),
                FragmentPagerItems.with(getContext())
                        .add("Casa 2023-24", LeHavreCsResultadoFragment.class)
                        .add("Fora 2023-24", LeHavreFrResultadoFragment.class)
                        .create()
        );

        // Iniciar o adapter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);

        return view;
    }

}