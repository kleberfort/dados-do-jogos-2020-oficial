package com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.franca.toulouse;

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
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Brest2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Clermont2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.LeHavre2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Lens2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Lille2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Lorient2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Lyon2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Marseille2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Metz2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Monaco2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Montpellier2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Nantes2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.OgcNice2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Psg2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Reims2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Rennes2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Strasbourg2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Toulouse2023_24Activity;
import com.jogos.dadosoficialkf228920.adapter.europa2023a24.franca.toulouse.ToulouseForaAdapter;
import com.jogos.dadosoficialkf228920.data.europaA2023a24.franca.toulouse.ToulouseForaPartidaApi;
import com.jogos.dadosoficialkf228920.databinding.FragmentToulouseFora2023a24Binding;
import com.jogos.dadosoficialkf228920.model.Partida;
import com.jogos.dadosoficialkf228920.model.RecyclerItemClickListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ToulouseForaFragment extends Fragment {

    private FragmentToulouseFora2023a24Binding binding;
    private ToulouseForaPartidaApi toulouseForaPartidaApi;
    private ToulouseForaAdapter toulouseForaAdapter;



    public ToulouseForaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentToulouseFora2023a24Binding.inflate(inflater, container, false);
        View view = binding.getRoot();

        setupHttpClient();
        setupDadosJogos();

        return view;
    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/europa-a-2023-24/franca/toulouse/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        toulouseForaPartidaApi = retrofit.create(ToulouseForaPartidaApi.class);

    }

    private void setupDadosJogos() {
        binding.rvListaJogos.setHasFixedSize(true);
        binding.rvListaJogos.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvListaJogos.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        toulouseForaPartidaApi.getToulouseFora().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    toulouseForaAdapter = new ToulouseForaAdapter(partidas);
                    binding.rvListaJogos.setAdapter(toulouseForaAdapter);

                    binding.rvListaJogos.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), binding.rvListaJogos, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {

                            Partida lista = partidas.get(position);

                            switch (lista.getHomeTime().getNome()){
                                case "Brest":
                                    Intent brest = new Intent(getContext(), Brest2023_24Activity.class);
                                    startActivity(brest);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Clermont":
                                    Intent clermont = new Intent(getContext(), Clermont2023_24Activity.class);
                                    startActivity(clermont);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Le-Havre":
                                    Intent havre = new Intent(getContext(), LeHavre2023_24Activity.class);
                                    startActivity(havre);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Lens":
                                    Intent lens = new Intent(getContext(), Lens2023_24Activity.class);
                                    startActivity(lens);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Lille":
                                    Intent lille = new Intent(getContext(), Lille2023_24Activity.class);
                                    startActivity(lille);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Lorient":
                                    Intent lorient = new Intent(getContext(), Lorient2023_24Activity.class);
                                    startActivity(lorient);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Lyon":
                                    Intent lyon = new Intent(getContext(), Lyon2023_24Activity.class);
                                    startActivity(lyon);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Marseille":
                                    Intent marseille = new Intent(getContext(), Marseille2023_24Activity.class);
                                    startActivity(marseille);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Metz":
                                    Intent metz = new Intent(getContext(), Metz2023_24Activity.class);
                                    startActivity(metz);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Monaco":
                                    Intent monaco = new Intent(getContext(), Monaco2023_24Activity.class);
                                    startActivity(monaco);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Montpellier":
                                    Intent montpellier = new Intent(getContext(), Montpellier2023_24Activity.class);
                                    startActivity(montpellier);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Nantes":
                                    Intent nantes = new Intent(getContext(), Nantes2023_24Activity.class);
                                    startActivity(nantes);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Nice":
                                    Intent nice = new Intent(getContext(), OgcNice2023_24Activity.class);
                                    startActivity(nice);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "PSG":
                                    Intent psg = new Intent(getContext(), Psg2023_24Activity.class);
                                    startActivity(psg);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Reims":
                                    Intent reims = new Intent(getContext(), Reims2023_24Activity.class);
                                    startActivity(reims);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Rennes":
                                    Intent rennes = new Intent(getContext(), Rennes2023_24Activity.class);
                                    startActivity(rennes);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Strasbourg":
                                    Intent strasbourg = new Intent(getContext(), Strasbourg2023_24Activity.class);
                                    startActivity(strasbourg);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Toulouse":
                                    Intent toulouse = new Intent(getContext(), Toulouse2023_24Activity.class);
                                    startActivity(toulouse);
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
