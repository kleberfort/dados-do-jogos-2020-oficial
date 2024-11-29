package com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.laLiga.util;

import android.util.Log;

import com.jogos.dadosoficialkf228920.data.brasil.serieA.jogos_campeonatos_chamada_api;
import com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.premierLeague.util.JogosPremierLeague_A_2024_2025_Listener;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JogosLaLiga_A_2024_25 {

    private JogosLaLiga_A_2024_2025_Listener listener;

    private jogos_campeonatos_chamada_api jogos_campeonatos_chamada_api;




    private List<PartidaNovoModelo> alavesCasa = new ArrayList<>();
    private List<PartidaNovoModelo> alavesFora = new ArrayList<>();

    private List<PartidaNovoModelo> athleticClubCasa = new ArrayList<>();
    private List<PartidaNovoModelo> athleticClubFora = new ArrayList<>();

    private List<PartidaNovoModelo> atlMadridCasa = new ArrayList<>();
    private List<PartidaNovoModelo> atlMadridFora = new ArrayList<>();


    private List<PartidaNovoModelo> barcelonaCasa = new ArrayList<>();
    private List<PartidaNovoModelo> barcelonaFora = new ArrayList<>();

    private List<PartidaNovoModelo> celtaCasa = new ArrayList<>();
    private List<PartidaNovoModelo> celtaFora = new ArrayList<>();

    private List<PartidaNovoModelo> espanyolCasa = new ArrayList<>();
    private List<PartidaNovoModelo> espanyolFora = new ArrayList<>();

    private List<PartidaNovoModelo> getafeCasa = new ArrayList<>();
    private List<PartidaNovoModelo> getafeFora = new ArrayList<>();

    private List<PartidaNovoModelo> gironaCasa = new ArrayList<>();
    private List<PartidaNovoModelo> gironaFora = new ArrayList<>();

    private List<PartidaNovoModelo> lasPalmasCasa = new ArrayList<>();
    private List<PartidaNovoModelo> lasPalmasFora = new ArrayList<>();

    private List<PartidaNovoModelo> leganesCasa = new ArrayList<>();
    private List<PartidaNovoModelo> leganesFora = new ArrayList<>();

    private List<PartidaNovoModelo> mallorcaCasa = new ArrayList<>();
    private List<PartidaNovoModelo> mallorcaFora = new ArrayList<>();

    private List<PartidaNovoModelo> osasunaCasa = new ArrayList<>();
    private List<PartidaNovoModelo> osasunaFora = new ArrayList<>();

    private List<PartidaNovoModelo> rayoVallecanoCasa = new ArrayList<>();
    private List<PartidaNovoModelo> rayoVallecanoFora = new ArrayList<>();
    private List<PartidaNovoModelo> realBetisCasa = new ArrayList<>();
    private List<PartidaNovoModelo> realBetisFora = new ArrayList<>();

    private List<PartidaNovoModelo> realMadridCasa = new ArrayList<>();
    private List<PartidaNovoModelo> realMadridFora = new ArrayList<>();

    private List<PartidaNovoModelo> realSociedadCasa = new ArrayList<>();
    private List<PartidaNovoModelo> realSociedadFora = new ArrayList<>();
    private List<PartidaNovoModelo> realValladolidCasa = new ArrayList<>();
    private List<PartidaNovoModelo> realValladolidFora = new ArrayList<>();

    private List<PartidaNovoModelo> sevillaCasa = new ArrayList<>();
    private List<PartidaNovoModelo> sevillaFora = new ArrayList<>();

    private List<PartidaNovoModelo> valenciaCasa = new ArrayList<>();
    private List<PartidaNovoModelo> valenciaFora = new ArrayList<>();

    private List<PartidaNovoModelo> villarrealCasa = new ArrayList<>();
    private List<PartidaNovoModelo> villarrealFora = new ArrayList<>();


    public void setListener(JogosLaLiga_A_2024_2025_Listener listener) {
        this.listener = listener;
    }


    public void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/refs/heads/master/europa-a-2024-2025/la-liga/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jogos_campeonatos_chamada_api = retrofit.create(jogos_campeonatos_chamada_api.class);
    }

    public void setupDadosJogos() {

        jogos_campeonatos_chamada_api.getLaLiga2024_25().enqueue(new Callback<List<PartidaNovoModelo>>() {
            @Override
            public void onResponse(Call<List<PartidaNovoModelo>> call, Response<List<PartidaNovoModelo>> response) {
                List<PartidaNovoModelo> partidas = response.body();
                Log.i("Entrou", "JogosSerieA" + partidas);
                for (PartidaNovoModelo partida : partidas) {

                    if (partida.getHomeTime().getName().equals("Alavés")) {
                        partida.setDataFormatada(partida.getDate());
                        alavesCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("Alavés")) {
                        partida.setDataFormatada(partida.getDate());
                        alavesFora.add(partida);
                        //Log.i("Data" ,"Data da partida " + partida.getDate());
                        //Log.i("Partida", "partida arsenal fora " + partida.getDataFormatada());
                    }

                    if (partida.getHomeTime().getName().equals("Athletic Club")) {
                        partida.setDataFormatada(partida.getDate());
                        athleticClubCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("Athletic Club")) {
                        partida.setDataFormatada(partida.getDate());
                        athleticClubFora.add(partida);
                    }

                    if (partida.getHomeTime().getName().equals("Atl. Madrid")) {
                        partida.setDataFormatada(partida.getDate());
                        atlMadridCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("Atl. Madrid")) {
                        partida.setDataFormatada(partida.getDate());
                        atlMadridFora.add(partida);
                    }

                    if (partida.getHomeTime().getName().equals("Barcelona")) {
                        partida.setDataFormatada(partida.getDate());
                        barcelonaCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("Barcelona")) {
                        partida.setDataFormatada(partida.getDate());
                        barcelonaFora.add(partida);
                    }

                    if (partida.getHomeTime().getName().equals("Celta")) {
                        partida.setDataFormatada(partida.getDate());
                        celtaCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("Celta")) {
                        partida.setDataFormatada(partida.getDate());
                        celtaFora.add(partida);
                    }

                    if (partida.getHomeTime().getName().equals("Espanyol")) {
                        partida.setDataFormatada(partida.getDate());
                        espanyolCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("Espanyol")) {
                        partida.setDataFormatada(partida.getDate());
                        espanyolFora.add(partida);
                    }

                    if (partida.getHomeTime().getName().equals("Getafe")) {
                        partida.setDataFormatada(partida.getDate());
                        getafeCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("Getafe")) {
                        partida.setDataFormatada(partida.getDate());
                        getafeFora.add(partida);
                    }

                    if (partida.getHomeTime().getName().equals("Girona")) {
                        partida.setDataFormatada(partida.getDate());
                        gironaCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("Girona")) {
                        partida.setDataFormatada(partida.getDate());
                        gironaFora.add(partida);
                    }

                    if (partida.getHomeTime().getName().equals("Las Palmas")) {
                        partida.setDataFormatada(partida.getDate());
                        lasPalmasCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("Las Palmas")) {
                        partida.setDataFormatada(partida.getDate());
                        lasPalmasFora.add(partida);
                    }

                    if (partida.getHomeTime().getName().equals("Leganés")) {
                        partida.setDataFormatada(partida.getDate());
                        leganesCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("Leganés")) {
                        partida.setDataFormatada(partida.getDate());
                        leganesFora.add(partida);
                    }

                    if (partida.getHomeTime().getName().equals("Mallorca")) {
                        partida.setDataFormatada(partida.getDate());
                        mallorcaCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("Mallorca")) {
                        partida.setDataFormatada(partida.getDate());
                        mallorcaFora.add(partida);
                    }

                    if (partida.getHomeTime().getName().equals("Osasuna")) {
                        partida.setDataFormatada(partida.getDate());
                        osasunaCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("Osasuna")) {
                        partida.setDataFormatada(partida.getDate());
                        osasunaFora.add(partida);
                    }
                    if (partida.getHomeTime().getName().equals("Rayo Vallecano")) {
                        partida.setDataFormatada(partida.getDate());
                        rayoVallecanoCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("Rayo Vallecano")) {
                        partida.setDataFormatada(partida.getDate());
                        rayoVallecanoFora.add(partida);
                    }

                    if (partida.getHomeTime().getName().equals("Real Betis")) {
                        partida.setDataFormatada(partida.getDate());
                        realBetisCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("Real Betis")) {
                        partida.setDataFormatada(partida.getDate());
                        realBetisFora.add(partida);
                    }

                    if (partida.getHomeTime().getName().equals("Real Madrid")) {
                        partida.setDataFormatada(partida.getDate());
                        realMadridCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("Real Madrid")) {
                        partida.setDataFormatada(partida.getDate());
                        realMadridFora.add(partida);
                    }

                    if (partida.getHomeTime().getName().equals("Real Sociedad")) {
                        partida.setDataFormatada(partida.getDate());
                        realSociedadCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("Real Sociedad")) {
                        partida.setDataFormatada(partida.getDate());
                        realSociedadFora.add(partida);
                    }

                    if (partida.getHomeTime().getName().equals("Real Valladolid")) {
                        partida.setDataFormatada(partida.getDate());
                        realValladolidCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("Real Valladolid")) {
                        partida.setDataFormatada(partida.getDate());
                        realValladolidFora.add(partida);
                    }

                    if (partida.getHomeTime().getName().equals("Sevilla")) {
                        partida.setDataFormatada(partida.getDate());
                        sevillaCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("Sevilla")) {
                        partida.setDataFormatada(partida.getDate());
                        sevillaFora.add(partida);
                    }

                    if (partida.getHomeTime().getName().equals("Valencia")) {
                        partida.setDataFormatada(partida.getDate());
                        valenciaCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("Valencia")) {
                        partida.setDataFormatada(partida.getDate());
                        valenciaFora.add(partida);
                    }

                    if (partida.getHomeTime().getName().equals("Villarreal")) {
                        partida.setDataFormatada(partida.getDate());
                        villarrealCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("Villarreal")) {
                        partida.setDataFormatada(partida.getDate());
                        villarrealFora.add(partida);
                    }

                }//fim do for

                //Aqui abaixo, agrupo os jogos de cada time, casa e fora e passo esses dados para o Listener
                //Observação: aqui a classe de modelo é diferente, pois aqui tenho todos os dados que recupero

                List<PartidaNovoModelo> alavesCompleto = new ArrayList<>();
                alavesCompleto.addAll(alavesCasa);
                alavesCompleto.addAll(alavesFora);

                List<PartidaNovoModelo> athleticClubCompleto = new ArrayList<>();
                athleticClubCompleto.addAll(athleticClubCasa);
                athleticClubCompleto.addAll(athleticClubFora);

                List<PartidaNovoModelo> atlMadridCompleto = new ArrayList<>();
                atlMadridCompleto.addAll(atlMadridCasa);
                atlMadridCompleto.addAll(atlMadridFora);

                List<PartidaNovoModelo> barcelonaCompleto = new ArrayList<>();
                barcelonaCompleto.addAll(barcelonaCasa);
                barcelonaCompleto.addAll(barcelonaFora);

                List<PartidaNovoModelo> celtaCompleto = new ArrayList<>();
                celtaCompleto.addAll(celtaCasa);
                celtaCompleto.addAll(celtaFora);

                List<PartidaNovoModelo> espanyolCompleto = new ArrayList<>();
                espanyolCompleto.addAll(espanyolCasa);
                espanyolCompleto.addAll(espanyolFora);

                List<PartidaNovoModelo> getafeCompleto = new ArrayList<>();
                getafeCompleto.addAll(getafeCasa);
                getafeCompleto.addAll(getafeFora);

                List<PartidaNovoModelo> gironaCompleto = new ArrayList<>();
                gironaCompleto.addAll(gironaCasa);
                gironaCompleto.addAll(gironaFora);

                List<PartidaNovoModelo> lasPalmasCompleto = new ArrayList<>();
                lasPalmasCompleto.addAll(lasPalmasCasa);
                lasPalmasCompleto.addAll(lasPalmasFora);

                List<PartidaNovoModelo> leganesCompleto = new ArrayList<>();
                leganesCompleto.addAll(leganesCasa);
                leganesCompleto.addAll(leganesFora);

                List<PartidaNovoModelo> mallorcaCompleto = new ArrayList<>();
                mallorcaCompleto.addAll(mallorcaCasa);
                mallorcaCompleto.addAll(mallorcaFora);

                List<PartidaNovoModelo> osasunaCompleto = new ArrayList<>();
                osasunaCompleto.addAll(osasunaCasa);
                osasunaCompleto.addAll(osasunaFora);

                List<PartidaNovoModelo> rayoVallecanoCompleto = new ArrayList<>();
                rayoVallecanoCompleto.addAll(rayoVallecanoCasa);
                rayoVallecanoCompleto.addAll(rayoVallecanoFora);

                List<PartidaNovoModelo> realBetisCompleto = new ArrayList<>();
                realBetisCompleto.addAll(realBetisCasa);
                realBetisCompleto.addAll(realBetisFora);

                List<PartidaNovoModelo> realMadridCompleto = new ArrayList<>();
                realMadridCompleto.addAll(realMadridCasa);
                realMadridCompleto.addAll(realMadridFora);

                List<PartidaNovoModelo> realSociedadCompleto = new ArrayList<>();
                realSociedadCompleto.addAll(realSociedadCasa);
                realSociedadCompleto.addAll(realSociedadFora);

                List<PartidaNovoModelo> realValladolidCompleto = new ArrayList<>();
                realValladolidCompleto.addAll(realValladolidCasa);
                realValladolidCompleto.addAll(realValladolidFora);

                List<PartidaNovoModelo> sevillaCompleto = new ArrayList<>();
                sevillaCompleto.addAll(sevillaCasa);
                sevillaCompleto.addAll(sevillaFora);


                List<PartidaNovoModelo> valenciaCompleto = new ArrayList<>();
                valenciaCompleto.addAll(valenciaCasa);
                valenciaCompleto.addAll(valenciaFora);

                List<PartidaNovoModelo> villarrealCompleto = new ArrayList<>();

                //entendi que voce dividiu a variavel  vitoriaCasa vitoriaFora
                //mas esta adicionadno as duas variavel denteo da variavel vitoriaCompleto //compreendeu ?sim, aqui é onde estou utilizando na classificação a list de cada
                villarrealCompleto.addAll(villarrealCasa);
                villarrealCompleto.addAll(villarrealFora);


                //essa variavel vitoriaCompleto possui os jogos de dentro de casa e fora de casa, correto ?na verdade eu separei

                //Aqui instanciaria o Framente passando a lista desse time, seja ele casa e fora respeinando o fragment que tem q receber?
                //voce pode fazer de varias formas
                ///mas perceba o seguinte todas as informacoes dos times do codigo acima voce esta passando pra onde ?
                //todas as informacoes do time estao indo para o listener abaixo
                //aqui o código ja esta tudo pronto
                //voce obtem todos os dados que vai precisar //jogos do vitoria dentro e fora de casa estao em qual variavel ?


                //Essa Classe dividi todos os jogos dos times, seja ele casa ou fora,
                //Passei aqui um Listener para acessar dentro do meu Frament


                if (listener != null) {
                    Log.d("teste jone", "2");
                    listener.onJogosLaLiga_A(alavesCompleto, athleticClubCompleto, atlMadridCompleto, barcelonaCompleto, celtaCompleto, espanyolCompleto, getafeCompleto, gironaCompleto, lasPalmasCompleto
                            , leganesCompleto, mallorcaCompleto, osasunaCompleto, rayoVallecanoCompleto, realBetisCompleto, realMadridCompleto, realSociedadCompleto, realValladolidCompleto, sevillaCompleto, valenciaCompleto, villarrealCompleto);
                    // Chame outros métodos do listener para notificar outras listas, se necessário
                }




            //Aqui faço para todas as lista, seja casa e fora
//             Collections.sort(atleticoPRCasa, new ComparatorDatasPartidas());
//             Collections.sort(atleticoPRFora, new ComparatorDatasPartidas());



            }//fim do método onResponse
            @Override
            public void onFailure(Call<List<PartidaNovoModelo>> call, Throwable t) {

            }
        });



    }// fim do método setupDadosDosJogos


}
