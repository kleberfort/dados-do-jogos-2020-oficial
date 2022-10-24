package com.example.dadosdosjogos2020oficial.fragments.alemanhaA2022a23.hoffenheim;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.dadosdosjogos2020oficial.adapter.alemanhaA2022a23.hoffenheim.HoffeheimCasa2022a23Adapter;
import com.example.dadosdosjogos2020oficial.data.alemanhaA2022a23.hoffenheim.HoffenheimCasaA2022a23PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.FragmentHoffenheimCasa2022a23Binding;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class HoffenheimCasa2022a23Fragment extends Fragment {


    private FragmentHoffenheimCasa2022a23Binding binding;
    private HoffenheimCasaA2022a23PartidaApi hoffenheimCasaA2022a23PartidaApi;
    private HoffeheimCasa2022a23Adapter hoffeHeimCasa2022a23Adapter;

    public HoffenheimCasa2022a23Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHoffenheimCasa2022a23Binding.inflate(inflater, container, false);
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
        binding.rvHoffenheimCasa.setHasFixedSize(true);
        binding.rvHoffenheimCasa.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvHoffenheimCasa.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
    }
}

