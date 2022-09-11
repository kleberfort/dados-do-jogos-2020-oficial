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
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.americaMG.AmericaMgForaA2022Adapter;
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.atleticoGO.AtleticoGoCasaA2022Adapter;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.americaMG.AmericaMgForaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.atleticoGO.AtleticoGoCasaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.atleticoPR.AtleticoPrCasaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.FragmentAmericaMgFora2022Binding;
import com.example.dadosdosjogos2020oficial.databinding.FragmentAtleticoGOCasa2022Binding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class AtleticoGOCasa2022Fragment extends Fragment {

    private FragmentAtleticoGOCasa2022Binding binding;
    private AtleticoGoCasaA2022Adapter atleticoGoCasaA2022Adapter;
    private AtleticoGoCasaA2022PartidaApi atleticoGoCasaA2022PartidaApi;






    public AtleticoGOCasa2022Fragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAtleticoGOCasa2022Binding.inflate(inflater, container, false);
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

        atleticoGoCasaA2022PartidaApi = retrofit.create(AtleticoGoCasaA2022PartidaApi.class);

    }

    private void setupDadosJogos() {
        binding.rvAlteticoGoCasa.setHasFixedSize(true);
        binding.rvAlteticoGoCasa.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvAlteticoGoCasa.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        atleticoGoCasaA2022PartidaApi.getAtleticoGoCasa().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    atleticoGoCasaA2022Adapter = new AtleticoGoCasaA2022Adapter(partidas);
                    binding.rvAlteticoGoCasa.setAdapter(atleticoGoCasaA2022Adapter);
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