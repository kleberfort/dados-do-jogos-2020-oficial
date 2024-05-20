package com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.alemanha;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.snackbar.Snackbar;
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
import com.jogos.dadosoficialkf228920.adapter.europa2023a24.alemanha.TimesAlemaoA2023a24Adapter;
import com.jogos.dadosoficialkf228920.data.europaA2023a24.alemanha.TimesAlemaoA2023a24Api;
import com.jogos.dadosoficialkf228920.databinding.FragmentListaAlemaoA2023a24Binding;
import com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.ingles.ListaInglesA2023a24Fragment;
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


public class ListaAlemaoA2023a24Fragment extends Fragment {

    private FragmentListaAlemaoA2023a24Binding binding;
    private TimesAlemaoA2023a24Adapter timesAlemaoA2023a24Adapter;
    private TimesAlemaoA2023a24Api timesAlemaoA2022a23Api;


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



    public ListaAlemaoA2023a24Fragment() {
        // Required empty public constructor
    }

    public interface ListaAlemanhaInterface{//esse é o codigo de criar a interface // entede essa primeira parte ? ele basicamente
        void listaAlemanhaMetodo(String nome);//viu que é uma string ?sim
    }


    //2 etapa criamos uma variavel da interface
    ListaAlemanhaInterface listaAlemanha = null;//queremos usar o metodo listaInglesa(String nome) mas estamos iniciando ela com o valor null
    //ou seuja null é igual a nulo ou nada
    //entende isso ?sim



    //3 etapa iniciamos a variavel
    @Override
    public void onAttach(@NonNull Context context) {//
        super.onAttach(context);

        if(context instanceof ListaAlemanhaInterface){
            listaAlemanha = (ListaAlemanhaInterface) context;//aqui iniciamos a nossa variavel... Esse código voce nao precisa entender, só tem que
            //compreendeu as 3 etapadas ?sim ok
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentListaAlemaoA2023a24Binding.inflate(inflater, container, false);
        View view = binding.getRoot();

        setupHttpClient();
        setupListaTimes();


        return view;
    }

    private void setupHttpClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/europa-a-2023-24/alemanha/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        timesAlemaoA2022a23Api = retrofit.create(TimesAlemaoA2023a24Api.class);

    }


    private void setupListaTimes() {

        binding.rvListaAlemaoA2023a24.setHasFixedSize(true);
        binding.rvListaAlemaoA2023a24.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvListaAlemaoA2023a24.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));


        timesAlemaoA2022a23Api.getTimesAlemaoA2023a2024().enqueue(new Callback<List<TimeClassificacao>>() {
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


                    timesAlemaoA2023a24Adapter = new TimesAlemaoA2023a24Adapter(minhaLista);
                    binding.rvListaAlemaoA2023a24.setAdapter(timesAlemaoA2023a24Adapter);


                    binding.rvListaAlemaoA2023a24.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), binding.rvListaAlemaoA2023a24, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {

                            ClassificacaoOficial lista = minhaLista.get(position);

                            switch (lista.getNome()){
                                case "Augsburg":
                                    listaAlemanha.listaAlemanhaMetodo("Augsburg");
//                                    Intent augsburg = new Intent(getContext(), Augsburg2023_24Activity.class);
//                                    startActivity(augsburg);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();

                                    break;
                                case "Bayer Leverkusen":
                                    listaAlemanha.listaAlemanhaMetodo("Bayer Leverkusen");
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Bayern de Munique":
                                    listaAlemanha.listaAlemanhaMetodo("Bayern de Munique");
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Bochum":
                                    listaAlemanha.listaAlemanhaMetodo("Bochum");
//                                    Intent bochum = new Intent(getContext(), Bochum2023_24Activity.class);
//                                    startActivity(bochum);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Borussia Dortmund":
                                    listaAlemanha.listaAlemanhaMetodo("Borussia Dortmund");
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Borussia Mönchengladbach":
                                    listaAlemanha.listaAlemanhaMetodo("Borussia Mönchengladbach");
//                                    Intent borussiaMonchengladbach = new Intent(getContext(), BorussiaMonche2023_24Activity.class);
//                                    startActivity(borussiaMonchengladbach);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Köln(Colônia)":
                                    listaAlemanha.listaAlemanhaMetodo("Köln(Colônia)");
//                                    Intent koln = new Intent(getContext(), Koln2023_24Activity.class);
//                                    startActivity(koln);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Darmstadt98":
                                    listaAlemanha.listaAlemanhaMetodo("Darmstadt98");
//                                    Intent darmstadt98 = new Intent(getContext(), Darmstadt2023_24Activity.class);
//                                    startActivity(darmstadt98);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;

                                case "Eintracht Frankfurt":
                                    listaAlemanha.listaAlemanhaMetodo("Eintracht Frankfurt");
//                                    Intent frankfurt = new Intent(getContext(), EintrachtFrankfurt2023_24Activity.class);
//                                    startActivity(frankfurt);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                    case "Freiburg":
                                        listaAlemanha.listaAlemanhaMetodo("Freiburg");
//                                    Intent freiburg = new Intent(getContext(), Freiburg2023_24Activity.class);
//                                    startActivity(freiburg);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Heidenheim":
                                    listaAlemanha.listaAlemanhaMetodo("Heidenheim");
//                                    Intent heidenheim = new Intent(getContext(), Heidenheim2023_24Activity.class);
//                                    startActivity(heidenheim);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Hoffenheim":
                                    listaAlemanha.listaAlemanhaMetodo("Hoffenheim");
//                                    Intent hoffenheim = new Intent(getContext(), Hoffenheim2023_24Activity.class);
//                                    startActivity(hoffenheim);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Mainz 05":
                                    listaAlemanha.listaAlemanhaMetodo("Mainz 05");
//                                    Intent mainz05 = new Intent(getContext(), Mainz2023_24Activity.class);
//                                    startActivity(mainz05);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "RB Leipzig":
                                    listaAlemanha.listaAlemanhaMetodo("RB Leipzig");
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Stuttgart":
                                    listaAlemanha.listaAlemanhaMetodo("Stuttgart");
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Union Berlin":
                                    listaAlemanha.listaAlemanhaMetodo("Union Berlin");
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Werder Bremen":
                                    listaAlemanha.listaAlemanhaMetodo("Werder Bremen");
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Wolfsburg":
                                    listaAlemanha.listaAlemanhaMetodo("Wolfsburg");
//                                    Intent wolfburg = new Intent(getContext(), Wolfsburg2023_24Activity.class);
//                                    startActivity(wolfburg);
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