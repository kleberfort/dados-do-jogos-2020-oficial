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
import com.example.dadosdosjogos2020oficial.adapter.alemanhaA2022a23.augsburg.AugsburgCasa2022a23Adapter;
import com.example.dadosdosjogos2020oficial.data.alemanhaA2022a23.augsburg.AugsburgCasaA2022a23PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.FragmentAugsburgCasa2022a23Binding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class AugsburgCasa2022a23Fragment extends Fragment {

    private FragmentAugsburgCasa2022a23Binding binding;
    private AugsburgCasaA2022a23PartidaApi augsburgCasaA2022a23PartidaApi;
    private AugsburgCasa2022a23Adapter augsburgCasa2022a23Adapter;



    public AugsburgCasa2022a23Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentAugsburgCasa2022a23Binding.inflate(inflater, container, false);
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

        augsburgCasaA2022a23PartidaApi = retrofit.create(AugsburgCasaA2022a23PartidaApi.class);

    }

    private void setupDadosJogos() {
        binding.rvAugsburgCasa.setHasFixedSize(true);
        binding.rvAugsburgCasa.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvAugsburgCasa.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        augsburgCasaA2022a23PartidaApi.getAugsburgCasa().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {

            }

            @Override
            public void onFailure(Call<List<Partida>> call, Throwable t) {

            }
        });
    }
}