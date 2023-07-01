package com.jogos.dadosoficialkf228920.fragments.inglesA2022a23;

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
import com.jogos.dadosoficialkf228920.activity.inglesA2022a23.ArsenalActivity;
import com.jogos.dadosoficialkf228920.activity.inglesA2022a23.AstonVillaActivity;
import com.jogos.dadosoficialkf228920.activity.inglesA2022a23.BournemouthActivity;
import com.jogos.dadosoficialkf228920.activity.inglesA2022a23.BrentfordActivity;
import com.jogos.dadosoficialkf228920.activity.inglesA2022a23.BrightonActivity;
import com.jogos.dadosoficialkf228920.activity.inglesA2022a23.ChelseaActivity;
import com.jogos.dadosoficialkf228920.activity.inglesA2022a23.CrystalPalaceActivity;
import com.jogos.dadosoficialkf228920.activity.inglesA2022a23.EvertonActivity;
import com.jogos.dadosoficialkf228920.activity.inglesA2022a23.FulhamActivity;
import com.jogos.dadosoficialkf228920.activity.inglesA2022a23.LeedsUnitedActivity;
import com.jogos.dadosoficialkf228920.activity.inglesA2022a23.LeicesterActivity;
import com.jogos.dadosoficialkf228920.activity.inglesA2022a23.LiverpoolActivity;
import com.jogos.dadosoficialkf228920.activity.inglesA2022a23.ManchesterCityActivity;
import com.jogos.dadosoficialkf228920.activity.inglesA2022a23.ManchesterUnitedActivity;
import com.jogos.dadosoficialkf228920.activity.inglesA2022a23.NewcastleActivity;
import com.jogos.dadosoficialkf228920.activity.inglesA2022a23.NottinghamForestActivity;
import com.jogos.dadosoficialkf228920.activity.inglesA2022a23.SouthamptonActivity;
import com.jogos.dadosoficialkf228920.activity.inglesA2022a23.TottenhamActivity;
import com.jogos.dadosoficialkf228920.activity.inglesA2022a23.WesthamActivity;
import com.jogos.dadosoficialkf228920.activity.inglesA2022a23.WolverhamptonActivity;
import com.jogos.dadosoficialkf228920.adapter.inglesA2022a2023.TimesInglesA2022a23Adapter;
import com.jogos.dadosoficialkf228920.data.inglesA2022a23.TimesInglesA2022a23Api;
import com.jogos.dadosoficialkf228920.databinding.FragmentListaInglesA2022a23Binding;
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


public class  ListaInglesA2022a23Fragment extends Fragment {
    private FragmentListaInglesA2022a23Binding binding;
    private TimesInglesA2022a23Api timesInglesA2022a23Api;
    private TimesInglesA2022a23Adapter timesInglesA2022a23Adapter;



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


    public ListaInglesA2022a23Fragment() {



        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        
        binding = FragmentListaInglesA2022a23Binding.inflate(inflater, container, false);
        View view = binding.getRoot();




        setupHttpClient();
        setupListaTimes();


        
       
        return view;
    }


    private void setupHttpClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/ingles-a-2022-23/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        timesInglesA2022a23Api = retrofit.create(TimesInglesA2022a23Api.class);



    }





    private void setupListaTimes() {

        binding.rvListaInglesA2022a23.setHasFixedSize(true);
        binding.rvListaInglesA2022a23.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvListaInglesA2022a23.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));


        timesInglesA2022a23Api.getTimesInglesA2022a2023().enqueue(new Callback<List<TimeClassificacao>>() {
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

                    timesInglesA2022a23Adapter = new TimesInglesA2022a23Adapter(minhaLista);
                    binding.rvListaInglesA2022a23.setAdapter(timesInglesA2022a23Adapter);


                    binding.rvListaInglesA2022a23.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), binding.rvListaInglesA2022a23, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {

                            ClassificacaoOficial lista = minhaLista.get(position);

                            switch (lista.getNome()){
                                case "Arsenal":
                                    Intent arsenal = new Intent(getContext(), ArsenalActivity.class);
                                    startActivity(arsenal);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Aston Villa":
                                    Intent astonVilla = new Intent(getContext(), AstonVillaActivity.class);
                                    startActivity(astonVilla);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Bournemouth":
                                    Intent bournemouth = new Intent(getContext(), BournemouthActivity.class);
                                    startActivity(bournemouth);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Brentford":
                                    Intent brentford = new Intent(getContext(), BrentfordActivity.class);
                                    startActivity(brentford);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Brighton":
                                    Intent brighton = new Intent(getContext(), BrightonActivity.class);
                                    startActivity(brighton);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Chelsea":
                                    Intent chelsea = new Intent(getContext(), ChelseaActivity.class);
                                    startActivity(chelsea);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Crystal Palace":
                                    Intent crystalPalace = new Intent(getContext(), CrystalPalaceActivity.class);
                                    startActivity(crystalPalace);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Everton":
                                    Intent everton = new Intent(getContext(), EvertonActivity.class);
                                    startActivity(everton);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Fulham":
                                    Intent fulham = new Intent(getContext(), FulhamActivity.class);
                                    startActivity(fulham);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Leeds United":
                                    Intent leedsUnited = new Intent(getContext(), LeedsUnitedActivity.class);
                                    startActivity(leedsUnited);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Leicester":
                                    Intent leicester = new Intent(getContext(), LeicesterActivity.class);
                                    startActivity(leicester);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Liverpool":
                                    Intent liverpool = new Intent(getContext(), LiverpoolActivity.class);
                                    startActivity(liverpool);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Manchester City":
                                    Intent manchesterCity = new Intent(getContext(), ManchesterCityActivity.class);
                                    startActivity(manchesterCity);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Manchester United":
                                    Intent manchesterUnited = new Intent(getContext(), ManchesterUnitedActivity.class);
                                    startActivity(manchesterUnited);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Newcastle":
                                    Intent newcastle = new Intent(getContext(), NewcastleActivity.class);
                                    startActivity(newcastle);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Nottingham Forest":
                                    Intent nottingham = new Intent(getContext(), NottinghamForestActivity.class);
                                    startActivity(nottingham);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Southampton":
                                    Intent southampton = new Intent(getContext(), SouthamptonActivity.class);
                                    startActivity(southampton);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Tottenham":
                                    Intent tottenham = new Intent(getContext(), TottenhamActivity.class);
                                    startActivity(tottenham);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "West Ham":
                                    Intent westHam = new Intent(getContext(), WesthamActivity.class);
                                    startActivity(westHam);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Wolverhampton":
                                    Intent wolverhampton = new Intent(getContext(), WolverhamptonActivity.class);
                                    startActivity(wolverhampton);
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



            } // fim do método de setup







    private void errorBuscarDados() {
        Snackbar.make(binding.getRoot(), "erro ao buscar dados da API, Verifique a conexão de Internet, ", Snackbar.LENGTH_LONG).show();
    }











}