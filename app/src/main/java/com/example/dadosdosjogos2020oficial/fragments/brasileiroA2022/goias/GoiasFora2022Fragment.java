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
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.goias.GoiasCasaA2022Adapter;
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.goias.GoiasForaA2022Adapter;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.goias.GoiasCasaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.goias.GoiasForaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.FragmentAtleticoPRFora2022Binding;
import com.example.dadosdosjogos2020oficial.databinding.FragmentGoiasFora2022Binding;
import com.example.dadosdosjogos2020oficial.model.Partida;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class GoiasFora2022Fragment extends Fragment {

    private FragmentGoiasFora2022Binding binding;
    private GoiasForaA2022Adapter goiasForaA2022Adapter;
    private GoiasForaA2022PartidaApi goiasForaA2022PartidaApi;



    public GoiasFora2022Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentGoiasFora2022Binding.inflate(inflater, container, false);
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

        goiasForaA2022PartidaApi = retrofit.create(GoiasForaA2022PartidaApi.class);
    }

    private void setupDadosJogos() {
        binding.rvGoiasFora.setHasFixedSize(true);
        binding.rvGoiasFora.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvGoiasFora.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        goiasForaA2022PartidaApi.getGoiasFora().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    goiasForaA2022Adapter = new GoiasForaA2022Adapter(partidas);
                    binding.rvGoiasFora.setAdapter(goiasForaA2022Adapter);
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