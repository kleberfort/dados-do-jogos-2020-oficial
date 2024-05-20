package com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.italia.resultado.estatistica.atalanta;

import static com.unity3d.services.core.properties.ClientProperties.getApplicationContext;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.jogos.dadosoficialkf228920.databinding.FragmentAtalantaResultadoEstatisticaBinding;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;


public class AtalantaResultadoEstatisticaFragment extends Fragment {

    private FragmentAtalantaResultadoEstatisticaBinding binding;

    public AtalantaResultadoEstatisticaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAtalantaResultadoEstatisticaBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        //configurar o adapter para abas do time
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getChildFragmentManager(),
                FragmentPagerItems.with(getApplicationContext())
                        .add("Casa 2023-24", AtalantaCsResultadoFragment.class)
                        .add("Fora 2023-24", AtalantaFrResultadoFragment.class)
                        .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);

        return  view;
    }

}