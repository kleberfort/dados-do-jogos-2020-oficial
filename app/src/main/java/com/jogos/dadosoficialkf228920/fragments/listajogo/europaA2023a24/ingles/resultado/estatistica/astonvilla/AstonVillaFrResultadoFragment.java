package com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.ingles.resultado.estatistica.astonvilla;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.snackbar.Snackbar;
import com.jogos.dadosoficialkf228920.adapter.europa2023a24.ingles.astonvilla.resultado.AstonVillaForaResultadoAdapter;
import com.jogos.dadosoficialkf228920.data.europaA2023a24.ingles.astonvilla.AstonVillaForaPartidaApi;
import com.jogos.dadosoficialkf228920.databinding.FragmentAstonVillaFrResultadoBinding;
import com.jogos.dadosoficialkf228920.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class AstonVillaFrResultadoFragment extends Fragment {

    private FragmentAstonVillaFrResultadoBinding binding;
    private AstonVillaForaPartidaApi astonVillaForaPartidaApi;
    private AstonVillaForaResultadoAdapter astonVillaForaResultadoAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAstonVillaFrResultadoBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        setupHttpClient();
        setupDadosJogos();





        return  view;
    }


    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/europa-a-2023-24/ingles/aston-villa/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        astonVillaForaPartidaApi = retrofit.create(AstonVillaForaPartidaApi.class);

    }



    private void setupDadosJogos() {
        binding.rvListaJogos.setHasFixedSize(true);
        binding.rvListaJogos.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvListaJogos.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        astonVillaForaPartidaApi.getAstonVillaFora().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {

                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    astonVillaForaResultadoAdapter = new AstonVillaForaResultadoAdapter(partidas);
                    binding.rvListaJogos.setAdapter(astonVillaForaResultadoAdapter);

                }else {
                    errorBuscarDados();
                }

            }

            @Override
            public void onFailure(Call<List<Partida>> call, Throwable t) {

            }
        });


    }

    private void errorBuscarDados() {
        Snackbar.make(binding.getRoot(), "erro ao buscar dados da API, Verifique a conexão de Internet, ", Snackbar.LENGTH_LONG).show();
    }
}