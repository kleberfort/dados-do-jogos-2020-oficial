package com.example.dadosdosjogos2020oficial.fragments.espanhaA2022a23.celtavigo;

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
import com.example.dadosdosjogos2020oficial.adapter.espanhaA2022a23.celtavigo.CeltaVigoFora2022a23Adapter;
import com.example.dadosdosjogos2020oficial.data.alemanhaA2022a23.bayerleverkusen.BayerLeverkusenCasaA2022a23PartidaApi;
import com.example.dadosdosjogos2020oficial.data.espanhaA2022a23.celtavigo.CeltaVigoForaA2022a23PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.FragmentBayerLeverkusenCasa2022a23Binding;
import com.example.dadosdosjogos2020oficial.databinding.FragmentCeltaVigoFora2022a23Binding;
import com.example.dadosdosjogos2020oficial.model.Partida;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class CeltaVigoFora2022a23Fragment extends Fragment {

    private FragmentCeltaVigoFora2022a23Binding binding;
    private CeltaVigoForaA2022a23PartidaApi celtaVigoForaA2022a23PartidaApi;
    private CeltaVigoFora2022a23Adapter celtaVigoFora2022a23Adapter;


    public CeltaVigoFora2022a23Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCeltaVigoFora2022a23Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupDadosJogos();


        return view;
    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/espanhol-a-2022-23/celta-de-vigo/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        celtaVigoForaA2022a23PartidaApi = retrofit.create(CeltaVigoForaA2022a23PartidaApi.class);
    }

    private void setupDadosJogos() {
        binding.rvCeltaVigoFora.setHasFixedSize(true);
        binding.rvCeltaVigoFora.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvCeltaVigoFora.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        celtaVigoForaA2022a23PartidaApi.getCeltaVigoFora().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    celtaVigoFora2022a23Adapter = new CeltaVigoFora2022a23Adapter(partidas);
                    binding.rvCeltaVigoFora.setAdapter(celtaVigoFora2022a23Adapter);



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

