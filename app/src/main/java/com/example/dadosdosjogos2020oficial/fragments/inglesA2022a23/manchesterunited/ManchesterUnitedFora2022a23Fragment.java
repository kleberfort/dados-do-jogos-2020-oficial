package com.example.dadosdosjogos2020oficial.fragments.inglesA2022a23.manchesterunited;

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
import com.example.dadosdosjogos2020oficial.adapter.inglesA2022a2023.manchesterunited.ManchesterUnitedFora2022a23Adapter;
import com.example.dadosdosjogos2020oficial.data.alemanhaA2022a23.bayerleverkusen.BayerLeverkusenCasaA2022a23PartidaApi;
import com.example.dadosdosjogos2020oficial.data.inglesA2022a23.manchesterunited.ManchesterUnitedForaA2022a23PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.FragmentBayerLeverkusenCasa2022a23Binding;
import com.example.dadosdosjogos2020oficial.databinding.FragmentManchesterUnitedFora2022a23Binding;
import com.example.dadosdosjogos2020oficial.model.Partida;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ManchesterUnitedFora2022a23Fragment extends Fragment {

    private FragmentManchesterUnitedFora2022a23Binding binding;
    private ManchesterUnitedForaA2022a23PartidaApi manchesterUnitedForaA2022a23PartidaApi;
    private ManchesterUnitedFora2022a23Adapter manchesterUnitedFora2022a23Adapter;


    public ManchesterUnitedFora2022a23Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentManchesterUnitedFora2022a23Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupDadosJogos();


        return view;
    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/ingles-a-2022-23/manchester-united/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        manchesterUnitedForaA2022a23PartidaApi = retrofit.create(ManchesterUnitedForaA2022a23PartidaApi.class);


    }

    private void setupDadosJogos() {
        binding.rvManchesterUnitedFora.setHasFixedSize(true);
        binding.rvManchesterUnitedFora.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvManchesterUnitedFora.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        manchesterUnitedForaA2022a23PartidaApi.getManchesterUnitedCasa().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    manchesterUnitedFora2022a23Adapter = new ManchesterUnitedFora2022a23Adapter(partidas);
                    binding.rvManchesterUnitedFora.setAdapter(manchesterUnitedFora2022a23Adapter);



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

