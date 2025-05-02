package com.jogos.dadosoficialkf228920.model.SugestaoAposta;

import android.util.Log;

import com.jogos.dadosoficialkf228920.data.brasil.serieA.Jogos_campeonatos_chamada_api;
import com.jogos.dadosoficialkf228920.model.CallbackInterface;
import com.jogos.dadosoficialkf228920.model.MatchNewModelDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SugestaoApostaIngles {

    private Jogos_campeonatos_chamada_api jogos_campeonatos_chamada_api;

    public void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/europa-a-2024-2025/premier-league/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jogos_campeonatos_chamada_api = retrofit.create(Jogos_campeonatos_chamada_api.class);
    }

    public void setupJogos(String timeCasa, String timeFora, String dataProximoJogo, CallbackInterface callback) {
        jogos_campeonatos_chamada_api.getPremierLeagueA2024_2025().enqueue(new Callback<List<MatchNewModelDate>>() {
            @Override
            public void onResponse(Call<List<MatchNewModelDate>> call, Response<List<MatchNewModelDate>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<MatchNewModelDate> todasPartidas = response.body();

                    List<MatchNewModelDate> partidasFiltradas = new ArrayList<>();
                    for (MatchNewModelDate partida : todasPartidas) {
                        if (isDataAnterior(partida.getDate(), dataProximoJogo)) {
                            partidasFiltradas.add(partida);
                        }
                    }

                    // Criando o mapa de classificação (exemplo)
                    Map<String, Integer> classificacao = obterClassificacaoTimes(todasPartidas);

                    // Chamando o método com a classificação
                    String sugestao = analisarAmbasMarcam(partidasFiltradas, timeCasa, timeFora, classificacao);
                    Log.d("Sugestao", "Aposta: " + sugestao);
                    callback.onSugestaoGerada(sugestao);
                }
            }

            @Override
            public void onFailure(Call<List<MatchNewModelDate>> call, Throwable t) {
                Log.e("ERRO", "Falha ao obter os dados.");
            }
        });
    }

    /**
     * Método para criar um mapa de classificação baseado na lista de partidas.
     */
    private Map<String, Integer> obterClassificacaoTimes(List<MatchNewModelDate> partidas) {
        Map<String, Integer> classificacao = new HashMap<>();

        for (MatchNewModelDate partida : partidas) {
            // Exemplo: suponha que o ranking esteja dentro do objeto do time
            classificacao.put(partida.getHomeTime().getName(), partida.getHomeTime().getClassificacao());
            classificacao.put(partida.getAwayTime().getName(), partida.getAwayTime().getClassificacao());
        }

        return classificacao;
    }
    private boolean isDataAnterior(String dataJogo, String dataReferencia) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        try {
            Date dateJogo = sdf.parse(dataJogo);
            Date dateReferencia = sdf.parse(dataReferencia);
            return dateJogo != null && dateJogo.before(dateReferencia);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    private String analisarJogo(List<MatchNewModelDate> partidas, String timeCasa, String timeFora) {
        int golsCasa = 0, golsSofridosCasa = 0, jogosCasa = 0;
        int golsFora = 0, golsSofridosFora = 0, jogosFora = 0;
        int vitoriasCasa = 0, empatesCasa = 0, derrotasCasa = 0;
        int vitoriasFora = 0, empatesFora = 0, derrotasFora = 0;

        double posseBolaCasa = 0, posseBolaFora = 0;
        double finalizacoesCasa = 0, finalizacoesGolCasa = 0;
        double finalizacoesFora = 0, finalizacoesGolFora = 0;

        int jogosAnalisados = 0;

        for (MatchNewModelDate partida : partidas) {
            if (partida.getHomeTime().getName().equals(timeCasa)) {
                jogosCasa++;
                jogosAnalisados++;
                golsCasa += partida.getHomeTime().getPlacar();
                golsSofridosCasa += partida.getAwayTime().getPlacar();

                posseBolaCasa += partida.getEstatisticaGeralHome().getPosseBola();
                finalizacoesCasa += partida.getEstatisticaGeralHome().getFinalizacao();
                finalizacoesGolCasa += partida.getEstatisticaGeralHome().getFinalizacaoGol();

                if (partida.getHomeTime().getPlacar() > partida.getAwayTime().getPlacar()) {
                    vitoriasCasa++;
                } else if (partida.getHomeTime().getPlacar() == partida.getAwayTime().getPlacar()) {
                    empatesCasa++;
                } else {
                    derrotasCasa++;
                }
            }

            if (partida.getAwayTime().getName().equals(timeFora)) {
                jogosFora++;
                jogosAnalisados++;
                golsFora += partida.getAwayTime().getPlacar();
                golsSofridosFora += partida.getHomeTime().getPlacar();

                posseBolaFora += partida.getEstatisticaGeralAway().getPosseBola();
                finalizacoesFora += partida.getEstatisticaGeralAway().getFinalizacao();
                finalizacoesGolFora += partida.getEstatisticaGeralAway().getFinalizacaoGol();

                if (partida.getAwayTime().getPlacar() > partida.getHomeTime().getPlacar()) {
                    vitoriasFora++;
                } else if (partida.getAwayTime().getPlacar() == partida.getHomeTime().getPlacar()) {
                    empatesFora++;
                } else {
                    derrotasFora++;
                }
            }
        }

        // Cálculo de médias
        double mediaGolsCasa = jogosCasa > 0 ? (double) golsCasa / jogosCasa : 0;
        double mediaGolsSofridosCasa = jogosCasa > 0 ? (double) golsSofridosCasa / jogosCasa : 0;
        double mediaGolsFora = jogosFora > 0 ? (double) golsFora / jogosFora : 0;
        double mediaGolsSofridosFora = jogosFora > 0 ? (double) golsSofridosFora / jogosFora : 0;

        double mediaPosseBolaCasa = jogosCasa > 0 ? posseBolaCasa / jogosCasa : 0;
        double mediaPosseBolaFora = jogosFora > 0 ? posseBolaFora / jogosFora : 0;

        double mediaFinalizacoesCasa = jogosCasa > 0 ? finalizacoesCasa / jogosCasa : 0;
        double mediaFinalizacoesGolCasa = jogosCasa > 0 ? finalizacoesGolCasa / jogosCasa : 0;
        double mediaFinalizacoesFora = jogosFora > 0 ? finalizacoesFora / jogosFora : 0;
        double mediaFinalizacoesGolFora = jogosFora > 0 ? finalizacoesGolFora / jogosFora : 0;

        Log.d("Análise", "🏟 " + timeCasa + " - Média de gols marcados em casa: " + mediaGolsCasa);
        Log.d("Análise", "🏟 " + timeCasa + " - Média de gols sofridos em casa: " + mediaGolsSofridosCasa);
        Log.d("Análise", "⚽ " + timeCasa + " - Finalizações por jogo: " + mediaFinalizacoesCasa);
        Log.d("Análise", "🎯 " + timeCasa + " - Finalizações no gol: " + mediaFinalizacoesGolCasa);
        Log.d("Análise", "🔄 " + timeCasa + " - Posse de bola: " + mediaPosseBolaCasa + "%");

        Log.d("Análise", "🏟 " + timeFora + " - Média de gols marcados fora: " + mediaGolsFora);
        Log.d("Análise", "🏟 " + timeFora + " - Média de gols sofridos fora: " + mediaGolsSofridosFora);
        Log.d("Análise", "⚽ " + timeFora + " - Finalizações por jogo: " + mediaFinalizacoesFora);
        Log.d("Análise", "🎯 " + timeFora + " - Finalizações no gol: " + mediaFinalizacoesGolFora);
        Log.d("Análise", "🔄 " + timeFora + " - Posse de bola: " + mediaPosseBolaFora + "%");

        // Definir sugestão com base nos dados coletados
        String sugestao = definirSugestaoAvancada(mediaGolsCasa, mediaGolsSofridosCasa, mediaGolsFora, mediaGolsSofridosFora,
                mediaFinalizacoesCasa, mediaFinalizacoesFora, mediaFinalizacoesGolCasa, mediaFinalizacoesGolFora,
                mediaPosseBolaCasa, mediaPosseBolaFora);

        Log.d("Sugestão", "📌 Sugestão de aposta: " + sugestao);
        return sugestao;
    }

    // Lista de times fortes previamente definidos
    private static final Set<String> TIMES_FORTES = new HashSet<>(Arrays.asList(
            "Man City", "Arsenal", "Liverpool", "Aston Villa", "Man Utd", "Tottenham"
    ));

    public String analisarAmbasMarcam(List<MatchNewModelDate> partidas, String timeCasa, String timeFora, Map<String, Integer> classificacao) {

        // Mapeamento das tendências de ambos marcam
        Map<String, Double[]> tendenciasTimes = new HashMap<>();

        int jogosCasa = 0, ambosMarcam = 0, sempreMarcaCasa = 0, sempreSofreCasa = 0;
        int jogosFora = 0, ambosMarcamFora = 0, sempreMarcaFora = 0, sempreSofreFora = 0;

        // Percorre todas as partidas para coletar estatísticas
        for (MatchNewModelDate partida : partidas) {
            if (partida.getHomeTime().getName().equals(timeCasa)) {
                jogosCasa++;
                int golsMarcados = partida.getHomeTime().getPlacar();
                int golsSofridos = partida.getAwayTime().getPlacar();

                if (golsMarcados > 0) sempreMarcaCasa++;
                if (golsSofridos > 0) sempreSofreCasa++;
                if (golsMarcados > 0 && golsSofridos > 0) ambosMarcam++;
            }

            if (partida.getAwayTime().getName().equals(timeFora)) {
                jogosFora++;
                int golsMarcadosFora = partida.getAwayTime().getPlacar();
                int golsSofridosFora = partida.getHomeTime().getPlacar();

                if (golsMarcadosFora > 0) sempreMarcaFora++;
                if (golsSofridosFora > 0) sempreSofreFora++;
                if (golsMarcadosFora > 0 && golsSofridosFora > 0) ambosMarcamFora++;
            }
        }

        if (jogosCasa == 0 && jogosFora == 0) return "Sem dados para análise.";

        // Calcula as porcentagens
        double porcentagemGolsMarcadosCasa = (jogosCasa > 0) ? Math.round((double) sempreMarcaCasa / jogosCasa * 100) : 0;
        double porcentagemGolsSofridosCasa = (jogosCasa > 0) ? Math.round((double) sempreSofreCasa / jogosCasa * 100) : 0;
        double porcentagemGolsMarcadosFora = (jogosFora > 0) ? Math.round((double) sempreMarcaFora / jogosFora * 100) : 0;
        double porcentagemGolsSofridosFora = (jogosFora > 0) ? Math.round((double) sempreSofreFora / jogosFora * 100) : 0;
        double porcentagemAmbosMarcam = (jogosCasa + jogosFora > 0) ?
                Math.round((double) (ambosMarcam + ambosMarcamFora) / (jogosCasa + jogosFora) * 100) : 0;

        // Adiciona as estatísticas no HashMap de tendências
        tendenciasTimes.put(timeCasa, new Double[]{porcentagemGolsMarcadosCasa, porcentagemGolsSofridosCasa});
        tendenciasTimes.put(timeFora, new Double[]{porcentagemGolsMarcadosFora, porcentagemGolsSofridosFora});

        Log.d("Estatísticas", String.format(
                "%s: Gol M = %.0f%%, Gol S = %.0f%%, %s: Gol M = %.0f%%, Gol S = %.0f%%, Ambos Marcam = %.0f%%",
                timeCasa, porcentagemGolsMarcadosCasa, porcentagemGolsSofridosCasa,
                timeFora, porcentagemGolsMarcadosFora, porcentagemGolsSofridosFora,
                porcentagemAmbosMarcam
        ));

        // Obtém a classificação dos times no campeonato
        int rankCasa = classificacao.getOrDefault(timeCasa, 10);
        int rankFora = classificacao.getOrDefault(timeFora, 10);

        // Definição das tendências com base nos dados
        boolean forte =
                (porcentagemAmbosMarcam >= 75 && (rankCasa <= 8 || rankFora <= 8)) ||
                        (porcentagemGolsMarcadosCasa >= 75 && porcentagemGolsSofridosFora >= 60) ||
                        (porcentagemGolsMarcadosFora >= 80 && porcentagemGolsSofridosFora >= 60);
        boolean media = (porcentagemAmbosMarcam >= 50);
        boolean pouca = !forte && !media;

        // Mapeamento textual das tendências
        Map<String, String> tendenciaMap = new HashMap<>();
        tendenciaMap.put("Forte", "Forte - tendência [ambos marcam]");
        tendenciaMap.put("Média", "Média - tendência [ambos marcam]");
        tendenciaMap.put("Pouca", "Pouca - tendência [ambos marcam]");

        // Retorna a tendência calculada
        if (forte) {
            return tendenciaMap.get("Forte");
        } else if (media) {
            return tendenciaMap.get("Média");
        } else {
            return tendenciaMap.get("Pouca");
        }
    }


    private String preverGolPrimeiroTempo(List<MatchNewModelDate> partidas, String timeCasa, String timeFora) {
        int golsPrimeiroTempoCasa = 0, jogosCasa = 0;
        int golsPrimeiroTempoFora = 0, jogosFora = 0;

        for (MatchNewModelDate partida : partidas) {
            if (partida.getHomeTime().getName().equals(timeCasa)) {
                jogosCasa++;
                golsPrimeiroTempoCasa += partida.getHomeEstatisticaJogo().getGolsPrimeiroTempo(); // Assume que getPlacar1T() retorna gols no 1º tempo
            }

            if (partida.getAwayTime().getName().equals(timeFora)) {
                jogosFora++;
                golsPrimeiroTempoFora += partida.getAwayEstatisticaJogo().getGolsPrimeiroTempo();
            }
        }

        double mediaGolsPrimeiroTempoCasa = jogosCasa > 0 ? (double) golsPrimeiroTempoCasa / jogosCasa : 0;
        double mediaGolsPrimeiroTempoFora = jogosFora > 0 ? (double) golsPrimeiroTempoFora / jogosFora : 0;

        Log.d("Análise", "⚽ Média de gols no 1º tempo - " + timeCasa + ": " + mediaGolsPrimeiroTempoCasa);
        Log.d("Análise", "⚽ Média de gols no 1º tempo - " + timeFora + ": " + mediaGolsPrimeiroTempoFora);

        if (mediaGolsPrimeiroTempoCasa > 0.8 && mediaGolsPrimeiroTempoFora > 0.8) {
            return "Aposta recomendada: Gol no primeiro tempo";
        } else if (mediaGolsPrimeiroTempoCasa > 0.5 || mediaGolsPrimeiroTempoFora > 0.5) {
            return "Aposta recomendada: Boa chance de gol no primeiro tempo";
        } else {
            return "Aposta recomendada: Jogo pode ser truncado no primeiro tempo";
        }
    }


    // Método para definir a sugestão baseada em critérios
    private String definirSugestaoAvancada(double golsCasa, double golsSofridosCasa, double golsFora, double golsSofridosFora,
                                           double finalizacoesCasa, double finalizacoesFora, double finalizacoesGolCasa, double finalizacoesGolFora,
                                           double posseBolaCasa, double posseBolaFora) {
        if (golsCasa > 1.5 && golsFora > 1.5) {
            return "Aposta recomendada: +2.5 gols na partida";
        } else if (finalizacoesGolCasa > 5 && finalizacoesGolFora > 5) {
            return "Aposta recomendada: Ambas equipes marcam (Sim)";
        } else if (posseBolaCasa > 55 && finalizacoesCasa > 10) {
            return "Aposta recomendada: Vitória do mandante";
        } else {
            return "Aposta recomendada: Jogo equilibrado, evite apostas arriscadas";
        }
        }
}