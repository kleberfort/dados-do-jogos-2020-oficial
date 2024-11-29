package com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.laLiga.util;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.databinding.FragmentEstatisticaForaLaLiga2025Binding;


public class EstatisticaForaLaLiga2025Fragment extends Fragment {

    private FragmentEstatisticaForaLaLiga2025Binding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_estatistica_fora_la_liga2025, container, false);
    }
}