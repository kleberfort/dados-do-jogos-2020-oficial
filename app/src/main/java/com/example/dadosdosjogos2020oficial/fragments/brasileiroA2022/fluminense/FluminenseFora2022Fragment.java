package com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.fluminense;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.dadosdosjogos2020oficial.R;
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.fluminense.FluminenseCasaA2022Adapter;
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.fluminense.FluminenseForaA2022Adapter;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.fluminense.FluminenseCasaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.fluminense.FluminenseForaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.FragmentAtleticoPRFora2022Binding;
import com.example.dadosdosjogos2020oficial.databinding.FragmentFluminenseFora2022Binding;
import com.example.dadosdosjogos2020oficial.model.Partida;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class FluminenseFora2022Fragment extends Fragment {

    private FragmentFluminenseFora2022Binding binding;
    private FluminenseForaA2022Adapter fluminenseForaA2022Adapter;
    private FluminenseForaA2022PartidaApi fluminenseForaA2022PartidaApi;


    public FluminenseFora2022Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFluminenseFora2022Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupDadosJogos();


        return view;




    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/brasileiro-a-2022/fluminense/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        fluminenseForaA2022PartidaApi = retrofit.create(FluminenseForaA2022PartidaApi.class);
    }

    private void setupDadosJogos() {
        binding.rvFluminenseFora.setHasFixedSize(true);
        binding.rvFluminenseFora.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvFluminenseFora.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        
        fluminenseForaA2022PartidaApi.getFluminenseFora().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    fluminenseForaA2022Adapter = new FluminenseForaA2022Adapter(partidas);
                    binding.rvFluminenseFora.setAdapter(fluminenseForaA2022Adapter);
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