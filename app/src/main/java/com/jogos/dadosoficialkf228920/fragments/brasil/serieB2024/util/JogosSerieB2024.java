package com.jogos.dadosoficialkf228920.fragments.brasil.serieB2024.util;

import android.util.Log;

import com.jogos.dadosoficialkf228920.data.brasil.serieA.jogos_campeonatos_chamada_api;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieA2024.util.JogosSerieAListener;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public  class JogosSerieB2024 {

    private JogosSerieB2024Listener listener;
    private jogos_campeonatos_chamada_api jogosSerieACasaEFora2024Api;


    private List<PartidaNovoModelo> amazonasCasa = new ArrayList<>();
    private List<PartidaNovoModelo> amazonasFora = new ArrayList<>();

    private List<PartidaNovoModelo> americaMGCasa = new ArrayList<>();
    private List<PartidaNovoModelo> americaMGFora = new ArrayList<>();

    private List<PartidaNovoModelo> avaiCasa = new ArrayList<>();
    private List<PartidaNovoModelo> avaiFora = new ArrayList<>();

    private List<PartidaNovoModelo> botafogoSPCasa = new ArrayList<>();
    private List<PartidaNovoModelo> botafogoSPFora = new ArrayList<>();

    private List<PartidaNovoModelo> brusqueCasa = new ArrayList<>();
    private List<PartidaNovoModelo> brusqueFora = new ArrayList<>();

    private List<PartidaNovoModelo> crbCasa = new ArrayList<>();
    private List<PartidaNovoModelo> crbFora = new ArrayList<>();


    private List<PartidaNovoModelo> cearaCasa = new ArrayList<>();
    private List<PartidaNovoModelo> cearaFora = new ArrayList<>();

    private List<PartidaNovoModelo> chapecoenseCasa = new ArrayList<>();
    private List<PartidaNovoModelo> chapecoenseFora = new ArrayList<>();

    private List<PartidaNovoModelo> coritibaCasa = new ArrayList<>();
    private List<PartidaNovoModelo> coritibaFora = new ArrayList<>();

    private List<PartidaNovoModelo> goiasCasa = new ArrayList<>();
    private List<PartidaNovoModelo> goiasFora = new ArrayList<>();

    private List<PartidaNovoModelo> guaraniCasa = new ArrayList<>();
    private List<PartidaNovoModelo> guaraniFora = new ArrayList<>();

    private List<PartidaNovoModelo> ituanoCasa = new ArrayList<>();
    private List<PartidaNovoModelo> ituanoFora = new ArrayList<>();

    private List<PartidaNovoModelo> mirassolCasa = new ArrayList<>();
    private List<PartidaNovoModelo> mirassolFora = new ArrayList<>();

    private List<PartidaNovoModelo> novorizontinoCasa = new ArrayList<>();
    private List<PartidaNovoModelo> novorizontinoFora = new ArrayList<>();
    private List<PartidaNovoModelo> operarioCasa = new ArrayList<>();
    private List<PartidaNovoModelo> operarioFora = new ArrayList<>();

    private List<PartidaNovoModelo> paysanduCasa = new ArrayList<>();
    private List<PartidaNovoModelo> paysanduFora = new ArrayList<>();

    private List<PartidaNovoModelo> pontepretaCasa = new ArrayList<>();
    private List<PartidaNovoModelo> pontepretaFora = new ArrayList<>();
    private List<PartidaNovoModelo> santosCasa = new ArrayList<>();
    private List<PartidaNovoModelo> santosFora = new ArrayList<>();

    private List<PartidaNovoModelo> sportCasa = new ArrayList<>();
    private List<PartidaNovoModelo> sportFora = new ArrayList<>();

    private List<PartidaNovoModelo> vilanovaCasa = new ArrayList<>();
    private List<PartidaNovoModelo> vilanovaFora = new ArrayList<>();




    public void setListener(JogosSerieB2024Listener listener) {
        this.listener = listener;
    }



    public JogosSerieB2024() {
    }

    public void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/brasil-2024/serie-b/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jogosSerieACasaEFora2024Api = retrofit.create(jogos_campeonatos_chamada_api.class);
    }

    public void setupDadosJogos() {
        jogosSerieACasaEFora2024Api.getSerieB().enqueue(new Callback<List<PartidaNovoModelo>>() {
         @Override
         public void onResponse(Call<List<PartidaNovoModelo>> call, Response<List<PartidaNovoModelo>> response) {

             List<PartidaNovoModelo> partidas = response.body();
             Log.i("Entrou", "JogosSerieB" + partidas);

             //Esse código abaixo, divido as partidas em CASA e fora de cada time

             //Aqui abaixo está a divisão de jogos casa e fora

             for (PartidaNovoModelo partida : partidas) {

                 if (partida.getHomeTime().getName().equals("Amazonas")) {
                     partida.setDataFormatada(partida.getDate());
                     amazonasCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("Amazonas")) {
                     partida.setDataFormatada(partida.getDate());
                     amazonasFora.add(partida);
                     //Log.i("Data" ,"Data da partida " + partida.getDate());
                     //Log.i("Partida", "partida arsenal fora " + partida.getDataFormatada());
                 }

                 if (partida.getHomeTime().getName().equals("América-MG")) {
                     partida.setDataFormatada(partida.getDate());
                     americaMGCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("América-MG")) {
                     partida.setDataFormatada(partida.getDate());
                     americaMGFora.add(partida);
                 }

                 if (partida.getHomeTime().getName().equals("Avaí")) {
                     partida.setDataFormatada(partida.getDate());
                     avaiCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("Avaí")) {
                     partida.setDataFormatada(partida.getDate());
                     avaiFora.add(partida);
                 }

                 if (partida.getHomeTime().getName().equals("Botafogo-SP")) {
                     partida.setDataFormatada(partida.getDate());
                     botafogoSPCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("Botafogo-SP")) {
                     partida.setDataFormatada(partida.getDate());
                     botafogoSPFora.add(partida);
                 }

                 if (partida.getHomeTime().getName().equals("Brusque")) {
                     partida.setDataFormatada(partida.getDate());
                     brusqueCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("Brusque")) {
                     partida.setDataFormatada(partida.getDate());
                     brusqueFora.add(partida);
                 }

                 if (partida.getHomeTime().getName().equals("CRB")) {
                     partida.setDataFormatada(partida.getDate());
                     crbCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("CRB")) {
                     partida.setDataFormatada(partida.getDate());
                     crbFora.add(partida);
                 }

                 if (partida.getHomeTime().getName().equals("Ceará")) {
                     partida.setDataFormatada(partida.getDate());
                     cearaCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("Ceará")) {
                     partida.setDataFormatada(partida.getDate());
                     cearaFora.add(partida);
                 }

                 if (partida.getHomeTime().getName().equals("Chapecoense")) {
                     partida.setDataFormatada(partida.getDate());
                     chapecoenseCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("Chapecoense")) {
                     partida.setDataFormatada(partida.getDate());
                     chapecoenseFora.add(partida);
                 }

                 if (partida.getHomeTime().getName().equals("Coritiba")) {
                     partida.setDataFormatada(partida.getDate());
                     coritibaCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("Coritiba")) {
                     partida.setDataFormatada(partida.getDate());
                     coritibaFora.add(partida);
                 }

                 if (partida.getHomeTime().getName().equals("Goiás")) {
                     partida.setDataFormatada(partida.getDate());
                     goiasCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("Goiás")) {
                     partida.setDataFormatada(partida.getDate());
                     goiasFora.add(partida);
                 }

                 if (partida.getHomeTime().getName().equals("Guarani")) {
                     partida.setDataFormatada(partida.getDate());
                     guaraniCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("Guarani")) {
                     partida.setDataFormatada(partida.getDate());
                     guaraniFora.add(partida);
                 }

                 if (partida.getHomeTime().getName().equals("Ituano")) {
                     partida.setDataFormatada(partida.getDate());
                     ituanoCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("Ituano")) {
                     partida.setDataFormatada(partida.getDate());
                     ituanoFora.add(partida);
                 }

                 if (partida.getHomeTime().getName().equals("Mirassol")) {
                     partida.setDataFormatada(partida.getDate());
                     mirassolCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("Mirassol")) {
                     partida.setDataFormatada(partida.getDate());
                     mirassolFora.add(partida);
                 }

                 if (partida.getHomeTime().getName().equals("Novorizontino")) {
                     partida.setDataFormatada(partida.getDate());
                     novorizontinoCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("Novorizontino")) {
                     partida.setDataFormatada(partida.getDate());
                     novorizontinoFora.add(partida);
                 }

                 if (partida.getHomeTime().getName().equals("Operário")) {
                     partida.setDataFormatada(partida.getDate());
                     operarioCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("Operário")) {
                     partida.setDataFormatada(partida.getDate());
                     operarioFora.add(partida);
                 }

                 if (partida.getHomeTime().getName().equals("Paysandu")) {
                     partida.setDataFormatada(partida.getDate());
                     paysanduCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("Paysandu")) {
                     partida.setDataFormatada(partida.getDate());
                     paysanduFora.add(partida);
                 }

                 if (partida.getHomeTime().getName().equals("Ponte Preta")) {
                     partida.setDataFormatada(partida.getDate());
                     pontepretaCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("Ponte Preta")) {
                     partida.setDataFormatada(partida.getDate());
                     pontepretaFora.add(partida);
                 }

                 if (partida.getHomeTime().getName().equals("Santos")) {
                     partida.setDataFormatada(partida.getDate());
                     santosCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("Santos")) {
                     partida.setDataFormatada(partida.getDate());
                     santosFora.add(partida);
                 }

                 if (partida.getHomeTime().getName().equals("Sport")) {
                     partida.setDataFormatada(partida.getDate());
                     sportCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("Sport")) {
                     partida.setDataFormatada(partida.getDate());
                     sportFora.add(partida);
                 }

                 if (partida.getHomeTime().getName().equals("Vila Nova")) {
                     partida.setDataFormatada(partida.getDate());
                     vilanovaCasa.add(partida);
                 }
                 if (partida.getAwayTime().getName().equals("Vila Nova")) {
                     partida.setDataFormatada(partida.getDate());
                     vilanovaFora.add(partida);
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

             List<PartidaNovoModelo> amazonasCompleto = new ArrayList<>();
             amazonasCompleto.addAll(amazonasCasa);
             amazonasCompleto.addAll(amazonasFora);

             List<PartidaNovoModelo> americaMGCompleto = new ArrayList<>();
             americaMGCompleto.addAll(americaMGCasa);
             americaMGCompleto.addAll(americaMGFora);

             List<PartidaNovoModelo> avaiCompleto = new ArrayList<>();
             avaiCompleto.addAll(avaiCasa);
             avaiCompleto.addAll(avaiFora);

             List<PartidaNovoModelo> botafogoSPCompleto = new ArrayList<>();
             botafogoSPCompleto.addAll(botafogoSPCasa);
             botafogoSPCompleto.addAll(botafogoSPFora);

             List<PartidaNovoModelo> brusqueCompleto = new ArrayList<>();
             brusqueCompleto.addAll(brusqueCasa);
             brusqueCompleto.addAll(brusqueFora);

             List<PartidaNovoModelo> crbCompleto = new ArrayList<>();
             crbCompleto.addAll(crbCasa);
             crbCompleto.addAll(crbFora);

             List<PartidaNovoModelo> cearaCompleto = new ArrayList<>();
             cearaCompleto.addAll(cearaCasa);
             cearaCompleto.addAll(cearaFora);

             List<PartidaNovoModelo> chapecoenseCompleto = new ArrayList<>();
             chapecoenseCompleto.addAll(chapecoenseCasa);
             chapecoenseCompleto.addAll(chapecoenseFora);

             List<PartidaNovoModelo> coritibaCompleto = new ArrayList<>();
             coritibaCompleto.addAll(coritibaCasa);
             coritibaCompleto.addAll(coritibaFora);

             List<PartidaNovoModelo> goiasCompleto = new ArrayList<>();
             goiasCompleto.addAll(goiasCasa);
             goiasCompleto.addAll(goiasFora);

             List<PartidaNovoModelo> guaraniCompleto = new ArrayList<>();
             guaraniCompleto.addAll(guaraniCasa);
             guaraniCompleto.addAll(guaraniFora);

             List<PartidaNovoModelo> ituanoCompleto = new ArrayList<>();
             ituanoCompleto.addAll(ituanoCasa);
             ituanoCompleto.addAll(ituanoFora);

             List<PartidaNovoModelo> mirassolCompleto = new ArrayList<>();
             mirassolCompleto.addAll(mirassolCasa);
             mirassolCompleto.addAll(mirassolFora);

             List<PartidaNovoModelo> novorizontinoCompleto = new ArrayList<>();
             novorizontinoCompleto.addAll(novorizontinoCasa);
             novorizontinoCompleto.addAll(novorizontinoFora);

             List<PartidaNovoModelo> operarioCompleto = new ArrayList<>();
             operarioCompleto.addAll(operarioCasa);
             operarioCompleto.addAll(operarioFora);

             List<PartidaNovoModelo> paysanduCompleto = new ArrayList<>();
             paysanduCompleto.addAll(paysanduCasa);
             paysanduCompleto.addAll(paysanduFora);

             List<PartidaNovoModelo> pontepretaCompleto = new ArrayList<>();
             pontepretaCompleto.addAll(pontepretaCasa);
             pontepretaCompleto.addAll(pontepretaFora);

             List<PartidaNovoModelo> santosCompleto = new ArrayList<>();
             santosCompleto.addAll(santosCasa);
             santosCompleto.addAll(santosFora);


             List<PartidaNovoModelo> sportCompleto = new ArrayList<>();
             sportCompleto.addAll(sportCasa);
             sportCompleto.addAll(sportFora);

             List<PartidaNovoModelo> vilanovaCompleto = new ArrayList<>();

             //entendi que voce dividiu a variavel  vitoriaCasa vitoriaFora
             //mas esta adicionadno as duas variavel denteo da variavel vitoriaCompleto //compreendeu ?sim, aqui é onde estou utilizando na classificação a list de cada
             vilanovaCompleto.addAll(vilanovaCasa);
             vilanovaCompleto.addAll(vilanovaFora);
             //essa variavel vitoriaCompleto possui os jogos de dentro de casa e fora de casa, correto ?na verdade eu separei

             //Aqui instanciaria o Framente passando a lista desse time, seja ele casa e fora respeinando o fragment que tem q receber?
             //voce pode fazer de varias formas
             ///mas perceba o seguinte todas as informacoes dos times do codigo acima voce esta passando pra onde ?
             //todas as informacoes do time estao indo para o listener abaixo
             //aqui o código ja esta tudo pronto
             //voce obtem todos os dados que vai precisar //jogos do vitoria dentro e fora de casa estao em qual variavel ?


             //Essa Classe dividi todos os jogos dos times, seja ele casa ou fora,
             //Passei aqui um Listener para acessar dentro do meu Frament

             if(listener != null){
                 listener.onJogosSerieBReady(amazonasCompleto,americaMGCompleto,avaiCompleto,botafogoSPCompleto,brusqueCompleto,crbCompleto,
                         cearaCompleto,chapecoenseCompleto,coritibaCompleto,goiasCompleto,guaraniCompleto,ituanoCompleto,mirassolCompleto,
                         novorizontinoCompleto,operarioCompleto,paysanduCompleto,pontepretaCompleto,santosCompleto,sportCompleto,vilanovaCompleto);
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