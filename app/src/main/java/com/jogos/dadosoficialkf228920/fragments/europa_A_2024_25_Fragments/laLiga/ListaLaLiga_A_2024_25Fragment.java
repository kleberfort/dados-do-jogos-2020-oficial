package com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.laLiga;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.activity.europa_A_2024_2025.laLiga.LaLiga2024_25Activity;
import com.jogos.dadosoficialkf228920.activity.europa_A_2024_2025.premierLeague.AstonVilla2024_25Activity;
import com.jogos.dadosoficialkf228920.adapter.brasil2024.TimesClasificacaoBrasilA2024Adapter;
import com.jogos.dadosoficialkf228920.databinding.FragmentListaLaLigaA202425Binding;
import com.jogos.dadosoficialkf228920.databinding.FragmentListaPremierLeagueA202425Binding;
import com.jogos.dadosoficialkf228920.databinding.FragmentListaPrimeiraLigaA202425Binding;
import com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.laLiga.util.JogosLaLiga_A_2024_2025_Listener;
import com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.laLiga.util.JogosLaLiga_A_2024_25;
import com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.premierLeague.util.JogosPremierLeague_A_2024_25;
import com.jogos.dadosoficialkf228920.model.ClassificacaoOficialNovoModelo;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;
import com.jogos.dadosoficialkf228920.model.RecyclerItemClickListener;
import com.jogos.dadosoficialkf228920.model.comparator.ComparatorPontosVitoriaSaldoGolsProSerieA_B;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ListaLaLiga_A_2024_25Fragment extends Fragment implements JogosLaLiga_A_2024_2025_Listener {

    private FragmentListaLaLigaA202425Binding binding;

    private JogosLaLiga_A_2024_25 jogosLaLigaA202425;
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

    List<PartidaNovoModelo> alavesCompleto = new ArrayList<>();
    List<PartidaNovoModelo> athleticClubCompleto = new ArrayList<>();
    List<PartidaNovoModelo> atlMadridCompleto = new ArrayList<>();
    List<PartidaNovoModelo> barcelonaCompleto = new ArrayList<>();
    List<PartidaNovoModelo> celtaCompleto = new ArrayList<>();
    List<PartidaNovoModelo> espanyolCompleto = new ArrayList<>();
    List<PartidaNovoModelo> getafeCompleto = new ArrayList<>();
    List<PartidaNovoModelo> gironaCompleto = new ArrayList<>();
    List<PartidaNovoModelo> lasPalmasCompleto = new ArrayList<>();
    List<PartidaNovoModelo> leganesCompleto = new ArrayList<>();
    List<PartidaNovoModelo> mallorcaCompleto = new ArrayList<>();
    List<PartidaNovoModelo> osasunaCompleto = new ArrayList<>();
    List<PartidaNovoModelo> rayoVallecanoCompleto = new ArrayList<>();
    List<PartidaNovoModelo> realBetisCompleto = new ArrayList<>();
    List<PartidaNovoModelo> realMadridCompleto = new ArrayList<>();
    List<PartidaNovoModelo> realSociedadCompleto = new ArrayList<>();
    List<PartidaNovoModelo> realValladolidCompleto = new ArrayList<>();
    List<PartidaNovoModelo> sevillaCompleto = new ArrayList<>();
    List<PartidaNovoModelo> valenciaCompleto = new ArrayList<>();
    List<PartidaNovoModelo> villarrealCompleto = new ArrayList<>();

    List<ClassificacaoOficialNovoModelo> listaOficial = new ArrayList<>(); ;//estamos iniciando nossa lista vazia


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentListaLaLigaA202425Binding.inflate(inflater, container, false);
        View view = binding.getRoot();




        jogosLaLigaA202425 = new JogosLaLiga_A_2024_25();
        jogosLaLigaA202425.setupHttpClient();
        jogosLaLigaA202425.setupDadosJogos();
        jogosLaLigaA202425.setListener(this);// Registra o fragmento como listener


        binding.rvLista.setHasFixedSize(true);
        binding.rvLista.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvLista.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        timesClasificacaoBrasilA2024Adapter = new TimesClasificacaoBrasilA2024Adapter(listaOficial);//o adapter vai receber a variazel listaOficial, mas ela esta vazia ainda
        binding.rvLista.setAdapter(timesClasificacaoBrasilA2024Adapter);





        binding.rvLista.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), binding.rvLista, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                ClassificacaoOficialNovoModelo lista = listaOficial.get(position);
                Intent intent = null;

                switch (lista.getName()){
                    case "Alavés":
                        intent = new Intent(getContext(), LaLiga2024_25Activity.class);
                        intent.putParcelableArrayListExtra("lista_partidas", new ArrayList<>(alavesCompleto));
                        break;
                }

                if (intent != null) {
                    startActivity(intent);
                }

            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));

            return view;

    }



    @Override
    public void onJogosLaLiga_A(List<PartidaNovoModelo> alavesCompleto, List<PartidaNovoModelo> athleticClubCompleto, List<PartidaNovoModelo> atlMadridCompleto, List<PartidaNovoModelo> barcelonaCompleto, List<PartidaNovoModelo> celtaCompleto, List<PartidaNovoModelo> espanyolCompleto, List<PartidaNovoModelo> getafeCompleto, List<PartidaNovoModelo> gironaCompleto, List<PartidaNovoModelo> lasPalmasCompleto, List<PartidaNovoModelo> leganesCompleto, List<PartidaNovoModelo> mallorcaCompleto, List<PartidaNovoModelo> osasunaCompleto, List<PartidaNovoModelo> rayoVallecanoCompleto, List<PartidaNovoModelo> realBetisCompleto, List<PartidaNovoModelo> realMadridCompleto, List<PartidaNovoModelo> realSociedadCompleto, List<PartidaNovoModelo> realValladolidCompleto, List<PartidaNovoModelo> sevillaCompleto, List<PartidaNovoModelo> valenciaCompleto, List<PartidaNovoModelo> villarrealCompleto) {
        this.alavesCompleto = alavesCompleto;
        this.athleticClubCompleto = athleticClubCompleto;
        this.atlMadridCompleto =  atlMadridCompleto;
        this.barcelonaCompleto = barcelonaCompleto;
        this.celtaCompleto = celtaCompleto;
        this.espanyolCompleto = espanyolCompleto;
        this.getafeCompleto = getafeCompleto;
        this.gironaCompleto = gironaCompleto;
        this. lasPalmasCompleto = lasPalmasCompleto;
        this.leganesCompleto = leganesCompleto;
        this.mallorcaCompleto = mallorcaCompleto;
        this.osasunaCompleto = osasunaCompleto;
        this.rayoVallecanoCompleto = rayoVallecanoCompleto;
        this.realBetisCompleto = realBetisCompleto;
        this.realMadridCompleto = realMadridCompleto;
        this.realSociedadCompleto = realSociedadCompleto;
        this.realValladolidCompleto = realValladolidCompleto;
        this.sevillaCompleto = sevillaCompleto;
        this.valenciaCompleto = valenciaCompleto;
        this.villarrealCompleto = villarrealCompleto;

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


        for (int i = 0; i < alavesCompleto.size(); i++) {
            if (alavesCompleto.get(i).getHomeTime().getName().equals("Alavés")) {
                name = alavesCompleto.get(i).getHomeTime().getName();
                image = alavesCompleto.get(i).getHomeTime().getImage();
                if (alavesCompleto.get(i).getHomeTime().getScore() > alavesCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (alavesCompleto.get(i).getHomeTime().getScore() == alavesCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (alavesCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += alavesCompleto.get(i).getHomeTime().getScore();
                if (alavesCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += alavesCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (alavesCompleto.get(i).getAwayTime().getName().equals("Alavés")) {
                name = alavesCompleto.get(i).getAwayTime().getName();
                image = alavesCompleto.get(i).getAwayTime().getImage();
                if (alavesCompleto.get(i).getAwayTime().getScore() > alavesCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (alavesCompleto.get(i).getAwayTime().getScore() == alavesCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (alavesCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += alavesCompleto.get(i).getAwayTime().getScore();
                if (alavesCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += alavesCompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < athleticClubCompleto.size(); i++) {
            if (athleticClubCompleto.get(i).getHomeTime().getName().equals("Athletic Club")) {
                name = athleticClubCompleto.get(i).getHomeTime().getName();
                image = athleticClubCompleto.get(i).getHomeTime().getImage();
                if (athleticClubCompleto.get(i).getHomeTime().getScore() > athleticClubCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (athleticClubCompleto.get(i).getHomeTime().getScore() == athleticClubCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (athleticClubCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += athleticClubCompleto.get(i).getHomeTime().getScore();
                if (athleticClubCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += athleticClubCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (athleticClubCompleto.get(i).getAwayTime().getName().equals("Athletic Club")) {
                name = athleticClubCompleto.get(i).getAwayTime().getName();
                image = athleticClubCompleto.get(i).getAwayTime().getImage();
                if (athleticClubCompleto.get(i).getAwayTime().getScore() > athleticClubCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (athleticClubCompleto.get(i).getAwayTime().getScore() == athleticClubCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (athleticClubCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += athleticClubCompleto.get(i).getAwayTime().getScore();
                if (athleticClubCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += athleticClubCompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < atlMadridCompleto.size(); i++) {
            if (atlMadridCompleto.get(i).getHomeTime().getName().equals("Atl. Madrid")) {
                name = atlMadridCompleto.get(i).getHomeTime().getName();
                image = atlMadridCompleto.get(i).getHomeTime().getImage();
                if (atlMadridCompleto.get(i).getHomeTime().getScore() > atlMadridCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (atlMadridCompleto.get(i).getHomeTime().getScore() == atlMadridCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (atlMadridCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += atlMadridCompleto.get(i).getHomeTime().getScore();
                if (atlMadridCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += atlMadridCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (atlMadridCompleto.get(i).getAwayTime().getName().equals("Atl. Madrid")) {
                name = atlMadridCompleto.get(i).getAwayTime().getName();
                image = atlMadridCompleto.get(i).getAwayTime().getImage();
                if (atlMadridCompleto.get(i).getAwayTime().getScore() > atlMadridCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (atlMadridCompleto.get(i).getAwayTime().getScore() == atlMadridCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (atlMadridCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += atlMadridCompleto.get(i).getAwayTime().getScore();
                if (atlMadridCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += atlMadridCompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < barcelonaCompleto.size(); i++) {
            if (barcelonaCompleto.get(i).getHomeTime().getName().equals("Barcelona")) {
                name = barcelonaCompleto.get(i).getHomeTime().getName();
                image = barcelonaCompleto.get(i).getHomeTime().getImage();
                if (barcelonaCompleto.get(i).getHomeTime().getScore() > barcelonaCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (barcelonaCompleto.get(i).getHomeTime().getScore() == barcelonaCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (barcelonaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += barcelonaCompleto.get(i).getHomeTime().getScore();
                if (barcelonaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += barcelonaCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (barcelonaCompleto.get(i).getAwayTime().getName().equals("Barcelona")) {
                name = barcelonaCompleto.get(i).getAwayTime().getName();
                image = barcelonaCompleto.get(i).getAwayTime().getImage();
                if (barcelonaCompleto.get(i).getAwayTime().getScore() > barcelonaCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (barcelonaCompleto.get(i).getAwayTime().getScore() == barcelonaCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (barcelonaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += barcelonaCompleto.get(i).getAwayTime().getScore();
                if (barcelonaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += barcelonaCompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < celtaCompleto.size(); i++) {
            if (celtaCompleto.get(i).getHomeTime().getName().equals("Celta")) {
                name = celtaCompleto.get(i).getHomeTime().getName();
                image = celtaCompleto.get(i).getHomeTime().getImage();
                if (celtaCompleto.get(i).getHomeTime().getScore() > celtaCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (celtaCompleto.get(i).getHomeTime().getScore() == celtaCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (celtaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += celtaCompleto.get(i).getHomeTime().getScore();
                if (celtaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += celtaCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (celtaCompleto.get(i).getAwayTime().getName().equals("Celta")) {
                name = celtaCompleto.get(i).getAwayTime().getName();
                image = celtaCompleto.get(i).getAwayTime().getImage();
                if (celtaCompleto.get(i).getAwayTime().getScore() > celtaCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (celtaCompleto.get(i).getAwayTime().getScore() == celtaCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (celtaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += celtaCompleto.get(i).getAwayTime().getScore();
                if (celtaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += celtaCompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < espanyolCompleto.size(); i++) {
            if (espanyolCompleto.get(i).getHomeTime().getName().equals("Espanyol")) {
                name = espanyolCompleto.get(i).getHomeTime().getName();
                image = espanyolCompleto.get(i).getHomeTime().getImage();
                if (espanyolCompleto.get(i).getHomeTime().getScore() > espanyolCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (espanyolCompleto.get(i).getHomeTime().getScore() == espanyolCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (espanyolCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += espanyolCompleto.get(i).getHomeTime().getScore();
                if (espanyolCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += espanyolCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (espanyolCompleto.get(i).getAwayTime().getName().equals("Espanyol")) {
                name = espanyolCompleto.get(i).getAwayTime().getName();
                image = espanyolCompleto.get(i).getAwayTime().getImage();
                if (espanyolCompleto.get(i).getAwayTime().getScore() > espanyolCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (espanyolCompleto.get(i).getAwayTime().getScore() == espanyolCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (espanyolCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += espanyolCompleto.get(i).getAwayTime().getScore();
                if (espanyolCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += espanyolCompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < getafeCompleto.size(); i++) {
            if (getafeCompleto.get(i).getHomeTime().getName().equals("Getafe")) {
                name = getafeCompleto.get(i).getHomeTime().getName();
                image = getafeCompleto.get(i).getHomeTime().getImage();
                if (getafeCompleto.get(i).getHomeTime().getScore() > getafeCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (getafeCompleto.get(i).getHomeTime().getScore() == getafeCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (getafeCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += getafeCompleto.get(i).getHomeTime().getScore();
                if (getafeCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += getafeCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (getafeCompleto.get(i).getAwayTime().getName().equals("Getafe")) {
                name = getafeCompleto.get(i).getAwayTime().getName();
                image = getafeCompleto.get(i).getAwayTime().getImage();
                if (getafeCompleto.get(i).getAwayTime().getScore() > getafeCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (getafeCompleto.get(i).getAwayTime().getScore() == getafeCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (getafeCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += getafeCompleto.get(i).getAwayTime().getScore();
                if (getafeCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += getafeCompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < gironaCompleto.size(); i++) {
            if (gironaCompleto.get(i).getHomeTime().getName().equals("Girona")) {
                name = gironaCompleto.get(i).getHomeTime().getName();
                image = gironaCompleto.get(i).getHomeTime().getImage();
                if (gironaCompleto.get(i).getHomeTime().getScore() > gironaCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (gironaCompleto.get(i).getHomeTime().getScore() == gironaCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (gironaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += gironaCompleto.get(i).getHomeTime().getScore();
                if (gironaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += gironaCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (gironaCompleto.get(i).getAwayTime().getName().equals("Girona")) {
                name = gironaCompleto.get(i).getAwayTime().getName();
                image = gironaCompleto.get(i).getAwayTime().getImage();
                if (gironaCompleto.get(i).getAwayTime().getScore() > gironaCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (gironaCompleto.get(i).getAwayTime().getScore() == gironaCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (gironaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += gironaCompleto.get(i).getAwayTime().getScore();
                if (gironaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += gironaCompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < lasPalmasCompleto.size(); i++) {
            if (lasPalmasCompleto.get(i).getHomeTime().getName().equals("Las Palmas")) {
                name = lasPalmasCompleto.get(i).getHomeTime().getName();
                image = lasPalmasCompleto.get(i).getHomeTime().getImage();
                if (lasPalmasCompleto.get(i).getHomeTime().getScore() > lasPalmasCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (lasPalmasCompleto.get(i).getHomeTime().getScore() == lasPalmasCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (lasPalmasCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += lasPalmasCompleto.get(i).getHomeTime().getScore();
                if (lasPalmasCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += lasPalmasCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (lasPalmasCompleto.get(i).getAwayTime().getName().equals("Las Palmas")) {
                name = lasPalmasCompleto.get(i).getAwayTime().getName();
                image = lasPalmasCompleto.get(i).getAwayTime().getImage();
                if (lasPalmasCompleto.get(i).getAwayTime().getScore() > lasPalmasCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (lasPalmasCompleto.get(i).getAwayTime().getScore() == lasPalmasCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (lasPalmasCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += lasPalmasCompleto.get(i).getAwayTime().getScore();
                if (lasPalmasCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += lasPalmasCompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < leganesCompleto.size(); i++) {
            if (leganesCompleto.get(i).getHomeTime().getName().equals("Leganés")) {
                name = leganesCompleto.get(i).getHomeTime().getName();
                image = leganesCompleto.get(i).getHomeTime().getImage();
                if (leganesCompleto.get(i).getHomeTime().getScore() > leganesCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (leganesCompleto.get(i).getHomeTime().getScore() == leganesCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (leganesCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += leganesCompleto.get(i).getHomeTime().getScore();
                if (leganesCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += leganesCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (leganesCompleto.get(i).getAwayTime().getName().equals("Leganés")) {
                name = leganesCompleto.get(i).getAwayTime().getName();
                image = leganesCompleto.get(i).getAwayTime().getImage();
                if (leganesCompleto.get(i).getAwayTime().getScore() > leganesCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (leganesCompleto.get(i).getAwayTime().getScore() == leganesCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (leganesCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += leganesCompleto.get(i).getAwayTime().getScore();
                if (leganesCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += leganesCompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < mallorcaCompleto.size(); i++) {
            if (mallorcaCompleto.get(i).getHomeTime().getName().equals("Mallorca")) {
                name = mallorcaCompleto.get(i).getHomeTime().getName();
                image = mallorcaCompleto.get(i).getHomeTime().getImage();
                if (mallorcaCompleto.get(i).getHomeTime().getScore() > mallorcaCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (mallorcaCompleto.get(i).getHomeTime().getScore() == mallorcaCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (mallorcaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += mallorcaCompleto.get(i).getHomeTime().getScore();
                if (mallorcaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += mallorcaCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (mallorcaCompleto.get(i).getAwayTime().getName().equals("Mallorca")) {
                name = mallorcaCompleto.get(i).getAwayTime().getName();
                image = mallorcaCompleto.get(i).getAwayTime().getImage();
                if (mallorcaCompleto.get(i).getAwayTime().getScore() > mallorcaCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (mallorcaCompleto.get(i).getAwayTime().getScore() == mallorcaCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (mallorcaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += mallorcaCompleto.get(i).getAwayTime().getScore();
                if (mallorcaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += mallorcaCompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < osasunaCompleto.size(); i++) {
            if (osasunaCompleto.get(i).getHomeTime().getName().equals("Osasuna")) {
                name = osasunaCompleto.get(i).getHomeTime().getName();
                image = osasunaCompleto.get(i).getHomeTime().getImage();
                if (osasunaCompleto.get(i).getHomeTime().getScore() > osasunaCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (osasunaCompleto.get(i).getHomeTime().getScore() == osasunaCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (osasunaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += osasunaCompleto.get(i).getHomeTime().getScore();
                if (osasunaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += osasunaCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (osasunaCompleto.get(i).getAwayTime().getName().equals("Osasuna")) {
                name = osasunaCompleto.get(i).getAwayTime().getName();
                image = osasunaCompleto.get(i).getAwayTime().getImage();
                if (osasunaCompleto.get(i).getAwayTime().getScore() > osasunaCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (osasunaCompleto.get(i).getAwayTime().getScore() == osasunaCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (osasunaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += osasunaCompleto.get(i).getAwayTime().getScore();
                if (osasunaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += osasunaCompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < rayoVallecanoCompleto.size(); i++) {
            if (rayoVallecanoCompleto.get(i).getHomeTime().getName().equals("Rayo Vallecano")) {
                name = rayoVallecanoCompleto.get(i).getHomeTime().getName();
                image = rayoVallecanoCompleto.get(i).getHomeTime().getImage();
                if (rayoVallecanoCompleto.get(i).getHomeTime().getScore() > rayoVallecanoCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (rayoVallecanoCompleto.get(i).getHomeTime().getScore() == rayoVallecanoCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (rayoVallecanoCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += rayoVallecanoCompleto.get(i).getHomeTime().getScore();
                if (rayoVallecanoCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += rayoVallecanoCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (rayoVallecanoCompleto.get(i).getAwayTime().getName().equals("Rayo Vallecano")) {
                name = rayoVallecanoCompleto.get(i).getAwayTime().getName();
                image = rayoVallecanoCompleto.get(i).getAwayTime().getImage();
                if (rayoVallecanoCompleto.get(i).getAwayTime().getScore() > rayoVallecanoCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (rayoVallecanoCompleto.get(i).getAwayTime().getScore() == rayoVallecanoCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (rayoVallecanoCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += rayoVallecanoCompleto.get(i).getAwayTime().getScore();
                if (rayoVallecanoCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += rayoVallecanoCompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < realBetisCompleto.size(); i++) {
            if (realBetisCompleto.get(i).getHomeTime().getName().equals("Real Betis")) {
                name = realBetisCompleto.get(i).getHomeTime().getName();
                image = realBetisCompleto.get(i).getHomeTime().getImage();
                if (realBetisCompleto.get(i).getHomeTime().getScore() > realBetisCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (realBetisCompleto.get(i).getHomeTime().getScore() == realBetisCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (realBetisCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += realBetisCompleto.get(i).getHomeTime().getScore();
                if (realBetisCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += realBetisCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (realBetisCompleto.get(i).getAwayTime().getName().equals("Real Betis")) {
                name = realBetisCompleto.get(i).getAwayTime().getName();
                image = realBetisCompleto.get(i).getAwayTime().getImage();
                if (realBetisCompleto.get(i).getAwayTime().getScore() > realBetisCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (realBetisCompleto.get(i).getAwayTime().getScore() == realBetisCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (realBetisCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += realBetisCompleto.get(i).getAwayTime().getScore();
                if (realBetisCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += realBetisCompleto.get(i).getHomeTime().getScore();
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


        for (int i = 0; i < realMadridCompleto.size(); i++) {
            if (realMadridCompleto.get(i).getHomeTime().getName().equals("Real Madrid")) {
                name = realMadridCompleto.get(i).getHomeTime().getName();
                image = realMadridCompleto.get(i).getHomeTime().getImage();
                if (realMadridCompleto.get(i).getHomeTime().getScore() > realMadridCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (realMadridCompleto.get(i).getHomeTime().getScore() == realMadridCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (realMadridCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += realMadridCompleto.get(i).getHomeTime().getScore();
                if (realMadridCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += realMadridCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (realMadridCompleto.get(i).getAwayTime().getName().equals("Real Madrid")) {
                name = realMadridCompleto.get(i).getAwayTime().getName();
                image = realMadridCompleto.get(i).getAwayTime().getImage();
                if (realMadridCompleto.get(i).getAwayTime().getScore() > realMadridCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (realMadridCompleto.get(i).getAwayTime().getScore() == realMadridCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (realMadridCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += realMadridCompleto.get(i).getAwayTime().getScore();
                if (realMadridCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += realMadridCompleto.get(i).getHomeTime().getScore();
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


        for (int i = 0; i < realSociedadCompleto.size(); i++) {
            if (realSociedadCompleto.get(i).getHomeTime().getName().equals("Real Sociedad")) {
                name = realSociedadCompleto.get(i).getHomeTime().getName();
                image = realSociedadCompleto.get(i).getHomeTime().getImage();
                if (realSociedadCompleto.get(i).getHomeTime().getScore() > realSociedadCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (realSociedadCompleto.get(i).getHomeTime().getScore() == realSociedadCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (realSociedadCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += realSociedadCompleto.get(i).getHomeTime().getScore();
                if (realSociedadCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += realSociedadCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (realSociedadCompleto.get(i).getAwayTime().getName().equals("Real Sociedad")) {
                name = realSociedadCompleto.get(i).getAwayTime().getName();
                image = realSociedadCompleto.get(i).getAwayTime().getImage();
                if (realSociedadCompleto.get(i).getAwayTime().getScore() > realSociedadCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (realSociedadCompleto.get(i).getAwayTime().getScore() == realSociedadCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (realSociedadCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += realSociedadCompleto.get(i).getAwayTime().getScore();
                if (realSociedadCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += realSociedadCompleto.get(i).getHomeTime().getScore();
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


        for (int i = 0; i < realValladolidCompleto.size(); i++) {
            if (realValladolidCompleto.get(i).getHomeTime().getName().equals("Real Valladolid")) {
                name = realValladolidCompleto.get(i).getHomeTime().getName();
                image = realValladolidCompleto.get(i).getHomeTime().getImage();
                if (realValladolidCompleto.get(i).getHomeTime().getScore() > realValladolidCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (realValladolidCompleto.get(i).getHomeTime().getScore() == realValladolidCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (realValladolidCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += realValladolidCompleto.get(i).getHomeTime().getScore();
                if (realValladolidCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += realValladolidCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (realValladolidCompleto.get(i).getAwayTime().getName().equals("Real Valladolid")) {
                name = realValladolidCompleto.get(i).getAwayTime().getName();
                image = realValladolidCompleto.get(i).getAwayTime().getImage();
                if (realValladolidCompleto.get(i).getAwayTime().getScore() > realValladolidCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (realValladolidCompleto.get(i).getAwayTime().getScore() == realValladolidCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (realValladolidCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += realValladolidCompleto.get(i).getAwayTime().getScore();
                if (realValladolidCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += realValladolidCompleto.get(i).getHomeTime().getScore();
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


        for (int i = 0; i < sevillaCompleto.size(); i++) { //inicio do for
            if (sevillaCompleto.get(i).getHomeTime().getName().equals("Sevilla")) {
                name = sevillaCompleto.get(i).getHomeTime().getName();
                image = sevillaCompleto.get(i).getHomeTime().getImage();
                if (sevillaCompleto.get(i).getHomeTime().getScore() > sevillaCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (sevillaCompleto.get(i).getHomeTime().getScore() == sevillaCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (sevillaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += sevillaCompleto.get(i).getHomeTime().getScore();
                if (sevillaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += sevillaCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (sevillaCompleto.get(i).getAwayTime().getName().equals("Sevilla")) {
                name = sevillaCompleto.get(i).getAwayTime().getName();
                image = sevillaCompleto.get(i).getAwayTime().getImage();
                if (sevillaCompleto.get(i).getAwayTime().getScore() > sevillaCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (sevillaCompleto.get(i).getAwayTime().getScore() == sevillaCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (sevillaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += sevillaCompleto.get(i).getAwayTime().getScore();
                if (sevillaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += sevillaCompleto.get(i).getHomeTime().getScore();
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


        for (int i = 0; i < valenciaCompleto.size(); i++) { //inicio do for
            if (valenciaCompleto.get(i).getHomeTime().getName().equals("Valencia")) {
                name = valenciaCompleto.get(i).getHomeTime().getName();
                image = valenciaCompleto.get(i).getHomeTime().getImage();
                if (valenciaCompleto.get(i).getHomeTime().getScore() > valenciaCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (valenciaCompleto.get(i).getHomeTime().getScore() == valenciaCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (valenciaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += valenciaCompleto.get(i).getHomeTime().getScore();
                if (valenciaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += valenciaCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (valenciaCompleto.get(i).getAwayTime().getName().equals("Valencia")) {
                name = valenciaCompleto.get(i).getAwayTime().getName();
                image = valenciaCompleto.get(i).getAwayTime().getImage();
                if (valenciaCompleto.get(i).getAwayTime().getScore() > valenciaCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (valenciaCompleto.get(i).getAwayTime().getScore() == valenciaCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (valenciaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += valenciaCompleto.get(i).getAwayTime().getScore();
                if (valenciaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += valenciaCompleto.get(i).getHomeTime().getScore();
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


        for (int i = 0; i < villarrealCompleto.size(); i++) { //inicio do for
            if (villarrealCompleto.get(i).getHomeTime().getName().equals("Villarreal")) {
                name = villarrealCompleto.get(i).getHomeTime().getName();
                image = villarrealCompleto.get(i).getHomeTime().getImage();
                if (villarrealCompleto.get(i).getHomeTime().getScore() > villarrealCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (villarrealCompleto.get(i).getHomeTime().getScore() == villarrealCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (villarrealCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += villarrealCompleto.get(i).getHomeTime().getScore();
                if (villarrealCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += villarrealCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (villarrealCompleto.get(i).getAwayTime().getName().equals("Villarreal")) {
                name = villarrealCompleto.get(i).getAwayTime().getName();
                image = villarrealCompleto.get(i).getAwayTime().getImage();
                if (villarrealCompleto.get(i).getAwayTime().getScore() > villarrealCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (villarrealCompleto.get(i).getAwayTime().getScore() == villarrealCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (villarrealCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += villarrealCompleto.get(i).getAwayTime().getScore();
                if (villarrealCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += villarrealCompleto.get(i).getHomeTime().getScore();
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