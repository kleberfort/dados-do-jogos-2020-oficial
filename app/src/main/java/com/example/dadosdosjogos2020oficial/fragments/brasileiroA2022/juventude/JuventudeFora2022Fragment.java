package com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.juventude;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.dadosdosjogos2020oficial.R;
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.juventude.JuventudeCasaA2022Adapter;
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.juventude.JuventudeForaA2022Adapter;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.juventude.JuventudeCasaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.juventude.JuventudeForaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.FragmentAtleticoPRFora2022Binding;
import com.example.dadosdosjogos2020oficial.databinding.FragmentJuventudeFora2022Binding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JuventudeFora2022Fragment extends Fragment {

    private FragmentJuventudeFora2022Binding binding;
    private JuventudeForaA2022Adapter juventudeForaA2022Adapter;
    private JuventudeForaA2022PartidaApi juventudeForaA2022PartidaApi;




    public JuventudeFora2022Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentJuventudeFora2022Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupDadosJogos();


        return view;




    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/brasileiro-a-2022/juventude/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        juventudeForaA2022PartidaApi = retrofit.create(JuventudeForaA2022PartidaApi.class);
    }

    private void setupDadosJogos() {
        binding.rvJuventudeFora.setHasFixedSize(true);
        binding.rvJuventudeFora.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvJuventudeFora.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        
        juventudeForaA2022PartidaApi.getJuventudeFora().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    juventudeForaA2022Adapter = new JuventudeForaA2022Adapter(partidas);
                    binding.rvJuventudeFora.setAdapter(juventudeForaA2022Adapter);
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