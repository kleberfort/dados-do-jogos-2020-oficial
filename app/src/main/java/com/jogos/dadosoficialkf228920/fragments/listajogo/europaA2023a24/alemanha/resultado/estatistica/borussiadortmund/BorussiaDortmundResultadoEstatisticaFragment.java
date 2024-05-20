package com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.alemanha.resultado.estatistica.borussiadortmund;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.jogos.dadosoficialkf228920.databinding.FragmentBorussiaDortmundResultadoEstatisticaBinding;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class BorussiaDortmundResultadoEstatisticaFragment extends Fragment {

    private FragmentBorussiaDortmundResultadoEstatisticaBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBorussiaDortmundResultadoEstatisticaBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getChildFragmentManager(),
                FragmentPagerItems.with(requireContext())
                        .add("Casa 2023-24", BorussiaDortmundCsResultadoFragment.class)
                        .add("Fora 2023-24", BorussiaDortmundFrResultadoFragment.class)
                        .create()
        );

        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);

        return view;
    }
}