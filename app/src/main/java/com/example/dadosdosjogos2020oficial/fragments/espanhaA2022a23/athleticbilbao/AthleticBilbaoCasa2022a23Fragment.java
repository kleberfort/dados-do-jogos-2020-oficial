package com.example.dadosdosjogos2020oficial.fragments.espanhaA2022a23.athleticbilbao;

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
import com.example.dadosdosjogos2020oficial.adapter.espanhaA2022a23.athleticbilbao.AthleticBilbaoCasa2022a23Adapter;
import com.example.dadosdosjogos2020oficial.data.alemanhaA2022a23.bayerleverkusen.BayerLeverkusenCasaA2022a23PartidaApi;
import com.example.dadosdosjogos2020oficial.data.espanhaA2022a23.athleticbilbao.AthleticBilbaoCasaA2022a23PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.FragmentAthleticBilbaoCasa2022a23Binding;
import com.example.dadosdosjogos2020oficial.databinding.FragmentBayerLeverkusenCasa2022a23Binding;
import com.example.dadosdosjogos2020oficial.model.Partida;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class AthleticBilbaoCasa2022a23Fragment extends Fragment {


    private FragmentAthleticBilbaoCasa2022a23Binding binding;
    private AthleticBilbaoCasaA2022a23PartidaApi athleticBilbaoCasaA2022a23PartidaApi;
    private AthleticBilbaoCasa2022a23Adapter athleticBilbaoCasa2022a23Adapter;

    public AthleticBilbaoCasa2022a23Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAthleticBilbaoCasa2022a23Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupDadosJogos();


        return view;
    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/espanhol-a-2022-23/athletic-bilbao/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        athleticBilbaoCasaA2022a23PartidaApi = retrofit.create(AthleticBilbaoCasaA2022a23PartidaApi.class);
    }

    private void setupDadosJogos() {
        binding.rvAthleticBilbaoCasa.setHasFixedSize(true);
        binding.rvAthleticBilbaoCasa.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvAthleticBilbaoCasa.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        athleticBilbaoCasaA2022a23PartidaApi.getAthleticBilbaoCasa().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    athleticBilbaoCasa2022a23Adapter = new AthleticBilbaoCasa2022a23Adapter(partidas);
                    binding.rvAthleticBilbaoCasa.setAdapter(athleticBilbaoCasa2022a23Adapter);



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
