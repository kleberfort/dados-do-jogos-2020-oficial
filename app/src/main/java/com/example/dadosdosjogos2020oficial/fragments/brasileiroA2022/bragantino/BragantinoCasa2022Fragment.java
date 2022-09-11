package com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.bragantino;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.dadosdosjogos2020oficial.R;
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.botafogo.BotafogoForaA2022Adapter;
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.bragantino.BragantinoCasaA2022Adapter;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.botafogo.BotafogoCasaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.bragantino.BragantinoCasaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.FragmentAtleticoPRFora2022Binding;
import com.example.dadosdosjogos2020oficial.databinding.FragmentBragantinoCasa2022Binding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BragantinoCasa2022Fragment extends Fragment {

    private FragmentBragantinoCasa2022Binding binding;
    private BragantinoCasaA2022Adapter bragantinoCasaA2022Adapter;
    private BragantinoCasaA2022PartidaApi bragantinoCasaA2022PartidaApi;



    public BragantinoCasa2022Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBragantinoCasa2022Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupDadosJogos();


        return view;




    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/brasileiro-a-2022/bragantino/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        bragantinoCasaA2022PartidaApi = retrofit.create(BragantinoCasaA2022PartidaApi.class);
    }

    private void setupDadosJogos() {
        binding.rvBragantinoCasa.setHasFixedSize(true);
        binding.rvBragantinoCasa.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvBragantinoCasa.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        bragantinoCasaA2022PartidaApi.getBragantinoCasa().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    bragantinoCasaA2022Adapter = new BragantinoCasaA2022Adapter(partidas);
                    binding.rvBragantinoCasa.setAdapter(bragantinoCasaA2022Adapter);
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