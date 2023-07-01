package com.jogos.dadosoficialkf228920.fragments.alemanhaA2022a23.bayerleverkusen;

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

import com.jogos.dadosoficialkf228920.activity.alemanhaA2022a23.AugsburgActivity;
import com.jogos.dadosoficialkf228920.activity.alemanhaA2022a23.BayernMuniqueActivity;
import com.jogos.dadosoficialkf228920.activity.alemanhaA2022a23.BochumActivity;
import com.jogos.dadosoficialkf228920.activity.alemanhaA2022a23.BorussiaDortmundActivity;
import com.jogos.dadosoficialkf228920.activity.alemanhaA2022a23.BorussiaMonchengladbachActivity;
import com.jogos.dadosoficialkf228920.activity.alemanhaA2022a23.EintrachtFrankfurtActivity;
import com.jogos.dadosoficialkf228920.activity.alemanhaA2022a23.FreiburgActivity;
import com.jogos.dadosoficialkf228920.activity.alemanhaA2022a23.HerthaBerlinActivity;
import com.jogos.dadosoficialkf228920.activity.alemanhaA2022a23.HoffenheimActivity;
import com.jogos.dadosoficialkf228920.activity.alemanhaA2022a23.KolnActivity;
import com.jogos.dadosoficialkf228920.activity.alemanhaA2022a23.Mainz05Activity;
import com.jogos.dadosoficialkf228920.activity.alemanhaA2022a23.RBLeipzigActivity;
import com.jogos.dadosoficialkf228920.activity.alemanhaA2022a23.Schalke04Activity;
import com.jogos.dadosoficialkf228920.activity.alemanhaA2022a23.StuttgartActivity;
import com.jogos.dadosoficialkf228920.activity.alemanhaA2022a23.UnionBerlinActivity;
import com.jogos.dadosoficialkf228920.activity.alemanhaA2022a23.WerderBremenActivity;
import com.jogos.dadosoficialkf228920.activity.alemanhaA2022a23.WolfsburgActivity;
import com.jogos.dadosoficialkf228920.adapter.alemanhaA2022a23.bayerleverkusen.BayerLeverkusenCasa2022a23Adapter;
import com.jogos.dadosoficialkf228920.data.alemanhaA2022a23.bayerleverkusen.BayerLeverkusenCasaA2022a23PartidaApi;
import com.jogos.dadosoficialkf228920.databinding.FragmentBayerLeverkusenCasa2022a23Binding;
import com.jogos.dadosoficialkf228920.model.Partida;
import com.jogos.dadosoficialkf228920.model.RecyclerItemClickListener;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class BayerLeverkusenCasa2022a23Fragment extends Fragment {
    
    private FragmentBayerLeverkusenCasa2022a23Binding binding;
    private BayerLeverkusenCasaA2022a23PartidaApi bayerLeverkusenCasaA2022a23PartidaApi;
    private BayerLeverkusenCasa2022a23Adapter bayerLeverkusenCasa2022a23Adapter;

    public BayerLeverkusenCasa2022a23Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBayerLeverkusenCasa2022a23Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupDadosJogos();
        
        
        return view;
    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/alemanha-a-2022-23/bayer-leverkusen/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        bayerLeverkusenCasaA2022a23PartidaApi = retrofit.create(BayerLeverkusenCasaA2022a23PartidaApi.class);

    }

    private void setupDadosJogos() {
        binding.rvBayerLeverkusenCasa.setHasFixedSize(true);
        binding.rvBayerLeverkusenCasa.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvBayerLeverkusenCasa.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        bayerLeverkusenCasaA2022a23PartidaApi.getBayerLeverkusenCasa().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    bayerLeverkusenCasa2022a23Adapter  = new BayerLeverkusenCasa2022a23Adapter(partidas);
                    binding.rvBayerLeverkusenCasa.setAdapter(bayerLeverkusenCasa2022a23Adapter);

                    binding.rvBayerLeverkusenCasa.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), binding.rvBayerLeverkusenCasa, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {

                            Partida lista = partidas.get(position);

                            switch (lista.getAwayTime().getNome()){
                                case "Augsburg":
                                    Intent augsburg = new Intent(getContext(), AugsburgActivity.class);
                                    startActivity(augsburg);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Bayern de Munique":
                                    Intent bayernMunique = new Intent(getContext(), BayernMuniqueActivity.class);
                                    startActivity(bayernMunique);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Bochum":
                                    Intent bochum = new Intent(getContext(), BochumActivity.class);
                                    startActivity(bochum);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Borussia Dortmund":
                                    Intent borussiaDortmund = new Intent(getContext(), BorussiaDortmundActivity.class);
                                    startActivity(borussiaDortmund);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Borussia Mönchengladbach":
                                    Intent borussiaMonchengladbach = new Intent(getContext(), BorussiaMonchengladbachActivity.class);
                                    startActivity(borussiaMonchengladbach);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Köln(Colônia)":
                                    Intent koln = new Intent(getContext(), KolnActivity.class);
                                    startActivity(koln);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Eintracht Frankfurt":
                                    Intent eintracthFrankfurt = new Intent(getContext(), EintrachtFrankfurtActivity.class);
                                    startActivity(eintracthFrankfurt);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Freiburg":
                                    Intent freiburg = new Intent(getContext(), FreiburgActivity.class);
                                    startActivity(freiburg);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Hertha Berlin":
                                    Intent herthaBerlin = new Intent(getContext(), HerthaBerlinActivity.class);
                                    startActivity(herthaBerlin);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Hoffenheim":
                                    Intent hoffenheim = new Intent(getContext(), HoffenheimActivity.class);
                                    startActivity(hoffenheim);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Mainz 05":
                                    Intent mainz05 = new Intent(getContext(), Mainz05Activity.class);
                                    startActivity(mainz05);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "RB Leipzig":
                                    Intent leipzig = new Intent(getContext(), RBLeipzigActivity.class);
                                    startActivity(leipzig);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Schalke 04":
                                    Intent schalke04 = new Intent(getContext(), Schalke04Activity.class);
                                    startActivity(schalke04);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Stuttgart":
                                    Intent stuttgart = new Intent(getContext(), StuttgartActivity.class);
                                    startActivity(stuttgart);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Union Berlin":
                                    Intent unionBerlin = new Intent(getContext(), UnionBerlinActivity.class);
                                    startActivity(unionBerlin);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Werder Bremen":
                                    Intent werderBremen = new Intent(getContext(), WerderBremenActivity.class);
                                    startActivity(werderBremen);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Wolfsburg":
                                    Intent wolfburg = new Intent(getContext(), WolfsburgActivity.class);
                                    startActivity(wolfburg);
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