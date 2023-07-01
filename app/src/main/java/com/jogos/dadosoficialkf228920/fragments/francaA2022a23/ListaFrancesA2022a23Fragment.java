package com.jogos.dadosoficialkf228920.fragments.francaA2022a23;

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
import com.jogos.dadosoficialkf228920.activity.francaA2022a23.AjaccioActivity;
import com.jogos.dadosoficialkf228920.activity.francaA2022a23.AngersActivity;
import com.jogos.dadosoficialkf228920.activity.francaA2022a23.AuxerreActivity;
import com.jogos.dadosoficialkf228920.activity.francaA2022a23.BrestActivity;
import com.jogos.dadosoficialkf228920.activity.francaA2022a23.ClermontActivity;
import com.jogos.dadosoficialkf228920.activity.francaA2022a23.LensActivity;
import com.jogos.dadosoficialkf228920.activity.francaA2022a23.LilleActivity;
import com.jogos.dadosoficialkf228920.activity.francaA2022a23.LorientActivity;
import com.jogos.dadosoficialkf228920.activity.francaA2022a23.LyonActivity;
import com.jogos.dadosoficialkf228920.activity.francaA2022a23.MarseilleActivity;
import com.jogos.dadosoficialkf228920.activity.francaA2022a23.MonacoActivity;
import com.jogos.dadosoficialkf228920.activity.francaA2022a23.MontpellierActivity;
import com.jogos.dadosoficialkf228920.activity.francaA2022a23.NantesActivity;
import com.jogos.dadosoficialkf228920.activity.francaA2022a23.NiceActivity;
import com.jogos.dadosoficialkf228920.activity.francaA2022a23.PsgActivity;
import com.jogos.dadosoficialkf228920.activity.francaA2022a23.ReimsActivity;
import com.jogos.dadosoficialkf228920.activity.francaA2022a23.RennesActivity;
import com.jogos.dadosoficialkf228920.activity.francaA2022a23.StrasbourgActivity;
import com.jogos.dadosoficialkf228920.activity.francaA2022a23.ToulouseActivity;
import com.jogos.dadosoficialkf228920.activity.francaA2022a23.TroyesActivity;
import com.jogos.dadosoficialkf228920.adapter.francaA2022a23.TimesFrancesA2022a23Adpater;
import com.jogos.dadosoficialkf228920.data.francaA2022a23.TimesFrancesA2022a23Api;
import com.jogos.dadosoficialkf228920.databinding.FragmentListaFrancesA2022a23Binding;
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


public class ListaFrancesA2022a23Fragment extends Fragment {

    private FragmentListaFrancesA2022a23Binding binding;
    private TimesFrancesA2022a23Adpater timesFrancesA2022a23Adpater;
    private TimesFrancesA2022a23Api timesFrancesA2022a23Api;


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




    public ListaFrancesA2022a23Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentListaFrancesA2022a23Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupListaTimes();

        return view;
    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/franca-a-2022-23/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        timesFrancesA2022a23Api = retrofit.create(TimesFrancesA2022a23Api.class);


    }

    private void setupListaTimes() {

        binding.rvListaFrancesA2022a23.setHasFixedSize(true);
        binding.rvListaFrancesA2022a23.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvListaFrancesA2022a23.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));


        timesFrancesA2022a23Api.getTimesFrancesA2022a2023().enqueue(new Callback<List<TimeClassificacao>>() {
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
                   // Collections.sort(minhaLista);
                    Collections.reverse(minhaLista);

                    timesFrancesA2022a23Adpater = new TimesFrancesA2022a23Adpater(minhaLista);
                    binding.rvListaFrancesA2022a23.setAdapter(timesFrancesA2022a23Adpater);

                    binding.rvListaFrancesA2022a23.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), binding.rvListaFrancesA2022a23, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {

                            ClassificacaoOficial lista = minhaLista.get(position);

                            switch (lista.getNome()){
                                case "Ajaccio":
                                    Intent ajaccio = new Intent(getContext(), AjaccioActivity.class);
                                    startActivity(ajaccio);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Angers":
                                    Intent angers = new Intent(getContext(), AngersActivity.class);
                                    startActivity(angers);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Auxerre":
                                    Intent auxerre = new Intent(getContext(), AuxerreActivity.class);
                                    startActivity(auxerre);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Brest":
                                    Intent brest = new Intent(getContext(), BrestActivity.class);
                                    startActivity(brest);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Clermont":
                                    Intent clermont = new Intent(getContext(), ClermontActivity.class);
                                    startActivity(clermont);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Lens":
                                    Intent lens = new Intent(getContext(), LensActivity.class);
                                    startActivity(lens);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Lille":
                                    Intent lille = new Intent(getContext(), LilleActivity.class);
                                    startActivity(lille);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Lorient":
                                    Intent lorient = new Intent(getContext(), LorientActivity.class);
                                    startActivity(lorient);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Lyon":
                                    Intent lyon = new Intent(getContext(), LyonActivity.class);
                                    startActivity(lyon);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Marseille":
                                    Intent marseille = new Intent(getContext(), MarseilleActivity.class);
                                    startActivity(marseille);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Monaco":
                                    Intent monaco = new Intent(getContext(), MonacoActivity.class);
                                    startActivity(monaco);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Montpellier":
                                    Intent montpellier = new Intent(getContext(), MontpellierActivity.class);
                                    startActivity(montpellier);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Nantes":
                                    Intent nantes = new Intent(getContext(), NantesActivity.class);
                                    startActivity(nantes);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Nice":
                                    Intent nice = new Intent(getContext(), NiceActivity.class);
                                    startActivity(nice);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "PSG":
                                    Intent psg = new Intent(getContext(), PsgActivity.class);
                                    startActivity(psg);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Reims":
                                    Intent reims = new Intent(getContext(), ReimsActivity.class);
                                    startActivity(reims);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Rennes":
                                    Intent rennes = new Intent(getContext(), RennesActivity.class);
                                    startActivity(rennes);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Strasbourg":
                                    Intent strasbourg = new Intent(getContext(), StrasbourgActivity.class);
                                    startActivity(strasbourg);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Toulouse":
                                    Intent toulouse = new Intent(getContext(), ToulouseActivity.class);
                                    startActivity(toulouse);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Troyes":
                                    Intent troyes = new Intent(getContext(), TroyesActivity.class);
                                    startActivity(troyes);
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