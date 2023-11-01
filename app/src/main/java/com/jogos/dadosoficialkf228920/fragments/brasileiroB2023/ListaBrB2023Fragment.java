package com.jogos.dadosoficialkf228920.fragments.brasileiroB2023;

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
import com.jogos.dadosoficialkf228920.activity.brasilB2023.AbcActivity;
import com.jogos.dadosoficialkf228920.activity.brasilB2023.AtleticoGoActivity;
import com.jogos.dadosoficialkf228920.activity.brasilB2023.AvaiActivity;
import com.jogos.dadosoficialkf228920.activity.brasilB2023.BotafogoSpActivity;
import com.jogos.dadosoficialkf228920.activity.brasilB2023.CearaActivity;
import com.jogos.dadosoficialkf228920.activity.brasilB2023.ChapecoenseActivity;
import com.jogos.dadosoficialkf228920.activity.brasilB2023.CrbActivity;
import com.jogos.dadosoficialkf228920.activity.brasilB2023.CriciumaActivity;
import com.jogos.dadosoficialkf228920.activity.brasilB2023.GuaraniActivity;
import com.jogos.dadosoficialkf228920.activity.brasilB2023.ItuanoActivity;
import com.jogos.dadosoficialkf228920.activity.brasilB2023.JuventudeActivity;
import com.jogos.dadosoficialkf228920.activity.brasilB2023.LondrinaActivity;
import com.jogos.dadosoficialkf228920.activity.brasilB2023.MirassolActivity;
import com.jogos.dadosoficialkf228920.activity.brasilB2023.NovorizontinoActivity;

import com.jogos.dadosoficialkf228920.activity.brasilB2023.PontePretaActivity;
import com.jogos.dadosoficialkf228920.activity.brasilB2023.SampaioCorreiaActivity;
import com.jogos.dadosoficialkf228920.activity.brasilB2023.SportActivity;
import com.jogos.dadosoficialkf228920.activity.brasilB2023.TombenseActivity;
import com.jogos.dadosoficialkf228920.activity.brasilB2023.VilaNovaActivity;
import com.jogos.dadosoficialkf228920.activity.brasilB2023.VitoriaActivity;
import com.jogos.dadosoficialkf228920.adapter.brasileriroB2023.TimesBrB2023Adapter;
import com.jogos.dadosoficialkf228920.data.brasileiroB2023.TimesBrB2023Api;
import com.jogos.dadosoficialkf228920.databinding.FragmentListaBrB2023Binding;
import com.jogos.dadosoficialkf228920.model.ClassificacaoOficial;
import com.jogos.dadosoficialkf228920.model.ComparatorPontos;
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


public class ListaBrB2023Fragment extends Fragment {

    private FragmentListaBrB2023Binding binding;
    private TimesBrB2023Adapter timesBrB2023Adapter;
    private TimesBrB2023Api timesBrB2023Api;

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


    public ListaBrB2023Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentListaBrB2023Binding.inflate(inflater, container, false);
        View view = binding.getRoot();

