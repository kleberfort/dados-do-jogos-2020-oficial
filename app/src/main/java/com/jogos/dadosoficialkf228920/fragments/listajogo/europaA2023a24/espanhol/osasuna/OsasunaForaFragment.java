package com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.espanhol.osasuna;

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
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.Alaves2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.Almeria2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.AthleticBilbao2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.AtleticoMadrid2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.Barcelona2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.Cadiz2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.CeltaVigo2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.Getafe2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.Girona2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.Granada2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.LasPalmas2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.Mallorca2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.Osasuna2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.RayoVallecano2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.RealBetis2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.RealMadrid2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.RealSociedad2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.Sevilla2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.Valencia2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.Villarreal2023_24Activity;
import com.jogos.dadosoficialkf228920.adapter.europa2023a24.espanhol.osasuna.OsasunaForaAdapter;
import com.jogos.dadosoficialkf228920.data.europaA2023a24.espanhol.osasuna.OsasunaForaPartidaApi;
import com.jogos.dadosoficialkf228920.databinding.FragmentOsasunaFora2023a24Binding;
import com.jogos.dadosoficialkf228920.model.Partida;
import com.jogos.dadosoficialkf228920.model.RecyclerItemClickListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OsasunaForaFragment extends Fragment {

    private FragmentOsasunaFora2023a24Binding binding;
    private OsasunaForaPartidaApi osasunaForaPartidaApi;
    private OsasunaForaAdapter osasunaForaAdapter;



    public OsasunaForaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentOsasunaFora2023a24Binding.inflate(inflater, container, false);
        View view = binding.getRoot();

        setupHttpClient();
        setupDadosJogos();

        return view;
    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/europa-a-2023-24/espanhol/osasuna/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        osasunaForaPartidaApi = retrofit.create(OsasunaForaPartidaApi.class);

    }

    private void setupDadosJogos() {
        binding.rvListaJogos.setHasFixedSize(true);
        binding.rvListaJogos.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvListaJogos.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        osasunaForaPartidaApi.getOsasunaFora().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    osasunaForaAdapter = new OsasunaForaAdapter(partidas);
                    binding.rvListaJogos.setAdapter(osasunaForaAdapter);

                    binding.rvListaJogos.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), binding.rvListaJogos, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {

                            Partida lista = partidas.get(position);

                            switch (lista.getHomeTime().getNome()){
                                case "Alaves":
                                    Intent alaves = new Intent(getContext(), Alaves2023_24Activity.class);
                                    startActivity(alaves);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Almeria":
                                    Intent almeria = new Intent(getContext(), Almeria2023_24Activity.class);
                                    startActivity(almeria);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Bilbao":
                                    Intent bilbao = new Intent(getContext(), AthleticBilbao2023_24Activity.class);
                                    startActivity(bilbao);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Atlético":
                                    Intent atletico = new Intent(getContext(), AtleticoMadrid2023_24Activity.class);
                                    startActivity(atletico);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Barcelona":
                                    Intent barcelona = new Intent(getContext(), Barcelona2023_24Activity.class);
                                    startActivity(barcelona);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Cadiz":
                                    Intent cadiz = new Intent(getContext(), Cadiz2023_24Activity.class);
                                    startActivity(cadiz);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Celta Vigo":
                                    Intent celta = new Intent(getContext(), CeltaVigo2023_24Activity.class);
                                    startActivity(celta);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Getafe":
                                    Intent getafe = new Intent(getContext(), Getafe2023_24Activity.class);
                                    startActivity(getafe);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Girona":
                                    Intent girona = new Intent(getContext(), Girona2023_24Activity.class);
                                    startActivity(girona);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Granada":
                                    Intent granada = new Intent(getContext(), Granada2023_24Activity.class);
                                    startActivity(granada);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Las Palmas":
                                    Intent palmas = new Intent(getContext(), LasPalmas2023_24Activity.class);
                                    startActivity(palmas);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Mallorca":
                                    Intent mallorca = new Intent(getContext(), Mallorca2023_24Activity.class);
                                    startActivity(mallorca);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Osasuna":
                                    Intent osasuna = new Intent(getContext(), Osasuna2023_24Activity.class);
                                    startActivity(osasuna);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Vallecano":
                                    Intent vallecano = new Intent(getContext(), RayoVallecano2023_24Activity.class);
                                    startActivity(vallecano);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Betis":
                                    Intent betis = new Intent(getContext(), RealBetis2023_24Activity.class);
                                    startActivity(betis);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Real Madrid":
                                    Intent madrid = new Intent(getContext(), RealMadrid2023_24Activity.class);
                                    startActivity(madrid);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Sociedad":
                                    Intent sociedad = new Intent(getContext(), RealSociedad2023_24Activity.class);
                                    startActivity(sociedad);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Sevilla":
                                    Intent sevilla = new Intent(getContext(), Sevilla2023_24Activity.class);
                                    startActivity(sevilla);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Valencia":
                                    Intent valencia = new Intent(getContext(), Valencia2023_24Activity.class);
                                    startActivity(valencia);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;

                                case "Villarreal":
                                    Intent villarreal = new Intent(getContext(), Villarreal2023_24Activity.class);
                                    startActivity(villarreal);
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
