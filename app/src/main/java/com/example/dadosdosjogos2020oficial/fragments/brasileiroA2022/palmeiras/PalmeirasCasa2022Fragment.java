package com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.palmeiras;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.dadosdosjogos2020oficial.R;
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.juventude.JuventudeForaA2022Adapter;
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.palmeiras.PalmeirasCasaA2022Adapter;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.juventude.JuventudeCasaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.palmeiras.PalmeirasCasaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.FragmentAtleticoPRFora2022Binding;
import com.example.dadosdosjogos2020oficial.databinding.FragmentPalmeirasCasa2022Binding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class PalmeirasCasa2022Fragment extends Fragment {

    private FragmentPalmeirasCasa2022Binding binding;
    private PalmeirasCasaA2022Adapter palmeirasCasaA2022Adapter;
    private PalmeirasCasaA2022PartidaApi palmeirasCasaA2022PartidaApi;


    public PalmeirasCasa2022Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPalmeirasCasa2022Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupDadosJogos();


        return view;




    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/brasileiro-a-2022/palmeiras/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        palmeirasCasaA2022PartidaApi = retrofit.create(PalmeirasCasaA2022PartidaApi.class);
    }

    private void setupDadosJogos() {
        binding.rvPalmeirasCasa.setHasFixedSize(true);
        binding.rvPalmeirasCasa.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvPalmeirasCasa.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        palmeirasCasaA2022PartidaApi.getPalmeirasCasa().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    palmeirasCasaA2022Adapter = new PalmeirasCasaA2022Adapter(partidas);
                    binding.rvPalmeirasCasa.setAdapter(palmeirasCasaA2022Adapter);
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