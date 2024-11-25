package com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.premierLeague.everton.estatistica_ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.databinding.FragmentAstonVillaEstatisticaFora2025Binding;
import com.jogos.dadosoficialkf228920.databinding.FragmentEvertonEstatisticaFora2025Binding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EvertonEstatisticaFora2025Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EvertonEstatisticaFora2025Fragment extends Fragment {

    private FragmentEvertonEstatisticaFora2025Binding binding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentEvertonEstatisticaFora2025Binding.inflate(inflater, container, false);
        View view = binding.getRoot();

        return  view;
    }
}