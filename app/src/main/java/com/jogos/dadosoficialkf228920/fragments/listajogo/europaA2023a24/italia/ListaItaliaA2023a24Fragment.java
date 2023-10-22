package com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.italia;

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
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.AcMilan2023_24Activity;
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
import com.jogos.dadosoficialkf228920.adapter.europa2023a24.italia.TimesItalianoA2023a24Adapter;
import com.jogos.dadosoficialkf228920.data.europaA2023a24.italia.TimesItalianoA2023a24Api;
import com.jogos.dadosoficialkf228920.databinding.FragmentListaItaliaA2023a24Binding;
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


public class ListaItaliaA2023a24Fragment extends Fragment {

    private FragmentListaItaliaA2023a24Binding binding;
    private TimesItalianoA2023a24Adapter timesItalianoA2023a24Adapter;
    private TimesItalianoA2023a24Api timesItalianoA2023a24Api;


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



    public ListaItaliaA2023a24Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentListaItaliaA2023a24Binding.inflate(inflater, container, false);
        View view = binding.getRoot();

        setupHttpClient();
        setupListaTimes();


        return view;
    }

    private void setupHttpClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/europa-a-2023-24/italiano/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        timesItalianoA2023a24Api = retrofit.create(TimesItalianoA2023a24Api.class);

    }


    private void setupListaTimes() {

        binding.rvListaItaliaA2023a24.setHasFixedSize(true);
        binding.rvListaItaliaA2023a24.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvListaItaliaA2023a24.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));


        timesItalianoA2023a24Api.getTimesItalianoA2023a2024().enqueue(new Callback<List<TimeClassificacao>>() {
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


                    timesItalianoA2023a24Adapter = new TimesItalianoA2023a24Adapter(minhaLista);
                    binding.rvListaItaliaA2023a24.setAdapter(timesItalianoA2023a24Adapter);


                    binding.rvListaItaliaA2023a24.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), binding.rvListaItaliaA2023a24, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {

                            ClassificacaoOficial lista = minhaLista.get(position);

                            switch (lista.getNome()){
                                case "Atalanta":
                                    Intent atalanta = new Intent(getContext(), Atalanta2023_24Activity.class);
                                    startActivity(atalanta);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Bologna":
                                    Intent bologna = new Intent(getContext(), Bologna2023_24Activity.class);
                                    startActivity(bologna);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Cagliari":
                                    Intent cagliari = new Intent(getContext(), Cagliari2023_24Activity.class);
                                    startActivity(cagliari);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Empoli":
                                    Intent empoli = new Intent(getContext(), Empoli2023_24Activity.class);
                                    startActivity(empoli);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Fiorentina":
                                    Intent fiorentina = new Intent(getContext(), Fiorentina2023_24Activity.class);
                                    startActivity(fiorentina);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Frosinone":
                                    Intent frosinone = new Intent(getContext(), Frosinone2023_24Activity.class);
                                    startActivity(frosinone);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Genoa":
                                    Intent genoa = new Intent(getContext(), Genoa2023_24Activity.class);
                                    startActivity(genoa);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Hellas Verona":
                                    Intent verona = new Intent(getContext(), HellasVerona2023_24Activity.class);
                                    startActivity(verona);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Inter Milan":
                                    Intent inter = new Intent(getContext(), InterMilao2023_24Activity.class);
                                    startActivity(inter);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Juventus":
                                    Intent juventus = new Intent(getContext(), Juventus2023_24Activity.class);
                                    startActivity(juventus);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Lazio":
                                    Intent lazio = new Intent(getContext(), Lazio2023_24Activity.class);
                                    startActivity(lazio);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Lecce":
                                    Intent lecce = new Intent(getContext(), Lecce2023_24Activity.class);
                                    startActivity(lecce);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Milan":
                                    Intent milan = new Intent(getContext(), AcMilan2023_24Activity.class);
                                    startActivity(milan);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Monza":
                                    Intent monza = new Intent(getContext(), Monza2023_24Activity.class);
                                    startActivity(monza);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Napoli":
                                    Intent napoli = new Intent(getContext(), Napoli2023_24Activity.class);
                                    startActivity(napoli);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Roma":
                                    Intent roma = new Intent(getContext(), Roma2023_24Activity.class);
                                    startActivity(roma);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Salernitana":
                                    Intent salernitana = new Intent(getContext(), Salernitana2023_24Activity.class);
                                    startActivity(salernitana);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Sassuolo":
                                    Intent sassuolo = new Intent(getContext(), Sassuolo2023_24Activity.class);
                                    startActivity(sassuolo);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Torino":
                                    Intent torino = new Intent(getContext(), Torino2023_24Activity.class);
                                    startActivity(torino);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Udinese":
                                    Intent udinese = new Intent(getContext(), Udinese2023_24Activity.class);
                                    startActivity(udinese);
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