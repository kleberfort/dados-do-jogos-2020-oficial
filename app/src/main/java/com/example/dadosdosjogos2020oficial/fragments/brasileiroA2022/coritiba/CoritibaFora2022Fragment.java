package com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.coritiba;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.dadosdosjogos2020oficial.R;
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.coritiba.CoritibaCasaA2022Adapter;
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.coritiba.CoritibaForaA2022Adapter;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.coritiba.CoritibaCasaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.coritiba.CoritibaForaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.FragmentAtleticoPRFora2022Binding;
import com.example.dadosdosjogos2020oficial.databinding.FragmentCoritibaFora2022Binding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class CoritibaFora2022Fragment extends Fragment {

    private FragmentCoritibaFora2022Binding binding;
    private CoritibaForaA2022Adapter coritibaForaA2022Adapter;
    private CoritibaForaA2022PartidaApi coritibaForaA2022PartidaApi;



    public CoritibaFora2022Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCoritibaFora2022Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupDadosJogos();


        return view;




    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/brasileiro-a-2022/coritiba/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        coritibaForaA2022PartidaApi = retrofit.create(CoritibaForaA2022PartidaApi.class);
    }

    private void setupDadosJogos() {
        binding.rvCoritibaFora.setHasFixedSize(true);
        binding.rvCoritibaFora.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvCoritibaFora.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        coritibaForaA2022PartidaApi.getCoritibaFora().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    coritibaForaA2022Adapter = new CoritibaForaA2022Adapter(partidas);
                    binding.rvCoritibaFora.setAdapter(coritibaForaA2022Adapter);
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