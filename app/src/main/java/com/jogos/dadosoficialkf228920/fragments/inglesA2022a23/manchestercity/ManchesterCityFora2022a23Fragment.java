package com.jogos.dadosoficialkf228920.fragments.inglesA2022a23.manchestercity;

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
import com.jogos.dadosoficialkf228920.activity.inglesA2022a23.ArsenalActivity;
import com.jogos.dadosoficialkf228920.activity.inglesA2022a23.AstonVillaActivity;
import com.jogos.dadosoficialkf228920.activity.inglesA2022a23.BournemouthActivity;
import com.jogos.dadosoficialkf228920.activity.inglesA2022a23.BrentfordActivity;
import com.jogos.dadosoficialkf228920.activity.inglesA2022a23.BrightonActivity;
import com.jogos.dadosoficialkf228920.activity.inglesA2022a23.ChelseaActivity;
import com.jogos.dadosoficialkf228920.activity.inglesA2022a23.CrystalPalaceActivity;
import com.jogos.dadosoficialkf228920.activity.inglesA2022a23.EvertonActivity;
import com.jogos.dadosoficialkf228920.activity.inglesA2022a23.FulhamActivity;
import com.jogos.dadosoficialkf228920.activity.inglesA2022a23.LeedsUnitedActivity;
import com.jogos.dadosoficialkf228920.activity.inglesA2022a23.LeicesterActivity;
import com.jogos.dadosoficialkf228920.activity.inglesA2022a23.LiverpoolActivity;
import com.jogos.dadosoficialkf228920.activity.inglesA2022a23.ManchesterUnitedActivity;
import com.jogos.dadosoficialkf228920.activity.inglesA2022a23.NewcastleActivity;
import com.jogos.dadosoficialkf228920.activity.inglesA2022a23.NottinghamForestActivity;
import com.jogos.dadosoficialkf228920.activity.inglesA2022a23.SouthamptonActivity;
import com.jogos.dadosoficialkf228920.activity.inglesA2022a23.TottenhamActivity;
import com.jogos.dadosoficialkf228920.activity.inglesA2022a23.WesthamActivity;
import com.jogos.dadosoficialkf228920.activity.inglesA2022a23.WolverhamptonActivity;
import com.jogos.dadosoficialkf228920.adapter.inglesA2022a2023.manchestercity.ManchesterCityFora2022a23Adapter;
import com.jogos.dadosoficialkf228920.data.inglesA2022a23.manchestercity.ManchesterCityForaA2022a23PartidaApi;
import com.jogos.dadosoficialkf228920.databinding.FragmentManchesterCityFora2022a23Binding;
import com.jogos.dadosoficialkf228920.model.Partida;
import com.jogos.dadosoficialkf228920.model.RecyclerItemClickListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ManchesterCityFora2022a23Fragment extends Fragment {

    private FragmentManchesterCityFora2022a23Binding binding;
    private ManchesterCityForaA2022a23PartidaApi manchesterCityForaA2022a23PartidaApi;
    private ManchesterCityFora2022a23Adapter manchesterCityFora2022a23Adapter;


    public ManchesterCityFora2022a23Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentManchesterCityFora2022a23Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupDadosJogos();


        return view;
    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/ingles-a-2022-23/manchester-city/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        manchesterCityForaA2022a23PartidaApi = retrofit.create(ManchesterCityForaA2022a23PartidaApi.class);

    }

    private void setupDadosJogos() {
        binding.rvManchesterCityFora.setHasFixedSize(true);
        binding.rvManchesterCityFora.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvManchesterCityFora.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        manchesterCityForaA2022a23PartidaApi.getManchesterCityFora().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    manchesterCityFora2022a23Adapter = new ManchesterCityFora2022a23Adapter(partidas);
                    binding.rvManchesterCityFora.setAdapter(manchesterCityFora2022a23Adapter);

                    binding.rvManchesterCityFora.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), binding.rvManchesterCityFora, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Partida lista = partidas.get(position);

                            switch (lista.getHomeTime().getNome()){
                                case "Arsenal":
                                    Intent arsenal = new Intent(getContext(), ArsenalActivity.class);
                                    startActivity(arsenal);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Aston Villa":
                                    Intent astonVilla = new Intent(getContext(), AstonVillaActivity.class);
                                    startActivity(astonVilla);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Bournemouth":
                                    Intent bournemouth = new Intent(getContext(), BournemouthActivity.class);
                                    startActivity(bournemouth);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Brentford":
                                    Intent brentford = new Intent(getContext(), BrentfordActivity.class);
                                    startActivity(brentford);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Brighton":
                                    Intent brighton = new Intent(getContext(), BrightonActivity.class);
                                    startActivity(brighton);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Chelsea":
                                    Intent chelsea = new Intent(getContext(), ChelseaActivity.class);
                                    startActivity(chelsea);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Crystal Palace":
                                    Intent crystalPalace = new Intent(getContext(), CrystalPalaceActivity.class);
                                    startActivity(crystalPalace);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Everton":
                                    Intent everton = new Intent(getContext(), EvertonActivity.class);
                                    startActivity(everton);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Fulham":
                                    Intent fulham = new Intent(getContext(), FulhamActivity.class);
                                    startActivity(fulham);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Leeds United":
                                    Intent leedsUnited = new Intent(getContext(), LeedsUnitedActivity.class);
                                    startActivity(leedsUnited);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Leicester":
                                    Intent leicester = new Intent(getContext(), LeicesterActivity.class);
                                    startActivity(leicester);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Liverpool":
                                    Intent liverpool = new Intent(getContext(), LiverpoolActivity.class);
                                    startActivity(liverpool);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Manchester United":
                                    Intent manchesterUnited = new Intent(getContext(), ManchesterUnitedActivity.class);
                                    startActivity(manchesterUnited);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Newcastle":
                                    Intent newcastle = new Intent(getContext(), NewcastleActivity.class);
                                    startActivity(newcastle);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Nottingham Forestla":
                                    Intent nottingham = new Intent(getContext(), NottinghamForestActivity.class);
                                    startActivity(nottingham);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Southampton":
                                    Intent southampton = new Intent(getContext(), SouthamptonActivity.class);
                                    startActivity(southampton);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Tottenham":
                                    Intent tottenham = new Intent(getContext(), TottenhamActivity.class);
                                    startActivity(tottenham);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "West Ham":
                                    Intent westHam = new Intent(getContext(), WesthamActivity.class);
                                    startActivity(westHam);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Wolverhampton":
                                    Intent wolverhampton = new Intent(getContext(), WolverhamptonActivity.class);
                                    startActivity(wolverhampton);
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

