package com.example.dadosdosjogos2020oficial.fragments.alemanhaA2022a23.augsburg;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.dadosdosjogos2020oficial.R;
import com.example.dadosdosjogos2020oficial.adapter.alemanhaA2022a23.augsburg.AugsburgFora2022a23Adapter;
import com.example.dadosdosjogos2020oficial.data.alemanhaA2022a23.augsburg.AugsburgForaA2022a23PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.FragmentAugsburgFora2022a23Binding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class AugsburgFora2022a23Fragment extends Fragment {

    private FragmentAugsburgFora2022a23Binding binding;
    private AugsburgForaA2022a23PartidaApi augsburgForaA2022a23PartidaApi;
    private AugsburgFora2022a23Adapter augsburgFora2022a23Adapter;



    public AugsburgFora2022a23Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAugsburgFora2022a23Binding.inflate(inflater, container, false);
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

        augsburgForaA2022a23PartidaApi = retrofit.create(AugsburgForaA2022a23PartidaApi.class);

    }

    private void setupDadosJogos() {
        binding.rvAugsburgFora.setHasFixedSize(true);
        binding.rvAugsburgFora.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvAugsburgFora.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        augsburgForaA2022a23PartidaApi.getAugsburgFora().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {

            }

            @Override
            public void onFailure(Call<List<Partida>> call, Throwable t) {

            }
        });

    }
}