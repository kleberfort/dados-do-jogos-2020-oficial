package com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.italia.resultado.estatistica.fiorentina;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.jogos.dadosoficialkf228920.databinding.FragmentFiorentinaResultadoEstatisticaBinding;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class FiorentinaResultadoEstatisticaFragment extends Fragment {

    private FragmentFiorentinaResultadoEstatisticaBinding binding;

    public FiorentinaResultadoEstatisticaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFiorentinaResultadoEstatisticaBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        // Configurar o adapter para abas do time
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getChildFragmentManager(),
                FragmentPagerItems.with(getContext())
                        .add("Casa 2023-24", FiorentinaCsResultadoFragment.class)
                        .add("Fora 2023-24", FiorentinaFrResultadoFragment.class)
                        .create()
        );

        // Iniciar o adapter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);

        return view;
    }

}