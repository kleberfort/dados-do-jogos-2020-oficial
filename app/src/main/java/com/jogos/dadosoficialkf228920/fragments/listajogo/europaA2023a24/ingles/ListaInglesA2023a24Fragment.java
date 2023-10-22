package com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.ingles;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.snackbar.Snackbar;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Arsenal2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.AstonVilla2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Bournemouth2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Brentford2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Brighton2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Burnley2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Chelsea2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.CrystalPalace2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Everton2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Fulham2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Liverpool2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Luton2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.ManchesterCity2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.ManchesterUnited2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Newcastle2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Nottingham2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Sheffield2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Tottenham2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.WestHam2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Wolves2023_24Activity;
import com.jogos.dadosoficialkf228920.adapter.europa2023a24.ingles.TimesInglesA2023a24Adapter;
import com.jogos.dadosoficialkf228920.data.europaA2023a24.ingles.TimesInglesA2023a24Api;
import com.jogos.dadosoficialkf228920.databinding.FragmentListaInglesA2023a24Binding;
import com.jogos.dadosoficialkf228920.model.ClassificacaoOficial;
import com.jogos.dadosoficialkf228920.model.ComparatorPontosSaldoGolsGolsPro;
import com.jogos.dadosoficialkf228920.model.RecyclerItemClickListener;
import com.jogos.dadosoficialkf228920.model.TimeClassificacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListaInglesA2023a24Fragment extends Fragment {

    private FragmentListaInglesA2023a24Binding binding;
    private TimesInglesA2023a24Adapter timesInglesA2023a24Adapter;
    private TimesInglesA2023a24Api timesInglesA2023a24Api;


    private List<ClassificacaoOficial> minhaLista = new ArrayList<>();



    String nome = null;
    String imagem = null;

    private Integer totalGolsContra = 0;

    private Integer golsProTotal = 0;
    private Integer golsContraTotal = 0;
    private Integer saldoGols = 0;

    private Integer totalJogos = 0;

    private Integer totalVitoria = 0;
    private Integer totalEmpate = 0;
    private Integer totalDerrota = 0;
    private Integer totalPontos = 0;



    public ListaInglesA2023a24Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentListaInglesA2023a24Binding.inflate(inflater, container, false);
        View view = binding.getRoot();

        setupHttpClient();
        setupListaTimes();


        return view;
    }

    private void setupHttpClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/europa-a-2023-24/ingles/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        timesInglesA2023a24Api = retrofit.create(TimesInglesA2023a24Api.class);

    }


    private void setupListaTimes() {

        binding.rvListaInglesA2023a24.setHasFixedSize(true);
        binding.rvListaInglesA2023a24.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvListaInglesA2023a24.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));


        timesInglesA2023a24Api.getTimesInglesA2023a2024().enqueue(new Callback<List<TimeClassificacao>>() {
            @Override
            public void onResponse(Call<List<TimeClassificacao>> call, Response<List<TimeClassificacao>> response) {
                if(response.isSuccessful()){

                    List<TimeClassificacao> listaDeTimes = response.body();

                    for (int i = 0; i < listaDeTimes.size(); i++) {

                        int vitoriaCasa = 0;
                        int vitoriaFora = 0;
                        int empateCasa = 0;
                        int empateFora = 0;
                        int derrotaCasa = 0;
                        int derrotaFora = 0;
                        int golsProCasa = 0;
                        int golsProFora = 0;
                        int golsContraCasa = 0;
                        int golsContraFora = 0;
                        int jogosCasa = 0;
                        int jogosFora = 0;


                        for (int j = 0; j < listaDeTimes.get(i).getHomeTime().size(); j++) {

                            if(listaDeTimes.get(i).getHomeTime().get(j).getJogosCasa().getPlacar() > listaDeTimes.get(i).getHomeTime().get(j).getJogosFora().getPlacar()) {
                                vitoriaCasa += 1;
                            } else if(listaDeTimes.get(i).getHomeTime().get(j).getJogosCasa().getPlacar() == listaDeTimes.get(i).getHomeTime().get(j).getJogosFora().getPlacar()) {
                                empateCasa += 1;
                            }else
                                derrotaCasa += 1;

                            if(listaDeTimes.get(i).getHomeTime().get(j).getJogosCasa().getPlacar() > 0)
                                golsProCasa += listaDeTimes.get(i).getHomeTime().get(j).getJogosCasa().getPlacar();

                            if(listaDeTimes.get(i).getHomeTime().get(j).getJogosFora().getPlacar() > 0)
                                golsContraCasa += listaDeTimes.get(i).getHomeTime().get(j).getJogosFora().getPlacar();

                            jogosCasa = listaDeTimes.get(i).getHomeTime().size();


                        } //Fim do for que percorre e coleta os dados dos jogos em casa

                        for (int j = 0; j < listaDeTimes.get(i).getAwayTime().size(); j++) {
                            if(listaDeTimes.get(i).getAwayTime().get(j).getJogosCasa().getPlacar() < listaDeTimes.get(i).getAwayTime().get(j).getJogosFora().getPlacar() ){
                                vitoriaFora += 1;
                            } else if(listaDeTimes.get(i).getAwayTime().get(j).getJogosCasa().getPlacar() == listaDeTimes.get(i).getAwayTime().get(j).getJogosFora().getPlacar() ){
                                empateFora += 1;
                            }else
                                derrotaFora += 1;

                            if(listaDeTimes.get(i).getAwayTime().get(j).getJogosFora().getPlacar() > 0)
                                golsProFora += listaDeTimes.get(i).getAwayTime().get(j).getJogosFora().getPlacar();

                            if(listaDeTimes.get(i).getAwayTime().get(j).getJogosCasa().getPlacar() > 0)
                                golsContraFora += listaDeTimes.get(i).getAwayTime().get(j).getJogosCasa().getPlacar();

                            jogosFora = listaDeTimes.get(i).getAwayTime().size();



                        } //Fim do for que percorre e coleta os dados dos jogos em fora


                        nome = listaDeTimes.get(i).getName();
                        imagem = listaDeTimes.get(i).getImage();

                        totalVitoria = vitoriaCasa + vitoriaFora;
                        totalEmpate = empateCasa + empateFora;
                        totalDerrota= derrotaCasa + derrotaFora;
                        totalPontos = (totalVitoria * 3) + totalEmpate;

                        totalJogos = jogosCasa + jogosFora;

                        golsProTotal = golsProCasa + golsProFora;
                        golsContraTotal = golsContraCasa + golsContraFora;
                        saldoGols = golsProTotal - golsContraTotal;



                        if(minhaLista.size() <= i) {
                            ClassificacaoOficial classificacaoOficial = new ClassificacaoOficial(nome, imagem, totalJogos, golsProTotal, golsContraTotal, saldoGols, totalPontos, totalVitoria, totalEmpate, totalDerrota);
                            minhaLista.add(classificacaoOficial);
                        }


                        Log.i("nome", "Do Time: " + nome + ": " + imagem);


                    } //Fim do for que percorre toda a lista


                    minhaLista.sort(new ComparatorPontosSaldoGolsGolsPro());
                    //Collections.sort(minhaLista);
                    Collections.reverse(minhaLista);


                    timesInglesA2023a24Adapter = new TimesInglesA2023a24Adapter(minhaLista);
                    binding.rvListaInglesA2023a24.setAdapter(timesInglesA2023a24Adapter);


                    binding.rvListaInglesA2023a24.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), binding.rvListaInglesA2023a24, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {

                            ClassificacaoOficial lista = minhaLista.get(position);

                            switch (lista.getNome()){
                                case "Arsenal":
                                    Intent arsenal = new Intent(getContext(), Arsenal2023_24Activity.class);
                                    startActivity(arsenal);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Aston Villa":
                                    Intent astonvilla = new Intent(getContext(), AstonVilla2023_24Activity.class);
                                    startActivity(astonvilla);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Bournemouth":
                                    Intent bournemouth = new Intent(getContext(), Bournemouth2023_24Activity.class);
                                    startActivity(bournemouth);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Brentford":
                                    Intent brentford = new Intent(getContext(), Brentford2023_24Activity.class);
                                    startActivity(brentford);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Brighton":
                                    Intent brighton = new Intent(getContext(), Brighton2023_24Activity.class);
                                    startActivity(brighton);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Burnley":
                                    Intent burnley = new Intent(getContext(), Burnley2023_24Activity.class);
                                    startActivity(burnley);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Chelsea":
                                    Intent chelsea = new Intent(getContext(), Chelsea2023_24Activity.class);
                                    startActivity(chelsea);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Crystal Palace":
                                    Intent crystalpalace = new Intent(getContext(), CrystalPalace2023_24Activity.class);
                                    startActivity(crystalpalace);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Everton":
                                    Intent everton = new Intent(getContext(), Everton2023_24Activity.class);
                                    startActivity(everton);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Fulham":
                                    Intent fulham = new Intent(getContext(), Fulham2023_24Activity.class);
                                    startActivity(fulham);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Liverpool":
                                    Intent liverpool = new Intent(getContext(), Liverpool2023_24Activity.class);
                                    startActivity(liverpool);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Luton":
                                    Intent luton = new Intent(getContext(), Luton2023_24Activity.class);
                                    startActivity(luton);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Manchester City":
                                    Intent city = new Intent(getContext(), ManchesterCity2023_24Activity.class);
                                    startActivity(city);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Manchester United":
                                    Intent united = new Intent(getContext(), ManchesterUnited2023_24Activity.class);
                                    startActivity(united);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Newcastle":
                                    Intent newcastle = new Intent(getContext(), Newcastle2023_24Activity.class);
                                    startActivity(newcastle);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Nottingham Forest":
                                    Intent forest = new Intent(getContext(), Nottingham2023_24Activity.class);
                                    startActivity(forest);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Sheffield":
                                    Intent sheffield = new Intent(getContext(), Sheffield2023_24Activity.class);
                                    startActivity(sheffield);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Tottenham":
                                    Intent tottenham = new Intent(getContext(), Tottenham2023_24Activity.class);
                                    startActivity(tottenham);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "West Ham":
                                    Intent westham = new Intent(getContext(), WestHam2023_24Activity.class);
                                    startActivity(westham);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Wolverhampton":
                                    Intent wolves = new Intent(getContext(), Wolves2023_24Activity.class);
                                    startActivity(wolves);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
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
            public void onFailure(Call<List<TimeClassificacao>> call, Throwable t) {
                errorBuscarDados();
            }
        });

    }

    private void errorBuscarDados() {

        Snackbar.make(binding.getRoot(), "erro ao buscar dados da API, Verifique a conexão de Internet, ", Snackbar.LENGTH_LONG).show();

    }
}