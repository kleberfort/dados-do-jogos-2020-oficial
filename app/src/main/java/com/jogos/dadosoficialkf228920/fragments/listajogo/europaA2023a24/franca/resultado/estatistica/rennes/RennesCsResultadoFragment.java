package com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.franca.resultado.estatistica.rennes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.material.snackbar.Snackbar;
import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.adapter.europa2023a24.franca.FrancaSpResultadoAdt;
import com.jogos.dadosoficialkf228920.data.europaA2023a24.franca.JogosFrancesCasaFora2023_24Api;
import com.jogos.dadosoficialkf228920.databinding.FragmentBrestCsResultadoBinding;
import com.jogos.dadosoficialkf228920.databinding.FragmentRennesCsResultadoBinding;
import com.jogos.dadosoficialkf228920.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RennesCsResultadoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RennesCsResultadoFragment extends Fragment {

    private FragmentRennesCsResultadoBinding binding;

    private JogosFrancesCasaFora2023_24Api jogosFrancesCasaFora2023_24Api;
    private FrancaSpResultadoAdt francaSpResultadoAdt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRennesCsResultadoBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        setupHttpClient();
        setupDadosJogos();

        return view;
    }

    private void setupHttpClient() {
        String nomeTime = "rennes";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/europa-a-2023-24/franca/"+nomeTime+"/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jogosFrancesCasaFora2023_24Api = retrofit.create(JogosFrancesCasaFora2023_24Api.class);
    }

    private void setupDadosJogos() {
        binding.rvListaJogos.setHasFixedSize(true);
        binding.rvListaJogos.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvListaJogos.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        jogosFrancesCasaFora2023_24Api.getRennesCasa().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {

                if (response.isSuccessful()) {
                    List<Partida> partidas = response.body();
                    francaSpResultadoAdt = new FrancaSpResultadoAdt(partidas);
                    binding.rvListaJogos.setAdapter(francaSpResultadoAdt);

                } else {
                    errorBuscarDados();
                }

            }

            @Override
            public void onFailure(Call<List<Partida>> call, Throwable t) {

            }
        });
    }

    private void errorBuscarDados() {
        Snackbar.make(binding.getRoot(), "Erro ao buscar dados da API. Verifique a conexão de Internet.", Snackbar.LENGTH_LONG).show();
    }
}