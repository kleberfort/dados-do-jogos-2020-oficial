package com.example.dadosdosjogos2020oficial.fragments.inglesA2022a23.nottinghamforest;

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
import com.example.dadosdosjogos2020oficial.adapter.inglesA2022a2023.nottinghamforest.NottinghamForestFora2022a23Adapter;
import com.example.dadosdosjogos2020oficial.data.alemanhaA2022a23.bayerleverkusen.BayerLeverkusenCasaA2022a23PartidaApi;
import com.example.dadosdosjogos2020oficial.data.inglesA2022a23.nottinghamforest.NottinghamForestForaA2022a23PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.FragmentBayerLeverkusenCasa2022a23Binding;
import com.example.dadosdosjogos2020oficial.databinding.FragmentNottinghamForestFora2022a23Binding;
import com.example.dadosdosjogos2020oficial.model.Partida;
import com.example.dadosdosjogos2020oficial.model.RecyclerItemClickListener;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class NottinghamForestFora2022a23Fragment extends Fragment {

    private FragmentNottinghamForestFora2022a23Binding binding;
    private NottinghamForestForaA2022a23PartidaApi nottinghamForestForaA2022a23PartidaApi;
    private NottinghamForestFora2022a23Adapter nottinghamForestFora2022a23Adapter;

    public NottinghamForestFora2022a23Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentNottinghamForestFora2022a23Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupDadosJogos();


        return view;
    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/ingles-a-2022-23/nottingham-forest/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        nottinghamForestForaA2022a23PartidaApi = retrofit.create(NottinghamForestForaA2022a23PartidaApi.class);


    }

    private void setupDadosJogos() {
        binding.rvNottinghamForestFora.setHasFixedSize(true);
        binding.rvNottinghamForestFora.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvNottinghamForestFora.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        nottinghamForestForaA2022a23PartidaApi.getNottinghamForestCasa().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    nottinghamForestFora2022a23Adapter = new NottinghamForestFora2022a23Adapter(partidas);
                    binding.rvNottinghamForestFora.setAdapter(nottinghamForestFora2022a23Adapter);

                    binding.rvNottinghamForestFora.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), binding.rvNottinghamForestFora, new RecyclerItemClickListener.OnItemClickListener() {
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




