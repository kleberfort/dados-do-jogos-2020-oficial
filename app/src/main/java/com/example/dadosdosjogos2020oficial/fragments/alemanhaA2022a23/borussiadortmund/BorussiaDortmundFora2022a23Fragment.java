package com.example.dadosdosjogos2020oficial.fragments.alemanhaA2022a23.borussiadortmund;

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
import com.example.dadosdosjogos2020oficial.adapter.alemanhaA2022a23.borussiadortmund.BorussiaDortmundFora2022a23Adapter;
import com.example.dadosdosjogos2020oficial.data.alemanhaA2022a23.bayerleverkusen.BayerLeverkusenCasaA2022a23PartidaApi;
import com.example.dadosdosjogos2020oficial.data.alemanhaA2022a23.borussiadortmund.BorussiaDortmundForaA2022a23PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.FragmentBayerLeverkusenCasa2022a23Binding;
import com.example.dadosdosjogos2020oficial.databinding.FragmentBorussiaDortmundFora2022a23Binding;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class BorussiaDortmundFora2022a23Fragment extends Fragment {


    private FragmentBorussiaDortmundFora2022a23Binding binding;
    private BorussiaDortmundForaA2022a23PartidaApi borussiaDortmundForaA2022a23PartidaApi;
    private BorussiaDortmundFora2022a23Adapter borussiaDortmundFora2022a23Adapter;


    public BorussiaDortmundFora2022a23Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBorussiaDortmundFora2022a23Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupDadosJogos();


        return view;
    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/alemanha-a-2022-23/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    private void setupDadosJogos() {
        binding.rvBorussiaDortmundFora.setHasFixedSize(true);
        binding.rvBorussiaDortmundFora.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvBorussiaDortmundFora.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
    }
}


