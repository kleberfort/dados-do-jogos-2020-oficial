package com.example.dadosdosjogos2020oficial.fragments.alemanhaA2022a23.leipzig;

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
import com.example.dadosdosjogos2020oficial.adapter.alemanhaA2022a23.leipzig.LeipzigCasa2022a23Adapter;
import com.example.dadosdosjogos2020oficial.data.alemanhaA2022a23.bayerleverkusen.BayerLeverkusenCasaA2022a23PartidaApi;
import com.example.dadosdosjogos2020oficial.data.alemanhaA2022a23.leipzig.LeipzigCasaA2022a23PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.FragmentBayerLeverkusenCasa2022a23Binding;
import com.example.dadosdosjogos2020oficial.databinding.FragmentLeipzigCasa2022a23Binding;
import com.example.dadosdosjogos2020oficial.model.Partida;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LeipzigCasa2022a23Fragment extends Fragment {


    private FragmentLeipzigCasa2022a23Binding binding;
    private LeipzigCasaA2022a23PartidaApi leipzigCasaA2022a23PartidaApi;
    private LeipzigCasa2022a23Adapter leipzigCasa2022a23Adapter;

    public LeipzigCasa2022a23Fragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLeipzigCasa2022a23Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupDadosJogos();


        return view;
    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/alemanha-a-2022-23/leipzig/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        leipzigCasaA2022a23PartidaApi = retrofit.create(LeipzigCasaA2022a23PartidaApi.class);

    }

    private void setupDadosJogos() {
        binding.rvLeipzigCasa.setHasFixedSize(true);
        binding.rvLeipzigCasa.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvLeipzigCasa.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        leipzigCasaA2022a23PartidaApi.getLeipzigCasa().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    leipzigCasa2022a23Adapter = new LeipzigCasa2022a23Adapter(partidas);
                    binding.rvLeipzigCasa.setAdapter(leipzigCasa2022a23Adapter);



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