        setupHttpClient();
        setupListaTimes();



        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    private void setupHttpClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/brasileiro-b-2023/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        timesBrB2023Api = retrofit.create(TimesBrB2023Api.class);

    }

    private void setupListaTimes() {
        binding.rvListaBrasileiroSerieB2023.setHasFixedSize(true);
        binding.rvListaBrasileiroSerieB2023.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvListaBrasileiroSerieB2023.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));


        timesBrB2023Api.getTimesBrB2023().enqueue(new Callback<List<TimeClassificacao>>() {
            @Override
            public void onResponse(Call<List<TimeClassificacao>> call, Response<List<TimeClassificacao>> response) {
                if (response.isSuccessful()) {
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

                            if (listaDeTimes.get(i).getHomeTime().get(j).getJogosCasa().getPlacar() > listaDeTimes.get(i).getHomeTime().get(j).getJogosFora().getPlacar()) {
                                vitoriaCasa += 1;
                            } else if (listaDeTimes.get(i).getHomeTime().get(j).getJogosCasa().getPlacar() == listaDeTimes.get(i).getHomeTime().get(j).getJogosFora().getPlacar()) {
                                empateCasa += 1;
                            } else
                                derrotaCasa += 1;

                            if (listaDeTimes.get(i).getHomeTime().get(j).getJogosCasa().getPlacar() > 0)
                                golsProCasa += listaDeTimes.get(i).getHomeTime().get(j).getJogosCasa().getPlacar();

                            if (listaDeTimes.get(i).getHomeTime().get(j).getJogosFora().getPlacar() > 0)
                                golsContraCasa += listaDeTimes.get(i).getHomeTime().get(j).getJogosFora().getPlacar();

                            jogosCasa = listaDeTimes.get(i).getHomeTime().size();


                        } //Fim do for que percorre e coleta os dados dos jogos em casa

                        for (int j = 0; j < listaDeTimes.get(i).getAwayTime().size(); j++) {
                            if (listaDeTimes.get(i).getAwayTime().get(j).getJogosCasa().getPlacar() < listaDeTimes.get(i).getAwayTime().get(j).getJogosFora().getPlacar()) {
                                vitoriaFora += 1;
                            } else if (listaDeTimes.get(i).getAwayTime().get(j).getJogosCasa().getPlacar() == listaDeTimes.get(i).getAwayTime().get(j).getJogosFora().getPlacar()) {
                                empateFora += 1;
                            } else
                                derrotaFora += 1;

                            if (listaDeTimes.get(i).getAwayTime().get(j).getJogosFora().getPlacar() > 0)
                                golsProFora += listaDeTimes.get(i).getAwayTime().get(j).getJogosFora().getPlacar();

                            if (listaDeTimes.get(i).getAwayTime().get(j).getJogosCasa().getPlacar() > 0)
                                golsContraFora += listaDeTimes.get(i).getAwayTime().get(j).getJogosCasa().getPlacar();

                            jogosFora = listaDeTimes.get(i).getAwayTime().size();


                        } //Fim do for que percorre e coleta os dados dos jogos em fora


                        nome = listaDeTimes.get(i).getName();
                        imagem = listaDeTimes.get(i).getImage();

                        totalVitoria = vitoriaCasa + vitoriaFora;
                        totalEmpate = empateCasa + empateFora;
                        totalDerrota = derrotaCasa + derrotaFora;
                        totalPontos = (totalVitoria * 3) + totalEmpate;

                        totalJogos = jogosCasa + jogosFora;

                        golsProTotal = golsProCasa + golsProFora;
                        golsContraTotal = golsContraCasa + golsContraFora;
                        saldoGols = golsProTotal - golsContraTotal;


                        if (minhaLista.size() <= i) {
                            ClassificacaoOficial classificacaoOficial = new ClassificacaoOficial(nome, imagem, totalJogos, golsProTotal, golsContraTotal, saldoGols, totalPontos, totalVitoria, totalEmpate, totalDerrota);
                            minhaLista.add(classificacaoOficial);
                        }


                        Log.i("nome", "Do Time: " + nome + ": " + imagem);


                    } //Fim do for que percorre toda a lista


                     minhaLista.sort(new ComparatorPontos());
                    //Collections.sort(minhaLista);
                    Collections.reverse(minhaLista);


                    //List<ListaTimeCampeonatoPrincipal> listaDeTimes = response.body();
                    timesBrB2023Adapter = new TimesBrB2023Adapter(minhaLista);
                    binding.rvListaBrasileiroSerieB2023.setAdapter(timesBrB2023Adapter);

                    binding.rvListaBrasileiroSerieB2023.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), binding.rvListaBrasileiroSerieB2023, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {

                            ClassificacaoOficial lista = minhaLista.get(position);


                            //ListaTimeCampeonatoPrincipal lista = listaDeTimes.get(position);

                            switch (lista.getNome()) {
                                case "ABC":
                                    Intent abc = new Intent(getContext(), AbcActivity.class);
                                    startActivity(abc);
                                    Toast.makeText(getContext(), "ABC", Toast.LENGTH_LONG).show();
                                    break;
                                case "Botafogo-SP":
                                    Intent botafogoSp = new Intent(getContext(), BotafogoSpActivity.class);
                                    startActivity(botafogoSp);
                                    break;
                                case "CRB":
                                    Intent crb = new Intent(getContext(), CrbActivity.class);
                                    startActivity(crb);
                                    break;
                                case "Atlético-GO":
                                    Intent atleticoGo = new Intent(getContext(), AtleticoGoActivity.class);
                                    startActivity(atleticoGo);
                                    break;
                                case "Avaí":
                                    Intent avai = new Intent(getContext(), AvaiActivity.class);
                                    startActivity(avai);
                                    break;
                                case "Chapecoense":
                                    Intent chapecoense = new Intent(getContext(), ChapecoenseActivity.class);
                                    startActivity(chapecoense);
                                    break;
                                case "Criciúma":
                                    Intent criciuma = new Intent(getContext(), CriciumaActivity.class);
                                    startActivity(criciuma);
                                    break;
                                case "Ceará":
                                    Intent ceara = new Intent(getContext(), CearaActivity.class);
                                    startActivity(ceara);
                                    Toast.makeText(getContext(), "Ceará", Toast.LENGTH_LONG).show();
                                    break;
                                case "Guarani":
                                    Intent guarani = new Intent(getContext(), GuaraniActivity.class);
                                    startActivity(guarani);
                                    break;
                                case "Ituano":
                                    Intent ituano = new Intent(getContext(), ItuanoActivity.class);
                                    startActivity(ituano);
                                    break;
                                case "Juventude":
                                    Intent juventude = new Intent(getContext(), JuventudeActivity.class);
                                    startActivity(juventude);
                                    break;
                                case "Londrina":
                                    Intent londrina = new Intent(getContext(), LondrinaActivity.class);
                                    startActivity(londrina);
                                    break;
                                case "Mirassol":
                                    Intent mirassol = new Intent(getContext(), MirassolActivity.class);
                                    startActivity(mirassol);
                                    break;
                                case "Novorizontino":
                                    Intent novorizontino = new Intent(getContext(), NovorizontinoActivity.class);
                                    startActivity(novorizontino);
                                    break;
                                case "Ponte Preta":
                                    Intent pontePreta = new Intent(getContext(), PontePretaActivity.class);
                                    startActivity(pontePreta);
                                    break;
                                case "Sampaio Corrêa":
                                    Intent sampaioCorrea = new Intent(getContext(), SampaioCorreiaActivity.class);
                                    startActivity(sampaioCorrea);
                                    break;
                                case "Sport":
                                    Intent sport = new Intent(getContext(), SportActivity.class);
                                    startActivity(sport);
                                    break;
                                case "Tombense":
                                    Intent tombense = new Intent(getContext(), TombenseActivity.class);
                                    startActivity(tombense);
                                    break;
                                case "Vila Nova":
                                    Intent vilaNova = new Intent(getContext(), VilaNovaActivity.class);
                                    startActivity(vilaNova);
                                    break;
                                case "Vitória":
                                    Intent vitoria = new Intent(getContext(), VitoriaActivity.class);
                                    startActivity(vitoria);
                                    break;

                            }

                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }
                    }));


                } else {
                    errorBuscarDados();
                }


            }

            @Override
            public void onFailure(Call<List<TimeClassificacao>> call, Throwable t) {
                errorBuscarDados();
            }
        });


    }//Fim do método de setup



    private void errorBuscarDados() {

        Snackbar.make(binding.getRoot(), "erro ao buscar dados da API, Verifique a conexão de Internet, ", Snackbar.LENGTH_LONG).show();

    }



}