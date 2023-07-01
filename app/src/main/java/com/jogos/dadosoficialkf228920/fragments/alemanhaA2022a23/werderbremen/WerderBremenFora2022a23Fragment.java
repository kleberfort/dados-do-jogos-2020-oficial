package com.jogos.dadosoficialkf228920.fragments.alemanhaA2022a23.werderbremen;

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
import com.jogos.dadosoficialkf228920.activity.alemanhaA2022a23.AugsburgActivity;
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
import com.jogos.dadosoficialkf228920.activity.alemanhaA2022a23.WolfsburgActivity;
import com.jogos.dadosoficialkf228920.adapter.alemanhaA2022a23.werderbremen.WerderBremenFora2022a23Adapter;
import com.jogos.dadosoficialkf228920.data.alemanhaA2022a23.werderbremen.WerderBremenForaA2022a23PartidaApi;
import com.jogos.dadosoficialkf228920.databinding.FragmentWerderBremenFora2022a23Binding;
import com.jogos.dadosoficialkf228920.model.Partida;
import com.jogos.dadosoficialkf228920.model.RecyclerItemClickListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class WerderBremenFora2022a23Fragment extends Fragment {

    private FragmentWerderBremenFora2022a23Binding binding;
    private WerderBremenForaA2022a23PartidaApi werderBremenForaA2022a23PartidaApi;
    private WerderBremenFora2022a23Adapter werderBremenFora2022a23Adapter;


    public WerderBremenFora2022a23Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentWerderBremenFora2022a23Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupDadosJogos();


        return view;
    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/alemanha-a-2022-23/werder-bremen/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        werderBremenForaA2022a23PartidaApi = retrofit.create(WerderBremenForaA2022a23PartidaApi.class);

    }

    private void setupDadosJogos() {
        binding.rvWerderBremenFora.setHasFixedSize(true);
        binding.rvWerderBremenFora.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvWerderBremenFora.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        werderBremenForaA2022a23PartidaApi.getWerderBremenora().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    werderBremenFora2022a23Adapter = new WerderBremenFora2022a23Adapter(partidas);
                    binding.rvWerderBremenFora.setAdapter(werderBremenFora2022a23Adapter);

                    binding.rvWerderBremenFora.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), binding.rvWerderBremenFora, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {

                            Partida lista = partidas.get(position);

                            switch (lista.getHomeTime().getNome()){
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

