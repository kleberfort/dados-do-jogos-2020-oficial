package com.example.dadosdosjogos2020oficial.fragments.inglesA2022a23.arsenal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.dadosdosjogos2020oficial.R;
import com.example.dadosdosjogos2020oficial.adapter.alemanhaA2022a23.bayerleverkusen.BayerLeverkusenCasa2022a23Adapter;
import com.example.dadosdosjogos2020oficial.adapter.inglesA2022a2023.arsenal.ArsenalFora2022a23Adapter;
import com.example.dadosdosjogos2020oficial.data.alemanhaA2022a23.bayerleverkusen.BayerLeverkusenCasaA2022a23PartidaApi;
import com.example.dadosdosjogos2020oficial.data.inglesA2022a23.arsenal.ArsenalForaA2022a23PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.FragmentArsenalCasa2022a23Binding;
import com.example.dadosdosjogos2020oficial.databinding.FragmentArsenalFora2022a23Binding;
import com.example.dadosdosjogos2020oficial.databinding.FragmentBayerLeverkusenCasa2022a23Binding;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ArsenalFora2022a23Fragment extends Fragment {

    private FragmentArsenalFora2022a23Binding binding;
    private ArsenalForaA2022a23PartidaApi arsenalForaA2022a23PartidaApi;
    private ArsenalFora2022a23Adapter arsenalFora2022a23Adapter;



    public ArsenalFora2022a23Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentArsenalFora2022a23Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupDadosJogos();


        return view;
    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/ingles-a-2022-23/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private void setupDadosJogos() {
        binding.rvArsenalFora.setHasFixedSize(true);
        binding.rvArsenalFora.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvArsenalFora.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
    }
}




