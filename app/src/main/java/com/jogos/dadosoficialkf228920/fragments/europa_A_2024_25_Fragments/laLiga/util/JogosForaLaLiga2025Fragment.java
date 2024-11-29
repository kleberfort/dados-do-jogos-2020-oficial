package com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.laLiga.util;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.databinding.FragmentJogosForaLaLiga2025Binding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link JogosForaLaLiga2025Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JogosForaLaLiga2025Fragment extends Fragment {


    private FragmentJogosForaLaLiga2025Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jogos_fora_la_liga2025, container, false);
    }
}