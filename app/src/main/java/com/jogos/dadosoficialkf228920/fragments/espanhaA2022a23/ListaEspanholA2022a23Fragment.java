package com.jogos.dadosoficialkf228920.fragments.espanhaA2022a23;

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
import com.jogos.dadosoficialkf228920.activity.espanhaA2022a23.AlmeriaActivity;
import com.jogos.dadosoficialkf228920.activity.espanhaA2022a23.AthleticBilbaoActivity;
import com.jogos.dadosoficialkf228920.activity.espanhaA2022a23.AtleticoMadridActivity;
import com.jogos.dadosoficialkf228920.activity.espanhaA2022a23.BarcelonaActivity;
import com.jogos.dadosoficialkf228920.activity.espanhaA2022a23.CadizActivity;
import com.jogos.dadosoficialkf228920.activity.espanhaA2022a23.CeltaVigoActivity;
import com.jogos.dadosoficialkf228920.activity.espanhaA2022a23.ElcheActivity;
import com.jogos.dadosoficialkf228920.activity.espanhaA2022a23.EspanyolActivity;
import com.jogos.dadosoficialkf228920.activity.espanhaA2022a23.GetafeActivity;
import com.jogos.dadosoficialkf228920.activity.espanhaA2022a23.GironaActivity;
import com.jogos.dadosoficialkf228920.activity.espanhaA2022a23.MallorcaActivity;
import com.jogos.dadosoficialkf228920.activity.espanhaA2022a23.OsasunaActivity;
import com.jogos.dadosoficialkf228920.activity.espanhaA2022a23.RayoVallecanoActivity;
import com.jogos.dadosoficialkf228920.activity.espanhaA2022a23.RealBetisActivity;
import com.jogos.dadosoficialkf228920.activity.espanhaA2022a23.RealMadridActivity;
import com.jogos.dadosoficialkf228920.activity.espanhaA2022a23.RealSociedadActivity;
import com.jogos.dadosoficialkf228920.activity.espanhaA2022a23.RealValladolidActivity;
import com.jogos.dadosoficialkf228920.activity.espanhaA2022a23.SevillaActivity;
import com.jogos.dadosoficialkf228920.activity.espanhaA2022a23.ValenciaActivity;
import com.jogos.dadosoficialkf228920.activity.espanhaA2022a23.VillarrealActivity;
import com.jogos.dadosoficialkf228920.adapter.espanhaA2022a23.TimesEspanholA2022a23Adapter;
import com.jogos.dadosoficialkf228920.data.espanhaA2022a23.TimesEspanholA2022a23Api;
import com.jogos.dadosoficialkf228920.databinding.FragmentListaEspanholA2022a23Binding;
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

public class ListaEspanholA2022a23Fragment extends Fragment {

    private FragmentListaEspanholA2022a23Binding binding;
    private TimesEspanholA2022a23Api timesEspanholA2022a23Api;
    private TimesEspanholA2022a23Adapter timesEspanholA2022a23Adapter;


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


    public ListaEspanholA2022a23Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentListaEspanholA2022a23Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupListaTimes();

        return view;
    }

    private void setupHttpClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/espanhol-a-2022-23/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        timesEspanholA2022a23Api = retrofit.create(TimesEspanholA2022a23Api.class);

    }

    private void setupListaTimes() {

        binding.rvListaEspanholA2022a23.setHasFixedSize(true);
        binding.rvListaEspanholA2022a23.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvListaEspanholA2022a23.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));


        timesEspanholA2022a23Api.getTimesEspanholA2022a2023().enqueue(new Callback<List<TimeClassificacao>>() {
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

                    timesEspanholA2022a23Adapter = new TimesEspanholA2022a23Adapter(minhaLista);
                    binding.rvListaEspanholA2022a23.setAdapter(timesEspanholA2022a23Adapter);

                    binding.rvListaEspanholA2022a23.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), binding.rvListaEspanholA2022a23, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {

                            ClassificacaoOficial lista = minhaLista.get(position);

                            switch (lista.getNome()){
                                case "Almería":
                                    Intent almeria = new Intent(getContext(), AlmeriaActivity.class);
                                    startActivity(almeria);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Athletic Bilbao":
                                    Intent athleticBilbao = new Intent(getContext(), AthleticBilbaoActivity.class);
                                    startActivity(athleticBilbao);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Atlético de Madrid":
                                    Intent atleticoMadrid = new Intent(getContext(), AtleticoMadridActivity.class);
                                    startActivity(atleticoMadrid);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Barcelona":
                                    Intent barcelona = new Intent(getContext(), BarcelonaActivity.class);
                                    startActivity(barcelona);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Cádiz":
                                    Intent cadiz = new Intent(getContext(), CadizActivity.class);
                                    startActivity(cadiz);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Celta de Vigo":
                                    Intent celtaVigo = new Intent(getContext(), CeltaVigoActivity.class);
                                    startActivity(celtaVigo);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Elche":
                                    Intent elche = new Intent(getContext(), ElcheActivity.class);
                                    startActivity(elche);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Espanyol":
                                    Intent espanyol = new Intent(getContext(), EspanyolActivity.class);
                                    startActivity(espanyol);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Getafe":
                                    Intent getafe = new Intent(getContext(), GetafeActivity.class);
                                    startActivity(getafe);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Girona":
                                    Intent girona = new Intent(getContext(), GironaActivity.class);
                                    startActivity(girona);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Mallorca":
                                    Intent mallorca = new Intent(getContext(), MallorcaActivity.class);
                                    startActivity(mallorca);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Osasuna":
                                    Intent osasuna = new Intent(getContext(), OsasunaActivity.class);
                                    startActivity(osasuna);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Rayo Vallecano":
                                    Intent rayoVallecano = new Intent(getContext(), RayoVallecanoActivity.class);
                                    startActivity(rayoVallecano);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Real Betis":
                                    Intent realBetis = new Intent(getContext(), RealBetisActivity.class);
                                    startActivity(realBetis);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Real Madrid":
                                    Intent realMadrid = new Intent(getContext(), RealMadridActivity.class);
                                    startActivity(realMadrid);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Real Sociedad":
                                    Intent realSociedad = new Intent(getContext(), RealSociedadActivity.class);
                                    startActivity(realSociedad);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Real Valladolid":
                                    Intent realValladolid = new Intent(getContext(), RealValladolidActivity.class);
                                    startActivity(realValladolid);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Sevilla":
                                    Intent sevilla = new Intent(getContext(), SevillaActivity.class);
                                    startActivity(sevilla);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Valencia":
                                    Intent valencica = new Intent(getContext(), ValenciaActivity.class);
                                    startActivity(valencica);
                                    Toast.makeText(getContext(), " " + lista.getNome(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Villarreal":
                                    Intent villarreal = new Intent(getContext(), VillarrealActivity.class);
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