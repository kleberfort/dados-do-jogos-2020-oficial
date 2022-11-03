package com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.atleticoPR;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.atleticoMG.AtleticoMgForaA2022Adapter;
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.atleticoPR.AtleticoPrCasaA2022Adapter;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.atleticoMG.AtleticoMgCasaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.atleticoPR.AtleticoPrCasaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.FragmentAtleticoPRCasa2022Binding;
import com.example.dadosdosjogos2020oficial.model.Partida;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class AtleticoPrCasa2022Fragment extends Fragment {

    private FragmentAtleticoPRCasa2022Binding binding;
    private AtleticoPrCasaA2022Adapter atleticoPrCasaA2022Adapter;
    private AtleticoPrCasaA2022PartidaApi atleticoPrCasaA2022PartidaApi;



    public AtleticoPrCasa2022Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAtleticoPRCasa2022Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupDadosJogos();


        return view;




    }

    private void setupHttpClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/brasileiro-a-2022/atletico-pr/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        atleticoPrCasaA2022PartidaApi = retrofit.create(AtleticoPrCasaA2022PartidaApi.class);
    }

    private void setupDadosJogos() {
        binding.rvAtleticoPrCasa.setHasFixedSize(true);
        binding.rvAtleticoPrCasa.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvAtleticoPrCasa.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        atleticoPrCasaA2022PartidaApi.getAtleticoPrCasa().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    atleticoPrCasaA2022Adapter = new AtleticoPrCasaA2022Adapter(partidas);
                    binding.rvAtleticoPrCasa.setAdapter(atleticoPrCasaA2022Adapter);
                }else {
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