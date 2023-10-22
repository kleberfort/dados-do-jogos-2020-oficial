package com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.espanhol;

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
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.Alaves2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.Almeria2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.AthleticBilbao2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.AtleticoMadrid2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.Barcelona2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.Cadiz2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.CeltaVigo2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.Getafe2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.Girona2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.Granada2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.LasPalmas2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.Mallorca2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.Osasuna2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.RayoVallecano2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.RealBetis2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.RealMadrid2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.RealSociedad2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.Sevilla2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.Valencia2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.Villarreal2023_24Activity;
import com.jogos.dadosoficialkf228920.adapter.europa2023a24.espanhol.TimesEspanholA2023a24Adapter;
import com.jogos.dadosoficialkf228920.data.europaA2023a24.espanhol.TimesEspanholA2023a24Api;
import com.jogos.dadosoficialkf228920.databinding.FragmentListaEspanholA2023a24Binding;
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


public class ListaEspanholA2023a24Fragment extends Fragment {

    private FragmentListaEspanholA2023a24Binding binding;
    private TimesEspanholA2023a24Adapter timesFrancesA2023a24Adpater;
    private TimesEspanholA2023a24Api timesEspanholA2023a24Api;


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



    public ListaEspanholA2023a24Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentListaEspanholA2023a24Binding.inflate(inflater, container, false);
        View view = binding.getRoot();

        setupHttpClient();
        setupListaTimes();


        return view;
    }

    private void setupHttpClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/europa-a-2023-24/espanhol/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        timesEspanholA2023a24Api = retrofit.create(TimesEspanholA2023a24Api.class);

    }


    private void setupListaTimes() {

        binding.rvListaSpanholA2023a24.setHasFixedSize(true);
        binding.rvListaSpanholA2023a24.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvListaSpanholA2023a24.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));


        timesEspanholA2023a24Api.getTimesEspanholA2023a2024().enqueue(new Callback<List<TimeClassificacao>>() {
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


                    timesFrancesA2023a24Adpater = new TimesEspanholA2023a24Adapter(minhaLista);
                    binding.rvListaSpanholA2023a24.setAdapter(timesFrancesA2023a24Adpater);


                    binding.rvListaSpanholA2023a24.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), binding.rvListaSpanholA2023a24, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {

                            ClassificacaoOficial lista = minhaLista.get(position);

                            switch (lista.getNome()){
                                case "Alaves":
                                    Intent elche = new Intent(getContext(), Alaves2023_24Activity.class);
                                    startActivity(elche);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;

                                case "Almería":
                                    Intent almeria = new Intent(getContext(), Almeria2023_24Activity.class);
                                    startActivity(almeria);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Athletic Bilbao":
                                    Intent athleticBilbao = new Intent(getContext(), AthleticBilbao2023_24Activity.class);
                                    startActivity(athleticBilbao);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Atlético de Madrid":
                                    Intent atleticoMadrid = new Intent(getContext(), AtleticoMadrid2023_24Activity.class);
                                    startActivity(atleticoMadrid);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Barcelona":
                                    Intent barcelona = new Intent(getContext(), Barcelona2023_24Activity.class);
                                    startActivity(barcelona);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Cádiz":
                                    Intent cadiz = new Intent(getContext(), Cadiz2023_24Activity.class);
                                    startActivity(cadiz);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Celta de Vigo":
                                    Intent celtaVigo = new Intent(getContext(), CeltaVigo2023_24Activity.class);
                                    startActivity(celtaVigo);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;

                                case "Getafe":
                                    Intent getafe = new Intent(getContext(), Getafe2023_24Activity.class);
                                    startActivity(getafe);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;

                                case "Girona":
                                    Intent girona = new Intent(getContext(), Girona2023_24Activity.class);
                                    startActivity(girona);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;

                                case "Granada":
                                    Intent espanyol = new Intent(getContext(), Granada2023_24Activity.class);
                                    startActivity(espanyol);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;

                                case "Las Palmas":
                                    Intent realValladolid = new Intent(getContext(), LasPalmas2023_24Activity.class);
                                    startActivity(realValladolid);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;

                                case "Mallorca":
                                    Intent mallorca = new Intent(getContext(), Mallorca2023_24Activity.class);
                                    startActivity(mallorca);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Osasuna":
                                    Intent osasuna = new Intent(getContext(), Osasuna2023_24Activity.class);
                                    startActivity(osasuna);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Rayo Vallecano":
                                    Intent rayoVallecano = new Intent(getContext(), RayoVallecano2023_24Activity.class);
                                    startActivity(rayoVallecano);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Real Betis":
                                    Intent realBetis = new Intent(getContext(), RealBetis2023_24Activity.class);
                                    startActivity(realBetis);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Real Madrid":
                                    Intent realMadrid = new Intent(getContext(), RealMadrid2023_24Activity.class);
                                    startActivity(realMadrid);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Real Sociedad":
                                    Intent realSociedad = new Intent(getContext(), RealSociedad2023_24Activity.class);
                                    startActivity(realSociedad);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;

                                case "Sevilla":
                                    Intent sevilla = new Intent(getContext(), Sevilla2023_24Activity.class);
                                    startActivity(sevilla);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Valencia":
                                    Intent valencica = new Intent(getContext(), Valencia2023_24Activity.class);
                                    startActivity(valencica);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Villarreal":
                                    Intent villarreal = new Intent(getContext(), Villarreal2023_24Activity.class);
                                    startActivity(villarreal);
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