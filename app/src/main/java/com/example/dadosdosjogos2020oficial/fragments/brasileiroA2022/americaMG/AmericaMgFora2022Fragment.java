package com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.americaMG;

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
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.americaMG.AmericaMgForaA2022Adapter;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.americaMG.AmericaMgForaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.FragmentAmericaMgFora2022Binding;
import com.example.dadosdosjogos2020oficial.model.Partida;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class AmericaMgFora2022Fragment extends Fragment {

    private FragmentAmericaMgFora2022Binding binding;
    private AmericaMgForaA2022Adapter americaMgForaA2022Adapter;
    private AmericaMgForaA2022PartidaApi americaMgForaA2022PartidaApi;

    public AmericaMgFora2022Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentAmericaMgFora2022Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupDadosJogos();


        return view;
    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/brasileiro-a-2022/america-mg/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        americaMgForaA2022PartidaApi = retrofit.create(AmericaMgForaA2022PartidaApi.class);
    }

    private void setupDadosJogos() {
        binding.rvAmericaMgFora.setHasFixedSize(true);
        binding.rvAmericaMgFora.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvAmericaMgFora.addItemDecoration(new DividerItemDecoration(getContext(),LinearLayout.VERTICAL));


        americaMgForaA2022PartidaApi.getAmericaMgFora().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    americaMgForaA2022Adapter = new AmericaMgForaA2022Adapter(partidas);
                    binding.rvAmericaMgFora.setAdapter(americaMgForaA2022Adapter);
                }else {
                    erroBuscaDados();
                }

            }

            @Override
            public void onFailure(Call<List<Partida>> call, Throwable t) {
                    erroBuscaDados();
            }
        });

    }
    private void erroBuscaDados() {
        Log.i("ERRO", "Erro na busca dos dados");
    }

}