package com.jogos.dadosoficialkf228920.fragments.brasileiroA2023.coritiba.resultado;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.databinding.FragmentAmericaMg2023RstdBinding;
import com.jogos.dadosoficialkf228920.databinding.FragmentCoritiba2023ResultadoBinding;
import com.jogos.dadosoficialkf228920.fragments.brasileiroA2023.americaMG.resultado.AmericaMgCs2023RstdFragment;
import com.jogos.dadosoficialkf228920.fragments.brasileiroA2023.americaMG.resultado.AmericaMgFr2023RstdFragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;


public class Coritiba2023ResultadoFragment extends Fragment {

    private FragmentCoritiba2023ResultadoBinding binding;

    public Coritiba2023ResultadoFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCoritiba2023ResultadoBinding.inflate(inflater, container, false);
        View view = binding.getRoot();



        //configurar o adapter para abas
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getChildFragmentManager(),
                FragmentPagerItems.with(getContext())
                        .add("Casa 2023", CoritibaCs2023RstdFragment.class)
                        .add("Fora 2023", CoritibaFr2023RstdFragment.class)

                        .create()
        );

        //Inicio o meu adpter para carregar na tela
        binding.viewPager.setAdapter(adapter);
        binding.viewPagerTab.setViewPager(binding.viewPager);


        return view;    }
}