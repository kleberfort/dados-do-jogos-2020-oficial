package com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.saopaulo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.dadosdosjogos2020oficial.R;
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.saopaulo.SaopauloCasaA2022Adapter;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.santos.SantosCasaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.saopaulo.SaopauloCasaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.FragmentAtleticoPRFora2022Binding;
import com.example.dadosdosjogos2020oficial.databinding.FragmentSaopauloCasa2022Binding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class SaopauloCasa2022Fragment extends Fragment {

    private FragmentSaopauloCasa2022Binding binding;
    private SaopauloCasaA2022Adapter saopauloCasaA2022Adapter;
    private SaopauloCasaA2022PartidaApi saopauloCasaA2022PartidaApi;




    public SaopauloCasa2022Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSaopauloCasa2022Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupDadosJogos();


        return view;




    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/brasileiro-a-2022/sao-paulo/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        saopauloCasaA2022PartidaApi = retrofit.create(SaopauloCasaA2022PartidaApi.class);
    }

    private void setupDadosJogos() {
        binding.rvSaopauloCasa.setHasFixedSize(true);
        binding.rvSaopauloCasa.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvSaopauloCasa.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        saopauloCasaA2022PartidaApi.getSaopauloCasa().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    saopauloCasaA2022Adapter = new SaopauloCasaA2022Adapter(partidas);
                    binding.rvSaopauloCasa.setAdapter(saopauloCasaA2022Adapter);

                }else{
                    erroBuscaDados();
                }
            }

            @Override
            public void onFailure(Call<List<Partida>> call, Throwable t) {
                    erroBuscaDados();
            }
        });

    }

    private void erroBuscaDados() {
        Log.i("ERRO", "Erro na busca dos dados");
    }
}