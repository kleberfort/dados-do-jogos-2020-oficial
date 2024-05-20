package com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.franca;

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
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Brest2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Clermont2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.LeHavre2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Lens2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Lille2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Lorient2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Lyon2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Marseille2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Metz2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Monaco2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Montpellier2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Nantes2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.OgcNice2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Psg2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Reims2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Rennes2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Strasbourg2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Toulouse2023_24Activity;
import com.jogos.dadosoficialkf228920.adapter.europa2023a24.franca.TimesFrancesA2023a24Adpater;
import com.jogos.dadosoficialkf228920.data.europaA2023a24.franca.TimesFrancesA2023a24Api;
import com.jogos.dadosoficialkf228920.databinding.FragmentListaFrancaA2023a24Binding;
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

public class ListaFrancaA2023a24Fragment extends Fragment {

    private FragmentListaFrancaA2023a24Binding binding;
    private TimesFrancesA2023a24Adpater timesFrancesA2023a24Adpater;
    private TimesFrancesA2023a24Api timesFrancesA2023a24Api;


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



    public ListaFrancaA2023a24Fragment() {
        // Required empty public constructor
    }


    //1 etapa criamos a interface
    public interface ListaFrancesInterface{//esse é o codigo de criar a interface // entede essa primeira parte ? ele basicamente
        void listaFrancesMetodo(String nome);//viu que é uma string ?sim
    }




    //2 etapa criamos uma variavel da interface
    ListaFrancesInterface listaFrances = null;//queremos usar o metodo listaInglesa(String nome) mas estamos iniciando ela com o valor null
    //ou seuja null é igual a nulo ou nada
    //entende isso ?sim



    //3 etapa iniciamos a variavel
    @Override
    public void onAttach(@NonNull Context context) {//
        super.onAttach(context);

        if(context instanceof ListaFrancesInterface){
            listaFrances = (ListaFrancesInterface) context;//aqui iniciamos a nossa variavel... Esse código voce nao precisa entender, só tem que
            //compreendeu as 3 etapadas ?sim ok
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentListaFrancaA2023a24Binding.inflate(inflater, container, false);
        View view = binding.getRoot();

        setupHttpClient();
        setupListaTimes();


        return view;
    }

    private void setupHttpClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/europa-a-2023-24/franca/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        timesFrancesA2023a24Api = retrofit.create(TimesFrancesA2023a24Api.class);

    }


    private void setupListaTimes() {

        binding.rvListaFrancaA2023a24.setHasFixedSize(true);
        binding.rvListaFrancaA2023a24.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvListaFrancaA2023a24.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));


        timesFrancesA2023a24Api.getTimesFrancesA2023a2024().enqueue(new Callback<List<TimeClassificacao>>() {
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
                           if(i == 10){
                            classificacaoOficial = new ClassificacaoOficial(nome, imagem, totalJogos, golsProTotal, golsContraTotal, saldoGols, (totalPontos-1), totalVitoria, totalEmpate, totalDerrota);
                           }
                            minhaLista.add(classificacaoOficial);
                        }


                        Log.i("nome", "Do Time: " + nome + ": " + imagem);


                    } //Fim do for que percorre toda a lista


                    minhaLista.sort(new ComparatorPontosSaldoGolsGolsPro());
                    //Collections.sort(minhaLista);
                    Collections.reverse(minhaLista);


                    timesFrancesA2023a24Adpater = new TimesFrancesA2023a24Adpater(minhaLista);
                    binding.rvListaFrancaA2023a24.setAdapter(timesFrancesA2023a24Adpater);


                    binding.rvListaFrancaA2023a24.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), binding.rvListaFrancaA2023a24, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {

                            ClassificacaoOficial lista = minhaLista.get(position);

                            switch (lista.getNome()){
                                case "Brest":
                                    listaFrances.listaFrancesMetodo("Brest");
//                                    Intent brest = new Intent(getContext(), Brest2023_24Activity.class);
//                                    startActivity(brest);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Clermont":
                                    listaFrances.listaFrancesMetodo("Clermont");
//                                    Intent clermont = new Intent(getContext(), Clermont2023_24Activity.class);
//                                    startActivity(clermont);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Le Havre":
                                    listaFrances.listaFrancesMetodo("Le Havre");
//                                    Intent leHavre = new Intent(getContext(), LeHavre2023_24Activity.class);
//                                    startActivity(leHavre);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Lens":
                                    listaFrances.listaFrancesMetodo("Lens");
//                                    Intent lens = new Intent(getContext(), Lens2023_24Activity.class);
//                                    startActivity(lens);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Lille":
                                    listaFrances.listaFrancesMetodo("Lille");
//                                    Intent lille = new Intent(getContext(), Lille2023_24Activity.class);
//                                    startActivity(lille);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Lorient":
                                    listaFrances.listaFrancesMetodo("Lorient");
//                                    Intent lorient = new Intent(getContext(), Lorient2023_24Activity.class);
//                                    startActivity(lorient);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Lyon":
                                    listaFrances.listaFrancesMetodo("Lyon");
//                                    Intent lyon = new Intent(getContext(), Lyon2023_24Activity.class);
//                                    startActivity(lyon);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Marseille":
                                    listaFrances.listaFrancesMetodo("Marseille");
//                                    Intent marseille = new Intent(getContext(), Marseille2023_24Activity.class);
//                                    startActivity(marseille);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Metz":
                                    listaFrances.listaFrancesMetodo("Metz");
//                                    Intent metz = new Intent(getContext(), Metz2023_24Activity.class);
//                                    startActivity(metz);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Monaco":
                                    listaFrances.listaFrancesMetodo("Monaco");
//                                    Intent monaco = new Intent(getContext(), Monaco2023_24Activity.class);
//                                    startActivity(monaco);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Montpellier":
                                    listaFrances.listaFrancesMetodo("Montpellier");
//                                    Intent montpellier = new Intent(getContext(), Montpellier2023_24Activity.class);
//                                    startActivity(montpellier);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Nantes":
                                    listaFrances.listaFrancesMetodo("Nantes");
//                                    Intent nantes = new Intent(getContext(), Nantes2023_24Activity.class);
//                                    startActivity(nantes);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Nice":
                                    listaFrances.listaFrancesMetodo("Nice");
//                                    Intent nice = new Intent(getContext(), OgcNice2023_24Activity.class);
//                                    startActivity(nice);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "PSG":
                                    listaFrances.listaFrancesMetodo("PSG");
//                                    Intent psg = new Intent(getContext(), Psg2023_24Activity.class);
//                                    startActivity(psg);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Reims":
                                    listaFrances.listaFrancesMetodo("Reims");
//                                    Intent reims = new Intent(getContext(), Reims2023_24Activity.class);
//                                    startActivity(reims);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Rennes":
                                    listaFrances.listaFrancesMetodo("Rennes");
//                                    Intent rennes = new Intent(getContext(), Rennes2023_24Activity.class);
//                                    startActivity(rennes);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Strasbourg":
                                    listaFrances.listaFrancesMetodo("Strasbourg");
//                                    Intent strasbourg = new Intent(getContext(), Strasbourg2023_24Activity.class);
//                                    startActivity(strasbourg);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Toulouse":
                                    listaFrances.listaFrancesMetodo("Toulouse");
//                                    Intent toulouse = new Intent(getContext(), Toulouse2023_24Activity.class);
//                                    startActivity(toulouse);
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