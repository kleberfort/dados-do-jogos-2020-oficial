package com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.botafogo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.dadosdosjogos2020oficial.R;
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.botafogo.BotafogoCasaA2022Adapter;
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.botafogo.BotafogoForaA2022Adapter;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.botafogo.BotafogoCasaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.botafogo.BotafogoForaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.FragmentAtleticoPRFora2022Binding;
import com.example.dadosdosjogos2020oficial.databinding.FragmentBotafogoFora2022Binding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class BotafogoFora2022Fragment extends Fragment {

    private FragmentBotafogoFora2022Binding binding;
    private BotafogoForaA2022Adapter botafogoForaA2022Adapter;
    private BotafogoForaA2022PartidaApi botafogoForaA2022PartidaApi;


    public BotafogoFora2022Fragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBotafogoFora2022Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupDadosJogos();


        return view;




    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/brasileiro-a-2022/botafogo/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        botafogoForaA2022PartidaApi = retrofit.create(BotafogoForaA2022PartidaApi.class);
    }

    private void setupDadosJogos() {
        binding.rvBotafogoFora.setHasFixedSize(true);
        binding.rvBotafogoFora.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvBotafogoFora.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        botafogoForaA2022PartidaApi.getBotafogoFora().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    botafogoForaA2022Adapter = new BotafogoForaA2022Adapter(partidas);
                    binding.rvBotafogoFora.setAdapter(botafogoForaA2022Adapter);
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