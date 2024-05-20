package com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.italia.resultado.estatistica.udinese;

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
import com.jogos.dadosoficialkf228920.adapter.europa2023a24.italia.ItaliaSpResultadoAdp;
import com.jogos.dadosoficialkf228920.data.europaA2023a24.italia.JogosItalianoCasaFora2023_24Api;
import com.jogos.dadosoficialkf228920.databinding.FragmentAtalantaFrResultadoBinding;
import com.jogos.dadosoficialkf228920.databinding.FragmentUdineseFrResultadoBinding;
import com.jogos.dadosoficialkf228920.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UdineseFrResultadoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UdineseFrResultadoFragment extends Fragment {

    private FragmentUdineseFrResultadoBinding binding;


    private JogosItalianoCasaFora2023_24Api jogosItalianoCasaFora2023_24Api;
    private ItaliaSpResultadoAdp italiaSpResultadoAdp;


    public UdineseFrResultadoFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentUdineseFrResultadoBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        setupHttpClient();
        setupDadosJogos();

        return  view;
    }
    private void setupHttpClient() {
        String nomeTime = "udinese";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/europa-a-2023-24/italiano/"+nomeTime+"/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jogosItalianoCasaFora2023_24Api = retrofit.create(JogosItalianoCasaFora2023_24Api.class);

    }

    private void setupDadosJogos() {
        binding.rvListaJogos.setHasFixedSize(true);
        binding.rvListaJogos.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvListaJogos.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        jogosItalianoCasaFora2023_24Api.getAtalantaFora().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {

                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    italiaSpResultadoAdp = new ItaliaSpResultadoAdp(partidas);
                    binding.rvListaJogos.setAdapter(italiaSpResultadoAdp);

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