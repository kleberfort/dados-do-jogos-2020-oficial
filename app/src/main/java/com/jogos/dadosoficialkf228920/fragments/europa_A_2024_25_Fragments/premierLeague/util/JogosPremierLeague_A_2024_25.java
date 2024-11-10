package com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.premierLeague.util;

import android.util.Log;

import com.jogos.dadosoficialkf228920.data.brasil.serieA.jogos_campeonatos_chamada_api;
import com.jogos.dadosoficialkf228920.fragments.americadosul.argentina.util.JogosLigaProfissional_A2024;
import com.jogos.dadosoficialkf228920.fragments.americadosul.argentina.util.JogosLigaProfissional_A_2024_Listener;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JogosPremierLeague_A_2024_25  {

    private JogosPremierLeague_A_2024_2025_Listener listener;

    private jogos_campeonatos_chamada_api jogos_campeonatos_chamada_api;


    private List<PartidaNovoModelo> astonVillaCasa = new ArrayList<>();
    private List<PartidaNovoModelo> astonVillaFora = new ArrayList<>();

    private List<PartidaNovoModelo> arsenalCasa = new ArrayList<>();
    private List<PartidaNovoModelo> arsenalFora = new ArrayList<>();

    private List<PartidaNovoModelo> brentfordCasa = new ArrayList<>();
    private List<PartidaNovoModelo> brentfordFora = new ArrayList<>();


    private List<PartidaNovoModelo> brightonCasa = new ArrayList<>();
    private List<PartidaNovoModelo> brightonFora = new ArrayList<>();

    private List<PartidaNovoModelo> bournemouthCasa = new ArrayList<>();
    private List<PartidaNovoModelo> bournemouthFora = new ArrayList<>();

    private List<PartidaNovoModelo> chelseaCasa = new ArrayList<>();
    private List<PartidaNovoModelo> chelseaFora = new ArrayList<>();

    private List<PartidaNovoModelo> crystalPalaceCasa = new ArrayList<>();
    private List<PartidaNovoModelo> crystalPalaceFora = new ArrayList<>();

    private List<PartidaNovoModelo> evertonCasa = new ArrayList<>();
    private List<PartidaNovoModelo> evertonFora = new ArrayList<>();

    private List<PartidaNovoModelo> forestCasa = new ArrayList<>();
    private List<PartidaNovoModelo> forestFora = new ArrayList<>();

    private List<PartidaNovoModelo> fulhamCasa = new ArrayList<>();
    private List<PartidaNovoModelo> fulhamFora = new ArrayList<>();

    private List<PartidaNovoModelo> ipswichCasa = new ArrayList<>();
    private List<PartidaNovoModelo> ipswichFora = new ArrayList<>();

    private List<PartidaNovoModelo> leicesterCasa = new ArrayList<>();
    private List<PartidaNovoModelo> leicesterFora = new ArrayList<>();

    private List<PartidaNovoModelo> liverpoolCasa = new ArrayList<>();
    private List<PartidaNovoModelo> liverpoolFora = new ArrayList<>();
    private List<PartidaNovoModelo> manCityCasa = new ArrayList<>();
    private List<PartidaNovoModelo> manCityFora = new ArrayList<>();

    private List<PartidaNovoModelo> manUtdCasa = new ArrayList<>();
    private List<PartidaNovoModelo> manUtdFora = new ArrayList<>();

    private List<PartidaNovoModelo> newcastleCasa = new ArrayList<>();
    private List<PartidaNovoModelo> newcastleFora = new ArrayList<>();
    private List<PartidaNovoModelo> southamptonCasa = new ArrayList<>();
    private List<PartidaNovoModelo> southamptonFora = new ArrayList<>();

    private List<PartidaNovoModelo> tottenhamCasa = new ArrayList<>();
    private List<PartidaNovoModelo> tottenhamFora = new ArrayList<>();

    private List<PartidaNovoModelo> westHamCasa = new ArrayList<>();
    private List<PartidaNovoModelo> westHamFora = new ArrayList<>();

    private List<PartidaNovoModelo> wolvesCasa = new ArrayList<>();
    private List<PartidaNovoModelo> wolvesFora = new ArrayList<>();


    public void setListener(JogosPremierLeague_A_2024_2025_Listener listener) {
        this.listener = listener;
    }


    public void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/refs/heads/master/europa-a-2024-2025/premier-league/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jogos_campeonatos_chamada_api = retrofit.create(jogos_campeonatos_chamada_api.class);
    }

    public void setupDadosJogos() {
        jogos_campeonatos_chamada_api.getPremierLeagueA2024_2025().enqueue(new Callback<List<PartidaNovoModelo>>() {
            @Override
            public void onResponse(Call<List<PartidaNovoModelo>> call, Response<List<PartidaNovoModelo>> response) {


                List<PartidaNovoModelo> partidas = response.body();
                Log.i("Entrou", "JogosSerieA" + partidas);

                //Esse código abaixo, divido as partidas em CASA e fora de cada time

                //Aqui abaixo está a divisão de jogos casa e fora

                for (PartidaNovoModelo partida : partidas) {

                    if (partida.getHomeTime().getName().equals("Aston Villa")) {
                        partida.setDataFormatada(partida.getDate());
                        astonVillaCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("Aston Villa")) {
                        partida.setDataFormatada(partida.getDate());
                        astonVillaFora.add(partida);
                        //Log.i("Data" ,"Data da partida " + partida.getDate());
                        //Log.i("Partida", "partida arsenal fora " + partida.getDataFormatada());
                    }

                    if (partida.getHomeTime().getName().equals("Arsenal")) {
                        partida.setDataFormatada(partida.getDate());
                        arsenalCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("Arsenal")) {
                        partida.setDataFormatada(partida.getDate());
                        arsenalFora.add(partida);
                    }

                    if (partida.getHomeTime().getName().equals("Brentford")) {
                        partida.setDataFormatada(partida.getDate());
                        brentfordCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("Brentford")) {
                        partida.setDataFormatada(partida.getDate());
                        brentfordFora.add(partida);
                    }

                    if (partida.getHomeTime().getName().equals("Brighton")) {
                        partida.setDataFormatada(partida.getDate());
                        brightonCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("Brighton")) {
                        partida.setDataFormatada(partida.getDate());
                        brightonFora.add(partida);
                    }

                    if (partida.getHomeTime().getName().equals("Bournemouth")) {
                        partida.setDataFormatada(partida.getDate());
                        bournemouthCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("Bournemouth")) {
                        partida.setDataFormatada(partida.getDate());
                        bournemouthFora.add(partida);
                    }

                    if (partida.getHomeTime().getName().equals("Chelsea")) {
                        partida.setDataFormatada(partida.getDate());
                        chelseaCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("Chelsea")) {
                        partida.setDataFormatada(partida.getDate());
                        chelseaFora.add(partida);
                    }

                    if (partida.getHomeTime().getName().equals("Crystal Palace")) {
                        partida.setDataFormatada(partida.getDate());
                        crystalPalaceCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("Crystal Palace")) {
                        partida.setDataFormatada(partida.getDate());
                        crystalPalaceFora.add(partida);
                    }

                    if (partida.getHomeTime().getName().equals("Everton")) {
                        partida.setDataFormatada(partida.getDate());
                        evertonCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("Everton")) {
                        partida.setDataFormatada(partida.getDate());
                        evertonFora.add(partida);
                    }

                    if (partida.getHomeTime().getName().equals("Forest")) {
                        partida.setDataFormatada(partida.getDate());
                        forestCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("Forest")) {
                        partida.setDataFormatada(partida.getDate());
                        forestFora.add(partida);
                    }

                    if (partida.getHomeTime().getName().equals("Fulham")) {
                        partida.setDataFormatada(partida.getDate());
                        fulhamCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("Fulham")) {
                        partida.setDataFormatada(partida.getDate());
                        fulhamFora.add(partida);
                    }

                    if (partida.getHomeTime().getName().equals("Ipswich")) {
                        partida.setDataFormatada(partida.getDate());
                        ipswichCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("Ipswich")) {
                        partida.setDataFormatada(partida.getDate());
                        ipswichFora.add(partida);
                    }

                    if (partida.getHomeTime().getName().equals("Leicester")) {
                        partida.setDataFormatada(partida.getDate());
                        leicesterCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("Leicester")) {
                        partida.setDataFormatada(partida.getDate());
                        leicesterFora.add(partida);
                    }
                    if (partida.getHomeTime().getName().equals("Liverpool")) {
                        partida.setDataFormatada(partida.getDate());
                        liverpoolCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("Liverpool")) {
                        partida.setDataFormatada(partida.getDate());
                        liverpoolFora.add(partida);
                    }

                    if (partida.getHomeTime().getName().equals("Man City")) {
                        partida.setDataFormatada(partida.getDate());
                        manCityCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("Man City")) {
                        partida.setDataFormatada(partida.getDate());
                        manCityFora.add(partida);
                    }

                    if (partida.getHomeTime().getName().equals("Man Utd")) {
                        partida.setDataFormatada(partida.getDate());
                        manUtdCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("Man Utd")) {
                        partida.setDataFormatada(partida.getDate());
                        manUtdFora.add(partida);
                    }

                    if (partida.getHomeTime().getName().equals("Newcastle")) {
                        partida.setDataFormatada(partida.getDate());
                        newcastleCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("Newcastle")) {
                        partida.setDataFormatada(partida.getDate());
                        newcastleFora.add(partida);
                    }

                    if (partida.getHomeTime().getName().equals("Southampton")) {
                        partida.setDataFormatada(partida.getDate());
                        southamptonCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("Southampton")) {
                        partida.setDataFormatada(partida.getDate());
                        southamptonFora.add(partida);
                    }

                    if (partida.getHomeTime().getName().equals("Tottenham")) {
                        partida.setDataFormatada(partida.getDate());
                        tottenhamCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("Tottenham")) {
                        partida.setDataFormatada(partida.getDate());
                        tottenhamFora.add(partida);
                    }

                    if (partida.getHomeTime().getName().equals("West Ham")) {
                        partida.setDataFormatada(partida.getDate());
                        westHamCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("West Ham")) {
                        partida.setDataFormatada(partida.getDate());
                        westHamFora.add(partida);
                    }

                    if (partida.getHomeTime().getName().equals("Wolves")) {
                        partida.setDataFormatada(partida.getDate());
                        wolvesCasa.add(partida);
                    }
                    if (partida.getAwayTime().getName().equals("Wolves")) {
                        partida.setDataFormatada(partida.getDate());
                        wolvesFora.add(partida);
                    }

                }

                //Aqui abaixo, agrupo os jogos de cada time, casa e fora e passo esses dados para o Listener
                //Observação: aqui a classe de modelo é diferente, pois aqui tenho todos os dados que recupero

                List<PartidaNovoModelo> astonVillaCompleto = new ArrayList<>();
                astonVillaCompleto.addAll(astonVillaCasa);
                astonVillaCompleto.addAll(astonVillaFora);

                List<PartidaNovoModelo> arsenalCompleto = new ArrayList<>();
                arsenalCompleto.addAll(arsenalCasa);
                arsenalCompleto.addAll(arsenalFora);

                List<PartidaNovoModelo> brentfordCompleto = new ArrayList<>();
                brentfordCompleto.addAll(brentfordCasa);
                brentfordCompleto.addAll(brentfordFora);

                List<PartidaNovoModelo> brightonCompleto = new ArrayList<>();
                brightonCompleto.addAll(brightonCasa);
                brightonCompleto.addAll(brightonFora);

                List<PartidaNovoModelo> bournemouthCompleto = new ArrayList<>();
                bournemouthCompleto.addAll(bournemouthCasa);
                bournemouthCompleto.addAll(bournemouthFora);

                List<PartidaNovoModelo> chelseaCompleto = new ArrayList<>();
                chelseaCompleto.addAll(chelseaCasa);
                chelseaCompleto.addAll(chelseaFora);

                List<PartidaNovoModelo> crystalPalaceCompleto = new ArrayList<>();
                crystalPalaceCompleto.addAll(crystalPalaceCasa);
                crystalPalaceCompleto.addAll(crystalPalaceFora);

                List<PartidaNovoModelo> evertonCompleto = new ArrayList<>();
                evertonCompleto.addAll(evertonCasa);
                evertonCompleto.addAll(evertonFora);

                List<PartidaNovoModelo> forestCompleto = new ArrayList<>();
                forestCompleto.addAll(forestCasa);
                forestCompleto.addAll(forestFora);

                List<PartidaNovoModelo> fulhamCompleto = new ArrayList<>();
                fulhamCompleto.addAll(fulhamCasa);
                fulhamCompleto.addAll(fulhamFora);

                List<PartidaNovoModelo> ipswichCompleto = new ArrayList<>();
                ipswichCompleto.addAll(ipswichCasa);
                ipswichCompleto.addAll(ipswichFora);

                List<PartidaNovoModelo> leicesterCompleto = new ArrayList<>();
                leicesterCompleto.addAll(leicesterCasa);
                leicesterCompleto.addAll(leicesterFora);

                List<PartidaNovoModelo> liverpoolCompleto = new ArrayList<>();
                liverpoolCompleto.addAll(liverpoolCasa);
                liverpoolCompleto.addAll(liverpoolFora);

                List<PartidaNovoModelo> manCityCompleto = new ArrayList<>();
                manCityCompleto.addAll(manCityCasa);
                manCityCompleto.addAll(manCityFora);

                List<PartidaNovoModelo> manUtdCompleto = new ArrayList<>();
                manUtdCompleto.addAll(manUtdCasa);
                manUtdCompleto.addAll(manUtdFora);

                List<PartidaNovoModelo> newcastleCompleto = new ArrayList<>();
                newcastleCompleto.addAll(newcastleCasa);
                newcastleCompleto.addAll(newcastleFora);

                List<PartidaNovoModelo> southamptonCompleto = new ArrayList<>();
                southamptonCompleto.addAll(southamptonCasa);
                southamptonCompleto.addAll(southamptonFora);

                List<PartidaNovoModelo> tottenhamCompleto = new ArrayList<>();
                tottenhamCompleto.addAll(tottenhamCasa);
                tottenhamCompleto.addAll(tottenhamFora);


                List<PartidaNovoModelo> westHamCompleto = new ArrayList<>();
                westHamCompleto.addAll(westHamCasa);
                westHamCompleto.addAll(westHamFora);

                List<PartidaNovoModelo> wolvesCompleto = new ArrayList<>();

                //entendi que voce dividiu a variavel  vitoriaCasa vitoriaFora
                //mas esta adicionadno as duas variavel denteo da variavel vitoriaCompleto //compreendeu ?sim, aqui é onde estou utilizando na classificação a list de cada
                wolvesCompleto.addAll(wolvesCasa);
                wolvesCompleto.addAll(wolvesFora);





                //essa variavel vitoriaCompleto possui os jogos de dentro de casa e fora de casa, correto ?na verdade eu separei

                //Aqui instanciaria o Framente passando a lista desse time, seja ele casa e fora respeinando o fragment que tem q receber?
                //voce pode fazer de varias formas
                ///mas perceba o seguinte todas as informacoes dos times do codigo acima voce esta passando pra onde ?
                //todas as informacoes do time estao indo para o listener abaixo
                //aqui o código ja esta tudo pronto
                //voce obtem todos os dados que vai precisar //jogos do vitoria dentro e fora de casa estao em qual variavel ?


                //Essa Classe dividi todos os jogos dos times, seja ele casa ou fora,
                //Passei aqui um Listener para acessar dentro do meu Frament

//             melhoresStatisticasCasaJogo1(lanusCompleto, "Lanús");
//             melhoresStatisticasForaJogo1(unionSantaFeCompleto,"Union Santa Fe");
//
//             melhoresStatisticasCasaJogo1(centralCordobaCompleto, "Central Córdoba");
//             melhoresStatisticasForaJogo1(institutoCompleto,"Instituto");
//
//             melhoresStatisticasCasaJogo1(riverPlateCompleto, "River Plate");
//             melhoresStatisticasForaJogo1(atleticoTucumanCompleto,"Atl. Tucuman");

//             melhoresStatisticasCasaJogo1(sanLorenzoCompleto, "San Lorenzo");
//             melhoresStatisticasForaJogo1(velezSarsfieldCompleto,"Vélez Sársfield");

//             melhoresStatisticasCasaJogo1(racingCompleto, "Racing");
//            melhoresStatisticasForaJogo1(bocaJuniorsCompleto,"Boca Juniors");
//
//             melhoresStatisticasCasaJogo1(tigreCompleto, "Tigre");
//             melhoresStatisticasForaJogo1(gimnasiaCompleto,"Gimnasia");
//
//             melhoresStatisticasCasaJogo1(belgranoCompleto, "Belgrano");
//             melhoresStatisticasForaJogo1(independienteCompleto,"Independiente");

//             melhoresStatisticasCasaJogo1(godoyCruzCompleto, "Godoy Cruz");
//             melhoresStatisticasForaJogo1(sarmientoCompleto,"Sarmiento");
//
//             melhoresStatisticasCasaJogo1(estudiantesLaPrataCompleto, "Estudiantes");
//             melhoresStatisticasForaJogo1(platenseCompleto,"Platense");
//
//             melhoresStatisticasCasaJogo1(rosarioCentralCompleto, "Rosario");
//             melhoresStatisticasForaJogo1(talleresCompleto,"Talleres");
//
//             melhoresStatisticasCasaJogo1(argentinoJuniorsCompleto, "Argentinos Jrs");
//             melhoresStatisticasForaJogo1(newellOldBoysCompleto,"Newell Old Boys");
//
//             melhoresStatisticasCasaJogo1(barracasCentralCompleto, "Barracas Central");
//             melhoresStatisticasForaJogo1(banfieldCompleto,"Banfield");
//
//             melhoresStatisticasCasaJogo1(independienteRivadaviaCompleto, "Ind. Rivadavia");
//             melhoresStatisticasForaJogo1(defensaJusticiaCompleto,"Def. Justicia");

                if (listener != null) {
                    Log.d("teste jone" ,"2");
                    listener.onJogosPremierLeague_A(astonVillaCompleto, arsenalCompleto,brentfordCompleto, brightonCompleto, bournemouthCompleto, chelseaCompleto, crystalPalaceCompleto, evertonCompleto, forestCompleto
                            , fulhamCompleto, ipswichCompleto, leicesterCompleto, liverpoolCompleto, manCityCompleto, manUtdCompleto,newcastleCompleto,southamptonCompleto,tottenhamCompleto,westHamCompleto,wolvesCompleto);
                    // Chame outros métodos do listener para notificar outras listas, se necessário
                }


                // atleticoPRCasa(atleticoPRCasa);


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
