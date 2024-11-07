package com.jogos.dadosoficialkf228920.fragments.americadosul.argentina.util;

import android.util.Log;

import com.jogos.dadosoficialkf228920.data.brasil.serieA.jogos_campeonatos_chamada_api;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JogosSerieA2024  {

    private JogosSerieAListener listener;
    private jogos_campeonatos_chamada_api jogosSerieACasaEFora2024Api;


    private List<PartidaNovoModelo> atleticoPRCasa = new ArrayList<>();
    private List<PartidaNovoModelo> atleticoPRFora = new ArrayList<>();

    private List<PartidaNovoModelo> atleticoGOCasa = new ArrayList<>();
    private List<PartidaNovoModelo> atleticoGOFora = new ArrayList<>();

    private List<PartidaNovoModelo> atleticoMGCasa = new ArrayList<>();
    private List<PartidaNovoModelo> atleticoMGFora = new ArrayList<>();

    private List<PartidaNovoModelo> bahiaCasa = new ArrayList<>();
    private List<PartidaNovoModelo> bahiaFora = new ArrayList<>();

    private List<PartidaNovoModelo> botafogoCasa = new ArrayList<>();
    private List<PartidaNovoModelo> botafogoFora = new ArrayList<>();

    private List<PartidaNovoModelo> bragantinoCasa = new ArrayList<>();
    private List<PartidaNovoModelo> bragantinoFora = new ArrayList<>();

    private List<PartidaNovoModelo> corinthiansCasa = new ArrayList<>();
    private List<PartidaNovoModelo> corinthiansFora = new ArrayList<>();

    private List<PartidaNovoModelo> criciumaCasa = new ArrayList<>();
    private List<PartidaNovoModelo> criciumaFora = new ArrayList<>();

    private List<PartidaNovoModelo> cruzeiroCasa = new ArrayList<>();
    private List<PartidaNovoModelo> cruzeiroFora = new ArrayList<>();

    private List<PartidaNovoModelo> cuiabaCasa = new ArrayList<>();
    private List<PartidaNovoModelo> cuiabaFora = new ArrayList<>();

    private List<PartidaNovoModelo> flamengoCasa = new ArrayList<>();
    private List<PartidaNovoModelo> flamengoFora = new ArrayList<>();

    private List<PartidaNovoModelo> fluminenseCasa = new ArrayList<>();
    private List<PartidaNovoModelo> fluminenseFora = new ArrayList<>();

    private List<PartidaNovoModelo> fortalezaCasa = new ArrayList<>();
    private List<PartidaNovoModelo> fortalezaFora = new ArrayList<>();

    private List<PartidaNovoModelo> gremioCasa = new ArrayList<>();
    private List<PartidaNovoModelo> gremioFora = new ArrayList<>();
    private List<PartidaNovoModelo> internacionalCasa = new ArrayList<>();
    private List<PartidaNovoModelo> internacionalFora = new ArrayList<>();

    private List<PartidaNovoModelo> juventudeCasa = new ArrayList<>();
    private List<PartidaNovoModelo> juventudeFora = new ArrayList<>();

    private List<PartidaNovoModelo> palmeirasCasa = new ArrayList<>();
    private List<PartidaNovoModelo> palmeirasFora = new ArrayList<>();
    private List<PartidaNovoModelo> saoPauloCasa = new ArrayList<>();
    private List<PartidaNovoModelo> saoPauloFora = new ArrayList<>();

    private List<PartidaNovoModelo> vascoCasa = new ArrayList<>();
    private List<PartidaNovoModelo> vascoFora = new ArrayList<>();

    private List<PartidaNovoModelo> vitoriaCasa = new ArrayList<>();
    private List<PartidaNovoModelo> vitoriaFora = new ArrayList<>();




    public void setListener(JogosSerieAListener listener) {
        this.listener = listener;
    }



    public JogosSerieA2024() {
    }

    public void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/brasil-2024/serie-a/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jogosSerieACasaEFora2024Api = retrofit.create(jogos_campeonatos_chamada_api.class);
    }

    public void setupDadosJogos() {
        jogosSerieACasaEFora2024Api.getSerieA().enqueue(new Callback<List<PartidaNovoModelo>>() {
         @Override
         public void onResponse(Call<List<PartidaNovoModelo>> call, Response<List<PartidaNovoModelo>> response) {

             List<PartidaNovoModelo> partidas = response.body();
             Log.i("Entrou", "JogosSerieA" + partidas);

             //Esse código abaixo, divido as partidas em CASA e fora de cada time

             //Aqui abaixo está a divisão de jogos casa e fora

             for (PartidaNovoModelo partida : partidas) {

                 if (partida.getHomeTime().getName().equals("Atlético-PR")) {
                     partida.setDataFormatada(partida.getDate());
                     atleticoPRCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("Atlético-PR")) {
                     partida.setDataFormatada(partida.getDate());
                     atleticoPRFora.add(partida);
                     //Log.i("Data" ,"Data da partida " + partida.getDate());
                     //Log.i("Partida", "partida arsenal fora " + partida.getDataFormatada());
                 }

                 if (partida.getHomeTime().getName().equals("Atlético-GO")) {
                     partida.setDataFormatada(partida.getDate());
                     atleticoGOCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("Atlético-GO")) {
                     partida.setDataFormatada(partida.getDate());
                     atleticoGOFora.add(partida);
                 }

                 if (partida.getHomeTime().getName().equals("Atlético-MG")) {
                     partida.setDataFormatada(partida.getDate());
                     atleticoMGCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("Atlético-MG")) {
                     partida.setDataFormatada(partida.getDate());
                     atleticoMGFora.add(partida);
                 }

                 if (partida.getHomeTime().getName().equals("Bahia")) {
                     partida.setDataFormatada(partida.getDate());
                     bahiaCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("Bahia")) {
                     partida.setDataFormatada(partida.getDate());
                     bahiaFora.add(partida);
                 }

                 if (partida.getHomeTime().getName().equals("Botafogo")) {
                     partida.setDataFormatada(partida.getDate());
                     botafogoCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("Botafogo")) {
                     partida.setDataFormatada(partida.getDate());
                     botafogoFora.add(partida);
                 }

                 if (partida.getHomeTime().getName().equals("Bragantino")) {
                     partida.setDataFormatada(partida.getDate());
                     bragantinoCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("Bragantino")) {
                     partida.setDataFormatada(partida.getDate());
                     bragantinoFora.add(partida);
                 }

                 if (partida.getHomeTime().getName().equals("Corinthians")) {
                     partida.setDataFormatada(partida.getDate());
                     corinthiansCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("Corinthians")) {
                     partida.setDataFormatada(partida.getDate());
                     corinthiansFora.add(partida);
                 }

                 if (partida.getHomeTime().getName().equals("Criciúma")) {
                     partida.setDataFormatada(partida.getDate());
                     criciumaCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("Criciúma")) {
                     partida.setDataFormatada(partida.getDate());
                     criciumaFora.add(partida);
                 }

                 if (partida.getHomeTime().getName().equals("Cruzeiro")) {
                     partida.setDataFormatada(partida.getDate());
                     cruzeiroCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("Cruzeiro")) {
                     partida.setDataFormatada(partida.getDate());
                     cruzeiroFora.add(partida);
                 }

                 if (partida.getHomeTime().getName().equals("Cuiabá")) {
                     partida.setDataFormatada(partida.getDate());
                     cuiabaCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("Cuiabá")) {
                     partida.setDataFormatada(partida.getDate());
                     cuiabaFora.add(partida);
                 }

                 if (partida.getHomeTime().getName().equals("Flamengo")) {
                     partida.setDataFormatada(partida.getDate());
                     flamengoCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("Flamengo")) {
                     partida.setDataFormatada(partida.getDate());
                     flamengoFora.add(partida);
                 }

                 if (partida.getHomeTime().getName().equals("Fluminense")) {
                     partida.setDataFormatada(partida.getDate());
                     fluminenseCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("Fluminense")) {
                     partida.setDataFormatada(partida.getDate());
                     fluminenseFora.add(partida);
                 }

                 if (partida.getHomeTime().getName().equals("Fortaleza")) {
                     partida.setDataFormatada(partida.getDate());
                     fortalezaCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("Fortaleza")) {
                     partida.setDataFormatada(partida.getDate());
                     fortalezaFora.add(partida);
                 }

                 if (partida.getHomeTime().getName().equals("Grêmio")) {
                     partida.setDataFormatada(partida.getDate());
                     gremioCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("Grêmio")) {
                     partida.setDataFormatada(partida.getDate());
                     gremioFora.add(partida);
                 }

                 if (partida.getHomeTime().getName().equals("Internacional")) {
                     partida.setDataFormatada(partida.getDate());
                     internacionalCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("Internacional")) {
                     partida.setDataFormatada(partida.getDate());
                     internacionalFora.add(partida);
                 }

                 if (partida.getHomeTime().getName().equals("Juventude")) {
                     partida.setDataFormatada(partida.getDate());
                     juventudeCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("Juventude")) {
                     partida.setDataFormatada(partida.getDate());
                     juventudeFora.add(partida);
                 }

                 if (partida.getHomeTime().getName().equals("Palmeiras")) {
                     partida.setDataFormatada(partida.getDate());
                     palmeirasCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("Palmeiras")) {
                     partida.setDataFormatada(partida.getDate());
                     palmeirasFora.add(partida);
                 }

                 if (partida.getHomeTime().getName().equals("São-Paulo")) {
                     partida.setDataFormatada(partida.getDate());
                     saoPauloCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("São-Paulo")) {
                     partida.setDataFormatada(partida.getDate());
                     saoPauloFora.add(partida);
                 }

                 if (partida.getHomeTime().getName().equals("Vasco")) {
                     partida.setDataFormatada(partida.getDate());
                     vascoCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("Vasco")) {
                     partida.setDataFormatada(partida.getDate());
                     vascoFora.add(partida);
                 }

                 if (partida.getHomeTime().getName().equals("Vitória")) {
                     partida.setDataFormatada(partida.getDate());
                     vitoriaCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("Vitória")) {
                     partida.setDataFormatada(partida.getDate());
                     vitoriaFora.add(partida);
                 }


             }//fim do for

             //Outra, duvida, e mesmo contexto, aqui separa os jogos por casa e fora de cada time
             //E aqui tenho que passar tambem meu adapter para os fragment q carregara jogos casa ou fora
             //tenho que fazer isso também aqui? e
             //nao entendi
             //mas essa sua classe é apenas a classe que obtem os dados da internet e separa esses daods
             //apenas isso

             //se voce quer exibir esses dados em um fragmen ou em uma activit, deve fazer o codigo igual voce fez no fragment que trabalhamos.
             //Exemplo, vou criar Dois fragments do time do Gremio, 1 - casa 2 - fora




            //Aqui abaixo, agrupo os jogos de cada time, casa e fora e passo esses dados para o Listener
             //Observação: aqui a classe de modelo é diferente, pois aqui tenho todos os dados que recupero

             List<PartidaNovoModelo> atleticoPRCompleto = new ArrayList<>();
             atleticoPRCompleto.addAll(atleticoPRCasa);
             atleticoPRCompleto.addAll(atleticoPRFora);

             List<PartidaNovoModelo> atleticoGOCompleto = new ArrayList<>();
             atleticoGOCompleto.addAll(atleticoGOCasa);
             atleticoGOCompleto.addAll(atleticoGOFora);

             List<PartidaNovoModelo> atleticoMGCompleto = new ArrayList<>();
             atleticoMGCompleto.addAll(atleticoMGCasa);
             atleticoMGCompleto.addAll(atleticoMGFora);

             List<PartidaNovoModelo> bahiaCompleto = new ArrayList<>();
             bahiaCompleto.addAll(bahiaCasa);
             bahiaCompleto.addAll(bahiaFora);

             List<PartidaNovoModelo> botafogoCompleto = new ArrayList<>();
             botafogoCompleto.addAll(botafogoCasa);
             botafogoCompleto.addAll(botafogoFora);

             List<PartidaNovoModelo> bragantinoCompleto = new ArrayList<>();
             bragantinoCompleto.addAll(bragantinoCasa);
             bragantinoCompleto.addAll(bragantinoFora);

             List<PartidaNovoModelo> corinthiansCompleto = new ArrayList<>();
             corinthiansCompleto.addAll(corinthiansCasa);
             corinthiansCompleto.addAll(corinthiansFora);

             List<PartidaNovoModelo> criciumaCompleto = new ArrayList<>();
             criciumaCompleto.addAll(criciumaCasa);
             criciumaCompleto.addAll(criciumaFora);

             List<PartidaNovoModelo> cruzeiroCompleto = new ArrayList<>();
             cruzeiroCompleto.addAll(cruzeiroCasa);
             cruzeiroCompleto.addAll(cruzeiroFora);

             List<PartidaNovoModelo> cuiabaCompleto = new ArrayList<>();
             cuiabaCompleto.addAll(cuiabaCasa);
             cuiabaCompleto.addAll(cuiabaFora);

             List<PartidaNovoModelo> flamengoCompleto = new ArrayList<>();
             flamengoCompleto.addAll(flamengoCasa);
             flamengoCompleto.addAll(flamengoFora);

             List<PartidaNovoModelo> fluminenseCompleto = new ArrayList<>();
             fluminenseCompleto.addAll(fluminenseCasa);
             fluminenseCompleto.addAll(fluminenseFora);

             List<PartidaNovoModelo> fortalezaCompleto = new ArrayList<>();
             fortalezaCompleto.addAll(fortalezaCasa);
             fortalezaCompleto.addAll(fortalezaFora);

             List<PartidaNovoModelo> gremioCompleto = new ArrayList<>();
             gremioCompleto.addAll(gremioCasa);
             gremioCompleto.addAll(gremioFora);

             List<PartidaNovoModelo> internacionalCompleto = new ArrayList<>();
             internacionalCompleto.addAll(internacionalCasa);
             internacionalCompleto.addAll(internacionalFora);

             List<PartidaNovoModelo> juventudeCompleto = new ArrayList<>();
             juventudeCompleto.addAll(juventudeCasa);
             juventudeCompleto.addAll(juventudeFora);

             List<PartidaNovoModelo> palmeirasCompleto = new ArrayList<>();
             palmeirasCompleto.addAll(palmeirasCasa);
             palmeirasCompleto.addAll(palmeirasFora);

             List<PartidaNovoModelo> saoPauloCompleto = new ArrayList<>();
             saoPauloCompleto.addAll(saoPauloCasa);
             saoPauloCompleto.addAll(saoPauloFora);


             List<PartidaNovoModelo> vascoCompleto = new ArrayList<>();
             vascoCompleto.addAll(vascoCasa);
             vascoCompleto.addAll(vascoFora);

             List<PartidaNovoModelo> vitoriaCompleto = new ArrayList<>();

             //entendi que voce dividiu a variavel  vitoriaCasa vitoriaFora
             //mas esta adicionadno as duas variavel denteo da variavel vitoriaCompleto //compreendeu ?sim, aqui é onde estou utilizando na classificação a list de cada
             vitoriaCompleto.addAll(vitoriaCasa);
             vitoriaCompleto.addAll(vitoriaFora);
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
                 Log.d("teste jone" ,"2");
                 listener.onJogosSerieAReady(atleticoPRCompleto, atleticoGOCompleto,atleticoMGCompleto, bahiaCompleto, botafogoCompleto, bragantinoCompleto, corinthiansCompleto, criciumaCompleto, cruzeiroCompleto
                         , cuiabaCompleto, flamengoCompleto, fluminenseCompleto, fortalezaCompleto, gremioCompleto, internacionalCompleto,juventudeCompleto,palmeirasCompleto,saoPauloCompleto,vascoCompleto,vitoriaCompleto);
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


    private void errorBuscarDados() {
        //Snackbar.make(binding.getRoot(), "erro ao Retornar Dados Estatístico. ", Snackbar.LENGTH_LONG).show();
    }








}