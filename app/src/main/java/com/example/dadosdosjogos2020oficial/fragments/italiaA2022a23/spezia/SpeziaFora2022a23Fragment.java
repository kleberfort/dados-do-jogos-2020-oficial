package com.example.dadosdosjogos2020oficial.fragments.italiaA2022a23.spezia;

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
import com.example.dadosdosjogos2020oficial.adapter.italiaA2022a23.spezia.SpeziaFora2022a23Adapter;
import com.example.dadosdosjogos2020oficial.data.alemanhaA2022a23.bayerleverkusen.BayerLeverkusenCasaA2022a23PartidaApi;
import com.example.dadosdosjogos2020oficial.data.italiaA2022a23.spezia.SpeziaForaA2022a23PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.FragmentBayerLeverkusenCasa2022a23Binding;
import com.example.dadosdosjogos2020oficial.databinding.FragmentSpeziaFora2022a23Binding;
import com.example.dadosdosjogos2020oficial.model.Partida;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class SpeziaFora2022a23Fragment extends Fragment {

    private FragmentSpeziaFora2022a23Binding binding;
    private SpeziaForaA2022a23PartidaApi speziaForaA2022a23PartidaApi;
    private SpeziaFora2022a23Adapter speziaFora2022a23Adapter;


    public SpeziaFora2022a23Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSpeziaFora2022a23Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupDadosJogos();


        return view;
    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/italia-a-2022-23/spezia/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        speziaForaA2022a23PartidaApi = retrofit.create(SpeziaForaA2022a23PartidaApi.class);

    }

    private void setupDadosJogos() {
        binding.rvSpeziaFora.setHasFixedSize(true);
        binding.rvSpeziaFora.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvSpeziaFora.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        speziaForaA2022a23PartidaApi.getSpeziaFora().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    speziaFora2022a23Adapter = new SpeziaFora2022a23Adapter(partidas);
                    binding.rvSpeziaFora.setAdapter(speziaFora2022a23Adapter);



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


