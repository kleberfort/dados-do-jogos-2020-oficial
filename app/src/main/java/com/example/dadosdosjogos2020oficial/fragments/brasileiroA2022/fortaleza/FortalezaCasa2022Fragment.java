package com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.fortaleza;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.fortaleza.FortalezaCasaA2022Adapter;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.fortaleza.FortalezaCasaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.FragmentFortalezaCasa2022Binding;
import com.example.dadosdosjogos2020oficial.model.Partida;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FortalezaCasa2022Fragment extends Fragment {

    private FragmentFortalezaCasa2022Binding binding;
    private FortalezaCasaA2022PartidaApi fortalezaCasaA2022PartidaApi;
    private FortalezaCasaA2022Adapter fortalezaCasaA2022Adapter;


    public FortalezaCasa2022Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentFortalezaCasa2022Binding.inflate(inflater, container, false);

        setupHttpClient();
        setupDadosJogos();

        return binding.getRoot();
    }

    private void setupHttpClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/brasileiro-a-2022/fortaleza/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        fortalezaCasaA2022PartidaApi = retrofit.create(FortalezaCasaA2022PartidaApi.class);


    }

    private void setupDadosJogos() {

        binding.rvFortalezaCasa.setHasFixedSize(true);
        binding.rvFortalezaCasa.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvFortalezaCasa.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        fortalezaCasaA2022PartidaApi.getFortalezaCasa().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if (response.isSuccessful()) {
                    List<Partida> partidas = response.body();
                    fortalezaCasaA2022Adapter = new FortalezaCasaA2022Adapter(partidas);
                    binding.rvFortalezaCasa.setAdapter(fortalezaCasaA2022Adapter);
                } else {
                    errorBuscarDados();
                }

            }

            @Override
            public void onFailure(Call<List<Partida>> call, Throwable t) {

                errorBuscarDados();

            }
        });

    }

    private void errorBuscarDados() {
        Snackbar.make(binding.getRoot(), "erro ao buscar dados da API, Verifique a conexão de Internet, ", Snackbar.LENGTH_LONG).show();
    }

}