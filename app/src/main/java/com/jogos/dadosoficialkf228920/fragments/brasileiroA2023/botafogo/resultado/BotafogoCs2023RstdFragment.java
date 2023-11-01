package com.jogos.dadosoficialkf228920.fragments.brasileiroA2023.botafogo.resultado;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.snackbar.Snackbar;
import com.jogos.dadosoficialkf228920.adapter.brasileiroA2023.botafogo.resultado.BotafogoCsA2023RstdAdt;
import com.jogos.dadosoficialkf228920.data.brasileiroA2023.botafogo.BotafogoCasaA2023PartidaApi;
import com.jogos.dadosoficialkf228920.databinding.FragmentBotafogoCs2023RstdBinding;
import com.jogos.dadosoficialkf228920.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class BotafogoCs2023RstdFragment extends Fragment {

    private FragmentBotafogoCs2023RstdBinding binding;
    private BotafogoCasaA2023PartidaApi botafogoCasaA2023PartidaApi;
    private BotafogoCsA2023RstdAdt botafogoCsA2023RstdAdt;


    public BotafogoCs2023RstdFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBotafogoCs2023RstdBinding.inflate(inflater, container, false);
        View view = binding.getRoot();



        setupHttpClient();
        setupDadosJogos();




        return view;    }

    private void setupHttpClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/brasileiro-a-2023/botafogo/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        botafogoCasaA2023PartidaApi = retrofit.create(BotafogoCasaA2023PartidaApi.class);



    }

    private void setupDadosJogos() {

        binding.rvListaResultado.setHasFixedSize(true);
        binding.rvListaResultado.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvListaResultado.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));


        botafogoCasaA2023PartidaApi.getBotafogoCasa().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){

                    List<Partida> partidas = response.body();
                    botafogoCsA2023RstdAdt = new BotafogoCsA2023RstdAdt(partidas);
                    binding.rvListaResultado.setAdapter(botafogoCsA2023RstdAdt);

                }else{
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
        Snackbar.make(binding.getRoot(), "erro ao buscar LISTA dos jogos, Verifique a conexão de Internet, ", Snackbar.LENGTH_LONG).show();
    }
}