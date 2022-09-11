package com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.fortaleza;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.dadosdosjogos2020oficial.R;
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.ceara.CearaCasaA2022Adapter;
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.fortaleza.FortalezaForaA2022Adapter;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.ceara.CearaCasaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.fortaleza.FortalezaForaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.FragmentFortalezaFora2022Binding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class FortalezaFora2022Fragment extends Fragment {

    private FragmentFortalezaFora2022Binding binding;
    private FortalezaForaA2022PartidaApi fortalezaForaA2022PartidaApi;
    private FortalezaForaA2022Adapter fortalezaForaA2022Adapter;




    public FortalezaFora2022Fragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentFortalezaFora2022Binding.inflate(inflater, container, false);


        setupHttpClient();
        setupDadosJogos();

        return binding.getRoot();
    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/brasileiro-a-2022/fortaleza/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        fortalezaForaA2022PartidaApi = retrofit.create(FortalezaForaA2022PartidaApi.class);
    }

    private void setupDadosJogos() {

        binding.rvFortalezaFora.setHasFixedSize(true);
        binding.rvFortalezaFora.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvFortalezaFora.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        fortalezaForaA2022PartidaApi.getFortalezaFora().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    fortalezaForaA2022Adapter = new FortalezaForaA2022Adapter(partidas);
                    binding.rvFortalezaFora.setAdapter(fortalezaForaA2022Adapter);
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
        Log.i("ERRO", "Erro na busca dos dados");
    }

}