package com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.ingles.resultado.estatistica.westham;

import static com.unity3d.services.core.properties.ClientProperties.getApplicationContext;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.databinding.FragmentAstonVillaCsResultadoBinding;
import com.jogos.dadosoficialkf228920.databinding.FragmentWestHamResultadoEstatisticaBinding;
import com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.ingles.resultado.estatistica.arsenal.ArsenalCsResultadoFragment;
import com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.ingles.resultado.estatistica.arsenal.ArsenalFrResultadoFragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;


public class WestHamResultadoEstatisticaFragment extends Fragment {

    private FragmentWestHamResultadoEstatisticaBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentWestHamResultadoEstatisticaBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        //configurar o adapter para abas do time
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getChildFragmentManager(),
                FragmentPagerItems.with(getApplicationContext())
                        .add("Casa 2023-24", WestHamCsResultadoFragment.class)
                        .add("Fora 2023-24", WestHamFrResultadoFragment.class)

                        .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);

        return  view;
    }
}