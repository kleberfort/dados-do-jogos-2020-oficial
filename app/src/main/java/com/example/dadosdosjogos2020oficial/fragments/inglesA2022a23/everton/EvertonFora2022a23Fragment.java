package com.example.dadosdosjogos2020oficial.fragments.inglesA2022a23.everton;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.dadosdosjogos2020oficial.R;
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.ArsenalActivity;
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.AstonVillaActivity;
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.BournemouthActivity;
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.BrentfordActivity;
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.BrightonActivity;
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.ChelseaActivity;
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.CrystalPalaceActivity;
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.EvertonActivity;
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.FulhamActivity;
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.LeedsUnitedActivity;
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.LeicesterActivity;
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.LiverpoolActivity;
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.ManchesterCityActivity;
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.ManchesterUnitedActivity;
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.NewcastleActivity;
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.NottinghamForestActivity;
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.SouthamptonActivity;
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.TottenhamActivity;
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.WesthamActivity;
import com.example.dadosdosjogos2020oficial.activity.inglesA2022a23.WolverhamptonActivity;
import com.example.dadosdosjogos2020oficial.adapter.alemanhaA2022a23.bayerleverkusen.BayerLeverkusenCasa2022a23Adapter;
import com.example.dadosdosjogos2020oficial.adapter.inglesA2022a2023.everton.EvertonFora2022a23Adapter;
import com.example.dadosdosjogos2020oficial.data.alemanhaA2022a23.bayerleverkusen.BayerLeverkusenCasaA2022a23PartidaApi;
import com.example.dadosdosjogos2020oficial.data.inglesA2022a23.everton.EvertonForaA2022a23PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.FragmentBayerLeverkusenCasa2022a23Binding;
import com.example.dadosdosjogos2020oficial.databinding.FragmentEvertonFora2022a23Binding;
import com.example.dadosdosjogos2020oficial.model.Partida;
import com.example.dadosdosjogos2020oficial.model.RecyclerItemClickListener;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class EvertonFora2022a23Fragment extends Fragment {

    private FragmentEvertonFora2022a23Binding binding;
    private EvertonForaA2022a23PartidaApi evertonForaA2022a23PartidaApi;
    private EvertonFora2022a23Adapter evertonFora2022a23Adapter;


    public EvertonFora2022a23Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentEvertonFora2022a23Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupDadosJogos();


        return view;
    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/ingles-a-2022-23/everton/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        evertonForaA2022a23PartidaApi = retrofit.create(EvertonForaA2022a23PartidaApi.class);


    }

    private void setupDadosJogos() {
        binding.rvEvertonFora.setHasFixedSize(true);
        binding.rvEvertonFora.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvEvertonFora.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        evertonForaA2022a23PartidaApi.getEvertonCasa().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    evertonFora2022a23Adapter = new EvertonFora2022a23Adapter(partidas);
                    binding.rvEvertonFora.setAdapter(evertonFora2022a23Adapter);

                    binding.rvEvertonFora.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), binding.rvEvertonFora, new RecyclerItemClickListener.OnItemClickListener() {
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
                                case "Manchester City":
                                    Intent manchesterCity = new Intent(getContext(), ManchesterCityActivity.class);
                                    startActivity(manchesterCity);
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

