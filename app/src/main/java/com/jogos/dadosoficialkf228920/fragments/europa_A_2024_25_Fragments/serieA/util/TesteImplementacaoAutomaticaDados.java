package com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.serieA.util;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.jogos.dadosoficialkf228920.model.EstatisticaCartoes;
import com.jogos.dadosoficialkf228920.model.EstatisticaJogo;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;
import com.jogos.dadosoficialkf228920.model.Time;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TesteImplementacaoAutomaticaDados {

    private JogosSerieAItalia2024_2025_Listener listener;

    private List<PartidaNovoModelo> allMatchTeam;

    private final OkHttpClient client = new OkHttpClient();
    private final OkHttpClient classificacao = new OkHttpClient();
    private final OkHttpClient dadosEstatistico = new OkHttpClient();

    private final ExecutorService executor = Executors.newSingleThreadExecutor(); // Thread para operações de rede


    public void setListener(JogosSerieAItalia2024_2025_Listener listener){
        this.listener = listener;
    }

    public void setupDadosJogos() {
        allMatchTeam = new ArrayList<>();
        executor.execute(() -> { // Executa a tarefa em uma thread separada
            for (int rodada = 0; rodada <= 0; rodada++) {
                String k = String.valueOf(rodada); // Converte o inteiro 'rodada' para String
                String urlSerieAItalia2024_25 = String.format(
                        "https://sportapi7.p.rapidapi.com/api/v1/unique-tournament/23/season/63515/events/round/%s/last/0", k);

                Request request = new Request.Builder()
                        .url(urlSerieAItalia2024_25)
                        .get()
                        .addHeader("x-rapidapi-key", "58b8072752msh548de46c3d61c7ap1b2a99jsn93b7d612311b")
                        .addHeader("x-rapidapi-host", "sportapi7.p.rapidapi.com")
                        .build();

                try (Response response = client.newCall(request).execute()) {
                    if (response.isSuccessful() && response.body() != null) {
                        String jsonResponse = response.body().string();
                        Gson gson = new Gson();
                        JsonObject jsonObject = gson.fromJson(jsonResponse, JsonObject.class);
                        JsonArray events = jsonObject.getAsJsonArray("events");

                        for (int i = 0; i < events.size(); i++) {
                            JsonObject firstEvent = events.get(i).getAsJsonObject();
                            JsonObject status = firstEvent.getAsJsonObject("status");
                            // Verifica se a chave "type" existe no objeto "status" e se o valor é "finished"
                            if (status.has("type") && "finished".equals(status.get("type").getAsString())) {

                                String idPartida = firstEvent.get("id").getAsString();

                                String url = String.format("https://sportapi7.p.rapidapi.com/api/v1/event/%s/pregame-form", idPartida);
                                String urlEstatistica = String.format("https://sportapi7.p.rapidapi.com/api/v1/event/%s/statistics", idPartida);
                                String urlIncidents = String.format("https://sportapi7.p.rapidapi.com/api/v1/event/%s/incidents", idPartida);

                                Request classifica = new Request.Builder()
                                        .url(url)
                                        .get()
                                        .addHeader("x-rapidapi-key", "58b8072752msh548de46c3d61c7ap1b2a99jsn93b7d612311b")
                                        .addHeader("x-rapidapi-host", "sportapi7.p.rapidapi.com")
                                        .build();

                                Request estatistica = new Request.Builder()
                                        .url(urlEstatistica)
                                        .get()
                                        .addHeader("x-rapidapi-key", "58b8072752msh548de46c3d61c7ap1b2a99jsn93b7d612311b")
                                        .addHeader("x-rapidapi-host", "sportapi7.p.rapidapi.com")
                                        .build();

                                Request eventIncident = new Request.Builder()
                                        .url(urlIncidents)
                                        .get()
                                        .addHeader("x-rapidapi-key", "58b8072752msh548de46c3d61c7ap1b2a99jsn93b7d612311b")
                                        .addHeader("x-rapidapi-host", "sportapi7.p.rapidapi.com")
                                        .build();

                                //vai recuperar o nome do torneio e o round
                                JsonObject torneio = firstEvent.getAsJsonObject("tournament");
                                JsonObject round = firstEvent.getAsJsonObject("roundInfo");
                                Long data = firstEvent.get("startTimestamp").getAsLong();

                                // Acessando o time da casa (por exemplo, "homeTeam")
                                JsonObject homeTeam = firstEvent.getAsJsonObject("homeTeam");
                                JsonObject awayTeam = firstEvent.getAsJsonObject("awayTeam");

                                //recupera nomes dos times
                                String home = homeTeam.get("shortName").getAsString();
                                String away = awayTeam.get("shortName").getAsString();

                                //recuperar os placares 1 e 2 tempo
                                Integer homeScore1 = 0;
                                Integer homeScore2 = 0;
                                Integer awayScore1 = 0;
                                Integer awayScore2 = 0;
                                Integer homePlacar;
                                Integer awayPlacar;

                                JsonObject homeScore = firstEvent.getAsJsonObject("homeScore");
                                JsonObject awayScore = firstEvent.getAsJsonObject("awayScore");

                                if (homeScore != null && homeScore.size() > 0) {
                                    homeScore1 = homeScore.get("period1").getAsInt();
                                    homeScore2 = homeScore.get("period2").getAsInt();

                                } else {
                                    // O objeto homeScore está vazio ou a chave "homeScore" não existe
                                    System.out.println("\nPlacar 1T Vazio - " + home + " - " + away);
                                }
                                if (awayScore != null && awayScore.size() > 0) {
                                    awayScore1 = awayScore.get("period1").getAsInt();
                                    awayScore2 = awayScore.get("period2").getAsInt();

                                } else {
                                    // O objeto homeScore está vazio ou a chave "homeScore" não existe
                                    System.out.println("Placar 2T Vazio - " + home + " - " + away);
                                }


                                homePlacar = homeScore1 + homeScore2;
                                awayPlacar = awayScore1 + awayScore2;


                                // Convertendo o timestamp Unix para um objeto Instant
                                Instant instant = Instant.ofEpochSecond(data);
                                // Convertendo o Instant para ZonedDateTime, considerando o fuso horário UTC
                                ZonedDateTime dateTime = instant.atZone(ZoneId.of("UTC"));
                                // Formatando a data no estilo dd/MM/yyyy
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                                //recuperando a data do jogo
                                String formattedDate = dateTime.format(formatter);

                                //recupera o nome do torneio e  round
                                String nomeTorneio = torneio.get("name").getAsString();
                                //qual rodada do campeonato
                                Integer roundInfo = round.get("round").getAsInt();

                                //quando e na primeria rodada ele vem nulo, na requisicao
                                Response response1 = classificacao.newCall(classifica).execute();

                                //recupera a classificacao na primeiro round
                                Integer homeClassificacao = 1;
                                Integer awayClassificacao = 1;

                                //vai retornar a classificacao do time
                                if (response1.isSuccessful()) {
                                    String classificacaoTimes = response1.body().string();
                                    Gson gson1 = new Gson();
                                    JsonObject jsonObject1 = gson1.fromJson(classificacaoTimes, JsonObject.class);

                                    JsonObject homeClassi = jsonObject1.getAsJsonObject("homeTeam");
                                    JsonObject awayClassi = jsonObject1.getAsJsonObject("awayTeam");

                                    //Extraindo a classificação antes do inicio da rodada
                                    homeClassificacao = homeClassi.get("position").getAsInt();
                                    awayClassificacao = awayClassi.get("position").getAsInt();

                                } else {
                                    System.out.println("\n\nERRO: Classificação -> home: " + homeClassificacao + " away: " + awayClassificacao);
                                }

                                // Chamada do método para obter a imagem
                                String imageHome = obterImageData(home);
                                String imageAway = obterImageData(away);


                                Response response2 = dadosEstatistico.newCall(estatistica).execute();
                                // Encadeamento das chamadas para acessar os valores de 'home' e 'away'

                                //recuperar os escanteios
                                Integer escanteioPrimeiroTempoCasa = 0;
                                Integer escanteioPrimeiroTempoFora = 0;

                                Integer escanteioSegundoTempoCasa = 0;
                                Integer escanteioSegundoTempoFora = 0;

                                if (response2.isSuccessful()) {
                                    String dadosTimes = response2.body().string();
                                    Gson gson2 = new Gson();
                                    JsonObject jsonObject2 = gson2.fromJson(dadosTimes, JsonObject.class);

                                    // Verifica se "statistics" existe e tem ao menos 2 elementos
                                    if (jsonObject2.has("statistics") && jsonObject2.getAsJsonArray("statistics").size() > 1) {
                                        JsonArray dadosEscanteiosPrimeiroTempo = jsonObject2.getAsJsonArray("statistics")
                                                .get(1).getAsJsonObject()
                                                .getAsJsonArray("groups")
                                                .get(0).getAsJsonObject()
                                                .getAsJsonArray("statisticsItems");

                                        // Percorre o array para encontrar a chave "cornerKicks"
                                        for (JsonElement element : dadosEscanteiosPrimeiroTempo) {
                                            JsonObject jsonObject6 = element.getAsJsonObject();
                                            if ("cornerKicks".equals(jsonObject6.get("key").getAsString())) {
                                                escanteioPrimeiroTempoCasa = jsonObject6.get("home").getAsInt();
                                                escanteioPrimeiroTempoFora = jsonObject6.get("away").getAsInt();
                                                break; // Sai do loop assim que "cornerKicks" for encontrado
                                            }
                                        }

                                        // Presumindo que você também tenha um JsonArray para o segundo tempo:
                                        JsonArray dadosEscanteiosSegundoTempo = jsonObject2.getAsJsonArray("statistics")
                                                .get(2).getAsJsonObject()
                                                .getAsJsonArray("groups")
                                                .get(0).getAsJsonObject()
                                                .getAsJsonArray("statisticsItems");

                                        // Percorre o array para encontrar a chave "cornerKicks"
                                        for (JsonElement element : dadosEscanteiosSegundoTempo) {
                                            JsonObject jsonObject7 = element.getAsJsonObject();
                                            if ("cornerKicks".equals(jsonObject7.get("key").getAsString())) {
                                                escanteioSegundoTempoCasa = jsonObject7.get("home").getAsInt();
                                                escanteioSegundoTempoFora = jsonObject7.get("away").getAsInt();
                                                break; // Sai do loop assim que "cornerKicks" for encontrado
                                            }
                                        }
                                    } else {
                                        System.out.println("  ESCANTEIOS-> ERRO no jogo do " + home + "  X  " + away);
                                    }


                                } else {
                                    System.out.println("ERRO BUSCA: ESCANTEIOS " + home + " - " + away);
                                }

                                Response response3 = classificacao.newCall(eventIncident).execute();

                                //recuperar os cartoes do time da casa
                                // Variáveis para contar os cartões do time CASA
                                int amarelosCasaPrimeiroTempo = 0;
                                int amarelosCasaSegundoTempo = 0;
                                int vermelhosCasaPrimeiroTempo = 0;
                                int vermelhosCasaSegundoTempo = 0;

                                //recuperar os cartoes do time da fora
                                // Variáveis para contar os cartões time VISITANTE
                                int amarelosVisitantePrimeiroTempo = 0;
                                int amarelosVisitanteSegundoTempo = 0;
                                int vermelhosVisitantePrimeioTempo = 0;
                                int vermelhosVisitanteSegundoTempo = 0;


                                if (response3.isSuccessful()) {
                                    String incidents = response3.body().string();
                                    Gson gson3 = new Gson();
                                    JsonObject jsonObject3 = gson3.fromJson(incidents, JsonObject.class);

                                    JsonArray dadosEvento = jsonObject3.getAsJsonArray("incidents");

                                    for (int l = dadosEvento.size() - 1; l >= 0; l--) {
                                        JsonObject teste2 = dadosEvento.get(l).getAsJsonObject();

                                        // Obtenha os valores de "time", "length", e "incidentType"
                                        int time = teste2.get("time").getAsInt();
                                        String incidentType = teste2.get("incidentType").getAsString();
                                        if (("injuryTime".equals(incidentType) && time == 45) || ("period".equals(incidentType) && time == 45)) {

                                            int tempoDecorrido = 0;
                                            if (teste2.has("length")) {
                                                int length = teste2.get("length").getAsInt();
                                                tempoDecorrido = time + length;
                                            } else {
                                                tempoDecorrido = time;
                                            }


                                            for (int j = dadosEvento.size() - 1; j >= 0; j--) {
                                                JsonObject teste3 = dadosEvento.get(j).getAsJsonObject();
                                                Integer tempo = teste3.get("time").getAsInt();
                                                String cartao = teste3.get("incidentType").getAsString();

                                                if (teste3.has("player") &&
                                                        (("yellow".equals(teste3.get("incidentClass").getAsString()) && !"-5".equals(teste3.get("time").getAsString())) ||
                                                                ("yellowRed".equals(teste3.get("incidentClass").getAsString()) && !"-5".equals(teste3.get("time").getAsString())))
                                                ) {
                                                    boolean casa = teste3.get("isHome").getAsBoolean();
                                                    String teamName = casa ? homeTeam.get("name").getAsString() : awayTeam.get("name").getAsString();
                                                    String player = teste3.get("playerName").getAsString();


                                                    if ("card".equals(cartao) && teste2.get("time").getAsInt() <= tempoDecorrido && teste3.get("time").getAsInt() <= 45 && player != null) {
                                                        if (casa) {
                                                            amarelosCasaPrimeiroTempo += 1;

                                                        } else {
                                                            amarelosVisitantePrimeiroTempo += 1;

                                                        }
                                                        //  System.out.println("cartao amarelo 1 tempo: " + teamName +": " + teste3.get("playerName").getAsString() + " "  + teste3.get("time").getAsString()  + (teste3.has("addedTime") ?  " + "+ teste3.get("addedTime").getAsInt() +"'" : "'")   );
                                                    } else if ("card".equals(cartao) && teste3.get("time").getAsInt() > 45) {
                                                        if (casa) {
                                                            amarelosCasaSegundoTempo += 1;

                                                        } else {
                                                            amarelosVisitanteSegundoTempo += 1;

                                                        }
                                                        //  System.out.println("cartao amarelo 2 tempo: " + teamName + ": " + teste3.get("playerName").getAsString() + " " + teste3.get("time").getAsString() + (teste3.has("addedTime") ?  " + "+ teste3.get("addedTime").getAsInt() +"'" : "'"));
                                                    }

                                                } else if ((teste3.has("player") &&
                                                        ("red".equals(teste3.get("incidentClass").getAsString()) && !"-5".equals(teste3.get("time").getAsString())))) {
                                                    boolean casa = teste3.get("isHome").getAsBoolean();
                                                    String teamName = casa ? homeTeam.get("name").getAsString() : awayTeam.get("name").getAsString();
                                                    String player = teste3.get("playerName").getAsString();

                                                    if ("card".equals(cartao) && teste2.get("time").getAsInt() <= tempoDecorrido && teste3.get("time").getAsInt() <= 45 && player != null) {
                                                        if (casa) {
                                                            vermelhosCasaPrimeiroTempo += 1;

                                                        } else {
                                                            vermelhosVisitantePrimeioTempo += 1;

                                                        }
                                                        //  System.out.println("cartao vermelho 1 tempo: " + teamName +": " + teste3.get("playerName").getAsString() + " "  + teste3.get("time").getAsString()  + (teste3.has("addedTime") ?  " + "+ teste3.get("addedTime").getAsInt() +"'" : "'")   );
                                                    } else if ("card".equals(cartao) && teste3.get("time").getAsInt() > 45) {
                                                        if (casa) {
                                                            vermelhosCasaSegundoTempo += 1;

                                                        } else {
                                                            vermelhosVisitanteSegundoTempo += 1;

                                                        }
                                                        //System.out.println("cartao vermelho 2 tempo: " + teamName + ": " + teste3.get("playerName").getAsString() + " " + teste3.get("time").getAsString() + (teste3.has("addedTime") ?  " + "+ teste3.get("addedTime").getAsInt() +"'" : "'"));
                                                    }

                                                }


                                            }//fim do for que trata dos cartões 1Tempo e 2Tempopp

                                            break;

                                        }

                                    }//fim do if inicial para pegar o tempo decorrido do 1Tempo


                                } else {
                                    System.out.println("ERRO BUSCA: CARTÕES " + home + " - " + away);
                                }


                                // Preencha os dados do objeto `partida`
                                PartidaNovoModelo partida = new PartidaNovoModelo();

                                Time homeTime = new Time();
                                Time awayTime = new Time();

                                EstatisticaJogo ettcMatchHome = new EstatisticaJogo();
                                EstatisticaJogo ettcMatchAway = new EstatisticaJogo();

                                EstatisticaCartoes ettcCardHome = new EstatisticaCartoes();
                                EstatisticaCartoes ettcCardAway = new EstatisticaCartoes();


                                homeTime.setName(home);
                                homeTime.setImage(imageHome);
                                homeTime.setClassificacao(homeClassificacao);
                                homeTime.setPlacar(homePlacar);

                                awayTime.setName(away);
                                awayTime.setImage(imageAway);
                                awayTime.setClassificacao(awayClassificacao);
                                awayTime.setPlacar(awayPlacar);

                                ettcMatchHome.setEscanteiosPrimeiroTempo(escanteioPrimeiroTempoCasa);
                                ettcMatchHome.setEscanteioSegundoTempo(escanteioSegundoTempoCasa);
                                ettcMatchHome.setGolsPrimeiroTempo(homeScore1);
                                ettcMatchHome.setGolsSegundoTempo(homeScore2);

                                ettcMatchAway.setEscanteiosPrimeiroTempo(escanteioPrimeiroTempoFora);
                                ettcMatchAway.setEscanteioSegundoTempo(escanteioSegundoTempoFora);
                                ettcMatchAway.setGolsPrimeiroTempo(awayScore1);
                                ettcMatchAway.setGolsSegundoTempo(awayScore2);

                                ettcCardHome.setCartaoAmareloPrimeiroTempo(amarelosCasaPrimeiroTempo);
                                ettcCardHome.setCartaoAmareloSegundoTempo(amarelosCasaSegundoTempo);
                                ettcCardHome.setCartaoVermelhoPrimeiroTempo(vermelhosCasaPrimeiroTempo);
                                ettcCardHome.setCartaoVermelhoSegundoTempo(vermelhosCasaSegundoTempo);

                                ettcCardAway.setCartaoAmareloPrimeiroTempo(amarelosVisitantePrimeiroTempo);
                                ettcCardAway.setCartaoAmareloSegundoTempo(amarelosVisitanteSegundoTempo);
                                ettcCardAway.setCartaoVermelhoPrimeiroTempo(vermelhosVisitantePrimeioTempo);
                                ettcCardAway.setCartaoVermelhoSegundoTempo(vermelhosVisitanteSegundoTempo);

                                // Definindo descrição, rodada e data
                                partida.setDescription(nomeTorneio);
                                partida.setRound(roundInfo);
                                partida.setDate(formattedDate);

                                // Adicionando os times
                                partida.setHomeTime(homeTime);
                                partida.setAwayTime(awayTime);

                                // Adicionando estatísticas dos jogos
                                partida.setHomeEstatisticaJogo(ettcMatchHome);
                                partida.setAwayEstatisticaJogo(ettcMatchAway);

                                // Adicionando estatísticas dos cartões
                                partida.setHomeCartoes(ettcCardHome);
                                partida.setAwayCartoes(ettcCardAway);

                                allMatchTeam.add(partida);
                            }

                        }//fim do for para coletar os dados

                    } else {
                        System.err.println("Falha na requisição: Código " + response.code());
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                    System.err.println("Erro durante a execução da requisição: " + e.getMessage());
                }

                //  Log.d("Serie A Italia: ", "1 : " + allMatchTeam);

            }



            Log.d("Finalizado", "toda a busca");

        });


    }

    private static String obterImageData(String time) {
        String imagem = null;

        switch (time) {
            case "Atalanta":
                imagem = TimesSerie_A_Italia_2024_25.ATALANTA.getImagem();
                break;
            case "Bologna":
                imagem = TimesSerie_A_Italia_2024_25.BOLOGNA.getImagem();
                break;
            case "Cagliari":
                imagem = TimesSerie_A_Italia_2024_25.CAGLIARI.getImagem();
                break;
            case "Como":
                imagem = TimesSerie_A_Italia_2024_25.COMO.getImagem();
                break;
            case "Empoli":
                imagem = TimesSerie_A_Italia_2024_25.EMPOLI.getImagem();
                break;
            case "Fiorentina":
                imagem = TimesSerie_A_Italia_2024_25.FIORENTINA.getImagem();
                break;
            case "Genoa":
                imagem = TimesSerie_A_Italia_2024_25.GENOA.getImagem();
                break;
            case "Inter":
                imagem = TimesSerie_A_Italia_2024_25.INTER.getImagem();
                break;
            case "Juventus":
                imagem = TimesSerie_A_Italia_2024_25.JUVENTUS.getImagem();
                break;
            case "Lazio":
                imagem = TimesSerie_A_Italia_2024_25.LAZIO.getImagem();
                break;
            case "Lecce":
                imagem = TimesSerie_A_Italia_2024_25.LECCE.getImagem();
                break;
            case "Milan":
                imagem = TimesSerie_A_Italia_2024_25.MILAN.getImagem();
                break;
            case "Monza":
                imagem = TimesSerie_A_Italia_2024_25.MONZA.getImagem();
                break;
            case "Napoli":
                imagem = TimesSerie_A_Italia_2024_25.NAPOLI.getImagem();
                break;
            case "Parma":
                imagem = TimesSerie_A_Italia_2024_25.PARMA.getImagem();
                break;
            case "Roma":
                imagem = TimesSerie_A_Italia_2024_25.ROMA.getImagem();
                break;
            case "Torino":
                imagem = TimesSerie_A_Italia_2024_25.TORINO.getImagem();
                break;
            case "Udinese":
                imagem = TimesSerie_A_Italia_2024_25.UDINESE.getImagem();
                break;
            case "Venezia":
                imagem = TimesSerie_A_Italia_2024_25.VENEZIA.getImagem();
                break;
            case "Verona":
                imagem = TimesSerie_A_Italia_2024_25.VERONA.getImagem();
                break;
            default:
                return imagem = null; // Retorna null para imagem
        }

        return imagem; // Retorna um array com o nome e a imagem

    }

}
