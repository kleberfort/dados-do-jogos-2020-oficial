package com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.italia.monza;

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
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.Atalanta2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.Bologna2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.Cagliari2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.Empoli2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.Fiorentina2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.Frosinone2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.Genoa2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.HellasVerona2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.InterMilao2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.Juventus2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.Lazio2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.Lecce2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.Monza2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.Napoli2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.Roma2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.Salernitana2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.Sassuolo2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.Torino2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.Udinese2023_24Activity;
import com.jogos.dadosoficialkf228920.adapter.europa2023a24.italia.monza.MonzaCasaAdapter;
import com.jogos.dadosoficialkf228920.data.europaA2023a24.italia.monza.MonzaCasaPartidaApi;
import com.jogos.dadosoficialkf228920.databinding.FragmentMonzaCasa2023a24Binding;
import com.jogos.dadosoficialkf228920.model.Partida;
import com.jogos.dadosoficialkf228920.model.RecyclerItemClickListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MonzaCasaFragment extends Fragment {

    private FragmentMonzaCasa2023a24Binding binding;
    private MonzaCasaPartidaApi monzaCasaPartidaApi;
    private MonzaCasaAdapter monzaCasaAdapter;



    public MonzaCasaFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentMonzaCasa2023a24Binding.inflate(inflater, container, false);
        View view = binding.getRoot();

        setupHttpClient();
        setupDadosJogos();


        return view;
    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/europa-a-2023-24/italiano/monza/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        monzaCasaPartidaApi = retrofit.create(MonzaCasaPartidaApi.class);

    }

    private void setupDadosJogos() {
        binding.rvListaJogos.setHasFixedSize(true);
        binding.rvListaJogos.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvListaJogos.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        monzaCasaPartidaApi.getMonzaCasa().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {

                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    monzaCasaAdapter = new MonzaCasaAdapter(partidas);
                    binding.rvListaJogos.setAdapter(monzaCasaAdapter);

                    binding.rvListaJogos.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), binding.rvListaJogos, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {

                            Partida lista = partidas.get(position);

                            switch (lista.getAwayTime().getNome()){

                                case "Atalanta":
                                    Intent atalanta = new Intent(getContext(), Atalanta2023_24Activity.class);
                                    startActivity(atalanta);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Bologna":
                                    Intent bologna = new Intent(getContext(), Bologna2023_24Activity.class);
                                    startActivity(bologna);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Cagliari":
                                    Intent cagliari = new Intent(getContext(), Cagliari2023_24Activity.class);
                                    startActivity(cagliari);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Empoli":
                                    Intent empoli = new Intent(getContext(), Empoli2023_24Activity.class);
                                    startActivity(empoli);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Fiorentina":
                                    Intent fiorentina = new Intent(getContext(), Fiorentina2023_24Activity.class);
                                    startActivity(fiorentina);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Frosinone":
                                    Intent frosinone = new Intent(getContext(), Frosinone2023_24Activity.class);
                                    startActivity(frosinone);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Genoa":
                                    Intent genoa = new Intent(getContext(), Genoa2023_24Activity.class);
                                    startActivity(genoa);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Verona":
                                    Intent verona = new Intent(getContext(), HellasVerona2023_24Activity.class);
                                    startActivity(verona);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Inter":
                                    Intent inter = new Intent(getContext(), InterMilao2023_24Activity.class);
                                    startActivity(inter);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Juventus":
                                    Intent juventus = new Intent(getContext(), Juventus2023_24Activity.class);
                                    startActivity(juventus);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Lazio":
                                    Intent lazio = new Intent(getContext(), Lazio2023_24Activity.class);
                                    startActivity(lazio);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Lecce":
                                    Intent lecce = new Intent(getContext(), Lecce2023_24Activity.class);
                                    startActivity(lecce);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Monza":
                                    Intent monza = new Intent(getContext(), Monza2023_24Activity.class);
                                    startActivity(monza);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Napoli":
                                    Intent napoli = new Intent(getContext(), Napoli2023_24Activity.class);
                                    startActivity(napoli);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Roma":
                                    Intent roma = new Intent(getContext(), Roma2023_24Activity.class);
                                    startActivity(roma);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Salernitana":
                                    Intent salernitana = new Intent(getContext(), Salernitana2023_24Activity.class);
                                    startActivity(salernitana);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Sassuolo":
                                    Intent sassuolo = new Intent(getContext(), Sassuolo2023_24Activity.class);
                                    startActivity(sassuolo);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Torino":
                                    Intent torino = new Intent(getContext(), Torino2023_24Activity.class);
                                    startActivity(torino);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Udinese":
                                    Intent udinese = new Intent(getContext(), Udinese2023_24Activity.class);
                                    startActivity(udinese);
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
