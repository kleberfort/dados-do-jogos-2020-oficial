package com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.ingles;

import android.annotation.SuppressLint;
import android.content.Context;
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
   // String keyAppOdealBanner = "77e8bff791352f147853a14eb2eac44f5e6262538a98b6cb";



    // quando temo
    //String jone ///temos uma variavel que se chama jone e ela armazena texto
    //ListaInglesaInterface listaInglesa // temos uma variavel que se chama listaInglesa e com ela podemos usar o metodo   listaInglesa(String nome)

    //entendeu agorra ?entendi


    //1 etapa criamos a interface
    public interface ListaInglesaInterface{//esse é o codigo de criar a interface // entede essa primeira parte ? ele basicamente
        void listaInglesaMetodo(String nome);//viu que é uma string ?sim
    }




    //2 etapa criamos uma variavel da interface
    ListaInglesaInterface listaInglesa = null;//queremos usar o metodo listaInglesa(String nome) mas estamos iniciando ela com o valor null
    //ou seuja null é igual a nulo ou nada
    //entende isso ?sim



    //3 etapa iniciamos a variavel
    @Override
    public void onAttach(@NonNull Context context) {//
        super.onAttach(context);

        if(context instanceof  ListaInglesaInterface){
            listaInglesa = (ListaInglesaInterface) context;//aqui iniciamos a nossa variavel... Esse código voce nao precisa entender, só tem que
            //compreendeu as 3 etapadas ?sim ok
        }
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
            @SuppressLint("SuspiciousIndentation")
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

                            String nome = listaDeTimes.get(i).getName();
                            int tamanho = listaDeTimes.get(i).getHomeTime().size();

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
                                if(i ==8){
                                     classificacaoOficial = new ClassificacaoOficial(nome, imagem, totalJogos, golsProTotal, golsContraTotal, saldoGols, (totalPontos - 8), totalVitoria, totalEmpate, totalDerrota);
                                }
                            if(i ==15){
                                classificacaoOficial = new ClassificacaoOficial(nome, imagem, totalJogos, golsProTotal, golsContraTotal, saldoGols, (totalPontos - 4), totalVitoria, totalEmpate, totalDerrota);
                            }
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
                                    //qaundo clicamos no Arsenal qual texto estamos enviando para o metodo?
                                    //Arsenal
                                    //clicando aqui passamo o texto Arsenal para o metodo
                                    //e a mainactivvty esta ouvindo o metodo

                                    listaInglesa.listaInglesaMetodo("Arsenal");
                                    break;
                                case "Aston Villa":

                                    //quando clicar aqui
                                    listaInglesa.listaInglesaMetodo("Aston");
                                    break;
                                case "Bournemouth":
                                    listaInglesa.listaInglesaMetodo("Bournemouth");
                                    break;

                                case "Brentford":

                                    listaInglesa.listaInglesaMetodo("Brentford");

                                    //Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Brighton":
                                    listaInglesa.listaInglesaMetodo("Brighton");
//                                    Intent brighton = new Intent(getContext(), Brighton2023_24Activity.class);
//                                    startActivity(brighton);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Burnley":
                                    listaInglesa.listaInglesaMetodo("Burnley");
//                                    Intent burnley = new Intent(getContext(), Burnley2023_24Activity.class);
//                                    startActivity(burnley);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Chelsea":
                                    listaInglesa.listaInglesaMetodo("Chelsea");
//                                    Intent chelsea = new Intent(getContext(), Chelsea2023_24Activity.class);
//                                    startActivity(chelsea);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Crystal Palace":
                                    listaInglesa.listaInglesaMetodo("Crystal Palace");
//                                    Intent crystalpalace = new Intent(getContext(), CrystalPalace2023_24Activity.class);
//                                    startActivity(crystalpalace);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Everton":
                                    listaInglesa.listaInglesaMetodo("Everton");
//                                    Intent everton = new Intent(getContext(), Everton2023_24Activity.class);
//                                    startActivity(everton);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Fulham":
                                    listaInglesa.listaInglesaMetodo("Fulham");
//                                    Intent fulham = new Intent(getContext(), Fulham2023_24Activity.class);
//                                    startActivity(fulham);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Liverpool":
                                    listaInglesa.listaInglesaMetodo("Liverpool");
                                    //Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Luton":
                                    listaInglesa.listaInglesaMetodo("Luton");
//                                    Intent luton = new Intent(getContext(), Luton2023_24Activity.class);
//                                    startActivity(luton);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Manchester City":
                                    listaInglesa.listaInglesaMetodo("Manchester City");
                                    //Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Manchester United":
                                    listaInglesa.listaInglesaMetodo("Manchester United");
                                    //Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Newcastle":
                                    listaInglesa.listaInglesaMetodo("Newcastle");
//                                    Intent newcastle = new Intent(getContext(), Newcastle2023_24Activity.class);
//                                    startActivity(newcastle);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Nottingham Forest":
                                    listaInglesa.listaInglesaMetodo("Nottingham Forest");
//                                    Intent forest = new Intent(getContext(), Nottingham2023_24Activity.class);
//                                    startActivity(forest);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Sheffield":
                                    listaInglesa.listaInglesaMetodo("Sheffield");
//                                    Intent sheffield = new Intent(getContext(), Sheffield2023_24Activity.class);
//                                    startActivity(sheffield);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Tottenham":
                                    listaInglesa.listaInglesaMetodo("Tottenham");
                                    //Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "West Ham":
                                    listaInglesa.listaInglesaMetodo("West Ham");
//                                    Intent westham = new Intent(getContext(), WestHam2023_24Activity.class);
//                                    startActivity(westham);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Wolverhampton":
                                    listaInglesa.listaInglesaMetodo("Wolverhampton");
//                                    Intent wolves = new Intent(getContext(), Wolves2023_24Activity.class);
//                                    startActivity(wolves);
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