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
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.corinthians.CorinthiansForaA2022Adapter;
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.coritiba.CoritibaCasaA2022Adapter;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.corinthians.CorinthiansCasaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.coritiba.CoritibaCasaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.FragmentAtleticoPRFora2022Binding;
import com.example.dadosdosjogos2020oficial.databinding.FragmentCorinthiansFora2022Binding;
import com.example.dadosdosjogos2020oficial.databinding.FragmentCoritibaCasa2022Binding;
import com.example.dadosdosjogos2020oficial.databinding.FragmentCoritibaFora2022Binding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class CoritibaCasa2022Fragment extends Fragment {

    private FragmentCoritibaCasa2022Binding binding;
    private CoritibaCasaA2022Adapter coritibaCasaA2022Adapter;
    private CoritibaCasaA2022PartidaApi coritibaCasaA2022PartidaApi;



    public CoritibaCasa2022Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCoritibaCasa2022Binding.inflate(inflater, container, false);
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

        coritibaCasaA2022PartidaApi = retrofit.create(CoritibaCasaA2022PartidaApi.class);
    }

    private void setupDadosJogos() {
        binding.rvCoritibaCasa.setHasFixedSize(true);
        binding.rvCoritibaCasa.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvCoritibaCasa.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        coritibaCasaA2022PartidaApi.getCoritibaCasa().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    coritibaCasaA2022Adapter = new CoritibaCasaA2022Adapter(partidas);
                    binding.rvCoritibaCasa.setAdapter(coritibaCasaA2022Adapter);
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