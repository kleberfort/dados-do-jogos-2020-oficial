package com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.alemanha.borussiadortmund;

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
import com.jogos.dadosoficialkf228920.activity.alemanhaA2022a23.BayerLeverkusenActivity;
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
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.alemanha.Augsburg2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.alemanha.BayerLeverkusen2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.alemanha.BayernMunique2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.alemanha.Bochum2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.alemanha.BorussiaDortmund2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.alemanha.BorussiaMonche2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.alemanha.Darmstadt2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.alemanha.EintrachtFrankfurt2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.alemanha.Freiburg2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.alemanha.Heidenheim2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.alemanha.Hoffenheim2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.alemanha.Koln2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.alemanha.Leipzig2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.alemanha.Mainz2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.alemanha.Stuttgart2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.alemanha.UnionBerlin2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.alemanha.WerderBremen2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.alemanha.Wolfsburg2023_24Activity;
import com.jogos.dadosoficialkf228920.adapter.alemanhaA2022a23.augsburg.AugsburgFora2022a23Adapter;
import com.jogos.dadosoficialkf228920.adapter.europa2023a24.alemanha.borussiadortmund.BorussiaDortmundForaAdapter;
import com.jogos.dadosoficialkf228920.data.alemanhaA2022a23.augsburg.AugsburgForaA2022a23PartidaApi;
import com.jogos.dadosoficialkf228920.data.brasileiroA2023.americaMG.AmericaMgForaA2023PartidaApi;
import com.jogos.dadosoficialkf228920.data.europaA2023a24.alemanha.augsburg.AugsburgForaPartidaApi;
import com.jogos.dadosoficialkf228920.data.europaA2023a24.alemanha.borussiadortmund.BorussiaDortmundCasaPartidaApi;
import com.jogos.dadosoficialkf228920.data.europaA2023a24.alemanha.borussiadortmund.BorussiaDortmundForaPartidaApi;
import com.jogos.dadosoficialkf228920.databinding.FragmentAugsburgFora2022a23Binding;
import com.jogos.dadosoficialkf228920.databinding.FragmentAugsburgFora2023a24Binding;
import com.jogos.dadosoficialkf228920.databinding.FragmentBorussiaDortmundFora2023a24Binding;
import com.jogos.dadosoficialkf228920.databinding.TelaEstatisticaOficialPorcentagemBinding;
import com.jogos.dadosoficialkf228920.model.Partida;
import com.jogos.dadosoficialkf228920.model.RecyclerItemClickListener;

import org.jetbrains.annotations.Nullable;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BorussiaDortmundForaFragment extends Fragment {

    private FragmentBorussiaDortmundFora2023a24Binding binding;
    private BorussiaDortmundForaPartidaApi borussiaDortmundForaPartidaApi;
    private BorussiaDortmundForaAdapter borussiaDortmundForaAdapter;



    public BorussiaDortmundForaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBorussiaDortmundFora2023a24Binding.inflate(inflater, container, false);
        View view = binding.getRoot();

        setupHttpClient();
        setupDadosJogos();

        return view;
    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/europa-a-2023-24/alemanha/borussia-dortmund/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        borussiaDortmundForaPartidaApi = retrofit.create(BorussiaDortmundForaPartidaApi.class);

    }

    private void setupDadosJogos() {
        binding.rvListaJogos.setHasFixedSize(true);
        binding.rvListaJogos.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvListaJogos.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        borussiaDortmundForaPartidaApi.getBorussiaDortmundFora().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    borussiaDortmundForaAdapter = new BorussiaDortmundForaAdapter(partidas);
                    binding.rvListaJogos.setAdapter(borussiaDortmundForaAdapter);

                    binding.rvListaJogos.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), binding.rvListaJogos, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {

                            Partida lista = partidas.get(position);

                            switch (lista.getHomeTime().getNome()){
                                case "Augsburg":
                                    Intent augsburg = new Intent(getContext(), Augsburg2023_24Activity.class);
                                    startActivity(augsburg);
                                    //Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;

                                case "Leverkusen":
                                    Intent bayerLeverkusen = new Intent(getContext(), BayerLeverkusen2023_24Activity.class);
                                    startActivity(bayerLeverkusen);
                                    //Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Bayern":
                                    Intent bayernMunique = new Intent(getContext(), BayernMunique2023_24Activity.class);
                                    startActivity(bayernMunique);
                                    //Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Bochum":
                                    Intent bochum = new Intent(getContext(), Bochum2023_24Activity.class);
                                    startActivity(bochum);
                                    //Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Dortmund":
                                    Intent borussiaDortmund = new Intent(getContext(), BorussiaDortmund2023_24Activity.class);
                                    startActivity(borussiaDortmund);
                                    //Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Mönche":
                                    Intent borussiaMonchengladbach = new Intent(getContext(), BorussiaMonche2023_24Activity.class);
                                    startActivity(borussiaMonchengladbach);
                                    //Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Darmstadt":
                                    Intent darmstadt = new Intent(getContext(), Darmstadt2023_24Activity.class);
                                    startActivity(darmstadt);
                                    //Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Frankfurt":
                                    Intent eintracthFrankfurt = new Intent(getContext(), EintrachtFrankfurt2023_24Activity.class);
                                    startActivity(eintracthFrankfurt);
                                    //Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Freiburg":
                                    Intent freiburg = new Intent(getContext(), Freiburg2023_24Activity.class);
                                    startActivity(freiburg);
                                    //Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Heidenheim":
                                    Intent heidenheim = new Intent(getContext(), Heidenheim2023_24Activity.class);
                                    startActivity(heidenheim);
                                    //Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Hoffenheim":
                                    Intent hoffenheim = new Intent(getContext(), Hoffenheim2023_24Activity.class);
                                    startActivity(hoffenheim);
                                    //Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Köln(Colônia)":
                                    Intent koln = new Intent(getContext(), Koln2023_24Activity.class);
                                    startActivity(koln);
                                    //Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Leipzig":
                                    Intent leipzig = new Intent(getContext(), Leipzig2023_24Activity.class);
                                    startActivity(leipzig);
                                    //Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Mainz 05":
                                    Intent mainz05 = new Intent(getContext(), Mainz2023_24Activity.class);
                                    startActivity(mainz05);
                                    //Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Stuttgart":
                                    Intent stuttgart = new Intent(getContext(), Stuttgart2023_24Activity.class);
                                    startActivity(stuttgart);
                                    //Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Union Berlin":
                                    Intent unionBerlin = new Intent(getContext(), UnionBerlin2023_24Activity.class);
                                    startActivity(unionBerlin);
                                    //Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Werder Bremen":
                                    Intent werderBremen = new Intent(getContext(), WerderBremen2023_24Activity.class);
                                    startActivity(werderBremen);
                                    //Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Wolfsburg":
                                    Intent wolfburg = new Intent(getContext(), Wolfsburg2023_24Activity.class);
                                    startActivity(wolfburg);
                                    //Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
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
