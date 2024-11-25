package com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.premierLeague.arsenal.estatistica_ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.databinding.FragmentArgentinoJuniorsEstatisticaCasa2024Binding;
import com.jogos.dadosoficialkf228920.databinding.FragmentArsenalEstatisticaFora2025Binding;


public class ArsenalEstatisticaFora2025Fragment extends Fragment {

    private FragmentArsenalEstatisticaFora2025Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentArsenalEstatisticaFora2025Binding.inflate(inflater, container, false);
        View view = binding.getRoot();

        return  view;
    }
}