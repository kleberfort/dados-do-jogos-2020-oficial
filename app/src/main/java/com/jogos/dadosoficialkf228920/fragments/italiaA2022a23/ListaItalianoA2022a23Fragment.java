package com.jogos.dadosoficialkf228920.fragments.italiaA2022a23;

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
import com.jogos.dadosoficialkf228920.activity.italiaA2022a23.AtalantaActivity;
import com.jogos.dadosoficialkf228920.activity.italiaA2022a23.BolognaActivity;
import com.jogos.dadosoficialkf228920.activity.italiaA2022a23.CremoneseActivity;
import com.jogos.dadosoficialkf228920.activity.italiaA2022a23.EmpoliActivity;
import com.jogos.dadosoficialkf228920.activity.italiaA2022a23.FiorentinaActivity;
import com.jogos.dadosoficialkf228920.activity.italiaA2022a23.HellasVeronaActivity;
import com.jogos.dadosoficialkf228920.activity.italiaA2022a23.InterMilanActivity;
import com.jogos.dadosoficialkf228920.activity.italiaA2022a23.JuventusActivity;
import com.jogos.dadosoficialkf228920.activity.italiaA2022a23.LazioActivity;
import com.jogos.dadosoficialkf228920.activity.italiaA2022a23.LecceActivity;
import com.jogos.dadosoficialkf228920.activity.italiaA2022a23.MilanActivity;
import com.jogos.dadosoficialkf228920.activity.italiaA2022a23.MonzaActivity;
import com.jogos.dadosoficialkf228920.activity.italiaA2022a23.NapoliActivity;
import com.jogos.dadosoficialkf228920.activity.italiaA2022a23.RomaActivity;
import com.jogos.dadosoficialkf228920.activity.italiaA2022a23.SalernitanaActivity;
import com.jogos.dadosoficialkf228920.activity.italiaA2022a23.SampdoriaActivity;
import com.jogos.dadosoficialkf228920.activity.italiaA2022a23.SassuoloActivity;
import com.jogos.dadosoficialkf228920.activity.italiaA2022a23.SpeziaActivity;
import com.jogos.dadosoficialkf228920.activity.italiaA2022a23.TorinoActivity;
import com.jogos.dadosoficialkf228920.activity.italiaA2022a23.UdineseActivity;
import com.jogos.dadosoficialkf228920.adapter.italiaA2022a23.TimesItalianoA2022a23Adapter;
import com.jogos.dadosoficialkf228920.data.italiaA2022a23.TimesItalianoA2022a23Api;
import com.jogos.dadosoficialkf228920.databinding.FragmentListaItalianoA2022a23Binding;
import com.jogos.dadosoficialkf228920.model.ClassificacaoOficial;
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


public class ListaItalianoA2022a23Fragment extends Fragment {

    private FragmentListaItalianoA2022a23Binding binding;
    private TimesItalianoA2022a23Adapter timesItalianoA2022a23Adapter;
    private TimesItalianoA2022a23Api timesItalianoA2022a23Api;

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



    public ListaItalianoA2022a23Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentListaItalianoA2022a23Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupListaTimes();

        return view;
    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/italia-a-2022-23/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        timesItalianoA2022a23Api = retrofit.create(TimesItalianoA2022a23Api.class);


    }

    private void setupListaTimes() {

        binding.rvListaItalianoA2022a23.setHasFixedSize(true);
        binding.rvListaItalianoA2022a23.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvListaItalianoA2022a23.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));


        timesItalianoA2022a23Api.getTimesItalianoA2022a2023().enqueue(new Callback<List<TimeClassificacao>>() {
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


                    // minhaLista.sort(new ComparatorPontos());
                    Collections.sort(minhaLista);
                    Collections.reverse(minhaLista);

                    timesItalianoA2022a23Adapter = new TimesItalianoA2022a23Adapter(minhaLista);
                    binding.rvListaItalianoA2022a23.setAdapter(timesItalianoA2022a23Adapter);

                    binding.rvListaItalianoA2022a23.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), binding.rvListaItalianoA2022a23, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {

                            ClassificacaoOficial lista = minhaLista.get(position);

                            switch (lista.getNome()){
                                case "Atalanta":
                                    Intent atalanta = new Intent(getContext(), AtalantaActivity.class);
                                    startActivity(atalanta);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Bologna":
                                    Intent bologna = new Intent(getContext(), BolognaActivity.class);
                                    startActivity(bologna);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Cremonese":
                                    Intent cremonese = new Intent(getContext(), CremoneseActivity.class);
                                    startActivity(cremonese);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Empoli":
                                    Intent empoli = new Intent(getContext(), EmpoliActivity.class);
                                    startActivity(empoli);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Fiorentina":
                                    Intent fiorentina = new Intent(getContext(), FiorentinaActivity.class);
                                    startActivity(fiorentina);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Hellas Verona":
                                    Intent hellasVerona = new Intent(getContext(), HellasVeronaActivity.class);
                                    startActivity(hellasVerona);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Inter Milan":
                                    Intent interMilao = new Intent(getContext(), InterMilanActivity.class);
                                    startActivity(interMilao);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Juventus":
                                    Intent juventus = new Intent(getContext(), JuventusActivity.class);
                                    startActivity(juventus);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Lazio":
                                    Intent lazio = new Intent(getContext(), LazioActivity.class);
                                    startActivity(lazio);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Lecce":
                                    Intent lecce = new Intent(getContext(), LecceActivity.class);
                                    startActivity(lecce);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Milan":
                                    Intent milan = new Intent(getContext(), MilanActivity.class);
                                    startActivity(milan);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Monza":
                                    Intent monza = new Intent(getContext(), MonzaActivity.class);
                                    startActivity(monza);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Napoli":
                                    Intent napoli = new Intent(getContext(), NapoliActivity.class);
                                    startActivity(napoli);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Roma":
                                    Intent roma = new Intent(getContext(), RomaActivity.class);
                                    startActivity(roma);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Salernitana":
                                    Intent salernitanaa = new Intent(getContext(), SalernitanaActivity.class);
                                    startActivity(salernitanaa);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Sampdoria":
                                    Intent sampdoria = new Intent(getContext(), SampdoriaActivity.class);
                                    startActivity(sampdoria);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Sassuolo":
                                    Intent sassuolo = new Intent(getContext(), SassuoloActivity.class);
                                    startActivity(sassuolo);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Spezia":
                                    Intent spezia = new Intent(getContext(), SpeziaActivity.class);
                                    startActivity(spezia);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Torino":
                                    Intent torino = new Intent(getContext(), TorinoActivity.class);
                                    startActivity(torino);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Udinese":
                                    Intent udinese = new Intent(getContext(), UdineseActivity.class);
                                    startActivity(udinese);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                            }

                        }

                        @Override
                        public void onLongItemClick(View view, int position) {
                            errorBuscarDados();
                        }
                    }));



                }else {
                    errorBuscarDados();

                }

            }

            @Override
            public void onFailure(Call<List<TimeClassificacao>> call, Throwable t) {

            }
        });

    }

    private void errorBuscarDados() {
        Snackbar.make(binding.getRoot(), "erro ao buscar dados da API, Verifique a conexão de Internet, ", Snackbar.LENGTH_LONG).show();
    }
}