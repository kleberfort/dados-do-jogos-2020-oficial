package com.example.dadosdosjogos2020oficial.fragments.inglesA2022a23.westham;

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
import com.example.dadosdosjogos2020oficial.adapter.inglesA2022a2023.westham.WesthamCasa2022a23Adapter;
import com.example.dadosdosjogos2020oficial.data.alemanhaA2022a23.bayerleverkusen.BayerLeverkusenCasaA2022a23PartidaApi;
import com.example.dadosdosjogos2020oficial.data.inglesA2022a23.westham.WestHamCasaA2022a23PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.FragmentBayerLeverkusenCasa2022a23Binding;
import com.example.dadosdosjogos2020oficial.databinding.FragmentWestHamCasa2022a23Binding;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class WestHamCasa2022a23Fragment extends Fragment {

    private FragmentWestHamCasa2022a23Binding binding;
    private WestHamCasaA2022a23PartidaApi westHamCasaA2022a23PartidaApi;
    private WesthamCasa2022a23Adapter westhamCasa2022a23Adapter;


    public WestHamCasa2022a23Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentWestHamCasa2022a23Binding.inflate(inflater, container, false);
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
        binding.rvWesthamCasa.setHasFixedSize(true);
        binding.rvWesthamCasa.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvWesthamCasa.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
    }
}




