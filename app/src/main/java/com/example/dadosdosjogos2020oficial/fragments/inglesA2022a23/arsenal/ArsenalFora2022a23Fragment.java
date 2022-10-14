package com.example.dadosdosjogos2020oficial.fragments.inglesA2022a23.arsenal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dadosdosjogos2020oficial.R;
import com.example.dadosdosjogos2020oficial.databinding.FragmentArsenalCasa2022a23Binding;
import com.example.dadosdosjogos2020oficial.databinding.FragmentArsenalFora2022a23Binding;

public class ArsenalFora2022a23Fragment extends Fragment {

    private FragmentArsenalFora2022a23Binding binding;



    public ArsenalFora2022a23Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentArsenalFora2022a23Binding.inflate(inflater, container, false);
        View view = binding.getRoot();




        return view;
    }
}