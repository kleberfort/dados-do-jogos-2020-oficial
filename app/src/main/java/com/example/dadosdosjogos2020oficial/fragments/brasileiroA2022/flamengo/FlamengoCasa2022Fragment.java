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
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.cuiaba.CuiabaForaA2022Adapter;
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.flamengo.FlamengoCasaA2022Adapter;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.cuiaba.CuiabaCasaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.flamengo.FlamengoCasaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.FragmentAtleticoPRFora2022Binding;
import com.example.dadosdosjogos2020oficial.databinding.FragmentFlamengoCasa2022Binding;
import com.example.dadosdosjogos2020oficial.model.Partida;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class FlamengoCasa2022Fragment extends Fragment {

    private FragmentFlamengoCasa2022Binding binding;
    private FlamengoCasaA2022Adapter flamengoCasaA2022Adapter;
    private FlamengoCasaA2022PartidaApi flamengoCasaA2022PartidaApi;


    public FlamengoCasa2022Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFlamengoCasa2022Binding.inflate(inflater, container, false);
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

        flamengoCasaA2022PartidaApi = retrofit.create(FlamengoCasaA2022PartidaApi.class);
    }

    private void setupDadosJogos() {
        binding.rvFlamengoCasa.setHasFixedSize(true);
        binding.rvFlamengoCasa.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvFlamengoCasa.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        
        flamengoCasaA2022PartidaApi.getFlamengoCasa().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    flamengoCasaA2022Adapter = new FlamengoCasaA2022Adapter(partidas);
                    binding.rvFlamengoCasa.setAdapter(flamengoCasaA2022Adapter);
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