package com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.flamengo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.dadosdosjogos2020oficial.R;
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.flamengo.FlamengoCasaA2022Adapter;
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.flamengo.FlamengoForaA2022Adapter;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.flamengo.FlamengoCasaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.flamengo.FlamengoForaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.FragmentAtleticoPRFora2022Binding;
import com.example.dadosdosjogos2020oficial.databinding.FragmentFlamengoFora2022Binding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FlamengoFora2022Fragment extends Fragment {

    private FragmentFlamengoFora2022Binding binding;
    private FlamengoForaA2022Adapter flamengoForaA2022Adapter;
    private FlamengoForaA2022PartidaApi flamengoForaA2022PartidaApi;




    public FlamengoFora2022Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFlamengoFora2022Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupDadosJogos();


        return view;




    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/brasileiro-a-2022/flamengo/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        flamengoForaA2022PartidaApi = retrofit.create(FlamengoForaA2022PartidaApi.class);
    }

    private void setupDadosJogos() {
        binding.rvFlamengoFora.setHasFixedSize(true);
        binding.rvFlamengoFora.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvFlamengoFora.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        
        flamengoForaA2022PartidaApi.getFlamengoFora().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    flamengoForaA2022Adapter = new FlamengoForaA2022Adapter(partidas);
                    binding.rvFlamengoFora.setAdapter(flamengoForaA2022Adapter);
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