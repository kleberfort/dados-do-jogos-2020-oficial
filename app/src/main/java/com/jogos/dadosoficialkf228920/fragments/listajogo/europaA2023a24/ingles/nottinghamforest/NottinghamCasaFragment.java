package com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.ingles.nottinghamforest;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.snackbar.Snackbar;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Arsenal2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.AstonVilla2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Bournemouth2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Brentford2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Brighton2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Burnley2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Chelsea2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.CrystalPalace2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Everton2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Fulham2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Liverpool2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Luton2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.ManchesterCity2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.ManchesterUnited2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Newcastle2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Nottingham2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Sheffield2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Tottenham2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.WestHam2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Wolves2023_24Activity;
import com.jogos.dadosoficialkf228920.adapter.europa2023a24.ingles.nottinghamforest.NottinhamCasaAdapter;
import com.jogos.dadosoficialkf228920.data.europaA2023a24.ingles.nottinghamforest.NottinghamForestCasaPartidaApi;
import com.jogos.dadosoficialkf228920.databinding.FragmentNottinghamCasa2023a24Binding;
import com.jogos.dadosoficialkf228920.model.Partida;
import com.jogos.dadosoficialkf228920.model.RecyclerItemClickListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NottinghamCasaFragment extends Fragment {

    private FragmentNottinghamCasa2023a24Binding binding;
    private NottinghamForestCasaPartidaApi nottinghamForestCasaPartidaApi;
    private NottinhamCasaAdapter nottinhamCasaAdapter;



    public NottinghamCasaFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentNottinghamCasa2023a24Binding.inflate(inflater, container, false);
        View view = binding.getRoot();

        setupHttpClient();
        setupDadosJogos();


        return view;
    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/europa-a-2023-24/ingles/nottingham/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        nottinghamForestCasaPartidaApi = retrofit.create(NottinghamForestCasaPartidaApi.class);

    }

    private void setupDadosJogos() {
        binding.rvListaJogos.setHasFixedSize(true);
        binding.rvListaJogos.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvListaJogos.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        nottinghamForestCasaPartidaApi.getNottinghamForestCasa().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {

                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    nottinhamCasaAdapter = new NottinhamCasaAdapter(partidas);
                    binding.rvListaJogos.setAdapter(nottinhamCasaAdapter);

                    binding.rvListaJogos.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), binding.rvListaJogos, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {

                            Partida lista = partidas.get(position);

                            switch (lista.getAwayTime().getNome()){

                                case "Arsenal":
                                    Intent arsenal = new Intent(getContext(), Arsenal2023_24Activity.class);
                                    startActivity(arsenal);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Aston Villa":
                                    Intent aston = new Intent(getContext(), AstonVilla2023_24Activity.class);
                                    startActivity(aston);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Bournemouth":
                                    Intent bournemou = new Intent(getContext(), Bournemouth2023_24Activity.class);
                                    startActivity(bournemou);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Brentford":
                                    Intent brentford = new Intent(getContext(), Brentford2023_24Activity.class);
                                    startActivity(brentford);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Brighton":
                                    Intent brighton = new Intent(getContext(), Brighton2023_24Activity.class);
                                    startActivity(brighton);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Burnley":
                                    Intent burnley = new Intent(getContext(), Burnley2023_24Activity.class);
                                    startActivity(burnley);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Chelsea":
                                    Intent chelsea = new Intent(getContext(), Chelsea2023_24Activity.class);
                                    startActivity(chelsea);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Crystal Palace":
                                    Intent crystal = new Intent(getContext(), CrystalPalace2023_24Activity.class);
                                    startActivity(crystal);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Everton":
                                    Intent everton = new Intent(getContext(), Everton2023_24Activity.class);
                                    startActivity(everton);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Fulham":
                                    Intent fulham = new Intent(getContext(), Fulham2023_24Activity.class);
                                    startActivity(fulham);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Liverpool":
                                    Intent liverpool = new Intent(getContext(), Liverpool2023_24Activity.class);
                                    startActivity(liverpool);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Luton":
                                    Intent luton = new Intent(getContext(), Luton2023_24Activity.class);
                                    startActivity(luton);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "City":
                                    Intent city = new Intent(getContext(), ManchesterCity2023_24Activity.class);
                                    startActivity(city);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "United":
                                    Intent united = new Intent(getContext(), ManchesterUnited2023_24Activity.class);
                                    startActivity(united);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Newcastle":
                                    Intent newcastle = new Intent(getContext(), Newcastle2023_24Activity.class);
                                    startActivity(newcastle);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Nottingham":
                                    Intent nottingham = new Intent(getContext(), Nottingham2023_24Activity.class);
                                    startActivity(nottingham);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Sheffield":
                                    Intent sheffield = new Intent(getContext(), Sheffield2023_24Activity.class);
                                    startActivity(sheffield);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Tottenham":
                                    Intent tottenham = new Intent(getContext(), Tottenham2023_24Activity.class);
                                    startActivity(tottenham);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "West Ham":
                                    Intent westham = new Intent(getContext(), WestHam2023_24Activity.class);
                                    startActivity(westham);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Wolves":
                                    Intent wolves = new Intent(getContext(), Wolves2023_24Activity.class);
                                    startActivity(wolves);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;

                            }

                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }
                    }));

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
