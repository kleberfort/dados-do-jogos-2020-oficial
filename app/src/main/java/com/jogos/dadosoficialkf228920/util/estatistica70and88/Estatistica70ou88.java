package com.jogos.dadosoficialkf228920.util.estatistica70and88;

import android.text.SpannableStringBuilder;
import android.util.Log;

import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;

import java.util.ArrayList;
import java.util.List;

public class Estatistica70ou88 {

    public static List<CharSequence> melhoresStatisticasCasa(List<PartidaNovoModelo> listTeamHomeCompleto, String team, Integer porcentagem) {

        String homeTeam = team;

        int homeGolsTotalPrimeiroTempoZeroCincoMarcados = 0;
        int homeGolsTotalPrimeiroTempoZeroCincoNaoMarcados = 0;

        int homeGolsTotalPrimeiroTempoUmCincoMarcados = 0;
        int homeGolsTotalPrimeiroTempoUmCincoNaoMarcados = 0;

        int homeGolsTotalPrimeiroTempoDoisCincoMarcados = 0;
        int homeGolsTotalPrimeiroTempoDoisCincoNaoMarcados = 0;

        int homeGolsTotalSegundoTempoZeroCincoMarcados = 0;
        int homeGolsTotalSegundoTempoZeroCincoNaoMarcados = 0;

        int homeGolsTotalSegundoTempoUmCincoMarcados = 0;
        int homeGolsTotalSegundoTempoUmCincoNaoMarcados = 0;

        int homeGolsTotalSegundoTempoDoisCincoMarcados = 0;
        int homeGolsTotalSegundoTempoDoisCincoNaoMarcados = 0;

        int awayGolsTotalPrimeiroTempoZeroCincoMarcados = 0;
        int awayGolsTotalPrimeiroTempoZeroCincoNaoMarcados = 0;

        int awayGolsTotalPrimeiroTempoUmCincoMarcados = 0;
        int awayGolsTotalPrimeiroTempoUmCincoNaoMarcados = 0;

        int awayGolsTotalPrimeiroTempoDoisCincoMarcados = 0;
        int awayGolsTotalPrimeiroTempoDoisCincoNaoMarcados = 0;

        int awayGolsTotalSegundoTempoZeroCincoMarcados = 0;
        int awayGolsTotalSegundoTempoZeroCincoNaoMarcados = 0;

        int awayGolsTotalSegundoTempoUmCincoMarcados = 0;
        int awayGolsTotalSegundoTempoUmCincoNaoMarcados = 0;

        int awayGolsTotalSegundoTempoDoisCincoMarcados = 0;
        int awayGolsTotalSegundoTempoDoisCincoNaoMarcados = 0;


        int homeGolsTotalZeroCincoMarcados = 0;
        int homeGolsTotalZeroCincoNaoMarcados = 0;

        int homeGolsTotalUmCincoMarcados = 0;
        int homeGolsTotalUmCincoNaoMarcados = 0;

        int homeGolsTotalDoisCincoMarcados = 0;
        int homeGolsTotalDoisCincoNaoMarcados = 0;

        int homeGolsTotalTresCincoMarcados = 0;
        int homeGolsTotalTresCincoNaoMarcados = 0;

        int awayGolsTotalZeroCincoMarcados = 0;
        int awayGolsTotalZeroCincoNaoMarcados = 0;

        int awayGolsTotalUmCincoMarcados = 0;
        int awayGolsTotalUmCincoNaoMarcados = 0;

        int awayGolsTotalDoisCincoMarcados = 0;
        int awayGolsTotalDoisCincoNaoMarcados = 0;

        int awayGolsTotalTresCincoMarcados = 0;
        int awayGolsTotalTresCincoNaoMarcados = 0;


        //CARTÕES
        int homeAmareloPrimeiroTempoZeroCincoMcd = 0;
        int homeAmareloPrimeiroTempoZeroCincoNaoMcd = 0;

        int homeAmareloPrimeiroTempoUmCincoMcd = 0;
        int homeAmareloPrimeiroTempoUmCincoNaoMcd = 0;

        int homeAmareloSegundoTempoZeroCincoMcd = 0;
        int homeAmareloSegundoTempoZeroCincoNaoMcd = 0;

        int homeAmareloSegundoTempoUmCincoMcd = 0;
        int homeAmareloSegundoTempoUmCincoNaoMcd = 0;

        int homeVermelhoPrimeiroTempoZeroCincoMcd = 0;
        int homeVermelhoPrimeiroTempoZeroCincoNaoMcd = 0;

        int homeVermelhoSegundoTempoZeroCincoMcd = 0;
        int homeVermelhoSegundoTempoZeroCincoNaoMcd = 0;

        //CARTÕES TOTAIS
        int homeAmareloVermelhoTotalZeroCincoMcd = 0;
        int homeAmareloVermelhoTotalZeroCincoNaoMcd = 0;

        int homeAmareloVermelhoTotalUmCincoMcd = 0;
        int homeAmareloVermelhoTotalUmCincoNaoMcd = 0;

        int homeAmareloVermelhoTotalDoisCincoMcd = 0;
        int homeAmareloVermelhoTotalDoisCincoNaoMcd = 0;

        int homeAmareloVermelhoTotalTresCincoMcd = 0;
        int homeAmareloVermelhoTotalTresCincoNaoMcd = 0;


        //ESCANTEIOS

        //ESCANTEIOS 1T CASA
        int homeEscanteiosPrimeiroTempoZeroCincoMcd = 0;
        int homeEscanteiosPrimeiroTempoZeroCincoNaoMcd = 0;

        int homeEscanteiosPrimeiroTempoUmCincoMcd = 0;
        int homeEscanteiosPrimeiroTempoUmCincoNaoMcd = 0;

        int homeEscanteiosPrimeiroTempoDoisCincoMcd = 0;
        int homeEscanteiosPrimeiroTempoDoisCincoNaoMcd = 0;

        int homeEscanteiosPrimeiroTempoTresCincoMcd = 0;
        int homeEscanteiosPrimeiroTempoTresCincoNaoMcd = 0;

        //ESCANTEIOS 2T CASA
        int homeEscanteiosSegundoTempoZeroCincoMcd = 0;
        int homeEscanteiosSegundoTempoZeroCincoNaoMcd = 0;

        int homeEscanteiosSegundoTempoUmCincoMcd = 0;
        int homeEscanteiosSegundoTempoUmCincoNaoMcd = 0;

        int homeEscanteiosSegundoTempoDoisCincoMcd = 0;
        int homeEscanteiosSegundoTempoDoisCincoNaoMcd = 0;

        int homeEscanteiosSegundoTempoTresCincoMcd = 0;
        int homeEscanteiosSegundoTempoTresCincoNaoMcd = 0;

        //ESCANTEIOS ACIMA TOTAL CASA
        int homeEscanteiosTotalZeroCincoMcd = 0;
        int homeEscanteiosTotalZeroCincoNaoMcd = 0;

        int homeEscanteiosTotalUmCincoMcd = 0;
        int homeEscanteiosTotalUmCincoNaoMcd = 0;

        int homeEscanteiosTotalDoisCincoMcd = 0;
        int homeEscanteiosTotalDoisCincoNaoMcd = 0;

        int homeEscanteiosTotalTresCincoMcd = 0;
        int homeEscanteiosTotalTresCincoNaoMcd = 0;

        int homeEscanteiosTotalQuatroCincoMcd = 0;
        int homeEscanteiosTotalQuatroCincoNaoMcd = 0;

        int homeEscanteiosTotalCincoCincoMcd = 0;
        int homeEscanteiosTotalCincoCincoNaoMcd = 0;

        int jogosCasa = 0;


        List<CharSequence> resultadosCasa = null;
        for (int i = 0; i < listTeamHomeCompleto.size(); i++) {

            resultadosCasa = new ArrayList<>();

            if (listTeamHomeCompleto.get(i).getHomeTime().getName().equals(homeTeam)) {
                //GOLS 0.5 1°TEMPO
                if (listTeamHomeCompleto.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo() > 0)
                    homeGolsTotalPrimeiroTempoZeroCincoMarcados += 1;
                //GOLS 1.5 1°TEMPO
                if (listTeamHomeCompleto.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo() > 1)
                    homeGolsTotalPrimeiroTempoUmCincoMarcados += 1;
                //GOLS 2.5 1°TEMPO
                if (listTeamHomeCompleto.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo() > 2)
                    homeGolsTotalPrimeiroTempoDoisCincoMarcados += 1;

                //GOLS 0.5 2°TEMPO
                if (listTeamHomeCompleto.get(i).getHomeEstatisticaJogo().getGolsSegundoTempo() > 0)
                    homeGolsTotalSegundoTempoZeroCincoMarcados += 1;
                //GOLS 1.5 2°TEMPO
                if (listTeamHomeCompleto.get(i).getHomeEstatisticaJogo().getGolsSegundoTempo() > 1)
                    homeGolsTotalSegundoTempoUmCincoMarcados += 1;
                //GOLS 2.5 2°TEMPO
                if (listTeamHomeCompleto.get(i).getHomeEstatisticaJogo().getGolsSegundoTempo() > 2)
                    homeGolsTotalSegundoTempoDoisCincoMarcados += 1;


                //GOLS ACIMA 0.5 TEMPO
                if (listTeamHomeCompleto.get(i).getHomeTime().getPlacar() > 0)
                    homeGolsTotalZeroCincoMarcados += 1;

                //GOLS ACIMA 1.5 TEMPO
                if (listTeamHomeCompleto.get(i).getHomeTime().getPlacar() > 1)
                    homeGolsTotalUmCincoMarcados += 1;

                //GOLS ACIMA 2.5 TEMPO
                if (listTeamHomeCompleto.get(i).getHomeTime().getPlacar() > 2)
                    homeGolsTotalDoisCincoMarcados += 1;

                //GOLS ACIMA 3.5 TEMPO
                if (listTeamHomeCompleto.get(i).getHomeTime().getPlacar() > 3)
                    homeGolsTotalTresCincoMarcados += 1;



                //--------------------DADOS JOGOS FORA --------------------------------------
                //GOLS 0.5 1°TEMPO
                if (listTeamHomeCompleto.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo() > 0)
                    awayGolsTotalPrimeiroTempoZeroCincoMarcados += 1;
                //GOLS 1.5 1°TEMPO
                if (listTeamHomeCompleto.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo() > 1)
                    awayGolsTotalPrimeiroTempoUmCincoMarcados += 1;
                //GOLS 2.5 1°TEMPO
                if (listTeamHomeCompleto.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo() > 2)
                    awayGolsTotalPrimeiroTempoDoisCincoMarcados += 1;

                //GOLS 0.5 2°TEMPO
                if (listTeamHomeCompleto.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo() > 0)
                    awayGolsTotalSegundoTempoZeroCincoMarcados += 1;
                //GOLS 1.5 2°TEMPO
                if (listTeamHomeCompleto.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo() > 1)
                    awayGolsTotalSegundoTempoUmCincoMarcados += 1;
                //GOLS 2.5 2°TEMPO
                if (listTeamHomeCompleto.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo() > 2)
                    awayGolsTotalSegundoTempoDoisCincoMarcados += 1;


                //GOLS ACIMA 0.5 TEMPO
                if (listTeamHomeCompleto.get(i).getAwayTime().getPlacar() > 0)
                    awayGolsTotalZeroCincoMarcados += 1;

                //GOLS ACIMA 1.5 TEMPO
                if (listTeamHomeCompleto.get(i).getAwayTime().getPlacar() > 1)
                    awayGolsTotalUmCincoMarcados += 1;

                //GOLS ACIMA 2.5 TEMPO
                if (listTeamHomeCompleto.get(i).getAwayTime().getPlacar() > 2)
                    awayGolsTotalDoisCincoMarcados += 1;

                //GOLS ACIMA 3.5 TEMPO
                if (listTeamHomeCompleto.get(i).getAwayTime().getPlacar() > 3)
                    awayGolsTotalTresCincoMarcados += 1;



                //---------------------------- CARTOES CASA --------------------------------------------------

                //CARTOES 0.5 1°TEMPO
                if(listTeamHomeCompleto.get(i).getHomeCartoes().getCartaoAmareloPrimeiroTempo() > 0)
                    homeAmareloPrimeiroTempoZeroCincoMcd += 1;

                //CARTOES 1.5 1°TEMPO
                if(listTeamHomeCompleto.get(i).getHomeCartoes().getCartaoAmareloPrimeiroTempo() > 1)
                    homeAmareloPrimeiroTempoUmCincoMcd += 1;

                //CARTOES VERMELHO DIRETO 0.5 1°TEMPO
                if(listTeamHomeCompleto.get(i).getHomeCartoes().getCartaoVermelhoPrimeiroTempo() > 0)
                    homeVermelhoPrimeiroTempoZeroCincoMcd += 1;

                // ------------------- SEGUNDO TEMPO -----------------------------------------------------------------------

                //CARTOES 0.5 2°TEMPO
                if(listTeamHomeCompleto.get(i).getHomeCartoes().getCartaoAmareloSegundoTempo() > 0)
                    homeAmareloSegundoTempoZeroCincoMcd += 1;

                //CARTOES 1.5 2°TEMPO
                if(listTeamHomeCompleto.get(i).getHomeCartoes().getCartaoAmareloSegundoTempo() > 1)
                    homeAmareloSegundoTempoUmCincoMcd += 1;

                //CARTOES VERMELHO DIRETO 0.5 2°TEMPO
                if(listTeamHomeCompleto.get(i).getHomeCartoes().getCartaoVermelhoSegundoTempo() > 0)
                    homeVermelhoSegundoTempoZeroCincoMcd += 1;

                //------------------------ CARTOES ACIMA---------------------------------------------------------

                //CARTOES ACIMA 0.5 TEMPO
                if(listTeamHomeCompleto.get(i).getHomeCartoes().getCartaoAmareloPrimeiroTempo() + listTeamHomeCompleto.get(i).getHomeCartoes().getCartaoAmareloSegundoTempo()  + listTeamHomeCompleto.get(i).getHomeCartoes().getCartaoVermelhoPrimeiroTempo() + listTeamHomeCompleto.get(i).getHomeCartoes().getCartaoVermelhoSegundoTempo() > 0)
                    homeAmareloVermelhoTotalZeroCincoMcd += 1;

                //CARTOES ACIMA 1.5 TEMPO
                if(listTeamHomeCompleto.get(i).getHomeCartoes().getCartaoAmareloPrimeiroTempo() + listTeamHomeCompleto.get(i).getHomeCartoes().getCartaoAmareloSegundoTempo()  + listTeamHomeCompleto.get(i).getHomeCartoes().getCartaoVermelhoPrimeiroTempo() + listTeamHomeCompleto.get(i).getHomeCartoes().getCartaoVermelhoSegundoTempo() > 1 )
                    homeAmareloVermelhoTotalUmCincoMcd += 1;

                //CARTOES ACIMA 2.5 TEMPO
                if(listTeamHomeCompleto.get(i).getHomeCartoes().getCartaoAmareloPrimeiroTempo() + listTeamHomeCompleto.get(i).getHomeCartoes().getCartaoAmareloSegundoTempo()  + listTeamHomeCompleto.get(i).getHomeCartoes().getCartaoVermelhoPrimeiroTempo() + listTeamHomeCompleto.get(i).getHomeCartoes().getCartaoVermelhoSegundoTempo() > 2)
                    homeAmareloVermelhoTotalDoisCincoMcd += 1;

                //CARTOES ACIMA 3.5 TEMPO
                if(listTeamHomeCompleto.get(i).getHomeCartoes().getCartaoAmareloPrimeiroTempo() + listTeamHomeCompleto.get(i).getHomeCartoes().getCartaoAmareloSegundoTempo()  + listTeamHomeCompleto.get(i).getHomeCartoes().getCartaoVermelhoPrimeiroTempo() + listTeamHomeCompleto.get(i).getHomeCartoes().getCartaoVermelhoSegundoTempo() > 3)
                    homeAmareloVermelhoTotalTresCincoMcd += 1;


                //------------------------ESCANTEIOS CASA----------------------------------------


                //----------------------------ESCANTEIOS 1T-------------------------------------

                //ESCANTEIOS 0.5 1°TEMPO
                if(listTeamHomeCompleto.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() > 0)
                    homeEscanteiosPrimeiroTempoZeroCincoMcd += 1;

                //ESCANTEIOS 1.5 1°TEMPO
                if(listTeamHomeCompleto.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() > 1)
                    homeEscanteiosPrimeiroTempoUmCincoMcd += 1;

                //ESCANTEIOS 2.5 1°TEMPO
                if(listTeamHomeCompleto.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() > 2)
                    homeEscanteiosPrimeiroTempoDoisCincoMcd += 1;

                //ESCANTEIOS 3.5 1°TEMPO
                if(listTeamHomeCompleto.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() > 3)
                    homeEscanteiosPrimeiroTempoTresCincoMcd += 1;


                //---------------------------ESCANTEIOS 2T-------------------------------------
                //ESCANTEIOS 0.5 2°TEMPO
                if(listTeamHomeCompleto.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() > 0)
                    homeEscanteiosSegundoTempoZeroCincoMcd += 1;

                //ESCANTEIOS 1.5 2°TEMPO
                if(listTeamHomeCompleto.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() > 1)
                    homeEscanteiosSegundoTempoUmCincoMcd += 1;

                //ESCANTEIOS 2.5 2°TEMPO
                if(listTeamHomeCompleto.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() > 2)
                    homeEscanteiosSegundoTempoDoisCincoMcd += 1;

                //ESCANTEIOS 3.5 2°TEMPO
                if(listTeamHomeCompleto.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() > 3)
                    homeEscanteiosSegundoTempoTresCincoMcd += 1;

                //---------------------ESCANTEIOS ACIMA CASA -------------------------------------

                //ESCANTEIOS ACIMA 0.5 TEMPO
                if(listTeamHomeCompleto.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo()
                        + listTeamHomeCompleto.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() > 0)
                    homeEscanteiosTotalZeroCincoMcd += 1;

                //ESCANTEIOS ACIMA 1.5 TEMPO
                if(listTeamHomeCompleto.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo()
                        + listTeamHomeCompleto.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() > 1)
                    homeEscanteiosTotalUmCincoMcd += 1;

                //ESCANTEIOS ACIMA 2.5 TEMPO
                if(listTeamHomeCompleto.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listTeamHomeCompleto.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() > 2)
                    homeEscanteiosTotalDoisCincoMcd += 1;

                //ESCANTEIOS ACIMA 3.5 TEMPO
                if(listTeamHomeCompleto.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listTeamHomeCompleto.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() > 3)
                    homeEscanteiosTotalTresCincoMcd += 1;

                //ESCANTEIOS ACIMA 4.5 TEMPO
                if(listTeamHomeCompleto.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listTeamHomeCompleto.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() > 4)
                    homeEscanteiosTotalQuatroCincoMcd += 1;

                //ESCANTEIOS ACIMA 5.5 TEMPO
                if(listTeamHomeCompleto.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listTeamHomeCompleto.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() > 5)
                    homeEscanteiosTotalCincoCincoMcd += 1;


                jogosCasa += 1;

            }

        }//fim do for ceara

        //-------------------------DADOS JOGOS CASA GOLS--------------------------------------------------------

        //GOLS 1T CASA
        homeGolsTotalPrimeiroTempoZeroCincoNaoMarcados = jogosCasa - homeGolsTotalPrimeiroTempoZeroCincoMarcados;
        homeGolsTotalPrimeiroTempoUmCincoNaoMarcados = jogosCasa - homeGolsTotalPrimeiroTempoUmCincoMarcados;
        homeGolsTotalPrimeiroTempoDoisCincoNaoMarcados = jogosCasa - homeGolsTotalPrimeiroTempoDoisCincoMarcados;

        //GOLS 2T CASA
        homeGolsTotalSegundoTempoZeroCincoNaoMarcados = jogosCasa - homeGolsTotalSegundoTempoZeroCincoMarcados;
        homeGolsTotalSegundoTempoUmCincoNaoMarcados = jogosCasa - homeGolsTotalSegundoTempoUmCincoMarcados;
        homeGolsTotalSegundoTempoDoisCincoNaoMarcados = jogosCasa - homeGolsTotalSegundoTempoDoisCincoMarcados;

        //-------------------------GOLS ACIMA CASA-------------------------------------------------
        homeGolsTotalZeroCincoNaoMarcados = jogosCasa - homeGolsTotalZeroCincoMarcados;
        homeGolsTotalUmCincoNaoMarcados = jogosCasa - homeGolsTotalUmCincoMarcados;
        homeGolsTotalDoisCincoNaoMarcados = jogosCasa - homeGolsTotalDoisCincoMarcados;
        homeGolsTotalTresCincoNaoMarcados = jogosCasa - homeGolsTotalTresCincoMarcados;


        //-------------------------DADOS JOGOS FORA GOLS -----------------------------------------------------

        //GOLS 1T FORA
        awayGolsTotalPrimeiroTempoZeroCincoNaoMarcados = jogosCasa - awayGolsTotalPrimeiroTempoZeroCincoMarcados;
        awayGolsTotalPrimeiroTempoUmCincoNaoMarcados = jogosCasa - awayGolsTotalPrimeiroTempoUmCincoMarcados;
        awayGolsTotalPrimeiroTempoDoisCincoNaoMarcados = jogosCasa - awayGolsTotalPrimeiroTempoDoisCincoMarcados;

        //GOLS 2T FORA
        awayGolsTotalSegundoTempoZeroCincoNaoMarcados = jogosCasa - awayGolsTotalSegundoTempoZeroCincoMarcados;
        awayGolsTotalSegundoTempoUmCincoNaoMarcados = jogosCasa - awayGolsTotalSegundoTempoUmCincoMarcados;
        awayGolsTotalSegundoTempoDoisCincoNaoMarcados = jogosCasa - awayGolsTotalSegundoTempoDoisCincoMarcados;

        //-------------------------GOLS ACIMA FORA-------------------------------------------------
        awayGolsTotalZeroCincoNaoMarcados = jogosCasa - awayGolsTotalZeroCincoMarcados;
        awayGolsTotalUmCincoNaoMarcados = jogosCasa - awayGolsTotalUmCincoMarcados;
        awayGolsTotalDoisCincoNaoMarcados = jogosCasa - awayGolsTotalDoisCincoMarcados;
        awayGolsTotalTresCincoNaoMarcados = jogosCasa - awayGolsTotalTresCincoMarcados;



        //-----------------------CARTÃO CASA ---------------------------------------------

        //CARTAO 1T CASA
        homeAmareloPrimeiroTempoZeroCincoNaoMcd = jogosCasa - homeAmareloPrimeiroTempoZeroCincoMcd;
        homeAmareloPrimeiroTempoUmCincoNaoMcd = jogosCasa - homeAmareloPrimeiroTempoUmCincoMcd;
        homeVermelhoPrimeiroTempoZeroCincoNaoMcd = jogosCasa - homeVermelhoPrimeiroTempoZeroCincoMcd;

        //CARTAO 2T CASA
        homeAmareloSegundoTempoZeroCincoNaoMcd = jogosCasa - homeAmareloSegundoTempoZeroCincoMcd;
        homeAmareloSegundoTempoUmCincoNaoMcd = jogosCasa - homeAmareloSegundoTempoUmCincoMcd;
        homeVermelhoSegundoTempoZeroCincoNaoMcd = jogosCasa - homeVermelhoSegundoTempoZeroCincoMcd;


        //CARTÕES TOTAIS
        homeAmareloVermelhoTotalZeroCincoNaoMcd = jogosCasa - homeAmareloVermelhoTotalZeroCincoMcd;
        homeAmareloVermelhoTotalUmCincoNaoMcd = jogosCasa - homeAmareloVermelhoTotalUmCincoMcd;
        homeAmareloVermelhoTotalDoisCincoNaoMcd = jogosCasa - homeAmareloVermelhoTotalDoisCincoMcd;
        homeAmareloVermelhoTotalTresCincoNaoMcd = jogosCasa - homeAmareloVermelhoTotalTresCincoMcd;


        //----------------------------ESCANTEIOS CASA --------------------------------------------
        //ESCANTEIOS 1T CASA
        homeEscanteiosPrimeiroTempoZeroCincoNaoMcd = jogosCasa - homeEscanteiosPrimeiroTempoZeroCincoMcd;
        homeEscanteiosPrimeiroTempoUmCincoNaoMcd = jogosCasa - homeEscanteiosPrimeiroTempoUmCincoMcd;
        homeEscanteiosPrimeiroTempoDoisCincoNaoMcd = jogosCasa - homeEscanteiosPrimeiroTempoDoisCincoMcd;
        homeEscanteiosPrimeiroTempoTresCincoNaoMcd = jogosCasa - homeEscanteiosPrimeiroTempoTresCincoMcd;

        //ESCANTEIOS 2T CASA
        homeEscanteiosSegundoTempoZeroCincoNaoMcd = jogosCasa - homeEscanteiosSegundoTempoZeroCincoMcd;
        homeEscanteiosSegundoTempoUmCincoNaoMcd = jogosCasa - homeEscanteiosSegundoTempoUmCincoMcd;
        homeEscanteiosSegundoTempoDoisCincoNaoMcd = jogosCasa - homeEscanteiosSegundoTempoDoisCincoMcd;
        homeEscanteiosSegundoTempoTresCincoNaoMcd = jogosCasa - homeEscanteiosSegundoTempoTresCincoMcd;

        //ESCANTEIOS TOTAL ACIMA CASA
        homeEscanteiosTotalZeroCincoNaoMcd = jogosCasa - homeEscanteiosTotalZeroCincoMcd;
        homeEscanteiosTotalUmCincoNaoMcd = jogosCasa - homeEscanteiosTotalUmCincoMcd;
        homeEscanteiosTotalDoisCincoNaoMcd = jogosCasa - homeEscanteiosTotalDoisCincoMcd;
        homeEscanteiosTotalTresCincoNaoMcd = jogosCasa - homeEscanteiosTotalTresCincoMcd;
        homeEscanteiosTotalQuatroCincoNaoMcd = jogosCasa - homeEscanteiosTotalQuatroCincoMcd;
        homeEscanteiosTotalCincoCincoNaoMcd = jogosCasa - homeEscanteiosTotalCincoCincoMcd;


        //GOLS HOME MARCADO 1T 0.5
       if (Math.round(homeGolsTotalPrimeiroTempoZeroCincoMarcados * 100 / jogosCasa) >= porcentagem){
           String mercado = "homeGolsTotalPrimeiroTempoZeroCincoMarcados";
           // Cria o SpannableStringBuilder com as cores formatadas
           SpannableStringBuilder builder = FormatCorViewHomeGolsMcdAndNaoMcdRecyclerView.formatTextHomeMarcou(mercado,
                   homeTeam, Math.round((homeGolsTotalPrimeiroTempoZeroCincoMarcados * 100.0 / jogosCasa)), homeGolsTotalPrimeiroTempoZeroCincoMarcados,
                   jogosCasa);
           // Adiciona à lista, assumindo que resultadosCasa pode aceitar CharSequence ou SpannableStringBuilder
           resultadosCasa.add(builder);
       }
            //GOLS HOME NAO MARCADO 1T 0.5
        if (Math.round(homeGolsTotalPrimeiroTempoZeroCincoNaoMarcados * 100 / jogosCasa) >= porcentagem){
            String mercado = "homeGolsTotalPrimeiroTempoZeroCincoNaoMarcados";
            // Cria o SpannableStringBuilder com as cores formatadas
            SpannableStringBuilder builder = FormatCorViewHomeGolsMcdAndNaoMcdRecyclerView.formatTextHomeNaoMarcou(mercado,
                    homeTeam, Math.round((homeGolsTotalPrimeiroTempoZeroCincoNaoMarcados * 100.0 / jogosCasa)), homeGolsTotalPrimeiroTempoZeroCincoNaoMarcados,
                    jogosCasa);
            // Adiciona à lista, assumindo que resultadosCasa pode aceitar CharSequence ou SpannableStringBuilder
            resultadosCasa.add(builder);
        }

            //GOLS HOME MARCADO 1T 1.5
        if (Math.round(homeGolsTotalPrimeiroTempoUmCincoMarcados * 100 / jogosCasa) >= porcentagem){
            String mercado = "homeGolsTotalPrimeiroTempoUmCincoMarcados";
            // Cria o SpannableStringBuilder com as cores formatadas
            SpannableStringBuilder builder = FormatCorViewHomeGolsMcdAndNaoMcdRecyclerView.formatTextHomeMarcou(mercado,
                    homeTeam, Math.round((homeGolsTotalPrimeiroTempoUmCincoMarcados * 100.0 / jogosCasa)), homeGolsTotalPrimeiroTempoUmCincoMarcados,
                    jogosCasa);
            // Adiciona à lista, assumindo que resultadosCasa pode aceitar CharSequence ou SpannableStringBuilder
            resultadosCasa.add(builder);
        }
            //GOLS HOME NAO MARCADO 1T 1.5
        if (Math.round(homeGolsTotalPrimeiroTempoUmCincoNaoMarcados * 100 / jogosCasa) >= porcentagem){
            String mercado = "homeGolsTotalPrimeiroTempoUmCincoNaoMarcados";
            // Cria o SpannableStringBuilder com as cores formatadas
            SpannableStringBuilder builder = FormatCorViewHomeGolsMcdAndNaoMcdRecyclerView.formatTextHomeNaoMarcou(mercado,
                    homeTeam, Math.round((homeGolsTotalPrimeiroTempoUmCincoNaoMarcados * 100.0 / jogosCasa)), homeGolsTotalPrimeiroTempoUmCincoNaoMarcados,
                    jogosCasa);
            // Adiciona à lista, assumindo que resultadosCasa pode aceitar CharSequence ou SpannableStringBuilder
            resultadosCasa.add(builder);
        }

        //GOLS HOME MARCADO 1T 2.5
        if (Math.round(homeGolsTotalPrimeiroTempoDoisCincoMarcados * 100 / jogosCasa) >= porcentagem){
            String mercado = "homeGolsTotalPrimeiroTempoDoisCincoMarcados";
            // Cria o SpannableStringBuilder com as cores formatadas
            SpannableStringBuilder builder = FormatCorViewHomeGolsMcdAndNaoMcdRecyclerView.formatTextHomeMarcou(mercado,
                    homeTeam, Math.round((homeGolsTotalPrimeiroTempoDoisCincoMarcados * 100.0 / jogosCasa)), homeGolsTotalPrimeiroTempoDoisCincoMarcados,
                    jogosCasa);
            // Adiciona à lista, assumindo que resultadosCasa pode aceitar CharSequence ou SpannableStringBuilder
            resultadosCasa.add(builder);
        }
            //GOLS HOME NAO MARCADO 1T 2.5
        if (Math.round(homeGolsTotalPrimeiroTempoDoisCincoNaoMarcados * 100 / jogosCasa) >= porcentagem){
            String mercado = "homeGolsTotalPrimeiroTempoDoisCincoNaoMarcados";
            // Cria o SpannableStringBuilder com as cores formatadas
            SpannableStringBuilder builder = FormatCorViewHomeGolsMcdAndNaoMcdRecyclerView.formatTextHomeNaoMarcou(mercado,
                    homeTeam, Math.round((homeGolsTotalPrimeiroTempoDoisCincoNaoMarcados * 100.0 / jogosCasa)), homeGolsTotalPrimeiroTempoDoisCincoNaoMarcados,
                    jogosCasa);
            // Adiciona à lista, assumindo que resultadosCasa pode aceitar CharSequence ou SpannableStringBuilder
            resultadosCasa.add(builder);
        }

    //------------------------------------------------------------------------------------------------------------------//

        //GOLS 2T CASA
        if (Math.round(homeGolsTotalSegundoTempoZeroCincoMarcados * 100 / jogosCasa) >= porcentagem){
            String mercado = "homeGolsTotalSegundoTempoZeroCincoMarcados";
            // Cria o SpannableStringBuilder com as cores formatadas
            SpannableStringBuilder builder = FormatCorViewHomeGolsMcdAndNaoMcdRecyclerView.formatTextHomeMarcou(mercado,
                    homeTeam, Math.round((homeGolsTotalSegundoTempoZeroCincoMarcados * 100.0 / jogosCasa)), homeGolsTotalSegundoTempoZeroCincoMarcados,
                    jogosCasa);
            // Adiciona à lista, assumindo que resultadosCasa pode aceitar CharSequence ou SpannableStringBuilder
            resultadosCasa.add(builder);
        }

        if (Math.round(homeGolsTotalSegundoTempoZeroCincoNaoMarcados * 100 / jogosCasa) >= porcentagem){
            String mercado = "homeGolsTotalSegundoTempoZeroCincoNaoMarcados";
            // Cria o SpannableStringBuilder com as cores formatadas
            SpannableStringBuilder builder = FormatCorViewHomeGolsMcdAndNaoMcdRecyclerView.formatTextHomeNaoMarcou(mercado,
                    homeTeam, Math.round((homeGolsTotalSegundoTempoZeroCincoNaoMarcados * 100.0 / jogosCasa)), homeGolsTotalSegundoTempoZeroCincoNaoMarcados,
                    jogosCasa);
            // Adiciona à lista, assumindo que resultadosCasa pode aceitar CharSequence ou SpannableStringBuilder
            resultadosCasa.add(builder);
        }


        if (Math.round(homeGolsTotalSegundoTempoUmCincoMarcados * 100.0 / jogosCasa) >= porcentagem){
            String mercado = "homeGolsTotalSegundoTempoUmCincoMarcados";
            // Cria o SpannableStringBuilder com as cores formatadas
            SpannableStringBuilder builder = FormatCorViewHomeGolsMcdAndNaoMcdRecyclerView.formatTextHomeMarcou(mercado,
                    homeTeam, Math.round((homeGolsTotalSegundoTempoUmCincoMarcados * 100.0 / jogosCasa)), homeGolsTotalSegundoTempoUmCincoMarcados,
                    jogosCasa);
            // Adiciona à lista, assumindo que resultadosCasa pode aceitar CharSequence ou SpannableStringBuilder
            resultadosCasa.add(builder);
        }

        if (Math.round(homeGolsTotalSegundoTempoUmCincoNaoMarcados * 100.0 / jogosCasa) >= porcentagem){
            String mercado = "homeGolsTotalSegundoTempoUmCincoNaoMarcados";
            // Cria o SpannableStringBuilder com as cores formatadas
            SpannableStringBuilder builder = FormatCorViewHomeGolsMcdAndNaoMcdRecyclerView.formatTextHomeNaoMarcou(mercado,
                    homeTeam, Math.round((homeGolsTotalSegundoTempoUmCincoNaoMarcados * 100.0 / jogosCasa)), homeGolsTotalSegundoTempoUmCincoNaoMarcados,
                    jogosCasa);
            // Adiciona à lista, assumindo que resultadosCasa pode aceitar CharSequence ou SpannableStringBuilder
            resultadosCasa.add(builder);

        }


        if (Math.round(homeGolsTotalSegundoTempoDoisCincoMarcados * 100 / jogosCasa) >= porcentagem){
            String mercado = "homeGolsTotalSegundoTempoDoisCincoMarcados";
            // Cria o SpannableStringBuilder com as cores formatadas
            SpannableStringBuilder builder = FormatCorViewHomeGolsMcdAndNaoMcdRecyclerView.formatTextHomeMarcou(mercado,
                    homeTeam, Math.round((homeGolsTotalSegundoTempoDoisCincoMarcados * 100.0 / jogosCasa)), homeGolsTotalSegundoTempoDoisCincoMarcados,
                    jogosCasa);
            // Adiciona à lista, assumindo que resultadosCasa pode aceitar CharSequence ou SpannableStringBuilder
            resultadosCasa.add(builder);
        }

        if (Math.round(homeGolsTotalSegundoTempoDoisCincoNaoMarcados * 100.0 / jogosCasa) >= porcentagem){
            String mercado = "homeGolsTotalSegundoTempoDoisCincoNaoMarcados";
            // Cria o SpannableStringBuilder com as cores formatadas
            SpannableStringBuilder builder = FormatCorViewHomeGolsMcdAndNaoMcdRecyclerView.formatTextHomeNaoMarcou(mercado,
                    homeTeam, Math.round((homeGolsTotalSegundoTempoDoisCincoNaoMarcados * 100.0 / jogosCasa)), homeGolsTotalSegundoTempoDoisCincoNaoMarcados,
                    jogosCasa);
            // Adiciona à lista, assumindo que resultadosCasa pode aceitar CharSequence ou SpannableStringBuilder
            resultadosCasa.add(builder);
        }




//        //GOLS ACIMA MARCADOS

        if (Math.round(homeGolsTotalZeroCincoMarcados * 100 / jogosCasa) >= porcentagem) {
            String mercado = "homeGolsTotalZeroCincoMarcados";
            // Cria o SpannableStringBuilder com as cores formatadas
            SpannableStringBuilder builder = FormatCorViewHomeGolsMcdAndNaoMcdRecyclerView.formatTextHomeMarcou(mercado,
                    homeTeam.toUpperCase(), Math.round((homeGolsTotalZeroCincoMarcados * 100.0 / jogosCasa)), homeGolsTotalZeroCincoMarcados,
                    jogosCasa);
            // Adiciona à lista, assumindo que resultadosCasa pode aceitar CharSequence ou SpannableStringBuilder
            resultadosCasa.add(builder);
        }

        if (Math.round(homeGolsTotalZeroCincoNaoMarcados * 100 / jogosCasa) >= porcentagem){
            String mercado = "homeGolsTotalZeroCincoNaoMarcados";
            // Cria o SpannableStringBuilder com as cores formatadas
            SpannableStringBuilder builder = FormatCorViewHomeGolsMcdAndNaoMcdRecyclerView.formatTextHomeNaoMarcou(mercado,
                    homeTeam, Math.round((homeGolsTotalZeroCincoNaoMarcados * 100.0 / jogosCasa)), homeGolsTotalZeroCincoNaoMarcados,
                    jogosCasa);
            // Adiciona à lista, assumindo que resultadosCasa pode aceitar CharSequence ou SpannableStringBuilder
            resultadosCasa.add(builder);
        }


        if (Math.round(homeGolsTotalUmCincoMarcados * 100 / jogosCasa) >= porcentagem){
            String mercado = "homeGolsTotalUmCincoMarcados";
            // Cria o SpannableStringBuilder com as cores formatadas
            SpannableStringBuilder builder = FormatCorViewHomeGolsMcdAndNaoMcdRecyclerView.formatTextHomeMarcou(mercado,
                    homeTeam, Math.round((homeGolsTotalUmCincoMarcados * 100.0 / jogosCasa)), homeGolsTotalUmCincoMarcados,
                    jogosCasa);
            // Adiciona à lista, assumindo que resultadosCasa pode aceitar CharSequence ou SpannableStringBuilder
            resultadosCasa.add(builder);

        }

        if (Math.round(homeGolsTotalUmCincoNaoMarcados * 100 / jogosCasa) >= porcentagem){
            String mercado = "homeGolsTotalUmCincoNaoMarcados";
            // Cria o SpannableStringBuilder com as cores formatadas
            SpannableStringBuilder builder = FormatCorViewHomeGolsMcdAndNaoMcdRecyclerView.formatTextHomeNaoMarcou(mercado,
                    homeTeam, Math.round((homeGolsTotalUmCincoNaoMarcados * 100.0 / jogosCasa)), homeGolsTotalUmCincoNaoMarcados,
                    jogosCasa);
            // Adiciona à lista, assumindo que resultadosCasa pode aceitar CharSequence ou SpannableStringBuilder
            resultadosCasa.add(builder);
        }


        if (Math.round(homeGolsTotalDoisCincoMarcados * 100 / jogosCasa) >= porcentagem){
            String mercado = "homeGolsTotalDoisCincoMarcados";
            SpannableStringBuilder builder = FormatCorViewHomeGolsMcdAndNaoMcdRecyclerView.formatTextHomeMarcou(mercado,
                    homeTeam, Math.round((homeGolsTotalDoisCincoMarcados * 100.0 / jogosCasa)),homeGolsTotalDoisCincoMarcados, jogosCasa);
        }

        if (Math.round(homeGolsTotalDoisCincoNaoMarcados * 100 / jogosCasa) >= porcentagem){
            String mercado = "homeGolsTotalDoisCincoNaoMarcados";
            // Cria o SpannableStringBuilder com as cores formatadas
            SpannableStringBuilder builder = FormatCorViewHomeGolsMcdAndNaoMcdRecyclerView.formatTextHomeNaoMarcou(mercado,
                    homeTeam, Math.round((homeGolsTotalDoisCincoNaoMarcados * 100.0 / jogosCasa)), homeGolsTotalDoisCincoNaoMarcados,
                    jogosCasa);
            // Adiciona à lista, assumindo que resultadosCasa pode aceitar CharSequence ou SpannableStringBuilder
            resultadosCasa.add(builder);
        }


        if (Math.round(homeGolsTotalTresCincoMarcados * 100 / jogosCasa) >= porcentagem){
            String mercado = "homeGolsTotalTresCincoMarcados";
            SpannableStringBuilder builder = FormatCorViewHomeGolsMcdAndNaoMcdRecyclerView.formatTextHomeMarcou(mercado,
                    homeTeam, Math.round((homeGolsTotalTresCincoMarcados * 100.0 / jogosCasa)) ,homeGolsTotalTresCincoMarcados, jogosCasa);
        }

        if (Math.round(homeGolsTotalTresCincoNaoMarcados * 100 / jogosCasa) >= porcentagem){
            String mercado = "homeGolsTotalTresCincoNaoMarcados";
            // Cria o SpannableStringBuilder com as cores formatadas
            SpannableStringBuilder builder = FormatCorViewHomeGolsMcdAndNaoMcdRecyclerView.formatTextHomeNaoMarcou(mercado,
                    homeTeam, Math.round((homeGolsTotalTresCincoNaoMarcados * 100.0 / jogosCasa)), homeGolsTotalTresCincoNaoMarcados,
                    jogosCasa);
            // Adiciona à lista, assumindo que resultadosCasa pode aceitar CharSequence ou SpannableStringBuilder
            resultadosCasa.add(builder);
        }




        //-----------------------------------------------DADOS JOGOS FORA--------------------------------------------------------
        //GOLS 1T CASA SOFRIDOS
        if (Math.round(awayGolsTotalPrimeiroTempoZeroCincoMarcados * 100 / jogosCasa) >= porcentagem){
            String mercado = "awayGolsTotalPrimeiroTempoZeroCincoMarcados";
            SpannableStringBuilder builder = FormatarCoresParaExibicaoAwayGolsMcdRecyclerView.formatTextAwayMarcou(mercado,
                    homeTeam, Math.round((awayGolsTotalPrimeiroTempoZeroCincoMarcados * 100.0 / jogosCasa)) ,awayGolsTotalPrimeiroTempoZeroCincoMarcados, jogosCasa);
            // Adiciona à lista, assumindo que resultadosCasa pode aceitar CharSequence ou SpannableStringBuilder
            resultadosCasa.add(builder);
        }
          //  resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [ SOFREU] Gol 1T > 0.5 em " + Math.round((awayGolsTotalPrimeiroTempoZeroCincoMarcados * 100.0 / jogosCasa)) + "% das" + " partidas(" + awayGolsTotalPrimeiroTempoZeroCincoMarcados +")"+ " de " + jogosCasa );
        if (Math.round(awayGolsTotalPrimeiroTempoZeroCincoNaoMarcados * 100 / jogosCasa) >= porcentagem){
            String mercado = "awayGolsTotalPrimeiroTempoZeroCincoNaoMarcados";
            SpannableStringBuilder builder = FormatarCoresParaExibicaoAwayGolsNaoMcdRecyclerView.formatTextAwayNaoMarcou(mercado,
                    homeTeam, Math.round((awayGolsTotalPrimeiroTempoZeroCincoNaoMarcados * 100.0 / jogosCasa)) ,awayGolsTotalPrimeiroTempoZeroCincoNaoMarcados, jogosCasa);
            // Adiciona à lista, assumindo que resultadosCasa pode aceitar CharSequence ou SpannableStringBuilder
            resultadosCasa.add(builder);
        }
            //resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [NÃO SOFREU] Gol 1T > 0.5 em " + Math.round((awayGolsTotalPrimeiroTempoZeroCincoNaoMarcados * 100.0 / jogosCasa)) + "% das" + " partidas(" + awayGolsTotalPrimeiroTempoZeroCincoNaoMarcados +")"+ " de " + jogosCasa );

        if (Math.round(awayGolsTotalPrimeiroTempoUmCincoMarcados * 100 / jogosCasa) >= porcentagem){
            String mercado = "awayGolsTotalPrimeiroTempoUmCincoMarcados";
            SpannableStringBuilder builder = FormatarCoresParaExibicaoAwayGolsMcdRecyclerView.formatTextAwayMarcou(mercado,
                    homeTeam, Math.round((awayGolsTotalPrimeiroTempoUmCincoMarcados * 100.0 / jogosCasa)) ,awayGolsTotalPrimeiroTempoUmCincoMarcados, jogosCasa);
            // Adiciona à lista, assumindo que resultadosCasa pode aceitar CharSequence ou SpannableStringBuilder
            resultadosCasa.add(builder);
        }
        //    resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [ SOFREU] Gol 1T > 1.5 em " + Math.round((awayGolsTotalPrimeiroTempoUmCincoMarcados * 100.0 / jogosCasa)) + "% das" + " partidas(" + awayGolsTotalPrimeiroTempoUmCincoMarcados +")"+ " de " + jogosCasa );
        if (Math.round(awayGolsTotalPrimeiroTempoUmCincoNaoMarcados * 100 / jogosCasa) >= porcentagem){
            String mercado = "awayGolsTotalPrimeiroTempoUmCincoNaoMarcados";
            SpannableStringBuilder builder = FormatarCoresParaExibicaoAwayGolsNaoMcdRecyclerView.formatTextAwayNaoMarcou(mercado,
                    homeTeam, Math.round((awayGolsTotalPrimeiroTempoUmCincoNaoMarcados * 100.0 / jogosCasa)) ,awayGolsTotalPrimeiroTempoUmCincoNaoMarcados, jogosCasa);
            // Adiciona à lista, assumindo que resultadosCasa pode aceitar CharSequence ou SpannableStringBuilder
            resultadosCasa.add(builder);
        }
           // resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [NÃO SOFREU] Gol 1T > 1.5 em " + Math.round((awayGolsTotalPrimeiroTempoUmCincoNaoMarcados * 100.0 / jogosCasa)) + "% das" + " partidas(" + awayGolsTotalPrimeiroTempoUmCincoNaoMarcados +")"+ " de " + jogosCasa );

        if (Math.round(awayGolsTotalPrimeiroTempoDoisCincoMarcados * 100 / jogosCasa) >= porcentagem){
            String mercado = "awayGolsTotalPrimeiroTempoDoisCincoMarcados";
            SpannableStringBuilder builder = FormatarCoresParaExibicaoAwayGolsMcdRecyclerView.formatTextAwayMarcou(mercado,
                    homeTeam, Math.round((awayGolsTotalPrimeiroTempoDoisCincoMarcados * 100.0 / jogosCasa)) ,awayGolsTotalPrimeiroTempoDoisCincoMarcados, jogosCasa);
            // Adiciona à lista, assumindo que resultadosCasa pode aceitar CharSequence ou SpannableStringBuilder
            resultadosCasa.add(builder);
        }
           // resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [ SOFREU] Gol 1T > 2.5 em " + Math.round((awayGolsTotalPrimeiroTempoDoisCincoMarcados * 100.0 / jogosCasa)) + "% das" + " partidas(" + awayGolsTotalPrimeiroTempoDoisCincoMarcados +")"+ " de " + jogosCasa );
        if (Math.round(awayGolsTotalPrimeiroTempoDoisCincoNaoMarcados * 100 / jogosCasa) >= porcentagem){
            String mercado = "awayGolsTotalPrimeiroTempoDoisCincoNaoMarcados";
            SpannableStringBuilder builder = FormatarCoresParaExibicaoAwayGolsNaoMcdRecyclerView.formatTextAwayNaoMarcou(mercado,
                    homeTeam, Math.round((awayGolsTotalPrimeiroTempoDoisCincoNaoMarcados * 100.0 / jogosCasa)) ,awayGolsTotalPrimeiroTempoDoisCincoNaoMarcados, jogosCasa);
            // Adiciona à lista, assumindo que resultadosCasa pode aceitar CharSequence ou SpannableStringBuilder
            resultadosCasa.add(builder);
        }
           // resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [NÃO SOFREU] Gol 1T > 2.5 em " + Math.round((awayGolsTotalPrimeiroTempoDoisCincoNaoMarcados * 100.0 / jogosCasa)) + "% das" + " partidas(" + awayGolsTotalPrimeiroTempoDoisCincoNaoMarcados +")"+ " de " + jogosCasa );


        //GOLS 2T CASA SOFRIDO
        if (Math.round(awayGolsTotalSegundoTempoZeroCincoMarcados * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [ SOFREU] Gol 2T > 0.5 em " + Math.round((awayGolsTotalSegundoTempoZeroCincoMarcados * 100.0 / jogosCasa)) + "% das" + " partidas(" + awayGolsTotalSegundoTempoZeroCincoMarcados +")"+ " de " + jogosCasa );
        if (Math.round(awayGolsTotalSegundoTempoZeroCincoNaoMarcados * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [NÃO SOFREU] Gol 2T > 0.5 em " + Math.round((awayGolsTotalSegundoTempoZeroCincoNaoMarcados * 100.0 / jogosCasa)) + "% das" + " partidas(" + awayGolsTotalSegundoTempoZeroCincoNaoMarcados +")"+ " de " + jogosCasa );

        if (Math.round(awayGolsTotalSegundoTempoUmCincoMarcados * 100.0 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [ SOFREU] Gol 2T > 1.5 em " + Math.round((awayGolsTotalSegundoTempoUmCincoMarcados * 100.0 / jogosCasa)) + "% das" + " partidas(" + awayGolsTotalSegundoTempoUmCincoMarcados +")"+ " de " + jogosCasa );
        if (Math.round(awayGolsTotalSegundoTempoUmCincoNaoMarcados * 100.0 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [NÃO SOFREU] Gol 2T > 1.5 em " + Math.round((awayGolsTotalSegundoTempoUmCincoNaoMarcados * 100.0 / jogosCasa)) + "% das" + " partidas(" + awayGolsTotalSegundoTempoUmCincoNaoMarcados +")"+ " de " + jogosCasa );

        if (Math.round(awayGolsTotalSegundoTempoDoisCincoMarcados * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [ SOFREU] Gol 2T > 2.5 em " + Math.round((awayGolsTotalSegundoTempoDoisCincoMarcados * 100.0 / jogosCasa)) + "% das" + " partidas(" + awayGolsTotalSegundoTempoDoisCincoMarcados +")"+ " de " + jogosCasa );
        if (Math.round(awayGolsTotalSegundoTempoDoisCincoNaoMarcados * 100.0 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [NÃO SOFREU] Gol 2T > 2.5 em " + (awayGolsTotalSegundoTempoDoisCincoNaoMarcados * 100 / jogosCasa) + "% das" + " partidas(" + awayGolsTotalSegundoTempoDoisCincoNaoMarcados +")"+ " de " + jogosCasa );


        //GOLS ACIMA SOFRIDOS
        if (Math.round(awayGolsTotalZeroCincoMarcados * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [SOFREU] Gol TOTAL > 0.5 em " + Math.round((awayGolsTotalZeroCincoMarcados * 100.0 / jogosCasa)) + "% das" + " partidas(" + awayGolsTotalZeroCincoMarcados +")"+ " de " + jogosCasa );
        if (Math.round(awayGolsTotalZeroCincoNaoMarcados * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [NÃO SOFREU] Gol TOTAL > 0.5 em " + Math.round((awayGolsTotalZeroCincoNaoMarcados * 100.0 / jogosCasa)) + "% das" + " partidas(" + awayGolsTotalZeroCincoNaoMarcados +")"+ " de " + jogosCasa );

        if (Math.round(awayGolsTotalUmCincoMarcados * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [ SOFREU] Gol TOTAL > 1.5 em " + Math.round((awayGolsTotalUmCincoMarcados * 100.0 / jogosCasa)) + "% das" + " partidas(" + awayGolsTotalUmCincoMarcados +")"+ " de " + jogosCasa );
        if (Math.round(awayGolsTotalUmCincoNaoMarcados * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [NÃO SOFREU] Gol TOTAL > 1.5 em " + Math.round((awayGolsTotalUmCincoNaoMarcados * 100.0 / jogosCasa)) + "% das" + " partidas(" + awayGolsTotalUmCincoNaoMarcados +")"+ " de " + jogosCasa );

        if (Math.round(awayGolsTotalDoisCincoMarcados * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [ SOFREU] Gol TOTAL > 2.5 em " + Math.round((awayGolsTotalDoisCincoMarcados * 100.0 / jogosCasa)) + "% das" + " partidas(" + awayGolsTotalDoisCincoMarcados +")"+ " de " + jogosCasa );
        if (Math.round(awayGolsTotalDoisCincoNaoMarcados * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [NÃO SOFREU] Gol TOTAL > 2.5 em " + Math.round((awayGolsTotalDoisCincoNaoMarcados * 100.0 / jogosCasa)) + "% das" + " partidas(" + awayGolsTotalDoisCincoNaoMarcados +")"+ " de " + jogosCasa );

        if (Math.round(awayGolsTotalTresCincoMarcados * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [ SOFREU] Gol TOTAL > 3.5 em " + Math.round((awayGolsTotalTresCincoMarcados * 100.0 / jogosCasa)) + "% das" + " partidas(" + awayGolsTotalTresCincoMarcados +")"+ " de " + jogosCasa );
        if (Math.round(awayGolsTotalTresCincoNaoMarcados * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [NÃO SOFREU] Gol TOTAL > 3.5 em " + Math.round((awayGolsTotalTresCincoNaoMarcados * 100.0 / jogosCasa)) + "% das" + " partidas(" + awayGolsTotalTresCincoNaoMarcados +")"+ " de " + jogosCasa );




        //------------------------CARTÕES CASA -------------------------------------------------------------------

        //CARTÃO 1T AMARELO CASA
        if (Math.round(homeAmareloPrimeiroTempoZeroCincoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [ LEVOU] AMARELO 1T > 0.5 em " + Math.round((homeAmareloPrimeiroTempoZeroCincoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeAmareloPrimeiroTempoZeroCincoMcd +")"+ " de " + jogosCasa );
        if (Math.round(homeAmareloPrimeiroTempoZeroCincoNaoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [NÃO LEVOU] AMARELO 1T > 0.5 em " + Math.round((homeAmareloPrimeiroTempoZeroCincoNaoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeAmareloPrimeiroTempoZeroCincoNaoMcd +")"+ " de " + jogosCasa );

        if (Math.round(homeAmareloPrimeiroTempoUmCincoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [ LEVOU] AMARELO 1T > 1.5 em " + Math.round((homeAmareloPrimeiroTempoUmCincoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeAmareloPrimeiroTempoUmCincoMcd +")"+ " de " + jogosCasa );
        if (Math.round(homeAmareloPrimeiroTempoUmCincoNaoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [NÃO LEVOU] AMARELO 1T > 1.5 em " + Math.round((homeAmareloPrimeiroTempoUmCincoNaoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeAmareloPrimeiroTempoUmCincoNaoMcd +")"+ " de " + jogosCasa );


        //CARTÃO 2T AMARELO CASA
        if (Math.round(homeAmareloSegundoTempoZeroCincoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [ LEVOU] AMARELO 2T > 0.5 em " + Math.round((homeAmareloSegundoTempoZeroCincoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeAmareloSegundoTempoZeroCincoMcd +")"+ " de " + jogosCasa );
        if (Math.round(homeAmareloSegundoTempoZeroCincoNaoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [NÃO LEVOU] AMARELO 2T > 0.5 em " + Math.round((homeAmareloSegundoTempoZeroCincoNaoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeAmareloSegundoTempoZeroCincoNaoMcd +")"+ " de " + jogosCasa );

        if (Math.round(homeAmareloSegundoTempoUmCincoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [ LEVOU] AMARELO 2T > 1.5 em " + Math.round((homeAmareloSegundoTempoUmCincoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeAmareloSegundoTempoUmCincoMcd +")"+ " de " + jogosCasa );
        if (Math.round(homeAmareloSegundoTempoUmCincoNaoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [NÃO LEVOU] AMARELO 2T > 1.5 em " + Math.round((homeAmareloSegundoTempoUmCincoNaoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeAmareloSegundoTempoUmCincoNaoMcd +")"+ " de " + jogosCasa );

        //CARTÃO 1T E 2T VERMELHO
        if (Math.round(homeVermelhoPrimeiroTempoZeroCincoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [ LEVOU] VERMELHO DIRETO 1T > 0.5 em " + Math.round((homeVermelhoPrimeiroTempoZeroCincoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeVermelhoPrimeiroTempoZeroCincoMcd +")"+ " de " + jogosCasa );
        if (Math.round(homeVermelhoPrimeiroTempoZeroCincoNaoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [NÃO LEVOU] VERMELHO DIRETO 1T > 0.5 em " + Math.round((homeVermelhoPrimeiroTempoZeroCincoNaoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeVermelhoPrimeiroTempoZeroCincoNaoMcd +")"+ " de " + jogosCasa );

        if (Math.round(homeVermelhoSegundoTempoZeroCincoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [ LEVOU] VERMELHO DIRETO 2T > 0.5 em " + Math.round((homeVermelhoSegundoTempoZeroCincoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeVermelhoSegundoTempoZeroCincoMcd +")"+ " de " + jogosCasa );
        if (Math.round(homeVermelhoSegundoTempoZeroCincoNaoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [NÃO LEVOU] VERMELHO DIRETO 2T > 0.5 em " + Math.round((homeVermelhoSegundoTempoZeroCincoNaoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeVermelhoSegundoTempoZeroCincoNaoMcd +")"+ " de " + jogosCasa );


        //CARTÕES ACIMA TOTAL
        if (Math.round(homeAmareloVermelhoTotalZeroCincoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [LEVOU] AMARELO E/OU VERMELHO TOTAL > 0.5 em " + Math.round((homeAmareloVermelhoTotalZeroCincoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeAmareloVermelhoTotalZeroCincoMcd +")"+ " de " + jogosCasa );
        if (Math.round(homeAmareloVermelhoTotalZeroCincoNaoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [NÃO LEVOU] AMARELO E/OU VERMELHO TOTAL > 0.5 em " + Math.round((homeAmareloVermelhoTotalZeroCincoNaoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeAmareloVermelhoTotalZeroCincoNaoMcd +")"+ " de " + jogosCasa );

        if (Math.round(homeAmareloVermelhoTotalUmCincoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [LEVOU] AMARELO E/OU VERMELHO TOTAL > 1.5 em " + Math.round((homeAmareloVermelhoTotalUmCincoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeAmareloVermelhoTotalUmCincoMcd +")"+ " de " + jogosCasa );
        if (Math.round(homeAmareloVermelhoTotalUmCincoNaoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [NÃO LEVOU] AMARELO E/OU VERMELHO TOTAL > 1.5 em " + Math.round((homeAmareloVermelhoTotalUmCincoNaoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeAmareloVermelhoTotalUmCincoNaoMcd +")"+ " de " + jogosCasa );

        if (Math.round(homeAmareloVermelhoTotalDoisCincoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [LEVOU] AMARELO E/OU VERMELHO TOTAL > 2.5 em " + Math.round((homeAmareloVermelhoTotalDoisCincoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeAmareloVermelhoTotalDoisCincoMcd +")"+ " de " + jogosCasa );
        if (Math.round(homeAmareloVermelhoTotalDoisCincoNaoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [NÃO LEVOU] AMARELO E/OU VERMELHO TOTAL > 2.5 em " + Math.round((homeAmareloVermelhoTotalDoisCincoNaoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeAmareloVermelhoTotalDoisCincoNaoMcd +")"+ " de " + jogosCasa );

        if (Math.round(homeAmareloVermelhoTotalTresCincoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [LEVOU] AMARELO E/OU VERMELHO TOTAL > 3.5 em " + Math.round((homeAmareloVermelhoTotalTresCincoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeAmareloVermelhoTotalTresCincoMcd +")"+ " de " + jogosCasa );
        if (Math.round(homeAmareloVermelhoTotalTresCincoNaoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [NÃO LEVOU] AMARELO E/OU VERMELHO TOTAL > 3.5 em " + Math.round((homeAmareloVermelhoTotalTresCincoNaoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeAmareloVermelhoTotalTresCincoNaoMcd +")"+ " de " + jogosCasa );


        //-----------------------ESCANTEIOS CASA ---------------------------------
        //ESCANTEIOS 1T CASA
        if (Math.round(homeEscanteiosPrimeiroTempoZeroCincoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [ SAIU] ESCANTEIOS 1T > 0.5 em " + Math.round((homeEscanteiosPrimeiroTempoZeroCincoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeEscanteiosPrimeiroTempoZeroCincoMcd +")"+ " de " + jogosCasa );
        if (Math.round(homeEscanteiosPrimeiroTempoZeroCincoNaoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [NÃO SAIU] ESCANTEIOS 1T > 0.5 em " + Math.round((homeEscanteiosPrimeiroTempoZeroCincoNaoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeEscanteiosPrimeiroTempoZeroCincoNaoMcd +")"+ " de " + jogosCasa );

        if (Math.round(homeEscanteiosPrimeiroTempoUmCincoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [ SAIU] ESCANTEIOS 1T > 1.5 em " + Math.round((homeEscanteiosPrimeiroTempoUmCincoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeEscanteiosPrimeiroTempoUmCincoMcd +")"+ " de " + jogosCasa );
        if (Math.round(homeEscanteiosPrimeiroTempoUmCincoNaoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [NÃO SAIU] ESCANTEIOS 1T > 1.5 em " + Math.round((homeEscanteiosPrimeiroTempoUmCincoNaoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeEscanteiosPrimeiroTempoUmCincoNaoMcd +")"+ " de " + jogosCasa );

        if (Math.round(homeEscanteiosPrimeiroTempoDoisCincoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [ SAIU] ESCANTEIOS 1T > 2.5 em " + Math.round((homeEscanteiosPrimeiroTempoDoisCincoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeEscanteiosPrimeiroTempoDoisCincoMcd +")"+ " de " + jogosCasa );
        if (Math.round(homeEscanteiosPrimeiroTempoDoisCincoNaoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [NÃO SAIU] ESCANTEIOS 1T > 2.5 em " + Math.round((homeEscanteiosPrimeiroTempoDoisCincoNaoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeEscanteiosPrimeiroTempoDoisCincoNaoMcd +")"+ " de " + jogosCasa );

        if (Math.round(homeEscanteiosPrimeiroTempoTresCincoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [ SAIU] ESCANTEIOS 1T > 3.5 em " + Math.round((homeEscanteiosPrimeiroTempoTresCincoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeEscanteiosPrimeiroTempoTresCincoMcd +")"+ " de " + jogosCasa );
        if (Math.round(homeEscanteiosPrimeiroTempoTresCincoNaoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [NÃO SAIU] ESCANTEIOS 1T > 3.5 em " + Math.round((homeEscanteiosPrimeiroTempoTresCincoNaoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeEscanteiosPrimeiroTempoTresCincoNaoMcd +")"+ " de " + jogosCasa );


        //ESCANTEIOS 2T CASA
        if (Math.round(homeEscanteiosSegundoTempoZeroCincoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [ SAIU] ESCANTEIOS 2T > 0.5 em " + Math.round((homeEscanteiosSegundoTempoZeroCincoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeEscanteiosSegundoTempoZeroCincoMcd +")"+ " de " + jogosCasa );
        if (Math.round(homeEscanteiosSegundoTempoZeroCincoNaoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [NÃO SAIU] ESCANTEIOS 2T > 0.5 em " + Math.round((homeEscanteiosSegundoTempoZeroCincoNaoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeEscanteiosSegundoTempoZeroCincoNaoMcd +")"+ " de " + jogosCasa );

        if (Math.round(homeEscanteiosSegundoTempoUmCincoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [ SAIU] ESCANTEIOS 2T > 1.5 em " + Math.round((homeEscanteiosSegundoTempoUmCincoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeEscanteiosSegundoTempoUmCincoMcd +")"+ " de " + jogosCasa );
        if (Math.round(homeEscanteiosSegundoTempoUmCincoNaoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [NÃO SAIU] ESCANTEIOS 2T > 1.5 em " + Math.round((homeEscanteiosSegundoTempoUmCincoNaoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeEscanteiosSegundoTempoUmCincoNaoMcd +")"+ " de " + jogosCasa );

        if (Math.round(homeEscanteiosSegundoTempoDoisCincoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [ SAIU] ESCANTEIOS 2T > 2.5 em " + Math.round((homeEscanteiosSegundoTempoDoisCincoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeEscanteiosSegundoTempoDoisCincoMcd +")"+ " de " + jogosCasa );
        if (Math.round(homeEscanteiosSegundoTempoDoisCincoNaoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [NÃO SAIU] ESCANTEIOS 2T > 2.5 em " + Math.round((homeEscanteiosSegundoTempoDoisCincoNaoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeEscanteiosSegundoTempoDoisCincoNaoMcd +")"+ " de " + jogosCasa );

        if (Math.round(homeEscanteiosSegundoTempoTresCincoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [ SAIU] ESCANTEIOS 2T > 3.5 em " + Math.round((homeEscanteiosSegundoTempoTresCincoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeEscanteiosSegundoTempoTresCincoMcd +")"+ " de " + jogosCasa );
        if (Math.round(homeEscanteiosSegundoTempoTresCincoNaoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [NÃO SAIU] ESCANTEIOS 2T > 3.5 em " + Math.round((homeEscanteiosSegundoTempoTresCincoNaoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeEscanteiosSegundoTempoTresCincoNaoMcd +")"+ " de " + jogosCasa );


        //ESCANTEIOS ACIMA TOTAL CASA
        if (Math.round(homeEscanteiosTotalZeroCincoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [SAIU] ESCANTEIOS TOTAL > 0.5 em " + Math.round((homeEscanteiosTotalZeroCincoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeEscanteiosTotalZeroCincoMcd +")"+ " de " + jogosCasa );
        if (Math.round(homeEscanteiosTotalZeroCincoNaoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [NÃO SAIU] ESCANTEIOS TOTAL > 0.5 em " + Math.round((homeEscanteiosTotalZeroCincoNaoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeEscanteiosTotalZeroCincoNaoMcd +")"+ " de " + jogosCasa );

        if (Math.round(homeEscanteiosTotalUmCincoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [SAIU] ESCANTEIOS TOTAL > 1.5 em " + Math.round((homeEscanteiosTotalUmCincoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeEscanteiosTotalUmCincoMcd +")"+ " de " + jogosCasa );
        if (Math.round(homeEscanteiosTotalUmCincoNaoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [NÃO SAIU] ESCANTEIOS TOTAL > 1.5 em " + Math.round((homeEscanteiosTotalUmCincoNaoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeEscanteiosTotalUmCincoNaoMcd +")"+ " de " + jogosCasa );

        if (Math.round(homeEscanteiosTotalDoisCincoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [SAIU] ESCANTEIOS TOTAL > 2.5 em " + Math.round((homeEscanteiosTotalDoisCincoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeEscanteiosTotalDoisCincoMcd +")"+ " de " + jogosCasa );
        if (Math.round(homeEscanteiosTotalDoisCincoNaoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [NÃO SAIU] ESCANTEIOS TOTAL > 2.5 em " + Math.round((homeEscanteiosTotalDoisCincoNaoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeEscanteiosTotalDoisCincoNaoMcd +")"+ " de " + jogosCasa );

        if (Math.round(homeEscanteiosTotalTresCincoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [SAIU] ESCANTEIOS TOTAL > 3.5 em " + Math.round((homeEscanteiosTotalTresCincoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeEscanteiosTotalTresCincoMcd +")"+ " de " + jogosCasa );
        if (Math.round(homeEscanteiosTotalTresCincoNaoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [NÃO SAIU] ESCANTEIOS TOTAL > 3.5 em " + Math.round((homeEscanteiosTotalTresCincoNaoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeEscanteiosTotalTresCincoNaoMcd +")"+ " de " + jogosCasa );

        if (Math.round(homeEscanteiosTotalQuatroCincoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [SAIU] ESCANTEIOS TOTAL > 4.5 em " + Math.round((homeEscanteiosTotalQuatroCincoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeEscanteiosTotalQuatroCincoMcd +")"+ " de " + jogosCasa );
        if (Math.round(homeEscanteiosTotalQuatroCincoNaoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [NÃO SAIU] ESCANTEIOS TOTAL > 4.5 em " + Math.round((homeEscanteiosTotalQuatroCincoNaoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeEscanteiosTotalQuatroCincoNaoMcd +")"+ " de " + jogosCasa );

        if (Math.round(homeEscanteiosTotalCincoCincoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [SAIU] ESCANTEIOS TOTAL > 5.5 em " + Math.round((homeEscanteiosTotalCincoCincoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeEscanteiosTotalCincoCincoMcd +")"+ " de " + jogosCasa );
        if (Math.round(homeEscanteiosTotalCincoCincoNaoMcd * 100 / jogosCasa) >= porcentagem)
            resultadosCasa.add("[ " +homeTeam.toUpperCase() + " CASA ]" +" [NÃO SAIU] ESCANTEIOS TOTAL > 5.5 em " + Math.round((homeEscanteiosTotalCincoCincoNaoMcd * 100.0 / jogosCasa)) + "% das" + " partidas(" + homeEscanteiosTotalCincoCincoNaoMcd +")"+ " de " + jogosCasa );


        Log.i("Ceará", "Resultados: " + resultadosCasa);

        return  resultadosCasa;

    }//fim do método


    public static List<CharSequence> melhoresStatisticasFora(List<PartidaNovoModelo> listTeamAwayCompleto, String team, Integer porcentagem) {

        String awayTeam = team;

        int awayGolsTotalPrimeiroTempoZeroCincoMarcados = 0;
        int awayGolsTotalPrimeiroTempoZeroCincoNaoMarcados = 0;

        int awayGolsTotalPrimeiroTempoUmCincoMarcados = 0;
        int awayGolsTotalPrimeiroTempoUmCincoNaoMarcados = 0;

        int awayGolsTotalPrimeiroTempoDoisCincoMarcados = 0;
        int awayGolsTotalPrimeiroTempoDoisCincoNaoMarcados = 0;

        int awayGolsTotalSegundoTempoZeroCincoMarcados = 0;
        int awayGolsTotalSegundoTempoZeroCincoNaoMarcados = 0;

        int awayGolsTotalSegundoTempoUmCincoMarcados = 0;
        int awayGolsTotalSegundoTempoUmCincoNaoMarcados = 0;

        int awayGolsTotalSegundoTempoDoisCincoMarcados = 0;
        int awayGolsTotalSegundoTempoDoisCincoNaoMarcados = 0;

        int homeGolsTotalPrimeiroTempoZeroCincoMarcados = 0;
        int homeGolsTotalPrimeiroTempoZeroCincoNaoMarcados = 0;

        int homeGolsTotalPrimeiroTempoUmCincoMarcados = 0;
        int homeGolsTotalPrimeiroTempoUmCincoNaoMarcados = 0;

        int homeGolsTotalPrimeiroTempoDoisCincoMarcados = 0;
        int homeGolsTotalPrimeiroTempoDoisCincoNaoMarcados = 0;

        int homeGolsTotalSegundoTempoZeroCincoMarcados = 0;
        int homeGolsTotalSegundoTempoZeroCincoNaoMarcados = 0;

        int homeGolsTotalSegundoTempoUmCincoMarcados = 0;
        int homeGolsTotalSegundoTempoUmCincoNaoMarcados = 0;

        int homeGolsTotalSegundoTempoDoisCincoMarcados = 0;
        int homeGolsTotalSegundoTempoDoisCincoNaoMarcados = 0;


        int awayGolsTotalZeroCincoMarcados = 0;
        int awayGolsTotalZeroCincoNaoMarcados = 0;

        int awayGolsTotalUmCincoMarcados = 0;
        int awayGolsTotalUmCincoNaoMarcados = 0;

        int awayGolsTotalDoisCincoMarcados = 0;
        int awayGolsTotalDoisCincoNaoMarcados = 0;

        int awayGolsTotalTresCincoMarcados = 0;
        int awayGolsTotalTresCincoNaoMarcados = 0;

        int homeGolsTotalZeroCincoMarcados = 0;
        int homeGolsTotalZeroCincoNaoMarcados = 0;

        int homeGolsTotalUmCincoMarcados = 0;
        int homeGolsTotalUmCincoNaoMarcados = 0;

        int homeGolsTotalDoisCincoMarcados = 0;
        int homeGolsTotalDoisCincoNaoMarcados = 0;

        int homeGolsTotalTresCincoMarcados = 0;
        int homeGolsTotalTresCincoNaoMarcados = 0;


        //CARTÕES
        int awayAmareloPrimeiroTempoZeroCincoMcd = 0;
        int awayAmareloPrimeiroTempoZeroCincoNaoMcd = 0;

        int awayAmareloPrimeiroTempoUmCincoMcd = 0;
        int awayAmareloPrimeiroTempoUmCincoNaoMcd = 0;

        int awayAmareloSegundoTempoZeroCincoMcd = 0;
        int awayAmareloSegundoTempoZeroCincoNaoMcd = 0;

        int awayAmareloSegundoTempoUmCincoMcd = 0;
        int awayAmareloSegundoTempoUmCincoNaoMcd = 0;

        int awayVermelhoPrimeiroTempoZeroCincoMcd = 0;
        int awayVermelhoPrimeiroTempoZeroCincoNaoMcd = 0;

        int awayVermelhoSegundoTempoZeroCincoMcd = 0;
        int awayVermelhoSegundoTempoZeroCincoNaoMcd = 0;

        //CARTÕES TOTAIS
        int awayAmareloVermelhoTotalZeroCincoMcd = 0;
        int awayAmareloVermelhoTotalZeroCincoNaoMcd = 0;

        int awayAmareloVermelhoTotalUmCincoMcd = 0;
        int awayAmareloVermelhoTotalUmCincoNaoMcd = 0;

        int awayAmareloVermelhoTotalDoisCincoMcd = 0;
        int awayAmareloVermelhoTotalDoisCincoNaoMcd = 0;

        int awayAmareloVermelhoTotalTresCincoMcd = 0;
        int awayAmareloVermelhoTotalTresCincoNaoMcd = 0;


        //ESCANTEIOS

        //ESCANTEIOS 1T CASA
        int awayEscanteiosPrimeiroTempoZeroCincoMcd = 0;
        int awayEscanteiosPrimeiroTempoZeroCincoNaoMcd = 0;

        int awayEscanteiosPrimeiroTempoUmCincoMcd = 0;
        int awayEscanteiosPrimeiroTempoUmCincoNaoMcd = 0;

        int awayEscanteiosPrimeiroTempoDoisCincoMcd = 0;
        int awayEscanteiosPrimeiroTempoDoisCincoNaoMcd = 0;

        int awayEscanteiosPrimeiroTempoTresCincoMcd = 0;
        int awayEscanteiosPrimeiroTempoTresCincoNaoMcd = 0;

        //ESCANTEIOS 2T CASA
        int awayEscanteiosSegundoTempoZeroCincoMcd = 0;
        int awayEscanteiosSegundoTempoZeroCincoNaoMcd = 0;

        int awayEscanteiosSegundoTempoUmCincoMcd = 0;
        int awayEscanteiosSegundoTempoUmCincoNaoMcd = 0;

        int awayEscanteiosSegundoTempoDoisCincoMcd = 0;
        int awayEscanteiosSegundoTempoDoisCincoNaoMcd = 0;

        int awayEscanteiosSegundoTempoTresCincoMcd = 0;
        int awayEscanteiosSegundoTempoTresCincoNaoMcd = 0;

        //ESCANTEIOS ACIMA TOTAL CASA
        int awayEscanteiosTotalZeroCincoMcd = 0;
        int awayEscanteiosTotalZeroCincoNaoMcd = 0;

        int awayEscanteiosTotalUmCincoMcd = 0;
        int awayEscanteiosTotalUmCincoNaoMcd = 0;

        int awayEscanteiosTotalDoisCincoMcd = 0;
        int awayEscanteiosTotalDoisCincoNaoMcd = 0;

        int awayEscanteiosTotalTresCincoMcd = 0;
        int awayEscanteiosTotalTresCincoNaoMcd = 0;

        int awayEscanteiosTotalQuatroCincoMcd = 0;
        int awayEscanteiosTotalQuatroCincoNaoMcd = 0;

        int awayEscanteiosTotalCincoCincoMcd = 0;
        int awayEscanteiosTotalCincoCincoNaoMcd = 0;

        int jogosFora = 0;

        List<CharSequence> resultadosFora = null;
        for (int i = 0; i < listTeamAwayCompleto.size(); i++) {
            resultadosFora = new ArrayList<>();
            if (listTeamAwayCompleto.get(i).getAwayTime().getName().equals(awayTeam)) {

                //-----------------DADOS GOLS FORA--------------------------------------

                //GOLS 0.5 1°TEMPO
                if (listTeamAwayCompleto.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo() > 0)
                    awayGolsTotalPrimeiroTempoZeroCincoMarcados += 1;
                //GOLS 1.5 1°TEMPO
                if (listTeamAwayCompleto.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo() > 1)
                    awayGolsTotalPrimeiroTempoUmCincoMarcados += 1;
                //GOLS 2.5 1°TEMPO
                if (listTeamAwayCompleto.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo() > 2)
                    awayGolsTotalPrimeiroTempoDoisCincoMarcados += 1;

                //GOLS 0.5 2°TEMPO
                if (listTeamAwayCompleto.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo() > 0)
                    awayGolsTotalSegundoTempoZeroCincoMarcados += 1;
                //GOLS 1.5 2°TEMPO
                if (listTeamAwayCompleto.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo() > 1)
                    awayGolsTotalSegundoTempoUmCincoMarcados += 1;
                //GOLS 2.5 2°TEMPO
                if (listTeamAwayCompleto.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo() > 2)
                    awayGolsTotalSegundoTempoDoisCincoMarcados += 1;


                //GOLS ACIMA 0.5 TEMPO
                if (listTeamAwayCompleto.get(i).getAwayTime().getPlacar() > 0)
                    awayGolsTotalZeroCincoMarcados += 1;

                //GOLS ACIMA 1.5 TEMPO
                if (listTeamAwayCompleto.get(i).getAwayTime().getPlacar() > 1)
                    awayGolsTotalUmCincoMarcados += 1;

                //GOLS ACIMA 2.5 TEMPO
                if (listTeamAwayCompleto.get(i).getAwayTime().getPlacar() > 2)
                    awayGolsTotalDoisCincoMarcados += 1;

                //GOLS ACIMA 3.5 TEMPO
                if (listTeamAwayCompleto.get(i).getAwayTime().getPlacar() > 3)
                    awayGolsTotalTresCincoMarcados += 1;



                //--------------------DADOS GOLS CASA --------------------------------------
                //GOLS 0.5 1°TEMPO
                if (listTeamAwayCompleto.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo() > 0)
                    homeGolsTotalPrimeiroTempoZeroCincoMarcados += 1;
                //GOLS 1.5 1°TEMPO
                if (listTeamAwayCompleto.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo() > 1)
                    homeGolsTotalPrimeiroTempoUmCincoMarcados += 1;
                //GOLS 2.5 1°TEMPO
                if (listTeamAwayCompleto.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo() > 2)
                    homeGolsTotalPrimeiroTempoDoisCincoMarcados += 1;

                //GOLS 0.5 2°TEMPO
                if (listTeamAwayCompleto.get(i).getHomeEstatisticaJogo().getGolsSegundoTempo() > 0)
                    homeGolsTotalSegundoTempoZeroCincoMarcados += 1;
                //GOLS 1.5 2°TEMPO
                if (listTeamAwayCompleto.get(i).getHomeEstatisticaJogo().getGolsSegundoTempo() > 1)
                    homeGolsTotalSegundoTempoUmCincoMarcados += 1;
                //GOLS 2.5 2°TEMPO
                if (listTeamAwayCompleto.get(i).getHomeEstatisticaJogo().getGolsSegundoTempo() > 2)
                    homeGolsTotalSegundoTempoDoisCincoMarcados += 1;


                //GOLS ACIMA 0.5 TEMPO
                if (listTeamAwayCompleto.get(i).getHomeTime().getPlacar() > 0)
                    homeGolsTotalZeroCincoMarcados += 1;

                //GOLS ACIMA 1.5 TEMPO
                if (listTeamAwayCompleto.get(i).getHomeTime().getPlacar() > 1)
                    homeGolsTotalUmCincoMarcados += 1;

                //GOLS ACIMA 2.5 TEMPO
                if (listTeamAwayCompleto.get(i).getHomeTime().getPlacar() > 2)
                    homeGolsTotalDoisCincoMarcados += 1;

                //GOLS ACIMA 3.5 TEMPO
                if (listTeamAwayCompleto.get(i).getHomeTime().getPlacar() > 3)
                    homeGolsTotalTresCincoMarcados += 1;



                //---------------------------- CARTOES FORA --------------------------------------------------

                //CARTOES 0.5 1°TEMPO
                if(listTeamAwayCompleto.get(i).getAwayCartoes().getCartaoAmareloPrimeiroTempo() > 0)
                    awayAmareloPrimeiroTempoZeroCincoMcd += 1;

                //CARTOES 1.5 1°TEMPO
                if(listTeamAwayCompleto.get(i).getAwayCartoes().getCartaoAmareloPrimeiroTempo() > 1)
                    awayAmareloPrimeiroTempoUmCincoMcd += 1;

                //CARTOES VERMELHO 0.5 1°TEMPO
                if(listTeamAwayCompleto.get(i).getAwayCartoes().getCartaoVermelhoPrimeiroTempo() > 0)
                    awayVermelhoPrimeiroTempoZeroCincoMcd += 1;

                // ------------------- SEGUNDO TEMPO -----------------------------------------------------------------------

                //CARTOES 0.5 2°TEMPO
                if(listTeamAwayCompleto.get(i).getAwayCartoes().getCartaoAmareloSegundoTempo() > 0)
                    awayAmareloSegundoTempoZeroCincoMcd += 1;

                //CARTOES 1.5 2°TEMPO
                if(listTeamAwayCompleto.get(i).getAwayCartoes().getCartaoAmareloSegundoTempo() > 1)
                    awayAmareloSegundoTempoUmCincoMcd += 1;

                //CARTOES VERMELHO 0.5 2°TEMPO
                if(listTeamAwayCompleto.get(i).getAwayCartoes().getCartaoVermelhoSegundoTempo() > 0)
                    awayVermelhoSegundoTempoZeroCincoMcd += 1;

                //------------------------ CARTOES ACIMA---------------------------------------------------------

                //CARTOES ACIMA 0.5 TEMPO
                if(listTeamAwayCompleto.get(i).getAwayCartoes().getCartaoAmareloPrimeiroTempo() + listTeamAwayCompleto.get(i).getAwayCartoes().getCartaoAmareloSegundoTempo()  + listTeamAwayCompleto.get(i).getAwayCartoes().getCartaoVermelhoPrimeiroTempo() + listTeamAwayCompleto.get(i).getAwayCartoes().getCartaoVermelhoSegundoTempo() > 0)
                    awayAmareloVermelhoTotalZeroCincoMcd += 1;

                //CARTOES ACIMA 1.5 TEMPO
                if(listTeamAwayCompleto.get(i).getAwayCartoes().getCartaoAmareloPrimeiroTempo() + listTeamAwayCompleto.get(i).getAwayCartoes().getCartaoAmareloSegundoTempo()  + listTeamAwayCompleto.get(i).getAwayCartoes().getCartaoVermelhoPrimeiroTempo() + listTeamAwayCompleto.get(i).getAwayCartoes().getCartaoVermelhoSegundoTempo() > 1 )
                    awayAmareloVermelhoTotalUmCincoMcd += 1;

                //CARTOES ACIMA 2.5 TEMPO
                if(listTeamAwayCompleto.get(i).getAwayCartoes().getCartaoAmareloPrimeiroTempo() + listTeamAwayCompleto.get(i).getAwayCartoes().getCartaoAmareloSegundoTempo()  + listTeamAwayCompleto.get(i).getAwayCartoes().getCartaoVermelhoPrimeiroTempo() + listTeamAwayCompleto.get(i).getAwayCartoes().getCartaoVermelhoSegundoTempo() > 2)
                    awayAmareloVermelhoTotalDoisCincoMcd += 1;

                //CARTOES ACIMA 3.5 TEMPO
                if(listTeamAwayCompleto.get(i).getAwayCartoes().getCartaoAmareloPrimeiroTempo() + listTeamAwayCompleto.get(i).getAwayCartoes().getCartaoAmareloSegundoTempo()  + listTeamAwayCompleto.get(i).getAwayCartoes().getCartaoVermelhoPrimeiroTempo() + listTeamAwayCompleto.get(i).getAwayCartoes().getCartaoVermelhoSegundoTempo() > 3)
                    awayAmareloVermelhoTotalTresCincoMcd += 1;


                //------------------------ESCANTEIOS CASA----------------------------------------


                //----------------------------ESCANTEIOS 1T-------------------------------------

                //ESCANTEIOS 0.5 1°TEMPO
                if(listTeamAwayCompleto.get(i).getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() > 0)
                    awayEscanteiosPrimeiroTempoZeroCincoMcd += 1;

                //ESCANTEIOS 1.5 1°TEMPO
                if(listTeamAwayCompleto.get(i).getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() > 1)
                    awayEscanteiosPrimeiroTempoUmCincoMcd += 1;

                //ESCANTEIOS 2.5 1°TEMPO
                if(listTeamAwayCompleto.get(i).getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() > 2)
                    awayEscanteiosPrimeiroTempoDoisCincoMcd += 1;

                //ESCANTEIOS 3.5 1°TEMPO
                if(listTeamAwayCompleto.get(i).getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() > 3)
                    awayEscanteiosPrimeiroTempoTresCincoMcd += 1;


                //---------------------------ESCANTEIOS 2T-------------------------------------
                //ESCANTEIOS 0.5 2°TEMPO
                if(listTeamAwayCompleto.get(i).getAwayEstatisticaJogo().getEscanteioSegundoTempo() > 0)
                    awayEscanteiosSegundoTempoZeroCincoMcd += 1;

                //ESCANTEIOS 1.5 2°TEMPO
                if(listTeamAwayCompleto.get(i).getAwayEstatisticaJogo().getEscanteioSegundoTempo() > 1)
                    awayEscanteiosSegundoTempoUmCincoMcd += 1;

                //ESCANTEIOS 2.5 2°TEMPO
                if(listTeamAwayCompleto.get(i).getAwayEstatisticaJogo().getEscanteioSegundoTempo() > 2)
                    awayEscanteiosSegundoTempoDoisCincoMcd += 1;

                //ESCANTEIOS 3.5 2°TEMPO
                if(listTeamAwayCompleto.get(i).getAwayEstatisticaJogo().getEscanteioSegundoTempo() > 3)
                    awayEscanteiosSegundoTempoTresCincoMcd += 1;

                //---------------------ESCANTEIOS ACIMA CASA -------------------------------------

                //ESCANTEIOS ACIMA 0.5 TEMPO
                if(listTeamAwayCompleto.get(i).getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo()
                        + listTeamAwayCompleto.get(i).getAwayEstatisticaJogo().getEscanteioSegundoTempo() > 0)
                    awayEscanteiosTotalZeroCincoMcd += 1;

                //ESCANTEIOS ACIMA 1.5 TEMPO
                if(listTeamAwayCompleto.get(i).getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo()
                        + listTeamAwayCompleto.get(i).getAwayEstatisticaJogo().getEscanteioSegundoTempo() > 1)
                    awayEscanteiosTotalUmCincoMcd += 1;

                //ESCANTEIOS ACIMA 2.5 TEMPO
                if(listTeamAwayCompleto.get(i).getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() + listTeamAwayCompleto.get(i).getAwayEstatisticaJogo().getEscanteioSegundoTempo() > 2)
                    awayEscanteiosTotalDoisCincoMcd += 1;

                //ESCANTEIOS ACIMA 3.5 TEMPO
                if(listTeamAwayCompleto.get(i).getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() + listTeamAwayCompleto.get(i).getAwayEstatisticaJogo().getEscanteioSegundoTempo() > 3)
                    awayEscanteiosTotalTresCincoMcd += 1;

                //ESCANTEIOS ACIMA 4.5 TEMPO
                if(listTeamAwayCompleto.get(i).getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() + listTeamAwayCompleto.get(i).getAwayEstatisticaJogo().getEscanteioSegundoTempo() > 4)
                    awayEscanteiosTotalQuatroCincoMcd += 1;

                //ESCANTEIOS ACIMA 5.5 TEMPO
                if(listTeamAwayCompleto.get(i).getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() + listTeamAwayCompleto.get(i).getAwayEstatisticaJogo().getEscanteioSegundoTempo() > 5)
                    awayEscanteiosTotalCincoCincoMcd += 1;


                jogosFora += 1;

            }

        }//fim do for ceara

        //-------------------------DADOS JOGOS CASA GOLS--------------------------------------------------------

        //GOLS 1T CASA
        awayGolsTotalPrimeiroTempoZeroCincoNaoMarcados = jogosFora - awayGolsTotalPrimeiroTempoZeroCincoMarcados;
        awayGolsTotalPrimeiroTempoUmCincoNaoMarcados = jogosFora - awayGolsTotalPrimeiroTempoUmCincoMarcados;
        awayGolsTotalPrimeiroTempoDoisCincoNaoMarcados = jogosFora - awayGolsTotalPrimeiroTempoDoisCincoMarcados;

        //GOLS 2T CASA
        awayGolsTotalSegundoTempoZeroCincoNaoMarcados = jogosFora - awayGolsTotalSegundoTempoZeroCincoMarcados;
        awayGolsTotalSegundoTempoUmCincoNaoMarcados = jogosFora - awayGolsTotalSegundoTempoUmCincoMarcados;
        awayGolsTotalSegundoTempoDoisCincoNaoMarcados = jogosFora - awayGolsTotalSegundoTempoDoisCincoMarcados;

        //-------------------------GOLS ACIMA CASA-------------------------------------------------
        awayGolsTotalZeroCincoNaoMarcados = jogosFora - awayGolsTotalZeroCincoMarcados;
        awayGolsTotalUmCincoNaoMarcados = jogosFora - awayGolsTotalUmCincoMarcados;
        awayGolsTotalDoisCincoNaoMarcados = jogosFora - awayGolsTotalDoisCincoMarcados;
        awayGolsTotalTresCincoNaoMarcados = jogosFora - awayGolsTotalTresCincoMarcados;


        //-------------------------DADOS JOGOS FORA GOLS -----------------------------------------------------

        //GOLS 1T FORA
        homeGolsTotalPrimeiroTempoZeroCincoNaoMarcados = jogosFora - homeGolsTotalPrimeiroTempoZeroCincoMarcados;
        homeGolsTotalPrimeiroTempoUmCincoNaoMarcados = jogosFora - homeGolsTotalPrimeiroTempoUmCincoMarcados;
        homeGolsTotalPrimeiroTempoDoisCincoNaoMarcados = jogosFora - homeGolsTotalPrimeiroTempoDoisCincoMarcados;

        //GOLS 2T FORA
        homeGolsTotalSegundoTempoZeroCincoNaoMarcados = jogosFora - homeGolsTotalSegundoTempoZeroCincoMarcados;
        homeGolsTotalSegundoTempoUmCincoNaoMarcados = jogosFora - homeGolsTotalSegundoTempoUmCincoMarcados;
        homeGolsTotalSegundoTempoDoisCincoNaoMarcados = jogosFora - homeGolsTotalSegundoTempoDoisCincoMarcados;

        //-------------------------GOLS ACIMA FORA-------------------------------------------------
        homeGolsTotalZeroCincoNaoMarcados = jogosFora - homeGolsTotalZeroCincoMarcados;
        homeGolsTotalUmCincoNaoMarcados = jogosFora - homeGolsTotalUmCincoMarcados;
        homeGolsTotalDoisCincoNaoMarcados = jogosFora - homeGolsTotalDoisCincoMarcados;
        homeGolsTotalTresCincoNaoMarcados = jogosFora - homeGolsTotalTresCincoMarcados;



        //-----------------------CARTÃO CASA ---------------------------------------------

        //CARTAO 1T CASA
        awayAmareloPrimeiroTempoZeroCincoNaoMcd = jogosFora - awayAmareloPrimeiroTempoZeroCincoMcd;
        awayAmareloPrimeiroTempoUmCincoNaoMcd = jogosFora - awayAmareloPrimeiroTempoUmCincoMcd;
        awayVermelhoPrimeiroTempoZeroCincoNaoMcd = jogosFora - awayVermelhoPrimeiroTempoZeroCincoMcd;

        //CARTAO 2T CASA
        awayAmareloSegundoTempoZeroCincoNaoMcd = jogosFora - awayAmareloSegundoTempoZeroCincoMcd;
        awayAmareloSegundoTempoUmCincoNaoMcd = jogosFora - awayAmareloSegundoTempoUmCincoMcd;
        awayVermelhoSegundoTempoZeroCincoNaoMcd = jogosFora - awayVermelhoSegundoTempoZeroCincoMcd;


        //CARTÕES TOTAIS
        awayAmareloVermelhoTotalZeroCincoNaoMcd = jogosFora - awayAmareloVermelhoTotalZeroCincoMcd;
        awayAmareloVermelhoTotalUmCincoNaoMcd = jogosFora - awayAmareloVermelhoTotalUmCincoMcd;
        awayAmareloVermelhoTotalDoisCincoNaoMcd = jogosFora - awayAmareloVermelhoTotalDoisCincoMcd;
        awayAmareloVermelhoTotalTresCincoNaoMcd = jogosFora - awayAmareloVermelhoTotalTresCincoMcd;


        //----------------------------ESCANTEIOS CASA --------------------------------------------
        //ESCANTEIOS 1T CASA
        awayEscanteiosPrimeiroTempoZeroCincoNaoMcd = jogosFora - awayEscanteiosPrimeiroTempoZeroCincoMcd;
        awayEscanteiosPrimeiroTempoUmCincoNaoMcd = jogosFora - awayEscanteiosPrimeiroTempoUmCincoMcd;
        awayEscanteiosPrimeiroTempoDoisCincoNaoMcd = jogosFora - awayEscanteiosPrimeiroTempoDoisCincoMcd;
        awayEscanteiosPrimeiroTempoTresCincoNaoMcd = jogosFora - awayEscanteiosPrimeiroTempoTresCincoMcd;

        //ESCANTEIOS 2T CASA
        awayEscanteiosSegundoTempoZeroCincoNaoMcd = jogosFora - awayEscanteiosSegundoTempoZeroCincoMcd;
        awayEscanteiosSegundoTempoUmCincoNaoMcd = jogosFora - awayEscanteiosSegundoTempoUmCincoMcd;
        awayEscanteiosSegundoTempoDoisCincoNaoMcd = jogosFora - awayEscanteiosSegundoTempoDoisCincoMcd;
        awayEscanteiosSegundoTempoTresCincoNaoMcd = jogosFora - awayEscanteiosSegundoTempoTresCincoMcd;

        //ESCANTEIOS TOTAL ACIMA CASA
        awayEscanteiosTotalZeroCincoNaoMcd = jogosFora - awayEscanteiosTotalZeroCincoMcd;
        awayEscanteiosTotalUmCincoNaoMcd = jogosFora - awayEscanteiosTotalUmCincoMcd;
        awayEscanteiosTotalDoisCincoNaoMcd = jogosFora - awayEscanteiosTotalDoisCincoMcd;
        awayEscanteiosTotalTresCincoNaoMcd = jogosFora - awayEscanteiosTotalTresCincoMcd;
        awayEscanteiosTotalQuatroCincoNaoMcd = jogosFora - awayEscanteiosTotalQuatroCincoMcd;
        awayEscanteiosTotalCincoCincoNaoMcd = jogosFora - awayEscanteiosTotalCincoCincoMcd;




        //GOLS 1T FORA
        if (Math.round(awayGolsTotalPrimeiroTempoZeroCincoMarcados * 100 / jogosFora) >= porcentagem){
            String mercado = "awayGolsTotalPrimeiroTempoZeroCincoMarcados";
            // Cria o SpannableStringBuilder com as cores formatadas
            SpannableStringBuilder builder = FormatarCoresParaExibicaoAwayGolsMcdRecyclerView.formatTextAwayMarcou(mercado,
                    awayTeam, Math.round((awayGolsTotalPrimeiroTempoZeroCincoMarcados * 100.0 / jogosFora)), awayGolsTotalPrimeiroTempoZeroCincoMarcados,
                    jogosFora);
            // Adiciona à lista, assumindo que resultadosCasa pode aceitar CharSequence ou SpannableStringBuilder
            resultadosFora.add(builder);
        }
          ///  resultadosFora.add("[ " + awayTeam.toUpperCase().toUpperCase() + " FORA ]" +" [ MARCOU] Gol 1T > 0.5 em " + Math.round((awayGolsTotalPrimeiroTempoZeroCincoMarcados * 100.0 / jogosFora)) + "% das" + " partidas(" + awayGolsTotalPrimeiroTempoZeroCincoMarcados +")"+ " de " + jogosFora );
        if (Math.round(awayGolsTotalPrimeiroTempoZeroCincoNaoMarcados * 100 / jogosFora) >= porcentagem){
            String mercado = "awayGolsTotalPrimeiroTempoZeroCincoNaoMarcados";
            // Cria o SpannableStringBuilder com as cores formatadas
            SpannableStringBuilder builder = FormatCorViewHomeGolsMcdAndNaoMcdRecyclerView.formatTextHomeMarcou(mercado,
                    awayTeam, Math.round((awayGolsTotalPrimeiroTempoZeroCincoNaoMarcados * 100.0 / jogosFora)), awayGolsTotalPrimeiroTempoZeroCincoNaoMarcados,
                    jogosFora);
            // Adiciona à lista, assumindo que resultadosCasa pode aceitar CharSequence ou SpannableStringBuilder
            resultadosFora.add(builder);
        }
      //      resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" + " [NÃO MARCOU] Gol 1T > 0.5 em " + Math.round((awayGolsTotalPrimeiroTempoZeroCincoNaoMarcados * 100.0 / jogosFora)) + "% das" + " partidas(" + awayGolsTotalPrimeiroTempoZeroCincoNaoMarcados +")"+ " de " + jogosFora );

        if (Math.round(awayGolsTotalPrimeiroTempoUmCincoMarcados * 100 / jogosFora) >= porcentagem){
            String mercado = "awayGolsTotalPrimeiroTempoUmCincoMarcados";
            // Cria o SpannableStringBuilder com as cores formatadas
            SpannableStringBuilder builder = FormatarCoresParaExibicaoAwayGolsMcdRecyclerView.formatTextAwayMarcou(mercado,
                    awayTeam, Math.round((awayGolsTotalPrimeiroTempoUmCincoMarcados * 100.0 / jogosFora)), awayGolsTotalPrimeiroTempoUmCincoMarcados,
                    jogosFora);
            // Adiciona à lista, assumindo que resultadosCasa pode aceitar CharSequence ou SpannableStringBuilder
            resultadosFora.add(builder);
        }
          //  resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [ MARCOU] Gol 1T > 1.5 em " + Math.round((awayGolsTotalPrimeiroTempoUmCincoMarcados * 100.0 / jogosFora)) + "% das" + " partidas(" + awayGolsTotalPrimeiroTempoUmCincoMarcados +")"+ " de " + jogosFora );
        if (Math.round(awayGolsTotalPrimeiroTempoUmCincoNaoMarcados * 100 / jogosFora) >= porcentagem){
            String mercado = "awayGolsTotalPrimeiroTempoUmCincoNaoMarcados";
            // Cria o SpannableStringBuilder com as cores formatadas
            SpannableStringBuilder builder = FormatCorViewHomeGolsMcdAndNaoMcdRecyclerView.formatTextHomeMarcou(mercado,
                    awayTeam, Math.round((awayGolsTotalPrimeiroTempoUmCincoNaoMarcados * 100.0 / jogosFora)), awayGolsTotalPrimeiroTempoUmCincoNaoMarcados,
                    jogosFora);
            // Adiciona à lista, assumindo que resultadosCasa pode aceitar CharSequence ou SpannableStringBuilder
            resultadosFora.add(builder);
        }
        //    resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO MARCOU] Gol 1T > 1.5 em " + Math.round((awayGolsTotalPrimeiroTempoUmCincoNaoMarcados * 100.0 / jogosFora)) + "% das" + " partidas(" + awayGolsTotalPrimeiroTempoUmCincoNaoMarcados +")"+ " de " + jogosFora );

        if (Math.round(awayGolsTotalPrimeiroTempoDoisCincoMarcados * 100 / jogosFora) >= porcentagem){
            String mercado = "awayGolsTotalPrimeiroTempoDoisCincoMarcados";
            // Cria o SpannableStringBuilder com as cores formatadas
            SpannableStringBuilder builder = FormatarCoresParaExibicaoAwayGolsMcdRecyclerView.formatTextAwayMarcou(mercado,
                    awayTeam, Math.round((awayGolsTotalPrimeiroTempoDoisCincoMarcados * 100.0 / jogosFora)), awayGolsTotalPrimeiroTempoDoisCincoMarcados,
                    jogosFora);
            // Adiciona à lista, assumindo que resultadosCasa pode aceitar CharSequence ou SpannableStringBuilder
            resultadosFora.add(builder);
        }
        //    resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [ MARCOU] Gol 1T > 2.5 em " + Math.round((awayGolsTotalPrimeiroTempoDoisCincoMarcados * 100.0 / jogosFora)) + "% das" + " partidas(" + awayGolsTotalPrimeiroTempoDoisCincoMarcados +")"+ " de " + jogosFora );
        if (Math.round(awayGolsTotalPrimeiroTempoDoisCincoNaoMarcados * 100 / jogosFora) >= porcentagem){
            String mercado = "awayGolsTotalPrimeiroTempoDoisCincoNaoMarcados";
            // Cria o SpannableStringBuilder com as cores formatadas
            SpannableStringBuilder builder = FormatCorViewHomeGolsMcdAndNaoMcdRecyclerView.formatTextHomeMarcou(mercado,
                    awayTeam, Math.round((awayGolsTotalPrimeiroTempoDoisCincoNaoMarcados * 100.0 / jogosFora)), awayGolsTotalPrimeiroTempoDoisCincoNaoMarcados,
                    jogosFora);
            // Adiciona à lista, assumindo que resultadosCasa pode aceitar CharSequence ou SpannableStringBuilder
            resultadosFora.add(builder);
        }
          //  resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO MARCOU] Gol 1T > 2.5 em " + Math.round((awayGolsTotalPrimeiroTempoDoisCincoNaoMarcados * 100.0 / jogosFora)) + "% das" + " partidas(" + awayGolsTotalPrimeiroTempoDoisCincoNaoMarcados +")"+ " de " + jogosFora );


        //GOLS 2T FORA - MARCOU
        if (Math.round(awayGolsTotalSegundoTempoZeroCincoMarcados * 100 / jogosFora) >= porcentagem){
            String mercado = "awayGolsTotalSegundoTempoZeroCincoMarcados";
            // Cria o SpannableStringBuilder com as cores formatadas
            SpannableStringBuilder builder = FormatarCoresParaExibicaoAwayGolsMcdRecyclerView.formatTextAwayMarcou(mercado,
                    awayTeam, Math.round((awayGolsTotalSegundoTempoZeroCincoMarcados * 100.0 / jogosFora)), awayGolsTotalSegundoTempoZeroCincoMarcados,
                    jogosFora);
            // Adiciona à lista, assumindo que resultadosCasa pode aceitar CharSequence ou SpannableStringBuilder
            resultadosFora.add(builder);

        }
        //    resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [MARCOU] Gol 2T > 0.5 em " + Math.round((awayGolsTotalSegundoTempoZeroCincoMarcados * 100.0 / jogosFora)) + "% das" + " partidas(" + awayGolsTotalSegundoTempoZeroCincoMarcados +")"+ " de " + jogosFora );
        if (Math.round(awayGolsTotalSegundoTempoZeroCincoNaoMarcados * 100 / jogosFora) >= porcentagem){

        }
        //   resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO MARCOU] Gol 2T > 0.5 em " + Math.round((awayGolsTotalSegundoTempoZeroCincoNaoMarcados * 100.0 / jogosFora)) + "% das" + " partidas(" + awayGolsTotalSegundoTempoZeroCincoNaoMarcados +")"+ " de " + jogosFora );

        if (Math.round(awayGolsTotalSegundoTempoUmCincoMarcados * 100.0 / jogosFora) >= porcentagem){
            String mercado = "awayGolsTotalSegundoTempoUmCincoMarcados";
            // Cria o SpannableStringBuilder com as cores formatadas
            SpannableStringBuilder builder = FormatarCoresParaExibicaoAwayGolsMcdRecyclerView.formatTextAwayMarcou(mercado,
                    awayTeam, Math.round((awayGolsTotalSegundoTempoUmCincoMarcados * 100.0 / jogosFora)), awayGolsTotalSegundoTempoUmCincoMarcados,
                    jogosFora);
            // Adiciona à lista, assumindo que resultadosCasa pode aceitar CharSequence ou SpannableStringBuilder
            resultadosFora.add(builder);

        }
        //   resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [MARCOU] Gol 2T > 1.5 em " + Math.round((awayGolsTotalSegundoTempoUmCincoMarcados * 100.0 / jogosFora)) + "% das" + " partidas(" + awayGolsTotalSegundoTempoUmCincoMarcados +")"+ " de " + jogosFora );
        if (Math.round(awayGolsTotalSegundoTempoUmCincoNaoMarcados * 100.0 / jogosFora) >= porcentagem){

        }
        // resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO MARCOU] Gol 2T > 1.5 em " + Math.round((awayGolsTotalSegundoTempoUmCincoNaoMarcados * 100.0 / jogosFora)) + "% das" + " partidas(" + awayGolsTotalSegundoTempoUmCincoNaoMarcados +")"+ " de " + jogosFora );

        if (Math.round(awayGolsTotalSegundoTempoDoisCincoMarcados * 100 / jogosFora) >= porcentagem){
            String mercado = "awayGolsTotalSegundoTempoDoisCincoMarcados";
            // Cria o SpannableStringBuilder com as cores formatadas
            SpannableStringBuilder builder = FormatarCoresParaExibicaoAwayGolsMcdRecyclerView.formatTextAwayMarcou(mercado,
                    awayTeam, Math.round((awayGolsTotalSegundoTempoDoisCincoMarcados * 100.0 / jogosFora)), awayGolsTotalSegundoTempoDoisCincoMarcados,
                    jogosFora);
            // Adiciona à lista, assumindo que resultadosCasa pode aceitar CharSequence ou SpannableStringBuilder
            resultadosFora.add(builder);

        }
        //   resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [MARCOU] Gol 2T > 2.5 em " + Math.round((awayGolsTotalSegundoTempoDoisCincoMarcados * 100.0 / jogosFora)) + "% das" + " partidas(" + awayGolsTotalSegundoTempoDoisCincoMarcados +")"+ " de " + jogosFora );
        if (Math.round(awayGolsTotalSegundoTempoDoisCincoNaoMarcados * 100.0 / jogosFora) >= porcentagem){

        }
        //   resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO MARCOU] Gol 2T > 2.5 em " + (awayGolsTotalSegundoTempoDoisCincoNaoMarcados * 100 / jogosFora) + "% das" + " partidas(" + awayGolsTotalSegundoTempoDoisCincoNaoMarcados +")"+ " de " + jogosFora );



        //GOLS ACIMA MARCADOS FORA
        if (Math.round(awayGolsTotalZeroCincoMarcados * 100 / jogosFora) >= porcentagem){

        }
        //    resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [MARCOU] Gol TOTAL > 0.5 em " + Math.round((awayGolsTotalZeroCincoMarcados * 100.0 / jogosFora)) + "% das" + " partidas(" + awayGolsTotalZeroCincoMarcados +")"+ " de " + jogosFora );
        if (Math.round(awayGolsTotalZeroCincoNaoMarcados * 100 / jogosFora) >= porcentagem){

        }
        //     resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO MARCOU] Gol TOTAL > 0.5 em " + Math.round((awayGolsTotalZeroCincoNaoMarcados * 100.0 / jogosFora)) + "% das" + " partidas(" + awayGolsTotalZeroCincoNaoMarcados +")"+ " de " + jogosFora );

        if (Math.round(awayGolsTotalUmCincoMarcados * 100 / jogosFora) >= porcentagem){

        }
        //    resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [ MARCOU] Gol TOTAL > 1.5 em " + Math.round((awayGolsTotalUmCincoMarcados * 100.0 / jogosFora)) + "% das" + " partidas(" + awayGolsTotalUmCincoMarcados +")"+ " de " + jogosFora );
        if (Math.round(awayGolsTotalUmCincoNaoMarcados * 100 / jogosFora) >= porcentagem){

        }
        //    resultadosFora.add("[ " +awayTeam.toUpperCase()+ " FORA ]" +" [NÃO MARCOU] Gol TOTAL > 1.5 em " + Math.round((awayGolsTotalUmCincoNaoMarcados * 100.0 / jogosFora)) + "% das" + " partidas(" + awayGolsTotalUmCincoNaoMarcados +")"+ " de " + jogosFora );

        if (Math.round(awayGolsTotalDoisCincoMarcados * 100 / jogosFora) >= porcentagem){

        }
        //    resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [ MARCOU] Gol TOTAL > 2.5 em " + Math.round((awayGolsTotalDoisCincoMarcados * 100.0 / jogosFora)) + "% das" + " partidas(" + awayGolsTotalDoisCincoMarcados +")"+ " de " + jogosFora );
        if (Math.round(awayGolsTotalDoisCincoNaoMarcados * 100 / jogosFora) >= porcentagem){

        }
        //    resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO MARCOU] Gol TOTAL > 2.5 em " + Math.round((awayGolsTotalDoisCincoNaoMarcados * 100.0 / jogosFora)) + "% das" + " partidas(" + awayGolsTotalDoisCincoNaoMarcados +")"+ " de " + jogosFora );

        if (Math.round(awayGolsTotalTresCincoMarcados * 100 / jogosFora) >= porcentagem){

        }
        //     resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [ MARCOU] Gol TOTAL > 3.5 em " + Math.round((awayGolsTotalTresCincoMarcados * 100.0 / jogosFora)) + "% das" + " partidas(" + awayGolsTotalTresCincoMarcados +")"+ " de " + jogosFora );
        if (Math.round(awayGolsTotalTresCincoNaoMarcados * 100 / jogosFora) >= porcentagem){

        }
        //    resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO MARCOU] Gol TOTAL > 3.5 em " + Math.round((awayGolsTotalTresCincoNaoMarcados * 100.0 / jogosFora)) + "% das" + " partidas(" + awayGolsTotalTresCincoNaoMarcados +")"+ " de " + jogosFora );





        //-----------------------------------------------DADOS JOGOS FORA--------------------------------------------------------
        //GOLS 1T CASA SOFRIDOS
        if (Math.round(homeGolsTotalPrimeiroTempoZeroCincoMarcados * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [ SOFREU] Gol 1T > 0.5 em " + Math.round((homeGolsTotalPrimeiroTempoZeroCincoMarcados * 100.0 / jogosFora)) + "% das" + " partidas(" + homeGolsTotalPrimeiroTempoZeroCincoMarcados +")"+ " de " + jogosFora );
        if (Math.round(homeGolsTotalPrimeiroTempoZeroCincoNaoMarcados * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO SOFREU] Gol 1T > 0.5 em " + Math.round((homeGolsTotalPrimeiroTempoZeroCincoNaoMarcados * 100.0 / jogosFora)) + "% das" + " partidas(" + homeGolsTotalPrimeiroTempoZeroCincoNaoMarcados +")"+ " de " + jogosFora );

        if (Math.round(homeGolsTotalPrimeiroTempoUmCincoMarcados * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [ SOFREU] Gol 1T > 1.5 em " + Math.round((homeGolsTotalPrimeiroTempoUmCincoMarcados * 100.0 / jogosFora)) + "% das" + " partidas(" + homeGolsTotalPrimeiroTempoUmCincoMarcados +")"+ " de " + jogosFora );
        if (Math.round(homeGolsTotalPrimeiroTempoUmCincoNaoMarcados * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO SOFREU] Gol 1T > 1.5 em " + Math.round((homeGolsTotalPrimeiroTempoUmCincoNaoMarcados * 100.0 / jogosFora)) + "% das" + " partidas(" + homeGolsTotalPrimeiroTempoUmCincoNaoMarcados +")"+ " de " + jogosFora );

        if (Math.round(homeGolsTotalPrimeiroTempoDoisCincoMarcados * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [ SOFREU] Gol 1T > 2.5 em " + Math.round((homeGolsTotalPrimeiroTempoDoisCincoMarcados * 100.0 / jogosFora)) + "% das" + " partidas(" + homeGolsTotalPrimeiroTempoDoisCincoMarcados +")"+ " de " + jogosFora );
        if (Math.round(homeGolsTotalPrimeiroTempoDoisCincoNaoMarcados * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO SOFREU] Gol 1T > 2.5 em " + Math.round((homeGolsTotalPrimeiroTempoDoisCincoNaoMarcados * 100.0 / jogosFora)) + "% das" + " partidas(" + homeGolsTotalPrimeiroTempoDoisCincoNaoMarcados +")"+ " de " + jogosFora );


        //GOLS 2T CASA SOFRIDO
        if (Math.round(homeGolsTotalSegundoTempoZeroCincoMarcados * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [ SOFREU] Gol 2T > 0.5 em " + Math.round((homeGolsTotalSegundoTempoZeroCincoMarcados * 100.0 / jogosFora)) + "% das" + " partidas(" + homeGolsTotalSegundoTempoZeroCincoMarcados +")"+ " de " + jogosFora );
        if (Math.round(homeGolsTotalSegundoTempoZeroCincoNaoMarcados * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO SOFREU] Gol 2T > 0.5 em " + Math.round((homeGolsTotalSegundoTempoZeroCincoNaoMarcados * 100.0 / jogosFora)) + "% das" + " partidas(" + homeGolsTotalSegundoTempoZeroCincoNaoMarcados +")"+ " de " + jogosFora );

        if (Math.round(homeGolsTotalSegundoTempoUmCincoMarcados * 100.0 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [ SOFREU] Gol 2T > 1.5 em " + Math.round((homeGolsTotalSegundoTempoUmCincoMarcados * 100.0 / jogosFora)) + "% das" + " partidas(" + homeGolsTotalSegundoTempoUmCincoMarcados +")"+ " de " + jogosFora );
        if (Math.round(homeGolsTotalSegundoTempoUmCincoNaoMarcados * 100.0 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO SOFREU] Gol 2T > 1.5 em " + Math.round((homeGolsTotalSegundoTempoUmCincoNaoMarcados * 100.0 / jogosFora)) + "% das" + " partidas(" + homeGolsTotalSegundoTempoUmCincoNaoMarcados +")"+ " de " + jogosFora );

        if (Math.round(homeGolsTotalSegundoTempoDoisCincoMarcados * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [ SOFREU] Gol 2T > 2.5 em " + Math.round((homeGolsTotalSegundoTempoDoisCincoMarcados * 100.0 / jogosFora)) + "% das" + " partidas(" + homeGolsTotalSegundoTempoDoisCincoMarcados +")"+ " de " + jogosFora );
        if (Math.round(homeGolsTotalSegundoTempoDoisCincoNaoMarcados * 100.0 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO SOFREU] Gol 2T > 2.5 em " + (homeGolsTotalSegundoTempoDoisCincoNaoMarcados * 100 / jogosFora) + "% das" + " partidas(" + homeGolsTotalSegundoTempoDoisCincoNaoMarcados +")"+ " de " + jogosFora );


        //GOLS ACIMA SOFRIDOS
        if (Math.round(homeGolsTotalZeroCincoMarcados * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [SOFREU] Gol TOTAL > 0.5 em " + Math.round((homeGolsTotalZeroCincoMarcados * 100.0 / jogosFora)) + "% das" + " partidas(" + homeGolsTotalZeroCincoMarcados +")"+ " de " + jogosFora );
        if (Math.round(homeGolsTotalZeroCincoNaoMarcados * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO SOFREU] Gol TOTAL > 0.5 em " + Math.round((homeGolsTotalZeroCincoNaoMarcados * 100.0 / jogosFora)) + "% das" + " partidas(" + homeGolsTotalZeroCincoNaoMarcados +")"+ " de " + jogosFora );

        if (Math.round(homeGolsTotalUmCincoMarcados * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [ SOFREU] Gol TOTAL > 1.5 em " + Math.round((homeGolsTotalUmCincoMarcados * 100.0 / jogosFora)) + "% das" + " partidas(" + homeGolsTotalUmCincoMarcados +")"+ " de " + jogosFora );
        if (Math.round(homeGolsTotalUmCincoNaoMarcados * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO SOFREU] Gol TOTAL > 1.5 em " + Math.round((homeGolsTotalUmCincoNaoMarcados * 100.0 / jogosFora)) + "% das" + " partidas(" + homeGolsTotalUmCincoNaoMarcados +")"+ " de " + jogosFora );

        if (Math.round(homeGolsTotalDoisCincoMarcados * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [ SOFREU] Gol TOTAL > 2.5 em " + Math.round((homeGolsTotalDoisCincoMarcados * 100.0 / jogosFora)) + "% das" + " partidas(" + homeGolsTotalDoisCincoMarcados +")"+ " de " + jogosFora );
        if (Math.round(homeGolsTotalDoisCincoNaoMarcados * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO SOFREU] Gol TOTAL > 2.5 em " + Math.round((homeGolsTotalDoisCincoNaoMarcados * 100.0 / jogosFora)) + "% das" + " partidas(" + homeGolsTotalDoisCincoNaoMarcados +")"+ " de " + jogosFora );

        if (Math.round(homeGolsTotalTresCincoMarcados * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [ SOFREU] Gol TOTAL > 3.5 em " + Math.round((homeGolsTotalTresCincoMarcados * 100.0 / jogosFora)) + "% das" + " partidas(" + homeGolsTotalTresCincoMarcados +")"+ " de " + jogosFora );
        if (Math.round(homeGolsTotalTresCincoNaoMarcados * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO SOFREU] Gol TOTAL > 3.5 em " + Math.round((homeGolsTotalTresCincoNaoMarcados * 100.0 / jogosFora)) + "% das" + " partidas(" + homeGolsTotalTresCincoNaoMarcados +")"+ " de " + jogosFora );




        //------------------------CARTÕES CASA -------------------------------------------------------------------

        //CARTÃO 1T AMARELO CASA
        if (Math.round(awayAmareloPrimeiroTempoZeroCincoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [ LEVOU] AMARELO 1T > 0.5 em " + Math.round((awayAmareloPrimeiroTempoZeroCincoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayAmareloPrimeiroTempoZeroCincoMcd +")"+ " de " + jogosFora );
        if (Math.round(awayAmareloPrimeiroTempoZeroCincoNaoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO LEVOU] AMARELO 1T > 0.5 em " + Math.round((awayAmareloPrimeiroTempoZeroCincoNaoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayAmareloPrimeiroTempoZeroCincoNaoMcd +")"+ " de " + jogosFora );

        if (Math.round(awayAmareloPrimeiroTempoUmCincoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [ LEVOU] AMARELO 1T > 1.5 em " + Math.round((awayAmareloPrimeiroTempoUmCincoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayAmareloPrimeiroTempoUmCincoMcd +")"+ " de " + jogosFora );
        if (Math.round(awayAmareloPrimeiroTempoUmCincoNaoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO LEVOU] AMARELO 1T > 1.5 em " + Math.round((awayAmareloPrimeiroTempoUmCincoNaoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayAmareloPrimeiroTempoUmCincoNaoMcd +")"+ " de " + jogosFora );


        //CARTÃO 2T AMARELO CASA
        if (Math.round(awayAmareloSegundoTempoZeroCincoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [ LEVOU] AMARELO 2T > 0.5 em " + Math.round((awayAmareloSegundoTempoZeroCincoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayAmareloSegundoTempoZeroCincoMcd +")"+ " de " + jogosFora );
        if (Math.round(awayAmareloSegundoTempoZeroCincoNaoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO LEVOU] AMARELO 2T > 0.5 em " + Math.round((awayAmareloSegundoTempoZeroCincoNaoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayAmareloSegundoTempoZeroCincoNaoMcd +")"+ " de " + jogosFora );

        if (Math.round(awayAmareloSegundoTempoUmCincoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [ LEVOU] AMARELO 2T > 1.5 em " + Math.round((awayAmareloSegundoTempoUmCincoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayAmareloSegundoTempoUmCincoMcd +")"+ " de " + jogosFora );
        if (Math.round(awayAmareloSegundoTempoUmCincoNaoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO LEVOU] AMARELO 2T > 1.5 em " + Math.round((awayAmareloSegundoTempoUmCincoNaoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayAmareloSegundoTempoUmCincoNaoMcd +")"+ " de " + jogosFora );

        //CARTÃO 1T E 2T VERMELHO
        if (Math.round(awayVermelhoPrimeiroTempoZeroCincoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [ LEVOU] VERMELHO DIRETO 1T > 0.5 em " + Math.round((awayVermelhoPrimeiroTempoZeroCincoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayVermelhoPrimeiroTempoZeroCincoMcd +")"+ " de " + jogosFora );
        if (Math.round(awayVermelhoPrimeiroTempoZeroCincoNaoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO LEVOU] VERMELHO DIRETO 1T > 0.5 em " + Math.round((awayVermelhoPrimeiroTempoZeroCincoNaoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayVermelhoPrimeiroTempoZeroCincoNaoMcd +")"+ " de " + jogosFora );

        if (Math.round(awayVermelhoSegundoTempoZeroCincoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [ LEVOU] VERMELHO DIRETO 2T > 0.5 em " + Math.round((awayVermelhoSegundoTempoZeroCincoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayVermelhoSegundoTempoZeroCincoMcd +")"+ " de " + jogosFora );
        if (Math.round(awayVermelhoSegundoTempoZeroCincoNaoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO LEVOU] VERMELHO DIRETO 2T > 0.5 em " + Math.round((awayVermelhoSegundoTempoZeroCincoNaoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayVermelhoSegundoTempoZeroCincoNaoMcd +")"+ " de " + jogosFora );


        //CARTÕES ACIMA TOTAL
        if (Math.round(awayAmareloVermelhoTotalZeroCincoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [LEVOU] AMARELO E/OU VERMELHO TOTAL > 0.5 em " + Math.round((awayAmareloVermelhoTotalZeroCincoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayAmareloVermelhoTotalZeroCincoMcd +")"+ " de " + jogosFora );
        if (Math.round(awayAmareloVermelhoTotalZeroCincoNaoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO LEVOU] AMARELO E/OU VERMELHO TOTAL > 0.5 em " + Math.round((awayAmareloVermelhoTotalZeroCincoNaoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayAmareloVermelhoTotalZeroCincoNaoMcd +")"+ " de " + jogosFora );

        if (Math.round(awayAmareloVermelhoTotalUmCincoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [LEVOU] AMARELO E/OU VERMELHO TOTAL > 1.5 em " + Math.round((awayAmareloVermelhoTotalUmCincoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayAmareloVermelhoTotalUmCincoMcd +")"+ " de " + jogosFora );
        if (Math.round(awayAmareloVermelhoTotalUmCincoNaoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO LEVOU] AMARELO E/OU VERMELHO TOTAL > 1.5 em " + Math.round((awayAmareloVermelhoTotalUmCincoNaoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayAmareloVermelhoTotalUmCincoNaoMcd +")"+ " de " + jogosFora );

        if (Math.round(awayAmareloVermelhoTotalDoisCincoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [LEVOU] AMARELO E/OU VERMELHO TOTAL > 2.5 em " + Math.round((awayAmareloVermelhoTotalDoisCincoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayAmareloVermelhoTotalDoisCincoMcd +")"+ " de " + jogosFora );
        if (Math.round(awayAmareloVermelhoTotalDoisCincoNaoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO LEVOU] AMARELO E/OU VERMELHO TOTAL > 2.5 em " + Math.round((awayAmareloVermelhoTotalDoisCincoNaoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayAmareloVermelhoTotalDoisCincoNaoMcd +")"+ " de " + jogosFora );

        if (Math.round(awayAmareloVermelhoTotalTresCincoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [LEVOU] AMARELO E/OU VERMELHO TOTAL > 3.5 em " + Math.round((awayAmareloVermelhoTotalTresCincoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayAmareloVermelhoTotalTresCincoMcd +")"+ " de " + jogosFora );
        if (Math.round(awayAmareloVermelhoTotalTresCincoNaoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO LEVOU] AMARELO E/OU VERMELHO TOTAL > 3.5 em " + Math.round((awayAmareloVermelhoTotalTresCincoNaoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayAmareloVermelhoTotalTresCincoNaoMcd +")"+ " de " + jogosFora );


        //-----------------------ESCANTEIOS CASA ---------------------------------
        //ESCANTEIOS 1T CASA
        if (Math.round(awayEscanteiosPrimeiroTempoZeroCincoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [ SAIU] ESCANTEIOS 1T > 0.5 em " + Math.round((awayEscanteiosPrimeiroTempoZeroCincoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayEscanteiosPrimeiroTempoZeroCincoMcd +")"+ " de " + jogosFora );
        if (Math.round(awayEscanteiosPrimeiroTempoZeroCincoNaoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO SAIU] ESCANTEIOS 1T > 0.5 em " + Math.round((awayEscanteiosPrimeiroTempoZeroCincoNaoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayEscanteiosPrimeiroTempoZeroCincoNaoMcd +")"+ " de " + jogosFora );

        if (Math.round(awayEscanteiosPrimeiroTempoUmCincoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [ SAIU] ESCANTEIOS 1T > 1.5 em " + Math.round((awayEscanteiosPrimeiroTempoUmCincoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayEscanteiosPrimeiroTempoUmCincoMcd +")"+ " de " + jogosFora );
        if (Math.round(awayEscanteiosPrimeiroTempoUmCincoNaoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO SAIU] ESCANTEIOS 1T > 1.5 em " + Math.round((awayEscanteiosPrimeiroTempoUmCincoNaoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayEscanteiosPrimeiroTempoUmCincoNaoMcd +")"+ " de " + jogosFora );

        if (Math.round(awayEscanteiosPrimeiroTempoDoisCincoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [ SAIU] ESCANTEIOS 1T > 2.5 em " + Math.round((awayEscanteiosPrimeiroTempoDoisCincoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayEscanteiosPrimeiroTempoDoisCincoMcd +")"+ " de " + jogosFora );
        if (Math.round(awayEscanteiosPrimeiroTempoDoisCincoNaoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO SAIU] ESCANTEIOS 1T > 2.5 em " + Math.round((awayEscanteiosPrimeiroTempoDoisCincoNaoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayEscanteiosPrimeiroTempoDoisCincoNaoMcd +")"+ " de " + jogosFora );

        if (Math.round(awayEscanteiosPrimeiroTempoTresCincoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [ SAIU] ESCANTEIOS 1T > 3.5 em " + Math.round((awayEscanteiosPrimeiroTempoTresCincoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayEscanteiosPrimeiroTempoTresCincoMcd +")"+ " de " + jogosFora );
        if (Math.round(awayEscanteiosPrimeiroTempoTresCincoNaoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO SAIU] ESCANTEIOS 1T > 3.5 em " + Math.round((awayEscanteiosPrimeiroTempoTresCincoNaoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayEscanteiosPrimeiroTempoTresCincoNaoMcd +")"+ " de " + jogosFora );


        //ESCANTEIOS 2T CASA
        if (Math.round(awayEscanteiosSegundoTempoZeroCincoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [ SAIU] ESCANTEIOS 2T > 0.5 em " + Math.round((awayEscanteiosSegundoTempoZeroCincoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayEscanteiosSegundoTempoZeroCincoMcd +")"+ " de " + jogosFora );
        if (Math.round(awayEscanteiosSegundoTempoZeroCincoNaoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO SAIU] ESCANTEIOS 2T > 0.5 em " + Math.round((awayEscanteiosSegundoTempoZeroCincoNaoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayEscanteiosSegundoTempoZeroCincoNaoMcd +")"+ " de " + jogosFora );

        if (Math.round(awayEscanteiosSegundoTempoUmCincoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [ SAIU] ESCANTEIOS 2T > 1.5 em " + Math.round((awayEscanteiosSegundoTempoUmCincoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayEscanteiosSegundoTempoUmCincoMcd +")"+ " de " + jogosFora );
        if (Math.round(awayEscanteiosSegundoTempoUmCincoNaoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO SAIU] ESCANTEIOS 2T > 1.5 em " + Math.round((awayEscanteiosSegundoTempoUmCincoNaoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayEscanteiosSegundoTempoUmCincoNaoMcd +")"+ " de " + jogosFora );

        if (Math.round(awayEscanteiosSegundoTempoDoisCincoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [ SAIU] ESCANTEIOS 2T > 2.5 em " + Math.round((awayEscanteiosSegundoTempoDoisCincoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayEscanteiosSegundoTempoDoisCincoMcd +")"+ " de " + jogosFora );
        if (Math.round(awayEscanteiosSegundoTempoDoisCincoNaoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO SAIU] ESCANTEIOS 2T > 2.5 em " + Math.round((awayEscanteiosSegundoTempoDoisCincoNaoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayEscanteiosSegundoTempoDoisCincoNaoMcd +")"+ " de " + jogosFora );

        if (Math.round(awayEscanteiosSegundoTempoTresCincoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [ SAIU] ESCANTEIOS 2T > 3.5 em " + Math.round((awayEscanteiosSegundoTempoTresCincoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayEscanteiosSegundoTempoTresCincoMcd +")"+ " de " + jogosFora );
        if (Math.round(awayEscanteiosSegundoTempoTresCincoNaoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO SAIU] ESCANTEIOS 2T > 3.5 em " + Math.round((awayEscanteiosSegundoTempoTresCincoNaoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayEscanteiosSegundoTempoTresCincoNaoMcd +")"+ " de " + jogosFora );


        //ESCANTEIOS ACIMA TOTAL CASA
        if (Math.round(awayEscanteiosTotalZeroCincoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [SAIU] ESCANTEIOS TOTAL > 0.5 em " + Math.round((awayEscanteiosTotalZeroCincoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayEscanteiosTotalZeroCincoMcd +")"+ " de " + jogosFora );
        if (Math.round(awayEscanteiosTotalZeroCincoNaoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO SAIU] ESCANTEIOS TOTAL > 0.5 em " + Math.round((awayEscanteiosTotalZeroCincoNaoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayEscanteiosTotalZeroCincoNaoMcd +")"+ " de " + jogosFora );

        if (Math.round(awayEscanteiosTotalUmCincoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [SAIU] ESCANTEIOS TOTAL > 1.5 em " + Math.round((awayEscanteiosTotalUmCincoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayEscanteiosTotalUmCincoMcd +")"+ " de " + jogosFora );
        if (Math.round(awayEscanteiosTotalUmCincoNaoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO SAIU] ESCANTEIOS TOTAL > 1.5 em " + Math.round((awayEscanteiosTotalUmCincoNaoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayEscanteiosTotalUmCincoNaoMcd +")"+ " de " + jogosFora );

        if (Math.round(awayEscanteiosTotalDoisCincoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [SAIU] ESCANTEIOS TOTAL > 2.5 em " + Math.round((awayEscanteiosTotalDoisCincoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayEscanteiosTotalDoisCincoMcd +")"+ " de " + jogosFora );
        if (Math.round(awayEscanteiosTotalDoisCincoNaoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO SAIU] ESCANTEIOS TOTAL > 2.5 em " + Math.round((awayEscanteiosTotalDoisCincoNaoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayEscanteiosTotalDoisCincoNaoMcd +")"+ " de " + jogosFora );

        if (Math.round(awayEscanteiosTotalTresCincoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [SAIU] ESCANTEIOS TOTAL > 3.5 em " + Math.round((awayEscanteiosTotalTresCincoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayEscanteiosTotalTresCincoMcd +")"+ " de " + jogosFora );
        if (Math.round(awayEscanteiosTotalTresCincoNaoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO SAIU] ESCANTEIOS TOTAL > 3.5 em " + Math.round((awayEscanteiosTotalTresCincoNaoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayEscanteiosTotalTresCincoNaoMcd +")"+ " de " + jogosFora );

        if (Math.round(awayEscanteiosTotalQuatroCincoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [SAIU] ESCANTEIOS TOTAL > 4.5 em " + Math.round((awayEscanteiosTotalQuatroCincoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayEscanteiosTotalQuatroCincoMcd +")"+ " de " + jogosFora );
        if (Math.round(awayEscanteiosTotalQuatroCincoNaoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO SAIU] ESCANTEIOS TOTAL > 4.5 em " + Math.round((awayEscanteiosTotalQuatroCincoNaoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayEscanteiosTotalQuatroCincoNaoMcd +")"+ " de " + jogosFora );

        if (Math.round(awayEscanteiosTotalCincoCincoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [SAIU] ESCANTEIOS TOTAL > 5.5 em " + Math.round((awayEscanteiosTotalCincoCincoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayEscanteiosTotalCincoCincoMcd +")"+ " de " + jogosFora );
        if (Math.round(awayEscanteiosTotalCincoCincoNaoMcd * 100 / jogosFora) >= porcentagem)
            resultadosFora.add("[ " +awayTeam.toUpperCase() + " FORA ]" +" [NÃO SAIU] ESCANTEIOS TOTAL > 5.5 em " + Math.round((awayEscanteiosTotalCincoCincoNaoMcd * 100.0 / jogosFora)) + "% das" + " partidas(" + awayEscanteiosTotalCincoCincoNaoMcd +")"+ " de " + jogosFora );


        Log.i("Ceará", "Resultados: " + resultadosFora);

        return  resultadosFora;




    }

}
