package com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.goias;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.dadosdosjogos2020oficial.R;
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.fortaleza.FortalezaForaA2022Adapter;
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.goias.GoiasCasaA2022Adapter;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.fluminense.FluminenseCasaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.goias.GoiasCasaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.FragmentAtleticoPRFora2022Binding;
import com.example.dadosdosjogos2020oficial.databinding.FragmentGoiasCasa2022Binding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GoiasCasa2022Fragment extends Fragment {

    private FragmentGoiasCasa2022Binding binding;
    private GoiasCasaA2022Adapter goiasCasaA2022Adapter;
    private GoiasCasaA2022PartidaApi goiasCasaA2022PartidaApi;



    public GoiasCasa2022Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentGoiasCasa2022Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupDadosJogos();


        return view;




    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/brasileiro-a-2022/goias/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        goiasCasaA2022PartidaApi = retrofit.create(GoiasCasaA2022PartidaApi.class);
    }

    private void setupDadosJogos() {
        binding.rvGoiasCasa.setHasFixedSize(true);
        binding.rvGoiasCasa.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvGoiasCasa.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        goiasCasaA2022PartidaApi.getGoiasCasa().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    goiasCasaA2022Adapter = new GoiasCasaA2022Adapter(partidas);
                    binding.rvGoiasCasa.setAdapter(goiasCasaA2022Adapter);
                }else {
                    erroBuscaDados();
                }
            }

            @Override
            public void onFailure(Call<List<Partida>> call, Throwable t) {

            }
        });

    }

    private void erroBuscaDados() {
    }
}