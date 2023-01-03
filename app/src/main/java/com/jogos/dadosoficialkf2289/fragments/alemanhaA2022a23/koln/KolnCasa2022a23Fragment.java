package com.jogos.dadosoficialkf2289.fragments.alemanhaA2022a23.koln;

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

import com.jogos.dadosoficialkf2289.R;
import com.jogos.dadosoficialkf2289.activity.alemanhaA2022a23.AugsburgActivity;
import com.jogos.dadosoficialkf2289.activity.alemanhaA2022a23.BayerLeverkusenActivity;
import com.jogos.dadosoficialkf2289.activity.alemanhaA2022a23.BayernMuniqueActivity;
import com.jogos.dadosoficialkf2289.activity.alemanhaA2022a23.BochumActivity;
import com.jogos.dadosoficialkf2289.activity.alemanhaA2022a23.BorussiaDortmundActivity;
import com.jogos.dadosoficialkf2289.activity.alemanhaA2022a23.BorussiaMonchengladbachActivity;
import com.jogos.dadosoficialkf2289.activity.alemanhaA2022a23.EintrachtFrankfurtActivity;
import com.jogos.dadosoficialkf2289.activity.alemanhaA2022a23.FreiburgActivity;
import com.jogos.dadosoficialkf2289.activity.alemanhaA2022a23.HerthaBerlinActivity;
import com.jogos.dadosoficialkf2289.activity.alemanhaA2022a23.HoffenheimActivity;
import com.jogos.dadosoficialkf2289.activity.alemanhaA2022a23.Mainz05Activity;
import com.jogos.dadosoficialkf2289.activity.alemanhaA2022a23.RBLeipzigActivity;
import com.jogos.dadosoficialkf2289.activity.alemanhaA2022a23.Schalke04Activity;
import com.jogos.dadosoficialkf2289.activity.alemanhaA2022a23.StuttgartActivity;
import com.jogos.dadosoficialkf2289.activity.alemanhaA2022a23.UnionBerlinActivity;
import com.jogos.dadosoficialkf2289.activity.alemanhaA2022a23.WerderBremenActivity;
import com.jogos.dadosoficialkf2289.activity.alemanhaA2022a23.WolfsburgActivity;
import com.jogos.dadosoficialkf2289.adapter.alemanhaA2022a23.koln.KolnCasa2022a23Adapter;
import com.jogos.dadosoficialkf2289.data.alemanhaA2022a23.koln.KolnCasaA2022a23PartidaApi;
import com.jogos.dadosoficialkf2289.databinding.FragmentBayerLeverkusenCasa2022a23Binding;
import com.jogos.dadosoficialkf2289.databinding.FragmentKolnCasa2022a23Binding;
import com.jogos.dadosoficialkf2289.model.Partida;
import com.jogos.dadosoficialkf2289.model.RecyclerItemClickListener;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class KolnCasa2022a23Fragment extends Fragment {


    private FragmentKolnCasa2022a23Binding binding;
    private KolnCasaA2022a23PartidaApi kolnCasaA2022a23PartidaApi;
    private KolnCasa2022a23Adapter kolnCasa2022a23Adapter;


    public KolnCasa2022a23Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentKolnCasa2022a23Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupDadosJogos();


        return view;
    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/alemanha-a-2022-23/koln/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        kolnCasaA2022a23PartidaApi = retrofit.create(KolnCasaA2022a23PartidaApi.class);
    }

    private void setupDadosJogos() {
        binding.rvKolnCasa.setHasFixedSize(true);
        binding.rvKolnCasa.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvKolnCasa.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        kolnCasaA2022a23PartidaApi.getKolnCasa().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    kolnCasa2022a23Adapter = new KolnCasa2022a23Adapter(partidas);
                    binding.rvKolnCasa.setAdapter(kolnCasa2022a23Adapter);

                    binding.rvKolnCasa.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), binding.rvKolnCasa, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {

                            Partida lista = partidas.get(position);

                            switch (lista.getAwayTime().getNome()){
                                case "Augsburg":
                                    Intent augsburg = new Intent(getContext(), AugsburgActivity.class);
                                    startActivity(augsburg);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Bayer Leverkusen":
                                    Intent bayerLeverkusen = new Intent(getContext(), BayerLeverkusenActivity.class);
                                    startActivity(bayerLeverkusen);
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
