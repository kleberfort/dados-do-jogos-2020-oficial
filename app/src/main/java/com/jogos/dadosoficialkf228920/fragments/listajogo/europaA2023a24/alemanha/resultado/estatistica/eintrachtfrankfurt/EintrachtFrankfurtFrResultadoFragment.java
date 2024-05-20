package com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.alemanha.resultado.estatistica.eintrachtfrankfurt;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jogos.dadosoficialkf228920.R;
import com.google.android.material.snackbar.Snackbar;
import com.jogos.dadosoficialkf228920.adapter.europa2023a24.alemanha.eintrachtfrankfurt.resultado.EintrachtFrankfurtForaResultadoAdapter;
import com.jogos.dadosoficialkf228920.data.europaA2023a24.alemanha.JogosAlemaoCasaFora2023_24Api;
import com.jogos.dadosoficialkf228920.databinding.FragmentEintrachtFrankfurtFrResultadoBinding;
import com.jogos.dadosoficialkf228920.model.Partida;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EintrachtFrankfurtFrResultadoFragment extends Fragment {

    private FragmentEintrachtFrankfurtFrResultadoBinding binding;

    private JogosAlemaoCasaFora2023_24Api jogosAlemaoCasaFora202324Api;
    private EintrachtFrankfurtForaResultadoAdapter eintrachtFrankfurtFrResultadoAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEintrachtFrankfurtFrResultadoBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        setupHttpClient();
        setupDadosJogos();

        return view;
    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/europa-a-2023-24/alemanha/eintracht-frankfurt/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jogosAlemaoCasaFora202324Api = retrofit.create(JogosAlemaoCasaFora2023_24Api.class);
    }

    private void setupDadosJogos() {
        binding.rvListaJogos.setHasFixedSize(true);
        binding.rvListaJogos.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvListaJogos.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        jogosAlemaoCasaFora202324Api.getEintrachtFrankfurtFora().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {

                if (response.isSuccessful()) {
                    List<Partida> partidas = response.body();
                    eintrachtFrankfurtFrResultadoAdapter = new EintrachtFrankfurtForaResultadoAdapter(partidas);
                    binding.rvListaJogos.setAdapter(eintrachtFrankfurtFrResultadoAdapter);

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