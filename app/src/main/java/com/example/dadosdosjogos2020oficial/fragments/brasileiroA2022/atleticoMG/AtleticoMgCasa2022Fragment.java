package com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.atleticoMG;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.dadosdosjogos2020oficial.R;
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.atleticoGO.AtleticoGoForaA2022Adapter;
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.atleticoMG.AtleticoMgCasaA2022Adapter;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.atleticoGO.AtleticoGoCasaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.atleticoMG.AtleticoMgCasaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.FragmentAtleticoGOCasa2022Binding;
import com.example.dadosdosjogos2020oficial.databinding.FragmentAtleticoMgCasa2022Binding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class AtleticoMgCasa2022Fragment extends Fragment {

    private FragmentAtleticoMgCasa2022Binding binding;
    private AtleticoMgCasaA2022Adapter atleticoMgCasaA2022Adapter;
    private AtleticoMgCasaA2022PartidaApi atleticoMgCasaA2022PartidaApi;



    public AtleticoMgCasa2022Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAtleticoMgCasa2022Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupDadosJogos();


        return view;




    }

    private void setupHttpClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/brasileiro-a-2022/atletico-mg/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        atleticoMgCasaA2022PartidaApi = retrofit.create(AtleticoMgCasaA2022PartidaApi.class);

    }

    private void setupDadosJogos() {
        binding.rvAtleticoMgCasa.setHasFixedSize(true);
        binding.rvAtleticoMgCasa.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvAtleticoMgCasa.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        
        atleticoMgCasaA2022PartidaApi.getAtleticoMgCasa().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    atleticoMgCasaA2022Adapter = new AtleticoMgCasaA2022Adapter(partidas);
                    binding.rvAtleticoMgCasa.setAdapter(atleticoMgCasaA2022Adapter);
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