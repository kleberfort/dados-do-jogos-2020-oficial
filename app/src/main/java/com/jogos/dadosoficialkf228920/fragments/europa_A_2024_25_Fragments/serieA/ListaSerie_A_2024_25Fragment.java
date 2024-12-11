package com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.serieA;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.adapter.brasil2024.TimesClasificacaoBrasilA2024Adapter;
import com.jogos.dadosoficialkf228920.databinding.FragmentListaLaLigaA202425Binding;
import com.jogos.dadosoficialkf228920.databinding.FragmentListaSerieA202425Binding;
import com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.serieA.util.JogosSerieAItalia2024_2025_Listener;
import com.jogos.dadosoficialkf228920.model.ClassificacaoOficialNovoModelo;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;
import com.jogos.dadosoficialkf228920.model.comparator.ComparatorPontosVitoriaSaldoGolsProSerieA_B;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ListaSerie_A_2024_25Fragment extends Fragment  implements JogosSerieAItalia2024_2025_Listener {

    private FragmentListaSerieA202425Binding binding;

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

    private List<PartidaNovoModelo> atalantaCasa = new ArrayList<>();
    private List<PartidaNovoModelo> atalantaFora = new ArrayList<>();

    private List<PartidaNovoModelo> bolognaCasa = new ArrayList<>();
    private List<PartidaNovoModelo> bolognaFora = new ArrayList<>();

    private List<PartidaNovoModelo> cagliariCasa = new ArrayList<>();
    private List<PartidaNovoModelo> cagliariFora = new ArrayList<>();


    private List<PartidaNovoModelo> comoCasa = new ArrayList<>();
    private List<PartidaNovoModelo> comoFora = new ArrayList<>();

    private List<PartidaNovoModelo> empoliCasa = new ArrayList<>();
    private List<PartidaNovoModelo> empoliFora = new ArrayList<>();

    private List<PartidaNovoModelo> fiorentinaCasa = new ArrayList<>();
    private List<PartidaNovoModelo> fiorentinaFora = new ArrayList<>();

    private List<PartidaNovoModelo> genoaCasa = new ArrayList<>();
    private List<PartidaNovoModelo> genoaFora = new ArrayList<>();

    private List<PartidaNovoModelo> interCasa = new ArrayList<>();
    private List<PartidaNovoModelo> interFora = new ArrayList<>();

    private List<PartidaNovoModelo> juventusCasa = new ArrayList<>();
    private List<PartidaNovoModelo> juventusFora = new ArrayList<>();

    private List<PartidaNovoModelo> lazioCasa = new ArrayList<>();
    private List<PartidaNovoModelo> lazioFora = new ArrayList<>();

    private List<PartidaNovoModelo> lecceCasa = new ArrayList<>();
    private List<PartidaNovoModelo> lecceFora = new ArrayList<>();

    private List<PartidaNovoModelo> milanCasa = new ArrayList<>();
    private List<PartidaNovoModelo> milanFora = new ArrayList<>();

    private List<PartidaNovoModelo> monzaCasa = new ArrayList<>();
    private List<PartidaNovoModelo> monzaFora = new ArrayList<>();
    private List<PartidaNovoModelo> napoliCasa = new ArrayList<>();
    private List<PartidaNovoModelo> napoliFora = new ArrayList<>();

    private List<PartidaNovoModelo> parmaCasa = new ArrayList<>();
    private List<PartidaNovoModelo> parmaFora = new ArrayList<>();

    private List<PartidaNovoModelo> romaCasa = new ArrayList<>();
    private List<PartidaNovoModelo> romaFora = new ArrayList<>();
    private List<PartidaNovoModelo> torinoCasa = new ArrayList<>();
    private List<PartidaNovoModelo> torinoFora = new ArrayList<>();

    private List<PartidaNovoModelo> udineseCasa = new ArrayList<>();
    private List<PartidaNovoModelo> udineseFora = new ArrayList<>();

    private List<PartidaNovoModelo> veneziaCasa = new ArrayList<>();
    private List<PartidaNovoModelo> veneziaFora = new ArrayList<>();

    private List<PartidaNovoModelo> veronaCasa = new ArrayList<>();
    private List<PartidaNovoModelo> veronaFora = new ArrayList<>();


    List<ClassificacaoOficialNovoModelo> listaOficial = new ArrayList<>(); ;//estamos iniciando nossa lista vazia

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentListaSerieA202425Binding.inflate(inflater, container, false);
        View view = binding.getRoot();

        return view;

    }

    @Override
    public void onJogosSerieAItalia_2024_25(List<PartidaNovoModelo> allMatchsSerieACompleto) {

        for (PartidaNovoModelo partida : allMatchsSerieACompleto) {

            if (partida.getHomeTime().getName().equals("Atalanta")) {
                partida.setDataFormatada(partida.getDate());
                atalantaCasa.add(partida);
            }
            if (partida.getAwayTime().getName().equals("Atalanta")) {
                partida.setDataFormatada(partida.getDate());
                atalantaFora.add(partida);
                //Log.i("Data" ,"Data da partida " + partida.getDate());
                //Log.i("Partida", "partida arsenal fora " + partida.getDataFormatada());
            }

            if (partida.getHomeTime().getName().equals("Bologna")) {
                partida.setDataFormatada(partida.getDate());
                bolognaCasa.add(partida);
            }
            if (partida.getAwayTime().getName().equals("Bologna")) {
                partida.setDataFormatada(partida.getDate());
                bolognaFora.add(partida);
            }

            if (partida.getHomeTime().getName().equals("Cagliari")) {
                partida.setDataFormatada(partida.getDate());
                cagliariCasa.add(partida);
            }
            if (partida.getAwayTime().getName().equals("Cagliari")) {
                partida.setDataFormatada(partida.getDate());
                cagliariFora.add(partida);
            }

            if (partida.getHomeTime().getName().equals("Como")) {
                partida.setDataFormatada(partida.getDate());
                comoCasa.add(partida);
            }
            if (partida.getAwayTime().getName().equals("Como")) {
                partida.setDataFormatada(partida.getDate());
                comoFora.add(partida);
            }

            if (partida.getHomeTime().getName().equals("Empoli")) {
                partida.setDataFormatada(partida.getDate());
                empoliCasa.add(partida);
            }
            if (partida.getAwayTime().getName().equals("Empoli")) {
                partida.setDataFormatada(partida.getDate());
                empoliFora.add(partida);
            }

            if (partida.getHomeTime().getName().equals("Fiorentina")) {
                partida.setDataFormatada(partida.getDate());
                fiorentinaCasa.add(partida);
            }
            if (partida.getAwayTime().getName().equals("Fiorentina")) {
                partida.setDataFormatada(partida.getDate());
                fiorentinaFora.add(partida);
            }

            if (partida.getHomeTime().getName().equals("Genoa")) {
                partida.setDataFormatada(partida.getDate());
                genoaCasa.add(partida);
            }
            if (partida.getAwayTime().getName().equals("Genoa")) {
                partida.setDataFormatada(partida.getDate());
                genoaFora.add(partida);
            }

            if (partida.getHomeTime().getName().equals("Inter")) {
                partida.setDataFormatada(partida.getDate());
                interCasa.add(partida);
            }
            if (partida.getAwayTime().getName().equals("Inter")) {
                partida.setDataFormatada(partida.getDate());
                interFora.add(partida);
            }

            if (partida.getHomeTime().getName().equals("Juventus")) {
                partida.setDataFormatada(partida.getDate());
                juventusCasa.add(partida);
            }
            if (partida.getAwayTime().getName().equals("Juventus")) {
                partida.setDataFormatada(partida.getDate());
                juventusFora.add(partida);
            }

            if (partida.getHomeTime().getName().equals("Lazio")) {
                partida.setDataFormatada(partida.getDate());
                lazioCasa.add(partida);
            }
            if (partida.getAwayTime().getName().equals("Lazio")) {
                partida.setDataFormatada(partida.getDate());
                lazioFora.add(partida);
            }

            if (partida.getHomeTime().getName().equals("Lecce")) {
                partida.setDataFormatada(partida.getDate());
                lecceCasa.add(partida);
            }
            if (partida.getAwayTime().getName().equals("Lecce")) {
                partida.setDataFormatada(partida.getDate());
                lecceFora.add(partida);
            }

            if (partida.getHomeTime().getName().equals("Milan")) {
                partida.setDataFormatada(partida.getDate());
                milanCasa.add(partida);
            }
            if (partida.getAwayTime().getName().equals("Milan")) {
                partida.setDataFormatada(partida.getDate());
                milanFora.add(partida);
            }
            if (partida.getHomeTime().getName().equals("Monza")) {
                partida.setDataFormatada(partida.getDate());
                monzaCasa.add(partida);
            }
            if (partida.getAwayTime().getName().equals("Monza")) {
                partida.setDataFormatada(partida.getDate());
                monzaFora.add(partida);
            }

            if (partida.getHomeTime().getName().equals("Napoli")) {
                partida.setDataFormatada(partida.getDate());
                napoliCasa.add(partida);
            }
            if (partida.getAwayTime().getName().equals("Napoli")) {
                partida.setDataFormatada(partida.getDate());
                napoliFora.add(partida);
            }

            if (partida.getHomeTime().getName().equals("Parma")) {
                partida.setDataFormatada(partida.getDate());
                parmaCasa.add(partida);
            }
            if (partida.getAwayTime().getName().equals("Parma")) {
                partida.setDataFormatada(partida.getDate());
                parmaFora.add(partida);
            }

            if (partida.getHomeTime().getName().equals("Roma")) {
                partida.setDataFormatada(partida.getDate());
                romaCasa.add(partida);
            }
            if (partida.getAwayTime().getName().equals("Roma")) {
                partida.setDataFormatada(partida.getDate());
                romaFora.add(partida);
            }

            if (partida.getHomeTime().getName().equals("Torino")) {
                partida.setDataFormatada(partida.getDate());
                torinoCasa.add(partida);
            }
            if (partida.getAwayTime().getName().equals("Torino")) {
                partida.setDataFormatada(partida.getDate());
                torinoFora.add(partida);
            }

            if (partida.getHomeTime().getName().equals("Udinese")) {
                partida.setDataFormatada(partida.getDate());
                udineseCasa.add(partida);
            }
            if (partida.getAwayTime().getName().equals("Udinese")) {
                partida.setDataFormatada(partida.getDate());
                udineseFora.add(partida);
            }

            if (partida.getHomeTime().getName().equals("Venezia")) {
                partida.setDataFormatada(partida.getDate());
                veneziaCasa.add(partida);
            }
            if (partida.getAwayTime().getName().equals("Venezia")) {
                partida.setDataFormatada(partida.getDate());
                veneziaFora.add(partida);
            }

            if (partida.getHomeTime().getName().equals("Verona")) {
                partida.setDataFormatada(partida.getDate());
                veronaCasa.add(partida);
            }
            if (partida.getAwayTime().getName().equals("Verona")) {
                partida.setDataFormatada(partida.getDate());
                veronaFora.add(partida);
            }

        }//fim do for

        Log.d("Partidas Serie A", "Partidas " + allMatchsSerieACompleto);

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


        for (int i = 0; i < allMatchsSerieACompleto.size(); i++) {
            if (allMatchsSerieACompleto.get(i).getHomeTime().getName().equals("Atalanta")) {
                name = allMatchsSerieACompleto.get(i).getHomeTime().getName();
                image = allMatchsSerieACompleto.get(i).getHomeTime().getImage();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() == allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (allMatchsSerieACompleto.get(i).getAwayTime().getName().equals("Atalanta")) {
                name = allMatchsSerieACompleto.get(i).getAwayTime().getName();
                image = allMatchsSerieACompleto.get(i).getAwayTime().getImage();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() == allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < allMatchsSerieACompleto.size(); i++) {
            if (allMatchsSerieACompleto.get(i).getHomeTime().getName().equals("Bologna")) {
                name = allMatchsSerieACompleto.get(i).getHomeTime().getName();
                image = allMatchsSerieACompleto.get(i).getHomeTime().getImage();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() == allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (allMatchsSerieACompleto.get(i).getAwayTime().getName().equals("Bologna")) {
                name = allMatchsSerieACompleto.get(i).getAwayTime().getName();
                image = allMatchsSerieACompleto.get(i).getAwayTime().getImage();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() == allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < allMatchsSerieACompleto.size(); i++) {
            if (allMatchsSerieACompleto.get(i).getHomeTime().getName().equals("Cagliari")) {
                name = allMatchsSerieACompleto.get(i).getHomeTime().getName();
                image = allMatchsSerieACompleto.get(i).getHomeTime().getImage();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() == allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (allMatchsSerieACompleto.get(i).getAwayTime().getName().equals("Cagliari")) {
                name = allMatchsSerieACompleto.get(i).getAwayTime().getName();
                image = allMatchsSerieACompleto.get(i).getAwayTime().getImage();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() == allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < allMatchsSerieACompleto.size(); i++) {
            if (allMatchsSerieACompleto.get(i).getHomeTime().getName().equals("Como")) {
                name = allMatchsSerieACompleto.get(i).getHomeTime().getName();
                image = allMatchsSerieACompleto.get(i).getHomeTime().getImage();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() == allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (allMatchsSerieACompleto.get(i).getAwayTime().getName().equals("Como")) {
                name = allMatchsSerieACompleto.get(i).getAwayTime().getName();
                image = allMatchsSerieACompleto.get(i).getAwayTime().getImage();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() == allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < allMatchsSerieACompleto.size(); i++) {
            if (allMatchsSerieACompleto.get(i).getHomeTime().getName().equals("Empoli")) {
                name = allMatchsSerieACompleto.get(i).getHomeTime().getName();
                image = allMatchsSerieACompleto.get(i).getHomeTime().getImage();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() == allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (allMatchsSerieACompleto.get(i).getAwayTime().getName().equals("Empoli")) {
                name = allMatchsSerieACompleto.get(i).getAwayTime().getName();
                image = allMatchsSerieACompleto.get(i).getAwayTime().getImage();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() == allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < allMatchsSerieACompleto.size(); i++) {
            if (allMatchsSerieACompleto.get(i).getHomeTime().getName().equals("Fiorentina")) {
                name = allMatchsSerieACompleto.get(i).getHomeTime().getName();
                image = allMatchsSerieACompleto.get(i).getHomeTime().getImage();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() == allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (allMatchsSerieACompleto.get(i).getAwayTime().getName().equals("Fiorentina")) {
                name = allMatchsSerieACompleto.get(i).getAwayTime().getName();
                image = allMatchsSerieACompleto.get(i).getAwayTime().getImage();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() == allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < allMatchsSerieACompleto.size(); i++) {
            if (allMatchsSerieACompleto.get(i).getHomeTime().getName().equals("Genoa")) {
                name = allMatchsSerieACompleto.get(i).getHomeTime().getName();
                image = allMatchsSerieACompleto.get(i).getHomeTime().getImage();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() == allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (allMatchsSerieACompleto.get(i).getAwayTime().getName().equals("Genoa")) {
                name = allMatchsSerieACompleto.get(i).getAwayTime().getName();
                image = allMatchsSerieACompleto.get(i).getAwayTime().getImage();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() == allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < allMatchsSerieACompleto.size(); i++) {
            if (allMatchsSerieACompleto.get(i).getHomeTime().getName().equals("Inter")) {
                name = allMatchsSerieACompleto.get(i).getHomeTime().getName();
                image = allMatchsSerieACompleto.get(i).getHomeTime().getImage();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() == allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (allMatchsSerieACompleto.get(i).getAwayTime().getName().equals("Inter")) {
                name = allMatchsSerieACompleto.get(i).getAwayTime().getName();
                image = allMatchsSerieACompleto.get(i).getAwayTime().getImage();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() == allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < allMatchsSerieACompleto.size(); i++) {
            if (allMatchsSerieACompleto.get(i).getHomeTime().getName().equals("Juventus")) {
                name = allMatchsSerieACompleto.get(i).getHomeTime().getName();
                image = allMatchsSerieACompleto.get(i).getHomeTime().getImage();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() == allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (allMatchsSerieACompleto.get(i).getAwayTime().getName().equals("Juventus")) {
                name = allMatchsSerieACompleto.get(i).getAwayTime().getName();
                image = allMatchsSerieACompleto.get(i).getAwayTime().getImage();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() == allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < allMatchsSerieACompleto.size(); i++) {
            if (allMatchsSerieACompleto.get(i).getHomeTime().getName().equals("Lazio")) {
                name = allMatchsSerieACompleto.get(i).getHomeTime().getName();
                image = allMatchsSerieACompleto.get(i).getHomeTime().getImage();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() == allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (allMatchsSerieACompleto.get(i).getAwayTime().getName().equals("Lazio")) {
                name = allMatchsSerieACompleto.get(i).getAwayTime().getName();
                image = allMatchsSerieACompleto.get(i).getAwayTime().getImage();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() == allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < allMatchsSerieACompleto.size(); i++) {
            if (allMatchsSerieACompleto.get(i).getHomeTime().getName().equals("Lecce")) {
                name = allMatchsSerieACompleto.get(i).getHomeTime().getName();
                image = allMatchsSerieACompleto.get(i).getHomeTime().getImage();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() == allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (allMatchsSerieACompleto.get(i).getAwayTime().getName().equals("Lecce")) {
                name = allMatchsSerieACompleto.get(i).getAwayTime().getName();
                image = allMatchsSerieACompleto.get(i).getAwayTime().getImage();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() == allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < allMatchsSerieACompleto.size(); i++) {
            if (allMatchsSerieACompleto.get(i).getHomeTime().getName().equals("Milan")) {
                name = allMatchsSerieACompleto.get(i).getHomeTime().getName();
                image = allMatchsSerieACompleto.get(i).getHomeTime().getImage();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() == allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (allMatchsSerieACompleto.get(i).getAwayTime().getName().equals("Milan")) {
                name = allMatchsSerieACompleto.get(i).getAwayTime().getName();
                image = allMatchsSerieACompleto.get(i).getAwayTime().getImage();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() == allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < allMatchsSerieACompleto.size(); i++) {
            if (allMatchsSerieACompleto.get(i).getHomeTime().getName().equals("Monza")) {
                name = allMatchsSerieACompleto.get(i).getHomeTime().getName();
                image = allMatchsSerieACompleto.get(i).getHomeTime().getImage();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() == allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (allMatchsSerieACompleto.get(i).getAwayTime().getName().equals("Monza")) {
                name = allMatchsSerieACompleto.get(i).getAwayTime().getName();
                image = allMatchsSerieACompleto.get(i).getAwayTime().getImage();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() == allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
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

        for (int i = 0; i < allMatchsSerieACompleto.size(); i++) {
            if (allMatchsSerieACompleto.get(i).getHomeTime().getName().equals("Napoli")) {
                name = allMatchsSerieACompleto.get(i).getHomeTime().getName();
                image = allMatchsSerieACompleto.get(i).getHomeTime().getImage();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() == allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (allMatchsSerieACompleto.get(i).getAwayTime().getName().equals("Napoli")) {
                name = allMatchsSerieACompleto.get(i).getAwayTime().getName();
                image = allMatchsSerieACompleto.get(i).getAwayTime().getImage();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() == allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
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


        for (int i = 0; i < allMatchsSerieACompleto.size(); i++) {
            if (allMatchsSerieACompleto.get(i).getHomeTime().getName().equals("Parma")) {
                name = allMatchsSerieACompleto.get(i).getHomeTime().getName();
                image = allMatchsSerieACompleto.get(i).getHomeTime().getImage();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() == allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (allMatchsSerieACompleto.get(i).getAwayTime().getName().equals("Parma")) {
                name = allMatchsSerieACompleto.get(i).getAwayTime().getName();
                image = allMatchsSerieACompleto.get(i).getAwayTime().getImage();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() == allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
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


        for (int i = 0; i < allMatchsSerieACompleto.size(); i++) {
            if (allMatchsSerieACompleto.get(i).getHomeTime().getName().equals("Roma")) {
                name = allMatchsSerieACompleto.get(i).getHomeTime().getName();
                image = allMatchsSerieACompleto.get(i).getHomeTime().getImage();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() == allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (allMatchsSerieACompleto.get(i).getAwayTime().getName().equals("Roma")) {
                name = allMatchsSerieACompleto.get(i).getAwayTime().getName();
                image = allMatchsSerieACompleto.get(i).getAwayTime().getImage();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() == allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
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


        for (int i = 0; i < allMatchsSerieACompleto.size(); i++) {
            if (allMatchsSerieACompleto.get(i).getHomeTime().getName().equals("Torino")) {
                name = allMatchsSerieACompleto.get(i).getHomeTime().getName();
                image = allMatchsSerieACompleto.get(i).getHomeTime().getImage();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() == allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (allMatchsSerieACompleto.get(i).getAwayTime().getName().equals("Torino")) {
                name = allMatchsSerieACompleto.get(i).getAwayTime().getName();
                image = allMatchsSerieACompleto.get(i).getAwayTime().getImage();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() == allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
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


        for (int i = 0; i < allMatchsSerieACompleto.size(); i++) { //inicio do for
            if (allMatchsSerieACompleto.get(i).getHomeTime().getName().equals("Udinese")) {
                name = allMatchsSerieACompleto.get(i).getHomeTime().getName();
                image = allMatchsSerieACompleto.get(i).getHomeTime().getImage();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() == allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (allMatchsSerieACompleto.get(i).getAwayTime().getName().equals("Udinese")) {
                name = allMatchsSerieACompleto.get(i).getAwayTime().getName();
                image = allMatchsSerieACompleto.get(i).getAwayTime().getImage();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() == allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
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


        for (int i = 0; i < allMatchsSerieACompleto.size(); i++) { //inicio do for
            if (allMatchsSerieACompleto.get(i).getHomeTime().getName().equals("Venezia")) {
                name = allMatchsSerieACompleto.get(i).getHomeTime().getName();
                image = allMatchsSerieACompleto.get(i).getHomeTime().getImage();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() == allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (allMatchsSerieACompleto.get(i).getAwayTime().getName().equals("Venezia")) {
                name = allMatchsSerieACompleto.get(i).getAwayTime().getName();
                image = allMatchsSerieACompleto.get(i).getAwayTime().getImage();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() == allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
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


        for (int i = 0; i < allMatchsSerieACompleto.size(); i++) { //inicio do for
            if (allMatchsSerieACompleto.get(i).getHomeTime().getName().equals("Verona")) {
                name = allMatchsSerieACompleto.get(i).getHomeTime().getName();
                image = allMatchsSerieACompleto.get(i).getHomeTime().getImage();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() == allMatchsSerieACompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (allMatchsSerieACompleto.get(i).getAwayTime().getName().equals("Verona")) {
                name = allMatchsSerieACompleto.get(i).getAwayTime().getName();
                image = allMatchsSerieACompleto.get(i).getAwayTime().getImage();
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() == allMatchsSerieACompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (allMatchsSerieACompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += allMatchsSerieACompleto.get(i).getAwayTime().getScore();
                if (allMatchsSerieACompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += allMatchsSerieACompleto.get(i).getHomeTime().getScore();
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



    }
}