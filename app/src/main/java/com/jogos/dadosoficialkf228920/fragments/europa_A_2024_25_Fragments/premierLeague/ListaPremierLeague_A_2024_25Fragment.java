package com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.premierLeague;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.activity.europa_A_2024_2025.premierLeague.Arsenal2024_25Activity;
import com.jogos.dadosoficialkf228920.activity.europa_A_2024_2025.premierLeague.AstonVilla2024_25Activity;
import com.jogos.dadosoficialkf228920.activity.europa_A_2024_2025.premierLeague.Bournemouth2024_25Activity;
import com.jogos.dadosoficialkf228920.activity.europa_A_2024_2025.premierLeague.Brentford2024_25Activity;
import com.jogos.dadosoficialkf228920.activity.europa_A_2024_2025.premierLeague.Brighton2024_25Activity;
import com.jogos.dadosoficialkf228920.activity.europa_A_2024_2025.premierLeague.Chelsea2024_25Activity;
import com.jogos.dadosoficialkf228920.activity.europa_A_2024_2025.premierLeague.CrystalPalace2024_25Activity;
import com.jogos.dadosoficialkf228920.activity.europa_A_2024_2025.premierLeague.Evernton2024_25Activity;
import com.jogos.dadosoficialkf228920.activity.europa_A_2024_2025.premierLeague.Fulham2024_25Activity;
import com.jogos.dadosoficialkf228920.activity.europa_A_2024_2025.premierLeague.Ipswich2024_25Activity;
import com.jogos.dadosoficialkf228920.activity.europa_A_2024_2025.premierLeague.LeicesterCity2024_25Activity;
import com.jogos.dadosoficialkf228920.activity.europa_A_2024_2025.premierLeague.Liverpool2024_25Activity;
import com.jogos.dadosoficialkf228920.activity.europa_A_2024_2025.premierLeague.ManchesterCity2024_25Activity;
import com.jogos.dadosoficialkf228920.activity.europa_A_2024_2025.premierLeague.ManchesterUnited2024_25Activity;
import com.jogos.dadosoficialkf228920.activity.europa_A_2024_2025.premierLeague.Newcastle2024_25Activity;
import com.jogos.dadosoficialkf228920.activity.europa_A_2024_2025.premierLeague.Nottingham2024_25Activity;
import com.jogos.dadosoficialkf228920.activity.europa_A_2024_2025.premierLeague.Southampton2024_25Activity;
import com.jogos.dadosoficialkf228920.activity.europa_A_2024_2025.premierLeague.Tottenham2024_25Activity;
import com.jogos.dadosoficialkf228920.activity.europa_A_2024_2025.premierLeague.WestHam2024_25Activity;
import com.jogos.dadosoficialkf228920.activity.europa_A_2024_2025.premierLeague.Wolves2024_25Activity;
import com.jogos.dadosoficialkf228920.adapter.brasil2024.TimesClasificacaoBrasilA2024Adapter;
import com.jogos.dadosoficialkf228920.databinding.FragmentListaLigaProfissionalA2024Binding;
import com.jogos.dadosoficialkf228920.databinding.FragmentListaPremierLeagueA202425Binding;
import com.jogos.dadosoficialkf228920.fragments.americadosul.argentina.util.JogosLigaProfissional_A2024;
import com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.premierLeague.util.JogosPremierLeague_A_2024_2025_Listener;
import com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.premierLeague.util.JogosPremierLeague_A_2024_25;
import com.jogos.dadosoficialkf228920.model.ClassificacaoOficialNovoModelo;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;
import com.jogos.dadosoficialkf228920.model.RecyclerItemClickListener;
import com.jogos.dadosoficialkf228920.model.comparator.ComparatorPontosVitoriaSaldoGolsProSerieA_B;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ListaPremierLeague_A_2024_25Fragment extends Fragment  implements JogosPremierLeague_A_2024_2025_Listener {

    private FragmentListaPremierLeagueA202425Binding binding;
    private JogosPremierLeague_A_2024_25 jogosPremierLeagueA202425;
    private TimesClasificacaoBrasilA2024Adapter timesClasificacaoBrasilA2024Adapter;


    String nome = null;
    String imagem = null;


    Integer totalGolsPro = 0;
    Integer totalGolsContra = 0;
    Integer totalsaldoGols = 0;

    Integer totalJogos = 0;

    Integer totalVitoria = 0;
    Integer totalEmpate = 0;
    Integer totalDerrota = 0;
    Integer totalPontos = 0;

    List<PartidaNovoModelo> astonVillaCompleto = new ArrayList<>();
    List<PartidaNovoModelo> arsenalCompleto = new ArrayList<>();
    List<PartidaNovoModelo> brentfordCompleto = new ArrayList<>();
    List<PartidaNovoModelo> brigthonCompleto = new ArrayList<>();
    List<PartidaNovoModelo> bournemouthCompleto = new ArrayList<>();
    List<PartidaNovoModelo> chelseaCompleto = new ArrayList<>();
    List<PartidaNovoModelo> crystalPalaceCompleto = new ArrayList<>();
    List<PartidaNovoModelo> evertonCompleto = new ArrayList<>();
    List<PartidaNovoModelo> forestCompleto = new ArrayList<>();
    List<PartidaNovoModelo> fulhamCompleto = new ArrayList<>();
    List<PartidaNovoModelo> ipswichCompleto = new ArrayList<>();
    List<PartidaNovoModelo> leicesterCompleto = new ArrayList<>();
    List<PartidaNovoModelo> liverpoolCompleto = new ArrayList<>();
    List<PartidaNovoModelo> manCityCompleto = new ArrayList<>();
    List<PartidaNovoModelo> manUtdCompleto = new ArrayList<>();
    List<PartidaNovoModelo> newcastleCompleto = new ArrayList<>();
    List<PartidaNovoModelo> southamptonCompleto = new ArrayList<>();
    List<PartidaNovoModelo> tottenhamCompleto = new ArrayList<>();
    List<PartidaNovoModelo> westHamCompleto = new ArrayList<>();
    List<PartidaNovoModelo> wolvesCompleto = new ArrayList<>();


    List<ClassificacaoOficialNovoModelo> listaOficial = new ArrayList<>(); ;//estamos iniciando nossa lista vazia



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentListaPremierLeagueA202425Binding.inflate(inflater, container, false);
        View view = binding.getRoot();

        jogosPremierLeagueA202425 = new JogosPremierLeague_A_2024_25();
        jogosPremierLeagueA202425.setupHttpClient();
        jogosPremierLeagueA202425.setupDadosJogos();
        jogosPremierLeagueA202425.setListener(this);// Registra o fragmento como listener


        binding.rvLista.setHasFixedSize(true);
        binding.rvLista.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvLista.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        timesClasificacaoBrasilA2024Adapter = new TimesClasificacaoBrasilA2024Adapter(listaOficial);//o adapter vai receber a variazel listaOficial, mas ela esta vazia ainda
        binding.rvLista.setAdapter(timesClasificacaoBrasilA2024Adapter);



        binding.rvLista.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), binding.rvLista, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                ClassificacaoOficialNovoModelo lista = listaOficial.get(position);


                switch (lista.getName()) {
                    case "Aston Villa":
                       // listaArgentinaA2024.listaArgentinaAMetodo("Argentinos Jrs");
                        Intent intent = new Intent(getContext(), AstonVilla2024_25Activity.class);
                         startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Arsenal":
                        // listaArgentinaA2024.listaArgentinaAMetodo("Argentinos Jrs");
                         intent = new Intent(getContext(), Arsenal2024_25Activity.class);
                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Brentford":
                        // listaArgentinaA2024.listaArgentinaAMetodo("Argentinos Jrs");
                         intent = new Intent(getContext(), Brentford2024_25Activity.class);
                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Brighton":
                        // listaArgentinaA2024.listaArgentinaAMetodo("Argentinos Jrs");
                         intent = new Intent(getContext(), Brighton2024_25Activity.class);
                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Bournemouth":
                        // listaArgentinaA2024.listaArgentinaAMetodo("Argentinos Jrs");
                         intent = new Intent(getContext(), Bournemouth2024_25Activity.class);
                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Chelsea":
                        // listaArgentinaA2024.listaArgentinaAMetodo("Argentinos Jrs");
                         intent = new Intent(getContext(), Chelsea2024_25Activity.class);
                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Crystal Palace":
                        // listaArgentinaA2024.listaArgentinaAMetodo("Argentinos Jrs");
                         intent = new Intent(getContext(), CrystalPalace2024_25Activity.class);
                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Everton":
                        // listaArgentinaA2024.listaArgentinaAMetodo("Argentinos Jrs");
                         intent = new Intent(getContext(), Evernton2024_25Activity.class);
                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Forest":
                        // listaArgentinaA2024.listaArgentinaAMetodo("Argentinos Jrs");
                         intent = new Intent(getContext(), Nottingham2024_25Activity.class);
                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Fulham":
                        // listaArgentinaA2024.listaArgentinaAMetodo("Argentinos Jrs");
                         intent = new Intent(getContext(), Fulham2024_25Activity.class);
                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Ipswich":
                        // listaArgentinaA2024.listaArgentinaAMetodo("Argentinos Jrs");
                         intent = new Intent(getContext(), Ipswich2024_25Activity.class);
                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Leicester":
                        // listaArgentinaA2024.listaArgentinaAMetodo("Argentinos Jrs");
                         intent = new Intent(getContext(), LeicesterCity2024_25Activity.class);
                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Liverpool":
                        // listaArgentinaA2024.listaArgentinaAMetodo("Argentinos Jrs");
                         intent = new Intent(getContext(), Liverpool2024_25Activity.class);
                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;

                    case "Man City":
                        // listaArgentinaA2024.listaArgentinaAMetodo("Argentinos Jrs");
                         intent = new Intent(getContext(), ManchesterCity2024_25Activity.class);
                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Man Utd":
                        // listaArgentinaA2024.listaArgentinaAMetodo("Argentinos Jrs");
                         intent = new Intent(getContext(), ManchesterUnited2024_25Activity.class);
                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Newcastle":
                        // listaArgentinaA2024.listaArgentinaAMetodo("Argentinos Jrs");
                         intent = new Intent(getContext(), Newcastle2024_25Activity.class);
                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Southampton":
                        // listaArgentinaA2024.listaArgentinaAMetodo("Argentinos Jrs");
                         intent = new Intent(getContext(), Southampton2024_25Activity.class);
                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Tottenham":
                        // listaArgentinaA2024.listaArgentinaAMetodo("Argentinos Jrs");
                         intent = new Intent(getContext(), Tottenham2024_25Activity.class);
                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "West Ham":
                        // listaArgentinaA2024.listaArgentinaAMetodo("Argentinos Jrs");
                         intent = new Intent(getContext(), WestHam2024_25Activity.class);
                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Wolves":
                        // listaArgentinaA2024.listaArgentinaAMetodo("Argentinos Jrs");
                         intent = new Intent(getContext(), Wolves2024_25Activity.class);
                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;


                }
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));

        return view;
    }

    @Override
    public void onJogosPremierLeague_A(List<PartidaNovoModelo> astonVillaCompleto, List<PartidaNovoModelo> arsenalCompleto, List<PartidaNovoModelo> brentfordCompleto,
                                       List<PartidaNovoModelo> brigthonCompleto, List<PartidaNovoModelo> bournemouthCompleto, List<PartidaNovoModelo> chelseaCompleto,
                                       List<PartidaNovoModelo> crystalPalaceCompleto, List<PartidaNovoModelo> evertonCompleto, List<PartidaNovoModelo> forestCompleto,
                                       List<PartidaNovoModelo> fulhamCompleto, List<PartidaNovoModelo> ipswichCompleto, List<PartidaNovoModelo> leicesterCompleto,
                                       List<PartidaNovoModelo> liverpoolCompleto, List<PartidaNovoModelo> manCityCompleto, List<PartidaNovoModelo> manUtdCompleto,
                                       List<PartidaNovoModelo> newcastleCompleto, List<PartidaNovoModelo> southamptonCompleto, List<PartidaNovoModelo> tottenhamCompleto,
                                       List<PartidaNovoModelo> westHamCompleto, List<PartidaNovoModelo> wolvesCompleto) {


        this.astonVillaCompleto = astonVillaCompleto;
        this.arsenalCompleto = arsenalCompleto;
        this.brentfordCompleto =  brentfordCompleto;
        this.brigthonCompleto = brigthonCompleto;
        this.bournemouthCompleto = bournemouthCompleto;
        this.chelseaCompleto = chelseaCompleto;
        this.crystalPalaceCompleto = crystalPalaceCompleto;
        this.evertonCompleto = evertonCompleto;
        this. forestCompleto = forestCompleto;
        this.fulhamCompleto = fulhamCompleto;
        this.ipswichCompleto = ipswichCompleto;
        this.leicesterCompleto = leicesterCompleto;
        this.liverpoolCompleto = liverpoolCompleto;
        this.manCityCompleto = manCityCompleto;
        this.manUtdCompleto = manUtdCompleto;
        this.newcastleCompleto = newcastleCompleto;
        this.southamptonCompleto = southamptonCompleto;
        this.tottenhamCompleto = tottenhamCompleto;
        this.westHamCompleto = westHamCompleto;
        this.wolvesCompleto = wolvesCompleto;

        ClassificacaoOficialNovoModelo classificacaoOficialNovoModelo = new ClassificacaoOficialNovoModelo();


        String name = null;
        String image = null;
        Integer pontos = 0;
        Integer golsPro = 0;
        Integer golsContra = 0;
        Integer saldoGols = 0;
        Integer jogos = 0;
        Integer vitoria = 0;
        Integer empate = 0;
        Integer derrota = 0;
        

        for (int i = 0; i < astonVillaCompleto.size(); i++) {
            if (astonVillaCompleto.get(i).getHomeTime().getName().equals("Aston Villa")) {
                name = astonVillaCompleto.get(i).getHomeTime().getName();
                image = astonVillaCompleto.get(i).getHomeTime().getImage();
                if (astonVillaCompleto.get(i).getHomeTime().getScore() > astonVillaCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (astonVillaCompleto.get(i).getHomeTime().getScore() == astonVillaCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (astonVillaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += astonVillaCompleto.get(i).getHomeTime().getScore();
                if (astonVillaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += astonVillaCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (astonVillaCompleto.get(i).getAwayTime().getName().equals("Aston Villa")) {
                name = astonVillaCompleto.get(i).getAwayTime().getName();
                image = astonVillaCompleto.get(i).getAwayTime().getImage();
                if (astonVillaCompleto.get(i).getAwayTime().getScore() > astonVillaCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (astonVillaCompleto.get(i).getAwayTime().getScore() == astonVillaCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (astonVillaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += astonVillaCompleto.get(i).getAwayTime().getScore();
                if (astonVillaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += astonVillaCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for bournemouth

        ClassificacaoOficialNovoModelo classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);

        listaOficial.add(classifica);//adicionamos as informacoes na nossa variavel que foi passada para o adapter na linha 110.
        //essa variavel listaOficial esta associada ao nosso adapter, pois fizemos isso na linha 110
        //entendeu essa parte ?sim


        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < arsenalCompleto.size(); i++) {
            if (arsenalCompleto.get(i).getHomeTime().getName().equals("Arsenal")) {
                name = arsenalCompleto.get(i).getHomeTime().getName();
                image = arsenalCompleto.get(i).getHomeTime().getImage();
                if (arsenalCompleto.get(i).getHomeTime().getScore() > arsenalCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (arsenalCompleto.get(i).getHomeTime().getScore() == arsenalCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (arsenalCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += arsenalCompleto.get(i).getHomeTime().getScore();
                if (arsenalCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += arsenalCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (arsenalCompleto.get(i).getAwayTime().getName().equals("Arsenal")) {
                name = arsenalCompleto.get(i).getAwayTime().getName();
                image = arsenalCompleto.get(i).getAwayTime().getImage();
                if (arsenalCompleto.get(i).getAwayTime().getScore() > arsenalCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (arsenalCompleto.get(i).getAwayTime().getScore() == arsenalCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (arsenalCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += arsenalCompleto.get(i).getAwayTime().getScore();
                if (arsenalCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += arsenalCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for brentford

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);


        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < brentfordCompleto.size(); i++) {
            if (brentfordCompleto.get(i).getHomeTime().getName().equals("Brentford")) {
                name = brentfordCompleto.get(i).getHomeTime().getName();
                image = brentfordCompleto.get(i).getHomeTime().getImage();
                if (brentfordCompleto.get(i).getHomeTime().getScore() > brentfordCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (brentfordCompleto.get(i).getHomeTime().getScore() == brentfordCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (brentfordCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += brentfordCompleto.get(i).getHomeTime().getScore();
                if (brentfordCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += brentfordCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (brentfordCompleto.get(i).getAwayTime().getName().equals("Brentford")) {
                name = brentfordCompleto.get(i).getAwayTime().getName();
                image = brentfordCompleto.get(i).getAwayTime().getImage();
                if (brentfordCompleto.get(i).getAwayTime().getScore() > brentfordCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (brentfordCompleto.get(i).getAwayTime().getScore() == brentfordCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (brentfordCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += brentfordCompleto.get(i).getAwayTime().getScore();
                if (brentfordCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += brentfordCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for brighton

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);

        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < brigthonCompleto.size(); i++) {
            if (brigthonCompleto.get(i).getHomeTime().getName().equals("Brighton")) {
                name = brigthonCompleto.get(i).getHomeTime().getName();
                image = brigthonCompleto.get(i).getHomeTime().getImage();
                if (brigthonCompleto.get(i).getHomeTime().getScore() > brigthonCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (brigthonCompleto.get(i).getHomeTime().getScore() == brigthonCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (brigthonCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += brigthonCompleto.get(i).getHomeTime().getScore();
                if (brigthonCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += brigthonCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (brigthonCompleto.get(i).getAwayTime().getName().equals("Brighton")) {
                name = brigthonCompleto.get(i).getAwayTime().getName();
                image = brigthonCompleto.get(i).getAwayTime().getImage();
                if (brigthonCompleto.get(i).getAwayTime().getScore() > brigthonCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (brigthonCompleto.get(i).getAwayTime().getScore() == brigthonCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (brigthonCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += brigthonCompleto.get(i).getAwayTime().getScore();
                if (brigthonCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += brigthonCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for burnley

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);

        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < bournemouthCompleto.size(); i++) {
            if (bournemouthCompleto.get(i).getHomeTime().getName().equals("Bournemouth")) {
                name = bournemouthCompleto.get(i).getHomeTime().getName();
                image = bournemouthCompleto.get(i).getHomeTime().getImage();
                if (bournemouthCompleto.get(i).getHomeTime().getScore() > bournemouthCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (bournemouthCompleto.get(i).getHomeTime().getScore() == bournemouthCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (bournemouthCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += bournemouthCompleto.get(i).getHomeTime().getScore();
                if (bournemouthCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += bournemouthCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (bournemouthCompleto.get(i).getAwayTime().getName().equals("Bournemouth")) {
                name = bournemouthCompleto.get(i).getAwayTime().getName();
                image = bournemouthCompleto.get(i).getAwayTime().getImage();
                if (bournemouthCompleto.get(i).getAwayTime().getScore() > bournemouthCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (bournemouthCompleto.get(i).getAwayTime().getScore() == bournemouthCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (bournemouthCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += bournemouthCompleto.get(i).getAwayTime().getScore();
                if (bournemouthCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += bournemouthCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for chelsea

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);


        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < chelseaCompleto.size(); i++) {
            if (chelseaCompleto.get(i).getHomeTime().getName().equals("Chelsea")) {
                name = chelseaCompleto.get(i).getHomeTime().getName();
                image = chelseaCompleto.get(i).getHomeTime().getImage();
                if (chelseaCompleto.get(i).getHomeTime().getScore() > chelseaCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (chelseaCompleto.get(i).getHomeTime().getScore() == chelseaCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (chelseaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += chelseaCompleto.get(i).getHomeTime().getScore();
                if (chelseaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += chelseaCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (chelseaCompleto.get(i).getAwayTime().getName().equals("Chelsea")) {
                name = chelseaCompleto.get(i).getAwayTime().getName();
                image = chelseaCompleto.get(i).getAwayTime().getImage();
                if (chelseaCompleto.get(i).getAwayTime().getScore() > chelseaCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (chelseaCompleto.get(i).getAwayTime().getScore() == chelseaCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (chelseaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += chelseaCompleto.get(i).getAwayTime().getScore();
                if (chelseaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += chelseaCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for crystalPalace

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);


        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < crystalPalaceCompleto.size(); i++) {
            if (crystalPalaceCompleto.get(i).getHomeTime().getName().equals("Crystal Palace")) {
                name = crystalPalaceCompleto.get(i).getHomeTime().getName();
                image = crystalPalaceCompleto.get(i).getHomeTime().getImage();
                if (crystalPalaceCompleto.get(i).getHomeTime().getScore() > crystalPalaceCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (crystalPalaceCompleto.get(i).getHomeTime().getScore() == crystalPalaceCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (crystalPalaceCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += crystalPalaceCompleto.get(i).getHomeTime().getScore();
                if (crystalPalaceCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += crystalPalaceCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (crystalPalaceCompleto.get(i).getAwayTime().getName().equals("Crystal Palace")) {
                name = crystalPalaceCompleto.get(i).getAwayTime().getName();
                image = crystalPalaceCompleto.get(i).getAwayTime().getImage();
                if (crystalPalaceCompleto.get(i).getAwayTime().getScore() > crystalPalaceCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (crystalPalaceCompleto.get(i).getAwayTime().getScore() == crystalPalaceCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (crystalPalaceCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += crystalPalaceCompleto.get(i).getAwayTime().getScore();
                if (crystalPalaceCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += crystalPalaceCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for everton

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);


        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < evertonCompleto.size(); i++) {
            if (evertonCompleto.get(i).getHomeTime().getName().equals("Everton")) {
                name = evertonCompleto.get(i).getHomeTime().getName();
                image = evertonCompleto.get(i).getHomeTime().getImage();
                if (evertonCompleto.get(i).getHomeTime().getScore() > evertonCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (evertonCompleto.get(i).getHomeTime().getScore() == evertonCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (evertonCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += evertonCompleto.get(i).getHomeTime().getScore();
                if (evertonCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += evertonCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (evertonCompleto.get(i).getAwayTime().getName().equals("Everton")) {
                name = evertonCompleto.get(i).getAwayTime().getName();
                image = evertonCompleto.get(i).getAwayTime().getImage();
                if (evertonCompleto.get(i).getAwayTime().getScore() > evertonCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (evertonCompleto.get(i).getAwayTime().getScore() == evertonCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (evertonCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += evertonCompleto.get(i).getAwayTime().getScore();
                if (evertonCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += evertonCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for fulham

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);


        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < forestCompleto.size(); i++) {
            if (forestCompleto.get(i).getHomeTime().getName().equals("Forest")) {
                name = forestCompleto.get(i).getHomeTime().getName();
                image = forestCompleto.get(i).getHomeTime().getImage();
                if (forestCompleto.get(i).getHomeTime().getScore() > forestCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (forestCompleto.get(i).getHomeTime().getScore() == forestCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (forestCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += forestCompleto.get(i).getHomeTime().getScore();
                if (forestCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += forestCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (forestCompleto.get(i).getAwayTime().getName().equals("Forest")) {
                name = forestCompleto.get(i).getAwayTime().getName();
                image = forestCompleto.get(i).getAwayTime().getImage();
                if (forestCompleto.get(i).getAwayTime().getScore() > forestCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (forestCompleto.get(i).getAwayTime().getScore() == forestCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (forestCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += forestCompleto.get(i).getAwayTime().getScore();
                if (forestCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += forestCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for liverpool

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);


        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < fulhamCompleto.size(); i++) {
            if (fulhamCompleto.get(i).getHomeTime().getName().equals("Fulham")) {
                name = fulhamCompleto.get(i).getHomeTime().getName();
                image = fulhamCompleto.get(i).getHomeTime().getImage();
                if (fulhamCompleto.get(i).getHomeTime().getScore() > fulhamCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (fulhamCompleto.get(i).getHomeTime().getScore() == fulhamCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (fulhamCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += fulhamCompleto.get(i).getHomeTime().getScore();
                if (fulhamCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += fulhamCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (fulhamCompleto.get(i).getAwayTime().getName().equals("Fulham")) {
                name = fulhamCompleto.get(i).getAwayTime().getName();
                image = fulhamCompleto.get(i).getAwayTime().getImage();
                if (fulhamCompleto.get(i).getAwayTime().getScore() > fulhamCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (fulhamCompleto.get(i).getAwayTime().getScore() == fulhamCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (fulhamCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += fulhamCompleto.get(i).getAwayTime().getScore();
                if (fulhamCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += fulhamCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for luton

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);

        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < ipswichCompleto.size(); i++) {
            if (ipswichCompleto.get(i).getHomeTime().getName().equals("Ipswich")) {
                name = ipswichCompleto.get(i).getHomeTime().getName();
                image = ipswichCompleto.get(i).getHomeTime().getImage();
                if (ipswichCompleto.get(i).getHomeTime().getScore() > ipswichCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (ipswichCompleto.get(i).getHomeTime().getScore() == ipswichCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (ipswichCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += ipswichCompleto.get(i).getHomeTime().getScore();
                if (ipswichCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += ipswichCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (ipswichCompleto.get(i).getAwayTime().getName().equals("Ipswich")) {
                name = ipswichCompleto.get(i).getAwayTime().getName();
                image = ipswichCompleto.get(i).getAwayTime().getImage();
                if (ipswichCompleto.get(i).getAwayTime().getScore() > ipswichCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (ipswichCompleto.get(i).getAwayTime().getScore() == ipswichCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (ipswichCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += ipswichCompleto.get(i).getAwayTime().getScore();
                if (ipswichCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += ipswichCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for city

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);


        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < leicesterCompleto.size(); i++) {
            if (leicesterCompleto.get(i).getHomeTime().getName().equals("Leicester")) {
                name = leicesterCompleto.get(i).getHomeTime().getName();
                image = leicesterCompleto.get(i).getHomeTime().getImage();
                if (leicesterCompleto.get(i).getHomeTime().getScore() > leicesterCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (leicesterCompleto.get(i).getHomeTime().getScore() == leicesterCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (leicesterCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += leicesterCompleto.get(i).getHomeTime().getScore();
                if (leicesterCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += leicesterCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (leicesterCompleto.get(i).getAwayTime().getName().equals("Leicester")) {
                name = leicesterCompleto.get(i).getAwayTime().getName();
                image = leicesterCompleto.get(i).getAwayTime().getImage();
                if (leicesterCompleto.get(i).getAwayTime().getScore() > leicesterCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (leicesterCompleto.get(i).getAwayTime().getScore() == leicesterCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (leicesterCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += leicesterCompleto.get(i).getAwayTime().getScore();
                if (leicesterCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += leicesterCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for unitede

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);


        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < liverpoolCompleto.size(); i++) {
            if (liverpoolCompleto.get(i).getHomeTime().getName().equals("Liverpool")) {
                name = liverpoolCompleto.get(i).getHomeTime().getName();
                image = liverpoolCompleto.get(i).getHomeTime().getImage();
                if (liverpoolCompleto.get(i).getHomeTime().getScore() > liverpoolCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (liverpoolCompleto.get(i).getHomeTime().getScore() == liverpoolCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (liverpoolCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += liverpoolCompleto.get(i).getHomeTime().getScore();
                if (liverpoolCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += liverpoolCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (liverpoolCompleto.get(i).getAwayTime().getName().equals("Liverpool")) {
                name = liverpoolCompleto.get(i).getAwayTime().getName();
                image = liverpoolCompleto.get(i).getAwayTime().getImage();
                if (liverpoolCompleto.get(i).getAwayTime().getScore() > liverpoolCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (liverpoolCompleto.get(i).getAwayTime().getScore() == liverpoolCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (liverpoolCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += liverpoolCompleto.get(i).getAwayTime().getScore();
                if (liverpoolCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += liverpoolCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for newcastle

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);


        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < manCityCompleto.size(); i++) {
            if (manCityCompleto.get(i).getHomeTime().getName().equals("Man City")) {
                name = manCityCompleto.get(i).getHomeTime().getName();
                image = manCityCompleto.get(i).getHomeTime().getImage();
                if (manCityCompleto.get(i).getHomeTime().getScore() > manCityCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (manCityCompleto.get(i).getHomeTime().getScore() == manCityCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (manCityCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += manCityCompleto.get(i).getHomeTime().getScore();
                if (manCityCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += manCityCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (manCityCompleto.get(i).getAwayTime().getName().equals("Man City")) {
                name = manCityCompleto.get(i).getAwayTime().getName();
                image = manCityCompleto.get(i).getAwayTime().getImage();
                if (manCityCompleto.get(i).getAwayTime().getScore() > manCityCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (manCityCompleto.get(i).getAwayTime().getScore() == manCityCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (manCityCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += manCityCompleto.get(i).getAwayTime().getScore();
                if (manCityCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += manCityCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for nottingham

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);

        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;


        for (int i = 0; i < manUtdCompleto.size(); i++) {
            if (manUtdCompleto.get(i).getHomeTime().getName().equals("Man Utd")) {
                name = manUtdCompleto.get(i).getHomeTime().getName();
                image = manUtdCompleto.get(i).getHomeTime().getImage();
                if (manUtdCompleto.get(i).getHomeTime().getScore() > manUtdCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (manUtdCompleto.get(i).getHomeTime().getScore() == manUtdCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (manUtdCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += manUtdCompleto.get(i).getHomeTime().getScore();
                if (manUtdCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += manUtdCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (manUtdCompleto.get(i).getAwayTime().getName().equals("Man Utd")) {
                name = manUtdCompleto.get(i).getAwayTime().getName();
                image = manUtdCompleto.get(i).getAwayTime().getImage();
                if (manUtdCompleto.get(i).getAwayTime().getScore() > manUtdCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (manUtdCompleto.get(i).getAwayTime().getScore() == manUtdCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (manUtdCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += manUtdCompleto.get(i).getAwayTime().getScore();
                if (manUtdCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += manUtdCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for sheffield

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);

        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;


        for (int i = 0; i < newcastleCompleto.size(); i++) {
            if (newcastleCompleto.get(i).getHomeTime().getName().equals("Newcastle")) {
                name = newcastleCompleto.get(i).getHomeTime().getName();
                image = newcastleCompleto.get(i).getHomeTime().getImage();
                if (newcastleCompleto.get(i).getHomeTime().getScore() > newcastleCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (newcastleCompleto.get(i).getHomeTime().getScore() == newcastleCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (newcastleCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += newcastleCompleto.get(i).getHomeTime().getScore();
                if (newcastleCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += newcastleCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (newcastleCompleto.get(i).getAwayTime().getName().equals("Newcastle")) {
                name = newcastleCompleto.get(i).getAwayTime().getName();
                image = newcastleCompleto.get(i).getAwayTime().getImage();
                if (newcastleCompleto.get(i).getAwayTime().getScore() > newcastleCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (newcastleCompleto.get(i).getAwayTime().getScore() == newcastleCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (newcastleCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += newcastleCompleto.get(i).getAwayTime().getScore();
                if (newcastleCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += newcastleCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for tottenham

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);//aqui modifiquei a variavel


        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;


        for (int i = 0; i < southamptonCompleto.size(); i++) {
            if (southamptonCompleto.get(i).getHomeTime().getName().equals("Southampton")) {
                name = southamptonCompleto.get(i).getHomeTime().getName();
                image = southamptonCompleto.get(i).getHomeTime().getImage();
                if (southamptonCompleto.get(i).getHomeTime().getScore() > southamptonCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (southamptonCompleto.get(i).getHomeTime().getScore() == southamptonCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (southamptonCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += southamptonCompleto.get(i).getHomeTime().getScore();
                if (southamptonCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += southamptonCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (southamptonCompleto.get(i).getAwayTime().getName().equals("Southampton")) {
                name = southamptonCompleto.get(i).getAwayTime().getName();
                image = southamptonCompleto.get(i).getAwayTime().getImage();
                if (southamptonCompleto.get(i).getAwayTime().getScore() > southamptonCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (southamptonCompleto.get(i).getAwayTime().getScore() == southamptonCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (southamptonCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += southamptonCompleto.get(i).getAwayTime().getScore();
                if (southamptonCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += southamptonCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for westHam

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);//aqui modifiquei a variavel


        //isso que fiz vai funcionar tambem.. masss podemos ter um problema de travar.. POis quando a lista é grande
        //e fico pedindo para o adapter atualizar para o usuario ele pode demorar e isso pode até fazer o app travar
        //entendeu ?sim, e agora?
        //por isso que nós fazemos o controle e avisamos o adapter para ele atualizar.. POis se toda vez que voce for modificar a variavel listaficial e o adapter
        //atualizar automaticamente pode acontecer esses problemas de travar o app.. entendeu ?sim, e qual seria outra melhor abordagem neste contexto?
        //fazer isso que 'nós fizemos ..pedir para o adapter atualizat a lista somente depois que inserimos tudo dentro da variavel listaOFICIAL
        //ENTENDEU ?pois é, aqui e adicionado a cada laço for percorrido e la no final e adicionado o útimo objeto.. ISSO


        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;


        for (int i = 0; i < tottenhamCompleto.size(); i++) { //inicio do for
            if (tottenhamCompleto.get(i).getHomeTime().getName().equals("Tottenham")) {
                name = tottenhamCompleto.get(i).getHomeTime().getName();
                image = tottenhamCompleto.get(i).getHomeTime().getImage();
                if (tottenhamCompleto.get(i).getHomeTime().getScore() > tottenhamCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (tottenhamCompleto.get(i).getHomeTime().getScore() == tottenhamCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (tottenhamCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += tottenhamCompleto.get(i).getHomeTime().getScore();
                if (tottenhamCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += tottenhamCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (tottenhamCompleto.get(i).getAwayTime().getName().equals("Tottenham")) {
                name = tottenhamCompleto.get(i).getAwayTime().getName();
                image = tottenhamCompleto.get(i).getAwayTime().getImage();
                if (tottenhamCompleto.get(i).getAwayTime().getScore() > tottenhamCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (tottenhamCompleto.get(i).getAwayTime().getScore() == tottenhamCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (tottenhamCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += tottenhamCompleto.get(i).getAwayTime().getScore();
                if (tottenhamCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += tottenhamCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if

        }//fim do for

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);//aqui modifiquei a variavel

        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;


        for (int i = 0; i < westHamCompleto.size(); i++) { //inicio do for
            if (westHamCompleto.get(i).getHomeTime().getName().equals("West Ham")) {
                name = westHamCompleto.get(i).getHomeTime().getName();
                image = westHamCompleto.get(i).getHomeTime().getImage();
                if (westHamCompleto.get(i).getHomeTime().getScore() > westHamCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (westHamCompleto.get(i).getHomeTime().getScore() == westHamCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (westHamCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += westHamCompleto.get(i).getHomeTime().getScore();
                if (westHamCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += westHamCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (westHamCompleto.get(i).getAwayTime().getName().equals("West Ham")) {
                name = westHamCompleto.get(i).getAwayTime().getName();
                image = westHamCompleto.get(i).getAwayTime().getImage();
                if (westHamCompleto.get(i).getAwayTime().getScore() > westHamCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (westHamCompleto.get(i).getAwayTime().getScore() == westHamCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (westHamCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += westHamCompleto.get(i).getAwayTime().getScore();
                if (westHamCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += westHamCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if

        }//fim do for

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);//aqui modifiquei a variavel

        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;


        for (int i = 0; i < wolvesCompleto.size(); i++) { //inicio do for
            if (wolvesCompleto.get(i).getHomeTime().getName().equals("Wolves")) {
                name = wolvesCompleto.get(i).getHomeTime().getName();
                image = wolvesCompleto.get(i).getHomeTime().getImage();
                if (wolvesCompleto.get(i).getHomeTime().getScore() > wolvesCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (wolvesCompleto.get(i).getHomeTime().getScore() == wolvesCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (wolvesCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += wolvesCompleto.get(i).getHomeTime().getScore();
                if (wolvesCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += wolvesCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (wolvesCompleto.get(i).getAwayTime().getName().equals("Wolves")) {
                name = wolvesCompleto.get(i).getAwayTime().getName();
                image = wolvesCompleto.get(i).getAwayTime().getImage();
                if (wolvesCompleto.get(i).getAwayTime().getScore() > wolvesCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (wolvesCompleto.get(i).getAwayTime().getScore() == wolvesCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (wolvesCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += wolvesCompleto.get(i).getAwayTime().getScore();
                if (wolvesCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += wolvesCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if

        }//fim do for


        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);//aqui modificamos a variavel listaOficial.. Essa variuavel nao esta vazia mais.// Só que pro adapter ela ainda esta vazia



        listaOficial.sort(new ComparatorPontosVitoriaSaldoGolsProSerieA_B());
        //Collections.sort(minhaLista);
        Collections.reverse(listaOficial);


        //Mas entenda que o código abaixo sempre vai atualizar a lista inteira
        timesClasificacaoBrasilA2024Adapter.notifyDataSetChanged();



    }//fim da interface
}