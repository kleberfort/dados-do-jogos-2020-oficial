package com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.premierLeague.leicester.estatistica_ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.databinding.FragmentAstonVillaEstatisticaFora2025Binding;
import com.jogos.dadosoficialkf228920.databinding.FragmentLeicesterEstatisticaFora2025Binding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LeicesterEstatisticaFora2025Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LeicesterEstatisticaFora2025Fragment extends Fragment {

    private FragmentLeicesterEstatisticaFora2025Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLeicesterEstatisticaFora2025Binding.inflate(inflater, container, false);
        View view = binding.getRoot();

        return  view;
    }
}