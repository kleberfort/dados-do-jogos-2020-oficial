package com.example.dadosdosjogos2020oficial.fragments.espanhaA2022a23.valencia;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.dadosdosjogos2020oficial.R;
import com.example.dadosdosjogos2020oficial.adapter.alemanhaA2022a23.bayerleverkusen.BayerLeverkusenCasa2022a23Adapter;
import com.example.dadosdosjogos2020oficial.adapter.espanhaA2022a23.valencia.ValenciaFora2022a23Adapter;
import com.example.dadosdosjogos2020oficial.data.alemanhaA2022a23.bayerleverkusen.BayerLeverkusenCasaA2022a23PartidaApi;
import com.example.dadosdosjogos2020oficial.data.espanhaA2022a23.valencia.ValenciaForaA2022a23PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.FragmentBayerLeverkusenCasa2022a23Binding;
import com.example.dadosdosjogos2020oficial.databinding.FragmentValenciaFora2022a23Binding;
import com.example.dadosdosjogos2020oficial.model.Partida;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ValenciaFora2022a23Fragment extends Fragment {


    private FragmentValenciaFora2022a23Binding binding;
    private ValenciaForaA2022a23PartidaApi valenciaForaA2022a23PartidaApi;
    private ValenciaFora2022a23Adapter valenciaFora2022a23Adapter;


    public ValenciaFora2022a23Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentValenciaFora2022a23Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupDadosJogos();


        return view;
    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/espanhol-a-2022-23/valencia/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        valenciaForaA2022a23PartidaApi = retrofit.create(ValenciaForaA2022a23PartidaApi.class);
    }

    private void setupDadosJogos() {
        binding.rvValenciaFora.setHasFixedSize(true);
        binding.rvValenciaFora.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvValenciaFora.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        valenciaForaA2022a23PartidaApi.getValenciaFora().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    valenciaFora2022a23Adapter = new ValenciaFora2022a23Adapter(partidas);
                    binding.rvValenciaFora.setAdapter(valenciaFora2022a23Adapter);



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
        Snackbar.make(binding.getRoot(), "Verifique a conexão de Internet", Snackbar.LENGTH_LONG).show();
    }
}