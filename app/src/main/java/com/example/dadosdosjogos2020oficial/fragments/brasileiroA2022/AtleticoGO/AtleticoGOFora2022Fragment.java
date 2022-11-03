package com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.AtleticoGO;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.dadosdosjogos2020oficial.R;
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.atleticoGO.AtleticoGoCasaA2022Adapter;
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.atleticoGO.AtleticoGoForaA2022Adapter;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.atleticoGO.AtleticoGoCasaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.atleticoGO.AtleticoGoForaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.FragmentAtleticoGOCasa2022Binding;
import com.example.dadosdosjogos2020oficial.databinding.FragmentAtleticoGOFora2022Binding;
import com.example.dadosdosjogos2020oficial.model.Partida;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AtleticoGOFora2022Fragment extends Fragment {

    private FragmentAtleticoGOFora2022Binding binding;
    private AtleticoGoForaA2022Adapter atleticoGoForaA2022Adapter;
    private AtleticoGoForaA2022PartidaApi atleticoGoForaA2022PartidaApi;




    public AtleticoGOFora2022Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAtleticoGOFora2022Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupDadosJogos();


        return view;




    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/brasileiro-a-2022/atletico-go/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        atleticoGoForaA2022PartidaApi = retrofit.create(AtleticoGoForaA2022PartidaApi.class);
    }

    private void setupDadosJogos() {
        binding.rvAtleticoGoFora.setHasFixedSize(true);
        binding.rvAtleticoGoFora.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvAtleticoGoFora.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        
        atleticoGoForaA2022PartidaApi.getAtleticoGoFora().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    atleticoGoForaA2022Adapter = new AtleticoGoForaA2022Adapter(partidas);
                    binding.rvAtleticoGoFora.setAdapter(atleticoGoForaA2022Adapter);
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